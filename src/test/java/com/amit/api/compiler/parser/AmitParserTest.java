package com.amit.api.compiler.parser;

import static org.junit.Assert.*;

import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Paths;

import org.junit.Test;

import com.amit.api.compiler.model.Module;
import com.amit.api.compiler.model.TypeEnum;

public class AmitParserTest {

			
	@Test
	public void testEnumInt() throws Exception {
		AmitParser parser = AmitParser.fromFile( path( "enum-int.amit" ) );
		Module module = parser.parse();
		
		assertEquals( 1, module.getEnums().size() );
		
		TypeEnum e = module.getEnums().get( 0 );
		assertEquals( "NumberEnum", e.getName() );
		
		assertEquals( 3, e.getValues().size() );
		assertEquals( "first", e.getValues().get( 0 ).getName() );
		assertEquals( "second", e.getValues().get( 1 ).getName() );
		assertEquals( "forth", e.getValues().get( 2 ).getName() );
		assertEquals( new Integer(1), e.getValues().get( 0 ).getIntegerValue() );
		assertEquals( new Integer(2), e.getValues().get( 1 ).getIntegerValue() );
		assertEquals( new Integer(4), e.getValues().get( 2 ).getIntegerValue() );
	}

	@Test
	public void testEnumString() throws Exception {
		AmitParser parser = AmitParser.fromFile( path( "enum-string.amit" ) );
		Module module = parser.parse();
		
		assertEquals( 1, module.getEnums().size() );
		
		TypeEnum e = module.getEnums().get( 0 );
		assertEquals( "StringEnum", e.getName() );
		
		assertEquals( 3, e.getValues().size() );
		assertEquals( "first", e.getValues().get( 0 ).getName() );
		assertEquals( "second", e.getValues().get( 1 ).getName() );
		assertEquals( "forth", e.getValues().get( 2 ).getName() );
		assertEquals( "1\"\\2", e.getValues().get( 0 ).getStringValue() );
		assertEquals( "2", e.getValues().get( 1 ).getStringValue() );
		assertEquals( "4", e.getValues().get( 2 ).getStringValue() );
	}
	
	
	private String path( String name ) throws URISyntaxException {
		URL resourceUrl = getClass().getResource("/parser/" + name );
		return Paths.get( resourceUrl.toURI() ).toString();

	}
}
