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
import java.util.List;

/**
 * the module, only one module can be per file
 */
public class Module extends ProjectElement {
	private ModuleType type;
	private List<Type> types = new ArrayList<Type>();
	private List<Interface> interfaces = new ArrayList<Interface>();
	private List<Service> services = new ArrayList<Service>();
	private List<Validation> validators = new ArrayList<Validation>();

	/**
	 * creates a module
	 * 
	 * @param name
	 *            module name
	 * @param type
	 *            module type
	 * @param context
	 *            context
	 * @param project
	 *            project
	 */
	protected Module(String name, ModuleType type, Context context,
			Project project) {
		super(name, context, project);

		if (type == null) {
			throw new IllegalArgumentException("type must be not null");
		}

		this.type = type;
	}

	/**
	 * returns the module type
	 * 
	 * @return module type
	 */
	public ModuleType getType() {
		return type;
	}

	/**
	 * adds a type to the module
	 * 
	 * @param type
	 *            type
	 * @throws ModuleElementException
	 *             thrown if validation fail
	 */
	public void add(Type type) throws ModuleElementException {
		if (type == null) {
			throw new IllegalArgumentException("type must be not null");
		}

		if (type.getProject() != this.getProject()) {
			throw new IllegalArgumentException("type must be in this project");
		}

		types.add(type);
	}

	/**
	 * adds an interface to the module
	 * 
	 * @param iinterface
	 *            interface
	 * @throws ModuleElementException
	 *             thrown if validation fail
	 */
	public void add(Interface iinterface) {
		if (iinterface == null) {
			throw new IllegalArgumentException("interface must be not null");
		}

		if (iinterface.getProject() != this.getProject()) {
			throw new IllegalArgumentException(
					"interface must be in this project");
		}

		interfaces.add(iinterface);
	}

	/**
	 * adds service to the module
	 * 
	 * @param service
	 *            service
	 * @throws ModuleElementException
	 *             thrown if validation fail
	 */
	public void add(Service service) throws ModuleElementException {
		if (service == null) {
			throw new IllegalArgumentException("service must be not null");
		}

		if (service.getProject() != this.getProject()) {
			throw new IllegalArgumentException(
					"service must be in this project");
		}

		if (!getType().equals(ModuleType.PROJECT)) {
			throw new ModuleElementException(
					"service is allowed only in the project file", service);
		}

		services.add(service);
	}

	/**
	 * adds validator to the module
	 * 
	 * @param validator
	 */
	public void add(Validation validator) {
		if (validator == null) {
			throw new IllegalArgumentException("validator must be not null");
		}

		if (validator.getProject() != this.getProject()) {
			throw new IllegalArgumentException(
					"validator must be in this project");
		}

		validators.add(validator);
	}

	@Override
	public void validate() throws ModuleElementException {
		super.validate();

		for (Type type : types) {
			type.validate();
		}

		for (Validation validator : validators) {
			validator.validate();
		}

		for (Interface intr : interfaces) {
			intr.validate();
		}

		for (Service service : services) {
			service.validate();
		}

	}

}
