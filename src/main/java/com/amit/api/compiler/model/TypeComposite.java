/******************************************************************************
 * Copyright 2014-2018 Alexandru Motriuc                                      *
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

/**
 * a composite type
 * type TypeName : baseType {
 * 		memberType memberName;
 * 		....
 * } 
 */
public class TypeComposite extends TypeCommonComposite {
	protected TypeComposite( String name, Context context, Project project ) {
		super( COMPOSITE, name, context, project );
	}
	
	@Override
	public void validate() throws ModuleElementException {
		super.validate();
		
		if( getBaseTypeName() != null ) {
			validateType( getBaseTypeName(), Type.COMPOSITE );
		}
	}
}
