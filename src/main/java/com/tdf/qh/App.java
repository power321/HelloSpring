package com.tdf.qh;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import org.springframework.context.support.FileSystemXmlApplicationContext;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;


/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	// 创建应用程序的上下文
        //ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
    	// 使用XmlBeanFactory去生成bean工厂
    	//XmlBeanFactory factory = new XmlBeanFactory((new ClassPathResource("Beans.xml")));
    	// 使用FileSystemXmlApplicationFactory去生成bean工厂
    	ApplicationContext context = new FileSystemXmlApplicationContext("F:/MyEclipse9/HelloSpring/src/main/java/Beans.xml");
        
    	// 通过上下文获取所需的bean
    	HelloWorld obj = (HelloWorld) context.getBean("helloWorld");
    	// 通过bean工厂的getBean方法获取指定bean对象
    	//HelloWorld obj = (HelloWorld) factory.getBean("helloWorld");
        // 通过上下文获取所需的bean
        //HelloWorld obj = (HelloWorld)context.getBean("helloWorld");
        obj.getMessage();

        
        
        // Test Singleton Scope
        //testSingleton();
        
        // Test Prototype
        testPrototype();
        
    }
    
    public static void testSingleton() {
    	ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
        HelloWorld objA = (HelloWorld) context.getBean("helloWorld");
        objA.setMessage("I'm object A");
        objA.getMessage();
        HelloWorld objB = (HelloWorld) context.getBean("helloWorld");
        objB.getMessage();
    }
    
    public static void testPrototype() {
    	ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
        HelloWorld objA = (HelloWorld) context.getBean("helloWorld");
        objA.setMessage("I'm object A");
        objA.getMessage();
        HelloWorld objB = (HelloWorld) context.getBean("helloWorld");
        objB.getMessage();
    }
}
