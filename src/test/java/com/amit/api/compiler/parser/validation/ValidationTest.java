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
package com.amit.api.compiler.parser.validation;

import static org.junit.Assert.*;

import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

import com.amit.api.compiler.model.Function;
import com.amit.api.compiler.model.Interface;
import com.amit.api.compiler.model.Module;
import com.amit.api.compiler.model.ModuleElementException;
import com.amit.api.compiler.model.Project;
import com.amit.api.compiler.parser.AmitParser;
import com.amit.api.compiler.parser.TestBase;

public class ValidationTest extends TestBase {
	@Test
	public void tesValidators() throws Exception {
		AmitParser parser = AmitParser.fromFile(path("validation.amit"));
		Project project = parser.parse();

		Module module = project.getProjectModule();

		assertNotNull(module);
	}

	@Test(expected = ModuleElementException.class)
	public void tesValidatorsExpectedCompositeType() throws Exception {
		AmitParser parser = AmitParser
				.fromFile(path("validator_exp_composite.amit"));
		parser.parse();
	}

	@Test(expected = ModuleElementException.class)
	public void tesValidatorsExpectedCompositeTypeMember() throws Exception {
		AmitParser parser = AmitParser
				.fromFile(path("validator_expected_comptype_member.amit"));
		parser.parse();
	}

	@Test(expected = ModuleElementException.class)
	public void tesValidatorsExpectedValidator() throws Exception {
		AmitParser parser = AmitParser
				.fromFile(path("validate_expected_validator.amit"));
		parser.parse();
	}

	@Test(expected = ModuleElementException.class)
	public void tesValidatorsExpectedFunctArg() throws Exception {
		AmitParser parser = AmitParser
				.fromFile(path("validate_expected_func_arg.amit"));
		parser.parse();
	}

	@Test
	public void testFunctionTypesToValidate() throws Exception {
		AmitParser parser = AmitParser
				.fromFile(path("validation_types_to_validate.amit"));
		Project project = parser.parse();

		Interface interface_test = project.getInterface("test");
		assertNotNull(interface_test);

		Function f_no_validation = interface_test
				.getFunction("f_no_validation");
		assertNotNull(f_no_validation);

		Set<String> t1 = f_no_validation.getTypesToValidate();
		assertTrue(t1.isEmpty());

		Function f_with_validation_circular = interface_test
				.getFunction("f_with_validation_circular");
		assertNotNull(f_with_validation_circular);

		Set<String> t2 = f_with_validation_circular.getTypesToValidate();
		assertEquals(new HashSet<String>(Arrays.asList("A", "B", "C", "D")), t2);

		Function f_with_validation_simple = interface_test
				.getFunction("f_with_validation_simple");
		assertNotNull(f_with_validation_simple);

		Set<String> t3 = f_with_validation_simple.getTypesToValidate();
		assertEquals(new HashSet<String>(Arrays.asList("A", "E")), t3);

		Function f_with_validation_single = interface_test
				.getFunction("f_with_validation_single");
		assertNotNull(f_with_validation_single);

		Set<String> t4 = f_with_validation_single.getTypesToValidate();
		assertEquals(new HashSet<String>(Arrays.asList("A", "B", "F")), t4);

	}

	private String path(String name) throws URISyntaxException {
		return pathGlobal("parser/validation/" + name);
	}
}
