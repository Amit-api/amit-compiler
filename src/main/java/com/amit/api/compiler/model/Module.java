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
import java.util.List;

/**
 * [TO DO]
 */
public class Module {
	private TypeCollection types = new TypeCollection();
	private List<TypeEnum> enums = new ArrayList<TypeEnum>();
		
	/**
	 * return all the types in the module
	 * @return
	 */
	public TypeCollection getTypes() {
		return types;
	}
	
	/**
	 * creates the enum
	 * @param name
	 * @return
	 * @throws ModuleElementException 
	 */
	public TypeEnum createEnum( String name, Context context ) throws ModuleElementException {
		TypeEnum type = new TypeEnum( name, context );
		types.add( type );
		enums.add( type );
		return type;
	}
	
	/**
	 * returns enum list
	 * @return
	 */
	public List<TypeEnum> getEnums() {
		return Collections.unmodifiableList( enums );
	}
}
