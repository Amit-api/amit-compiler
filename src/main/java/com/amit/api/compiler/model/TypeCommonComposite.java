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

import java.util.List;

public class TypeCommonComposite extends Type {
	private UniqueCollection<TypeCompositeMember> members = new UniqueCollection<TypeCompositeMember>( "type member" );
	private String baseType;
	
	public TypeCommonComposite( String type, String name, Context context ) {
		super( type, name, context);
	}
	
	/**
	 * adds composite type member
	 * @param type
	 * @param name
	 * @param context
	 */
	public void addMember( String type, String name, boolean isArray, boolean isRequred, Context context ) {
		TypeCompositeMember member = new TypeCompositeMember( type, name, context );
		member.setIsArray( isArray );
		member.setIsRequired( isRequred );
		
		members.add( member );
	}
	
	/**
	 * retuns composite type members
	 * @return
	 */
	public List<TypeCompositeMember> getMembers() {
		return members.readonlyList();
	}
	
	/**
	 * set base type
	 * @param baseType
	 */
	public void setBaseType( String baseType ) {
		this.baseType = baseType;
	}
	
	/**
	 * return base type
	 * @return
	 */
	public String getBaseType() {
		return baseType;
	}
}
