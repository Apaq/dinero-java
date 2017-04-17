# Dinero Java Bindings 

You can sign up for a Dinero account at https://dinero.dk.

Requirements
============

Java 1.6 and later.

Installation
============

### Maven users

Add this dependency to your project's POM:

```xml
<dependency>
  <groupId>com.previsto</groupId>
  <artifactId>dinero-java</artifactId>
  <version>1.0.0-SNAPSHOT</version>
</dependency>
```

_Currently this requires having it build locally as it is not available in Central Repository._


Usage in Spring Boot
=====

application.yml
```yml
dinero:
  serviceUrl: http://billy.dk/api
  apiKey: YOUR_API_KEY
```

DineroExample.java

```java
import com.previsto.billy.model.Contact;

@SpringBootApplication
public class BillyExample {

    @AutoWired
    private BillyClient client;
    
    @PostConstruct
    private void init() {
      List<Contact> contacts = client.getContactResource().findAll();
        
      System.out.println("Count: " + contacts.size());
      for(Contact contact : contacts) {
        System.out.println("Contact: " + contact);
      }
    }
    
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
        
    }
}
```


See [Test.java](https://github.com/Previsto/dinero-java/blob/master/src/test/java/com/previsto/dinero/Test.java) for more examples.

Testing
=======

You must have Maven installed. To run the tests:

    mvn test


Deploy Artifact
=======
Artifacts are deployed to a secure S3 repository. 
In order to be able to deploy to it, the correct credentials are required in settings.xml. 
You set it up like this:

```
<settings>
  ...
  <servers>
    ...
    <server>
      <id>aws-release</id>
      <username>[ACCESS_KEY]</username>
      <password>[SECRET_KEY]</password>
    </server>
    <server>
      <id>aws-snapshot</id>
      <username>[ACCESS_KEY]</username>
      <password>[SECRET_KEY]</password>
    </server>
    ...
  </servers>
  ...
</settings>
```

