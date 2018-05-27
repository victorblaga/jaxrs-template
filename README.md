# JAX-RS Template

This is a template project for creating JAX-RS restful web-services.
Included:

 - JSON Jackson configuration
 - Environment-specific configuration and dependency injection (production and local)

### Environments

The environment are defined through maven profiles (check out the `pom.xml`),
and the `war` maven plugin is customized to take it into account.

Each environment has its own `resources` and `webapp` folders:

 - `resources-local` and `webapp-local` for the local environment
 - `resources-production` and `webapp-production` for the production environment

The `resources` folder is common for all environments.
 
To add a new environment do the following:

 - Create a new profile in the `pom.xml` file (follow the local / production examples)
 - Create a new `resources-profile_name` folder (e.g. `resources-staging`)
 - Create a new `webapp-profile_name` folder (e.g. `webapp-staging`)

### Dependency injection (environment-specific)
 
Dependency injection is managed through CDI.
CDI is enabled by the presence of the `beans.xml` file in the WEB-INF folder.
Injection of non-production dependencies should be done through the standard CDI `@Alternatives` annotation.
As per the CDI specifications, `@Alternative`s have to be enabled through the `beans.xml` file.

For example, in this template, the `MockService` is annotated with `@Alternative`
and it is enabled in the `webapp-local/WEB-INF/beans.xml`

```xml
<beans...>
    <alternatives>
        <class>org.home.services.MockService</class>
    </alternatives>
</beans>
```

The `webapp-production/WEB-INF/beans.xml` does not the define an alternative for it.
This means that the mock alternative will only be injected in the `local` environment, and not in the `production` environment.

### Environment specific configuration (connection strings, usernames, etc.)

This template reads configuration from the `resources/app.properties` and `resources-{environment}/environment.properties` files.
The configuration is available by injecting a `Properties` field with the `@AppProperties` qualifier.
For example, in your service:

```java
@Dependent
public class MyService implements Service {
    private final Properties properties;
    
    @Inject
    public MyService(@AppProperties Properties properties) {
        this.properties = properties;
    }
}

// or, without constructor - more difficult to test

@Dependent
public class MyService implements Service {
    @Inject @AppProperties
    private Properties properties;
}
```