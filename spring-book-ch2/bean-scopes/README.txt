- Questo Spike tratta lo SCOPE dei beans attraverso l'implementazione di una mini web-application

- The lifetime of beans created by the Spring Container is called bean scope. By default, all beans created
by the Spring Container have singleton scope. In other words, only one bean instance is created
for a bean definition, and that instance is used by the container for the whole application lifetime.
This scope is very appropriate for beans that correspond to layers such as controller, service, and
data access object (DAO). They are usually stateless instances that serve several different requests at
the same time:

- In questo spike viene fatto uso di 3 tripologie differenti di SCOPE:
    -   SINGLETON: Scope di default dei beans. Only one instance from a bean definition is created.
                   It is the default scope for bean definitions.
                   Fanno parte di questo tipo le classi java: CommandManager, UserService

    -   PROTOTYPE: Every access to the bean definition, either through other bean definitions or
                   via the getBean(.â•›.) method, causes a new bean instance to be created. It is
                   similar to the new operator in Java.
                   Fanno parte di questo tipo le classi java: Command

    -   SESSION:   Same bean instance will be used for a specific HTTP session. Different HTTP
                   session creations cause new bean instances to be created.
                   When you define request‐ and session‐scoped beans, you have to place the <aop:scoped‐proxy/>
                   element as a child element in the <bean> element.
                   Fanno parte di questo tipo le classi java: UserPreferences


