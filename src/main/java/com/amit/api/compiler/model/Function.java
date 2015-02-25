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
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Function extends ProjectElement {
	private UniqueCollection<FunctionArgument> arguments =  new UniqueCollection<FunctionArgument>( "argument" );
	private FunctionReturn returnType;
	private Set<String> throwsExceptions = new HashSet<String>();
	private List<String> throwsExceptionsList = new ArrayList<String>();
	
	protected Function( String name, Context context ) {
		super( name, context );
	}
	
	/**
	 * creates a function argument
	 * @param type
	 * @param name
	 * @param isArray
	 * @param attr
	 * @param context
	 * @return
	 */
	public FunctionArgument createArgument( String type, String name, boolean isArray,
			boolean isRequired, AttributeList attr, Context context ) {
		
		FunctionArgument arg = new FunctionArgument( type, name, context );
		arg.setAttributeList( attr );
		arg.setIsArray( isArray );
		arg.setIsRequired( isRequired );
		
		arguments.add( arg );
		return arg;
	}
	
	/**
	 * returns function arguments
	 * @return
	 */
	public List<FunctionArgument> getArguments() {
		return arguments.readonlyList();
	}
	
	/**
	 * set function return type
	 * @param returnType
	 */
	public void setReturn( FunctionReturn returnType ) {
		this.returnType = returnType;
	}
	
	/**
	 * get function return type
	 * @return
	 */
	public FunctionReturn getReturn() {
		return returnType;
	}
	
	/**
	 * adds throws exception
	 * @param exceptionName
	 */
	public void addThrowsException( String exceptionName ) {
		if( exceptionName == null || exceptionName.isEmpty() ) {
			throw new IllegalArgumentException( "exceptionName must be not null or empty" );
		}
		
		if( throwsExceptions.contains( exceptionName ) ) {
			throw new ModuleElementException(
					String.format( "duplicate throws exception for name '%s'", exceptionName ), this );
		}
		
		throwsExceptions.add( exceptionName );
		throwsExceptionsList.add( exceptionName );		
	}
	
	/**
	 * returns throws exception name list
	 * @return
	 */
	public List<String> getThrowsExceptionNames() {
		return Collections.unmodifiableList( throwsExceptionsList );
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean dependsOnType( String typeName ) {
		if( super.dependsOnType( typeName ) ) {
			return true;
		}
		
		if( typeName.equals( returnType.getTypeName() ) ) {
			return true;
		}
		
		for( FunctionArgument arg : arguments ) {
			if( arg.getTypeName().equals( typeName ) ) {
				return true;
			}
		}
		
		return false;
 	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean dependsOnTypeArray() {
		if( super.dependsOnTypeArray() ) {
			return true;
		}
		
		if( returnType.isArray() ) {
			return true;
		}
		
		for( FunctionArgument arg : arguments ) {
			if( arg.isArray() ) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void validate( Project project ) throws ModuleElementException {
		super.validate( project );
		validateArgs( project );
		validateExceptions( project );
	}
	
	private void validateArgs( Project project ) throws ModuleElementException {
		returnType.validate( project );
		for( FunctionArgument arg : arguments ) {
			arg.validate( project );
		}		
	}
	
	private void validateExceptions( Project project ) throws ModuleElementException {
		for( String exception : throwsExceptionsList ) {
			project.validateType( this, exception, Type.EXCEPTION );
		}		
	}
}
