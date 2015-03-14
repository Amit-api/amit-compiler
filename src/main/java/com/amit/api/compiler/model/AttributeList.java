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
 * attributes list 
 */
public class AttributeList extends ProjectElement {
	private Map<String, Attribute> attributeMap = new HashMap<String, Attribute>();

	protected AttributeList( Project project ) {
		super( "attributes", null, project );
	}
	
	/**
	 * creates an attribute
	 * @param name
	 * @param value
	 * @param context
	 * @return
	 */
	public Attribute createAttribute( String name, String value, Context context ) {
		Attribute attr = new Attribute( name, value, context, getProject() );
		add( attr );
		return attr;
	}

	/**
	 * returns the attribute value
	 * @param name
	 * @return
	 */
	public String get( String name ) {
		if( name == null || name.isEmpty() ) {
			throw new IllegalArgumentException( "name must be not empty or null" );
		}
		
		Attribute attr = attributeMap.get( name );
		return attr == null ? null : attr.getValue();
	}
	
	private void add( Attribute attr ) {
		if( attributeMap.containsKey( attr.getName() ) ) {
			throw new ModuleElementException( "duplicate attribute value", attr );
		}
		
		attributeMap.put( attr.getName(), attr );		
	}	
}
