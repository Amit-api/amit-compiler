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

public class ProjectElement {
	private String name;
	private Context context;
	private AttributeList attributes;
	
	protected ProjectElement( String name, Context context ) {
		if( name == null || name.isEmpty() ) {
			throw new IllegalArgumentException( "type must be not null or empty" );
		}
		
		this.name = name;
		this.context = context;
	}
	
	/**
	 * returns the name
	 * @return
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * return context
	 * @return
	 */
	public Context getContext() {
		return context;
	}
	
	/**
	 * sets element attributes
	 * @param attributes
	 */
	public void setAttributeList( AttributeList attributes ) {
		this.attributes = attributes;
	}
	
	/**
	 * return element attributes
	 * @return
	 */
	public AttributeList getAttributes() {
		return attributes;
	}

	/**
	 * returns attribute value
	 * @param name
	 * @return
	 */
	public String getAttributeValue( String name ) {
		return attributes.get( name );
	}
	
	/**
	 * returns attribute value
	 * @param name
	 * @param defaultValue
	 * @return
	 */
	public String getAttributeValue( String name, String defaultValue ) {
		String attr = attributes.get( name );

		return attr == null ? defaultValue : attr;
	}
	
	/**
	 * validates the project element if the validation fails
	 * the exception is thrown
	 * @param project
	 * @throws ModuleElementException
	 */
	public void validate( Project project ) throws ModuleElementException {
	}
	
	/**
	 * return true if the element depends on type
	 * @param typeName
	 * @return
	 */	
	public boolean dependsOnType( String typeName ) {
		return false;
	}
	
	/**
	 * return true if the element depends on array
	 * @return
	 */
	public boolean dependsOnTypeArray() {
		return false;
	}
}
