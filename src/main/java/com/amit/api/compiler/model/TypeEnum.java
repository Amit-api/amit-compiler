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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * emit enum Ex:
 * 
 * enum Color {
 * 	red = 1,
 *  blue = 2
 *  }
 */
public class TypeEnum extends Type {
	
	private Map<String, TypeEnumValue> values = new HashMap<String, TypeEnumValue>();
	private List<TypeEnumValue> valueList = new ArrayList<TypeEnumValue>();
	
	/**
	 * returns enum values
	 * @return enum values
	 */
	public List<TypeEnumValue> getValues() {
		return Collections.unmodifiableList( valueList );
	}
	
	/**
	 * create the enum 
	 * @param name enum name
	 * @param context context
	 * @param project project
	 */
	protected TypeEnum( String name, Context context, Project project ) {
		super( Type.ENUM, name, context, project );
	}
	
	/**
	 * creates an enum value
	 * @param name value name
	 * @param value value integer value
	 * @param context context
	 * @param attr attribute list
	 * @return enum value
	 */
	public TypeEnumValue createValue( String name, Integer value, AttributeList attr, Context context ) {
		TypeEnumValue enum_value = new TypeEnumValue( name, value, context, getProject() );
		enum_value.setAttributeList( attr );
		
		add( enum_value );		
		return enum_value;
	}

	/**
	 * creates an enum value
	 * @param name value name
	 * @param value string value
	 * @param attr attribute list
	 * @param context context
	 * @return enum value
	 */
	public TypeEnumValue createValue( String name, String value, AttributeList attr, Context context ) {
		TypeEnumValue enum_value = new TypeEnumValue( name, value, context, getProject() );
		enum_value.setAttributeList( attr );

		add( enum_value );
		return enum_value;
	}
		
	private void add( TypeEnumValue enum_value ) {
		if( values.containsKey( enum_value.getName() ) ) {
			throw new ModuleElementException( "duplicate enum value", enum_value );
		}
		
		values.put( enum_value.getName(), enum_value );		
		valueList.add( enum_value );
	}
}
