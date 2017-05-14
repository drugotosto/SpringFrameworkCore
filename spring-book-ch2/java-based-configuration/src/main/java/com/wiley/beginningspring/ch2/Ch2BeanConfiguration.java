package com.wiley.beginningspring.ch2;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/*
    Within the configuration class, you created two factory methods marked with the
    "org.springframework.context.annotation.Bean" annotation. Those methods are called
    by the Spring Container during bootstrap, and their returning values are treated
    as Spring‐managed beans.
    Within a factory method, you created a bean using its concrete class and returned it
    after setting its necessary dependencies by calling its setter methods. Dependencies
    can also be given as constructor arguments.
*/
@Configuration
public class Ch2BeanConfiguration {

	@Bean
	public AccountDao accountDao() {
		AccountDaoInMemoryImpl bean = new AccountDaoInMemoryImpl();
		//depedencies of accountDao bean will be injected here...
		return bean;
	}


	// AccountServiceImpl has a dependency to the AccountDao interface
	@Bean
	public AccountService accountService(AccountDao accountDao) {
		AccountServiceImpl bean = new AccountServiceImpl();
		bean.setAccountDao(accountDao);
		return bean;
	}
	

}
