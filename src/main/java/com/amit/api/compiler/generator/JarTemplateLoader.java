package com.amit.api.compiler.generator;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;

import freemarker.cache.TemplateLoader;

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
	}

}
