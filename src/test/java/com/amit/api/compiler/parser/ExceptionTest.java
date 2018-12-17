/******************************************************************************
 * Copyright 2014-2018 Alexandru Motriuc                                     *
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

import com.amit.api.compiler.model.Project;
import com.amit.api.compiler.model.TypeCompositeMember;
import com.amit.api.compiler.model.TypeException;

public class ExceptionTest extends TestBase {

	@Test
	public void testSimple() throws Exception {
		AmitParser parser = AmitParser.fromFile( path( "except-simple.amit" ) );
		Project project = parser.parse();
		
		assertEquals( 1, project.getExceptions().size() );
		
		TypeException except = project.getExceptions().get( 0 );
		
		assertEquals( "InvalidArgException", except.getName() );
		assertEquals( "exception", except.getType() );
		assertEquals( 2, except.getMembers().size() );
		assertNull( except.getBaseTypeName() );
		
		TypeCompositeMember member = except.getMembers().get( 0 );
		assertEquals( "argumentName", member.getName() );
		assertEquals( "string", member.getTypeName() );
		assertFalse( member.isArray() );
		
		member = except.getMembers().get( 1 );
		assertEquals( "argumentType", member.getName() );
		assertEquals( "int", member.getTypeName() );
		assertFalse( member.isArray() );
	}

	@Test
	public void testWithBase() throws Exception {
		AmitParser parser = AmitParser.fromFile( path( "except-with-base.amit" ) );
		Project project = parser.parse();

		assertEquals( 2, project.getExceptions().size() );
		
		TypeException except = project.getExceptions().get( 0 );
		
		assertEquals( "BaseException", except.getName() );
		assertEquals( "exception", except.getType() );
		assertNull( except.getBaseTypeName() );

		except = project.getExceptions().get( 1 );
		assertEquals( "DerivedException", except.getName() );
		assertEquals( "exception", except.getType() );
		assertEquals( "BaseException", except.getBaseTypeName() );
	}
	
	private String path( String name ) throws URISyntaxException {
		return pathGlobal( "parser/exception/" + name );
	}	
}
