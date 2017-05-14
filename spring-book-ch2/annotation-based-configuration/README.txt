- Spike che istanzia lo Spring Container e lo va a configurare utilizzando Java Annotation‐Based Configuration
ovvero utilizzo dell "Automatically wiring beans" utilizzando le funzioni di:
    - Component Scanning: Spring automatically discovers beans to be created in the application context.
    - Autowiring: Spring automatically satisfies bean dependencies.

- You used the "@Service" and "@Repository" annotations to define your Spring‐managed beans. They both
extend from the "org.springframework.stereotype.Component annotation".
- The "@Service" annotation has no special meaning apart from defining a bean from the class it used on top.
- The "@Repository", on the other hand, enables additional functionality related to Spring data access,
- Therefore, your beans have the names "accountServiceImpl" and "accountDaoInMemoryImpl"

- The "org.springframework.beans.factory.annotation.Autowired" is used to tell Spring that the specified
  dependency should be satisfied from within the container if it's available. Therefore, Spring first
  looks at the input argument type of the setter method onto which the "@Autowired" annotation is placed.
  It then tries to find a Spring managed bean with that type in the container, and injects it into the
  target bean by invoking the setter method.

- Spring tries to identify classes that have the @Component annotation and its derivations during bootstrap
  by scanning classes that exist in the classpath. However, you first need to enable this component scan process
  and narrow the classpath so that the bootstrap doesn't take too much time.
  Therefore, you put the <context:component‐scan/> element into the bean configuration file

- Utilizzo del XML java ch2-beans.xml to to enable this component scan process