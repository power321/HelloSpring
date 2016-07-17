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
    	// ����Ӧ�ó����������
        //ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
    	// ʹ��XmlBeanFactoryȥ����bean����
    	//XmlBeanFactory factory = new XmlBeanFactory((new ClassPathResource("Beans.xml")));
    	// ʹ��FileSystemXmlApplicationFactoryȥ����bean����
    	ApplicationContext context = new FileSystemXmlApplicationContext("F:/MyEclipse9/HelloSpring/src/main/java/Beans.xml");
        
    	// ͨ�������Ļ�ȡ�����bean
    	HelloWorld obj = (HelloWorld) context.getBean("helloWorld");
    	// ͨ��bean������getBean������ȡָ��bean����
    	//HelloWorld obj = (HelloWorld) factory.getBean("helloWorld");
        // ͨ�������Ļ�ȡ�����bean
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
