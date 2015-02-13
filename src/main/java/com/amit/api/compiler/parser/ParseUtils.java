package com.amit.api.compiler.parser;

public final class ParseUtils {

	/**
	 * parses string from parser format to string format
	 * @param str
	 * @return
	 */
	public static String parseString( String str ) {
		return str.substring( 1, str.length() - 1 ).replace("\\\"", "\"").replace("\\\\", "\\" );
	}
}
