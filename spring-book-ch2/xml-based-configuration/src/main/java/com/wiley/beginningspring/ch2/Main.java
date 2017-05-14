package com.wiley.beginningspring.ch2;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    /*
        In this case, org.springframework.context.support.ClassPathXmlApplicationContext is used to load the
        XML configuration metadata files, which reside in the classpath of the application.
     */
	public static void main(String[] args) {
		ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("META-INF/spring/ch2-beans.xml");
		/*
            After creating "ApplicationContext" you performed a bean lookup by calling
            the "ApplicationContext.getBean()" method and obtained the accountService bean
        */
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
