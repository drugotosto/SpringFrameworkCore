package spittr.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
import spittr.controller.WebConfig;

/**
 * Created by drugo on 17/05/2017.
 */
/*
    Basically the DispatcherServlet is the entry point of every Spring MVC application.
    Its purpose is to intercept HTTP requests and to dispatch them to the right component that will know how to handle it.
    There are  three different approaches of configuring a DispatcherServlet
        - Use XML configuration (controllers+viewResolver) and a web.xml file.
        - Migrate the Servlet declaration from the web.xml file to Java config (implementing a WebApplicationInitializer)
          but we’ll leave any other configuration in XML.
        - Use 100% Java-configured project (WebApplicationInitializer -> AbstractAnnotationConfigDispatcherServletInitializer)
          WebApplicationInitializer depends on Servlet 3.0 containers.So make sure you don’t have any web.xml
          with servlet declaration less than 3.0.
*/
public class SpitterWebInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    /*
    getServletMappings(), identifies one or more paths that DispatcherServlet will be mapped to.
    In this case, it’s mapped to /, indicating that it will be the application’s default servlet.
    It will handle all requests coming into the application.
     */
    @Override
    protected String[] getServletMappings() {
        return new String[] { "/" };
    }

    /*
        The @Configuration classes returned from getServletConfigClasses()
        will define beans for DispatcherServlet’s application context.
        DispatcherServlet is expected to load beans containing controller components
        such as controllers, view resolvers, and handler mappings
    */
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[] { WebConfig.class };
    }

    /*
    The @Configuration class’s returned getRootConfigClasses() will be used
    to configure the application context created by ContextLoaderListener (server listener).
    ContextLoaderListener is expected to load the other beans in your application.
    These beans are typically the middle-tier and dao-tier components that drive
    the back end of the application
*/
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[] { RootConfig.class};
    }
}
