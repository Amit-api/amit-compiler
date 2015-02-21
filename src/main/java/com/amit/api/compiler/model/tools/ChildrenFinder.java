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
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import com.amit.api.compiler.model.TypeCommonComposite;

public class ChildrenFinder {
	private List<? extends TypeCommonComposite> elements;
	private Map<String,Set<String>> childrenMap = new HashMap<String,Set<String>>();
	
	public ChildrenFinder( List<? extends TypeCommonComposite> elements ) {
		this.elements = elements;
		buildChildrenMap();
		findAllChildren();
	}
	
	public Map<String,Set<String>> getAllChildren() {
		return childrenMap;
	}
	
	private void buildChildrenMap() {
		childrenMap = new HashMap<String,Set<String>>();
		
		for( TypeCommonComposite element : elements ) {
			if( element.getBaseTypeName() != null ) {
				Set<String> children = childrenMap.get( element.getBaseTypeName() );
				if( children == null ) {
					children = new HashSet<String>();
					childrenMap.put( element.getBaseTypeName(), children );
				}
				children.add( element.getName() );
			}
		}		
	}
	
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
