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

import com.amit.api.compiler.model.Module;
import com.amit.api.compiler.model.Project;

public class ModuleTests extends TestBase {

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
		return pathGlobal( "parser/module/" + name );
	}	
}
