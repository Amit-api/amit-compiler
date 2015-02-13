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
import java.util.List;

public class Project {
	private UniqueCollection<Type> types = new UniqueCollection<Type>( "type,enum,interface" );
	private UniqueCollection<Module> modules = new UniqueCollection<Module>( "module" );
	private List<TypeEnum> enums = new ArrayList<TypeEnum>();
	private List<CompositeType> compositeTypes = new ArrayList<CompositeType>();
	private Module currentModule;

	/**
	 * creates an enum
	 * @param name
	 * @param context
	 * @return
	 * @throws ModuleElementException
	 */
	public TypeEnum createEnum( String name, Context context ) throws ModuleElementException {
		return addEnum(  new TypeEnum( name, context ) );
	}
	
	/**
	 * returns all enums from the project
	 * @return
	 */
	public List<TypeEnum> getEnums() {
		return Collections.unmodifiableList( enums );
	}

	/**
	 * creates a module
	 * @param name
	 * @param context
	 * @return
	 * @throws ModuleElementException
	 */
	public Module createModule( String name, ModuleType type, Context context ) throws ModuleElementException {
		Module module = new Module( name, type, context );
		modules.add( module );
		currentModule = module;
		return module;
	}
	
	/**
	 * create a composite type
	 * @param name
	 * @param attr
	 * @param context
	 * @return
	 * @throws ModuleElementException
	 */
	public CompositeType creatCompositeType( String name, AttributeList attr, Context context ) throws ModuleElementException {
		CompositeType type = new CompositeType( name, context );
		type.setAttributeList( attr );
		return addCompositeType( type );
	}
	
	/**
	 * returns composite types
	 * @return
	 */
	public List<CompositeType> getCompositeTypes() {
		return Collections.unmodifiableList( compositeTypes );
	}
	
	private CompositeType addCompositeType( CompositeType type ) {
		addType( type );
		compositeTypes.add( type );
		return type;
	}
	
	private TypeEnum addEnum( TypeEnum type ) {
		addType( type );
		enums.add( type );
		return type;
	}
	
	private void addType( Type type ) {
		types.add( type );
		currentModule.add( type );		
	}
}
