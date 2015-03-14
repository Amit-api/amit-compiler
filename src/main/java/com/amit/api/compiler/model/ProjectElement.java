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
 * A project element is an entity in the project
 * the entity belongs to the project has a name and may contain attributes 
 */
public class ProjectElement {
	private String name;
	private Context context;
	private AttributeList attributes;
	private Project project;
	
	/**
	 * creates the project element
	 * @param name - the element name
	 * @param context - parsing context
	 * @param project - the owner project
	 */
	protected ProjectElement( String name, Context context, Project project ) {
		if( name == null || name.isEmpty() ) {
			throw new IllegalArgumentException( "type must be not null or empty" );
		}
		if( project == null ) {
			throw new IllegalArgumentException( "project must be not null" );
		}
		
		this.name = name;
		this.context = context;
		this.project = project;
	}
	
	/**
	 * returns the project elements belongs to
	 * @return
	 */
	public Project getProject() {
		return project;
	}
	
	/**
	 * returns the element name
	 * @return
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * returns the element context
	 * @return
	 */
	public Context getContext() {
		return context;
	}
	
	/**
	 * sets the element attributes
	 * @param attributes
	 */
	public void setAttributeList( AttributeList attributes ) {
		if( attributes.getProject() != this.project ) {
			throw new IllegalArgumentException( "the attribute list must belong to this project" );
		}
		this.attributes = attributes;
	}
	
	/**
	 * returns the element attributes
	 * @return
	 */
	public AttributeList getAttributes() {
		return attributes;
	}

	/**
	 * returns the attribute value associated to the element
	 * @param name
	 * @return
	 */
	public String getAttributeValue( String name ) {
		return attributes.get( name );
	}
	
	/**
	 * returns attribute value associated to the element
	 * if there is no attribute was find the defaultValue is returned 
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
	 * @throws ModuleElementException
	 */
	public void validate() throws ModuleElementException {
	}
	
	/**
	 * creates the AttributeList which can be used in the project
	 * that elements belongs to
	 * @return
	 */
	public AttributeList createAttributeList() {
		return project.createAttributeList();
	}
		
	/**
	 * validates if the typeName has acceptedTypeTypes 
	 * otherwise the exception is thrown
	 * @param typeName
	 * @param acceptedTypeTypes
	 * @throws ModuleElementException
	 */
	protected void validateType( String typeName, String... acceptedTypeTypes ) throws ModuleElementException {
		Type type = project.getType( typeName );
		if( type == null ) {
			throw new ModuleElementException( String.format( "unknown type '%s'", typeName ), this );
		}
		
		for( String typeType: acceptedTypeTypes ) {
			if( type.getType().equals( typeType ) ) {
				return;
			}
		}
		
		throw new ModuleElementException( 
				String.format( "unsuported type '%s' which is '%s' ", typeName, type.getType() ), this );			
	}	
}
