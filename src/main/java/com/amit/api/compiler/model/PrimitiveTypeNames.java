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
 * the list of all primitive types supported by amit 
 */
final public class PrimitiveTypeNames {
	public static final String VOID = "void";
	public static final String BOOL = "boolean";
	public static final String INT = "int";
	public static final String LONG = "long";
	public static final String DOUBLE = "double";
	public static final String STRING = "string";
	public static final String DATETIME = "datetime";
	public static final String UUID = "uuid";
	
	public static final String[] ALL = {
		VOID,
		BOOL,
		INT,
		LONG,
		DOUBLE,
		STRING,
		DATETIME,
		UUID		
	};
}
