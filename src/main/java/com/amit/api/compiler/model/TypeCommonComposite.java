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

/**
 * a common type for composite types like type and exception
 */
public class TypeCommonComposite extends Type {
	private UniqueCollection<TypeCompositeMember> members = new UniqueCollection<TypeCompositeMember>( "type member" );
	private String baseTypeName;

	/**
	 * retuns composite type members
	 * @return member list
	 */
	public List<TypeCompositeMember> getMembers() {
		return members.readonlyList();
	}

	/**
	 * return base type
	 * @return name base type name
	 */
	public String getBaseTypeName() {
		return baseTypeName;
	}
	
	/**
	 * creates common composite type
	 * @param type type type
	 * @param name type name
	 * @param context context
	 * @param project project
	 */
	protected TypeCommonComposite( String type, String name, Context context, Project project ) {
		super( type, name, context, project );
	}
	
	/**
	 * adds composite type member
	 * @param type member type
	 * @param name member name
	 * @param isArray is array or not
	 * @param isRequred is required or not
	 * @param context context
	 */
	public void addMember( String type, String name, boolean isArray, boolean isRequred, Context context ) {
		TypeCompositeMember member = new TypeCompositeMember( type, name, context, getProject() );
		member.setIsArray( isArray );
		member.setIsRequired( isRequred );
		
		members.add( member );
	}
	
	
	/**
	 * set base type
	 * @param baseTypeName base type name
	 */
	public void setBaseTypeName( String baseTypeName ) {
		this.baseTypeName = baseTypeName;
	}
		
	/**
	 * {@inheritDoc}
	 */
	public void validate() throws ModuleElementException {
		super.validate();
		
		for( TypeCompositeMember member : members ) {
			member.validate();
		}
	}
}
