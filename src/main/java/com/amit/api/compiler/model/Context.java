/******************************************************************************
 * Copyright 20014-2015 Alexandru Motriuc                                     *
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

import org.antlr.runtime.Token;

public class Context {
	private int lineNumber;
	private int positionInLine;
	
	public Context( Token token ) {
		if( token == null ) {
			throw new IllegalArgumentException( "token must be not null" );
		}
		
		this.lineNumber = token.getLine();
		this.positionInLine = token.getCharPositionInLine();
	}
	
	/**
	 * returns line number in the file
	 * @return
	 */
	public int getLineNumber() {
		return lineNumber;
	}
	
	/**
	 * returns position in line
	 * @return
	 */
	public int getPositionInLine() {
		return positionInLine;
	}
}
