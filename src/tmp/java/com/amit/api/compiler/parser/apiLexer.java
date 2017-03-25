// $ANTLR 3.5.2 api.g 2017-03-25 17:01:58

package com.amit.api.compiler.parser;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class apiLexer extends Lexer {
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
			// api.g:206:2: ( 'array' )
			// api.g:206:4: 'array'
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
			// api.g:209:2: ( 'map' )
			// api.g:209:4: 'map'
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
			// api.g:213:2: ( 'required' )
			// api.g:213:4: 'required'
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
			// api.g:216:6: ( 'enum' )
			// api.g:216:8: 'enum'
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
			// api.g:219:6: ( 'type' )
			// api.g:219:8: 'type'
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
			// api.g:222:5: ( 'lib' )
			// api.g:222:7: 'lib'
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
			// api.g:225:9: ( 'project' )
			// api.g:225:11: 'project'
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
			// api.g:228:9: ( 'service' )
			// api.g:228:11: 'service'
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
			// api.g:231:11: ( 'exception' )
			// api.g:231:13: 'exception'
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
			// api.g:234:9: ( 'include' )
			// api.g:234:11: 'include'
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
			// api.g:237:11: ( 'interface' )
			// api.g:237:13: 'interface'
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
			// api.g:240:8: ( 'throws' )
			// api.g:240:10: 'throws'
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

	// $ANTLR start "ID"
	public final void mID() throws RecognitionException {
		try {
			int _type = ID;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// api.g:243:5: ( ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )* )
			// api.g:243:7: ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )*
			{
			if ( (input.LA(1) >= 'A' && input.LA(1) <= 'Z')||input.LA(1)=='_'||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			// api.g:243:31: ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )*
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
			// api.g:246:5: ( ( '0' .. '9' )+ )
			// api.g:246:7: ( '0' .. '9' )+
			{
			// api.g:246:7: ( '0' .. '9' )+
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

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "INT"

	// $ANTLR start "FLOAT"
	public final void mFLOAT() throws RecognitionException {
		try {
			int _type = FLOAT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// api.g:250:5: ( ( '0' .. '9' )+ '.' ( '0' .. '9' )* ( EXPONENT )? | '.' ( '0' .. '9' )+ ( EXPONENT )? | ( '0' .. '9' )+ EXPONENT )
			int alt9=3;
			alt9 = dfa9.predict(input);
			switch (alt9) {
				case 1 :
					// api.g:250:9: ( '0' .. '9' )+ '.' ( '0' .. '9' )* ( EXPONENT )?
					{
					// api.g:250:9: ( '0' .. '9' )+
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

					match('.'); 
					// api.g:250:25: ( '0' .. '9' )*
					loop4:
					while (true) {
						int alt4=2;
						int LA4_0 = input.LA(1);
						if ( ((LA4_0 >= '0' && LA4_0 <= '9')) ) {
							alt4=1;
						}

						switch (alt4) {
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
							break loop4;
						}
					}

					// api.g:250:37: ( EXPONENT )?
					int alt5=2;
					int LA5_0 = input.LA(1);
					if ( (LA5_0=='E'||LA5_0=='e') ) {
						alt5=1;
					}
					switch (alt5) {
						case 1 :
							// api.g:250:37: EXPONENT
							{
							mEXPONENT(); 

							}
							break;

					}

					}
					break;
				case 2 :
					// api.g:251:9: '.' ( '0' .. '9' )+ ( EXPONENT )?
					{
					match('.'); 
					// api.g:251:13: ( '0' .. '9' )+
					int cnt6=0;
					loop6:
					while (true) {
						int alt6=2;
						int LA6_0 = input.LA(1);
						if ( ((LA6_0 >= '0' && LA6_0 <= '9')) ) {
							alt6=1;
						}

						switch (alt6) {
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
							if ( cnt6 >= 1 ) break loop6;
							EarlyExitException eee = new EarlyExitException(6, input);
							throw eee;
						}
						cnt6++;
					}

					// api.g:251:25: ( EXPONENT )?
					int alt7=2;
					int LA7_0 = input.LA(1);
					if ( (LA7_0=='E'||LA7_0=='e') ) {
						alt7=1;
					}
					switch (alt7) {
						case 1 :
							// api.g:251:25: EXPONENT
							{
							mEXPONENT(); 

							}
							break;

					}

					}
					break;
				case 3 :
					// api.g:252:9: ( '0' .. '9' )+ EXPONENT
					{
					// api.g:252:9: ( '0' .. '9' )+
					int cnt8=0;
					loop8:
					while (true) {
						int alt8=2;
						int LA8_0 = input.LA(1);
						if ( ((LA8_0 >= '0' && LA8_0 <= '9')) ) {
							alt8=1;
						}

						switch (alt8) {
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
							if ( cnt8 >= 1 ) break loop8;
							EarlyExitException eee = new EarlyExitException(8, input);
							throw eee;
						}
						cnt8++;
					}

					mEXPONENT(); 

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
	// $ANTLR end "FLOAT"

	// $ANTLR start "ASTART"
	public final void mASTART() throws RecognitionException {
		try {
			int _type = ASTART;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// api.g:256:8: ( '[' )
			// api.g:256:10: '['
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
			// api.g:259:7: ( ']' )
			// api.g:259:9: ']'
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
			// api.g:262:8: ( '{' )
			// api.g:262:10: '{'
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
			// api.g:265:5: ( '}' )
			// api.g:265:7: '}'
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
			// api.g:268:7: ( '(' )
			// api.g:268:9: '('
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
			// api.g:271:8: ( ')' )
			// api.g:271:10: ')'
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
			// api.g:274:7: ( '=' )
			// api.g:274:9: '='
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
			// api.g:277:7: ( ',' )
			// api.g:277:9: ','
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
			// api.g:281:2: ( ';' )
			// api.g:281:4: ';'
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
			// api.g:284:7: ( ':' )
			// api.g:284:9: ':'
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

	// $ANTLR start "COMMENT"
	public final void mCOMMENT() throws RecognitionException {
		try {
			int _type = COMMENT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// api.g:288:5: ( '//' (~ ( '\\n' | '\\r' ) )* ( '\\r' )? '\\n' | '/*' ( options {greedy=false; } : . )* '*/' )
			int alt13=2;
			int LA13_0 = input.LA(1);
			if ( (LA13_0=='/') ) {
				int LA13_1 = input.LA(2);
				if ( (LA13_1=='/') ) {
					alt13=1;
				}
				else if ( (LA13_1=='*') ) {
					alt13=2;
				}

				else {
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 13, 1, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 13, 0, input);
				throw nvae;
			}

			switch (alt13) {
				case 1 :
					// api.g:288:9: '//' (~ ( '\\n' | '\\r' ) )* ( '\\r' )? '\\n'
					{
					match("//"); 

					// api.g:288:14: (~ ( '\\n' | '\\r' ) )*
					loop10:
					while (true) {
						int alt10=2;
						int LA10_0 = input.LA(1);
						if ( ((LA10_0 >= '\u0000' && LA10_0 <= '\t')||(LA10_0 >= '\u000B' && LA10_0 <= '\f')||(LA10_0 >= '\u000E' && LA10_0 <= '\uFFFF')) ) {
							alt10=1;
						}

						switch (alt10) {
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
							break loop10;
						}
					}

					// api.g:288:28: ( '\\r' )?
					int alt11=2;
					int LA11_0 = input.LA(1);
					if ( (LA11_0=='\r') ) {
						alt11=1;
					}
					switch (alt11) {
						case 1 :
							// api.g:288:28: '\\r'
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
					// api.g:289:9: '/*' ( options {greedy=false; } : . )* '*/'
					{
					match("/*"); 

					// api.g:289:14: ( options {greedy=false; } : . )*
					loop12:
					while (true) {
						int alt12=2;
						int LA12_0 = input.LA(1);
						if ( (LA12_0=='*') ) {
							int LA12_1 = input.LA(2);
							if ( (LA12_1=='/') ) {
								alt12=2;
							}
							else if ( ((LA12_1 >= '\u0000' && LA12_1 <= '.')||(LA12_1 >= '0' && LA12_1 <= '\uFFFF')) ) {
								alt12=1;
							}

						}
						else if ( ((LA12_0 >= '\u0000' && LA12_0 <= ')')||(LA12_0 >= '+' && LA12_0 <= '\uFFFF')) ) {
							alt12=1;
						}

						switch (alt12) {
						case 1 :
							// api.g:289:42: .
							{
							matchAny(); 
							}
							break;

						default :
							break loop12;
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
			// api.g:292:5: ( ( ' ' | '\\t' | '\\r' | '\\n' ) )
			// api.g:292:9: ( ' ' | '\\t' | '\\r' | '\\n' )
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
			// api.g:299:5: ( ( MINUS )? '0' ( 'x' | 'X' ) ( HEX_DIGIT )+ )
			// api.g:299:9: ( MINUS )? '0' ( 'x' | 'X' ) ( HEX_DIGIT )+
			{
			// api.g:299:9: ( MINUS )?
			int alt14=2;
			int LA14_0 = input.LA(1);
			if ( (LA14_0=='-') ) {
				alt14=1;
			}
			switch (alt14) {
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
			// api.g:299:30: ( HEX_DIGIT )+
			int cnt15=0;
			loop15:
			while (true) {
				int alt15=2;
				int LA15_0 = input.LA(1);
				if ( ((LA15_0 >= '0' && LA15_0 <= '9')||(LA15_0 >= 'A' && LA15_0 <= 'F')||(LA15_0 >= 'a' && LA15_0 <= 'f')) ) {
					alt15=1;
				}

				switch (alt15) {
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
					if ( cnt15 >= 1 ) break loop15;
					EarlyExitException eee = new EarlyExitException(15, input);
					throw eee;
				}
				cnt15++;
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
			// api.g:303:5: ( '\"' ( ESC_SEQ |~ ( '\\\\' | '\"' ) )* '\"' )
			// api.g:303:8: '\"' ( ESC_SEQ |~ ( '\\\\' | '\"' ) )* '\"'
			{
			match('\"'); 
			// api.g:303:12: ( ESC_SEQ |~ ( '\\\\' | '\"' ) )*
			loop16:
			while (true) {
				int alt16=3;
				int LA16_0 = input.LA(1);
				if ( (LA16_0=='\\') ) {
					alt16=1;
				}
				else if ( ((LA16_0 >= '\u0000' && LA16_0 <= '!')||(LA16_0 >= '#' && LA16_0 <= '[')||(LA16_0 >= ']' && LA16_0 <= '\uFFFF')) ) {
					alt16=2;
				}

				switch (alt16) {
				case 1 :
					// api.g:303:14: ESC_SEQ
					{
					mESC_SEQ(); 

					}
					break;
				case 2 :
					// api.g:303:24: ~ ( '\\\\' | '\"' )
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
					break loop16;
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
			// api.g:306:5: ( '\\'' ( ESC_SEQ |~ ( '\\'' | '\\\\' ) ) '\\'' )
			// api.g:306:8: '\\'' ( ESC_SEQ |~ ( '\\'' | '\\\\' ) ) '\\''
			{
			match('\''); 
			// api.g:306:13: ( ESC_SEQ |~ ( '\\'' | '\\\\' ) )
			int alt17=2;
			int LA17_0 = input.LA(1);
			if ( (LA17_0=='\\') ) {
				alt17=1;
			}
			else if ( ((LA17_0 >= '\u0000' && LA17_0 <= '&')||(LA17_0 >= '(' && LA17_0 <= '[')||(LA17_0 >= ']' && LA17_0 <= '\uFFFF')) ) {
				alt17=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 17, 0, input);
				throw nvae;
			}

			switch (alt17) {
				case 1 :
					// api.g:306:15: ESC_SEQ
					{
					mESC_SEQ(); 

					}
					break;
				case 2 :
					// api.g:306:25: ~ ( '\\'' | '\\\\' )
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
			// api.g:311:7: ( '-' )
			// api.g:311:9: '-'
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
			// api.g:315:10: ( ( 'e' | 'E' ) ( '+' | '-' )? ( '0' .. '9' )+ )
			// api.g:315:12: ( 'e' | 'E' ) ( '+' | '-' )? ( '0' .. '9' )+
			{
			if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			// api.g:315:22: ( '+' | '-' )?
			int alt18=2;
			int LA18_0 = input.LA(1);
			if ( (LA18_0=='+'||LA18_0=='-') ) {
				alt18=1;
			}
			switch (alt18) {
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

			// api.g:315:33: ( '0' .. '9' )+
			int cnt19=0;
			loop19:
			while (true) {
				int alt19=2;
				int LA19_0 = input.LA(1);
				if ( ((LA19_0 >= '0' && LA19_0 <= '9')) ) {
					alt19=1;
				}

				switch (alt19) {
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
					if ( cnt19 >= 1 ) break loop19;
					EarlyExitException eee = new EarlyExitException(19, input);
					throw eee;
				}
				cnt19++;
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
			// api.g:318:11: ( ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' ) )
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
			// api.g:322:5: ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\\\"' | '\\'' | '\\\\' ) | UNICODE_ESC | OCTAL_ESC )
			int alt20=3;
			int LA20_0 = input.LA(1);
			if ( (LA20_0=='\\') ) {
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
					alt20=1;
					}
					break;
				case 'u':
					{
					alt20=2;
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
					alt20=3;
					}
					break;
				default:
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 20, 1, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 20, 0, input);
				throw nvae;
			}

			switch (alt20) {
				case 1 :
					// api.g:322:9: '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\\\"' | '\\'' | '\\\\' )
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
					// api.g:323:9: UNICODE_ESC
					{
					mUNICODE_ESC(); 

					}
					break;
				case 3 :
					// api.g:324:9: OCTAL_ESC
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
			// api.g:329:5: ( '\\\\' ( '0' .. '3' ) ( '0' .. '7' ) ( '0' .. '7' ) | '\\\\' ( '0' .. '7' ) ( '0' .. '7' ) | '\\\\' ( '0' .. '7' ) )
			int alt21=3;
			int LA21_0 = input.LA(1);
			if ( (LA21_0=='\\') ) {
				int LA21_1 = input.LA(2);
				if ( ((LA21_1 >= '0' && LA21_1 <= '3')) ) {
					int LA21_2 = input.LA(3);
					if ( ((LA21_2 >= '0' && LA21_2 <= '7')) ) {
						int LA21_4 = input.LA(4);
						if ( ((LA21_4 >= '0' && LA21_4 <= '7')) ) {
							alt21=1;
						}

						else {
							alt21=2;
						}

					}

					else {
						alt21=3;
					}

				}
				else if ( ((LA21_1 >= '4' && LA21_1 <= '7')) ) {
					int LA21_3 = input.LA(3);
					if ( ((LA21_3 >= '0' && LA21_3 <= '7')) ) {
						alt21=2;
					}

					else {
						alt21=3;
					}

				}

				else {
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 21, 1, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 21, 0, input);
				throw nvae;
			}

			switch (alt21) {
				case 1 :
					// api.g:329:9: '\\\\' ( '0' .. '3' ) ( '0' .. '7' ) ( '0' .. '7' )
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
					// api.g:330:9: '\\\\' ( '0' .. '7' ) ( '0' .. '7' )
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
					// api.g:331:9: '\\\\' ( '0' .. '7' )
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
			// api.g:336:5: ( '\\\\' 'u' HEX_DIGIT HEX_DIGIT HEX_DIGIT HEX_DIGIT )
			// api.g:336:9: '\\\\' 'u' HEX_DIGIT HEX_DIGIT HEX_DIGIT HEX_DIGIT
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
		// api.g:1:8: ( ARRAY | MAP | REQUIRED | ENUM | TYPE | LIB | PROJECT | SERVICE | EXCEPTION | INCLUDE | INTERFACE | THROWS | ID | INT | FLOAT | ASTART | ASTOP | START | END | POPEN | PCLOSE | EQUAL | COMMA | SEMICOLON | COLON | COMMENT | WS | HEX | STRING | CHAR )
		int alt22=30;
		alt22 = dfa22.predict(input);
		switch (alt22) {
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
				// api.g:1:94: ID
				{
				mID(); 

				}
				break;
			case 14 :
				// api.g:1:97: INT
				{
				mINT(); 

				}
				break;
			case 15 :
				// api.g:1:101: FLOAT
				{
				mFLOAT(); 

				}
				break;
			case 16 :
				// api.g:1:107: ASTART
				{
				mASTART(); 

				}
				break;
			case 17 :
				// api.g:1:114: ASTOP
				{
				mASTOP(); 

				}
				break;
			case 18 :
				// api.g:1:120: START
				{
				mSTART(); 

				}
				break;
			case 19 :
				// api.g:1:126: END
				{
				mEND(); 

				}
				break;
			case 20 :
				// api.g:1:130: POPEN
				{
				mPOPEN(); 

				}
				break;
			case 21 :
				// api.g:1:136: PCLOSE
				{
				mPCLOSE(); 

				}
				break;
			case 22 :
				// api.g:1:143: EQUAL
				{
				mEQUAL(); 

				}
				break;
			case 23 :
				// api.g:1:149: COMMA
				{
				mCOMMA(); 

				}
				break;
			case 24 :
				// api.g:1:155: SEMICOLON
				{
				mSEMICOLON(); 

				}
				break;
			case 25 :
				// api.g:1:165: COLON
				{
				mCOLON(); 

				}
				break;
			case 26 :
				// api.g:1:171: COMMENT
				{
				mCOMMENT(); 

				}
				break;
			case 27 :
				// api.g:1:179: WS
				{
				mWS(); 

				}
				break;
			case 28 :
				// api.g:1:182: HEX
				{
				mHEX(); 

				}
				break;
			case 29 :
				// api.g:1:186: STRING
				{
				mSTRING(); 

				}
				break;
			case 30 :
				// api.g:1:193: CHAR
				{
				mCHAR(); 

				}
				break;

		}
	}


	protected DFA9 dfa9 = new DFA9(this);
	protected DFA22 dfa22 = new DFA22(this);
	static final String DFA9_eotS =
		"\5\uffff";
	static final String DFA9_eofS =
		"\5\uffff";
	static final String DFA9_minS =
		"\2\56\3\uffff";
	static final String DFA9_maxS =
		"\1\71\1\145\3\uffff";
	static final String DFA9_acceptS =
		"\2\uffff\1\2\1\1\1\3";
	static final String DFA9_specialS =
		"\5\uffff}>";
	static final String[] DFA9_transitionS = {
			"\1\2\1\uffff\12\1",
			"\1\3\1\uffff\12\1\13\uffff\1\4\37\uffff\1\4",
			"",
			"",
			""
	};

	static final short[] DFA9_eot = DFA.unpackEncodedString(DFA9_eotS);
	static final short[] DFA9_eof = DFA.unpackEncodedString(DFA9_eofS);
	static final char[] DFA9_min = DFA.unpackEncodedStringToUnsignedChars(DFA9_minS);
	static final char[] DFA9_max = DFA.unpackEncodedStringToUnsignedChars(DFA9_maxS);
	static final short[] DFA9_accept = DFA.unpackEncodedString(DFA9_acceptS);
	static final short[] DFA9_special = DFA.unpackEncodedString(DFA9_specialS);
	static final short[][] DFA9_transition;

	static {
		int numStates = DFA9_transitionS.length;
		DFA9_transition = new short[numStates][];
		for (int i=0; i<numStates; i++) {
			DFA9_transition[i] = DFA.unpackEncodedString(DFA9_transitionS[i]);
		}
	}

	protected class DFA9 extends DFA {

		public DFA9(BaseRecognizer recognizer) {
			this.recognizer = recognizer;
			this.decisionNumber = 9;
			this.eot = DFA9_eot;
			this.eof = DFA9_eof;
			this.min = DFA9_min;
			this.max = DFA9_max;
			this.accept = DFA9_accept;
			this.special = DFA9_special;
			this.transition = DFA9_transition;
		}
		@Override
		public String getDescription() {
			return "249:1: FLOAT : ( ( '0' .. '9' )+ '.' ( '0' .. '9' )* ( EXPONENT )? | '.' ( '0' .. '9' )+ ( EXPONENT )? | ( '0' .. '9' )+ EXPONENT );";
		}
	}

	static final String DFA22_eotS =
		"\1\uffff\11\12\1\uffff\1\50\16\uffff\1\50\2\uffff\13\12\1\uffff\1\12\1"+
		"\66\5\12\1\74\5\12\1\uffff\1\12\1\103\1\12\1\105\1\12\1\uffff\4\12\1\113"+
		"\1\12\1\uffff\1\12\1\uffff\5\12\1\uffff\2\12\1\125\6\12\1\uffff\1\134"+
		"\1\135\1\136\1\12\1\140\1\12\3\uffff\1\12\1\uffff\1\143\1\144\2\uffff";
	static final String DFA22_eofS =
		"\145\uffff";
	static final String DFA22_minS =
		"\1\11\1\162\1\141\1\145\1\156\1\150\1\151\1\162\1\145\1\156\1\uffff\1"+
		"\56\16\uffff\1\56\2\uffff\1\162\1\160\1\161\1\165\1\143\1\160\1\162\1"+
		"\142\1\157\1\162\1\143\1\uffff\1\141\1\60\1\165\1\155\2\145\1\157\1\60"+
		"\1\152\1\166\1\154\1\145\1\171\1\uffff\1\151\1\60\1\160\1\60\1\167\1\uffff"+
		"\1\145\1\151\1\165\1\162\1\60\1\162\1\uffff\1\164\1\uffff\1\163\2\143"+
		"\1\144\1\146\1\uffff\1\145\1\151\1\60\1\164\2\145\1\141\1\144\1\157\1"+
		"\uffff\3\60\1\143\1\60\1\156\3\uffff\1\145\1\uffff\2\60\2\uffff";
	static final String DFA22_maxS =
		"\1\175\1\162\1\141\1\145\1\170\1\171\1\151\1\162\1\145\1\156\1\uffff\1"+
		"\170\16\uffff\1\145\2\uffff\1\162\1\160\1\161\1\165\1\143\1\160\1\162"+
		"\1\142\1\157\1\162\1\164\1\uffff\1\141\1\172\1\165\1\155\2\145\1\157\1"+
		"\172\1\152\1\166\1\154\1\145\1\171\1\uffff\1\151\1\172\1\160\1\172\1\167"+
		"\1\uffff\1\145\1\151\1\165\1\162\1\172\1\162\1\uffff\1\164\1\uffff\1\163"+
		"\2\143\1\144\1\146\1\uffff\1\145\1\151\1\172\1\164\2\145\1\141\1\144\1"+
		"\157\1\uffff\3\172\1\143\1\172\1\156\3\uffff\1\145\1\uffff\2\172\2\uffff";
	static final String DFA22_acceptS =
		"\12\uffff\1\15\1\uffff\1\17\1\20\1\21\1\22\1\23\1\24\1\25\1\26\1\27\1"+
		"\30\1\31\1\32\1\33\1\34\1\uffff\1\35\1\36\13\uffff\1\16\15\uffff\1\2\5"+
		"\uffff\1\6\6\uffff\1\4\1\uffff\1\5\5\uffff\1\1\11\uffff\1\14\6\uffff\1"+
		"\7\1\10\1\12\1\uffff\1\3\2\uffff\1\11\1\13";
	static final String DFA22_specialS =
		"\145\uffff}>";
	static final String[] DFA22_transitionS = {
			"\2\30\2\uffff\1\30\22\uffff\1\30\1\uffff\1\33\4\uffff\1\34\1\21\1\22"+
			"\2\uffff\1\24\1\31\1\14\1\27\1\13\11\32\1\26\1\25\1\uffff\1\23\3\uffff"+
			"\32\12\1\15\1\uffff\1\16\1\uffff\1\12\1\uffff\1\1\3\12\1\4\3\12\1\11"+
			"\2\12\1\6\1\2\2\12\1\7\1\12\1\3\1\10\1\5\6\12\1\17\1\uffff\1\20",
			"\1\35",
			"\1\36",
			"\1\37",
			"\1\40\11\uffff\1\41",
			"\1\43\20\uffff\1\42",
			"\1\44",
			"\1\45",
			"\1\46",
			"\1\47",
			"",
			"\1\14\1\uffff\12\32\13\uffff\1\14\22\uffff\1\31\14\uffff\1\14\22\uffff"+
			"\1\31",
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
			"\1\14\1\uffff\12\32\13\uffff\1\14\37\uffff\1\14",
			"",
			"",
			"\1\51",
			"\1\52",
			"\1\53",
			"\1\54",
			"\1\55",
			"\1\56",
			"\1\57",
			"\1\60",
			"\1\61",
			"\1\62",
			"\1\63\20\uffff\1\64",
			"",
			"\1\65",
			"\12\12\7\uffff\32\12\4\uffff\1\12\1\uffff\32\12",
			"\1\67",
			"\1\70",
			"\1\71",
			"\1\72",
			"\1\73",
			"\12\12\7\uffff\32\12\4\uffff\1\12\1\uffff\32\12",
			"\1\75",
			"\1\76",
			"\1\77",
			"\1\100",
			"\1\101",
			"",
			"\1\102",
			"\12\12\7\uffff\32\12\4\uffff\1\12\1\uffff\32\12",
			"\1\104",
			"\12\12\7\uffff\32\12\4\uffff\1\12\1\uffff\32\12",
			"\1\106",
			"",
			"\1\107",
			"\1\110",
			"\1\111",
			"\1\112",
			"\12\12\7\uffff\32\12\4\uffff\1\12\1\uffff\32\12",
			"\1\114",
			"",
			"\1\115",
			"",
			"\1\116",
			"\1\117",
			"\1\120",
			"\1\121",
			"\1\122",
			"",
			"\1\123",
			"\1\124",
			"\12\12\7\uffff\32\12\4\uffff\1\12\1\uffff\32\12",
			"\1\126",
			"\1\127",
			"\1\130",
			"\1\131",
			"\1\132",
			"\1\133",
			"",
			"\12\12\7\uffff\32\12\4\uffff\1\12\1\uffff\32\12",
			"\12\12\7\uffff\32\12\4\uffff\1\12\1\uffff\32\12",
			"\12\12\7\uffff\32\12\4\uffff\1\12\1\uffff\32\12",
			"\1\137",
			"\12\12\7\uffff\32\12\4\uffff\1\12\1\uffff\32\12",
			"\1\141",
			"",
			"",
			"",
			"\1\142",
			"",
			"\12\12\7\uffff\32\12\4\uffff\1\12\1\uffff\32\12",
			"\12\12\7\uffff\32\12\4\uffff\1\12\1\uffff\32\12",
			"",
			""
	};

	static final short[] DFA22_eot = DFA.unpackEncodedString(DFA22_eotS);
	static final short[] DFA22_eof = DFA.unpackEncodedString(DFA22_eofS);
	static final char[] DFA22_min = DFA.unpackEncodedStringToUnsignedChars(DFA22_minS);
	static final char[] DFA22_max = DFA.unpackEncodedStringToUnsignedChars(DFA22_maxS);
	static final short[] DFA22_accept = DFA.unpackEncodedString(DFA22_acceptS);
	static final short[] DFA22_special = DFA.unpackEncodedString(DFA22_specialS);
	static final short[][] DFA22_transition;

	static {
		int numStates = DFA22_transitionS.length;
		DFA22_transition = new short[numStates][];
		for (int i=0; i<numStates; i++) {
			DFA22_transition[i] = DFA.unpackEncodedString(DFA22_transitionS[i]);
		}
	}

	protected class DFA22 extends DFA {

		public DFA22(BaseRecognizer recognizer) {
			this.recognizer = recognizer;
			this.decisionNumber = 22;
			this.eot = DFA22_eot;
			this.eof = DFA22_eof;
			this.min = DFA22_min;
			this.max = DFA22_max;
			this.accept = DFA22_accept;
			this.special = DFA22_special;
			this.transition = DFA22_transition;
		}
		@Override
		public String getDescription() {
			return "1:1: Tokens : ( ARRAY | MAP | REQUIRED | ENUM | TYPE | LIB | PROJECT | SERVICE | EXCEPTION | INCLUDE | INTERFACE | THROWS | ID | INT | FLOAT | ASTART | ASTOP | START | END | POPEN | PCLOSE | EQUAL | COMMA | SEMICOLON | COLON | COMMENT | WS | HEX | STRING | CHAR );";
		}
	}

}
