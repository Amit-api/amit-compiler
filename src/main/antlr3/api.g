grammar api;

@parser::header {
package com.amit.api.compiler.parser;

import com.amit.api.compiler.model.*;
}

@lexer::header {
package com.amit.api.compiler.parser;

}
   
start [Project project] 	
	: header [project] ( statment [ project ] )*;
	

header [Project project]
	: include 
	  module [project]
	;
	
include 
	: ( INCLUDE STRING ) *
	;
	
module [Project project]
@init {
	AttributeList attrList = new AttributeList();
}	: attributes [attrList] PROJECT ID SEMICOLON { project.createModule( $ID.text, ModuleType.PROJECT, attrList, new Context( $ID ) ); }
	| LIB ID SEMICOLON { project.createModule( $ID.text, ModuleType.LIB, null, new Context( $ID ) ); }
	;

statment [Project project] 
	: enum_statment [project]
	| type_statment [project]
	| interface_statment [project]
	| exception_statment [project]
	| service_statment [project]
	;

service_statment [Project project]
@init {
	AttributeList attrList = new AttributeList();
}
	: attributes [attrList] SERVICE
	  ID { Service service = project.createService( $ID.text, attrList, new Context( $ID ) ); }
	  interface_inh [service]
	  SEMICOLON 
	  ;

interface_statment [Project project]
@init {
	AttributeList attrList = new AttributeList();
}
	: attributes [attrList] INTERFACE
	  ID { Interface interf = project.createInterface( $ID.text, attrList, new Context( $ID ) ); }
	  interface_inh [interf]
	  START
	  ( function [interf] )*  
	  END
	;
	
interface_inh [Interface interf]
	:
	| COLON ID { interf.addBaseInterface( $ID.text); } interface_inh_end [interf]
	;
	
interface_inh_end [Interface interf]
	: ( COMMA ID { interf.addBaseInterface( $ID.text); } )*
	;	
		
function [Interface interf]
@init {
	AttributeList attrList = new AttributeList();
	ReturnValue<FunctionReturn> returnType = new ReturnValue<FunctionReturn>(); 
}
	: attributes [attrList] function_ret [returnType] 
	  ID { Function fun = interf.createFunction( $ID.text, returnType.get(), attrList, new Context( $ID ) ); } 
	  function_end [fun]
	; 

function_end [Function fun]
	: POPEN function_args [fun] PCLOSE function_throws [fun] SEMICOLON
	| POPEN PCLOSE function_throws [fun] SEMICOLON
	;

function_throws [Function fun]
	:
	| THROWS ID { fun.addThrowsException( $ID.text ); }
	  ( function_throws_more [fun] )*
	;

function_throws_more [Function fun]
	: COMMA ID { fun.addThrowsException( $ID.text ); }
	;	
	

function_ret [ReturnValue<FunctionReturn> returnType]
	: ID { returnType.set( new FunctionReturn( $ID.text, false, new Context( $ID ) ) ); }
	| ARRAY ID { returnType.set( new FunctionReturn( $ID.text, true, new Context( $ID ) ) ); }
	;
		
function_args [Function fun] 
	: function_arg [fun] ( COMMA function_arg [fun] )*
	; 
			
function_arg [Function fun]
@init {
	AttributeList attrList = new AttributeList();
}
	: attributes [attrList] ID function_arg_end [$ID.text, false, false, attrList, fun] 
	| attributes [attrList] ARRAY ID function_arg_end [$ID.text, true, false, attrList, fun]
	| attributes [attrList] REQUIRED ID function_arg_end [$ID.text, false, true, attrList, fun]
	;

function_arg_end [String type, boolean isArray, boolean isRequired, AttributeList attrList, Function fun]
	: ID { fun.createArgument( type, $ID.text, isArray, isRequired, attrList, new Context( $ID ) ); }
	;

exception_statment[Project project]
@init {
	AttributeList attrList = new AttributeList();
}
	: attributes [attrList] EXCEPTION
	  ID { TypeCommonComposite type = project.createException( $ID.text, attrList, new Context( $ID ) ); }
	  type_end [type]
	;
				
type_statment[Project project]
@init {
	AttributeList attrList = new AttributeList();
}
	: attributes [attrList] TYPE
	  ID { TypeCommonComposite type = project.creatCompositeType( $ID.text, attrList, new Context( $ID ) ); }
	  type_end [type]
	;

type_end [TypeCommonComposite type]
	: START ( type_item [type] )* END
	| COLON ID START ( type_item [type] )* END { type.setBaseTypeName( $ID.text ); }
	;
	
type_item [TypeCommonComposite type] 
@init {
	AttributeList attrList = new AttributeList();
}
	: attributes [attrList] ID type_value[false, false, $ID.text, type]
	| attributes [attrList] REQUIRED ID type_value[false, true, $ID.text, type]
	| attributes [attrList] ARRAY ID type_value[true, false, $ID.text, type]
	;

type_value [boolean isArray, boolean isRequired, String memberType, TypeCommonComposite type]
	: ID SEMICOLON { type.addMember( memberType, $ID.text, isArray, isRequired, new Context( $ID ) ); }
	;
			
enum_statment [Project project]
@init {
	AttributeList attrList = new AttributeList();
}
	: attributes [attrList]
	  ENUM
	  ID {
	  	TypeEnum type_enum = project.createEnum( $ID.text, new Context( $ID ) );
	  }
	  START
	  enum_values [type_enum]
	  END 
	;	


enum_value [TypeEnum type_enum]
@init {
	AttributeList attrList = new AttributeList();
}
	: attributes [attrList] ID	EQUAL number_value { type_enum.createValue( $ID.text, ParseUtils.parseNumber( $number_value.text ), new Context( $ID ), attrList  ); }
	| attributes [attrList] ID	EQUAL STRING { type_enum.createValue( $ID.text, ParseUtils.parseString( $STRING.text ), new Context( $ID ), attrList  ); }
	;
	
enum_values [TypeEnum type_enum]
	: enum_value[type_enum]
	 ( COMMA enum_value[type_enum] )*
	;
		
attribute [AttributeList attrList]
	: ASTART ID EQUAL STRING ASTOP { attrList.createAttribute( $ID.text, ParseUtils.parseString( $STRING.text ), new Context( $ID ) ); }
	;
	
attributes [AttributeList attrList]
	: (attribute [attrList])*
	;		


number_value
	: INT
	| HEX
	;
ARRAY	
	: 'array'
	;
	
REQUIRED 
	: 'required'
	;
	
ENUM	: 'enum'
	;

TYPE	: 'type'
	;
	
LIB : 'lib'
	;

PROJECT : 'project'
	; 
	
SERVICE : 'service'
	;
	
EXCEPTION : 'exception'
	;

INCLUDE : 'include'
	;
	
INTERFACE : 'interface'
	;
	
THROWS : 'throws'
	;
	
ID  :	('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'0'..'9'|'_')*
    ;

INT :	'0'..'9'+
    ;

FLOAT
    :   ('0'..'9')+ '.' ('0'..'9')* EXPONENT?
    |   '.' ('0'..'9')+ EXPONENT?
    |   ('0'..'9')+ EXPONENT
    ;


ASTART	: '['
	;

ASTOP	: ']'
	;
	
START 	: '{'
	;
	
END	: '}'
	;
	
POPEN	: '('
	;
	
PCLOSE	: ')'
	;
	
EQUAL	: '='
	;
	
COMMA	: ','
	;
	
SEMICOLON 
	: ';'
	;
	
COLON	: ':'
	;
		
COMMENT
    :   '//' ~('\n'|'\r')* '\r'? '\n' {$channel=HIDDEN;}
    |   '/*' ( options {greedy=false;} : . )* '*/' {$channel=HIDDEN;}
    ;

WS  :   ( ' '
        | '\t'
        | '\r'
        | '\n'
        ) {$channel=HIDDEN;}
    ;	
HEX
    :   MINUS? '0' ('x'|'X') HEX_DIGIT+
    ;
    
STRING
    :  '"' ( ESC_SEQ | ~('\\'|'"') )* '"'
    ;

CHAR:  '\'' ( ESC_SEQ | ~('\''|'\\') ) '\''
    ;

fragment
MINUS	: '-'
	;	

fragment
EXPONENT : ('e'|'E') ('+'|'-')? ('0'..'9')+ ;

fragment
HEX_DIGIT : ('0'..'9'|'a'..'f'|'A'..'F') ;

fragment
ESC_SEQ
    :   '\\' ('b'|'t'|'n'|'f'|'r'|'\"'|'\''|'\\')
    |   UNICODE_ESC
    |   OCTAL_ESC
    ;

fragment
OCTAL_ESC
    :   '\\' ('0'..'3') ('0'..'7') ('0'..'7')
    |   '\\' ('0'..'7') ('0'..'7')
    |   '\\' ('0'..'7')
    ;

fragment
UNICODE_ESC
    :   '\\' 'u' HEX_DIGIT HEX_DIGIT HEX_DIGIT HEX_DIGIT
    ;
