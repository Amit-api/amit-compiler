/******************************************************************************
 * Copyright 2014-2018 Alexandru Motriuc                                      *
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

/**
 * an amit interface ex: interface IntefaceName : BaseInterface1, ...
 * BaseInterfaceN { .... }
 */
public class Interface extends ProjectElement {
	private UniqueCollection<Function> functions = new UniqueCollection<Function>(
			"function");
	private Set<String> baseInterfaces = new HashSet<String>();
	private List<String> baseInterfacesList = new ArrayList<String>();

	/**
	 * returns interface functions
	 * 
	 * @return function list
	 */
	public List<Function> getFunctions() {
		return functions.readonlyList();
	}

	/**
	 * returns the list of base interface names
	 * 
	 * @return interface name list
	 */
	public List<String> getBaseInterfaceNames() {
		return Collections.unmodifiableList(baseInterfacesList);
	}

	/**
	 * return all base interface names full depth
	 * 
	 * @return interface name set
	 */
	public Set<String> getAllBaseInterfaceNames() {
		return getProject().getInterfaceBaseInterfaces(getName());
	}

	/**
	 * creates an interface
	 * 
	 * @param name
	 *            interface name
	 * @param context
	 *            context
	 * @param project
	 *            project
	 */
	protected Interface(String name, Context context, Project project) {
		super(name, context, project);
	}

	/**
	 * creates a function in the interface
	 * 
	 * @param name
	 *            function name
	 * @param functionReturn
	 *            function return
	 * @param attr
	 *            function attributes
	 * @param context
	 *            context
	 * @return function
	 */
	public Function createFunction(String name, FunctionReturn functionReturn,
			AttributeList attr, Context context) {
		Function fun = new Function(name, context, this, getProject());
		fun.setAttributeList(attr);
		fun.setReturn(functionReturn);
		functions.add(fun);
		return fun;
	}

	/**
	 * adds a base interfaces
	 * 
	 * @param interfaceName
	 *            interface name
	 */
	public void addBaseInterface(String interfaceName) {
		if (interfaceName == null || interfaceName.isEmpty()) {
			throw new IllegalArgumentException(
					"interfaceName must be not null or empty");
		}

		if (baseInterfaces.contains(interfaceName)) {
			throw new ModuleElementException(String.format(
					"duplicate inheritance for name '%s'", interfaceName), this);
		}

		baseInterfaces.add(interfaceName);
		baseInterfacesList.add(interfaceName);
	}
	
	/**
	 * return the funciton by name
	 * @return
	 */
	public Function getFunction(String functionName) {
		return functions.get(functionName);
	}

	@Override
	public void validate() throws ModuleElementException {
		super.validate();

		for (Function fun : functions) {
			fun.validate();
		}

		for (String interfName : baseInterfacesList) {
			validateInterface(interfName);
		}
	}
}
