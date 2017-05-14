package com.wiley.beginningspring.ch2;

import com.wiley.beginningspring.ch2.config.Ch2BeanConfiguration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    /*
        The "org.springframework.context.ApplicationContext" interface represents the Spring Container;
        in fact, the terms the Spring Container and ApplicationContext are often used interchangeably.
    */
	public static void main(String[] args) {
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(Ch2BeanConfiguration.class);
		AccountService accountService = applicationContext.getBean("accountService", AccountService.class);

		System.out.println("Before money transfer");
		System.out.println("Account 1 balance :" + accountService.getAccount(1).getBalance());
		System.out.println("Account 2 balance :" + accountService.getAccount(2).getBalance());		
		
		accountService.transferMoney(1, 2, 5.0);
		
		System.out.println("After money transfer");
		System.out.println("Account 1 balance :" + accountService.getAccount(1).getBalance());
		System.out.println("Account 2 balance :" + accountService.getAccount(2).getBalance());
	}

}
