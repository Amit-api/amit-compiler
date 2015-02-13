package com.amit.api.compiler.parser;

import static org.junit.Assert.*;

import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Paths;

import org.junit.Test;

import com.amit.api.compiler.model.CompositeType;
import com.amit.api.compiler.model.CompositeTypeMember;
import com.amit.api.compiler.model.Project;

public class CustomTypesTests {

	@Test
	public void testSimple() throws Exception {
		AmitParser parser = AmitParser.fromFile( path( "type-simple.amit" ) );
		Project project = parser.parse();
		
		assertEquals( 1, project.getCompositeTypes().size() );
		CompositeType type = project.getCompositeTypes().get( 0 );
		
		assertEquals( "Point", type.getName() );
		assertNull( type.getBaseType() );
		
		assertEquals( 2, type.getMembers().size() );
		
		CompositeTypeMember m = type.getMembers().get( 0 );
		assertEquals( "int", m.getType() );
		assertEquals( "x", m.getName() );
		
		m = type.getMembers().get( 1 );
		assertEquals( "int", m.getType() );
		assertEquals( "y", m.getName() );
	}

	@Test
	public void testBaseType() throws Exception {
		AmitParser parser = AmitParser.fromFile( path( "type-with-base.amit" ) );
		Project project = parser.parse();
		
		assertEquals( 2, project.getCompositeTypes().size() );
		CompositeType type = project.getCompositeTypes().get( 0 );
		
		assertEquals( "T1", type.getName() );
		assertNull( type.getBaseType() );

		type = project.getCompositeTypes().get( 1 );
		
		assertEquals( "T2", type.getName() );
		assertEquals( "T1",type.getBaseType() );		
	}

	private String path( String name ) throws URISyntaxException {
		URL resourceUrl = getClass().getResource("/parser/customtype/" + name );
		return Paths.get( resourceUrl.toURI() ).toString();

	}	
}
