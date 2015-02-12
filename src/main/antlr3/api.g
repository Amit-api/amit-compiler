grammar api;

@parser::header {
package com.amit.api.compiler.parser;

import com.amit.api.compiler.model.*;
}

@lexer::header {
package com.amit.api.compiler.parser;

}
   
start [Module module] 	
	:	statment [module] +;
	

statment [Module module] 
	: enum_statment [module]
	| type_statment
	| service_statment
	;

service_statment
@init {
	AttributeList attrList = new AttributeList();
}
	: attributes [attrList] SERVICE
	  ID
	  START
	  ( function )*  
	  END
	;
	
function 
@init {
	AttributeList attrList = new AttributeList();
}
	: attributes [attrList] function_arg OPEN function_args CLOSE SEMICOLON
	; 
		
function_args 
	: function_arg ( COMMA function_arg )*
	; 
			
function_arg 
	: ID ID
	| ARRAY ID ID
	;	
			
type_statment
@init {
	AttributeList attrList = new AttributeList();
}
	: attributes [attrList] TYPE ID START ( type_value )* END
	| attributes [attrList] TYPE ID COLON ARRAY ID
	| attributes [attrList] TYPE ID COLON ID START ( type_value )* END
	;

	
type_value 
@init {
	AttributeList attrList = new AttributeList();
}
	: attributes [attrList] ID ID SEMICOLON
	| attributes [attrList] REQUIRED ID ID SEMICOLON
	| attributes [attrList] ARRAY ID ID SEMICOLON
	;
	
			
enum_statment [Module module]
@init {
	AttributeList attrList = new AttributeList();
}
	: attributes [attrList]
	  ENUM
	  ID {
	  	TypeEnum type_enum = module.createEnum( $ID.text, new Context( $ID ) );
	  }
	  START
	  enum_values [type_enum]
	  END 
	;	


enum_value [TypeEnum type_enum]
@init {
	AttributeList attrList = new AttributeList();
}
	: attributes [attrList] ID	EQUAL number_value { type_enum.createValue( $ID.text, Integer.valueOf( $number_value.text ), new Context( $ID ), attrList  ); }
	| attributes [attrList] ID	EQUAL STRING { type_enum.createValue( $ID.text, ModuleElement.fromParsedString( $STRING.text ), new Context( $ID ), attrList  ); }
	;
	
enum_values [TypeEnum type_enum]
	: enum_value[type_enum]
	 ( COMMA enum_value[type_enum] )*
	;
		
attribute [AttributeList attrList]
	: ASTART ID EQUAL STRING ASTOP { attrList.createAttribute( $ID.text, ModuleElement.fromParsedString( $STRING.text ), new Context( $ID ) ); }
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
	
SERVICE : 'service'
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
	
OPEN	: '('
	;
	
CLOSE	: ')'
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
