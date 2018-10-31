// $ANTLR 3.5.2 api.g 2018-09-27 11:46:18

package com.amit.api.compiler.parser;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class apiLexer extends Lexer {
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
	// delegators
	public Lexer[] getDelegates() {
		return new Lexer[] {};
	}

	public apiLexer() {} 
	public apiLexer(CharStream input) {
		this(input, new RecognizerSharedState());
	}
	public apiLexer(CharStream input, RecognizerSharedState state) {
		super(input,state);
	}
	@Override public String getGrammarFileName() { return "api.g"; }

	// $ANTLR start "ARRAY"
	public final void mARRAY() throws RecognitionException {
		try {
			int _type = ARRAY;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// api.g:299:2: ( 'array' )
			// api.g:299:4: 'array'
			{
			match("array"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "ARRAY"

	// $ANTLR start "MAP"
	public final void mMAP() throws RecognitionException {
		try {
			int _type = MAP;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// api.g:302:2: ( 'map' )
			// api.g:302:4: 'map'
			{
			match("map"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "MAP"

	// $ANTLR start "REQUIRED"
	public final void mREQUIRED() throws RecognitionException {
		try {
			int _type = REQUIRED;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// api.g:306:2: ( 'required' )
			// api.g:306:4: 'required'
			{
			match("required"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "REQUIRED"

	// $ANTLR start "ENUM"
	public final void mENUM() throws RecognitionException {
		try {
			int _type = ENUM;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// api.g:309:6: ( 'enum' )
			// api.g:309:8: 'enum'
			{
			match("enum"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "ENUM"

	// $ANTLR start "TYPE"
	public final void mTYPE() throws RecognitionException {
		try {
			int _type = TYPE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// api.g:312:6: ( 'type' )
			// api.g:312:8: 'type'
			{
			match("type"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "TYPE"

	// $ANTLR start "LIB"
	public final void mLIB() throws RecognitionException {
		try {
			int _type = LIB;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// api.g:315:5: ( 'lib' )
			// api.g:315:7: 'lib'
			{
			match("lib"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "LIB"

	// $ANTLR start "PROJECT"
	public final void mPROJECT() throws RecognitionException {
		try {
			int _type = PROJECT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// api.g:318:9: ( 'project' )
			// api.g:318:11: 'project'
			{
			match("project"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "PROJECT"

	// $ANTLR start "SERVICE"
	public final void mSERVICE() throws RecognitionException {
		try {
			int _type = SERVICE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// api.g:321:9: ( 'service' )
			// api.g:321:11: 'service'
			{
			match("service"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "SERVICE"

	// $ANTLR start "EXCEPTION"
	public final void mEXCEPTION() throws RecognitionException {
		try {
			int _type = EXCEPTION;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// api.g:324:11: ( 'exception' )
			// api.g:324:13: 'exception'
			{
			match("exception"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "EXCEPTION"

	// $ANTLR start "INCLUDE"
	public final void mINCLUDE() throws RecognitionException {
		try {
			int _type = INCLUDE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// api.g:327:9: ( 'include' )
			// api.g:327:11: 'include'
			{
			match("include"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "INCLUDE"

	// $ANTLR start "INTERFACE"
	public final void mINTERFACE() throws RecognitionException {
		try {
			int _type = INTERFACE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// api.g:330:11: ( 'interface' )
			// api.g:330:13: 'interface'
			{
			match("interface"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "INTERFACE"

	// $ANTLR start "THROWS"
	public final void mTHROWS() throws RecognitionException {
		try {
			int _type = THROWS;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// api.g:333:8: ( 'throws' )
			// api.g:333:10: 'throws'
			{
			match("throws"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "THROWS"

	// $ANTLR start "VALIDATE"
	public final void mVALIDATE() throws RecognitionException {
		try {
			int _type = VALIDATE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// api.g:336:10: ( 'validate' )
			// api.g:336:12: 'validate'
			{
			match("validate"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "VALIDATE"

	// $ANTLR start "VALIDATION"
	public final void mVALIDATION() throws RecognitionException {
		try {
			int _type = VALIDATION;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// api.g:339:11: ( 'validation' )
			// api.g:339:13: 'validation'
			{
			match("validation"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "VALIDATION"

	// $ANTLR start "NULL"
	public final void mNULL() throws RecognitionException {
		try {
			int _type = NULL;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// api.g:342:6: ( 'null' )
			// api.g:342:8: 'null'
			{
			match("null"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "NULL"

	// $ANTLR start "EMPTY"
	public final void mEMPTY() throws RecognitionException {
		try {
			int _type = EMPTY;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// api.g:345:7: ( 'empty' )
			// api.g:345:9: 'empty'
			{
			match("empty"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "EMPTY"

	// $ANTLR start "FOR"
	public final void mFOR() throws RecognitionException {
		try {
			int _type = FOR;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// api.g:348:5: ( 'for' )
			// api.g:348:7: 'for'
			{
			match("for"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "FOR"

	// $ANTLR start "OR"
	public final void mOR() throws RecognitionException {
		try {
			int _type = OR;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// api.g:351:4: ( 'or' )
			// api.g:351:6: 'or'
			{
			match("or"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "OR"

	// $ANTLR start "AND"
	public final void mAND() throws RecognitionException {
		try {
			int _type = AND;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// api.g:354:5: ( 'and' )
			// api.g:354:7: 'and'
			{
			match("and"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "AND"

	// $ANTLR start "ID"
	public final void mID() throws RecognitionException {
		try {
			int _type = ID;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// api.g:357:5: ( ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )* )
			// api.g:357:7: ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )*
			{
			if ( (input.LA(1) >= 'A' && input.LA(1) <= 'Z')||input.LA(1)=='_'||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			// api.g:357:31: ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )*
			loop1:
			while (true) {
				int alt1=2;
				int LA1_0 = input.LA(1);
				if ( ((LA1_0 >= '0' && LA1_0 <= '9')||(LA1_0 >= 'A' && LA1_0 <= 'Z')||LA1_0=='_'||(LA1_0 >= 'a' && LA1_0 <= 'z')) ) {
					alt1=1;
				}

				switch (alt1) {
				case 1 :
					// api.g:
					{
					if ( (input.LA(1) >= '0' && input.LA(1) <= '9')||(input.LA(1) >= 'A' && input.LA(1) <= 'Z')||input.LA(1)=='_'||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;

				default :
					break loop1;
				}
			}

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "ID"

	// $ANTLR start "INT"
	public final void mINT() throws RecognitionException {
		try {
			int _type = INT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// api.g:360:5: ( ( '0' .. '9' )+ | '-' ( '0' .. '9' )+ )
			int alt4=2;
			int LA4_0 = input.LA(1);
			if ( ((LA4_0 >= '0' && LA4_0 <= '9')) ) {
				alt4=1;
			}
			else if ( (LA4_0=='-') ) {
				alt4=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 4, 0, input);
				throw nvae;
			}

			switch (alt4) {
				case 1 :
					// api.g:360:7: ( '0' .. '9' )+
					{
					// api.g:360:7: ( '0' .. '9' )+
					int cnt2=0;
					loop2:
					while (true) {
						int alt2=2;
						int LA2_0 = input.LA(1);
						if ( ((LA2_0 >= '0' && LA2_0 <= '9')) ) {
							alt2=1;
						}

						switch (alt2) {
						case 1 :
							// api.g:
							{
							if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
								input.consume();
							}
							else {
								MismatchedSetException mse = new MismatchedSetException(null,input);
								recover(mse);
								throw mse;
							}
							}
							break;

						default :
							if ( cnt2 >= 1 ) break loop2;
							EarlyExitException eee = new EarlyExitException(2, input);
							throw eee;
						}
						cnt2++;
					}

					}
					break;
				case 2 :
					// api.g:361:4: '-' ( '0' .. '9' )+
					{
					match('-'); 
					// api.g:361:7: ( '0' .. '9' )+
					int cnt3=0;
					loop3:
					while (true) {
						int alt3=2;
						int LA3_0 = input.LA(1);
						if ( ((LA3_0 >= '0' && LA3_0 <= '9')) ) {
							alt3=1;
						}

						switch (alt3) {
						case 1 :
							// api.g:
							{
							if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
								input.consume();
							}
							else {
								MismatchedSetException mse = new MismatchedSetException(null,input);
								recover(mse);
								throw mse;
							}
							}
							break;

						default :
							if ( cnt3 >= 1 ) break loop3;
							EarlyExitException eee = new EarlyExitException(3, input);
							throw eee;
						}
						cnt3++;
					}

					}
					break;

			}
			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "INT"

	// $ANTLR start "DOTDOT"
	public final void mDOTDOT() throws RecognitionException {
		try {
			int _type = DOTDOT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// api.g:364:8: ( '..' )
			// api.g:364:10: '..'
			{
			match(".."); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "DOTDOT"

	// $ANTLR start "ASTART"
	public final void mASTART() throws RecognitionException {
		try {
			int _type = ASTART;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// api.g:367:8: ( '[' )
			// api.g:367:10: '['
			{
			match('['); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "ASTART"

	// $ANTLR start "ASTOP"
	public final void mASTOP() throws RecognitionException {
		try {
			int _type = ASTOP;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// api.g:370:7: ( ']' )
			// api.g:370:9: ']'
			{
			match(']'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "ASTOP"

	// $ANTLR start "START"
	public final void mSTART() throws RecognitionException {
		try {
			int _type = START;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// api.g:373:8: ( '{' )
			// api.g:373:10: '{'
			{
			match('{'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "START"

	// $ANTLR start "END"
	public final void mEND() throws RecognitionException {
		try {
			int _type = END;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// api.g:376:5: ( '}' )
			// api.g:376:7: '}'
			{
			match('}'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "END"

	// $ANTLR start "POPEN"
	public final void mPOPEN() throws RecognitionException {
		try {
			int _type = POPEN;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// api.g:379:7: ( '(' )
			// api.g:379:9: '('
			{
			match('('); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "POPEN"

	// $ANTLR start "PCLOSE"
	public final void mPCLOSE() throws RecognitionException {
		try {
			int _type = PCLOSE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// api.g:382:8: ( ')' )
			// api.g:382:10: ')'
			{
			match(')'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "PCLOSE"

	// $ANTLR start "EQUAL"
	public final void mEQUAL() throws RecognitionException {
		try {
			int _type = EQUAL;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// api.g:385:7: ( '=' )
			// api.g:385:9: '='
			{
			match('='); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "EQUAL"

	// $ANTLR start "COMMA"
	public final void mCOMMA() throws RecognitionException {
		try {
			int _type = COMMA;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// api.g:388:7: ( ',' )
			// api.g:388:9: ','
			{
			match(','); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "COMMA"

	// $ANTLR start "SEMICOLON"
	public final void mSEMICOLON() throws RecognitionException {
		try {
			int _type = SEMICOLON;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// api.g:392:2: ( ';' )
			// api.g:392:4: ';'
			{
			match(';'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "SEMICOLON"

	// $ANTLR start "COLON"
	public final void mCOLON() throws RecognitionException {
		try {
			int _type = COLON;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// api.g:395:7: ( ':' )
			// api.g:395:9: ':'
			{
			match(':'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "COLON"

	// $ANTLR start "NOT"
	public final void mNOT() throws RecognitionException {
		try {
			int _type = NOT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// api.g:398:5: ( '!' )
			// api.g:398:7: '!'
			{
			match('!'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "NOT"

	// $ANTLR start "COMMENT"
	public final void mCOMMENT() throws RecognitionException {
		try {
			int _type = COMMENT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// api.g:402:5: ( '//' (~ ( '\\n' | '\\r' ) )* ( '\\r' )? '\\n' | '/*' ( options {greedy=false; } : . )* '*/' )
			int alt8=2;
			int LA8_0 = input.LA(1);
			if ( (LA8_0=='/') ) {
				int LA8_1 = input.LA(2);
				if ( (LA8_1=='/') ) {
					alt8=1;
				}
				else if ( (LA8_1=='*') ) {
					alt8=2;
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
					// api.g:402:9: '//' (~ ( '\\n' | '\\r' ) )* ( '\\r' )? '\\n'
					{
					match("//"); 

					// api.g:402:14: (~ ( '\\n' | '\\r' ) )*
					loop5:
					while (true) {
						int alt5=2;
						int LA5_0 = input.LA(1);
						if ( ((LA5_0 >= '\u0000' && LA5_0 <= '\t')||(LA5_0 >= '\u000B' && LA5_0 <= '\f')||(LA5_0 >= '\u000E' && LA5_0 <= '\uFFFF')) ) {
							alt5=1;
						}

						switch (alt5) {
						case 1 :
							// api.g:
							{
							if ( (input.LA(1) >= '\u0000' && input.LA(1) <= '\t')||(input.LA(1) >= '\u000B' && input.LA(1) <= '\f')||(input.LA(1) >= '\u000E' && input.LA(1) <= '\uFFFF') ) {
								input.consume();
							}
							else {
								MismatchedSetException mse = new MismatchedSetException(null,input);
								recover(mse);
								throw mse;
							}
							}
							break;

						default :
							break loop5;
						}
					}

					// api.g:402:28: ( '\\r' )?
					int alt6=2;
					int LA6_0 = input.LA(1);
					if ( (LA6_0=='\r') ) {
						alt6=1;
					}
					switch (alt6) {
						case 1 :
							// api.g:402:28: '\\r'
							{
							match('\r'); 
							}
							break;

					}

					match('\n'); 
					_channel=HIDDEN;
					}
					break;
				case 2 :
					// api.g:403:9: '/*' ( options {greedy=false; } : . )* '*/'
					{
					match("/*"); 

					// api.g:403:14: ( options {greedy=false; } : . )*
					loop7:
					while (true) {
						int alt7=2;
						int LA7_0 = input.LA(1);
						if ( (LA7_0=='*') ) {
							int LA7_1 = input.LA(2);
							if ( (LA7_1=='/') ) {
								alt7=2;
							}
							else if ( ((LA7_1 >= '\u0000' && LA7_1 <= '.')||(LA7_1 >= '0' && LA7_1 <= '\uFFFF')) ) {
								alt7=1;
							}

						}
						else if ( ((LA7_0 >= '\u0000' && LA7_0 <= ')')||(LA7_0 >= '+' && LA7_0 <= '\uFFFF')) ) {
							alt7=1;
						}

						switch (alt7) {
						case 1 :
							// api.g:403:42: .
							{
							matchAny(); 
							}
							break;

						default :
							break loop7;
						}
					}

					match("*/"); 

					_channel=HIDDEN;
					}
					break;

			}
			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "COMMENT"

	// $ANTLR start "WS"
	public final void mWS() throws RecognitionException {
		try {
			int _type = WS;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// api.g:406:5: ( ( ' ' | '\\t' | '\\r' | '\\n' ) )
			// api.g:406:9: ( ' ' | '\\t' | '\\r' | '\\n' )
			{
			if ( (input.LA(1) >= '\t' && input.LA(1) <= '\n')||input.LA(1)=='\r'||input.LA(1)==' ' ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			_channel=HIDDEN;
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "WS"

	// $ANTLR start "HEX"
	public final void mHEX() throws RecognitionException {
		try {
			int _type = HEX;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// api.g:413:5: ( ( MINUS )? '0' ( 'x' | 'X' ) ( HEX_DIGIT )+ )
			// api.g:413:9: ( MINUS )? '0' ( 'x' | 'X' ) ( HEX_DIGIT )+
			{
			// api.g:413:9: ( MINUS )?
			int alt9=2;
			int LA9_0 = input.LA(1);
			if ( (LA9_0=='-') ) {
				alt9=1;
			}
			switch (alt9) {
				case 1 :
					// api.g:
					{
					if ( input.LA(1)=='-' ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;

			}

			match('0'); 
			if ( input.LA(1)=='X'||input.LA(1)=='x' ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			// api.g:413:30: ( HEX_DIGIT )+
			int cnt10=0;
			loop10:
			while (true) {
				int alt10=2;
				int LA10_0 = input.LA(1);
				if ( ((LA10_0 >= '0' && LA10_0 <= '9')||(LA10_0 >= 'A' && LA10_0 <= 'F')||(LA10_0 >= 'a' && LA10_0 <= 'f')) ) {
					alt10=1;
				}

				switch (alt10) {
				case 1 :
					// api.g:
					{
					if ( (input.LA(1) >= '0' && input.LA(1) <= '9')||(input.LA(1) >= 'A' && input.LA(1) <= 'F')||(input.LA(1) >= 'a' && input.LA(1) <= 'f') ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;

				default :
					if ( cnt10 >= 1 ) break loop10;
					EarlyExitException eee = new EarlyExitException(10, input);
					throw eee;
				}
				cnt10++;
			}

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "HEX"

	// $ANTLR start "STRING"
	public final void mSTRING() throws RecognitionException {
		try {
			int _type = STRING;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// api.g:417:5: ( '\"' ( ESC_SEQ |~ ( '\\\\' | '\"' ) )* '\"' )
			// api.g:417:8: '\"' ( ESC_SEQ |~ ( '\\\\' | '\"' ) )* '\"'
			{
			match('\"'); 
			// api.g:417:12: ( ESC_SEQ |~ ( '\\\\' | '\"' ) )*
			loop11:
			while (true) {
				int alt11=3;
				int LA11_0 = input.LA(1);
				if ( (LA11_0=='\\') ) {
					alt11=1;
				}
				else if ( ((LA11_0 >= '\u0000' && LA11_0 <= '!')||(LA11_0 >= '#' && LA11_0 <= '[')||(LA11_0 >= ']' && LA11_0 <= '\uFFFF')) ) {
					alt11=2;
				}

				switch (alt11) {
				case 1 :
					// api.g:417:14: ESC_SEQ
					{
					mESC_SEQ(); 

					}
					break;
				case 2 :
					// api.g:417:24: ~ ( '\\\\' | '\"' )
					{
					if ( (input.LA(1) >= '\u0000' && input.LA(1) <= '!')||(input.LA(1) >= '#' && input.LA(1) <= '[')||(input.LA(1) >= ']' && input.LA(1) <= '\uFFFF') ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;

				default :
					break loop11;
				}
			}

			match('\"'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "STRING"

	// $ANTLR start "CHAR"
	public final void mCHAR() throws RecognitionException {
		try {
			int _type = CHAR;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// api.g:420:5: ( '\\'' ( ESC_SEQ |~ ( '\\'' | '\\\\' ) ) '\\'' )
			// api.g:420:8: '\\'' ( ESC_SEQ |~ ( '\\'' | '\\\\' ) ) '\\''
			{
			match('\''); 
			// api.g:420:13: ( ESC_SEQ |~ ( '\\'' | '\\\\' ) )
			int alt12=2;
			int LA12_0 = input.LA(1);
			if ( (LA12_0=='\\') ) {
				alt12=1;
			}
			else if ( ((LA12_0 >= '\u0000' && LA12_0 <= '&')||(LA12_0 >= '(' && LA12_0 <= '[')||(LA12_0 >= ']' && LA12_0 <= '\uFFFF')) ) {
				alt12=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 12, 0, input);
				throw nvae;
			}

			switch (alt12) {
				case 1 :
					// api.g:420:15: ESC_SEQ
					{
					mESC_SEQ(); 

					}
					break;
				case 2 :
					// api.g:420:25: ~ ( '\\'' | '\\\\' )
					{
					if ( (input.LA(1) >= '\u0000' && input.LA(1) <= '&')||(input.LA(1) >= '(' && input.LA(1) <= '[')||(input.LA(1) >= ']' && input.LA(1) <= '\uFFFF') ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;

			}

			match('\''); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "CHAR"

	// $ANTLR start "MINUS"
	public final void mMINUS() throws RecognitionException {
		try {
			// api.g:425:7: ( '-' )
			// api.g:425:9: '-'
			{
			match('-'); 
			}

		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "MINUS"

	// $ANTLR start "EXPONENT"
	public final void mEXPONENT() throws RecognitionException {
		try {
			// api.g:429:10: ( ( 'e' | 'E' ) ( '+' | '-' )? ( '0' .. '9' )+ )
			// api.g:429:12: ( 'e' | 'E' ) ( '+' | '-' )? ( '0' .. '9' )+
			{
			if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			// api.g:429:22: ( '+' | '-' )?
			int alt13=2;
			int LA13_0 = input.LA(1);
			if ( (LA13_0=='+'||LA13_0=='-') ) {
				alt13=1;
			}
			switch (alt13) {
				case 1 :
					// api.g:
					{
					if ( input.LA(1)=='+'||input.LA(1)=='-' ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;

			}

			// api.g:429:33: ( '0' .. '9' )+
			int cnt14=0;
			loop14:
			while (true) {
				int alt14=2;
				int LA14_0 = input.LA(1);
				if ( ((LA14_0 >= '0' && LA14_0 <= '9')) ) {
					alt14=1;
				}

				switch (alt14) {
				case 1 :
					// api.g:
					{
					if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;

				default :
					if ( cnt14 >= 1 ) break loop14;
					EarlyExitException eee = new EarlyExitException(14, input);
					throw eee;
				}
				cnt14++;
			}

			}

		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "EXPONENT"

	// $ANTLR start "HEX_DIGIT"
	public final void mHEX_DIGIT() throws RecognitionException {
		try {
			// api.g:432:11: ( ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' ) )
			// api.g:
			{
			if ( (input.LA(1) >= '0' && input.LA(1) <= '9')||(input.LA(1) >= 'A' && input.LA(1) <= 'F')||(input.LA(1) >= 'a' && input.LA(1) <= 'f') ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			}

		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "HEX_DIGIT"

	// $ANTLR start "ESC_SEQ"
	public final void mESC_SEQ() throws RecognitionException {
		try {
			// api.g:436:5: ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\\\"' | '\\'' | '\\\\' ) | UNICODE_ESC | OCTAL_ESC )
			int alt15=3;
			int LA15_0 = input.LA(1);
			if ( (LA15_0=='\\') ) {
				switch ( input.LA(2) ) {
				case '\"':
				case '\'':
				case '\\':
				case 'b':
				case 'f':
				case 'n':
				case 'r':
				case 't':
					{
					alt15=1;
					}
					break;
				case 'u':
					{
					alt15=2;
					}
					break;
				case '0':
				case '1':
				case '2':
				case '3':
				case '4':
				case '5':
				case '6':
				case '7':
					{
					alt15=3;
					}
					break;
				default:
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 15, 1, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 15, 0, input);
				throw nvae;
			}

			switch (alt15) {
				case 1 :
					// api.g:436:9: '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\\\"' | '\\'' | '\\\\' )
					{
					match('\\'); 
					if ( input.LA(1)=='\"'||input.LA(1)=='\''||input.LA(1)=='\\'||input.LA(1)=='b'||input.LA(1)=='f'||input.LA(1)=='n'||input.LA(1)=='r'||input.LA(1)=='t' ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;
				case 2 :
					// api.g:437:9: UNICODE_ESC
					{
					mUNICODE_ESC(); 

					}
					break;
				case 3 :
					// api.g:438:9: OCTAL_ESC
					{
					mOCTAL_ESC(); 

					}
					break;

			}
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "ESC_SEQ"

	// $ANTLR start "OCTAL_ESC"
	public final void mOCTAL_ESC() throws RecognitionException {
		try {
			// api.g:443:5: ( '\\\\' ( '0' .. '3' ) ( '0' .. '7' ) ( '0' .. '7' ) | '\\\\' ( '0' .. '7' ) ( '0' .. '7' ) | '\\\\' ( '0' .. '7' ) )
			int alt16=3;
			int LA16_0 = input.LA(1);
			if ( (LA16_0=='\\') ) {
				int LA16_1 = input.LA(2);
				if ( ((LA16_1 >= '0' && LA16_1 <= '3')) ) {
					int LA16_2 = input.LA(3);
					if ( ((LA16_2 >= '0' && LA16_2 <= '7')) ) {
						int LA16_4 = input.LA(4);
						if ( ((LA16_4 >= '0' && LA16_4 <= '7')) ) {
							alt16=1;
						}

						else {
							alt16=2;
						}

					}

					else {
						alt16=3;
					}

				}
				else if ( ((LA16_1 >= '4' && LA16_1 <= '7')) ) {
					int LA16_3 = input.LA(3);
					if ( ((LA16_3 >= '0' && LA16_3 <= '7')) ) {
						alt16=2;
					}

					else {
						alt16=3;
					}

				}

				else {
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 16, 1, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 16, 0, input);
				throw nvae;
			}

			switch (alt16) {
				case 1 :
					// api.g:443:9: '\\\\' ( '0' .. '3' ) ( '0' .. '7' ) ( '0' .. '7' )
					{
					match('\\'); 
					if ( (input.LA(1) >= '0' && input.LA(1) <= '3') ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					if ( (input.LA(1) >= '0' && input.LA(1) <= '7') ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					if ( (input.LA(1) >= '0' && input.LA(1) <= '7') ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;
				case 2 :
					// api.g:444:9: '\\\\' ( '0' .. '7' ) ( '0' .. '7' )
					{
					match('\\'); 
					if ( (input.LA(1) >= '0' && input.LA(1) <= '7') ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					if ( (input.LA(1) >= '0' && input.LA(1) <= '7') ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;
				case 3 :
					// api.g:445:9: '\\\\' ( '0' .. '7' )
					{
					match('\\'); 
					if ( (input.LA(1) >= '0' && input.LA(1) <= '7') ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;

			}
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "OCTAL_ESC"

	// $ANTLR start "UNICODE_ESC"
	public final void mUNICODE_ESC() throws RecognitionException {
		try {
			// api.g:450:5: ( '\\\\' 'u' HEX_DIGIT HEX_DIGIT HEX_DIGIT HEX_DIGIT )
			// api.g:450:9: '\\\\' 'u' HEX_DIGIT HEX_DIGIT HEX_DIGIT HEX_DIGIT
			{
			match('\\'); 
			match('u'); 
			mHEX_DIGIT(); 

			mHEX_DIGIT(); 

			mHEX_DIGIT(); 

			mHEX_DIGIT(); 

			}

		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "UNICODE_ESC"

	@Override
	public void mTokens() throws RecognitionException {
		// api.g:1:8: ( ARRAY | MAP | REQUIRED | ENUM | TYPE | LIB | PROJECT | SERVICE | EXCEPTION | INCLUDE | INTERFACE | THROWS | VALIDATE | VALIDATION | NULL | EMPTY | FOR | OR | AND | ID | INT | DOTDOT | ASTART | ASTOP | START | END | POPEN | PCLOSE | EQUAL | COMMA | SEMICOLON | COLON | NOT | COMMENT | WS | HEX | STRING | CHAR )
		int alt17=38;
		alt17 = dfa17.predict(input);
		switch (alt17) {
			case 1 :
				// api.g:1:10: ARRAY
				{
				mARRAY(); 

				}
				break;
			case 2 :
				// api.g:1:16: MAP
				{
				mMAP(); 

				}
				break;
			case 3 :
				// api.g:1:20: REQUIRED
				{
				mREQUIRED(); 

				}
				break;
			case 4 :
				// api.g:1:29: ENUM
				{
				mENUM(); 

				}
				break;
			case 5 :
				// api.g:1:34: TYPE
				{
				mTYPE(); 

				}
				break;
			case 6 :
				// api.g:1:39: LIB
				{
				mLIB(); 

				}
				break;
			case 7 :
				// api.g:1:43: PROJECT
				{
				mPROJECT(); 

				}
				break;
			case 8 :
				// api.g:1:51: SERVICE
				{
				mSERVICE(); 

				}
				break;
			case 9 :
				// api.g:1:59: EXCEPTION
				{
				mEXCEPTION(); 

				}
				break;
			case 10 :
				// api.g:1:69: INCLUDE
				{
				mINCLUDE(); 

				}
				break;
			case 11 :
				// api.g:1:77: INTERFACE
				{
				mINTERFACE(); 

				}
				break;
			case 12 :
				// api.g:1:87: THROWS
				{
				mTHROWS(); 

				}
				break;
			case 13 :
				// api.g:1:94: VALIDATE
				{
				mVALIDATE(); 

				}
				break;
			case 14 :
				// api.g:1:103: VALIDATION
				{
				mVALIDATION(); 

				}
				break;
			case 15 :
				// api.g:1:114: NULL
				{
				mNULL(); 

				}
				break;
			case 16 :
				// api.g:1:119: EMPTY
				{
				mEMPTY(); 

				}
				break;
			case 17 :
				// api.g:1:125: FOR
				{
				mFOR(); 

				}
				break;
			case 18 :
				// api.g:1:129: OR
				{
				mOR(); 

				}
				break;
			case 19 :
				// api.g:1:132: AND
				{
				mAND(); 

				}
				break;
			case 20 :
				// api.g:1:136: ID
				{
				mID(); 

				}
				break;
			case 21 :
				// api.g:1:139: INT
				{
				mINT(); 

				}
				break;
			case 22 :
				// api.g:1:143: DOTDOT
				{
				mDOTDOT(); 

				}
				break;
			case 23 :
				// api.g:1:150: ASTART
				{
				mASTART(); 

				}
				break;
			case 24 :
				// api.g:1:157: ASTOP
				{
				mASTOP(); 

				}
				break;
			case 25 :
				// api.g:1:163: START
				{
				mSTART(); 

				}
				break;
			case 26 :
				// api.g:1:169: END
				{
				mEND(); 

				}
				break;
			case 27 :
				// api.g:1:173: POPEN
				{
				mPOPEN(); 

				}
				break;
			case 28 :
				// api.g:1:179: PCLOSE
				{
				mPCLOSE(); 

				}
				break;
			case 29 :
				// api.g:1:186: EQUAL
				{
				mEQUAL(); 

				}
				break;
			case 30 :
				// api.g:1:192: COMMA
				{
				mCOMMA(); 

				}
				break;
			case 31 :
				// api.g:1:198: SEMICOLON
				{
				mSEMICOLON(); 

				}
				break;
			case 32 :
				// api.g:1:208: COLON
				{
				mCOLON(); 

				}
				break;
			case 33 :
				// api.g:1:214: NOT
				{
				mNOT(); 

				}
				break;
			case 34 :
				// api.g:1:218: COMMENT
				{
				mCOMMENT(); 

				}
				break;
			case 35 :
				// api.g:1:226: WS
				{
				mWS(); 

				}
				break;
			case 36 :
				// api.g:1:229: HEX
				{
				mHEX(); 

				}
				break;
			case 37 :
				// api.g:1:233: STRING
				{
				mSTRING(); 

				}
				break;
			case 38 :
				// api.g:1:240: CHAR
				{
				mCHAR(); 

				}
				break;

		}
	}


	protected DFA17 dfa17 = new DFA17(this);
	static final String DFA17_eotS =
		"\1\uffff\15\16\1\uffff\1\37\22\uffff\20\16\1\106\1\uffff\1\37\1\16\1\110"+
		"\1\111\6\16\1\120\6\16\1\127\1\uffff\1\16\2\uffff\1\16\1\132\2\16\1\135"+
		"\1\16\1\uffff\5\16\1\144\1\uffff\1\145\1\16\1\uffff\1\16\1\150\1\uffff"+
		"\6\16\2\uffff\2\16\1\uffff\1\161\7\16\1\uffff\1\171\1\172\1\173\2\16\1"+
		"\177\1\16\3\uffff\1\16\1\u0082\1\16\1\uffff\1\u0084\1\u0085\1\uffff\1"+
		"\16\2\uffff\1\u0087\1\uffff";
	static final String DFA17_eofS =
		"\u0088\uffff";
	static final String DFA17_minS =
		"\1\11\1\156\1\141\1\145\1\155\1\150\1\151\1\162\1\145\1\156\1\141\1\165"+
		"\1\157\1\162\1\uffff\1\130\1\60\21\uffff\1\162\1\144\1\160\1\161\1\165"+
		"\1\143\2\160\1\162\1\142\1\157\1\162\1\143\2\154\1\162\1\60\1\uffff\1"+
		"\130\1\141\2\60\1\165\1\155\1\145\1\164\1\145\1\157\1\60\1\152\1\166\1"+
		"\154\1\145\1\151\1\154\1\60\1\uffff\1\171\2\uffff\1\151\1\60\1\160\1\171"+
		"\1\60\1\167\1\uffff\1\145\1\151\1\165\1\162\1\144\1\60\1\uffff\1\60\1"+
		"\162\1\uffff\1\164\1\60\1\uffff\1\163\2\143\1\144\1\146\1\141\2\uffff"+
		"\1\145\1\151\1\uffff\1\60\1\164\2\145\1\141\1\164\1\144\1\157\1\uffff"+
		"\3\60\1\143\1\145\1\60\1\156\3\uffff\1\145\1\60\1\157\1\uffff\2\60\1\uffff"+
		"\1\156\2\uffff\1\60\1\uffff";
	static final String DFA17_maxS =
		"\1\175\1\162\1\141\1\145\1\170\1\171\1\151\1\162\1\145\1\156\1\141\1\165"+
		"\1\157\1\162\1\uffff\1\170\1\71\21\uffff\1\162\1\144\1\160\1\161\1\165"+
		"\1\143\2\160\1\162\1\142\1\157\1\162\1\164\2\154\1\162\1\172\1\uffff\1"+
		"\170\1\141\2\172\1\165\1\155\1\145\1\164\1\145\1\157\1\172\1\152\1\166"+
		"\1\154\1\145\1\151\1\154\1\172\1\uffff\1\171\2\uffff\1\151\1\172\1\160"+
		"\1\171\1\172\1\167\1\uffff\1\145\1\151\1\165\1\162\1\144\1\172\1\uffff"+
		"\1\172\1\162\1\uffff\1\164\1\172\1\uffff\1\163\2\143\1\144\1\146\1\141"+
		"\2\uffff\1\145\1\151\1\uffff\1\172\1\164\2\145\1\141\1\164\1\144\1\157"+
		"\1\uffff\3\172\1\143\1\151\1\172\1\156\3\uffff\1\145\1\172\1\157\1\uffff"+
		"\2\172\1\uffff\1\156\2\uffff\1\172\1\uffff";
	static final String DFA17_acceptS =
		"\16\uffff\1\24\2\uffff\1\26\1\27\1\30\1\31\1\32\1\33\1\34\1\35\1\36\1"+
		"\37\1\40\1\41\1\42\1\43\1\25\1\45\1\46\21\uffff\1\44\22\uffff\1\22\1\uffff"+
		"\1\23\1\2\6\uffff\1\6\6\uffff\1\21\2\uffff\1\4\2\uffff\1\5\6\uffff\1\17"+
		"\1\1\2\uffff\1\20\10\uffff\1\14\7\uffff\1\7\1\10\1\12\3\uffff\1\3\2\uffff"+
		"\1\15\1\uffff\1\11\1\13\1\uffff\1\16";
	static final String DFA17_specialS =
		"\u0088\uffff}>";
	static final String[] DFA17_transitionS = {
			"\2\36\2\uffff\1\36\22\uffff\1\36\1\34\1\40\4\uffff\1\41\1\26\1\27\2\uffff"+
			"\1\31\1\20\1\21\1\35\1\17\11\37\1\33\1\32\1\uffff\1\30\3\uffff\32\16"+
			"\1\22\1\uffff\1\23\1\uffff\1\16\1\uffff\1\1\3\16\1\4\1\14\2\16\1\11\2"+
			"\16\1\6\1\2\1\13\1\15\1\7\1\16\1\3\1\10\1\5\1\16\1\12\4\16\1\24\1\uffff"+
			"\1\25",
			"\1\43\3\uffff\1\42",
			"\1\44",
			"\1\45",
			"\1\50\1\46\11\uffff\1\47",
			"\1\52\20\uffff\1\51",
			"\1\53",
			"\1\54",
			"\1\55",
			"\1\56",
			"\1\57",
			"\1\60",
			"\1\61",
			"\1\62",
			"",
			"\1\63\37\uffff\1\63",
			"\1\64\11\37",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"\1\65",
			"\1\66",
			"\1\67",
			"\1\70",
			"\1\71",
			"\1\72",
			"\1\73",
			"\1\74",
			"\1\75",
			"\1\76",
			"\1\77",
			"\1\100",
			"\1\101\20\uffff\1\102",
			"\1\103",
			"\1\104",
			"\1\105",
			"\12\16\7\uffff\32\16\4\uffff\1\16\1\uffff\32\16",
			"",
			"\1\63\37\uffff\1\63",
			"\1\107",
			"\12\16\7\uffff\32\16\4\uffff\1\16\1\uffff\32\16",
			"\12\16\7\uffff\32\16\4\uffff\1\16\1\uffff\32\16",
			"\1\112",
			"\1\113",
			"\1\114",
			"\1\115",
			"\1\116",
			"\1\117",
			"\12\16\7\uffff\32\16\4\uffff\1\16\1\uffff\32\16",
			"\1\121",
			"\1\122",
			"\1\123",
			"\1\124",
			"\1\125",
			"\1\126",
			"\12\16\7\uffff\32\16\4\uffff\1\16\1\uffff\32\16",
			"",
			"\1\130",
			"",
			"",
			"\1\131",
			"\12\16\7\uffff\32\16\4\uffff\1\16\1\uffff\32\16",
			"\1\133",
			"\1\134",
			"\12\16\7\uffff\32\16\4\uffff\1\16\1\uffff\32\16",
			"\1\136",
			"",
			"\1\137",
			"\1\140",
			"\1\141",
			"\1\142",
			"\1\143",
			"\12\16\7\uffff\32\16\4\uffff\1\16\1\uffff\32\16",
			"",
			"\12\16\7\uffff\32\16\4\uffff\1\16\1\uffff\32\16",
			"\1\146",
			"",
			"\1\147",
			"\12\16\7\uffff\32\16\4\uffff\1\16\1\uffff\32\16",
			"",
			"\1\151",
			"\1\152",
			"\1\153",
			"\1\154",
			"\1\155",
			"\1\156",
			"",
			"",
			"\1\157",
			"\1\160",
			"",
			"\12\16\7\uffff\32\16\4\uffff\1\16\1\uffff\32\16",
			"\1\162",
			"\1\163",
			"\1\164",
			"\1\165",
			"\1\166",
			"\1\167",
			"\1\170",
			"",
			"\12\16\7\uffff\32\16\4\uffff\1\16\1\uffff\32\16",
			"\12\16\7\uffff\32\16\4\uffff\1\16\1\uffff\32\16",
			"\12\16\7\uffff\32\16\4\uffff\1\16\1\uffff\32\16",
			"\1\174",
			"\1\175\3\uffff\1\176",
			"\12\16\7\uffff\32\16\4\uffff\1\16\1\uffff\32\16",
			"\1\u0080",
			"",
			"",
			"",
			"\1\u0081",
			"\12\16\7\uffff\32\16\4\uffff\1\16\1\uffff\32\16",
			"\1\u0083",
			"",
			"\12\16\7\uffff\32\16\4\uffff\1\16\1\uffff\32\16",
			"\12\16\7\uffff\32\16\4\uffff\1\16\1\uffff\32\16",
			"",
			"\1\u0086",
			"",
			"",
			"\12\16\7\uffff\32\16\4\uffff\1\16\1\uffff\32\16",
			""
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
			return "1:1: Tokens : ( ARRAY | MAP | REQUIRED | ENUM | TYPE | LIB | PROJECT | SERVICE | EXCEPTION | INCLUDE | INTERFACE | THROWS | VALIDATE | VALIDATION | NULL | EMPTY | FOR | OR | AND | ID | INT | DOTDOT | ASTART | ASTOP | START | END | POPEN | PCLOSE | EQUAL | COMMA | SEMICOLON | COLON | NOT | COMMENT | WS | HEX | STRING | CHAR );";
		}
	}

}
