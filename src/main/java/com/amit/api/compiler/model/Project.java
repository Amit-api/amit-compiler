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
	private UniqueCollection<Type> types = new UniqueCollection<Type>( "type" );
	private UniqueCollection<Module> modules = new UniqueCollection<Module>( "module" );
	private UniqueCollection<Interface> interfaces = new UniqueCollection<Interface>( "interface" );
	
	private List<TypeEnum> enums = new ArrayList<TypeEnum>();
	private List<CompositeType> compositeTypes = new ArrayList<CompositeType>();
	
	private Module currentModule;
	private Module projectModule;

	/**
	 * creates an enum
	 * @param name
	 * @param context
	 * @return
	 * @throws ModuleElementException
	 */
	public TypeEnum createEnum( String name, Context context ) throws ModuleElementException {
		TypeEnum type = new TypeEnum( name, context ); 
		addEnum( type );
		return type;
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
	public Module createModule( String name, ModuleType type, AttributeList attr, Context context ) throws ModuleElementException {
		Module module = new Module( name, type, context );
		module.setAttributeList( attr );
		addModule( module );
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
		addCompositeType( type );
		return type;
	}
	
	/**
	 * create an interface
	 * @param name
	 * @param attr
	 * @param context
	 * @return
	 * @throws ModuleElementException
	 */
	public Interface createInterface( String name, AttributeList attr, Context context ) throws ModuleElementException {
		Interface interf = new Interface( name, context );
		interf.setAttributeList( attr );
		addInterface( interf );
		return interf;
	}
	
	/**
	 * returns project module
	 * @return
	 */
	public Module getProjectModule() {
		return projectModule;
	}
	
	/**
	 * returns composite types
	 * @return
	 */
	public List<CompositeType> getCompositeTypes() {
		return Collections.unmodifiableList( compositeTypes );
	}
	
	private void addCompositeType( CompositeType type ) {
		addType( type );
		compositeTypes.add( type );
	}
	
	private void addEnum( TypeEnum type ) {
		addType( type );
		enums.add( type );
	}
	
	private void addInterface( Interface interf ) {
		interfaces.add( interf );
		currentModule.add( interf );		
	}
	
	private void addType( Type type ) {
		types.add( type );
		currentModule.add( type );		
	}
	
	private void addModule( Module module ) throws ModuleElementException {
		modules.add( module );
		currentModule = module;
		
		if( module.getType().equals( ModuleType.PROJECT ) ) {
			if( projectModule != null ) {
				throw new ModuleElementException( "Project module can't be included", module );
			}
			
			projectModule = module;
		}
	}
}
