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
package com.amit.api.compiler.parser;

import static org.junit.Assert.*;

import java.net.URISyntaxException;
import org.junit.Test;

import com.amit.api.compiler.model.TypeComposite;
import com.amit.api.compiler.model.TypeCompositeMember;
import com.amit.api.compiler.model.Project;

public class CustomTypesTest extends TestBase {

	@Test
	public void testSimple() throws Exception {
		AmitParser parser = AmitParser.fromFile( path( "type-simple.amit" ) );
		Project project = parser.parse();
		
		assertEquals( 1, project.getCompositeTypes().size() );
		TypeComposite type = project.getCompositeTypes().get( 0 );
		
		assertEquals( "Point", type.getName() );
		assertNull( type.getBaseType() );
		
		assertEquals( 2, type.getMembers().size() );
		
		TypeCompositeMember m = type.getMembers().get( 0 );
		assertEquals( "int", m.getTypeName() );
		assertEquals( "x", m.getName() );
		
		m = type.getMembers().get( 1 );
		assertEquals( "int", m.getTypeName() );
		assertEquals( "y", m.getName() );
	}

	@Test
	public void testBaseType() throws Exception {
		AmitParser parser = AmitParser.fromFile( path( "type-with-base.amit" ) );
		Project project = parser.parse();
		
		assertEquals( 2, project.getCompositeTypes().size() );
		TypeComposite type = project.getCompositeTypes().get( 0 );
		
		assertEquals( "T1", type.getName() );
		assertNull( type.getBaseType() );

		type = project.getCompositeTypes().get( 1 );
		
		assertEquals( "T2", type.getName() );
		assertEquals( "T1",type.getBaseType() );		
	}

	@Test
	public void testArgumentModifiers() throws Exception {
		AmitParser parser = AmitParser.fromFile( path( "type-member-modifiers.amit" ) );
		Project project = parser.parse();
		
		assertEquals( 1, project.getCompositeTypes().size() );
		TypeComposite type = project.getCompositeTypes().get( 0 );
		
		assertEquals( "Modfiers", type.getName() );
		assertNull( type.getBaseType() );

		assertEquals( 3, type.getMembers().size() );
		
		TypeCompositeMember member = type.getMembers().get( 0 );
		assertEquals( "a", member.getName() );
		assertEquals( "int", member.getTypeName() );
		assertFalse( member.isArray() );
		assertTrue( member.isRequired() );
		
		member = type.getMembers().get( 1 );
		assertEquals( "b", member.getName() );
		assertEquals( "int", member.getTypeName() );
		assertFalse( member.isArray() );
		assertFalse( member.isRequired() );

		member = type.getMembers().get( 2 );
		assertEquals( "c", member.getName() );
		assertEquals( "string", member.getTypeName() );
		assertTrue( member.isArray() );
		assertFalse( member.isRequired() );
	}
	
	private String path( String name ) throws URISyntaxException {
		return pathGlobal( "parser/customtype/" + name );
	}
}
