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

public class ValidationFieldCondition extends ProjectElement {
	private final List<ValidationCondition> conditions = new ArrayList<ValidationCondition>();
	private final Set<ValidationConditionType> conditionTypes = new HashSet<ValidationConditionType>();
	private final boolean isArray;
	private final boolean isMap;

	protected ValidationFieldCondition(String name, boolean isMap,
			boolean isArray, Context context, Project project) {
		super(name, context, project);
		this.isMap = isMap;
		this.isArray = isArray;
	}

	public ValidationFieldCondition notNull(Context context) {
		addCondition(new ValidationCondition(getName(), context, getProject(),
				ValidationConditionType.NOT_NULL, null));
		return this;
	}

	public ValidationFieldCondition notEmpty(Context context) {
		addCondition(new ValidationCondition(getName(), context, getProject(),
				ValidationConditionType.NOT_EMPTY, null));
		return this;
	}

	public ValidationFieldCondition biggerOrEq(String value, Context context) {
		addCondition(new ValidationCondition(getName(), context, getProject(),
				ValidationConditionType.BIGGER_OR_EQ, value));
		return this;
	}

	public ValidationFieldCondition smallerOrEq(String value, Context context) {
		addCondition(new ValidationCondition(getName(), context, getProject(),
				ValidationConditionType.SMALLER_OR_EQ, value));
		return this;
	}

	public ValidationFieldCondition regex(String expression, Context context) {
		addCondition(new ValidationCondition(getName(), context, getProject(),
				ValidationConditionType.REGEX, expression));
		return this;
	}

	public List<ValidationCondition> getConditions() {
		List<ValidationCondition> result = new ArrayList<ValidationCondition>(
				conditions);
		Collections.sort(result, (a, b) -> a.getType().compareTo(b.getType()));
		return Collections.unmodifiableList(result);
	}

	public boolean isArray() {
		return isArray;
	}

	public boolean isMap() {
		return isMap;
	}

	public boolean isValidationName() {
		return conditions.isEmpty();
	}

	protected void validateMember(TypeComposite type) {
		if (conditions.isEmpty()) {
			throw new ModuleElementException("expected a condition", this);
		}

		TypeCompositeMember member = type.getMember(getName());

		if (member == null) {
			throw new ModuleElementException(String.format(
					"'%s' expected a member from the type '%s'", getName(),
					type.getName()), this);
		}

		validateConditions(member);
	}

	protected void validateMember(Function function) {
		if (isValidationName()) {
			validateValidator(getName());
		} else {
			FunctionArgument arg = function.getArgument(getName());
			if (arg == null) {
				throw new ModuleElementException(String.format(
						"'%s' expected an argument from the function '%s'",
						getName(), function.getName()), this);
			}

			validateConditions(arg);
		}
	}

	private void addCondition(ValidationCondition condition) {
		if (conditionTypes.contains(condition.getType())) {
			throw new ModuleElementException(
					String.format(
							"only one condition '%s' can be used in the validation expression",
							condition.getType()), condition);
		}

		conditions.add(condition);
		conditionTypes.add(condition.getType());
	}

	private void validateConditions(TypedItem typedItem) {
		for (ValidationCondition condition : conditions) {
			condition.validateCondition(typedItem, isArray || isMap);
		}
	}
}
