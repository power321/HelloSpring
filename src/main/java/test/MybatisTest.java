package test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import model.User;
import dao.UserMapper;

public class MybatisTest {
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		UserMapper userMapper = (UserMapper)ctx.getBean("userMapper");
		User user = new User();
		user.setUsername("admin");
		user.setPassword("admin");
		System.out.println(userMapper.selectUser(user));
		
		User insertUser = new User();
		insertUser.setUsername("user2");
		insertUser.setPassword("user2");
		userMapper.insertUser(insertUser);
		
		
		
	}
}
