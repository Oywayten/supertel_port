# Supertel Port

> \- is a simple library for converting an array of strings into an array of sequences of numbers. From the array numbers, you can get all sorts of unique ordered groups of elements.

## About the application

+ To use the library, you need to create a Port object and pass an array of strings to the constructor.
````
String[] indexes = {"1,3-5", "2", "3-4"};
Port port = new Port(indexes);
````
+ E.g. The array of strings {"1,3-5", "2", "3-4"} is converted to the following array of numbers:
  {[1, 2, 3], [1, 2, 4], [3, 2, 3], [3, 2, 4], [4, 2, 3], [4, 2, 4], [5, 2, 3], [5, 2, 4]}.

## Technology stack:

```text
+ Java 8
+ Maven 4
+ Junit 5
+ AssertJ
+ Javadoc
+ Checkstyle
```

## Build the project and run the application

```shell
mvn clean install
   ```

## Build the javadoc
```shell
mvn javadoc:javadoc
   ```

### Contacts

+ email: [oywayten+port@gmail.com](mailto:oywayten+port@gmail.com)
+ telegram: [@VitaliyJVM](https://t.me/VitaliyJVM/ "go to t.me/VitaliyJVM")