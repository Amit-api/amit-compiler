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
import java.util.Map;
import java.util.Set;

import com.amit.api.compiler.model.tools.InterfaceBaseChildrenFinder;
import com.amit.api.compiler.model.tools.InterfaceChildrenFinder;
import com.amit.api.compiler.model.tools.TypeCommonCompositeChildrenFinder;

/**
 * amit project
 */
public class Project {
	private UniqueCollection<Type> types = new UniqueCollection<Type>("type");
	private UniqueCollection<Module> modules = new UniqueCollection<Module>(
			"module");
	private UniqueCollection<Service> services = new UniqueCollection<Service>(
			"service");

	private List<Interface> interfaces = new ArrayList<Interface>();
	private List<TypeEnum> enums = new ArrayList<TypeEnum>();
	private List<TypeComposite> compositeTypes = new ArrayList<TypeComposite>();
	private List<TypeException> exceptionTypes = new ArrayList<TypeException>();

	private Module currentModule;
	private Module projectModule;

	private Map<String, Set<String>> compositeTypesChildren;
	private Map<String, Set<String>> exceptionTypesChildren;
	private Map<String, Set<String>> interfaceChildred;

	private Map<String, Set<String>> interfaceBaseInterfaces;

	public Project() {
		addPrimitiveTypes(PrimitiveTypeNames.ALL);
	}

	/**
	 * returns all services from the project
	 * 
	 * @return service list
	 */
	public List<Service> getServices() {
		return services.readonlyList();
	}

	/**
	 * returns all enums from the project
	 * 
	 * @return enum list
	 */
	public List<TypeEnum> getEnums() {
		return Collections.unmodifiableList(enums);
	}

	/**
	 * returns all interfaces from the project
	 * 
	 * @return interface list
	 */
	public List<Interface> getInterfaces() {
		return Collections.unmodifiableList(interfaces);
	}

	/**
	 * returns all the interface names inherited from the interface with name
	 * 
	 * @param name
	 *            interface name
	 * @return interface set
	 */
	public Set<String> getInterfaceChildren(String name) {
		Set<String> result = interfaceChildred.get(name);
		return result == null ? new HashSet<String>() : result;
	}

	/**
	 * returns interface all base interfaces names
	 * 
	 * @param name
	 *            interface name
	 * @return base name interface set
	 */
	public Set<String> getInterfaceBaseInterfaces(String name) {
		Set<String> result = interfaceBaseInterfaces.get(name);
		return result == null ? new HashSet<String>() : result;
	}

	/**
	 * returns all composite types from the project
	 * 
	 * @return type list
	 */
	public List<TypeComposite> getCompositeTypes() {
		return Collections.unmodifiableList(compositeTypes);
	}

	/**
	 * returns all types inherited from the composite type name
	 * 
	 * @param name
	 *            type name
	 * @return type name set
	 */
	public Set<String> getCompositeTypeChildren(String name) {
		Set<String> result = compositeTypesChildren.get(name);
		return result == null ? new HashSet<String>() : result;
	}

	/**
	 * returns all exceptions from the project
	 * 
	 * @return exception list
	 */
	public List<TypeException> getExceptions() {
		return Collections.unmodifiableList(exceptionTypes);
	}

	/**
	 * returns all the exception names inherited from the exception with name
	 * 
	 * @param name
	 *            exception name
	 * @return exception name set
	 */
	public Set<String> getExceptionTypeChildren(String name) {
		Set<String> result = exceptionTypesChildren.get(name);
		return result == null ? new HashSet<String>() : result;
	}

	/**
	 * returns all exception inherited from the exception names in the list
	 * including the names from the names list
	 * 
	 * @param names
	 *            exceptions names
	 * @return exception name set
	 */
	public Set<String> getExceptionTypeChildren(List<String> names) {
		Set<String> result = new HashSet<String>();
		for (String name : names) {
			result.add(name);
			result.addAll(getExceptionTypeChildren(name));
		}
		return result;
	}

	/**
	 * returns project module associated to the project only one module of this
	 * type can be per project
	 * 
	 * @return module module
	 */
	public Module getProjectModule() {
		return projectModule;
	}

	/**
	 * returns a type from the project by name
	 * 
	 * @param name
	 *            type name
	 * @return type
	 */
	public Type getType(String name) {
		return types.get(name);
	}

	/**
	 * returns true if the type is primitive
	 * 
	 * @param name
	 *            type name
	 * @return true or false
	 */
	public boolean isPrimitiveType(String name) {
		Type type = getType(name);

		if (type == null) {
			return false;
		}

		return type.getType().equals(Type.PRIMITIVE);
	}

	/**
	 * returns true if the type is enum
	 * 
	 * @param name
	 *            enum name
	 * @return true or false
	 */
	public boolean isEnumType(String name) {
		Type type = getType(name);

		if (type == null) {
			return false;
		}

		return type.getType().equals(Type.ENUM);
	}

	/**
	 * creates an enum type
	 * 
	 * @param name
	 *            enum name
	 * @param context
	 *            context
	 * @return enum created enum
	 * @throws ModuleElementException
	 *             throw on error
	 */
	public TypeEnum createEnum(String name, Context context)
			throws ModuleElementException {
		TypeEnum type = new TypeEnum(name, context, this);
		addEnum(type);
		return type;
	}

	/**
	 * creates a module
	 * 
	 * @param name
	 *            module name
	 * @param type
	 *            module type
	 * @param attr
	 *            attribute list
	 * @param context
	 *            context
	 * @return module created module
	 * @throws ModuleElementException
	 *             thrown on error
	 */
	public Module createModule(String name, ModuleType type,
			AttributeList attr, Context context) throws ModuleElementException {
		Module module = new Module(name, type, context, this);
		module.setAttributeList(attr);
		addModule(module);
		return module;
	}

	/**
	 * creates a composite type
	 * 
	 * @param name
	 *            type name
	 * @param attr
	 *            attribute list
	 * @param context
	 *            contexgt
	 * @return type return created type
	 * @throws ModuleElementException
	 *             thrown on error
	 */
	public TypeComposite createCompositeType(String name, AttributeList attr,
			Context context) throws ModuleElementException {
		TypeComposite type = new TypeComposite(name, context, this);
		type.setAttributeList(attr);
		addComposite(type);
		return type;
	}

	/**
	 * create an interface
	 * 
	 * @param name
	 *            interface name
	 * @param attr
	 *            attribute list
	 * @param context
	 *            context
	 * @return interface created interface
	 * @throws ModuleElementException
	 *             thrown exception
	 */
	public Interface createInterface(String name, AttributeList attr,
			Context context) throws ModuleElementException {
		Interface interf = new Interface(name, context, this);
		interf.setAttributeList(attr);
		addInterface(interf);
		return interf;
	}

	/**
	 * create an exception type
	 * 
	 * @param name
	 *            exception name
	 * @param attr
	 *            attribute list
	 * @param context
	 *            context
	 * @return exception created exception
	 * @throws ModuleElementException
	 *             thrown on error
	 */
	public TypeException createException(String name, AttributeList attr,
			Context context) throws ModuleElementException {
		TypeException exception = new TypeException(name, context, this);
		exception.setAttributeList(attr);
		addException(exception);
		return exception;
	}

	/**
	 * creates an service
	 * 
	 * @param name
	 *            service name
	 * @param attr
	 *            attribute list
	 * @param context
	 *            context
	 * @return service created service
	 * @throws ModuleElementException
	 *             thrown on error
	 */
	public Service createService(String name, AttributeList attr,
			Context context) throws ModuleElementException {
		Service service = new Service(name, context, this);
		service.setAttributeList(attr);
		addService(service);

		return service;
	}

	/**
	 * creates an attribute list
	 * 
	 * @return attribute list
	 */
	public AttributeList createAttributeList() {
		return new AttributeList(this);
	}

	/**
	 * create the function return element
	 * @param type
	 * @param isArray
	 * @param isMap
	 * @param context
	 * @return
	 */
	public FunctionReturn createFunctionReturn(String type, boolean isArray,
			boolean isMap, Context context) {
		return new FunctionReturn(type, isArray, isMap, context, this);
	}

	/**
	 * validates the project
	 * 
	 * @throws ModuleElementException
	 *             thrown on error
	 */
	public void validate() throws ModuleElementException {
		for (Module module : modules) {
			module.validate();
		}

		validateTypeCircularDependency(compositeTypes);
		validateTypeCircularDependency(exceptionTypes);
		validateInterfaceCircularDependency(interfaces);

		findCompositeTypesChildren();
		findExceptionTypesChildren();
		findInterfaceChildren();
		findInterfaceBaseChildren();
	}

	private void addComposite(TypeComposite type) {
		addType(type);
		compositeTypes.add(type);
	}

	private void addException(TypeException exception) {
		addType(exception);
		exceptionTypes.add(exception);
	}

	private void addEnum(TypeEnum type) {
		addType(type);
		enums.add(type);
	}

	private void addInterface(Interface interf) {
		addType(interf);
		interfaces.add(interf);
		currentModule.add(interf);
	}

	private void addType(Type type) {
		types.add(type);
		currentModule.add(type);
	}

	private void addService(Service service) {
		services.add(service);
		currentModule.add(service);
	}

	private void addModule(Module module) throws ModuleElementException {
		modules.add(module);
		currentModule = module;

		if (module.getType().equals(ModuleType.PROJECT)) {
			if (projectModule != null) {
				throw new ModuleElementException(
						"Project module can't be included", module);
			}

			projectModule = module;
		}
	}

	private void addPrimitiveTypes(String... names) {
		for (String name : names) {
			types.add(new TypePrimitive(name, this));
		}
	}

	private void validateTypeCircularDependency(
			List<? extends TypeCommonComposite> elements)
			throws ModuleElementException {
		Set<String> notCircularElements = new HashSet<String>();
		Set<String> circularElements = new HashSet<String>();

		int lastSize = -1;

		while (lastSize != notCircularElements.size()) {
			lastSize = notCircularElements.size();

			for (TypeCommonComposite element : elements) {
				if (notCircularElements.contains(element.getName())) {
					continue;
				}
				if (element.getBaseTypeName() == null) {
					notCircularElements.add(element.getName());
				} else {
					if (notCircularElements.contains(element.getBaseTypeName())) {
						notCircularElements.add(element.getName());
						circularElements.remove(element.getName());
					} else {
						circularElements.add(element.getName());
					}
				}
			}
		}

		if (circularElements.size() > 0) {
			StringBuffer sb = new StringBuffer();
			sb.append("Circular dependencies for types: ");
			for (String type : circularElements) {
				sb.append(type);
				sb.append(";");
			}

			throw new ModuleElementException(sb.toString(), null);
		}
	}

	private void validateInterfaceCircularDependency(List<Interface> elements)
			throws ModuleElementException {
		Set<String> notCircularElements = new HashSet<String>();
		Set<String> circularElements = new HashSet<String>();

		int lastSize = -1;

		while (lastSize != notCircularElements.size()) {
			lastSize = notCircularElements.size();

			for (Interface element : elements) {
				if (notCircularElements.contains(element.getName())) {
					continue;
				}

				if (element.getBaseInterfaceNames().size() <= 0) {
					notCircularElements.add(element.getName());
				} else {

					if (notCircularElements.containsAll(element
							.getBaseInterfaceNames())) {
						notCircularElements.add(element.getName());
						circularElements.remove(element.getName());
					} else {
						circularElements.add(element.getName());
					}
				}
			}
		}

		if (circularElements.size() > 0) {
			StringBuffer sb = new StringBuffer();
			sb.append("Circular dependencies for interfaces: ");
			for (String type : circularElements) {
				sb.append(type);
				sb.append(";");
			}

			throw new ModuleElementException(sb.toString(), null);
		}
	}

	private void findCompositeTypesChildren() {
		TypeCommonCompositeChildrenFinder finder = new TypeCommonCompositeChildrenFinder(
				compositeTypes);
		compositeTypesChildren = finder.getAllChildren();
	}

	private void findExceptionTypesChildren() {
		TypeCommonCompositeChildrenFinder finder = new TypeCommonCompositeChildrenFinder(
				exceptionTypes);
		exceptionTypesChildren = finder.getAllChildren();
	}

	private void findInterfaceChildren() {
		InterfaceChildrenFinder finder = new InterfaceChildrenFinder(interfaces);
		interfaceChildred = finder.getAllChildren();
	}

	private void findInterfaceBaseChildren() {
		InterfaceBaseChildrenFinder finder = new InterfaceBaseChildrenFinder(
				interfaces);
		interfaceBaseInterfaces = finder.getAllChildren();
	}
}
