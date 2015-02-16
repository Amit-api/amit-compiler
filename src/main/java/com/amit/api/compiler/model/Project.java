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
	private UniqueCollection<Service> services = new UniqueCollection<Service>( "service" );
	
	private List<Interface> interfaces = new ArrayList<Interface>();
	private List<TypeEnum> enums = new ArrayList<TypeEnum>();
	private List<TypeComposite> compositeTypes = new ArrayList<TypeComposite>();
	private List<TypeException> exceptions = new ArrayList<TypeException>();
	
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
	 * returns module associated to the project
	 * only one module of this type can be per project
	 * @return
	 */
	public Module getProjectModule() {
		return projectModule;
	}
	
	/**
	 * creates a composite type
	 * @param name
	 * @param attr
	 * @param context
	 * @return
	 * @throws ModuleElementException
	 */
	public TypeComposite creatCompositeType( String name, AttributeList attr, Context context ) throws ModuleElementException {
		TypeComposite type = new TypeComposite( name, context );
		type.setAttributeList( attr );
		addComposite( type );
		return type;
	}
	
	/**
	 * returns all composite types from project
	 * @return
	 */
	public List<TypeComposite> getCompositeTypes() {
		return Collections.unmodifiableList( compositeTypes );
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
	 * returns all interfaces from the project
	 * @return
	 */
	public List<Interface> getInterfaces() {
		return Collections.unmodifiableList( interfaces );
	}
	
	/**
	 * create an exception type
	 * @param name
	 * @param attr
	 * @param context
	 * @return
	 * @throws ModuleElementException
	 */
	public TypeException createException( String name, AttributeList attr, Context context ) throws ModuleElementException {
		TypeException exception = new TypeException( name, context );
		exception.setAttributeList( attr );
		addException( exception );
		return exception;
	}
	
	/**
	 * returns all exceptions from the project
	 * @return
	 */
	public List<TypeException> getExceptions() {
		return Collections.unmodifiableList( exceptions );
	}
	
	/**
	 * creates an service
	 * @param name
	 * @param attr
	 * @param context
	 * @return
	 * @throws ModuleElementException
	 */
	public Service createService( String name, AttributeList attr, Context context ) throws ModuleElementException {
		Service service = new Service( name, context );
		service.setAttributeList( attr );
		addService( service );
		
		return service;
	}
	
	/**
	 * returns all services from the project
	 * @return
	 */
	public List<Service> getServices() {
		return services.readonlyList();
	}
	
	private void addComposite( TypeComposite type ) {
		addType( type );
		compositeTypes.add( type );
	}
	
	private void addException( TypeException exception ) {
		addType( exception );
		exceptions.add( exception );
	}
	
	private void addEnum( TypeEnum type ) {
		addType( type );
		enums.add( type );
	}
	
	private void addInterface( Interface interf ) {
		addType( interf );	
		interfaces.add( interf );
		currentModule.add( interf );
	}
	
	private void addType( Type type ) {
		types.add( type );
		currentModule.add( type );		
	}
	
	private void addService( Service service ) {
		services.add( service );
		currentModule.add( service );
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
