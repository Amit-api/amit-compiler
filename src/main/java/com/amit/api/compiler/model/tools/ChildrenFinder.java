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
package com.amit.api.compiler.model.tools;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

/**
 * finds all children in a directional graph
 * Ex:
 * a - b, c
 * b - c, f
 * c - g
 * will result:
 * a - b, c, g, f
 * b - c, f, g
 * c - g 
 */
public abstract class ChildrenFinder {
	private Map<String,Set<String>> childrenMap = new HashMap<String,Set<String>>();
	
	public Map<String,Set<String>> getAllChildren() {
		return childrenMap;
	}
	
	protected void process() {
		buildChildrenMap( childrenMap );
		findAllChildren();
	}
	
	protected abstract void buildChildrenMap( Map<String,Set<String>> childrenMap );
	
	private void findAllChildren() {
		List<String> nodes = new ArrayList<String>();
		nodes.addAll( childrenMap.keySet() );

		while( !nodes.isEmpty() ) {
			String name = nodes.remove( 0 );
			Set<String> children = childrenMap.get( name );
			
			for( Entry<String, Set<String>> item : childrenMap.entrySet() ) {
				if( item.getValue().contains( name) ) {
					item.getValue().addAll( children );
				}
			}
		}
	}	
}
