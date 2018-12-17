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
package com.amit.api.compiler.model.tools;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import org.junit.Test;

import com.amit.api.compiler.model.ModuleType;
import com.amit.api.compiler.model.Project;
import com.amit.api.compiler.model.TypeCommonComposite;

public class ChildrenFinderTest {

	@Test
	public void testGetChildren() {
		Project project = new Project();
		project.createModule("m", ModuleType.PROJECT, null, null );
		
		TypeCommonComposite v1 = project.createCompositeType("1", null, null );
			v1.setBaseTypeName( "7" );
		TypeCommonComposite v2 = project.createCompositeType("2", null, null );
			v2.setBaseTypeName( "1" );
		TypeCommonComposite v3 = project.createCompositeType("3", null, null );
			v3.setBaseTypeName( "1" );
		TypeCommonComposite v4 = project.createCompositeType("4", null, null );
			v4.setBaseTypeName( "2" );
		TypeCommonComposite v5 = project.createCompositeType("5", null, null );
			v5.setBaseTypeName( "2" );
		TypeCommonComposite v6 = project.createCompositeType("6", null, null );
			v6.setBaseTypeName( "3" );
		TypeCommonComposite v7 = project.createCompositeType("7", null, null );
		TypeCommonComposite v8 = project.createCompositeType("8", null, null );
			v8.setBaseTypeName( "7" );
		TypeCommonComposite v9 = project.createCompositeType("9", null, null );
		TypeCommonComposite v10 = project.createCompositeType("10", null, null );
			v10.setBaseTypeName( "9" );
			
		List<TypeCommonComposite> list = Arrays.asList( v1, v2, v3, v4, v5, v6, v7, v8, v9, v10 );
		
		
		TypeCommonCompositeChildrenFinder find = new TypeCommonCompositeChildrenFinder( list );
		
		assertEquals( new HashSet<String>(Arrays.asList("2","3","6","4","5" ) ), 
				find.getAllChildren().get( "1" ) );

		assertEquals( new HashSet<String>(Arrays.asList("4","5" ) ), 
				find.getAllChildren().get( "2" ) );

		assertEquals( new HashSet<String>(Arrays.asList("6" ) ), 
				find.getAllChildren().get( "3" ) );

		assertNull( find.getAllChildren().get( "4" ) );
		assertNull( find.getAllChildren().get( "5" ) );
		assertNull( find.getAllChildren().get( "6" ) );

		assertEquals( new HashSet<String>(Arrays.asList("1","2","3","6","4","5", "8" ) ), 
				find.getAllChildren().get( "7" ) );
		
		assertNull( find.getAllChildren().get( "8" ) );
		
		assertEquals( new HashSet<String>(Arrays.asList("10" ) ), 
				find.getAllChildren().get( "9" ) );

		assertNull( find.getAllChildren().get( "10" ) );
	}
}
