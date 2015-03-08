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
