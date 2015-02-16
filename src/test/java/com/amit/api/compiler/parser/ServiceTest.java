package com.amit.api.compiler.parser;

import static org.junit.Assert.*;

import java.net.URISyntaxException;

import org.junit.Test;

import com.amit.api.compiler.model.Project;
import com.amit.api.compiler.model.Service;

public class ServiceTest extends TestBase {

	@Test
	public void testSimple() throws Exception {
		AmitParser parser = AmitParser.fromFile( path( "service-simple.amit" ) );
		Project project = parser.parse();
		
		assertEquals( 1, project.getServices().size() );
	
		Service service = project.getServices().get( 0 );
		assertEquals( "MyService", service.getName() );
		assertEquals( "/hello/me", service.getAttributeValue( "path" ) );
		assertEquals( 2, service.getBaseInterfaceNames().size() );
		assertEquals( "I1", service.getBaseInterfaceNames().get( 0 ) );
		assertEquals( "I2", service.getBaseInterfaceNames().get( 1 ) );
	}
	
	private String path( String name ) throws URISyntaxException {
		return pathGlobal( "parser/service/" + name );
	}
}
