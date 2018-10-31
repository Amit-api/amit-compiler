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

/**
 * A project element is an entity in the project the entity belongs to the
 * project has a name and may contain attributes
 */
public class ProjectElement {
	private String name;
	private Context context;
	private AttributeList attributes;
	private Project project;

	/**
	 * creates the project element
	 * 
	 * @param name
	 *            the element name
	 * @param context
	 *            parsing context
	 * @param project
	 *            the owner project
	 */
	protected ProjectElement(String name, Context context, Project project) {
		if (name == null || name.isEmpty()) {
			throw new IllegalArgumentException("type must be not null or empty");
		}
		if (project == null) {
			throw new IllegalArgumentException("project must be not null");
		}

		this.name = name;
		this.context = context;
		this.project = project;
	}

	/**
	 * returns the project element belongs to
	 * 
	 * @return owner project
	 */
	public Project getProject() {
		return project;
	}

	/**
	 * returns the element name
	 * 
	 * @return element name
	 */
	public String getName() {
		return name;
	}

	/**
	 * returns the element context
	 * 
	 * @return element context
	 */
	public Context getContext() {
		return context;
	}

	/**
	 * sets the element attributes
	 * 
	 * @param attributes
	 *            attribute list
	 */
	public void setAttributeList(AttributeList attributes) {
		if (attributes != null) {
			if (attributes.getProject() != this.project) {
				throw new IllegalArgumentException(
						"the attribute list must belong to this project");
			}
		}
		this.attributes = attributes;
	}

	/**
	 * returns the element attributes
	 * 
	 * @return attribute list
	 */
	public AttributeList getAttributes() {
		return attributes;
	}

	/**
	 * returns the attribute value associated to the element
	 * 
	 * @param name
	 *            attribute name
	 * @return attribute value
	 */
	public String getAttributeValue(String name) {
		return attributes.get(name);
	}

	/**
	 * returns attribute value associated to the element if there is no
	 * attribute was find the defaultValue is returned
	 * 
	 * @param name
	 *            attribute name
	 * @param defaultValue
	 *            value returned if attribute is not present
	 * @return attribute value
	 */
	public String getAttributeValue(String name, String defaultValue) {
		String attr = attributes.get(name);

		return attr == null ? defaultValue : attr;
	}

	/**
	 * validates the project element if the validation fails the exception is
	 * thrown
	 * 
	 * @throws ModuleElementException
	 *             thrown when validation fails
	 */
	public void validate() throws ModuleElementException {
	}

	/**
	 * creates the AttributeList which can be used in the project that elements
	 * belongs to
	 * 
	 * @return attribute list
	 */
	public AttributeList createAttributeList() {
		return project.createAttributeList();
	}

	/**
	 * validates if the interface exist
	 * 
	 * @param interfaceName
	 */
	protected void validateInterface(String interfaceName) {
		Interface intr = project.getInterface(interfaceName);
		if (intr == null) {
			throw new ModuleElementException("unknown interface", this);
		}
	}

	/**
	 * validates if validator exists
	 * 
	 * @param validatorName
	 */
	protected void validateValidator(String validatorName) {
		Validation validator = project.getValidation(validatorName);
		if (validator == null) {
			throw new ModuleElementException("unknown validation", this);
		}
	}

	/**
	 * validates if the typeName has acceptedTypeTypes otherwise the exception
	 * is thrown
	 * 
	 * @param typeName
	 *            type to be verified
	 * @param acceptedTypeTypes
	 *            list of accepted types
	 * @throws ModuleElementException
	 *             thrown is validation fails
	 */
	protected void validateType(String typeName, String... acceptedTypeTypes)
			throws ModuleElementException {
		Type type = project.getType(typeName);
		if (type == null) {
			throw new ModuleElementException(String.format("unknown type '%s'",
					typeName), this);
		}

		for (String typeType : acceptedTypeTypes) {
			if (type.getType().equals(typeType)) {
				return;
			}
		}

		throw new ModuleElementException(
				String.format("unsuported type '%s' which is '%s' ", typeName,
						type.getType()), this);
	}
}
