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

public class ValidationCondition extends ProjectElement {
	private final ValidationConditionType type;
	private final String value;

	protected ValidationCondition(String name, Context context,
			Project project, ValidationConditionType type, String value) {
		super(name, context, project);
		this.type = type;
		this.value = value;
	}

	public ValidationConditionType getType() {
		return type;
	}

	public String getValue() {
		return value;
	}

	public void validateCondition(TypedItem typedItem, boolean isElement) {
		validateElementModifier(typedItem, isElement);

		String typeName = typedItem.getTypeName();

		switch (type) {
		case NOT_NULL:
			return;
		case NOT_EMPTY:
			if (typedItem.isArray() || typedItem.isMap()) {
				if (!isElement) {
					return;
				}
			}
			if (typeName.equals(PrimitiveTypeNames.STRING)) {
				return;
			}
			break;

		case SMALLER_OR_EQ:
		case BIGGER_OR_EQ:
			if (typedItem.isArray() || typedItem.isMap()) {
				if (!isElement) {
					return;
				}
			}

			if (typeName.equals(PrimitiveTypeNames.STRING)
					|| typeName.equals(PrimitiveTypeNames.INT)
					|| typeName.equals(PrimitiveTypeNames.LONG)) {
				return;
			}
			break;

		case REGEX:
			if (typedItem.isArray() || typedItem.isMap()) {
				if (!isElement) {
					break;
				}
			}
			
			if (typeName.equals(PrimitiveTypeNames.STRING)) {
				return;
			}

			break;
		default:
			throw new UnsupportedOperationException();
		}

		throw new ModuleElementException(String.format(
				"unsuported condition %s for the type:%s%s %s %s", type,
				typedItem.isArray() ? " array" : "", typedItem.isMap() ? " map"
						: "", typedItem.getTypeName(), isElement ? "element"
						: ""), this);
	}

	private void validateElementModifier(TypedItem typedItem, boolean isElement) {
		if (!typedItem.isArray() && !typedItem.isMap() && isElement) {
			throw new ModuleElementException(
					String.format(
							"unsuported modifier [] or {} modifier for element %s for the type:%s%s %s",
							type, typedItem.isArray() ? " array" : "",
							typedItem.isMap() ? " map" : "",
							typedItem.getTypeName()), this);
		}
	}

}
