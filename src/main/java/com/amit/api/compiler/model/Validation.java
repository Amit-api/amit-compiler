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

import java.util.List;

public class Validation extends ProjectElement {
	private String typeName;
	private ValidationFieldConditionList fieldConfitions = new ValidationFieldConditionList();

	protected Validation(String name, Context context, Project project) {
		super(name, context, project);
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public List<ValidationFieldCondition> getFieldConditions() {
		return fieldConfitions.values();
	}

	@Override
	public void validate() throws ModuleElementException {
		super.validate();

		validateType(typeName, Type.COMPOSITE);

		TypeComposite type = (TypeComposite) getProject().getType(typeName);

		for (ValidationFieldCondition v : fieldConfitions.values()) {
			v.validateMember(type);
		}
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
}
