# Read Me
This is a project based on book: [Test-Driven Development with Java](https://learning.oreilly.com/library/view/test-driven-development-with/9781803236230/) by Alan Mellor.

# Reference
- https://learning.oreilly.com/library/view/test-driven-development-with/9781803236230/

# Dependencies
## junit-jupiter = junit-jupiter-engine + junit-jupiter-api + junit-jupiter-params
The dependency used here (junit-jupiter) is an aggregator of junit-jupiter-engine + junit-jupiter-api + junit-jupiter-params.
```
<!-- https://mvnrepository.com/artifact/org.junit.jupiter/junit-jupiter-params -->
<dependency>
    <groupId>org.junit.jupiter</groupId>
    <artifactId>junit-jupiter-params</artifactId>
    <version>5.11.0</version>
    <scope>test</scope>
</dependency>

```
is the same as:
```
<!-- https://mvnrepository.com/artifact/org.junit.jupiter/junit-jupiter-engine -->
<dependency>
    <groupId>org.junit.jupiter</groupId>
    <artifactId>junit-jupiter-engine</artifactId>
    <version>5.11.0</version>
    <scope>test</scope>
</dependency>

<!-- https://mvnrepository.com/artifact/org.junit.jupiter/junit-jupiter-api -->
<dependency>
    <groupId>org.junit.jupiter</groupId>
    <artifactId>junit-jupiter-api</artifactId>
    <version>5.11.0</version>
    <scope>test</scope>
</dependency>

<!-- https://mvnrepository.com/artifact/org.junit.jupiter/junit-jupiter-params -->
<dependency>
    <groupId>org.junit.jupiter</groupId>
    <artifactId>junit-jupiter-params</artifactId>
    <version>5.11.0</version>
    <scope>test</scope>
</dependency>


```
## No Mockito here
Different from junit_mockito_min project, mockito dependency is not included in this super simplified version of TDD framework template.

If needed, here is the dependency:
```
  <properties>
    <mockito-junit-jupiter.version>5.13.0</mockito-junit-jupiter.version>
  </properties>
  
    <!-- https://mvnrepository.com/artifact/org.mockito/mockito-junit-jupiter -->
    <dependency>
      <groupId>org.mockito</groupId>
      <artifactId>mockito-junit-jupiter</artifactId>
      <version>${mockito-junit-jupiter.version}</version>
      <scope>test</scope>
    </dependency>
```
