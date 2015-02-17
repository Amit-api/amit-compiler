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

public class TypeArgument extends ProjectElement {
	private String typeName;
	private boolean isArray = false;
	private boolean isRequired = false;
	private boolean canBeVoid = false;

	protected TypeArgument( String type, String name, Context context ) {
		this( type, name, context, false );
	}

	protected TypeArgument( String type, String name, Context context, boolean canBeVoid ) {
		super( name, context );
		
		if( type == null || type.isEmpty() ) {
			throw new IllegalArgumentException( "type must be not null or empty" );
		}
		
		this.typeName = type;
		this.canBeVoid = canBeVoid;
	}

	/**
	 * sets the isRequired flag
	 * @param isRequired
	 */
	public void setIsRequired( boolean isRequired ) {
		this.isRequired = isRequired;
	}
	
	/**
	 * sets is array flag
	 * @param isArray
	 */
	public void setIsArray( boolean isArray ) {
		this.isArray = isArray;
	}
	
	/**
	 * returns the item type
	 * @return
	 */
	public String getTypeName() {
		return typeName;
	}	
	
	/**
	 * returns true if composite member is an array
	 * @return
	 */
	public boolean isArray() {
		return isArray;
	}
	
	/**
	 * return true if member is required
	 * @return
	 */
	public boolean isRequired() {
		return isRequired;
	}
	
	/***
	 * {@inheritDoc}
	 */
	@Override
	public void validate( Project project ) throws ModuleElementException {
		super.validate( project );
		
		project.validateType( this, getTypeName(), Type.PRIMITIVE, Type.ENUM, Type.COMPOSITE );
		
		if( !canBeVoid && getTypeName().equals( PrimitiveTypeNames.VOID ) ) {
			throw new ModuleElementException( "the type can't be void ", this );
		}
	}
}
