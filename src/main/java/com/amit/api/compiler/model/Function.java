/******************************************************************************
 * Copyright 2014-2018 Alexandru Motriuc                                     *
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

import com.amit.api.compiler.model.tools.ValidatorChildrenFinder;

/**
 * a function : returnType FunctionName( function args ) throws exceptions;
 */
public class Function extends ProjectElement {
	private final UniqueCollection<FunctionArgument> arguments = new UniqueCollection<FunctionArgument>(
			"argument");
	private FunctionReturn returnType;
	private final Set<String> throwsExceptions = new HashSet<String>();
	private final List<String> throwsExceptionsList = new ArrayList<String>();
	private ValidationFieldConditionList fieldConfitions = new ValidationFieldConditionList();
	private final Interface intr;

	protected Function(String name, Context context, Interface intr,
			Project project) {
		super(name, context, project);
		this.intr = intr;
	}

	/**
	 * returns the function interface
	 * 
	 * @return
	 */
	public Interface getInterface() {
		return intr;
	}

	/**
	 * returns function arguments
	 * 
	 * @return argument list
	 */
	public List<FunctionArgument> getArguments() {
		return arguments.readonlyList();
	}

	/**
	 * get function return type
	 * 
	 * @return return type
	 */
	public FunctionReturn getReturn() {
		return returnType;
	}

	/**
	 * return the argument conditions
	 * 
	 * @return
	 */
	public List<ValidationFieldCondition> getArgumentConditions() {
		return fieldConfitions.values();
	}

	/**
	 * returns throws exception name list
	 * 
	 * @return exception name list
	 */
	public List<String> getThrowsExceptionNames() {
		return Collections.unmodifiableList(throwsExceptionsList);
	}

	/**
	 * returns all the types required to be validated
	 * 
	 * @return
	 */
	public Set<String> getTypesToValidate() {
		Set<String> validationTypes = fieldConfitions
				.getValidationTypes(getProject());
		ValidatorChildrenFinder finder = new ValidatorChildrenFinder(
				getArguments(), validationTypes);
		return finder.result();
	}

	/**
	 * returns all the validations for the type
	 * 
	 * @param typeName
	 * @return
	 */
	public List<Validation> getValidationsForTypeName(String typeName) {
		Set<String> validationNames = fieldConfitions.getValidationNames();
		Set<String> children = getProject().getCompositeTypeChildren(typeName);
		children.add(typeName);
		List<Validation> result = new ArrayList<Validation>();
		for (String validationName : validationNames) {
			Validation validation = getProject().getValidation(validationName);
			if (children.contains(validation.getTypeName())) {
				result.add(validation);
			}
		}
		return result;
	}

	/**
	 * creates a field validation condition
	 * 
	 * @param name
	 * @param isMap
	 * @param isArray
	 * @param context
	 * @return
	 */
	public ValidationFieldCondition createValidationFieldCondition(String name,
			boolean isMap, boolean isArray, Context context) {
		return fieldConfitions.add(new ValidationFieldCondition(name, isMap,
				isArray, context, getProject()));
	}

	/**
	 * returns the argument
	 * 
	 * @param argumentName
	 * @return
	 */
	public FunctionArgument getArgument(String argumentName) {
		return arguments.get(argumentName);
	}

	/**
	 * create a function argument
	 * 
	 * @param type
	 * @param name
	 * @param isMap
	 * @param isArray
	 * @param attr
	 * @param context
	 * @return
	 */
	public FunctionArgument createArgument(String type, String name,
			boolean isArray, boolean isMap, AttributeList attr, Context context) {

		FunctionArgument arg = new FunctionArgument(type, name, isArray, isMap,
				context, getProject());
		arg.setAttributeList(attr);

		arguments.add(arg);
		return arg;
	}

	/**
	 * set function return type
	 * 
	 * @param returnType
	 *            return type
	 */
	public void setReturn(FunctionReturn returnType) {
		if (returnType.getProject() != this.getProject()) {
			throw new IllegalArgumentException(
					"the return type must belong to the project");
		}

		this.returnType = returnType;
	}

	/**
	 * adds throws exception
	 * 
	 * @param exceptionName
	 *            exception name
	 */
	public void addThrowsException(String exceptionName) {
		if (exceptionName == null || exceptionName.isEmpty()) {
			throw new IllegalArgumentException(
					"exceptionName must be not null or empty");
		}

		if (throwsExceptions.contains(exceptionName)) {
			throw new ModuleElementException(String.format(
					"duplicate throws exception for name '%s'", exceptionName),
					this);
		}

		throwsExceptions.add(exceptionName);
		throwsExceptionsList.add(exceptionName);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void validate() throws ModuleElementException {
		super.validate();
		validateArgs();
		validateExceptions();
		validateValidation();
	}

	private void validateValidation() throws ModuleElementException {
		for (ValidationFieldCondition cond : fieldConfitions.values()) {
			cond.validateMember(this);
		}
	}

	private void validateArgs() throws ModuleElementException {
		returnType.validate();
		for (FunctionArgument arg : arguments) {
			arg.validate();
		}
	}

	private void validateExceptions() throws ModuleElementException {
		for (String exception : throwsExceptionsList) {
			validateType(exception, Type.EXCEPTION);
		}
	}
}
