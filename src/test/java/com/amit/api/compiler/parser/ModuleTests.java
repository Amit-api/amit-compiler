package com.amit.api.compiler.parser;

import static org.junit.Assert.*;

import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Paths;

import org.junit.Test;

import com.amit.api.compiler.model.Module;
import com.amit.api.compiler.model.Project;

public class ModuleTests {

	@Test
	public void tesProjecttAttributes() throws Exception {
		AmitParser parser = AmitParser.fromFile( path( "project-attr.amit" ) );
		Project project = parser.parse();
		
		Module module = project.getProjectModule();
		
		assertNotNull( module );
		assertEquals( "attributes", module.getName() );
		assertEquals( "who cares", module.getAttributeValue( "csharp_package" ) );
		assertEquals( "com.project.au", module.getAttributeValue( "java_package" ) );
	}
	
	private String path( String name ) throws URISyntaxException {
		URL resourceUrl = getClass().getResource("/parser/module/" + name );
		return Paths.get( resourceUrl.toURI() ).toString();

	}	
}
