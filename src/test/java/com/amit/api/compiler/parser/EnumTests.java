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

import com.amit.api.compiler.model.Project;
import com.amit.api.compiler.model.TypeEnum;

public class EnumTests extends TestBase {
			
	@Test
	public void testEnumInt() throws Exception {
		AmitParser parser = AmitParser.fromFile( path( "enum-int.amit" ) );
		Project project = parser.parse();
		
		assertEquals( 1, project.getEnums().size() );
		
		TypeEnum e = project.getEnums().get( 0 );
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
		Project project = parser.parse();
		
		assertEquals( 1, project.getEnums().size() );
		
		TypeEnum e = project.getEnums().get( 0 );
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
		return pathGlobal( "parser/enum/" + name );
	}
}
