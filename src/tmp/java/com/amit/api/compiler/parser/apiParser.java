// $ANTLR 3.5.2 api.g 2018-09-27 11:46:18

package com.amit.api.compiler.parser;

import com.amit.api.compiler.model.*;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class apiParser extends Parser {
	public static final String[] tokenNames = new String[] {
		"<invalid>", "<EOR>", "<DOWN>", "<UP>", "AND", "ARRAY", "ASTART", "ASTOP", 
		"CHAR", "COLON", "COMMA", "COMMENT", "DOTDOT", "EMPTY", "END", "ENUM", 
		"EQUAL", "ESC_SEQ", "EXCEPTION", "EXPONENT", "FOR", "HEX", "HEX_DIGIT", 
		"ID", "INCLUDE", "INT", "INTERFACE", "LIB", "MAP", "MINUS", "NOT", "NULL", 
		"OCTAL_ESC", "OR", "PCLOSE", "POPEN", "PROJECT", "REQUIRED", "SEMICOLON", 
		"SERVICE", "START", "STRING", "THROWS", "TYPE", "UNICODE_ESC", "VALIDATE", 
		"VALIDATION", "WS"
	};
	public static final int EOF=-1;
	public static final int AND=4;
	public static final int ARRAY=5;
	public static final int ASTART=6;
	public static final int ASTOP=7;
	public static final int CHAR=8;
	public static final int COLON=9;
	public static final int COMMA=10;
	public static final int COMMENT=11;
	public static final int DOTDOT=12;
	public static final int EMPTY=13;
	public static final int END=14;
	public static final int ENUM=15;
	public static final int EQUAL=16;
	public static final int ESC_SEQ=17;
	public static final int EXCEPTION=18;
	public static final int EXPONENT=19;
	public static final int FOR=20;
	public static final int HEX=21;
	public static final int HEX_DIGIT=22;
	public static final int ID=23;
	public static final int INCLUDE=24;
	public static final int INT=25;
	public static final int INTERFACE=26;
	public static final int LIB=27;
	public static final int MAP=28;
	public static final int MINUS=29;
	public static final int NOT=30;
	public static final int NULL=31;
	public static final int OCTAL_ESC=32;
	public static final int OR=33;
	public static final int PCLOSE=34;
	public static final int POPEN=35;
	public static final int PROJECT=36;
	public static final int REQUIRED=37;
	public static final int SEMICOLON=38;
	public static final int SERVICE=39;
	public static final int START=40;
	public static final int STRING=41;
	public static final int THROWS=42;
	public static final int TYPE=43;
	public static final int UNICODE_ESC=44;
	public static final int VALIDATE=45;
	public static final int VALIDATION=46;
	public static final int WS=47;

	// delegates
	public Parser[] getDelegates() {
		return new Parser[] {};
	}

	// delegators


	public apiParser(TokenStream input) {
		this(input, new RecognizerSharedState());
	}
	public apiParser(TokenStream input, RecognizerSharedState state) {
		super(input, state);
	}

	@Override public String[] getTokenNames() { return apiParser.tokenNames; }
	@Override public String getGrammarFileName() { return "api.g"; }



	// $ANTLR start "start"
	// api.g:14:1: start[Project project] : header[project] ( statment[ project ] )* ;
	public final void start(Project project) throws RecognitionException {
		try {
			// api.g:15:2: ( header[project] ( statment[ project ] )* )
			// api.g:15:4: header[project] ( statment[ project ] )*
			{
			pushFollow(FOLLOW_header_in_start36);
			header(project);
			state._fsp--;

			// api.g:15:21: ( statment[ project ] )*
			loop1:
			while (true) {
				int alt1=2;
				int LA1_0 = input.LA(1);
				if ( ((LA1_0 >= ARRAY && LA1_0 <= ASTART)||LA1_0==ENUM||LA1_0==EXCEPTION||LA1_0==ID||LA1_0==INTERFACE||LA1_0==MAP||LA1_0==PROJECT||LA1_0==SERVICE||LA1_0==TYPE||LA1_0==VALIDATION) ) {
					alt1=1;
				}

				switch (alt1) {
				case 1 :
					// api.g:15:23: statment[ project ]
					{
					pushFollow(FOLLOW_statment_in_start42);
					statment(project);
					state._fsp--;

					}
					break;

				default :
					break loop1;
				}
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "start"



	// $ANTLR start "header"
	// api.g:18:1: header[Project project] : include module[project] ;
	public final void header(Project project) throws RecognitionException {
		try {
			// api.g:19:2: ( include module[project] )
			// api.g:19:4: include module[project]
			{
			pushFollow(FOLLOW_include_in_header60);
			include();
			state._fsp--;

			pushFollow(FOLLOW_module_in_header66);
			module(project);
			state._fsp--;

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "header"



	// $ANTLR start "include"
	// api.g:23:1: include : ( INCLUDE STRING )* ;
	public final void include() throws RecognitionException {
		try {
			// api.g:24:2: ( ( INCLUDE STRING )* )
			// api.g:24:4: ( INCLUDE STRING )*
			{
			// api.g:24:4: ( INCLUDE STRING )*
			loop2:
			while (true) {
				int alt2=2;
				int LA2_0 = input.LA(1);
				if ( (LA2_0==INCLUDE) ) {
					alt2=1;
				}

				switch (alt2) {
				case 1 :
					// api.g:24:6: INCLUDE STRING
					{
					match(input,INCLUDE,FOLLOW_INCLUDE_in_include83); 
					match(input,STRING,FOLLOW_STRING_in_include85); 
					}
					break;

				default :
					break loop2;
				}
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "include"



	// $ANTLR start "module"
	// api.g:27:1: module[Project project] : ( attributes[attrList] PROJECT ID SEMICOLON | LIB ID SEMICOLON );
	public final void module(Project project) throws RecognitionException {
		Token ID1=null;
		Token ID2=null;


			AttributeList attrList = project.createAttributeList();

		try {
			// api.g:30:3: ( attributes[attrList] PROJECT ID SEMICOLON | LIB ID SEMICOLON )
			int alt3=2;
			int LA3_0 = input.LA(1);
			if ( ((LA3_0 >= ARRAY && LA3_0 <= ASTART)||LA3_0==ENUM||LA3_0==EXCEPTION||LA3_0==ID||LA3_0==INTERFACE||LA3_0==MAP||LA3_0==PROJECT||LA3_0==SERVICE||LA3_0==TYPE||LA3_0==VALIDATION) ) {
				alt3=1;
			}
			else if ( (LA3_0==LIB) ) {
				alt3=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 3, 0, input);
				throw nvae;
			}

			switch (alt3) {
				case 1 :
					// api.g:30:5: attributes[attrList] PROJECT ID SEMICOLON
					{
					pushFollow(FOLLOW_attributes_in_module107);
					attributes(attrList);
					state._fsp--;

					match(input,PROJECT,FOLLOW_PROJECT_in_module111); 
					ID1=(Token)match(input,ID,FOLLOW_ID_in_module113); 
					match(input,SEMICOLON,FOLLOW_SEMICOLON_in_module115); 
					 project.createModule( (ID1!=null?ID1.getText():null), ModuleType.PROJECT, attrList, new Context( ID1 ) ); 
					}
					break;
				case 2 :
					// api.g:31:4: LIB ID SEMICOLON
					{
					match(input,LIB,FOLLOW_LIB_in_module122); 
					ID2=(Token)match(input,ID,FOLLOW_ID_in_module124); 
					match(input,SEMICOLON,FOLLOW_SEMICOLON_in_module126); 
					 project.createModule( (ID2!=null?ID2.getText():null), ModuleType.LIB, null, new Context( ID2 ) ); 
					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "module"



	// $ANTLR start "statment"
	// api.g:34:1: statment[Project project] : ( enum_statment[project] | type_statment[project] | interface_statment[project] | exception_statment[project] | service_statment[project] | validation_expression[project] );
	public final void statment(Project project) throws RecognitionException {
		try {
			// api.g:35:2: ( enum_statment[project] | type_statment[project] | interface_statment[project] | exception_statment[project] | service_statment[project] | validation_expression[project] )
			int alt4=6;
			alt4 = dfa4.predict(input);
			switch (alt4) {
				case 1 :
					// api.g:35:4: enum_statment[project]
					{
					pushFollow(FOLLOW_enum_statment_in_statment142);
					enum_statment(project);
					state._fsp--;

					}
					break;
				case 2 :
					// api.g:36:4: type_statment[project]
					{
					pushFollow(FOLLOW_type_statment_in_statment149);
					type_statment(project);
					state._fsp--;

					}
					break;
				case 3 :
					// api.g:37:4: interface_statment[project]
					{
					pushFollow(FOLLOW_interface_statment_in_statment156);
					interface_statment(project);
					state._fsp--;

					}
					break;
				case 4 :
					// api.g:38:4: exception_statment[project]
					{
					pushFollow(FOLLOW_exception_statment_in_statment163);
					exception_statment(project);
					state._fsp--;

					}
					break;
				case 5 :
					// api.g:39:4: service_statment[project]
					{
					pushFollow(FOLLOW_service_statment_in_statment170);
					service_statment(project);
					state._fsp--;

					}
					break;
				case 6 :
					// api.g:40:4: validation_expression[project]
					{
					pushFollow(FOLLOW_validation_expression_in_statment177);
					validation_expression(project);
					state._fsp--;

					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "statment"



	// $ANTLR start "service_statment"
	// api.g:43:1: service_statment[Project project] : attributes[attrList] SERVICE ID interface_inh[service] SEMICOLON ;
	public final void service_statment(Project project) throws RecognitionException {
		Token ID3=null;


			AttributeList attrList = project.createAttributeList();

		try {
			// api.g:47:2: ( attributes[attrList] SERVICE ID interface_inh[service] SEMICOLON )
			// api.g:47:4: attributes[attrList] SERVICE ID interface_inh[service] SEMICOLON
			{
			pushFollow(FOLLOW_attributes_in_service_statment197);
			attributes(attrList);
			state._fsp--;

			match(input,SERVICE,FOLLOW_SERVICE_in_service_statment201); 
			ID3=(Token)match(input,ID,FOLLOW_ID_in_service_statment206); 
			 Service service = project.createService( (ID3!=null?ID3.getText():null), attrList, new Context( ID3 ) ); 
			pushFollow(FOLLOW_interface_inh_in_service_statment213);
			interface_inh(service);
			state._fsp--;

			match(input,SEMICOLON,FOLLOW_SEMICOLON_in_service_statment220); 
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "service_statment"



	// $ANTLR start "interface_statment"
	// api.g:53:1: interface_statment[Project project] : attributes[attrList] INTERFACE ID interface_inh[interf] START ( function[interf] )* END ;
	public final void interface_statment(Project project) throws RecognitionException {
		Token ID4=null;


			AttributeList attrList = project.createAttributeList();

		try {
			// api.g:57:2: ( attributes[attrList] INTERFACE ID interface_inh[interf] START ( function[interf] )* END )
			// api.g:57:4: attributes[attrList] INTERFACE ID interface_inh[interf] START ( function[interf] )* END
			{
			pushFollow(FOLLOW_attributes_in_interface_statment241);
			attributes(attrList);
			state._fsp--;

			match(input,INTERFACE,FOLLOW_INTERFACE_in_interface_statment245); 
			ID4=(Token)match(input,ID,FOLLOW_ID_in_interface_statment250); 
			 Interface interf = project.createInterface( (ID4!=null?ID4.getText():null), attrList, new Context( ID4 ) ); 
			pushFollow(FOLLOW_interface_inh_in_interface_statment257);
			interface_inh(interf);
			state._fsp--;

			match(input,START,FOLLOW_START_in_interface_statment264); 
			// api.g:61:4: ( function[interf] )*
			loop5:
			while (true) {
				int alt5=2;
				int LA5_0 = input.LA(1);
				if ( ((LA5_0 >= ARRAY && LA5_0 <= ASTART)||LA5_0==ENUM||LA5_0==EXCEPTION||LA5_0==ID||LA5_0==INTERFACE||LA5_0==MAP||LA5_0==PROJECT||LA5_0==SERVICE||LA5_0==TYPE||LA5_0==VALIDATION) ) {
					alt5=1;
				}

				switch (alt5) {
				case 1 :
					// api.g:61:6: function[interf]
					{
					pushFollow(FOLLOW_function_in_interface_statment271);
					function(interf);
					state._fsp--;

					}
					break;

				default :
					break loop5;
				}
			}

			match(input,END,FOLLOW_END_in_interface_statment283); 
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "interface_statment"



	// $ANTLR start "interface_inh"
	// api.g:65:1: interface_inh[Interface interf] : (| COLON ID interface_inh_end[interf] );
	public final void interface_inh(Interface interf) throws RecognitionException {
		Token ID5=null;

		try {
			// api.g:66:2: (| COLON ID interface_inh_end[interf] )
			int alt6=2;
			int LA6_0 = input.LA(1);
			if ( (LA6_0==SEMICOLON||LA6_0==START) ) {
				alt6=1;
			}
			else if ( (LA6_0==COLON) ) {
				alt6=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 6, 0, input);
				throw nvae;
			}

			switch (alt6) {
				case 1 :
					// api.g:67:2: 
					{
					}
					break;
				case 2 :
					// api.g:67:4: COLON ID interface_inh_end[interf]
					{
					match(input,COLON,FOLLOW_COLON_in_interface_inh300); 
					ID5=(Token)match(input,ID,FOLLOW_ID_in_interface_inh302); 
					 interf.addBaseInterface( (ID5!=null?ID5.getText():null)); 
					pushFollow(FOLLOW_interface_inh_end_in_interface_inh306);
					interface_inh_end(interf);
					state._fsp--;

					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "interface_inh"



	// $ANTLR start "interface_inh_end"
	// api.g:70:1: interface_inh_end[Interface interf] : ( COMMA ID )* ;
	public final void interface_inh_end(Interface interf) throws RecognitionException {
		Token ID6=null;

		try {
			// api.g:71:2: ( ( COMMA ID )* )
			// api.g:71:4: ( COMMA ID )*
			{
			// api.g:71:4: ( COMMA ID )*
			loop7:
			while (true) {
				int alt7=2;
				int LA7_0 = input.LA(1);
				if ( (LA7_0==COMMA) ) {
					alt7=1;
				}

				switch (alt7) {
				case 1 :
					// api.g:71:6: COMMA ID
					{
					match(input,COMMA,FOLLOW_COMMA_in_interface_inh_end324); 
					ID6=(Token)match(input,ID,FOLLOW_ID_in_interface_inh_end326); 
					 interf.addBaseInterface( (ID6!=null?ID6.getText():null)); 
					}
					break;

				default :
					break loop7;
				}
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "interface_inh_end"



	// $ANTLR start "function"
	// api.g:74:1: function[Interface interf] : attributes[attrList] function_ret[returnType,interf] ID function_end[fun] ;
	public final void function(Interface interf) throws RecognitionException {
		Token ID7=null;


			AttributeList attrList = interf.createAttributeList();
			ReturnValue<FunctionReturn> returnType = new ReturnValue<FunctionReturn>(); 

		try {
			// api.g:79:2: ( attributes[attrList] function_ret[returnType,interf] ID function_end[fun] )
			// api.g:79:4: attributes[attrList] function_ret[returnType,interf] ID function_end[fun]
			{
			pushFollow(FOLLOW_attributes_in_function352);
			attributes(attrList);
			state._fsp--;

			pushFollow(FOLLOW_function_ret_in_function356);
			function_ret(returnType, interf);
			state._fsp--;

			ID7=(Token)match(input,ID,FOLLOW_ID_in_function364); 
			 Function fun = interf.createFunction( (ID7!=null?ID7.getText():null), returnType.get(), attrList, new Context( ID7 ) ); 
			pushFollow(FOLLOW_function_end_in_function372);
			function_end(fun);
			state._fsp--;

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "function"



	// $ANTLR start "function_end"
	// api.g:84:1: function_end[Function fun] : ( POPEN function_args[fun] PCLOSE function_throws[fun] validate_optional[fun] SEMICOLON | POPEN PCLOSE function_throws[fun] validate_optional[fun] SEMICOLON );
	public final void function_end(Function fun) throws RecognitionException {
		try {
			// api.g:85:2: ( POPEN function_args[fun] PCLOSE function_throws[fun] validate_optional[fun] SEMICOLON | POPEN PCLOSE function_throws[fun] validate_optional[fun] SEMICOLON )
			int alt8=2;
			int LA8_0 = input.LA(1);
			if ( (LA8_0==POPEN) ) {
				int LA8_1 = input.LA(2);
				if ( (LA8_1==PCLOSE) ) {
					alt8=2;
				}
				else if ( ((LA8_1 >= ARRAY && LA8_1 <= ASTART)||LA8_1==ID||LA8_1==MAP) ) {
					alt8=1;
				}

				else {
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 8, 1, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 8, 0, input);
				throw nvae;
			}

			switch (alt8) {
				case 1 :
					// api.g:85:4: POPEN function_args[fun] PCLOSE function_throws[fun] validate_optional[fun] SEMICOLON
					{
					match(input,POPEN,FOLLOW_POPEN_in_function_end388); 
					pushFollow(FOLLOW_function_args_in_function_end390);
					function_args(fun);
					state._fsp--;

					match(input,PCLOSE,FOLLOW_PCLOSE_in_function_end394); 
					pushFollow(FOLLOW_function_throws_in_function_end396);
					function_throws(fun);
					state._fsp--;

					pushFollow(FOLLOW_validate_optional_in_function_end400);
					validate_optional(fun);
					state._fsp--;

					match(input,SEMICOLON,FOLLOW_SEMICOLON_in_function_end404); 
					}
					break;
				case 2 :
					// api.g:86:4: POPEN PCLOSE function_throws[fun] validate_optional[fun] SEMICOLON
					{
					match(input,POPEN,FOLLOW_POPEN_in_function_end409); 
					match(input,PCLOSE,FOLLOW_PCLOSE_in_function_end411); 
					pushFollow(FOLLOW_function_throws_in_function_end413);
					function_throws(fun);
					state._fsp--;

					pushFollow(FOLLOW_validate_optional_in_function_end417);
					validate_optional(fun);
					state._fsp--;

					match(input,SEMICOLON,FOLLOW_SEMICOLON_in_function_end421); 
					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "function_end"



	// $ANTLR start "function_throws"
	// api.g:89:1: function_throws[Function fun] : (| THROWS ID ( function_throws_more[fun] )* );
	public final void function_throws(Function fun) throws RecognitionException {
		Token ID8=null;

		try {
			// api.g:90:2: (| THROWS ID ( function_throws_more[fun] )* )
			int alt10=2;
			int LA10_0 = input.LA(1);
			if ( (LA10_0==SEMICOLON||LA10_0==VALIDATE) ) {
				alt10=1;
			}
			else if ( (LA10_0==THROWS) ) {
				alt10=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 10, 0, input);
				throw nvae;
			}

			switch (alt10) {
				case 1 :
					// api.g:91:2: 
					{
					}
					break;
				case 2 :
					// api.g:91:4: THROWS ID ( function_throws_more[fun] )*
					{
					match(input,THROWS,FOLLOW_THROWS_in_function_throws437); 
					ID8=(Token)match(input,ID,FOLLOW_ID_in_function_throws439); 
					 fun.addThrowsException( (ID8!=null?ID8.getText():null) ); 
					// api.g:92:4: ( function_throws_more[fun] )*
					loop9:
					while (true) {
						int alt9=2;
						int LA9_0 = input.LA(1);
						if ( (LA9_0==COMMA) ) {
							alt9=1;
						}

						switch (alt9) {
						case 1 :
							// api.g:92:6: function_throws_more[fun]
							{
							pushFollow(FOLLOW_function_throws_more_in_function_throws448);
							function_throws_more(fun);
							state._fsp--;

							}
							break;

						default :
							break loop9;
						}
					}

					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "function_throws"



	// $ANTLR start "function_throws_more"
	// api.g:95:1: function_throws_more[Function fun] : COMMA ID ;
	public final void function_throws_more(Function fun) throws RecognitionException {
		Token ID9=null;

		try {
			// api.g:96:2: ( COMMA ID )
			// api.g:96:4: COMMA ID
			{
			match(input,COMMA,FOLLOW_COMMA_in_function_throws_more466); 
			ID9=(Token)match(input,ID,FOLLOW_ID_in_function_throws_more468); 
			 fun.addThrowsException( (ID9!=null?ID9.getText():null) ); 
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "function_throws_more"



	// $ANTLR start "function_ret"
	// api.g:100:1: function_ret[ReturnValue<FunctionReturn> returnType,Interface interf] : ( ID | ARRAY ID | MAP ID );
	public final void function_ret(ReturnValue<FunctionReturn> returnType, Interface interf) throws RecognitionException {
		Token ID10=null;
		Token ID11=null;
		Token ID12=null;

		try {
			// api.g:101:2: ( ID | ARRAY ID | MAP ID )
			int alt11=3;
			switch ( input.LA(1) ) {
			case ID:
				{
				alt11=1;
				}
				break;
			case ARRAY:
				{
				alt11=2;
				}
				break;
			case MAP:
				{
				alt11=3;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 11, 0, input);
				throw nvae;
			}
			switch (alt11) {
				case 1 :
					// api.g:101:4: ID
					{
					ID10=(Token)match(input,ID,FOLLOW_ID_in_function_ret486); 
					 returnType.set( interf.getProject().createFunctionReturn( (ID10!=null?ID10.getText():null), false, false, new Context( ID10 ) ) ); 
					}
					break;
				case 2 :
					// api.g:102:4: ARRAY ID
					{
					match(input,ARRAY,FOLLOW_ARRAY_in_function_ret493); 
					ID11=(Token)match(input,ID,FOLLOW_ID_in_function_ret495); 
					 returnType.set( interf.getProject().createFunctionReturn( (ID11!=null?ID11.getText():null), true, false, new Context( ID11 ) ) ); 
					}
					break;
				case 3 :
					// api.g:103:4: MAP ID
					{
					match(input,MAP,FOLLOW_MAP_in_function_ret502); 
					ID12=(Token)match(input,ID,FOLLOW_ID_in_function_ret504); 
					 returnType.set( interf.getProject().createFunctionReturn( (ID12!=null?ID12.getText():null), false, true, new Context( ID12 ) ) ); 
					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "function_ret"



	// $ANTLR start "function_args"
	// api.g:106:1: function_args[Function fun] : function_arg[fun] ( COMMA function_arg[fun] )* ;
	public final void function_args(Function fun) throws RecognitionException {
		try {
			// api.g:107:2: ( function_arg[fun] ( COMMA function_arg[fun] )* )
			// api.g:107:4: function_arg[fun] ( COMMA function_arg[fun] )*
			{
			pushFollow(FOLLOW_function_arg_in_function_args522);
			function_arg(fun);
			state._fsp--;

			// api.g:107:23: ( COMMA function_arg[fun] )*
			loop12:
			while (true) {
				int alt12=2;
				int LA12_0 = input.LA(1);
				if ( (LA12_0==COMMA) ) {
					alt12=1;
				}

				switch (alt12) {
				case 1 :
					// api.g:107:25: COMMA function_arg[fun]
					{
					match(input,COMMA,FOLLOW_COMMA_in_function_args528); 
					pushFollow(FOLLOW_function_arg_in_function_args530);
					function_arg(fun);
					state._fsp--;

					}
					break;

				default :
					break loop12;
				}
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "function_args"



	// $ANTLR start "function_arg"
	// api.g:110:1: function_arg[Function fun] : ( attributes[attrList] ID function_arg_end[$ID.text, false, false, attrList, fun] | attributes[attrList] ARRAY ID function_arg_end[$ID.text, true, false, attrList, fun] | attributes[attrList] MAP ID function_arg_end[$ID.text, false, true, attrList, fun] );
	public final void function_arg(Function fun) throws RecognitionException {
		Token ID13=null;
		Token ID14=null;
		Token ID15=null;


			AttributeList attrList = fun.createAttributeList();

		try {
			// api.g:114:2: ( attributes[attrList] ID function_arg_end[$ID.text, false, false, attrList, fun] | attributes[attrList] ARRAY ID function_arg_end[$ID.text, true, false, attrList, fun] | attributes[attrList] MAP ID function_arg_end[$ID.text, false, true, attrList, fun] )
			int alt13=3;
			alt13 = dfa13.predict(input);
			switch (alt13) {
				case 1 :
					// api.g:114:4: attributes[attrList] ID function_arg_end[$ID.text, false, false, attrList, fun]
					{
					pushFollow(FOLLOW_attributes_in_function_arg557);
					attributes(attrList);
					state._fsp--;

					ID13=(Token)match(input,ID,FOLLOW_ID_in_function_arg561); 
					pushFollow(FOLLOW_function_arg_end_in_function_arg563);
					function_arg_end((ID13!=null?ID13.getText():null), false, false, attrList, fun);
					state._fsp--;

					}
					break;
				case 2 :
					// api.g:115:4: attributes[attrList] ARRAY ID function_arg_end[$ID.text, true, false, attrList, fun]
					{
					pushFollow(FOLLOW_attributes_in_function_arg571);
					attributes(attrList);
					state._fsp--;

					match(input,ARRAY,FOLLOW_ARRAY_in_function_arg575); 
					ID14=(Token)match(input,ID,FOLLOW_ID_in_function_arg577); 
					pushFollow(FOLLOW_function_arg_end_in_function_arg579);
					function_arg_end((ID14!=null?ID14.getText():null), true, false, attrList, fun);
					state._fsp--;

					}
					break;
				case 3 :
					// api.g:116:4: attributes[attrList] MAP ID function_arg_end[$ID.text, false, true, attrList, fun]
					{
					pushFollow(FOLLOW_attributes_in_function_arg586);
					attributes(attrList);
					state._fsp--;

					match(input,MAP,FOLLOW_MAP_in_function_arg590); 
					ID15=(Token)match(input,ID,FOLLOW_ID_in_function_arg592); 
					pushFollow(FOLLOW_function_arg_end_in_function_arg594);
					function_arg_end((ID15!=null?ID15.getText():null), false, true, attrList, fun);
					state._fsp--;

					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "function_arg"



	// $ANTLR start "function_arg_end"
	// api.g:119:1: function_arg_end[String type, boolean isArray, boolean isMap, AttributeList attrList, Function fun] : ID ;
	public final void function_arg_end(String type, boolean isArray, boolean isMap, AttributeList attrList, Function fun) throws RecognitionException {
		Token ID16=null;

		try {
			// api.g:120:2: ( ID )
			// api.g:120:4: ID
			{
			ID16=(Token)match(input,ID,FOLLOW_ID_in_function_arg_end609); 
			 fun.createArgument( type, (ID16!=null?ID16.getText():null), isArray, isMap, attrList, new Context( ID16 ) ); 
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "function_arg_end"



	// $ANTLR start "exception_statment"
	// api.g:123:1: exception_statment[Project project] : attributes[attrList] EXCEPTION ID type_end[type] ;
	public final void exception_statment(Project project) throws RecognitionException {
		Token ID17=null;


			AttributeList attrList = project.createAttributeList();

		try {
			// api.g:127:2: ( attributes[attrList] EXCEPTION ID type_end[type] )
			// api.g:127:4: attributes[attrList] EXCEPTION ID type_end[type]
			{
			pushFollow(FOLLOW_attributes_in_exception_statment628);
			attributes(attrList);
			state._fsp--;

			match(input,EXCEPTION,FOLLOW_EXCEPTION_in_exception_statment632); 
			ID17=(Token)match(input,ID,FOLLOW_ID_in_exception_statment637); 
			 TypeCommonComposite type = project.createException( (ID17!=null?ID17.getText():null), attrList, new Context( ID17 ) ); 
			pushFollow(FOLLOW_type_end_in_exception_statment644);
			type_end(type);
			state._fsp--;

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "exception_statment"



	// $ANTLR start "type_statment"
	// api.g:132:1: type_statment[Project project] : attributes[attrList] TYPE ID type_end[type] ;
	public final void type_statment(Project project) throws RecognitionException {
		Token ID18=null;


			AttributeList attrList = project.createAttributeList();

		try {
			// api.g:136:2: ( attributes[attrList] TYPE ID type_end[type] )
			// api.g:136:4: attributes[attrList] TYPE ID type_end[type]
			{
			pushFollow(FOLLOW_attributes_in_type_statment667);
			attributes(attrList);
			state._fsp--;

			match(input,TYPE,FOLLOW_TYPE_in_type_statment671); 
			ID18=(Token)match(input,ID,FOLLOW_ID_in_type_statment676); 
			 TypeCommonComposite type = project.createCompositeType( (ID18!=null?ID18.getText():null), attrList, new Context( ID18 ) ); 
			pushFollow(FOLLOW_type_end_in_type_statment683);
			type_end(type);
			state._fsp--;

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "type_statment"



	// $ANTLR start "type_end"
	// api.g:141:1: type_end[TypeCommonComposite type] : ( START ( type_item[type] )* END | COLON ID START ( type_item[type] )* END );
	public final void type_end(TypeCommonComposite type) throws RecognitionException {
		Token ID19=null;

		try {
			// api.g:142:2: ( START ( type_item[type] )* END | COLON ID START ( type_item[type] )* END )
			int alt16=2;
			int LA16_0 = input.LA(1);
			if ( (LA16_0==START) ) {
				alt16=1;
			}
			else if ( (LA16_0==COLON) ) {
				alt16=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 16, 0, input);
				throw nvae;
			}

			switch (alt16) {
				case 1 :
					// api.g:142:4: START ( type_item[type] )* END
					{
					match(input,START,FOLLOW_START_in_type_end698); 
					// api.g:142:10: ( type_item[type] )*
					loop14:
					while (true) {
						int alt14=2;
						int LA14_0 = input.LA(1);
						if ( ((LA14_0 >= ARRAY && LA14_0 <= ASTART)||LA14_0==ENUM||LA14_0==EXCEPTION||LA14_0==ID||LA14_0==INTERFACE||LA14_0==MAP||LA14_0==PROJECT||LA14_0==SERVICE||LA14_0==TYPE||LA14_0==VALIDATION) ) {
							alt14=1;
						}

						switch (alt14) {
						case 1 :
							// api.g:142:12: type_item[type]
							{
							pushFollow(FOLLOW_type_item_in_type_end702);
							type_item(type);
							state._fsp--;

							}
							break;

						default :
							break loop14;
						}
					}

					match(input,END,FOLLOW_END_in_type_end709); 
					}
					break;
				case 2 :
					// api.g:143:4: COLON ID START ( type_item[type] )* END
					{
					match(input,COLON,FOLLOW_COLON_in_type_end714); 
					ID19=(Token)match(input,ID,FOLLOW_ID_in_type_end716); 
					match(input,START,FOLLOW_START_in_type_end718); 
					// api.g:143:19: ( type_item[type] )*
					loop15:
					while (true) {
						int alt15=2;
						int LA15_0 = input.LA(1);
						if ( ((LA15_0 >= ARRAY && LA15_0 <= ASTART)||LA15_0==ENUM||LA15_0==EXCEPTION||LA15_0==ID||LA15_0==INTERFACE||LA15_0==MAP||LA15_0==PROJECT||LA15_0==SERVICE||LA15_0==TYPE||LA15_0==VALIDATION) ) {
							alt15=1;
						}

						switch (alt15) {
						case 1 :
							// api.g:143:21: type_item[type]
							{
							pushFollow(FOLLOW_type_item_in_type_end722);
							type_item(type);
							state._fsp--;

							}
							break;

						default :
							break loop15;
						}
					}

					match(input,END,FOLLOW_END_in_type_end729); 
					 type.setBaseTypeName( (ID19!=null?ID19.getText():null) ); 
					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "type_end"



	// $ANTLR start "type_item"
	// api.g:146:1: type_item[TypeCommonComposite type] : ( attributes[attrList] ID type_value[$ID.text, false, false, type] | attributes[attrList] ARRAY ID type_value[$ID.text, true, false, type] | attributes[attrList] MAP ID type_value[$ID.text, false, true, type] );
	public final void type_item(TypeCommonComposite type) throws RecognitionException {
		Token ID20=null;
		Token ID21=null;
		Token ID22=null;


			AttributeList attrList = type.createAttributeList();

		try {
			// api.g:150:2: ( attributes[attrList] ID type_value[$ID.text, false, false, type] | attributes[attrList] ARRAY ID type_value[$ID.text, true, false, type] | attributes[attrList] MAP ID type_value[$ID.text, false, true, type] )
			int alt17=3;
			alt17 = dfa17.predict(input);
			switch (alt17) {
				case 1 :
					// api.g:150:4: attributes[attrList] ID type_value[$ID.text, false, false, type]
					{
					pushFollow(FOLLOW_attributes_in_type_item751);
					attributes(attrList);
					state._fsp--;

					ID20=(Token)match(input,ID,FOLLOW_ID_in_type_item755); 
					pushFollow(FOLLOW_type_value_in_type_item757);
					type_value((ID20!=null?ID20.getText():null), false, false, type);
					state._fsp--;

					}
					break;
				case 2 :
					// api.g:151:4: attributes[attrList] ARRAY ID type_value[$ID.text, true, false, type]
					{
					pushFollow(FOLLOW_attributes_in_type_item763);
					attributes(attrList);
					state._fsp--;

					match(input,ARRAY,FOLLOW_ARRAY_in_type_item767); 
					ID21=(Token)match(input,ID,FOLLOW_ID_in_type_item769); 
					pushFollow(FOLLOW_type_value_in_type_item771);
					type_value((ID21!=null?ID21.getText():null), true, false, type);
					state._fsp--;

					}
					break;
				case 3 :
					// api.g:152:4: attributes[attrList] MAP ID type_value[$ID.text, false, true, type]
					{
					pushFollow(FOLLOW_attributes_in_type_item777);
					attributes(attrList);
					state._fsp--;

					match(input,MAP,FOLLOW_MAP_in_type_item781); 
					ID22=(Token)match(input,ID,FOLLOW_ID_in_type_item783); 
					pushFollow(FOLLOW_type_value_in_type_item785);
					type_value((ID22!=null?ID22.getText():null), false, true, type);
					state._fsp--;

					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "type_item"



	// $ANTLR start "type_value"
	// api.g:155:1: type_value[String memberType, boolean isArray, boolean isMap, TypeCommonComposite type] : ID SEMICOLON ;
	public final void type_value(String memberType, boolean isArray, boolean isMap, TypeCommonComposite type) throws RecognitionException {
		Token ID23=null;

		try {
			// api.g:156:2: ( ID SEMICOLON )
			// api.g:156:4: ID SEMICOLON
			{
			ID23=(Token)match(input,ID,FOLLOW_ID_in_type_value799); 
			match(input,SEMICOLON,FOLLOW_SEMICOLON_in_type_value801); 
			 type.addMember( memberType, (ID23!=null?ID23.getText():null), isArray, isMap, new Context( ID23 ) ); 
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "type_value"



	// $ANTLR start "enum_statment"
	// api.g:159:1: enum_statment[Project project] : attributes[attrList] ENUM ID START enum_values[type_enum] END ;
	public final void enum_statment(Project project) throws RecognitionException {
		Token ID24=null;


			AttributeList attrList = project.createAttributeList();

		try {
			// api.g:163:2: ( attributes[attrList] ENUM ID START enum_values[type_enum] END )
			// api.g:163:4: attributes[attrList] ENUM ID START enum_values[type_enum] END
			{
			pushFollow(FOLLOW_attributes_in_enum_statment824);
			attributes(attrList);
			state._fsp--;

			match(input,ENUM,FOLLOW_ENUM_in_enum_statment831); 
			ID24=(Token)match(input,ID,FOLLOW_ID_in_enum_statment836); 

				  	TypeEnum type_enum = project.createEnum( (ID24!=null?ID24.getText():null), new Context( ID24 ) );
				  
			match(input,START,FOLLOW_START_in_enum_statment843); 
			pushFollow(FOLLOW_enum_values_in_enum_statment848);
			enum_values(type_enum);
			state._fsp--;

			match(input,END,FOLLOW_END_in_enum_statment855); 
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "enum_statment"



	// $ANTLR start "enum_value"
	// api.g:174:1: enum_value[TypeEnum type_enum] : ( attributes[attrList] ID EQUAL number_value | attributes[attrList] ID EQUAL STRING );
	public final void enum_value(TypeEnum type_enum) throws RecognitionException {
		Token ID25=null;
		Token ID27=null;
		Token STRING28=null;
		ParserRuleReturnScope number_value26 =null;


			AttributeList attrList = type_enum.createAttributeList();

		try {
			// api.g:178:2: ( attributes[attrList] ID EQUAL number_value | attributes[attrList] ID EQUAL STRING )
			int alt18=2;
			alt18 = dfa18.predict(input);
			switch (alt18) {
				case 1 :
					// api.g:178:4: attributes[attrList] ID EQUAL number_value
					{
					pushFollow(FOLLOW_attributes_in_enum_value876);
					attributes(attrList);
					state._fsp--;

					ID25=(Token)match(input,ID,FOLLOW_ID_in_enum_value880); 
					match(input,EQUAL,FOLLOW_EQUAL_in_enum_value882); 
					pushFollow(FOLLOW_number_value_in_enum_value884);
					number_value26=number_value();
					state._fsp--;

					 type_enum.createValue( (ID25!=null?ID25.getText():null), ParseUtils.parseNumber( (number_value26!=null?input.toString(number_value26.start,number_value26.stop):null) ), attrList, new Context( ID25 ) ); 
					}
					break;
				case 2 :
					// api.g:179:4: attributes[attrList] ID EQUAL STRING
					{
					pushFollow(FOLLOW_attributes_in_enum_value891);
					attributes(attrList);
					state._fsp--;

					ID27=(Token)match(input,ID,FOLLOW_ID_in_enum_value895); 
					match(input,EQUAL,FOLLOW_EQUAL_in_enum_value897); 
					STRING28=(Token)match(input,STRING,FOLLOW_STRING_in_enum_value899); 
					 type_enum.createValue( (ID27!=null?ID27.getText():null), ParseUtils.parseString( (STRING28!=null?STRING28.getText():null) ), attrList, new Context( ID27 ) ); 
					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "enum_value"



	// $ANTLR start "enum_values"
	// api.g:182:1: enum_values[TypeEnum type_enum] : enum_value[type_enum] ( COMMA enum_value[type_enum] )* ;
	public final void enum_values(TypeEnum type_enum) throws RecognitionException {
		try {
			// api.g:183:2: ( enum_value[type_enum] ( COMMA enum_value[type_enum] )* )
			// api.g:183:4: enum_value[type_enum] ( COMMA enum_value[type_enum] )*
			{
			pushFollow(FOLLOW_enum_value_in_enum_values915);
			enum_value(type_enum);
			state._fsp--;

			// api.g:184:3: ( COMMA enum_value[type_enum] )*
			loop19:
			while (true) {
				int alt19=2;
				int LA19_0 = input.LA(1);
				if ( (LA19_0==COMMA) ) {
					alt19=1;
				}

				switch (alt19) {
				case 1 :
					// api.g:184:5: COMMA enum_value[type_enum]
					{
					match(input,COMMA,FOLLOW_COMMA_in_enum_values922); 
					pushFollow(FOLLOW_enum_value_in_enum_values924);
					enum_value(type_enum);
					state._fsp--;

					}
					break;

				default :
					break loop19;
				}
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "enum_values"



	// $ANTLR start "attribute"
	// api.g:187:1: attribute[AttributeList attrList] : ASTART ID EQUAL STRING ASTOP ;
	public final void attribute(AttributeList attrList) throws RecognitionException {
		Token ID29=null;
		Token STRING30=null;

		try {
			// api.g:188:2: ( ASTART ID EQUAL STRING ASTOP )
			// api.g:188:4: ASTART ID EQUAL STRING ASTOP
			{
			match(input,ASTART,FOLLOW_ASTART_in_attribute943); 
			ID29=(Token)match(input,ID,FOLLOW_ID_in_attribute945); 
			match(input,EQUAL,FOLLOW_EQUAL_in_attribute947); 
			STRING30=(Token)match(input,STRING,FOLLOW_STRING_in_attribute949); 
			match(input,ASTOP,FOLLOW_ASTOP_in_attribute951); 
			 attrList.createAttribute( (ID29!=null?ID29.getText():null), ParseUtils.parseString( (STRING30!=null?STRING30.getText():null) ), new Context( ID29 ) ); 
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "attribute"



	// $ANTLR start "attributes"
	// api.g:191:1: attributes[AttributeList attrList] : ( attribute[attrList] )* ;
	public final void attributes(AttributeList attrList) throws RecognitionException {
		try {
			// api.g:192:2: ( ( attribute[attrList] )* )
			// api.g:192:4: ( attribute[attrList] )*
			{
			// api.g:192:4: ( attribute[attrList] )*
			loop20:
			while (true) {
				int alt20=2;
				int LA20_0 = input.LA(1);
				if ( (LA20_0==ASTART) ) {
					alt20=1;
				}

				switch (alt20) {
				case 1 :
					// api.g:192:5: attribute[attrList]
					{
					pushFollow(FOLLOW_attribute_in_attributes968);
					attribute(attrList);
					state._fsp--;

					}
					break;

				default :
					break loop20;
				}
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "attributes"



	// $ANTLR start "validation_expression"
	// api.g:195:1: validation_expression[Project project] : attributes[attrList] VALIDATION ID validation_expression_end[validation] ;
	public final void validation_expression(Project project) throws RecognitionException {
		Token ID31=null;


			AttributeList attrList = project.createAttributeList();

		try {
			// api.g:199:2: ( attributes[attrList] VALIDATION ID validation_expression_end[validation] )
			// api.g:199:4: attributes[attrList] VALIDATION ID validation_expression_end[validation]
			{
			pushFollow(FOLLOW_attributes_in_validation_expression992);
			attributes(attrList);
			state._fsp--;

			match(input,VALIDATION,FOLLOW_VALIDATION_in_validation_expression996); 
			ID31=(Token)match(input,ID,FOLLOW_ID_in_validation_expression998); 

					Validation validation = project.createValidation( (ID31!=null?ID31.getText():null), attrList, new Context( ID31 ) );
				
			pushFollow(FOLLOW_validation_expression_end_in_validation_expression1003);
			validation_expression_end(validation);
			state._fsp--;

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "validation_expression"



	// $ANTLR start "validation_expression_end"
	// api.g:205:1: validation_expression_end[Validation validation] : FOR ID START ( validation_field[validation] )* END ;
	public final void validation_expression_end(Validation validation) throws RecognitionException {
		Token ID32=null;

		try {
			// api.g:206:2: ( FOR ID START ( validation_field[validation] )* END )
			// api.g:206:4: FOR ID START ( validation_field[validation] )* END
			{
			match(input,FOR,FOLLOW_FOR_in_validation_expression_end1018); 
			ID32=(Token)match(input,ID,FOLLOW_ID_in_validation_expression_end1020); 

					validation.setTypeName( (ID32!=null?ID32.getText():null) );
				
			match(input,START,FOLLOW_START_in_validation_expression_end1024); 
			// api.g:209:2: ( validation_field[validation] )*
			loop21:
			while (true) {
				int alt21=2;
				int LA21_0 = input.LA(1);
				if ( (LA21_0==ID) ) {
					alt21=1;
				}

				switch (alt21) {
				case 1 :
					// api.g:209:3: validation_field[validation]
					{
					pushFollow(FOLLOW_validation_field_in_validation_expression_end1028);
					validation_field(validation);
					state._fsp--;

					}
					break;

				default :
					break loop21;
				}
			}

			match(input,END,FOLLOW_END_in_validation_expression_end1035); 
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "validation_expression_end"



	// $ANTLR start "validation_field"
	// api.g:213:1: validation_field[Validation validation] : ID validation_field_modifier[validation, $ID.text, new Context( $ID )] ;
	public final void validation_field(Validation validation) throws RecognitionException {
		Token ID33=null;

		try {
			// api.g:214:2: ( ID validation_field_modifier[validation, $ID.text, new Context( $ID )] )
			// api.g:214:4: ID validation_field_modifier[validation, $ID.text, new Context( $ID )]
			{
			ID33=(Token)match(input,ID,FOLLOW_ID_in_validation_field1049); 
			pushFollow(FOLLOW_validation_field_modifier_in_validation_field1051);
			validation_field_modifier(validation, (ID33!=null?ID33.getText():null), new Context( ID33 ));
			state._fsp--;

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "validation_field"



	// $ANTLR start "validation_field_modifier"
	// api.g:217:1: validation_field_modifier[Validation validation, String name, Context context] : ( ( validate_condition[c] )+ SEMICOLON | ASTART ASTOP ( validate_condition[c] )+ SEMICOLON | START END ( validate_condition[c] )+ SEMICOLON );
	public final void validation_field_modifier(Validation validation, String name, Context context) throws RecognitionException {
		try {
			// api.g:218:2: ( ( validate_condition[c] )+ SEMICOLON | ASTART ASTOP ( validate_condition[c] )+ SEMICOLON | START END ( validate_condition[c] )+ SEMICOLON )
			int alt25=3;
			switch ( input.LA(1) ) {
			case NOT:
			case STRING:
				{
				alt25=1;
				}
				break;
			case ASTART:
				{
				int LA25_2 = input.LA(2);
				if ( (LA25_2==ASTOP) ) {
					alt25=2;
				}
				else if ( (LA25_2==DOTDOT||LA25_2==INT) ) {
					alt25=1;
				}

				else {
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 25, 2, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

				}
				break;
			case START:
				{
				alt25=3;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 25, 0, input);
				throw nvae;
			}
			switch (alt25) {
				case 1 :
					// api.g:218:4: ( validate_condition[c] )+ SEMICOLON
					{

							ValidationFieldCondition c = validation.createValidationFieldCondition(name, false, false, context);
						
					// api.g:220:4: ( validate_condition[c] )+
					int cnt22=0;
					loop22:
					while (true) {
						int alt22=2;
						int LA22_0 = input.LA(1);
						if ( (LA22_0==ASTART||LA22_0==NOT||LA22_0==STRING) ) {
							alt22=1;
						}

						switch (alt22) {
						case 1 :
							// api.g:220:5: validate_condition[c]
							{
							pushFollow(FOLLOW_validate_condition_in_validation_field_modifier1070);
							validate_condition(c);
							state._fsp--;

							}
							break;

						default :
							if ( cnt22 >= 1 ) break loop22;
							EarlyExitException eee = new EarlyExitException(22, input);
							throw eee;
						}
						cnt22++;
					}

					match(input,SEMICOLON,FOLLOW_SEMICOLON_in_validation_field_modifier1076); 
					}
					break;
				case 2 :
					// api.g:221:4: ASTART ASTOP ( validate_condition[c] )+ SEMICOLON
					{
					match(input,ASTART,FOLLOW_ASTART_in_validation_field_modifier1081); 
					match(input,ASTOP,FOLLOW_ASTOP_in_validation_field_modifier1083); 
					 
							ValidationFieldCondition c = validation.createValidationFieldCondition(name, false, true, context);
						
					// api.g:223:4: ( validate_condition[c] )+
					int cnt23=0;
					loop23:
					while (true) {
						int alt23=2;
						int LA23_0 = input.LA(1);
						if ( (LA23_0==ASTART||LA23_0==NOT||LA23_0==STRING) ) {
							alt23=1;
						}

						switch (alt23) {
						case 1 :
							// api.g:223:5: validate_condition[c]
							{
							pushFollow(FOLLOW_validate_condition_in_validation_field_modifier1088);
							validate_condition(c);
							state._fsp--;

							}
							break;

						default :
							if ( cnt23 >= 1 ) break loop23;
							EarlyExitException eee = new EarlyExitException(23, input);
							throw eee;
						}
						cnt23++;
					}

					match(input,SEMICOLON,FOLLOW_SEMICOLON_in_validation_field_modifier1094); 
					}
					break;
				case 3 :
					// api.g:224:4: START END ( validate_condition[c] )+ SEMICOLON
					{
					match(input,START,FOLLOW_START_in_validation_field_modifier1099); 
					match(input,END,FOLLOW_END_in_validation_field_modifier1101); 

							ValidationFieldCondition c = validation.createValidationFieldCondition(name, true, false, context);	
						
					// api.g:226:4: ( validate_condition[c] )+
					int cnt24=0;
					loop24:
					while (true) {
						int alt24=2;
						int LA24_0 = input.LA(1);
						if ( (LA24_0==ASTART||LA24_0==NOT||LA24_0==STRING) ) {
							alt24=1;
						}

						switch (alt24) {
						case 1 :
							// api.g:226:5: validate_condition[c]
							{
							pushFollow(FOLLOW_validate_condition_in_validation_field_modifier1106);
							validate_condition(c);
							state._fsp--;

							}
							break;

						default :
							if ( cnt24 >= 1 ) break loop24;
							EarlyExitException eee = new EarlyExitException(24, input);
							throw eee;
						}
						cnt24++;
					}

					match(input,SEMICOLON,FOLLOW_SEMICOLON_in_validation_field_modifier1112); 
					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "validation_field_modifier"



	// $ANTLR start "validate_optional"
	// api.g:229:1: validate_optional[Function fun] : (| validate_statment[fun] );
	public final void validate_optional(Function fun) throws RecognitionException {
		try {
			// api.g:230:2: (| validate_statment[fun] )
			int alt26=2;
			int LA26_0 = input.LA(1);
			if ( (LA26_0==SEMICOLON) ) {
				alt26=1;
			}
			else if ( (LA26_0==VALIDATE) ) {
				alt26=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 26, 0, input);
				throw nvae;
			}

			switch (alt26) {
				case 1 :
					// api.g:231:2: 
					{
					}
					break;
				case 2 :
					// api.g:231:4: validate_statment[fun]
					{
					pushFollow(FOLLOW_validate_statment_in_validate_optional1129);
					validate_statment(fun);
					state._fsp--;

					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "validate_optional"



	// $ANTLR start "validate_statment"
	// api.g:234:1: validate_statment[Function fun] : VALIDATE START ( validate_field[fun] )* END ;
	public final void validate_statment(Function fun) throws RecognitionException {
		try {
			// api.g:235:2: ( VALIDATE START ( validate_field[fun] )* END )
			// api.g:235:4: VALIDATE START ( validate_field[fun] )* END
			{
			match(input,VALIDATE,FOLLOW_VALIDATE_in_validate_statment1145); 
			match(input,START,FOLLOW_START_in_validate_statment1147); 
			// api.g:236:2: ( validate_field[fun] )*
			loop27:
			while (true) {
				int alt27=2;
				int LA27_0 = input.LA(1);
				if ( (LA27_0==ID) ) {
					alt27=1;
				}

				switch (alt27) {
				case 1 :
					// api.g:236:3: validate_field[fun]
					{
					pushFollow(FOLLOW_validate_field_in_validate_statment1152);
					validate_field(fun);
					state._fsp--;

					}
					break;

				default :
					break loop27;
				}
			}

			match(input,END,FOLLOW_END_in_validate_statment1159); 
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "validate_statment"



	// $ANTLR start "validate_field"
	// api.g:240:1: validate_field[Function fun] : ID validate_field_modifier[fun, $ID.text, new Context( $ID )] ;
	public final void validate_field(Function fun) throws RecognitionException {
		Token ID34=null;

		try {
			// api.g:241:2: ( ID validate_field_modifier[fun, $ID.text, new Context( $ID )] )
			// api.g:241:4: ID validate_field_modifier[fun, $ID.text, new Context( $ID )]
			{
			ID34=(Token)match(input,ID,FOLLOW_ID_in_validate_field1173); 
			pushFollow(FOLLOW_validate_field_modifier_in_validate_field1175);
			validate_field_modifier(fun, (ID34!=null?ID34.getText():null), new Context( ID34 ));
			state._fsp--;

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "validate_field"



	// $ANTLR start "validate_field_modifier"
	// api.g:244:1: validate_field_modifier[Function fun, String name, Context context] : ( validate_field_end[c] | ASTART ASTOP validate_field_end[c] | START END validate_field_end[c] );
	public final void validate_field_modifier(Function fun, String name, Context context) throws RecognitionException {
		try {
			// api.g:245:2: ( validate_field_end[c] | ASTART ASTOP validate_field_end[c] | START END validate_field_end[c] )
			int alt28=3;
			switch ( input.LA(1) ) {
			case NOT:
			case SEMICOLON:
			case STRING:
				{
				alt28=1;
				}
				break;
			case ASTART:
				{
				int LA28_2 = input.LA(2);
				if ( (LA28_2==ASTOP) ) {
					alt28=2;
				}
				else if ( (LA28_2==DOTDOT||LA28_2==INT) ) {
					alt28=1;
				}

				else {
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 28, 2, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

				}
				break;
			case START:
				{
				alt28=3;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 28, 0, input);
				throw nvae;
			}
			switch (alt28) {
				case 1 :
					// api.g:245:4: validate_field_end[c]
					{

							ValidationFieldCondition c = fun.createValidationFieldCondition(name, false, false, context);	
						
					pushFollow(FOLLOW_validate_field_end_in_validate_field_modifier1193);
					validate_field_end(c);
					state._fsp--;

					}
					break;
				case 2 :
					// api.g:248:4: ASTART ASTOP validate_field_end[c]
					{
					match(input,ASTART,FOLLOW_ASTART_in_validate_field_modifier1200); 
					match(input,ASTOP,FOLLOW_ASTOP_in_validate_field_modifier1202); 

							ValidationFieldCondition c = fun.createValidationFieldCondition(name, false, true, context);	
						
					pushFollow(FOLLOW_validate_field_end_in_validate_field_modifier1206);
					validate_field_end(c);
					state._fsp--;

					}
					break;
				case 3 :
					// api.g:251:4: START END validate_field_end[c]
					{
					match(input,START,FOLLOW_START_in_validate_field_modifier1213); 
					match(input,END,FOLLOW_END_in_validate_field_modifier1215); 

							ValidationFieldCondition c = fun.createValidationFieldCondition(name, true, false, context);	
						
					pushFollow(FOLLOW_validate_field_end_in_validate_field_modifier1219);
					validate_field_end(c);
					state._fsp--;

					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "validate_field_modifier"



	// $ANTLR start "validate_field_end"
	// api.g:256:1: validate_field_end[ValidationFieldCondition v] : ( SEMICOLON | ( validate_condition[v] )+ SEMICOLON );
	public final void validate_field_end(ValidationFieldCondition v) throws RecognitionException {
		try {
			// api.g:257:2: ( SEMICOLON | ( validate_condition[v] )+ SEMICOLON )
			int alt30=2;
			int LA30_0 = input.LA(1);
			if ( (LA30_0==SEMICOLON) ) {
				alt30=1;
			}
			else if ( (LA30_0==ASTART||LA30_0==NOT||LA30_0==STRING) ) {
				alt30=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 30, 0, input);
				throw nvae;
			}

			switch (alt30) {
				case 1 :
					// api.g:257:4: SEMICOLON
					{
					match(input,SEMICOLON,FOLLOW_SEMICOLON_in_validate_field_end1235); 
					}
					break;
				case 2 :
					// api.g:258:4: ( validate_condition[v] )+ SEMICOLON
					{
					// api.g:258:4: ( validate_condition[v] )+
					int cnt29=0;
					loop29:
					while (true) {
						int alt29=2;
						int LA29_0 = input.LA(1);
						if ( (LA29_0==ASTART||LA29_0==NOT||LA29_0==STRING) ) {
							alt29=1;
						}

						switch (alt29) {
						case 1 :
							// api.g:258:5: validate_condition[v]
							{
							pushFollow(FOLLOW_validate_condition_in_validate_field_end1241);
							validate_condition(v);
							state._fsp--;

							}
							break;

						default :
							if ( cnt29 >= 1 ) break loop29;
							EarlyExitException eee = new EarlyExitException(29, input);
							throw eee;
						}
						cnt29++;
					}

					match(input,SEMICOLON,FOLLOW_SEMICOLON_in_validate_field_end1247); 
					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "validate_field_end"



	// $ANTLR start "validate_condition"
	// api.g:261:1: validate_condition[ValidationFieldCondition v] : ( NOT do_operator[v] | range[v] | regex[v] );
	public final void validate_condition(ValidationFieldCondition v) throws RecognitionException {
		try {
			// api.g:262:2: ( NOT do_operator[v] | range[v] | regex[v] )
			int alt31=3;
			switch ( input.LA(1) ) {
			case NOT:
				{
				alt31=1;
				}
				break;
			case ASTART:
				{
				alt31=2;
				}
				break;
			case STRING:
				{
				alt31=3;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 31, 0, input);
				throw nvae;
			}
			switch (alt31) {
				case 1 :
					// api.g:262:4: NOT do_operator[v]
					{
					match(input,NOT,FOLLOW_NOT_in_validate_condition1261); 
					pushFollow(FOLLOW_do_operator_in_validate_condition1263);
					do_operator(v);
					state._fsp--;

					}
					break;
				case 2 :
					// api.g:263:4: range[v]
					{
					pushFollow(FOLLOW_range_in_validate_condition1270);
					range(v);
					state._fsp--;

					}
					break;
				case 3 :
					// api.g:264:4: regex[v]
					{
					pushFollow(FOLLOW_regex_in_validate_condition1277);
					regex(v);
					state._fsp--;

					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "validate_condition"



	// $ANTLR start "do_operator"
	// api.g:267:1: do_operator[ValidationFieldCondition v] : ( NULL | EMPTY );
	public final void do_operator(ValidationFieldCondition v) throws RecognitionException {
		Token NULL35=null;
		Token EMPTY36=null;

		try {
			// api.g:268:2: ( NULL | EMPTY )
			int alt32=2;
			int LA32_0 = input.LA(1);
			if ( (LA32_0==NULL) ) {
				alt32=1;
			}
			else if ( (LA32_0==EMPTY) ) {
				alt32=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 32, 0, input);
				throw nvae;
			}

			switch (alt32) {
				case 1 :
					// api.g:268:4: NULL
					{
					NULL35=(Token)match(input,NULL,FOLLOW_NULL_in_do_operator1292); 
					v.notNull(new Context( NULL35 ));
					}
					break;
				case 2 :
					// api.g:269:4: EMPTY
					{
					EMPTY36=(Token)match(input,EMPTY,FOLLOW_EMPTY_in_do_operator1299); 
					v.notEmpty(new Context( EMPTY36 ));
					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "do_operator"



	// $ANTLR start "regex"
	// api.g:272:1: regex[ValidationFieldCondition v] : STRING ;
	public final void regex(ValidationFieldCondition v) throws RecognitionException {
		Token STRING37=null;

		try {
			// api.g:273:2: ( STRING )
			// api.g:273:4: STRING
			{
			STRING37=(Token)match(input,STRING,FOLLOW_STRING_in_regex1315); 
			v.regex((STRING37!=null?STRING37.getText():null), new Context( STRING37 ));
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "regex"



	// $ANTLR start "range"
	// api.g:276:1: range[ValidationFieldCondition v] : ASTART start_range[v] DOTDOT end_range[v] ASTOP ;
	public final void range(ValidationFieldCondition v) throws RecognitionException {
		try {
			// api.g:277:2: ( ASTART start_range[v] DOTDOT end_range[v] ASTOP )
			// api.g:277:4: ASTART start_range[v] DOTDOT end_range[v] ASTOP
			{
			match(input,ASTART,FOLLOW_ASTART_in_range1332); 
			pushFollow(FOLLOW_start_range_in_range1336);
			start_range(v);
			state._fsp--;

			match(input,DOTDOT,FOLLOW_DOTDOT_in_range1341); 
			pushFollow(FOLLOW_end_range_in_range1344);
			end_range(v);
			state._fsp--;

			match(input,ASTOP,FOLLOW_ASTOP_in_range1349); 
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "range"



	// $ANTLR start "start_range"
	// api.g:284:1: start_range[ValidationFieldCondition v] : (| INT );
	public final void start_range(ValidationFieldCondition v) throws RecognitionException {
		Token INT38=null;

		try {
			// api.g:285:2: (| INT )
			int alt33=2;
			int LA33_0 = input.LA(1);
			if ( (LA33_0==DOTDOT) ) {
				alt33=1;
			}
			else if ( (LA33_0==INT) ) {
				alt33=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 33, 0, input);
				throw nvae;
			}

			switch (alt33) {
				case 1 :
					// api.g:286:2: 
					{
					}
					break;
				case 2 :
					// api.g:286:4: INT
					{
					INT38=(Token)match(input,INT,FOLLOW_INT_in_start_range1366); 
					v.biggerOrEq((INT38!=null?INT38.getText():null), new Context( INT38 ));
					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "start_range"



	// $ANTLR start "end_range"
	// api.g:289:1: end_range[ValidationFieldCondition v] : (| INT );
	public final void end_range(ValidationFieldCondition v) throws RecognitionException {
		Token INT39=null;

		try {
			// api.g:290:2: (| INT )
			int alt34=2;
			int LA34_0 = input.LA(1);
			if ( (LA34_0==ASTOP) ) {
				alt34=1;
			}
			else if ( (LA34_0==INT) ) {
				alt34=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 34, 0, input);
				throw nvae;
			}

			switch (alt34) {
				case 1 :
					// api.g:291:2: 
					{
					}
					break;
				case 2 :
					// api.g:291:4: INT
					{
					INT39=(Token)match(input,INT,FOLLOW_INT_in_end_range1386); 
					v.smallerOrEq((INT39!=null?INT39.getText():null), new Context( INT39 ));
					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "end_range"


	public static class number_value_return extends ParserRuleReturnScope {
	};


	// $ANTLR start "number_value"
	// api.g:294:1: number_value : ( INT | HEX );
	public final apiParser.number_value_return number_value() throws RecognitionException {
		apiParser.number_value_return retval = new apiParser.number_value_return();
		retval.start = input.LT(1);

		try {
			// api.g:295:2: ( INT | HEX )
			// api.g:
			{
			if ( input.LA(1)==HEX||input.LA(1)==INT ) {
				input.consume();
				state.errorRecovery=false;
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				throw mse;
			}
			}

			retval.stop = input.LT(-1);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "number_value"

	// Delegated rules


	protected DFA4 dfa4 = new DFA4(this);
	protected DFA13 dfa13 = new DFA13(this);
	protected DFA17 dfa17 = new DFA17(this);
	protected DFA18 dfa18 = new DFA18(this);
	static final String DFA4_eotS =
		"\14\uffff";
	static final String DFA4_eofS =
		"\14\uffff";
	static final String DFA4_minS =
		"\1\6\1\27\6\uffff\1\20\1\51\1\7\1\6";
	static final String DFA4_maxS =
		"\1\56\1\27\6\uffff\1\20\1\51\1\7\1\56";
	static final String DFA4_acceptS =
		"\2\uffff\1\1\1\2\1\3\1\4\1\5\1\6\4\uffff";
	static final String DFA4_specialS =
		"\14\uffff}>";
	static final String[] DFA4_transitionS = {
			"\1\1\10\uffff\1\2\2\uffff\1\5\7\uffff\1\4\14\uffff\1\6\3\uffff\1\3\2"+
			"\uffff\1\7",
			"\1\10",
			"",
			"",
			"",
			"",
			"",
			"",
			"\1\11",
			"\1\12",
			"\1\13",
			"\1\1\10\uffff\1\2\2\uffff\1\5\7\uffff\1\4\14\uffff\1\6\3\uffff\1\3\2"+
			"\uffff\1\7"
	};

	static final short[] DFA4_eot = DFA.unpackEncodedString(DFA4_eotS);
	static final short[] DFA4_eof = DFA.unpackEncodedString(DFA4_eofS);
	static final char[] DFA4_min = DFA.unpackEncodedStringToUnsignedChars(DFA4_minS);
	static final char[] DFA4_max = DFA.unpackEncodedStringToUnsignedChars(DFA4_maxS);
	static final short[] DFA4_accept = DFA.unpackEncodedString(DFA4_acceptS);
	static final short[] DFA4_special = DFA.unpackEncodedString(DFA4_specialS);
	static final short[][] DFA4_transition;

	static {
		int numStates = DFA4_transitionS.length;
		DFA4_transition = new short[numStates][];
		for (int i=0; i<numStates; i++) {
			DFA4_transition[i] = DFA.unpackEncodedString(DFA4_transitionS[i]);
		}
	}

	protected class DFA4 extends DFA {

		public DFA4(BaseRecognizer recognizer) {
			this.recognizer = recognizer;
			this.decisionNumber = 4;
			this.eot = DFA4_eot;
			this.eof = DFA4_eof;
			this.min = DFA4_min;
			this.max = DFA4_max;
			this.accept = DFA4_accept;
			this.special = DFA4_special;
			this.transition = DFA4_transition;
		}
		@Override
		public String getDescription() {
			return "34:1: statment[Project project] : ( enum_statment[project] | type_statment[project] | interface_statment[project] | exception_statment[project] | service_statment[project] | validation_expression[project] );";
		}
	}

	static final String DFA13_eotS =
		"\11\uffff";
	static final String DFA13_eofS =
		"\11\uffff";
	static final String DFA13_minS =
		"\1\5\1\27\3\uffff\1\20\1\51\1\7\1\5";
	static final String DFA13_maxS =
		"\1\34\1\27\3\uffff\1\20\1\51\1\7\1\34";
	static final String DFA13_acceptS =
		"\2\uffff\1\1\1\2\1\3\4\uffff";
	static final String DFA13_specialS =
		"\11\uffff}>";
	static final String[] DFA13_transitionS = {
			"\1\3\1\1\20\uffff\1\2\4\uffff\1\4",
			"\1\5",
			"",
			"",
			"",
			"\1\6",
			"\1\7",
			"\1\10",
			"\1\3\1\1\20\uffff\1\2\4\uffff\1\4"
	};

	static final short[] DFA13_eot = DFA.unpackEncodedString(DFA13_eotS);
	static final short[] DFA13_eof = DFA.unpackEncodedString(DFA13_eofS);
	static final char[] DFA13_min = DFA.unpackEncodedStringToUnsignedChars(DFA13_minS);
	static final char[] DFA13_max = DFA.unpackEncodedStringToUnsignedChars(DFA13_maxS);
	static final short[] DFA13_accept = DFA.unpackEncodedString(DFA13_acceptS);
	static final short[] DFA13_special = DFA.unpackEncodedString(DFA13_specialS);
	static final short[][] DFA13_transition;

	static {
		int numStates = DFA13_transitionS.length;
		DFA13_transition = new short[numStates][];
		for (int i=0; i<numStates; i++) {
			DFA13_transition[i] = DFA.unpackEncodedString(DFA13_transitionS[i]);
		}
	}

	protected class DFA13 extends DFA {

		public DFA13(BaseRecognizer recognizer) {
			this.recognizer = recognizer;
			this.decisionNumber = 13;
			this.eot = DFA13_eot;
			this.eof = DFA13_eof;
			this.min = DFA13_min;
			this.max = DFA13_max;
			this.accept = DFA13_accept;
			this.special = DFA13_special;
			this.transition = DFA13_transition;
		}
		@Override
		public String getDescription() {
			return "110:1: function_arg[Function fun] : ( attributes[attrList] ID function_arg_end[$ID.text, false, false, attrList, fun] | attributes[attrList] ARRAY ID function_arg_end[$ID.text, true, false, attrList, fun] | attributes[attrList] MAP ID function_arg_end[$ID.text, false, true, attrList, fun] );";
		}
	}

	static final String DFA17_eotS =
		"\11\uffff";
	static final String DFA17_eofS =
		"\11\uffff";
	static final String DFA17_minS =
		"\1\5\1\27\3\uffff\1\20\1\51\1\7\1\5";
	static final String DFA17_maxS =
		"\1\34\1\27\3\uffff\1\20\1\51\1\7\1\34";
	static final String DFA17_acceptS =
		"\2\uffff\1\1\1\2\1\3\4\uffff";
	static final String DFA17_specialS =
		"\11\uffff}>";
	static final String[] DFA17_transitionS = {
			"\1\3\1\1\20\uffff\1\2\4\uffff\1\4",
			"\1\5",
			"",
			"",
			"",
			"\1\6",
			"\1\7",
			"\1\10",
			"\1\3\1\1\20\uffff\1\2\4\uffff\1\4"
	};

	static final short[] DFA17_eot = DFA.unpackEncodedString(DFA17_eotS);
	static final short[] DFA17_eof = DFA.unpackEncodedString(DFA17_eofS);
	static final char[] DFA17_min = DFA.unpackEncodedStringToUnsignedChars(DFA17_minS);
	static final char[] DFA17_max = DFA.unpackEncodedStringToUnsignedChars(DFA17_maxS);
	static final short[] DFA17_accept = DFA.unpackEncodedString(DFA17_acceptS);
	static final short[] DFA17_special = DFA.unpackEncodedString(DFA17_specialS);
	static final short[][] DFA17_transition;

	static {
		int numStates = DFA17_transitionS.length;
		DFA17_transition = new short[numStates][];
		for (int i=0; i<numStates; i++) {
			DFA17_transition[i] = DFA.unpackEncodedString(DFA17_transitionS[i]);
		}
	}

	protected class DFA17 extends DFA {

		public DFA17(BaseRecognizer recognizer) {
			this.recognizer = recognizer;
			this.decisionNumber = 17;
			this.eot = DFA17_eot;
			this.eof = DFA17_eof;
			this.min = DFA17_min;
			this.max = DFA17_max;
			this.accept = DFA17_accept;
			this.special = DFA17_special;
			this.transition = DFA17_transition;
		}
		@Override
		public String getDescription() {
			return "146:1: type_item[TypeCommonComposite type] : ( attributes[attrList] ID type_value[$ID.text, false, false, type] | attributes[attrList] ARRAY ID type_value[$ID.text, true, false, type] | attributes[attrList] MAP ID type_value[$ID.text, false, true, type] );";
		}
	}

	static final String DFA18_eotS =
		"\12\uffff";
	static final String DFA18_eofS =
		"\12\uffff";
	static final String DFA18_minS =
		"\1\6\1\27\2\20\1\25\1\51\2\uffff\1\7\1\6";
	static final String DFA18_maxS =
		"\2\27\2\20\2\51\2\uffff\1\7\1\27";
	static final String DFA18_acceptS =
		"\6\uffff\1\2\1\1\2\uffff";
	static final String DFA18_specialS =
		"\12\uffff}>";
	static final String[] DFA18_transitionS = {
			"\1\1\20\uffff\1\2",
			"\1\3",
			"\1\4",
			"\1\5",
			"\1\7\3\uffff\1\7\17\uffff\1\6",
			"\1\10",
			"",
			"",
			"\1\11",
			"\1\1\20\uffff\1\2"
	};

	static final short[] DFA18_eot = DFA.unpackEncodedString(DFA18_eotS);
	static final short[] DFA18_eof = DFA.unpackEncodedString(DFA18_eofS);
	static final char[] DFA18_min = DFA.unpackEncodedStringToUnsignedChars(DFA18_minS);
	static final char[] DFA18_max = DFA.unpackEncodedStringToUnsignedChars(DFA18_maxS);
	static final short[] DFA18_accept = DFA.unpackEncodedString(DFA18_acceptS);
	static final short[] DFA18_special = DFA.unpackEncodedString(DFA18_specialS);
	static final short[][] DFA18_transition;

	static {
		int numStates = DFA18_transitionS.length;
		DFA18_transition = new short[numStates][];
		for (int i=0; i<numStates; i++) {
			DFA18_transition[i] = DFA.unpackEncodedString(DFA18_transitionS[i]);
		}
	}

	protected class DFA18 extends DFA {

		public DFA18(BaseRecognizer recognizer) {
			this.recognizer = recognizer;
			this.decisionNumber = 18;
			this.eot = DFA18_eot;
			this.eof = DFA18_eof;
			this.min = DFA18_min;
			this.max = DFA18_max;
			this.accept = DFA18_accept;
			this.special = DFA18_special;
			this.transition = DFA18_transition;
		}
		@Override
		public String getDescription() {
			return "174:1: enum_value[TypeEnum type_enum] : ( attributes[attrList] ID EQUAL number_value | attributes[attrList] ID EQUAL STRING );";
		}
	}

	public static final BitSet FOLLOW_header_in_start36 = new BitSet(new long[]{0x0000488004048042L});
	public static final BitSet FOLLOW_statment_in_start42 = new BitSet(new long[]{0x0000488004048042L});
	public static final BitSet FOLLOW_include_in_header60 = new BitSet(new long[]{0x0000001008000040L});
	public static final BitSet FOLLOW_module_in_header66 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_INCLUDE_in_include83 = new BitSet(new long[]{0x0000020000000000L});
	public static final BitSet FOLLOW_STRING_in_include85 = new BitSet(new long[]{0x0000000001000002L});
	public static final BitSet FOLLOW_attributes_in_module107 = new BitSet(new long[]{0x0000001000000000L});
	public static final BitSet FOLLOW_PROJECT_in_module111 = new BitSet(new long[]{0x0000000000800000L});
	public static final BitSet FOLLOW_ID_in_module113 = new BitSet(new long[]{0x0000004000000000L});
	public static final BitSet FOLLOW_SEMICOLON_in_module115 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LIB_in_module122 = new BitSet(new long[]{0x0000000000800000L});
	public static final BitSet FOLLOW_ID_in_module124 = new BitSet(new long[]{0x0000004000000000L});
	public static final BitSet FOLLOW_SEMICOLON_in_module126 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_enum_statment_in_statment142 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_type_statment_in_statment149 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_interface_statment_in_statment156 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_exception_statment_in_statment163 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_service_statment_in_statment170 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_validation_expression_in_statment177 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_attributes_in_service_statment197 = new BitSet(new long[]{0x0000008000000000L});
	public static final BitSet FOLLOW_SERVICE_in_service_statment201 = new BitSet(new long[]{0x0000000000800000L});
	public static final BitSet FOLLOW_ID_in_service_statment206 = new BitSet(new long[]{0x0000004000000200L});
	public static final BitSet FOLLOW_interface_inh_in_service_statment213 = new BitSet(new long[]{0x0000004000000000L});
	public static final BitSet FOLLOW_SEMICOLON_in_service_statment220 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_attributes_in_interface_statment241 = new BitSet(new long[]{0x0000000004000000L});
	public static final BitSet FOLLOW_INTERFACE_in_interface_statment245 = new BitSet(new long[]{0x0000000000800000L});
	public static final BitSet FOLLOW_ID_in_interface_statment250 = new BitSet(new long[]{0x0000010000000200L});
	public static final BitSet FOLLOW_interface_inh_in_interface_statment257 = new BitSet(new long[]{0x0000010000000000L});
	public static final BitSet FOLLOW_START_in_interface_statment264 = new BitSet(new long[]{0x0000000010804060L});
	public static final BitSet FOLLOW_function_in_interface_statment271 = new BitSet(new long[]{0x0000000010804060L});
	public static final BitSet FOLLOW_END_in_interface_statment283 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_COLON_in_interface_inh300 = new BitSet(new long[]{0x0000000000800000L});
	public static final BitSet FOLLOW_ID_in_interface_inh302 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_interface_inh_end_in_interface_inh306 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_COMMA_in_interface_inh_end324 = new BitSet(new long[]{0x0000000000800000L});
	public static final BitSet FOLLOW_ID_in_interface_inh_end326 = new BitSet(new long[]{0x0000000000000402L});
	public static final BitSet FOLLOW_attributes_in_function352 = new BitSet(new long[]{0x0000000010800020L});
	public static final BitSet FOLLOW_function_ret_in_function356 = new BitSet(new long[]{0x0000000000800000L});
	public static final BitSet FOLLOW_ID_in_function364 = new BitSet(new long[]{0x0000000800000000L});
	public static final BitSet FOLLOW_function_end_in_function372 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_POPEN_in_function_end388 = new BitSet(new long[]{0x0000000010800060L});
	public static final BitSet FOLLOW_function_args_in_function_end390 = new BitSet(new long[]{0x0000000400000000L});
	public static final BitSet FOLLOW_PCLOSE_in_function_end394 = new BitSet(new long[]{0x0000244000000000L});
	public static final BitSet FOLLOW_function_throws_in_function_end396 = new BitSet(new long[]{0x0000204000000000L});
	public static final BitSet FOLLOW_validate_optional_in_function_end400 = new BitSet(new long[]{0x0000004000000000L});
	public static final BitSet FOLLOW_SEMICOLON_in_function_end404 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_POPEN_in_function_end409 = new BitSet(new long[]{0x0000000400000000L});
	public static final BitSet FOLLOW_PCLOSE_in_function_end411 = new BitSet(new long[]{0x0000244000000000L});
	public static final BitSet FOLLOW_function_throws_in_function_end413 = new BitSet(new long[]{0x0000204000000000L});
	public static final BitSet FOLLOW_validate_optional_in_function_end417 = new BitSet(new long[]{0x0000004000000000L});
	public static final BitSet FOLLOW_SEMICOLON_in_function_end421 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_THROWS_in_function_throws437 = new BitSet(new long[]{0x0000000000800000L});
	public static final BitSet FOLLOW_ID_in_function_throws439 = new BitSet(new long[]{0x0000000000000402L});
	public static final BitSet FOLLOW_function_throws_more_in_function_throws448 = new BitSet(new long[]{0x0000000000000402L});
	public static final BitSet FOLLOW_COMMA_in_function_throws_more466 = new BitSet(new long[]{0x0000000000800000L});
	public static final BitSet FOLLOW_ID_in_function_throws_more468 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ID_in_function_ret486 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ARRAY_in_function_ret493 = new BitSet(new long[]{0x0000000000800000L});
	public static final BitSet FOLLOW_ID_in_function_ret495 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_MAP_in_function_ret502 = new BitSet(new long[]{0x0000000000800000L});
	public static final BitSet FOLLOW_ID_in_function_ret504 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_function_arg_in_function_args522 = new BitSet(new long[]{0x0000000000000402L});
	public static final BitSet FOLLOW_COMMA_in_function_args528 = new BitSet(new long[]{0x0000000010800060L});
	public static final BitSet FOLLOW_function_arg_in_function_args530 = new BitSet(new long[]{0x0000000000000402L});
	public static final BitSet FOLLOW_attributes_in_function_arg557 = new BitSet(new long[]{0x0000000000800000L});
	public static final BitSet FOLLOW_ID_in_function_arg561 = new BitSet(new long[]{0x0000000000800000L});
	public static final BitSet FOLLOW_function_arg_end_in_function_arg563 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_attributes_in_function_arg571 = new BitSet(new long[]{0x0000000000000020L});
	public static final BitSet FOLLOW_ARRAY_in_function_arg575 = new BitSet(new long[]{0x0000000000800000L});
	public static final BitSet FOLLOW_ID_in_function_arg577 = new BitSet(new long[]{0x0000000000800000L});
	public static final BitSet FOLLOW_function_arg_end_in_function_arg579 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_attributes_in_function_arg586 = new BitSet(new long[]{0x0000000010000000L});
	public static final BitSet FOLLOW_MAP_in_function_arg590 = new BitSet(new long[]{0x0000000000800000L});
	public static final BitSet FOLLOW_ID_in_function_arg592 = new BitSet(new long[]{0x0000000000800000L});
	public static final BitSet FOLLOW_function_arg_end_in_function_arg594 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ID_in_function_arg_end609 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_attributes_in_exception_statment628 = new BitSet(new long[]{0x0000000000040000L});
	public static final BitSet FOLLOW_EXCEPTION_in_exception_statment632 = new BitSet(new long[]{0x0000000000800000L});
	public static final BitSet FOLLOW_ID_in_exception_statment637 = new BitSet(new long[]{0x0000010000000200L});
	public static final BitSet FOLLOW_type_end_in_exception_statment644 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_attributes_in_type_statment667 = new BitSet(new long[]{0x0000080000000000L});
	public static final BitSet FOLLOW_TYPE_in_type_statment671 = new BitSet(new long[]{0x0000000000800000L});
	public static final BitSet FOLLOW_ID_in_type_statment676 = new BitSet(new long[]{0x0000010000000200L});
	public static final BitSet FOLLOW_type_end_in_type_statment683 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_START_in_type_end698 = new BitSet(new long[]{0x0000000010804060L});
	public static final BitSet FOLLOW_type_item_in_type_end702 = new BitSet(new long[]{0x0000000010804060L});
	public static final BitSet FOLLOW_END_in_type_end709 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_COLON_in_type_end714 = new BitSet(new long[]{0x0000000000800000L});
	public static final BitSet FOLLOW_ID_in_type_end716 = new BitSet(new long[]{0x0000010000000000L});
	public static final BitSet FOLLOW_START_in_type_end718 = new BitSet(new long[]{0x0000000010804060L});
	public static final BitSet FOLLOW_type_item_in_type_end722 = new BitSet(new long[]{0x0000000010804060L});
	public static final BitSet FOLLOW_END_in_type_end729 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_attributes_in_type_item751 = new BitSet(new long[]{0x0000000000800000L});
	public static final BitSet FOLLOW_ID_in_type_item755 = new BitSet(new long[]{0x0000000000800000L});
	public static final BitSet FOLLOW_type_value_in_type_item757 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_attributes_in_type_item763 = new BitSet(new long[]{0x0000000000000020L});
	public static final BitSet FOLLOW_ARRAY_in_type_item767 = new BitSet(new long[]{0x0000000000800000L});
	public static final BitSet FOLLOW_ID_in_type_item769 = new BitSet(new long[]{0x0000000000800000L});
	public static final BitSet FOLLOW_type_value_in_type_item771 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_attributes_in_type_item777 = new BitSet(new long[]{0x0000000010000000L});
	public static final BitSet FOLLOW_MAP_in_type_item781 = new BitSet(new long[]{0x0000000000800000L});
	public static final BitSet FOLLOW_ID_in_type_item783 = new BitSet(new long[]{0x0000000000800000L});
	public static final BitSet FOLLOW_type_value_in_type_item785 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ID_in_type_value799 = new BitSet(new long[]{0x0000004000000000L});
	public static final BitSet FOLLOW_SEMICOLON_in_type_value801 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_attributes_in_enum_statment824 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_ENUM_in_enum_statment831 = new BitSet(new long[]{0x0000000000800000L});
	public static final BitSet FOLLOW_ID_in_enum_statment836 = new BitSet(new long[]{0x0000010000000000L});
	public static final BitSet FOLLOW_START_in_enum_statment843 = new BitSet(new long[]{0x0000000000800040L});
	public static final BitSet FOLLOW_enum_values_in_enum_statment848 = new BitSet(new long[]{0x0000000000004000L});
	public static final BitSet FOLLOW_END_in_enum_statment855 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_attributes_in_enum_value876 = new BitSet(new long[]{0x0000000000800000L});
	public static final BitSet FOLLOW_ID_in_enum_value880 = new BitSet(new long[]{0x0000000000010000L});
	public static final BitSet FOLLOW_EQUAL_in_enum_value882 = new BitSet(new long[]{0x0000000002200000L});
	public static final BitSet FOLLOW_number_value_in_enum_value884 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_attributes_in_enum_value891 = new BitSet(new long[]{0x0000000000800000L});
	public static final BitSet FOLLOW_ID_in_enum_value895 = new BitSet(new long[]{0x0000000000010000L});
	public static final BitSet FOLLOW_EQUAL_in_enum_value897 = new BitSet(new long[]{0x0000020000000000L});
	public static final BitSet FOLLOW_STRING_in_enum_value899 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_enum_value_in_enum_values915 = new BitSet(new long[]{0x0000000000000402L});
	public static final BitSet FOLLOW_COMMA_in_enum_values922 = new BitSet(new long[]{0x0000000000800040L});
	public static final BitSet FOLLOW_enum_value_in_enum_values924 = new BitSet(new long[]{0x0000000000000402L});
	public static final BitSet FOLLOW_ASTART_in_attribute943 = new BitSet(new long[]{0x0000000000800000L});
	public static final BitSet FOLLOW_ID_in_attribute945 = new BitSet(new long[]{0x0000000000010000L});
	public static final BitSet FOLLOW_EQUAL_in_attribute947 = new BitSet(new long[]{0x0000020000000000L});
	public static final BitSet FOLLOW_STRING_in_attribute949 = new BitSet(new long[]{0x0000000000000080L});
	public static final BitSet FOLLOW_ASTOP_in_attribute951 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_attribute_in_attributes968 = new BitSet(new long[]{0x0000000000000042L});
	public static final BitSet FOLLOW_attributes_in_validation_expression992 = new BitSet(new long[]{0x0000400000000000L});
	public static final BitSet FOLLOW_VALIDATION_in_validation_expression996 = new BitSet(new long[]{0x0000000000800000L});
	public static final BitSet FOLLOW_ID_in_validation_expression998 = new BitSet(new long[]{0x0000000000100000L});
	public static final BitSet FOLLOW_validation_expression_end_in_validation_expression1003 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_FOR_in_validation_expression_end1018 = new BitSet(new long[]{0x0000000000800000L});
	public static final BitSet FOLLOW_ID_in_validation_expression_end1020 = new BitSet(new long[]{0x0000010000000000L});
	public static final BitSet FOLLOW_START_in_validation_expression_end1024 = new BitSet(new long[]{0x0000000000804000L});
	public static final BitSet FOLLOW_validation_field_in_validation_expression_end1028 = new BitSet(new long[]{0x0000000000804000L});
	public static final BitSet FOLLOW_END_in_validation_expression_end1035 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ID_in_validation_field1049 = new BitSet(new long[]{0x0000030040000040L});
	public static final BitSet FOLLOW_validation_field_modifier_in_validation_field1051 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_validate_condition_in_validation_field_modifier1070 = new BitSet(new long[]{0x0000024040000040L});
	public static final BitSet FOLLOW_SEMICOLON_in_validation_field_modifier1076 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ASTART_in_validation_field_modifier1081 = new BitSet(new long[]{0x0000000000000080L});
	public static final BitSet FOLLOW_ASTOP_in_validation_field_modifier1083 = new BitSet(new long[]{0x0000020040000040L});
	public static final BitSet FOLLOW_validate_condition_in_validation_field_modifier1088 = new BitSet(new long[]{0x0000024040000040L});
	public static final BitSet FOLLOW_SEMICOLON_in_validation_field_modifier1094 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_START_in_validation_field_modifier1099 = new BitSet(new long[]{0x0000000000004000L});
	public static final BitSet FOLLOW_END_in_validation_field_modifier1101 = new BitSet(new long[]{0x0000020040000040L});
	public static final BitSet FOLLOW_validate_condition_in_validation_field_modifier1106 = new BitSet(new long[]{0x0000024040000040L});
	public static final BitSet FOLLOW_SEMICOLON_in_validation_field_modifier1112 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_validate_statment_in_validate_optional1129 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_VALIDATE_in_validate_statment1145 = new BitSet(new long[]{0x0000010000000000L});
	public static final BitSet FOLLOW_START_in_validate_statment1147 = new BitSet(new long[]{0x0000000000804000L});
	public static final BitSet FOLLOW_validate_field_in_validate_statment1152 = new BitSet(new long[]{0x0000000000804000L});
	public static final BitSet FOLLOW_END_in_validate_statment1159 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ID_in_validate_field1173 = new BitSet(new long[]{0x0000034040000040L});
	public static final BitSet FOLLOW_validate_field_modifier_in_validate_field1175 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_validate_field_end_in_validate_field_modifier1193 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ASTART_in_validate_field_modifier1200 = new BitSet(new long[]{0x0000000000000080L});
	public static final BitSet FOLLOW_ASTOP_in_validate_field_modifier1202 = new BitSet(new long[]{0x0000024040000040L});
	public static final BitSet FOLLOW_validate_field_end_in_validate_field_modifier1206 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_START_in_validate_field_modifier1213 = new BitSet(new long[]{0x0000000000004000L});
	public static final BitSet FOLLOW_END_in_validate_field_modifier1215 = new BitSet(new long[]{0x0000024040000040L});
	public static final BitSet FOLLOW_validate_field_end_in_validate_field_modifier1219 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_SEMICOLON_in_validate_field_end1235 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_validate_condition_in_validate_field_end1241 = new BitSet(new long[]{0x0000024040000040L});
	public static final BitSet FOLLOW_SEMICOLON_in_validate_field_end1247 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NOT_in_validate_condition1261 = new BitSet(new long[]{0x0000000080002000L});
	public static final BitSet FOLLOW_do_operator_in_validate_condition1263 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_range_in_validate_condition1270 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_regex_in_validate_condition1277 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NULL_in_do_operator1292 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_EMPTY_in_do_operator1299 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_STRING_in_regex1315 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ASTART_in_range1332 = new BitSet(new long[]{0x0000000002001000L});
	public static final BitSet FOLLOW_start_range_in_range1336 = new BitSet(new long[]{0x0000000000001000L});
	public static final BitSet FOLLOW_DOTDOT_in_range1341 = new BitSet(new long[]{0x0000000002000080L});
	public static final BitSet FOLLOW_end_range_in_range1344 = new BitSet(new long[]{0x0000000000000080L});
	public static final BitSet FOLLOW_ASTOP_in_range1349 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_INT_in_start_range1366 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_INT_in_end_range1386 = new BitSet(new long[]{0x0000000000000002L});
}
