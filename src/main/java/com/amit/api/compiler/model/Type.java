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
 * the base class for all Amit types
 */
public class Type extends ProjectElement {
	/**
	 * type names
	 */
	protected final static String ENUM = "enum";
	protected final static String COMPOSITE = "type";
	protected final static String EXCEPTION = "exception";
	protected final static String PRIMITIVE = "primitive";

	private String type;

	/**
	 * creates a new type
	 * 
	 * @param type
	 *            type type
	 * @param name
	 *            type name
	 * @param context
	 *            context
	 * @param project
	 *            project
	 */
	protected Type(String type, String name, Context context, Project project) {
		super(name, context, project);

		if (type == null || type.isEmpty()) {
			throw new IllegalArgumentException("type must be not null or empty");
		}

		this.type = type;
	}

	/**
	 * returns the type of the type
	 * 
	 * @return type of the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * returns true if the type is composite
	 * 
	 * @return
	 */
	public boolean isComposite() {
		return getType().equals(COMPOSITE);
	}
}
