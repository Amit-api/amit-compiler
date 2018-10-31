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
	AttributeList attrList = project.createAttributeList();
}	: attributes [attrList] PROJECT ID SEMICOLON { project.createModule( $ID.text, ModuleType.PROJECT, attrList, new Context( $ID ) ); }
	| LIB ID SEMICOLON { project.createModule( $ID.text, ModuleType.LIB, null, new Context( $ID ) ); }
	;

statment [Project project] 
	: enum_statment [project]
	| type_statment [project]
	| interface_statment [project]
	| exception_statment [project]
	| service_statment [project]
	| validation_expression [project]
	;

service_statment [Project project]
@init {
	AttributeList attrList = project.createAttributeList();
}
	: attributes [attrList] SERVICE
	  ID { Service service = project.createService( $ID.text, attrList, new Context( $ID ) ); }
	  interface_inh [service]
	  SEMICOLON 
	  ;

interface_statment [Project project]
@init {
	AttributeList attrList = project.createAttributeList();
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
	AttributeList attrList = interf.createAttributeList();
	ReturnValue<FunctionReturn> returnType = new ReturnValue<FunctionReturn>(); 
}
	: attributes [attrList] function_ret [returnType,interf] 
	  ID { Function fun = interf.createFunction( $ID.text, returnType.get(), attrList, new Context( $ID ) ); } 
	  function_end [fun]
	; 

function_end [Function fun]
	: POPEN function_args [fun] PCLOSE function_throws [fun] validate_optional [fun] SEMICOLON
	| POPEN PCLOSE function_throws [fun] validate_optional [fun] SEMICOLON
	;

function_throws [Function fun]
	:
	| THROWS ID { fun.addThrowsException( $ID.text ); }
	  ( function_throws_more [fun] )*
	;

function_throws_more [Function fun]
	: COMMA ID { fun.addThrowsException( $ID.text ); }
	;	
	

function_ret [ReturnValue<FunctionReturn> returnType,Interface interf]
	: ID { returnType.set( interf.getProject().createFunctionReturn( $ID.text, false, false, new Context( $ID ) ) ); }
	| ARRAY ID { returnType.set( interf.getProject().createFunctionReturn( $ID.text, true, false, new Context( $ID ) ) ); }
	| MAP ID { returnType.set( interf.getProject().createFunctionReturn( $ID.text, false, true, new Context( $ID ) ) ); }
	;
		
function_args [Function fun] 
	: function_arg [fun] ( COMMA function_arg [fun] )*
	; 
			
function_arg [Function fun]
@init {
	AttributeList attrList = fun.createAttributeList();
}
	: attributes [attrList] ID function_arg_end [$ID.text, false, false, attrList, fun] 
	| attributes [attrList] ARRAY ID function_arg_end [$ID.text, true, false, attrList, fun]
	| attributes [attrList] MAP ID function_arg_end [$ID.text, false, true, attrList, fun]
	;

function_arg_end [String type, boolean isArray, boolean isMap, AttributeList attrList, Function fun]
	: ID { fun.createArgument( type, $ID.text, isArray, isMap, attrList, new Context( $ID ) ); }
	;

exception_statment[Project project]
@init {
	AttributeList attrList = project.createAttributeList();
}
	: attributes [attrList] EXCEPTION
	  ID { TypeCommonComposite type = project.createException( $ID.text, attrList, new Context( $ID ) ); }
	  type_end [type]
	;
				
type_statment[Project project]
@init {
	AttributeList attrList = project.createAttributeList();
}
	: attributes [attrList] TYPE
	  ID { TypeCommonComposite type = project.createCompositeType( $ID.text, attrList, new Context( $ID ) ); }
	  type_end [type]
	;

type_end [TypeCommonComposite type]
	: START ( type_item [type] )* END
	| COLON ID START ( type_item [type] )* END { type.setBaseTypeName( $ID.text ); }
	;
	
type_item [TypeCommonComposite type] 
@init {
	AttributeList attrList = type.createAttributeList();
}
	: attributes [attrList] ID type_value[$ID.text, false, false, type]
	| attributes [attrList] ARRAY ID type_value[$ID.text, true, false, type]
	| attributes [attrList] MAP ID type_value[$ID.text, false, true, type]
	;

type_value [String memberType, boolean isArray, boolean isMap, TypeCommonComposite type]
	: ID SEMICOLON { type.addMember( memberType, $ID.text, isArray, isMap, new Context( $ID ) ); }
	;
			
enum_statment [Project project]
@init {
	AttributeList attrList = project.createAttributeList();
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
	AttributeList attrList = type_enum.createAttributeList();
}
	: attributes [attrList] ID	EQUAL number_value { type_enum.createValue( $ID.text, ParseUtils.parseNumber( $number_value.text ), attrList, new Context( $ID ) ); }
	| attributes [attrList] ID	EQUAL STRING { type_enum.createValue( $ID.text, ParseUtils.parseString( $STRING.text ), attrList, new Context( $ID ) ); }
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
	
validation_expression [Project project] 
@init {
	AttributeList attrList = project.createAttributeList();
}
	: attributes [attrList] VALIDATION ID {
		Validation validation = project.createValidation( $ID.text, attrList, new Context( $ID ) );
	}
	validation_expression_end [validation]
	;

validation_expression_end [Validation validation]
	: FOR ID {
		validation.setTypeName( $ID.text );
	} START
	(validation_field [validation])*
	END
	;
	
validation_field [Validation validation]
	: ID validation_field_modifier [validation, $ID.text, new Context( $ID )]
	;
	
validation_field_modifier [Validation validation, String name, Context context]
	: {
		ValidationFieldCondition c = validation.createValidationFieldCondition(name, false, false, context);
	} (validate_condition [c])+ SEMICOLON
	| ASTART ASTOP { 
		ValidationFieldCondition c = validation.createValidationFieldCondition(name, false, true, context);
	} (validate_condition [c])+ SEMICOLON
	| START END {
		ValidationFieldCondition c = validation.createValidationFieldCondition(name, true, false, context);	
	} (validate_condition [c])+ SEMICOLON
	;
	
validate_optional [Function fun]
	:
	| validate_statment [fun]
	;
	
validate_statment [Function fun]
	: VALIDATE START 
	(validate_field [fun])*
	END
	;
	
validate_field [Function fun]
	: ID validate_field_modifier [fun, $ID.text, new Context( $ID )]
	;
	
validate_field_modifier [Function fun, String name, Context context]
	: {
		ValidationFieldCondition c = fun.createValidationFieldCondition(name, false, false, context);	
	} validate_field_end [c]
	| ASTART ASTOP {
		ValidationFieldCondition c = fun.createValidationFieldCondition(name, false, true, context);	
	} validate_field_end [c]
	| START END {
		ValidationFieldCondition c = fun.createValidationFieldCondition(name, true, false, context);	
	} validate_field_end [c]
	;
	
validate_field_end [ValidationFieldCondition v]
	: SEMICOLON
	| (validate_condition [v])+ SEMICOLON
	;
	
validate_condition [ValidationFieldCondition v]
	: NOT do_operator [v]
	| range [v]
	| regex [v]
	;

do_operator [ValidationFieldCondition v]
	: NULL {v.notNull(new Context( $NULL ));}
	| EMPTY {v.notEmpty(new Context( $EMPTY ));}
	;
	
regex [ValidationFieldCondition v]
	: STRING {v.regex($STRING.text, new Context( $STRING ));}
	;
		
range [ValidationFieldCondition v]
	: ASTART 
	start_range [v]
	DOTDOT
	end_range [v]
	ASTOP
	;
	
start_range [ValidationFieldCondition v]
	:
	| INT {v.biggerOrEq($INT.text, new Context( $INT ));}
	;
	
end_range [ValidationFieldCondition v]
	: 
	| INT {v.smallerOrEq($INT.text, new Context( $INT ));}
	;
	
number_value
	: INT
	| HEX
	;
ARRAY	
	: 'array'
	;
MAP
	: 'map'
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
	
VALIDATE : 'validate'
	;

VALIDATION: 'validation'
	;
	
NULL : 'null'
	;
	
EMPTY : 'empty'
	;	
	
FOR : 'for'
	;	
	
OR : 'or'
	;
	
AND : 'and'
	;
		
ID  :	('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'0'..'9'|'_')*
    ;

INT :	'0'..'9'+
	| '-'('0'..'9')+
    ;

DOTDOT : '..'
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
	
NOT : '!'
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
