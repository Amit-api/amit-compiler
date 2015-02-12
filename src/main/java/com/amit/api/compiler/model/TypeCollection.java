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

import java.util.HashMap;
import java.util.Map;

/**
 * 
 */
public class TypeCollection {
	private Map<String,Type> types = new HashMap<String,Type>();
	
	/**
	 * adds a type to the collection
	 * @param type
	 * @throws ModuleElementException 
	 */
	public void add( Type type ) throws ModuleElementException {
		if( type == null ) {
			throw new IllegalArgumentException( "type must not be null" );
		}
		
		if( types.containsKey( type.getName() ) ) {
			throw new ModuleElementException( "duplicate type", type  );
		}
		
		types.put( type.getName() , type );
	}
}
