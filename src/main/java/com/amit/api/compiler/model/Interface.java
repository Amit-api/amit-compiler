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
package com.amit.api.compiler.model;

import java.util.List;

public class Interface extends ProjectElement {
	private UniqueCollection<Function> functions = new UniqueCollection<Function>( "function" );
	
	protected Interface( String name, Context context ) {
		super( name, context );
	}
	
	/**
	 * creates a function in the interface
	 * @param name
	 * @param attr
	 * @param context
	 * @return
	 */
	public Function createFunction( String name, AttributeList attr, Context context ) {
		Function fun = new Function( name, context );
		fun.setAttributeList( attr );
		functions.add( fun );
		return fun;
	}
	
	/**
	 * returns interface functions
	 * @return
	 */
	public List<Function> getFunctions() {
		return functions.readonlyList();
	}
}
