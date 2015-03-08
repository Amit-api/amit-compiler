# amit-compiler

The purpose of the Amit compiler is to create a generic API definition and code generator tool. 
The goal is to have:
* Simple and readable API defintion langiage.
* Code generator templates eazy to write and idependent from the compiler.

The amit compiler is used to define API using amit API definition language and it uses FreeMaker http://freemarker.org/ to generate code from the definition.

It can be used in commad line or in a maven project by using amit-maven-plugin.
predefined Amit templates can be found in https://github.com/Amit-api/amit-templates.

Simple API definition sample:
```
project sample;

type Person {
  int id;
  string name;
}

exception InvalidPersonIdException {
}

interface PersonStorage {
  Person getPerson( int id ) throws InvalidPersonIdException;
  void updatePerson( Person person ) throws InvalidPersonIdException;
}

service PersonStorageService : PersonStorage;

```

A sample template to generate interfaces from API defintion language

* interface.ftl - file
```
<#import "macros.ftl" as my>
<#assign javaPackage = my.getJavaPackage() >
<#assign objectName = object.getName() >
package ${javaPackage};

/**
 * interface ${objectName}
 */
public interface ${objectName} <@my.extendsInterfaces items=object.getBaseInterfaceNames() />{
<#list object.getFunctions() as function >
	<#assign fname = function.getName() >
	<#assign rtype = my.javaType( function.getReturn() ) >
	
	/**
	 * function ${fname}
	 */
	${rtype} ${fname}(
	<#list function.getArguments() as arg >
		<#assign aname = arg.getName() >
		<#assign atype = my.javaType( arg ) >
		${atype} ${aname}<#if arg_has_next>,</#if>
	</#list>
	) <@my.throwsExceptions items=function.getThrowsExceptionNames() />
</#list>
}
```
