/******************************************************************************
 * Copyright 2014-2018 Alexandru Motriuc                                     *
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

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.amit.api.compiler.model.TypeCommonComposite;

public class TypeCommonCompositeChildrenFinder  extends ChildrenFinder {
	private List<? extends TypeCommonComposite> elements;
	
	public TypeCommonCompositeChildrenFinder( List<? extends TypeCommonComposite> elements ) {
		this.elements = elements;
		this.process();
	}
	
	@Override
	protected void buildChildrenMap(Map<String, Set<String>> childrenMap) {
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
}
