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

public class ModuleElement {
	private String name;
	private Context context;
	private AttributeList attributes;
	
	public ModuleElement( String name, Context context ) {
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
	 * set attributes
	 * @param attributes
	 */
	public void setAttributeList( AttributeList attributes ) {
		this.attributes = attributes;
	}
	
	/**
	 * return attributes
	 * @return
	 */
	public AttributeList getAttributes() {
		return attributes;
	}
	
	public static String fromParsedString( String str ) {
		return str.substring( 1, str.length() - 1 ).replace("\\\"", "\"").replace("\\\\", "\\" );
	}	
}
