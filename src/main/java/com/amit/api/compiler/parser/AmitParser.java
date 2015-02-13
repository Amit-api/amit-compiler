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
package com.amit.api.compiler.parser;

import java.io.IOException;

import org.antlr.runtime.ANTLRFileStream;
import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CharStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;

import com.amit.api.compiler.model.Project;

/**
 * Amit Parser based on ANTLR  
 *
 */
public class AmitParser {
	private CharStream stream;
	
	/**
	 * creates the Amit parser for a string
	 * @param text
	 * @return
	 * @throws IllegalArgumentException
	 */
	public static AmitParser fromString( String text ) throws IllegalArgumentException {
		if( text == null ) {
			throw new IllegalArgumentException( "text must be not null" );
		}
		
		return new AmitParser( new ANTLRStringStream( text ) );
	}
		
	/**
	 * creates the Amit parser for a file
	 * @param fileName
	 * @return
	 * @throws IllegalArgumentException
	 * @throws IOException
	 */
	public static AmitParser fromFile( String fileName ) throws IllegalArgumentException, IOException {
		if( fileName == null ) {
			throw new IllegalArgumentException( "fileName must be not null" );
		}
		
		return new AmitParser( new ANTLRFileStream( fileName, "UTF8" ) );		
	}
	
	private AmitParser( CharStream stream ) {
		if( stream == null ) {
			throw new IllegalArgumentException( "stream must be not null" );			
		}
		this.stream = stream;
	}
	
	/**
	 * parsers the Amit content and returns the resulted module
	 * @return
	 * @throws RecognitionException 
	 */
	public Project parse() throws RecognitionException {
		apiLexer lexer = new apiLexer( stream );
		CommonTokenStream tokens = new CommonTokenStream( lexer );

		apiParser g = new apiParser( tokens, null );
		
		Project module = new Project();
		g.start( module );
		
		return module;
	}
}
