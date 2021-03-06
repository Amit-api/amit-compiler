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
