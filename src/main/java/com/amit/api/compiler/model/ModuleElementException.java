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

public class ModuleElementException extends IllegalArgumentException {
	private static final long serialVersionUID = 1L;

	private ProjectElement element;

	public ModuleElementException(String message, ProjectElement element) {
		super(message);
		this.element = element;
	}

	public ProjectElement getModuleElement() {
		return element;
	}

	@Override
	public String getMessage() {
		StringBuilder sb = new StringBuilder();
		if (element != null) {
			if (element.getContext() != null) {
				sb.append("line(");
				sb.append(element.getContext().getLineNumber());
				sb.append(":");
				sb.append(element.getContext().getPositionInLine());
				sb.append(") ");
			}
			sb.append("at element <");
			sb.append(element.getName());
			sb.append("> ");
		}
		sb.append("error: ");
		sb.append(super.getMessage());

		return sb.toString();
	}
}
