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

public class Function extends ProjectElement {
	private UniqueCollection<FunctionArgument> arguments =  new UniqueCollection<FunctionArgument>( "argument" );
	private FunctionReturn returnType;
	
	protected Function( String name, Context context ) {
		super( name, context );
	}
	
	/**
	 * creates a function argument
	 * @param type
	 * @param name
	 * @param isArray
	 * @param attr
	 * @param context
	 * @return
	 */
	public FunctionArgument createArgument( String type, String name, boolean isArray,
			AttributeList attr, Context context ) {
		
		FunctionArgument arg = new FunctionArgument( type, name, isArray, context );
		arg.setAttributeList( attr );
		arguments.add( arg );
		return arg;
	}
	
	/**
	 * returns function arguments
	 * @return
	 */
	public List<FunctionArgument> getArguments() {
		return arguments.readonlyList();
	}
	
	/**
	 * set function return type
	 * @param returnType
	 */
	public void setReturn( FunctionReturn returnType ) {
		this.returnType = returnType;
	}
	
	/**
	 * get function return type
	 * @return
	 */
	public FunctionReturn getReturn() {
		return returnType;
	}
}
