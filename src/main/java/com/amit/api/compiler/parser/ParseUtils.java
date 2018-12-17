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
package com.amit.api.compiler.parser;

public final class ParseUtils {

	/**
	 * parses string from parser format to string format
	 * @param str string
	 * @return string
	 */
	public static String parseString( String str ) {
		return str.substring( 1, str.length() - 1 ).replace("\\\"", "\"").replace("\\\\", "\\" );
	}
	
	/**
	 * parses int number to a string
	 * @param str string
	 * @return integer
	 */
	public static Integer parseNumber( String str ) {
		if( str.startsWith( "0x" ) ) {
			return Integer.parseInt( str.substring( 2 ), 16 ); 
		} else {
			return Integer.valueOf( str );
		}
	}
}
