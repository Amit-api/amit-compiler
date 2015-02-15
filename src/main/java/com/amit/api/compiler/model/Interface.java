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

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Interface extends ProjectElement {
	private UniqueCollection<Function> functions = new UniqueCollection<Function>( "function" );
	private Set<String> baseInterfaces = new HashSet<String>();
	private List<String> baseInterfacesList = new ArrayList<String>();
	
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
	public Function createFunction( String name, FunctionReturn functionReturn, AttributeList attr, Context context ) {
		Function fun = new Function( name, context );
		fun.setAttributeList( attr );
		fun.setReturn( functionReturn );
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
	
	/**
	 * add base interfaces
	 * @param interfaceName
	 */
	public void addBaseInterface( String interfaceName ) {
		if( interfaceName == null || interfaceName.isEmpty() ) {
			throw new IllegalArgumentException( "interfaceName must be not null or empty" );
		}
		
		if( baseInterfaces.contains( interfaceName ) ) {
			throw new ModuleElementException( String.format( "duplicate inheritance for name '%s'", interfaceName ), this );
		}
		
		baseInterfaces.add( interfaceName );
		baseInterfacesList.add( interfaceName );
	}
	
	/**
	 * returns the list of base interface names 
	 * @return
	 */
	public List<String> getBaseInterfaceNames() {
		return Collections.unmodifiableList( baseInterfacesList );
	}
}
