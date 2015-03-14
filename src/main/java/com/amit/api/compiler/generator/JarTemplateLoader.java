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

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;

import freemarker.cache.TemplateLoader;

/**
 * the Template loader from jar, used for freemarker
 */
public class JarTemplateLoader implements TemplateLoader {
	private ClassLoader classLoader;
	private String path;
	
	public JarTemplateLoader( String classPath, String path ) throws Exception {
		
		classLoader = Class.forName( classPath ).getClassLoader();
		this.path = path;
	}
	
	@Override
	public Object findTemplateSource(String name) throws IOException {
		String rpath = path + "/" + name;		
		return classLoader.getResourceAsStream( rpath );
	}

	@Override
	public long getLastModified(Object templateSource) {
		return -1;
	}

	@Override
	public Reader getReader(Object templateSource, String encoding)
			throws IOException {
		InputStream stream = (InputStream)templateSource;

		return new InputStreamReader( stream, Charset.forName( encoding ) );
	}

	@Override
	public void closeTemplateSource(Object templateSource) throws IOException {
		InputStream stream = (InputStream)templateSource;
		stream.close();
	}
}
