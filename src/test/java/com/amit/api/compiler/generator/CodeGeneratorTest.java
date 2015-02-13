package com.amit.api.compiler.generator;

import static org.junit.Assert.*;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Paths;

import org.antlr.runtime.RecognitionException;
import org.junit.Test;

import com.amit.api.compiler.model.Project;
import com.amit.api.compiler.parser.AmitParser;

import freemarker.template.TemplateException;

public class CodeGeneratorTest {

	@Test
	public void test() throws URISyntaxException, IllegalArgumentException, IOException, RecognitionException, TemplateException {		
		AmitParser parser = AmitParser.fromFile( path( "parser/customtype/type-with-base.amit" ) );
		Project project = parser.parse();

		CodeGenerator generator = new CodeGenerator( project, path( "generate/test1"), path( "generate/out" ) );
		
		generator.generate();
		
	}

	private String path( String name ) throws URISyntaxException {
		URL resourceUrl = getClass().getResource("/" + name );
		return Paths.get( resourceUrl.toURI() ).toString();

	}	
}