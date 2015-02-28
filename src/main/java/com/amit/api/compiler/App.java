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
package com.amit.api.compiler;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.GnuParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

import com.amit.api.compiler.generator.CodeGenerator;
import com.amit.api.compiler.model.Project;
import com.amit.api.compiler.parser.AmitParser;

public class App {
	public static void main( String[] args ) {
		Options options = createOptions();

		CommandLineParser parser = new GnuParser();
		try {
			// parse the command line arguments
			CommandLine cmd = parser.parse( options, args );
			execute( cmd );
		} catch ( ParseException exp ) {
			System.out.println( "Invalid arguments.  Reason: " + exp.getMessage() );
			HelpFormatter formatter = new HelpFormatter();
			formatter.printHelp( "args", options );			
		} catch( Exception e ) {
			e.printStackTrace();
		}
	}
	
	private static void execute( CommandLine cmd ) 
			throws Exception {
		AmitParser parser = AmitParser.fromFile( cmd.getOptionValue( "project" ) );
		Project project = parser.parse();
		
		CodeGenerator generator = new CodeGenerator( 
				project, cmd.getOptionValue( "template" ), cmd.getOptionValue( "destination" ) );
		
		generator.generate();
	}

	private static Options createOptions() {
		Option project = new Option( 
				"p", "project", true, "the path to amit project file." );
		project.setRequired( true );

		Option template = new Option( 
				"t", "template", true, "the path to the template used to generate the result." );
		template.setRequired( true );
		
		Option dest = new Option( 
				"d", "destination", true, "the destination to generate the files." );
		dest.setRequired( true );
		
		Options options = new Options();
		options.addOption(project);
		options.addOption(template);
		options.addOption(dest);
		
		return options;
	}
}
