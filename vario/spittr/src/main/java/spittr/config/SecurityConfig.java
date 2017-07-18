package spittr.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.StandardPasswordEncoder;

@Configuration
// Enables web security
@EnableWebSecurity
/*
  Any bean in the Spring application context that extend "WebSecurityConfigurerAdapter" can contribute to Spring Security configuration.
  You can configure web security by overriding WebSecurityConfigurerAdapter’s three configure() methods
  and setting behavior on the parameter passed in.
*/
public class SecurityConfig extends WebSecurityConfigurerAdapter {

//    @Autowired
//    private DataSource dataSource;

    @Autowired
    private UserDetailsService userDetailsService;

  @Override
  protected void configure(HttpSecurity http) throws Exception {
      http
              // Adding a custom login page
              .formLogin()
                .loginPage("/login")
              .and()

              /* Intercepting requests (Some requests may require authentication; some may not.
                 Some requests may only be available to users with certain authorities and
                 unavailable to those without those authorities.
               */
              .authorizeRequests()
                  .antMatchers(HttpMethod.POST,"/spittles/**").authenticated()
                  .anyRequest().permitAll()
              .and()

              // Enforcing channel security HTTPS
              .requiresChannel()
                .antMatchers(HttpMethod.POST, "spitter/register/**").requiresSecure()
              .and()

              /*
              HTTP Basic authentication is one way to authenticate a user to an application directly in the HTTP request itself.
              This makes it suitable as a means for REST clients to authenticate against the services they’re consuming.
              */
              .httpBasic()
                  .realmName("Spittr")
              .and()

              /*
              Logout is implemented as a servlet filter that (by default) intercepts requests to /logout.
              The request for /logout will be handled by Spring Security’s LogoutFilter.
              The user will be logged out and any remember-me tokens cleared.
               */
              .logout();
  }


  /*
    Spring expects that certain tables exist where user data will be kept.
    If you’re okay with defining and populating tables in your database that satisfy
    specific queries, then there’s not much else for you to do.
    Otherwise you have to replace the default SQL queries with those of your own design,
    it’s important to adhere to the basic contract of the queries.
    We also use the "passwordEncoder" bean for check the matching with user input.
     */
//  @Override
//  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//    auth
//      .jdbcAuthentication()
//            .dataSource(dataSource)
//            .usersByUsernameQuery("select username, password, true " + "from Spitter where username=?")
//            .authoritiesByUsernameQuery("select username, 'ROLE_USER' from Spitter where username=?")
//            .passwordEncoder(passwordEncoder());
//  }

    /*
      Versione che fa uso di un bean della classe "userDetailsService" per meglio customizzare
      il servizio di autenticazione degli utenti attraverso apposito data store.
    */
    @Override
    protected void configure(final AuthenticationManagerBuilder auth) throws Exception {
        auth
            .authenticationProvider(authProvider());
    }

    /*
        - We are injecting our implementation of the users details service
        - We are defining an authentication provider that references our details service
        - We are also enabling the password encoder
    */
    @Bean
    public DaoAuthenticationProvider authProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        /*
            To use SpitterUserService to authenticate users, you can configure it in your security
            configuration with the "setUserDetailsService()" method.
            The userDetailsService() method (like jdbcAuthentication(), ldapAuthentication, and inMemoryAuthentication())
            configures a configuration store. But instead of using one of Spring’s provided user stores,
            it takes any implementation of "UserDetailsService".
         */
        authProvider.setUserDetailsService(userDetailsService);
        authProvider.setPasswordEncoder(passwordEncoder());
        return authProvider;
    }

    // Bean che viene utilizzato per decifrare la password scelta/inserita dall'utente.
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new StandardPasswordEncoder();
  }

}
