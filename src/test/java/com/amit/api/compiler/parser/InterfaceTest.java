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

import static org.junit.Assert.*;

import java.net.URISyntaxException;
import java.util.HashSet;

import org.junit.Test;

import com.amit.api.compiler.model.Function;
import com.amit.api.compiler.model.FunctionArgument;
import com.amit.api.compiler.model.Interface;
import com.amit.api.compiler.model.ModuleElementException;
import com.amit.api.compiler.model.Project;

public class InterfaceTest extends TestBase {

	@Test
	public void testSimpe() throws Exception {
		AmitParser parser = AmitParser.fromFile( path( "int-simple.amit" ) );
		Project project = parser.parse();
		
		assertEquals( 1, project.getInterfaces().size() );
		
		Interface interf = project.getInterfaces().get( 0 );
	
		assertEquals( "ICall", interf.getName() );
		assertEquals( "hello", interf.getAttributeValue( "path" ) );
		
		assertEquals( 1, interf.getFunctions().size() );
		
		Function fun = interf.getFunctions().get( 0 );
		assertEquals( "fun", fun.getName() );
		assertEquals( "do something", fun.getAttributeValue( "public_name" ) );
		assertEquals( 0, fun.getArguments().size() );
		assertEquals( "void", fun.getReturn().getTypeName() );
		assertEquals( "*return*", fun.getReturn().getName() );
		assertFalse( fun.getReturn().isArray() );
	}
	
	@Test
	public void testArgAttributes() throws Exception {
		AmitParser parser = AmitParser.fromFile( path( "int-arg-attr.amit" ) );
		Project project = parser.parse();
		
		assertEquals( 1, project.getInterfaces().size() );
		
		Interface interf = project.getInterfaces().get( 0 );
		
		assertEquals( 2, interf.getFunctions().size() );
		
		Function fun = interf.getFunctions().get( 0 );
		assertEquals( "doStuf", fun.getName() );
		assertEquals( "int", fun.getReturn().getTypeName() );	
		assertEquals( 2, fun.getArguments().size() );
		
		FunctionArgument arg = fun.getArguments().get( 0 );
		assertEquals( "p1", arg.getName() );
		assertEquals( "int", arg.getTypeName() );
		assertEquals( "unknown", arg.getAttributeValue( "public_name" ) );

		arg = fun.getArguments().get( 1 );
		assertEquals( "p2", arg.getName() );
		assertEquals( "string", arg.getTypeName() );
		assertEquals( "i whish i knew", arg.getAttributeValue( "public_name" ) );
		
		fun = interf.getFunctions().get( 1 );
		assertEquals( "doMoreStuf", fun.getName() );
		assertEquals( "string", fun.getReturn().getTypeName() );
		assertEquals( 1, fun.getArguments().size() );
		
		arg = fun.getArguments().get( 0 );
		assertEquals( "input", arg.getName() );
		assertEquals( "int", arg.getTypeName() );		
	}
	
	@Test
	public void testInheritance() throws Exception {
		AmitParser parser = AmitParser.fromFile( path( "int-inheritance.amit" ) );
		Project project = parser.parse();
		
		assertEquals( 3, project.getInterfaces().size() );
		
		Interface interf = project.getInterfaces().get( 0 );
		assertEquals( "IntA", interf.getName() );
		assertEquals( 0, interf.getBaseInterfaceNames().size() );
	
		interf = project.getInterfaces().get( 1 );
		assertEquals( "IntB", interf.getName() );
		assertEquals( 0, interf.getBaseInterfaceNames().size() );

		interf = project.getInterfaces().get( 2 );
		assertEquals( "IntC", interf.getName() );
		assertEquals( 2, interf.getBaseInterfaceNames().size() );
		assertEquals( "IntA", interf.getBaseInterfaceNames().get( 0 ) );
		assertEquals( "IntB", interf.getBaseInterfaceNames().get( 1 ) );
	}

	@Test
	public void testExceptions() throws Exception {
		AmitParser parser = AmitParser.fromFile( path( "int-except.amit" ) );
		Project project = parser.parse();
		
		assertEquals( 1, project.getInterfaces().size() );
		
		Interface interf = project.getInterfaces().get( 0 );
		assertEquals( "ICall", interf.getName() );
		assertEquals( 0, interf.getBaseInterfaceNames().size() );
		assertEquals( 1, interf.getFunctions().size() );
		
		Function fun = interf.getFunctions().get( 0 );
		assertEquals( "doStuf", fun.getName() );
		assertEquals( "void", fun.getReturn().getTypeName() );
		assertEquals( 2, fun.getThrowsExceptionNames().size() );
		assertEquals( "Exception1", fun.getThrowsExceptionNames().get( 0 ) );
		assertEquals( "Exception2", fun.getThrowsExceptionNames().get( 1 ) );
	}

	@Test
	public void testArgModifiers() throws Exception {
		AmitParser parser = AmitParser.fromFile( path( "int-arg-modifiers.amit" ) );
		Project project = parser.parse();
		
		assertEquals( 1, project.getInterfaces().size() );
		
		Interface interf = project.getInterfaces().get( 0 );
		assertEquals( "ITest", interf.getName() );
		assertEquals( 0, interf.getBaseInterfaceNames().size() );
		assertEquals( 1, interf.getFunctions().size() );
		
		Function fun = interf.getFunctions().get( 0 );
		assertEquals( "doStuf", fun.getName() );
		
		assertEquals( 3, fun.getArguments().size() );

		FunctionArgument arg = fun.getArguments().get( 0 );
		assertEquals( "int", arg.getTypeName() );
		assertEquals( "a", arg.getName() );
		assertFalse( arg.isArray() );
		assertFalse( arg.isRequired() );

		arg = fun.getArguments().get( 1 );
		assertEquals( "int", arg.getTypeName() );
		assertEquals( "c", arg.getName() );
		assertFalse( arg.isArray() );
		assertTrue( arg.isRequired() );
		
		arg = fun.getArguments().get( 2 );
		assertEquals( "int", arg.getTypeName() );
		assertEquals( "d", arg.getName() );
		assertTrue( arg.isArray() );
		assertFalse( arg.isRequired() );
	}
	
	@SuppressWarnings("serial")
	@Test
	public void testDependency() throws Exception {
		AmitParser parser = AmitParser.fromFile( path( "int-dep.amit" ) );
		Project project = parser.parse();
	
		assertEquals( new HashSet<String>(), project.getInterfaceBaseInterfaces( "I1" ) );
		assertEquals( new HashSet<String>(), project.getInterfaceBaseInterfaces( "I2" ) );
		assertEquals( new HashSet<String>(){{add("I1");}}, project.getInterfaceBaseInterfaces( "I3" ) );
		assertEquals( new HashSet<String>(){{add("I1");add("I2");add("I3");}}, project.getInterfaceBaseInterfaces( "I4" ) );
		assertEquals( new HashSet<String>(){{add("I1");add("I2");add("I3");add("I4");}}, project.getInterfaceBaseInterfaces( "I5" ) );
		
		assertEquals( new HashSet<String>(), project.getInterfaceChildren( "I5" ) );
		assertEquals( new HashSet<String>(){{add("I5");}}, project.getInterfaceChildren( "I4" ) );
		assertEquals( new HashSet<String>(){{add("I5");add("I4");}}, project.getInterfaceChildren( "I3" ) );
		assertEquals( new HashSet<String>(){{add("I5");add("I4");}}, project.getInterfaceChildren( "I2" ) );
		assertEquals( new HashSet<String>(){{add("I5");add("I4");add("I3");}}, project.getInterfaceChildren( "I1" ) );	
	}
	
	@Test( expected = ModuleElementException.class )
	public void testBadBaseType() throws Exception {
		AmitParser parser = AmitParser.fromFile( path( "int-bad-base-type.amit" ) );
		parser.parse();
	}

	@Test( expected = ModuleElementException.class )
	public void testCircularBaseType() throws Exception {
		AmitParser parser = AmitParser.fromFile( path( "int-circular.amit" ) );
		parser.parse();
	}
	
	@Test( expected = ModuleElementException.class )
	public void testBadException() throws Exception {
		AmitParser parser = AmitParser.fromFile( path( "int-bad-exception.amit" ) );
		parser.parse();
	}
	
	@Test( expected = ModuleElementException.class )
	public void testUnknowException() throws Exception {
		AmitParser parser = AmitParser.fromFile( path( "int-unknown-exception.amit" ) );
		parser.parse();
	}
	
	private String path( String name ) throws URISyntaxException {
		return pathGlobal( "parser/interface/" + name );
	}	
}
