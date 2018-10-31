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

import static org.junit.Assert.assertNotNull;

import java.net.URISyntaxException;

import org.junit.Test;

import com.amit.api.compiler.model.Module;
import com.amit.api.compiler.model.ModuleElementException;
import com.amit.api.compiler.model.Project;
import com.amit.api.compiler.parser.AmitParser;
import com.amit.api.compiler.parser.TestBase;

public class ValidationCompositeTest extends TestBase {
	@Test
	public void notnull() throws Exception {
		AmitParser parser = AmitParser.fromFile(path("notnull.amit"));
		Project project = parser.parse();

		Module module = project.getProjectModule();
		assertNotNull(module);
	}

	@Test(expected=ModuleElementException.class)
	public void notempty() throws Exception {
		AmitParser parser = AmitParser.fromFile(path("notempty.amit"));
		parser.parse();
	}
	
	@Test(expected=ModuleElementException.class)
	public void range() throws Exception {
		AmitParser parser = AmitParser.fromFile(path("range.amit"));
		parser.parse();
	}

	@Test(expected=ModuleElementException.class)
	public void regex() throws Exception {
		AmitParser parser = AmitParser.fromFile(path("regex.amit"));
		parser.parse();
	}
	
	private String path(String name) throws URISyntaxException {
		return pathGlobal("parser/validation/composite/" + name);
	}
}
