package spittr.config;

import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;

/*
 Used to register "DelegatingFilterProxy" with the web container.
 Once configure "DelegatingFilterProxy" in web.xml or by subclassing "AbstractSecurityWebApplicationInitializer",
 it will intercept requests coming into the application and delegate them to a bean whose ID is "springSecurityFilterChain".
 */
public class SecurityWebInitializer extends AbstractSecurityWebApplicationInitializer {
}
