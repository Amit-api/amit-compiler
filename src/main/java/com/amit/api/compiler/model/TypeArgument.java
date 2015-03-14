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

/**
 * an argument which contains a type which can be array type as well 
 */
public class TypeArgument extends ProjectElement {
	private String typeName;
	private boolean isArray = false;
	private boolean isRequired = false;
	private boolean canBeVoid = false;
	
	/**
	 * returns the item type
	 * @return item type name
	 */
	public String getTypeName() {
		return typeName;
	}	
	
	/**
	 * returns true if composite member is an array
	 * @return true or false
	 */
	public boolean isArray() {
		return isArray;
	}
	
	/**
	 * return true if member is required
	 * @return true or false
	 */
	public boolean isRequired() {
		return isRequired;
	}

	protected TypeArgument( String type, String name, Context context, Project project ) {
		this( type, name, context, false, project );
	}

	protected TypeArgument( String type, String name, Context context, boolean canBeVoid, Project project ) {
		super( name, context, project );
		
		if( type == null || type.isEmpty() ) {
			throw new IllegalArgumentException( "type must be not null or empty" );
		}
		
		this.typeName = type;
		this.canBeVoid = canBeVoid;
	}

	/**
	 * sets the isRequired flag
	 * @param isRequired required flag
	 */
	public void setIsRequired( boolean isRequired ) {
		this.isRequired = isRequired;
	}
	
	/**
	 * sets is array flag
	 * @param isArray is array flag
	 */
	public void setIsArray( boolean isArray ) {
		this.isArray = isArray;
	}
	
	/***
	 * {@inheritDoc}
	 */
	@Override
	public void validate() throws ModuleElementException {
		super.validate();
		
		validateType( getTypeName(), Type.PRIMITIVE, Type.ENUM, Type.COMPOSITE );
		
		if( !canBeVoid && getTypeName().equals( PrimitiveTypeNames.VOID ) ) {
			throw new ModuleElementException( "the type can't be void ", this );
		}
	}
}
