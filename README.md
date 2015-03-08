# amit-compiler

The amit compiler is used to define API using amit API definition language and it uses FreeMaker http://freemarker.org/ to generate code from the definition.

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
