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

import com.amit.api.compiler.model.Function;
import com.amit.api.compiler.model.Interface;
import com.amit.api.compiler.model.Project;

public class InterfaceTests extends TestBase {

	@Test
	public void testSimpe() throws Exception {
		AmitParser parser = AmitParser.fromFile( path( "int-simple.amit" ) );
		Project project = parser.parse();
		
		assertEquals( 1, project.getInterfaces().size() );
		
		Interface interf = project.getInterfaces().get( 0 );
	
		assertEquals( "ICall", interf.getName() );
		assertEquals( "hello", interf.getAttributeValue( "path" ) );
		
		assertEquals( 1, interf.getFunctions().size() );
		
		Function fun = interf.getFunctions().get( 0 );
		assertEquals( "fun", fun.getName() );
		assertEquals( "do something", fun.getAttributeValue( "public_name" ) );
	}
	
	private String path( String name ) throws URISyntaxException {
		return pathGlobal( "parser/interface/" + name );
	}	
}
