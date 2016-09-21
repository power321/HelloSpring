package com.shaman.beans;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.shaman.beans.controller.UserController;
import com.shaman.beans.repository.UserRepository;
import com.shaman.beans.services.UserService;

public class Main {
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("UserBeans.xml");
		
//		TestObject tObject = (TestObject) ctx.getBean("testObject");
//		System.out.println(tObject);
//		
		UserController userController = (UserController) ctx.getBean("userController");
		System.out.println(userController);
		userController.execute();
//		
//		UserService userService = (UserService) ctx.getBean("userService");
//		System.out.println(userService);
		
//		UserRepository userRepository = (UserRepository) ctx.getBean("userRepository");
//		System.out.println(userRepository);
		
	}
}
