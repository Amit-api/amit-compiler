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
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

class ValidationFieldConditionList {
	private Map<String, ValidationFieldCondition> conditionsIndex = new HashMap<String, ValidationFieldCondition>();

	/**
	 * add the condition
	 * 
	 * @param condition
	 * @return
	 */
	public ValidationFieldCondition add(ValidationFieldCondition condition) {
		String id = String.format("%s-%s.%s", condition.getName(),
				condition.isArray(), condition.isMap());
		ValidationFieldCondition result = conditionsIndex.get(id);
		if (result == null) {
			result = condition;
			conditionsIndex.put(id, result);
		}

		return result;
	}

	/**
	 * return the values
	 * 
	 * @return
	 */
	public List<ValidationFieldCondition> values() {
		List<ValidationFieldCondition> result = new ArrayList<ValidationFieldCondition>(
				conditionsIndex.values());
		Collections.sort(result, (a, b) -> {
			int r = a.getName().compareTo(b.getName());
			if (r == 0) {
				r = sortId(a) - sortId(b);
			}
			return r;
		});

		return Collections.unmodifiableList(result);
	}

	/**
	 * return the validation names
	 * @return
	 */
	public Set<String> getValidationNames() {
		Set<String> result = new HashSet<String>();
		for (ValidationFieldCondition cond : conditionsIndex.values()) {
			if (cond.isValidationName()) {
				result.add(cond.getName());
			}
		}

		return result;
	}
	
	/**
	 * returns the validations type names
	 * @param project
	 * @return
	 */
	public Set<String> getValidationTypes(Project project) {
		Set<String> result = new HashSet<String>();

		Set<String> validations = getValidationNames();
		for(String validationName: validations) {
			Validation validation = project.getValidation(validationName);
			result.add(validation.getTypeName());
		}
		
		return result;
	}

	private static final int sortId(ValidationFieldCondition r) {
		return (r.isArray() ? 1 : 0) + (r.isMap() ? 2 : 0);
	}
}
