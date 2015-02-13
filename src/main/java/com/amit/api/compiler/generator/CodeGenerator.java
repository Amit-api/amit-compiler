package com.amit.api.compiler.generator;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.amit.api.compiler.model.CompositeType;
import com.amit.api.compiler.model.Project;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;

public class CodeGenerator {
	private String outputPath;
	private Project project;
	private Configuration cfg;
	
	public CodeGenerator( Project project, String templatePath, String outputPath ) throws IOException {
		this.outputPath = outputPath;
		this.project = project;

		cfg = new Configuration( Configuration.VERSION_2_3_21 );

		cfg.setDirectoryForTemplateLoading( new File( templatePath ) );
		cfg.setDefaultEncoding("UTF-8");

		cfg.setTemplateExceptionHandler( TemplateExceptionHandler.RETHROW_HANDLER );		
	}
	
	public void generate(  ) throws IOException, TemplateException {
		process( null, "start.ftl", "start.out" );
	}

	public class Runtime {
		public List<String> processTemplate( String entity, String templateName, String outFile ) throws IOException, TemplateException {
			List<String> ret = new ArrayList<String>();
			if( entity.equals( "types") ) {
				processTypes( ret, templateName, outFile );
			}
			return ret;
		}
		
		private void processTypes( List<String> ret, String templateName, String outFile ) throws IOException, TemplateException {
			for( CompositeType type : project.getCompositeTypes() ) {
				String fileName = String.format( outFile, type.getName() );
				process( type, templateName, fileName );
				ret.add( String.format( "type: %s, file: %s", type.getName(), fileName ) );
			}
		}
	}
	
	public void process( Object obj, String templateFileName, String outFileName ) throws IOException, TemplateException {
		Template template = cfg.getTemplate( templateFileName );

		Map<String, Object> root = new HashMap<String, Object>();		
		root.put( "project", project );
		root.put( "runtime", new Runtime() );
		root.put( "object", obj );
		
		Writer out = null;
		try {
			out = new PrintWriter( Paths.get( outputPath , outFileName ).toString(), "UTF-8" );
			template.process( root, out );
			out.flush();
		} finally {
			if( out != null ) {
				out.close();
			}
		}
	}
}
