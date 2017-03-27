/******************************************************************************
 * Copyright 20014-2015 Alexandru Motriuc                                     *
 *                                                                            *
 ******************************************************************************
 * Licensed under the Apache License, Version 2.0 (the "License");            *
 * you may not use this file except in compliance with the License.           *
 * You may obtain a copy of the License at                                    *
 * http://www.apache.org/licenses/LICENSE-2.0                                 *
 * Unless required by applicable law or agreed to in writing, software        *
 * distributed under the License is distributed on an "AS IS" BASIS,          *
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.   *
 * See the License for the specific language governing permissions and        *
 * limitations under the License.                                             *
 ******************************************************************************/
package com.amit.api.compiler.generator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.amit.api.compiler.model.Project;
import com.amit.api.compiler.model.ProjectElement;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;

public class CodeGenerator {
	private String outputPath;
	private Project project;
	private Configuration cfg;

	public CodeGenerator(Project project, String templatePath, String outputPath)
			throws Exception {
		this(project, null, templatePath, outputPath);
	}

	public CodeGenerator(Project project, String jarClass, String templatePath,
			String outputPath) throws Exception {
		this.outputPath = outputPath;
		this.project = project;

		cfg = new Configuration(Configuration.VERSION_2_3_21);

		if (jarClass != null) {
			cfg.setTemplateLoader(new JarTemplateLoader(jarClass, templatePath));
		} else {
			cfg.setDirectoryForTemplateLoading(new File(templatePath));
		}

		cfg.setDefaultEncoding("UTF-8");

		cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
	}

	public void generate() throws IOException, TemplateException {
		for(File file: Paths.get(outputPath).toFile().listFiles()) 
		    if (!file.isDirectory()) 
		        file.delete();
		
		process(null, "start.ftl", "start.out");
	}

	public void process(Object obj, String templateFileName, String outFileName)
			throws IOException, TemplateException {
		Template template = cfg.getTemplate(templateFileName);

		Map<String, Object> root = createObjects(obj);

		Writer out = null;
		try {
			out = createWrite(outFileName);
			template.process(root, out);
			out.flush();
		} finally {
			if (out != null) {
				out.close();
			}
		}
	}

	private Writer createWrite(String outFileName)
			throws FileNotFoundException, UnsupportedEncodingException {
		Path filePath = Paths.get(outputPath, outFileName);
		filePath.toFile().getParentFile().mkdirs();
		return new PrintWriter(filePath.toString(), "UTF-8");
	}

	private Map<String, Object> createObjects(Object obj) {
		Map<String, Object> root = new HashMap<String, Object>();
		root.put("project", project);
		root.put("amit", new Runtime());
		root.put("object", obj);

		return root;
	}

	/**
	 * generator runtime
	 */
	public class Runtime {
		public List<String> generate(String entity, String templateName,
				String outFile) throws IOException, TemplateException {
			List<String> ret = new ArrayList<String>();

			if (entity.equals("type")) {
				generate(project.getCompositeTypes(), templateName, outFile,
						ret);
			} else if (entity.equals("interface")) {
				generate(project.getInterfaces(), templateName, outFile, ret);
			} else if (entity.equals("enum")) {
				generate(project.getEnums(), templateName, outFile, ret);
			} else if (entity.equals("service")) {
				generate(project.getServices(), templateName, outFile, ret);
			} else if (entity.equals("exception")) {
				generate(project.getExceptions(), templateName, outFile, ret);
			} else if (entity.equals("project")) {
				process(null, templateName, outFile);
				ret.add(outFile);
			} else {
				throw new IllegalArgumentException(String.format(
						"unknown %s entity", entity));
			}
			return ret;
		}

		public String toPath(String value, String separator) {
			String values[] = value.split(separator);
			return Paths.get("", values).toString();
		}

		private void generate(List<? extends ProjectElement> elements,
				String templateName, String outFile, List<String> ret)
				throws IOException, TemplateException {
			for (ProjectElement element : elements) {
				String fileName = String.format(outFile, element.getName());
				process(element, templateName, fileName);
				ret.add(String.format("generated: %s, file: %s",
						element.getName(), fileName));
			}
		}
	}
}
