// $ANTLR 3.5.2 api.g 2017-03-25 17:01:57

package com.amit.api.compiler.parser;

import com.amit.api.compiler.model.*;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class apiParser extends Parser {
	public static final String[] tokenNames = new String[] {
		"<invalid>", "<EOR>", "<DOWN>", "<UP>", "ARRAY", "ASTART", "ASTOP", "CHAR", 
		"COLON", "COMMA", "COMMENT", "END", "ENUM", "EQUAL", "ESC_SEQ", "EXCEPTION", 
		"EXPONENT", "FLOAT", "HEX", "HEX_DIGIT", "ID", "INCLUDE", "INT", "INTERFACE", 
		"LIB", "MAP", "MINUS", "OCTAL_ESC", "PCLOSE", "POPEN", "PROJECT", "REQUIRED", 
		"SEMICOLON", "SERVICE", "START", "STRING", "THROWS", "TYPE", "UNICODE_ESC", 
		"WS"
	};
	public static final int EOF=-1;
	public static final int ARRAY=4;
	public static final int ASTART=5;
	public static final int ASTOP=6;
	public static final int CHAR=7;
	public static final int COLON=8;
	public static final int COMMA=9;
	public static final int COMMENT=10;
	public static final int END=11;
	public static final int ENUM=12;
	public static final int EQUAL=13;
	public static final int ESC_SEQ=14;
	public static final int EXCEPTION=15;
	public static final int EXPONENT=16;
	public static final int FLOAT=17;
	public static final int HEX=18;
	public static final int HEX_DIGIT=19;
	public static final int ID=20;
	public static final int INCLUDE=21;
	public static final int INT=22;
	public static final int INTERFACE=23;
	public static final int LIB=24;
	public static final int MAP=25;
	public static final int MINUS=26;
	public static final int OCTAL_ESC=27;
	public static final int PCLOSE=28;
	public static final int POPEN=29;
	public static final int PROJECT=30;
	public static final int REQUIRED=31;
	public static final int SEMICOLON=32;
	public static final int SERVICE=33;
	public static final int START=34;
	public static final int STRING=35;
	public static final int THROWS=36;
	public static final int TYPE=37;
	public static final int UNICODE_ESC=38;
	public static final int WS=39;

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
				if ( ((LA1_0 >= ARRAY && LA1_0 <= ASTART)||LA1_0==ENUM||LA1_0==EXCEPTION||LA1_0==ID||LA1_0==INTERFACE||LA1_0==MAP||(LA1_0 >= PROJECT && LA1_0 <= REQUIRED)||LA1_0==SERVICE||LA1_0==TYPE) ) {
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
			if ( ((LA3_0 >= ARRAY && LA3_0 <= ASTART)||LA3_0==ENUM||LA3_0==EXCEPTION||LA3_0==ID||LA3_0==INTERFACE||LA3_0==MAP||(LA3_0 >= PROJECT && LA3_0 <= REQUIRED)||LA3_0==SERVICE||LA3_0==TYPE) ) {
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
	// api.g:34:1: statment[Project project] : ( enum_statment[project] | type_statment[project] | interface_statment[project] | exception_statment[project] | service_statment[project] );
	public final void statment(Project project) throws RecognitionException {
		try {
			// api.g:35:2: ( enum_statment[project] | type_statment[project] | interface_statment[project] | exception_statment[project] | service_statment[project] )
			int alt4=5;
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
	// api.g:42:1: service_statment[Project project] : attributes[attrList] SERVICE ID interface_inh[service] SEMICOLON ;
	public final void service_statment(Project project) throws RecognitionException {
		Token ID3=null;


			AttributeList attrList = project.createAttributeList();

		try {
			// api.g:46:2: ( attributes[attrList] SERVICE ID interface_inh[service] SEMICOLON )
			// api.g:46:4: attributes[attrList] SERVICE ID interface_inh[service] SEMICOLON
			{
			pushFollow(FOLLOW_attributes_in_service_statment190);
			attributes(attrList);
			state._fsp--;

			match(input,SERVICE,FOLLOW_SERVICE_in_service_statment194); 
			ID3=(Token)match(input,ID,FOLLOW_ID_in_service_statment199); 
			 Service service = project.createService( (ID3!=null?ID3.getText():null), attrList, new Context( ID3 ) ); 
			pushFollow(FOLLOW_interface_inh_in_service_statment206);
			interface_inh(service);
			state._fsp--;

			match(input,SEMICOLON,FOLLOW_SEMICOLON_in_service_statment213); 
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
	// api.g:52:1: interface_statment[Project project] : attributes[attrList] INTERFACE ID interface_inh[interf] START ( function[interf] )* END ;
	public final void interface_statment(Project project) throws RecognitionException {
		Token ID4=null;


			AttributeList attrList = project.createAttributeList();

		try {
			// api.g:56:2: ( attributes[attrList] INTERFACE ID interface_inh[interf] START ( function[interf] )* END )
			// api.g:56:4: attributes[attrList] INTERFACE ID interface_inh[interf] START ( function[interf] )* END
			{
			pushFollow(FOLLOW_attributes_in_interface_statment234);
			attributes(attrList);
			state._fsp--;

			match(input,INTERFACE,FOLLOW_INTERFACE_in_interface_statment238); 
			ID4=(Token)match(input,ID,FOLLOW_ID_in_interface_statment243); 
			 Interface interf = project.createInterface( (ID4!=null?ID4.getText():null), attrList, new Context( ID4 ) ); 
			pushFollow(FOLLOW_interface_inh_in_interface_statment250);
			interface_inh(interf);
			state._fsp--;

			match(input,START,FOLLOW_START_in_interface_statment257); 
			// api.g:60:4: ( function[interf] )*
			loop5:
			while (true) {
				int alt5=2;
				int LA5_0 = input.LA(1);
				if ( ((LA5_0 >= ARRAY && LA5_0 <= ASTART)||LA5_0==ENUM||LA5_0==EXCEPTION||LA5_0==ID||LA5_0==INTERFACE||LA5_0==MAP||(LA5_0 >= PROJECT && LA5_0 <= REQUIRED)||LA5_0==SERVICE||LA5_0==TYPE) ) {
					alt5=1;
				}

				switch (alt5) {
				case 1 :
					// api.g:60:6: function[interf]
					{
					pushFollow(FOLLOW_function_in_interface_statment264);
					function(interf);
					state._fsp--;

					}
					break;

				default :
					break loop5;
				}
			}

			match(input,END,FOLLOW_END_in_interface_statment276); 
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
	// api.g:64:1: interface_inh[Interface interf] : (| COLON ID interface_inh_end[interf] );
	public final void interface_inh(Interface interf) throws RecognitionException {
		Token ID5=null;

		try {
			// api.g:65:2: (| COLON ID interface_inh_end[interf] )
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
					// api.g:66:2: 
					{
					}
					break;
				case 2 :
					// api.g:66:4: COLON ID interface_inh_end[interf]
					{
					match(input,COLON,FOLLOW_COLON_in_interface_inh293); 
					ID5=(Token)match(input,ID,FOLLOW_ID_in_interface_inh295); 
					 interf.addBaseInterface( (ID5!=null?ID5.getText():null)); 
					pushFollow(FOLLOW_interface_inh_end_in_interface_inh299);
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
	// api.g:69:1: interface_inh_end[Interface interf] : ( COMMA ID )* ;
	public final void interface_inh_end(Interface interf) throws RecognitionException {
		Token ID6=null;

		try {
			// api.g:70:2: ( ( COMMA ID )* )
			// api.g:70:4: ( COMMA ID )*
			{
			// api.g:70:4: ( COMMA ID )*
			loop7:
			while (true) {
				int alt7=2;
				int LA7_0 = input.LA(1);
				if ( (LA7_0==COMMA) ) {
					alt7=1;
				}

				switch (alt7) {
				case 1 :
					// api.g:70:6: COMMA ID
					{
					match(input,COMMA,FOLLOW_COMMA_in_interface_inh_end317); 
					ID6=(Token)match(input,ID,FOLLOW_ID_in_interface_inh_end319); 
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
	// api.g:73:1: function[Interface interf] : attributes[attrList] function_ret[returnType,interf] ID function_end[fun] ;
	public final void function(Interface interf) throws RecognitionException {
		Token ID7=null;


			AttributeList attrList = interf.createAttributeList();
			ReturnValue<FunctionReturn> returnType = new ReturnValue<FunctionReturn>(); 

		try {
			// api.g:78:2: ( attributes[attrList] function_ret[returnType,interf] ID function_end[fun] )
			// api.g:78:4: attributes[attrList] function_ret[returnType,interf] ID function_end[fun]
			{
			pushFollow(FOLLOW_attributes_in_function345);
			attributes(attrList);
			state._fsp--;

			pushFollow(FOLLOW_function_ret_in_function349);
			function_ret(returnType, interf);
			state._fsp--;

			ID7=(Token)match(input,ID,FOLLOW_ID_in_function357); 
			 Function fun = interf.createFunction( (ID7!=null?ID7.getText():null), returnType.get(), attrList, new Context( ID7 ) ); 
			pushFollow(FOLLOW_function_end_in_function365);
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
	// api.g:83:1: function_end[Function fun] : ( POPEN function_args[fun] PCLOSE function_throws[fun] SEMICOLON | POPEN PCLOSE function_throws[fun] SEMICOLON );
	public final void function_end(Function fun) throws RecognitionException {
		try {
			// api.g:84:2: ( POPEN function_args[fun] PCLOSE function_throws[fun] SEMICOLON | POPEN PCLOSE function_throws[fun] SEMICOLON )
			int alt8=2;
			int LA8_0 = input.LA(1);
			if ( (LA8_0==POPEN) ) {
				int LA8_1 = input.LA(2);
				if ( (LA8_1==PCLOSE) ) {
					alt8=2;
				}
				else if ( ((LA8_1 >= ARRAY && LA8_1 <= ASTART)||LA8_1==ID||LA8_1==MAP||LA8_1==REQUIRED) ) {
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
					// api.g:84:4: POPEN function_args[fun] PCLOSE function_throws[fun] SEMICOLON
					{
					match(input,POPEN,FOLLOW_POPEN_in_function_end381); 
					pushFollow(FOLLOW_function_args_in_function_end383);
					function_args(fun);
					state._fsp--;

					match(input,PCLOSE,FOLLOW_PCLOSE_in_function_end387); 
					pushFollow(FOLLOW_function_throws_in_function_end389);
					function_throws(fun);
					state._fsp--;

					match(input,SEMICOLON,FOLLOW_SEMICOLON_in_function_end393); 
					}
					break;
				case 2 :
					// api.g:85:4: POPEN PCLOSE function_throws[fun] SEMICOLON
					{
					match(input,POPEN,FOLLOW_POPEN_in_function_end398); 
					match(input,PCLOSE,FOLLOW_PCLOSE_in_function_end400); 
					pushFollow(FOLLOW_function_throws_in_function_end402);
					function_throws(fun);
					state._fsp--;

					match(input,SEMICOLON,FOLLOW_SEMICOLON_in_function_end406); 
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
	// api.g:88:1: function_throws[Function fun] : (| THROWS ID ( function_throws_more[fun] )* );
	public final void function_throws(Function fun) throws RecognitionException {
		Token ID8=null;

		try {
			// api.g:89:2: (| THROWS ID ( function_throws_more[fun] )* )
			int alt10=2;
			int LA10_0 = input.LA(1);
			if ( (LA10_0==SEMICOLON) ) {
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
					// api.g:90:2: 
					{
					}
					break;
				case 2 :
					// api.g:90:4: THROWS ID ( function_throws_more[fun] )*
					{
					match(input,THROWS,FOLLOW_THROWS_in_function_throws422); 
					ID8=(Token)match(input,ID,FOLLOW_ID_in_function_throws424); 
					 fun.addThrowsException( (ID8!=null?ID8.getText():null) ); 
					// api.g:91:4: ( function_throws_more[fun] )*
					loop9:
					while (true) {
						int alt9=2;
						int LA9_0 = input.LA(1);
						if ( (LA9_0==COMMA) ) {
							alt9=1;
						}

						switch (alt9) {
						case 1 :
							// api.g:91:6: function_throws_more[fun]
							{
							pushFollow(FOLLOW_function_throws_more_in_function_throws433);
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
	// api.g:94:1: function_throws_more[Function fun] : COMMA ID ;
	public final void function_throws_more(Function fun) throws RecognitionException {
		Token ID9=null;

		try {
			// api.g:95:2: ( COMMA ID )
			// api.g:95:4: COMMA ID
			{
			match(input,COMMA,FOLLOW_COMMA_in_function_throws_more451); 
			ID9=(Token)match(input,ID,FOLLOW_ID_in_function_throws_more453); 
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
	// api.g:99:1: function_ret[ReturnValue<FunctionReturn> returnType,Interface interf] : ( ID | ARRAY ID | MAP ID );
	public final void function_ret(ReturnValue<FunctionReturn> returnType, Interface interf) throws RecognitionException {
		Token ID10=null;
		Token ID11=null;
		Token ID12=null;

		try {
			// api.g:100:2: ( ID | ARRAY ID | MAP ID )
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
					// api.g:100:4: ID
					{
					ID10=(Token)match(input,ID,FOLLOW_ID_in_function_ret471); 
					 returnType.set( interf.getProject().createFunctionReturn( (ID10!=null?ID10.getText():null), false, false, new Context( ID10 ) ) ); 
					}
					break;
				case 2 :
					// api.g:101:4: ARRAY ID
					{
					match(input,ARRAY,FOLLOW_ARRAY_in_function_ret478); 
					ID11=(Token)match(input,ID,FOLLOW_ID_in_function_ret480); 
					 returnType.set( interf.getProject().createFunctionReturn( (ID11!=null?ID11.getText():null), true, false, new Context( ID11 ) ) ); 
					}
					break;
				case 3 :
					// api.g:102:4: MAP ID
					{
					match(input,MAP,FOLLOW_MAP_in_function_ret487); 
					ID12=(Token)match(input,ID,FOLLOW_ID_in_function_ret489); 
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
	// api.g:105:1: function_args[Function fun] : function_arg[fun] ( COMMA function_arg[fun] )* ;
	public final void function_args(Function fun) throws RecognitionException {
		try {
			// api.g:106:2: ( function_arg[fun] ( COMMA function_arg[fun] )* )
			// api.g:106:4: function_arg[fun] ( COMMA function_arg[fun] )*
			{
			pushFollow(FOLLOW_function_arg_in_function_args507);
			function_arg(fun);
			state._fsp--;

			// api.g:106:23: ( COMMA function_arg[fun] )*
			loop12:
			while (true) {
				int alt12=2;
				int LA12_0 = input.LA(1);
				if ( (LA12_0==COMMA) ) {
					alt12=1;
				}

				switch (alt12) {
				case 1 :
					// api.g:106:25: COMMA function_arg[fun]
					{
					match(input,COMMA,FOLLOW_COMMA_in_function_args513); 
					pushFollow(FOLLOW_function_arg_in_function_args515);
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
	// api.g:109:1: function_arg[Function fun] : ( attributes[attrList] ID function_arg_end[$ID.text, false, false, false, attrList, fun] | attributes[attrList] ARRAY ID function_arg_end[$ID.text, false, true, false, attrList, fun] | attributes[attrList] MAP ID function_arg_end[$ID.text, false, false, true, attrList, fun] | attributes[attrList] REQUIRED ID function_arg_end[$ID.text, true, false, false, attrList, fun] | attributes[attrList] REQUIRED ARRAY ID function_arg_end[$ID.text, true, true, false, attrList, fun] | attributes[attrList] REQUIRED MAP ID function_arg_end[$ID.text, true, false, true, attrList, fun] );
	public final void function_arg(Function fun) throws RecognitionException {
		Token ID13=null;
		Token ID14=null;
		Token ID15=null;
		Token ID16=null;
		Token ID17=null;
		Token ID18=null;


			AttributeList attrList = fun.createAttributeList();

		try {
			// api.g:113:2: ( attributes[attrList] ID function_arg_end[$ID.text, false, false, false, attrList, fun] | attributes[attrList] ARRAY ID function_arg_end[$ID.text, false, true, false, attrList, fun] | attributes[attrList] MAP ID function_arg_end[$ID.text, false, false, true, attrList, fun] | attributes[attrList] REQUIRED ID function_arg_end[$ID.text, true, false, false, attrList, fun] | attributes[attrList] REQUIRED ARRAY ID function_arg_end[$ID.text, true, true, false, attrList, fun] | attributes[attrList] REQUIRED MAP ID function_arg_end[$ID.text, true, false, true, attrList, fun] )
			int alt13=6;
			alt13 = dfa13.predict(input);
			switch (alt13) {
				case 1 :
					// api.g:113:4: attributes[attrList] ID function_arg_end[$ID.text, false, false, false, attrList, fun]
					{
					pushFollow(FOLLOW_attributes_in_function_arg542);
					attributes(attrList);
					state._fsp--;

					ID13=(Token)match(input,ID,FOLLOW_ID_in_function_arg546); 
					pushFollow(FOLLOW_function_arg_end_in_function_arg548);
					function_arg_end((ID13!=null?ID13.getText():null), false, false, false, attrList, fun);
					state._fsp--;

					}
					break;
				case 2 :
					// api.g:114:4: attributes[attrList] ARRAY ID function_arg_end[$ID.text, false, true, false, attrList, fun]
					{
					pushFollow(FOLLOW_attributes_in_function_arg556);
					attributes(attrList);
					state._fsp--;

					match(input,ARRAY,FOLLOW_ARRAY_in_function_arg560); 
					ID14=(Token)match(input,ID,FOLLOW_ID_in_function_arg562); 
					pushFollow(FOLLOW_function_arg_end_in_function_arg564);
					function_arg_end((ID14!=null?ID14.getText():null), false, true, false, attrList, fun);
					state._fsp--;

					}
					break;
				case 3 :
					// api.g:115:4: attributes[attrList] MAP ID function_arg_end[$ID.text, false, false, true, attrList, fun]
					{
					pushFollow(FOLLOW_attributes_in_function_arg571);
					attributes(attrList);
					state._fsp--;

					match(input,MAP,FOLLOW_MAP_in_function_arg575); 
					ID15=(Token)match(input,ID,FOLLOW_ID_in_function_arg577); 
					pushFollow(FOLLOW_function_arg_end_in_function_arg579);
					function_arg_end((ID15!=null?ID15.getText():null), false, false, true, attrList, fun);
					state._fsp--;

					}
					break;
				case 4 :
					// api.g:116:4: attributes[attrList] REQUIRED ID function_arg_end[$ID.text, true, false, false, attrList, fun]
					{
					pushFollow(FOLLOW_attributes_in_function_arg586);
					attributes(attrList);
					state._fsp--;

					match(input,REQUIRED,FOLLOW_REQUIRED_in_function_arg590); 
					ID16=(Token)match(input,ID,FOLLOW_ID_in_function_arg592); 
					pushFollow(FOLLOW_function_arg_end_in_function_arg594);
					function_arg_end((ID16!=null?ID16.getText():null), true, false, false, attrList, fun);
					state._fsp--;

					}
					break;
				case 5 :
					// api.g:117:4: attributes[attrList] REQUIRED ARRAY ID function_arg_end[$ID.text, true, true, false, attrList, fun]
					{
					pushFollow(FOLLOW_attributes_in_function_arg601);
					attributes(attrList);
					state._fsp--;

					match(input,REQUIRED,FOLLOW_REQUIRED_in_function_arg605); 
					match(input,ARRAY,FOLLOW_ARRAY_in_function_arg607); 
					ID17=(Token)match(input,ID,FOLLOW_ID_in_function_arg609); 
					pushFollow(FOLLOW_function_arg_end_in_function_arg611);
					function_arg_end((ID17!=null?ID17.getText():null), true, true, false, attrList, fun);
					state._fsp--;

					}
					break;
				case 6 :
					// api.g:118:4: attributes[attrList] REQUIRED MAP ID function_arg_end[$ID.text, true, false, true, attrList, fun]
					{
					pushFollow(FOLLOW_attributes_in_function_arg618);
					attributes(attrList);
					state._fsp--;

					match(input,REQUIRED,FOLLOW_REQUIRED_in_function_arg622); 
					match(input,MAP,FOLLOW_MAP_in_function_arg624); 
					ID18=(Token)match(input,ID,FOLLOW_ID_in_function_arg626); 
					pushFollow(FOLLOW_function_arg_end_in_function_arg628);
					function_arg_end((ID18!=null?ID18.getText():null), true, false, true, attrList, fun);
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
	// api.g:121:1: function_arg_end[String type, boolean isRequired, boolean isArray, boolean isMap, AttributeList attrList, Function fun] : ID ;
	public final void function_arg_end(String type, boolean isRequired, boolean isArray, boolean isMap, AttributeList attrList, Function fun) throws RecognitionException {
		Token ID19=null;

		try {
			// api.g:122:2: ( ID )
			// api.g:122:4: ID
			{
			ID19=(Token)match(input,ID,FOLLOW_ID_in_function_arg_end643); 
			 fun.createArgument( type, (ID19!=null?ID19.getText():null), isRequired, isArray, isMap, attrList, new Context( ID19 ) ); 
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
	// api.g:125:1: exception_statment[Project project] : attributes[attrList] EXCEPTION ID type_end[type] ;
	public final void exception_statment(Project project) throws RecognitionException {
		Token ID20=null;


			AttributeList attrList = project.createAttributeList();

		try {
			// api.g:129:2: ( attributes[attrList] EXCEPTION ID type_end[type] )
			// api.g:129:4: attributes[attrList] EXCEPTION ID type_end[type]
			{
			pushFollow(FOLLOW_attributes_in_exception_statment662);
			attributes(attrList);
			state._fsp--;

			match(input,EXCEPTION,FOLLOW_EXCEPTION_in_exception_statment666); 
			ID20=(Token)match(input,ID,FOLLOW_ID_in_exception_statment671); 
			 TypeCommonComposite type = project.createException( (ID20!=null?ID20.getText():null), attrList, new Context( ID20 ) ); 
			pushFollow(FOLLOW_type_end_in_exception_statment678);
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
	// api.g:134:1: type_statment[Project project] : attributes[attrList] TYPE ID type_end[type] ;
	public final void type_statment(Project project) throws RecognitionException {
		Token ID21=null;


			AttributeList attrList = project.createAttributeList();

		try {
			// api.g:138:2: ( attributes[attrList] TYPE ID type_end[type] )
			// api.g:138:4: attributes[attrList] TYPE ID type_end[type]
			{
			pushFollow(FOLLOW_attributes_in_type_statment701);
			attributes(attrList);
			state._fsp--;

			match(input,TYPE,FOLLOW_TYPE_in_type_statment705); 
			ID21=(Token)match(input,ID,FOLLOW_ID_in_type_statment710); 
			 TypeCommonComposite type = project.createCompositeType( (ID21!=null?ID21.getText():null), attrList, new Context( ID21 ) ); 
			pushFollow(FOLLOW_type_end_in_type_statment717);
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
	// api.g:143:1: type_end[TypeCommonComposite type] : ( START ( type_item[type] )* END | COLON ID START ( type_item[type] )* END );
	public final void type_end(TypeCommonComposite type) throws RecognitionException {
		Token ID22=null;

		try {
			// api.g:144:2: ( START ( type_item[type] )* END | COLON ID START ( type_item[type] )* END )
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
					// api.g:144:4: START ( type_item[type] )* END
					{
					match(input,START,FOLLOW_START_in_type_end732); 
					// api.g:144:10: ( type_item[type] )*
					loop14:
					while (true) {
						int alt14=2;
						int LA14_0 = input.LA(1);
						if ( ((LA14_0 >= ARRAY && LA14_0 <= ASTART)||LA14_0==ENUM||LA14_0==EXCEPTION||LA14_0==ID||LA14_0==INTERFACE||LA14_0==MAP||(LA14_0 >= PROJECT && LA14_0 <= REQUIRED)||LA14_0==SERVICE||LA14_0==TYPE) ) {
							alt14=1;
						}

						switch (alt14) {
						case 1 :
							// api.g:144:12: type_item[type]
							{
							pushFollow(FOLLOW_type_item_in_type_end736);
							type_item(type);
							state._fsp--;

							}
							break;

						default :
							break loop14;
						}
					}

					match(input,END,FOLLOW_END_in_type_end743); 
					}
					break;
				case 2 :
					// api.g:145:4: COLON ID START ( type_item[type] )* END
					{
					match(input,COLON,FOLLOW_COLON_in_type_end748); 
					ID22=(Token)match(input,ID,FOLLOW_ID_in_type_end750); 
					match(input,START,FOLLOW_START_in_type_end752); 
					// api.g:145:19: ( type_item[type] )*
					loop15:
					while (true) {
						int alt15=2;
						int LA15_0 = input.LA(1);
						if ( ((LA15_0 >= ARRAY && LA15_0 <= ASTART)||LA15_0==ENUM||LA15_0==EXCEPTION||LA15_0==ID||LA15_0==INTERFACE||LA15_0==MAP||(LA15_0 >= PROJECT && LA15_0 <= REQUIRED)||LA15_0==SERVICE||LA15_0==TYPE) ) {
							alt15=1;
						}

						switch (alt15) {
						case 1 :
							// api.g:145:21: type_item[type]
							{
							pushFollow(FOLLOW_type_item_in_type_end756);
							type_item(type);
							state._fsp--;

							}
							break;

						default :
							break loop15;
						}
					}

					match(input,END,FOLLOW_END_in_type_end763); 
					 type.setBaseTypeName( (ID22!=null?ID22.getText():null) ); 
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
	// api.g:148:1: type_item[TypeCommonComposite type] : ( attributes[attrList] ID type_value[$ID.text, false, false, false, type] | attributes[attrList] ARRAY ID type_value[$ID.text, false, true, false, type] | attributes[attrList] MAP ID type_value[$ID.text, false, false, true, type] | attributes[attrList] REQUIRED ID type_value[$ID.text, true, false, false, type] | attributes[attrList] REQUIRED ARRAY ID type_value[$ID.text, true, true, false, type] | attributes[attrList] REQUIRED MAP ID type_value[$ID.text, true, false, true, type] );
	public final void type_item(TypeCommonComposite type) throws RecognitionException {
		Token ID23=null;
		Token ID24=null;
		Token ID25=null;
		Token ID26=null;
		Token ID27=null;
		Token ID28=null;


			AttributeList attrList = type.createAttributeList();

		try {
			// api.g:152:2: ( attributes[attrList] ID type_value[$ID.text, false, false, false, type] | attributes[attrList] ARRAY ID type_value[$ID.text, false, true, false, type] | attributes[attrList] MAP ID type_value[$ID.text, false, false, true, type] | attributes[attrList] REQUIRED ID type_value[$ID.text, true, false, false, type] | attributes[attrList] REQUIRED ARRAY ID type_value[$ID.text, true, true, false, type] | attributes[attrList] REQUIRED MAP ID type_value[$ID.text, true, false, true, type] )
			int alt17=6;
			alt17 = dfa17.predict(input);
			switch (alt17) {
				case 1 :
					// api.g:152:4: attributes[attrList] ID type_value[$ID.text, false, false, false, type]
					{
					pushFollow(FOLLOW_attributes_in_type_item785);
					attributes(attrList);
					state._fsp--;

					ID23=(Token)match(input,ID,FOLLOW_ID_in_type_item789); 
					pushFollow(FOLLOW_type_value_in_type_item791);
					type_value((ID23!=null?ID23.getText():null), false, false, false, type);
					state._fsp--;

					}
					break;
				case 2 :
					// api.g:153:4: attributes[attrList] ARRAY ID type_value[$ID.text, false, true, false, type]
					{
					pushFollow(FOLLOW_attributes_in_type_item797);
					attributes(attrList);
					state._fsp--;

					match(input,ARRAY,FOLLOW_ARRAY_in_type_item801); 
					ID24=(Token)match(input,ID,FOLLOW_ID_in_type_item803); 
					pushFollow(FOLLOW_type_value_in_type_item805);
					type_value((ID24!=null?ID24.getText():null), false, true, false, type);
					state._fsp--;

					}
					break;
				case 3 :
					// api.g:154:4: attributes[attrList] MAP ID type_value[$ID.text, false, false, true, type]
					{
					pushFollow(FOLLOW_attributes_in_type_item811);
					attributes(attrList);
					state._fsp--;

					match(input,MAP,FOLLOW_MAP_in_type_item815); 
					ID25=(Token)match(input,ID,FOLLOW_ID_in_type_item817); 
					pushFollow(FOLLOW_type_value_in_type_item819);
					type_value((ID25!=null?ID25.getText():null), false, false, true, type);
					state._fsp--;

					}
					break;
				case 4 :
					// api.g:155:4: attributes[attrList] REQUIRED ID type_value[$ID.text, true, false, false, type]
					{
					pushFollow(FOLLOW_attributes_in_type_item825);
					attributes(attrList);
					state._fsp--;

					match(input,REQUIRED,FOLLOW_REQUIRED_in_type_item829); 
					ID26=(Token)match(input,ID,FOLLOW_ID_in_type_item831); 
					pushFollow(FOLLOW_type_value_in_type_item833);
					type_value((ID26!=null?ID26.getText():null), true, false, false, type);
					state._fsp--;

					}
					break;
				case 5 :
					// api.g:156:4: attributes[attrList] REQUIRED ARRAY ID type_value[$ID.text, true, true, false, type]
					{
					pushFollow(FOLLOW_attributes_in_type_item839);
					attributes(attrList);
					state._fsp--;

					match(input,REQUIRED,FOLLOW_REQUIRED_in_type_item843); 
					match(input,ARRAY,FOLLOW_ARRAY_in_type_item845); 
					ID27=(Token)match(input,ID,FOLLOW_ID_in_type_item847); 
					pushFollow(FOLLOW_type_value_in_type_item849);
					type_value((ID27!=null?ID27.getText():null), true, true, false, type);
					state._fsp--;

					}
					break;
				case 6 :
					// api.g:157:4: attributes[attrList] REQUIRED MAP ID type_value[$ID.text, true, false, true, type]
					{
					pushFollow(FOLLOW_attributes_in_type_item855);
					attributes(attrList);
					state._fsp--;

					match(input,REQUIRED,FOLLOW_REQUIRED_in_type_item859); 
					match(input,MAP,FOLLOW_MAP_in_type_item861); 
					ID28=(Token)match(input,ID,FOLLOW_ID_in_type_item863); 
					pushFollow(FOLLOW_type_value_in_type_item865);
					type_value((ID28!=null?ID28.getText():null), true, false, true, type);
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
	// api.g:160:1: type_value[String memberType, boolean isRequired, boolean isArray, boolean isMap, TypeCommonComposite type] : ID SEMICOLON ;
	public final void type_value(String memberType, boolean isRequired, boolean isArray, boolean isMap, TypeCommonComposite type) throws RecognitionException {
		Token ID29=null;

		try {
			// api.g:161:2: ( ID SEMICOLON )
			// api.g:161:4: ID SEMICOLON
			{
			ID29=(Token)match(input,ID,FOLLOW_ID_in_type_value879); 
			match(input,SEMICOLON,FOLLOW_SEMICOLON_in_type_value881); 
			 type.addMember( memberType, (ID29!=null?ID29.getText():null), isRequired, isArray, isMap, new Context( ID29 ) ); 
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
	// api.g:164:1: enum_statment[Project project] : attributes[attrList] ENUM ID START enum_values[type_enum] END ;
	public final void enum_statment(Project project) throws RecognitionException {
		Token ID30=null;


			AttributeList attrList = project.createAttributeList();

		try {
			// api.g:168:2: ( attributes[attrList] ENUM ID START enum_values[type_enum] END )
			// api.g:168:4: attributes[attrList] ENUM ID START enum_values[type_enum] END
			{
			pushFollow(FOLLOW_attributes_in_enum_statment904);
			attributes(attrList);
			state._fsp--;

			match(input,ENUM,FOLLOW_ENUM_in_enum_statment911); 
			ID30=(Token)match(input,ID,FOLLOW_ID_in_enum_statment916); 

				  	TypeEnum type_enum = project.createEnum( (ID30!=null?ID30.getText():null), new Context( ID30 ) );
				  
			match(input,START,FOLLOW_START_in_enum_statment923); 
			pushFollow(FOLLOW_enum_values_in_enum_statment928);
			enum_values(type_enum);
			state._fsp--;

			match(input,END,FOLLOW_END_in_enum_statment935); 
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
	// api.g:179:1: enum_value[TypeEnum type_enum] : ( attributes[attrList] ID EQUAL number_value | attributes[attrList] ID EQUAL STRING );
	public final void enum_value(TypeEnum type_enum) throws RecognitionException {
		Token ID31=null;
		Token ID33=null;
		Token STRING34=null;
		ParserRuleReturnScope number_value32 =null;


			AttributeList attrList = type_enum.createAttributeList();

		try {
			// api.g:183:2: ( attributes[attrList] ID EQUAL number_value | attributes[attrList] ID EQUAL STRING )
			int alt18=2;
			alt18 = dfa18.predict(input);
			switch (alt18) {
				case 1 :
					// api.g:183:4: attributes[attrList] ID EQUAL number_value
					{
					pushFollow(FOLLOW_attributes_in_enum_value956);
					attributes(attrList);
					state._fsp--;

					ID31=(Token)match(input,ID,FOLLOW_ID_in_enum_value960); 
					match(input,EQUAL,FOLLOW_EQUAL_in_enum_value962); 
					pushFollow(FOLLOW_number_value_in_enum_value964);
					number_value32=number_value();
					state._fsp--;

					 type_enum.createValue( (ID31!=null?ID31.getText():null), ParseUtils.parseNumber( (number_value32!=null?input.toString(number_value32.start,number_value32.stop):null) ), attrList, new Context( ID31 ) ); 
					}
					break;
				case 2 :
					// api.g:184:4: attributes[attrList] ID EQUAL STRING
					{
					pushFollow(FOLLOW_attributes_in_enum_value971);
					attributes(attrList);
					state._fsp--;

					ID33=(Token)match(input,ID,FOLLOW_ID_in_enum_value975); 
					match(input,EQUAL,FOLLOW_EQUAL_in_enum_value977); 
					STRING34=(Token)match(input,STRING,FOLLOW_STRING_in_enum_value979); 
					 type_enum.createValue( (ID33!=null?ID33.getText():null), ParseUtils.parseString( (STRING34!=null?STRING34.getText():null) ), attrList, new Context( ID33 ) ); 
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
	// api.g:187:1: enum_values[TypeEnum type_enum] : enum_value[type_enum] ( COMMA enum_value[type_enum] )* ;
	public final void enum_values(TypeEnum type_enum) throws RecognitionException {
		try {
			// api.g:188:2: ( enum_value[type_enum] ( COMMA enum_value[type_enum] )* )
			// api.g:188:4: enum_value[type_enum] ( COMMA enum_value[type_enum] )*
			{
			pushFollow(FOLLOW_enum_value_in_enum_values995);
			enum_value(type_enum);
			state._fsp--;

			// api.g:189:3: ( COMMA enum_value[type_enum] )*
			loop19:
			while (true) {
				int alt19=2;
				int LA19_0 = input.LA(1);
				if ( (LA19_0==COMMA) ) {
					alt19=1;
				}

				switch (alt19) {
				case 1 :
					// api.g:189:5: COMMA enum_value[type_enum]
					{
					match(input,COMMA,FOLLOW_COMMA_in_enum_values1002); 
					pushFollow(FOLLOW_enum_value_in_enum_values1004);
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
	// api.g:192:1: attribute[AttributeList attrList] : ASTART ID EQUAL STRING ASTOP ;
	public final void attribute(AttributeList attrList) throws RecognitionException {
		Token ID35=null;
		Token STRING36=null;

		try {
			// api.g:193:2: ( ASTART ID EQUAL STRING ASTOP )
			// api.g:193:4: ASTART ID EQUAL STRING ASTOP
			{
			match(input,ASTART,FOLLOW_ASTART_in_attribute1023); 
			ID35=(Token)match(input,ID,FOLLOW_ID_in_attribute1025); 
			match(input,EQUAL,FOLLOW_EQUAL_in_attribute1027); 
			STRING36=(Token)match(input,STRING,FOLLOW_STRING_in_attribute1029); 
			match(input,ASTOP,FOLLOW_ASTOP_in_attribute1031); 
			 attrList.createAttribute( (ID35!=null?ID35.getText():null), ParseUtils.parseString( (STRING36!=null?STRING36.getText():null) ), new Context( ID35 ) ); 
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
	// api.g:196:1: attributes[AttributeList attrList] : ( attribute[attrList] )* ;
	public final void attributes(AttributeList attrList) throws RecognitionException {
		try {
			// api.g:197:2: ( ( attribute[attrList] )* )
			// api.g:197:4: ( attribute[attrList] )*
			{
			// api.g:197:4: ( attribute[attrList] )*
			loop20:
			while (true) {
				int alt20=2;
				int LA20_0 = input.LA(1);
				if ( (LA20_0==ASTART) ) {
					alt20=1;
				}

				switch (alt20) {
				case 1 :
					// api.g:197:5: attribute[attrList]
					{
					pushFollow(FOLLOW_attribute_in_attributes1048);
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


	public static class number_value_return extends ParserRuleReturnScope {
	};


	// $ANTLR start "number_value"
	// api.g:201:1: number_value : ( INT | HEX );
	public final apiParser.number_value_return number_value() throws RecognitionException {
		apiParser.number_value_return retval = new apiParser.number_value_return();
		retval.start = input.LT(1);

		try {
			// api.g:202:2: ( INT | HEX )
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
		"\13\uffff";
	static final String DFA4_eofS =
		"\13\uffff";
	static final String DFA4_minS =
		"\1\5\1\24\5\uffff\1\15\1\43\1\6\1\5";
	static final String DFA4_maxS =
		"\1\45\1\24\5\uffff\1\15\1\43\1\6\1\45";
	static final String DFA4_acceptS =
		"\2\uffff\1\1\1\2\1\3\1\4\1\5\4\uffff";
	static final String DFA4_specialS =
		"\13\uffff}>";
	static final String[] DFA4_transitionS = {
			"\1\1\6\uffff\1\2\2\uffff\1\5\7\uffff\1\4\11\uffff\1\6\3\uffff\1\3",
			"\1\7",
			"",
			"",
			"",
			"",
			"",
			"\1\10",
			"\1\11",
			"\1\12",
			"\1\1\6\uffff\1\2\2\uffff\1\5\7\uffff\1\4\11\uffff\1\6\3\uffff\1\3"
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
			return "34:1: statment[Project project] : ( enum_statment[project] | type_statment[project] | interface_statment[project] | exception_statment[project] | service_statment[project] );";
		}
	}

	static final String DFA13_eotS =
		"\15\uffff";
	static final String DFA13_eofS =
		"\15\uffff";
	static final String DFA13_minS =
		"\1\4\1\24\3\uffff\1\4\1\15\3\uffff\1\43\1\6\1\4";
	static final String DFA13_maxS =
		"\1\37\1\24\3\uffff\1\31\1\15\3\uffff\1\43\1\6\1\37";
	static final String DFA13_acceptS =
		"\2\uffff\1\1\1\2\1\3\2\uffff\1\4\1\5\1\6\3\uffff";
	static final String DFA13_specialS =
		"\15\uffff}>";
	static final String[] DFA13_transitionS = {
			"\1\3\1\1\16\uffff\1\2\4\uffff\1\4\5\uffff\1\5",
			"\1\6",
			"",
			"",
			"",
			"\1\10\17\uffff\1\7\4\uffff\1\11",
			"\1\12",
			"",
			"",
			"",
			"\1\13",
			"\1\14",
			"\1\3\1\1\16\uffff\1\2\4\uffff\1\4\5\uffff\1\5"
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
			return "109:1: function_arg[Function fun] : ( attributes[attrList] ID function_arg_end[$ID.text, false, false, false, attrList, fun] | attributes[attrList] ARRAY ID function_arg_end[$ID.text, false, true, false, attrList, fun] | attributes[attrList] MAP ID function_arg_end[$ID.text, false, false, true, attrList, fun] | attributes[attrList] REQUIRED ID function_arg_end[$ID.text, true, false, false, attrList, fun] | attributes[attrList] REQUIRED ARRAY ID function_arg_end[$ID.text, true, true, false, attrList, fun] | attributes[attrList] REQUIRED MAP ID function_arg_end[$ID.text, true, false, true, attrList, fun] );";
		}
	}

	static final String DFA17_eotS =
		"\15\uffff";
	static final String DFA17_eofS =
		"\15\uffff";
	static final String DFA17_minS =
		"\1\4\1\24\3\uffff\1\4\1\15\3\uffff\1\43\1\6\1\4";
	static final String DFA17_maxS =
		"\1\37\1\24\3\uffff\1\31\1\15\3\uffff\1\43\1\6\1\37";
	static final String DFA17_acceptS =
		"\2\uffff\1\1\1\2\1\3\2\uffff\1\4\1\5\1\6\3\uffff";
	static final String DFA17_specialS =
		"\15\uffff}>";
	static final String[] DFA17_transitionS = {
			"\1\3\1\1\16\uffff\1\2\4\uffff\1\4\5\uffff\1\5",
			"\1\6",
			"",
			"",
			"",
			"\1\10\17\uffff\1\7\4\uffff\1\11",
			"\1\12",
			"",
			"",
			"",
			"\1\13",
			"\1\14",
			"\1\3\1\1\16\uffff\1\2\4\uffff\1\4\5\uffff\1\5"
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
			return "148:1: type_item[TypeCommonComposite type] : ( attributes[attrList] ID type_value[$ID.text, false, false, false, type] | attributes[attrList] ARRAY ID type_value[$ID.text, false, true, false, type] | attributes[attrList] MAP ID type_value[$ID.text, false, false, true, type] | attributes[attrList] REQUIRED ID type_value[$ID.text, true, false, false, type] | attributes[attrList] REQUIRED ARRAY ID type_value[$ID.text, true, true, false, type] | attributes[attrList] REQUIRED MAP ID type_value[$ID.text, true, false, true, type] );";
		}
	}

	static final String DFA18_eotS =
		"\12\uffff";
	static final String DFA18_eofS =
		"\12\uffff";
	static final String DFA18_minS =
		"\1\5\1\24\2\15\1\22\1\43\2\uffff\1\6\1\5";
	static final String DFA18_maxS =
		"\2\24\2\15\2\43\2\uffff\1\6\1\24";
	static final String DFA18_acceptS =
		"\6\uffff\1\2\1\1\2\uffff";
	static final String DFA18_specialS =
		"\12\uffff}>";
	static final String[] DFA18_transitionS = {
			"\1\1\16\uffff\1\2",
			"\1\3",
			"\1\4",
			"\1\5",
			"\1\7\3\uffff\1\7\14\uffff\1\6",
			"\1\10",
			"",
			"",
			"\1\11",
			"\1\1\16\uffff\1\2"
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
			return "179:1: enum_value[TypeEnum type_enum] : ( attributes[attrList] ID EQUAL number_value | attributes[attrList] ID EQUAL STRING );";
		}
	}

	public static final BitSet FOLLOW_header_in_start36 = new BitSet(new long[]{0x0000002200809022L});
	public static final BitSet FOLLOW_statment_in_start42 = new BitSet(new long[]{0x0000002200809022L});
	public static final BitSet FOLLOW_include_in_header60 = new BitSet(new long[]{0x0000000041000020L});
	public static final BitSet FOLLOW_module_in_header66 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_INCLUDE_in_include83 = new BitSet(new long[]{0x0000000800000000L});
	public static final BitSet FOLLOW_STRING_in_include85 = new BitSet(new long[]{0x0000000000200002L});
	public static final BitSet FOLLOW_attributes_in_module107 = new BitSet(new long[]{0x0000000040000000L});
	public static final BitSet FOLLOW_PROJECT_in_module111 = new BitSet(new long[]{0x0000000000100000L});
	public static final BitSet FOLLOW_ID_in_module113 = new BitSet(new long[]{0x0000000100000000L});
	public static final BitSet FOLLOW_SEMICOLON_in_module115 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LIB_in_module122 = new BitSet(new long[]{0x0000000000100000L});
	public static final BitSet FOLLOW_ID_in_module124 = new BitSet(new long[]{0x0000000100000000L});
	public static final BitSet FOLLOW_SEMICOLON_in_module126 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_enum_statment_in_statment142 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_type_statment_in_statment149 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_interface_statment_in_statment156 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_exception_statment_in_statment163 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_service_statment_in_statment170 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_attributes_in_service_statment190 = new BitSet(new long[]{0x0000000200000000L});
	public static final BitSet FOLLOW_SERVICE_in_service_statment194 = new BitSet(new long[]{0x0000000000100000L});
	public static final BitSet FOLLOW_ID_in_service_statment199 = new BitSet(new long[]{0x0000000100000100L});
	public static final BitSet FOLLOW_interface_inh_in_service_statment206 = new BitSet(new long[]{0x0000000100000000L});
	public static final BitSet FOLLOW_SEMICOLON_in_service_statment213 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_attributes_in_interface_statment234 = new BitSet(new long[]{0x0000000000800000L});
	public static final BitSet FOLLOW_INTERFACE_in_interface_statment238 = new BitSet(new long[]{0x0000000000100000L});
	public static final BitSet FOLLOW_ID_in_interface_statment243 = new BitSet(new long[]{0x0000000400000100L});
	public static final BitSet FOLLOW_interface_inh_in_interface_statment250 = new BitSet(new long[]{0x0000000400000000L});
	public static final BitSet FOLLOW_START_in_interface_statment257 = new BitSet(new long[]{0x0000000002100830L});
	public static final BitSet FOLLOW_function_in_interface_statment264 = new BitSet(new long[]{0x0000000002100830L});
	public static final BitSet FOLLOW_END_in_interface_statment276 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_COLON_in_interface_inh293 = new BitSet(new long[]{0x0000000000100000L});
	public static final BitSet FOLLOW_ID_in_interface_inh295 = new BitSet(new long[]{0x0000000000000200L});
	public static final BitSet FOLLOW_interface_inh_end_in_interface_inh299 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_COMMA_in_interface_inh_end317 = new BitSet(new long[]{0x0000000000100000L});
	public static final BitSet FOLLOW_ID_in_interface_inh_end319 = new BitSet(new long[]{0x0000000000000202L});
	public static final BitSet FOLLOW_attributes_in_function345 = new BitSet(new long[]{0x0000000002100010L});
	public static final BitSet FOLLOW_function_ret_in_function349 = new BitSet(new long[]{0x0000000000100000L});
	public static final BitSet FOLLOW_ID_in_function357 = new BitSet(new long[]{0x0000000020000000L});
	public static final BitSet FOLLOW_function_end_in_function365 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_POPEN_in_function_end381 = new BitSet(new long[]{0x0000000082100030L});
	public static final BitSet FOLLOW_function_args_in_function_end383 = new BitSet(new long[]{0x0000000010000000L});
	public static final BitSet FOLLOW_PCLOSE_in_function_end387 = new BitSet(new long[]{0x0000001100000000L});
	public static final BitSet FOLLOW_function_throws_in_function_end389 = new BitSet(new long[]{0x0000000100000000L});
	public static final BitSet FOLLOW_SEMICOLON_in_function_end393 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_POPEN_in_function_end398 = new BitSet(new long[]{0x0000000010000000L});
	public static final BitSet FOLLOW_PCLOSE_in_function_end400 = new BitSet(new long[]{0x0000001100000000L});
	public static final BitSet FOLLOW_function_throws_in_function_end402 = new BitSet(new long[]{0x0000000100000000L});
	public static final BitSet FOLLOW_SEMICOLON_in_function_end406 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_THROWS_in_function_throws422 = new BitSet(new long[]{0x0000000000100000L});
	public static final BitSet FOLLOW_ID_in_function_throws424 = new BitSet(new long[]{0x0000000000000202L});
	public static final BitSet FOLLOW_function_throws_more_in_function_throws433 = new BitSet(new long[]{0x0000000000000202L});
	public static final BitSet FOLLOW_COMMA_in_function_throws_more451 = new BitSet(new long[]{0x0000000000100000L});
	public static final BitSet FOLLOW_ID_in_function_throws_more453 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ID_in_function_ret471 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ARRAY_in_function_ret478 = new BitSet(new long[]{0x0000000000100000L});
	public static final BitSet FOLLOW_ID_in_function_ret480 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_MAP_in_function_ret487 = new BitSet(new long[]{0x0000000000100000L});
	public static final BitSet FOLLOW_ID_in_function_ret489 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_function_arg_in_function_args507 = new BitSet(new long[]{0x0000000000000202L});
	public static final BitSet FOLLOW_COMMA_in_function_args513 = new BitSet(new long[]{0x0000000082100030L});
	public static final BitSet FOLLOW_function_arg_in_function_args515 = new BitSet(new long[]{0x0000000000000202L});
	public static final BitSet FOLLOW_attributes_in_function_arg542 = new BitSet(new long[]{0x0000000000100000L});
	public static final BitSet FOLLOW_ID_in_function_arg546 = new BitSet(new long[]{0x0000000000100000L});
	public static final BitSet FOLLOW_function_arg_end_in_function_arg548 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_attributes_in_function_arg556 = new BitSet(new long[]{0x0000000000000010L});
	public static final BitSet FOLLOW_ARRAY_in_function_arg560 = new BitSet(new long[]{0x0000000000100000L});
	public static final BitSet FOLLOW_ID_in_function_arg562 = new BitSet(new long[]{0x0000000000100000L});
	public static final BitSet FOLLOW_function_arg_end_in_function_arg564 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_attributes_in_function_arg571 = new BitSet(new long[]{0x0000000002000000L});
	public static final BitSet FOLLOW_MAP_in_function_arg575 = new BitSet(new long[]{0x0000000000100000L});
	public static final BitSet FOLLOW_ID_in_function_arg577 = new BitSet(new long[]{0x0000000000100000L});
	public static final BitSet FOLLOW_function_arg_end_in_function_arg579 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_attributes_in_function_arg586 = new BitSet(new long[]{0x0000000080000000L});
	public static final BitSet FOLLOW_REQUIRED_in_function_arg590 = new BitSet(new long[]{0x0000000000100000L});
	public static final BitSet FOLLOW_ID_in_function_arg592 = new BitSet(new long[]{0x0000000000100000L});
	public static final BitSet FOLLOW_function_arg_end_in_function_arg594 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_attributes_in_function_arg601 = new BitSet(new long[]{0x0000000080000000L});
	public static final BitSet FOLLOW_REQUIRED_in_function_arg605 = new BitSet(new long[]{0x0000000000000010L});
	public static final BitSet FOLLOW_ARRAY_in_function_arg607 = new BitSet(new long[]{0x0000000000100000L});
	public static final BitSet FOLLOW_ID_in_function_arg609 = new BitSet(new long[]{0x0000000000100000L});
	public static final BitSet FOLLOW_function_arg_end_in_function_arg611 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_attributes_in_function_arg618 = new BitSet(new long[]{0x0000000080000000L});
	public static final BitSet FOLLOW_REQUIRED_in_function_arg622 = new BitSet(new long[]{0x0000000002000000L});
	public static final BitSet FOLLOW_MAP_in_function_arg624 = new BitSet(new long[]{0x0000000000100000L});
	public static final BitSet FOLLOW_ID_in_function_arg626 = new BitSet(new long[]{0x0000000000100000L});
	public static final BitSet FOLLOW_function_arg_end_in_function_arg628 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ID_in_function_arg_end643 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_attributes_in_exception_statment662 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_EXCEPTION_in_exception_statment666 = new BitSet(new long[]{0x0000000000100000L});
	public static final BitSet FOLLOW_ID_in_exception_statment671 = new BitSet(new long[]{0x0000000400000100L});
	public static final BitSet FOLLOW_type_end_in_exception_statment678 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_attributes_in_type_statment701 = new BitSet(new long[]{0x0000002000000000L});
	public static final BitSet FOLLOW_TYPE_in_type_statment705 = new BitSet(new long[]{0x0000000000100000L});
	public static final BitSet FOLLOW_ID_in_type_statment710 = new BitSet(new long[]{0x0000000400000100L});
	public static final BitSet FOLLOW_type_end_in_type_statment717 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_START_in_type_end732 = new BitSet(new long[]{0x0000000082100830L});
	public static final BitSet FOLLOW_type_item_in_type_end736 = new BitSet(new long[]{0x0000000082100830L});
	public static final BitSet FOLLOW_END_in_type_end743 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_COLON_in_type_end748 = new BitSet(new long[]{0x0000000000100000L});
	public static final BitSet FOLLOW_ID_in_type_end750 = new BitSet(new long[]{0x0000000400000000L});
	public static final BitSet FOLLOW_START_in_type_end752 = new BitSet(new long[]{0x0000000082100830L});
	public static final BitSet FOLLOW_type_item_in_type_end756 = new BitSet(new long[]{0x0000000082100830L});
	public static final BitSet FOLLOW_END_in_type_end763 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_attributes_in_type_item785 = new BitSet(new long[]{0x0000000000100000L});
	public static final BitSet FOLLOW_ID_in_type_item789 = new BitSet(new long[]{0x0000000000100000L});
	public static final BitSet FOLLOW_type_value_in_type_item791 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_attributes_in_type_item797 = new BitSet(new long[]{0x0000000000000010L});
	public static final BitSet FOLLOW_ARRAY_in_type_item801 = new BitSet(new long[]{0x0000000000100000L});
	public static final BitSet FOLLOW_ID_in_type_item803 = new BitSet(new long[]{0x0000000000100000L});
	public static final BitSet FOLLOW_type_value_in_type_item805 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_attributes_in_type_item811 = new BitSet(new long[]{0x0000000002000000L});
	public static final BitSet FOLLOW_MAP_in_type_item815 = new BitSet(new long[]{0x0000000000100000L});
	public static final BitSet FOLLOW_ID_in_type_item817 = new BitSet(new long[]{0x0000000000100000L});
	public static final BitSet FOLLOW_type_value_in_type_item819 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_attributes_in_type_item825 = new BitSet(new long[]{0x0000000080000000L});
	public static final BitSet FOLLOW_REQUIRED_in_type_item829 = new BitSet(new long[]{0x0000000000100000L});
	public static final BitSet FOLLOW_ID_in_type_item831 = new BitSet(new long[]{0x0000000000100000L});
	public static final BitSet FOLLOW_type_value_in_type_item833 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_attributes_in_type_item839 = new BitSet(new long[]{0x0000000080000000L});
	public static final BitSet FOLLOW_REQUIRED_in_type_item843 = new BitSet(new long[]{0x0000000000000010L});
	public static final BitSet FOLLOW_ARRAY_in_type_item845 = new BitSet(new long[]{0x0000000000100000L});
	public static final BitSet FOLLOW_ID_in_type_item847 = new BitSet(new long[]{0x0000000000100000L});
	public static final BitSet FOLLOW_type_value_in_type_item849 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_attributes_in_type_item855 = new BitSet(new long[]{0x0000000080000000L});
	public static final BitSet FOLLOW_REQUIRED_in_type_item859 = new BitSet(new long[]{0x0000000002000000L});
	public static final BitSet FOLLOW_MAP_in_type_item861 = new BitSet(new long[]{0x0000000000100000L});
	public static final BitSet FOLLOW_ID_in_type_item863 = new BitSet(new long[]{0x0000000000100000L});
	public static final BitSet FOLLOW_type_value_in_type_item865 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ID_in_type_value879 = new BitSet(new long[]{0x0000000100000000L});
	public static final BitSet FOLLOW_SEMICOLON_in_type_value881 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_attributes_in_enum_statment904 = new BitSet(new long[]{0x0000000000001000L});
	public static final BitSet FOLLOW_ENUM_in_enum_statment911 = new BitSet(new long[]{0x0000000000100000L});
	public static final BitSet FOLLOW_ID_in_enum_statment916 = new BitSet(new long[]{0x0000000400000000L});
	public static final BitSet FOLLOW_START_in_enum_statment923 = new BitSet(new long[]{0x0000000000100020L});
	public static final BitSet FOLLOW_enum_values_in_enum_statment928 = new BitSet(new long[]{0x0000000000000800L});
	public static final BitSet FOLLOW_END_in_enum_statment935 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_attributes_in_enum_value956 = new BitSet(new long[]{0x0000000000100000L});
	public static final BitSet FOLLOW_ID_in_enum_value960 = new BitSet(new long[]{0x0000000000002000L});
	public static final BitSet FOLLOW_EQUAL_in_enum_value962 = new BitSet(new long[]{0x0000000000440000L});
	public static final BitSet FOLLOW_number_value_in_enum_value964 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_attributes_in_enum_value971 = new BitSet(new long[]{0x0000000000100000L});
	public static final BitSet FOLLOW_ID_in_enum_value975 = new BitSet(new long[]{0x0000000000002000L});
	public static final BitSet FOLLOW_EQUAL_in_enum_value977 = new BitSet(new long[]{0x0000000800000000L});
	public static final BitSet FOLLOW_STRING_in_enum_value979 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_enum_value_in_enum_values995 = new BitSet(new long[]{0x0000000000000202L});
	public static final BitSet FOLLOW_COMMA_in_enum_values1002 = new BitSet(new long[]{0x0000000000100020L});
	public static final BitSet FOLLOW_enum_value_in_enum_values1004 = new BitSet(new long[]{0x0000000000000202L});
	public static final BitSet FOLLOW_ASTART_in_attribute1023 = new BitSet(new long[]{0x0000000000100000L});
	public static final BitSet FOLLOW_ID_in_attribute1025 = new BitSet(new long[]{0x0000000000002000L});
	public static final BitSet FOLLOW_EQUAL_in_attribute1027 = new BitSet(new long[]{0x0000000800000000L});
	public static final BitSet FOLLOW_STRING_in_attribute1029 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_ASTOP_in_attribute1031 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_attribute_in_attributes1048 = new BitSet(new long[]{0x0000000000000022L});
}
