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
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * collection that ensures 
 * unique by name list of the ProjectElements
 */
public class UniqueCollection<T extends ProjectElement> implements Iterable<T> {
	private Map<String,T> elements = new HashMap<String,T>();
	private List<T> elementList = new ArrayList<T>();
	private String typeName;
	
	public UniqueCollection( String typeName ) {
		if( typeName == null || typeName.isEmpty() ) {
			throw new IllegalArgumentException( "typeName must be not null or empty" );
		}
		
		this.typeName = typeName;
	}
	
	/**
	 * adds a element to the collection and exception is thrown when 
	 * element 
	 * @param type
	 * @throws ModuleElementException 
	 */
	public void add( T element ) throws ModuleElementException {
		if( element == null ) {
			throw new IllegalArgumentException( "type must not be null" );
		}
		
		if( elements.containsKey( element.getName() ) ) {
			throw new ModuleElementException( String.format( "%s name is in use", typeName ), element );
		}
		
		elements.put( element.getName() , element );
		elementList.add( element );
	}
	
	/**
	 * gets the element by name
	 * @param name
	 * @return
	 */
	public T get( String name ) {
		if( name == null || name.isEmpty() ) {
			throw new IllegalArgumentException( "name must be not null or empty" );
		}
		
		return elements.get( name );
	}
	
	/**
	 * returns the read only list
	 * @return
	 */
	public List<T> readonlyList() {
		return Collections.unmodifiableList( elementList );
	}

	public Iterator<T> iterator() {
		return elementList.iterator();
	}
}
