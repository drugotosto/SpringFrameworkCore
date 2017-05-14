Spike che effettua Autowiring attraverso Java‐Based Bean Configuration facendo uso delle annotazioni @Autowired e @Qualifier

You don't have to explicitly define dependencies in your bean definitions; you can let the Spring
Container inject them to your beans automatically. This is called autowiring. It is useful especially
during development because bean definitions need to be updated as the codebase evolves.
Autowiring has three modes:
        - byType
        - byName
        - constructor.

- In particolare si nota che ci sono 2 beans candidati associati al tipo "AccountDao" ed è per questo che deve essere usato
  il @Qualifier notification poichè il modo standard utilizzato "byType" in questo caso non funzionerebbe.
  The container failed during bootstrap because it identified two candidate beans with theAccountDao type,
  which can be auto‐injected into the accountDao property of the accountService bean.
  When you place the @Qualifier annotation together with the @Autowired and @Bean annotations,
  autowiring behavior turns into byName mode.

- Another nice feature related to autowiring in Java‐ and annotation‐based configurations is that you
  can also place @Autowired on fields. This removes the necessity of having setter methods for setter injection.

- Autowiring is only for dependencies to other beans. It doesn't work for straight values, such as
  int, boolean, String, Enum, and so on. For such properties, you can use the
  org.springframework.beans.factory.annotation.Value annotation either on the field level or on the setter method level.

  The @Value annotation accepts a String value to specify the value to be injected into the built‐in Java typed property.
  The @Value annotation can also be used for expression‐driven dependency injection.
  In other words, you can place Spring expressions (SpEl expression) or placeholders in it.