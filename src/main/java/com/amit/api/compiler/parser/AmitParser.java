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

import java.io.IOException;

import org.antlr.runtime.ANTLRFileStream;
import org.antlr.runtime.ANTLRInputStream;
import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CharStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;

import com.amit.api.compiler.model.ModuleElementException;
import com.amit.api.compiler.model.Project;

/**
 * Amit Parser based on ANTLR  
 *
 */
public class AmitParser {
	private CharStream stream;
	
	/**
	 * creates the Amit parser for a string
	 * @param text amit text
	 * @return returns amit parser
	 * @throws IllegalArgumentException thrown on error
	 */
	public static AmitParser fromString( String text ) throws IllegalArgumentException {
		if( text == null ) {
			throw new IllegalArgumentException( "text must be not null" );
		}
		
		return new AmitParser( new ANTLRStringStream( text ) );
	}
	
	/**
	 * creates a amit parser from a jar file
	 * @param classFromJar a class from the jar
	 * @param jarFilePath path in the jar
	 * @return amit parser
	 * @throws ClassNotFoundException thrown on classFromJar not found
	 * @throws IOException thrown on IO error
	 */
	public static AmitParser fromJar( String classFromJar, String jarFilePath ) throws ClassNotFoundException, IOException {
		if( classFromJar == null ) {
			throw new IllegalArgumentException( "classFromJar must be not null" );
		}
		
		if( jarFilePath == null ) {
			throw new IllegalArgumentException( "jarFilePath must be not null" );			
		}

		return new AmitParser( new ANTLRInputStream(
			Class.forName( classFromJar ).getClassLoader().getResourceAsStream( jarFilePath )));
	}
		
	/**
	 * creates the Amit parser for a file
	 * @param fileName file name
	 * @return amit parser
	 * @throws IllegalArgumentException thrown on invalid args
	 * @throws IOException thrown on IO error
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
	 * parsers the Amit content and returns the resulted project
	 * @return project
	 * @throws RecognitionException thrown on parse error
	 * @throws ModuleElementException thrown on parse error
	 */
	public Project parse() throws RecognitionException, ModuleElementException {
		apiLexer lexer = new apiLexer( stream );
		CommonTokenStream tokens = new CommonTokenStream( lexer );

		apiParser g = new apiParser( tokens, null );
		
		Project project = new Project();
		g.start( project );
		
		project.validate();
		
		return project;
	}
}
