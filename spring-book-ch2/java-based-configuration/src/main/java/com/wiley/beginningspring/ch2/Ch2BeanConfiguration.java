package com.wiley.beginningspring.ch2;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class Ch2BeanConfiguration {

	@Bean
	public AccountDao accountDao() {
		AccountDaoInMemoryImpl bean = new AccountDaoInMemoryImpl();
		//depedencies of accountDao bean will be injected here...
		return bean;
	}

	@Bean
	public AccountService accountService(AccountDao accountDao) {
		AccountServiceImpl bean = new AccountServiceImpl();
		bean.setAccountDao(accountDao);
		return bean;
	}
	

}
