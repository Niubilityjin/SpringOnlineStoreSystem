
import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.tedu.store.bean.User;
import cn.tedu.store.mapper.UserMapper;
import cn.tedu.store.service.IUserService;
import cn.tedu.store.service.UserService;

public class test {
	
	public void testinsert(){
		User user=new User();
		AbstractApplicationContext ac=new ClassPathXmlApplicationContext("spring-dao.xml");
		UserMapper userMapper 
		= ac.getBean(
			"userMapper", 
			UserMapper.class);
		
		user.setUsername("laojin");
		user.setPassword("2222");
		user.setPhone("123");
		user.setEmail("2222");
		user.setGender(1);
		userMapper.insert
		(user);
		ac.close();
		
	
	}
	
	public void testgetUserByUsername() {
		AbstractApplicationContext ac=new ClassPathXmlApplicationContext("spring-dao.xml");
		UserMapper userMapper 
		= ac.getBean(
			"userMapper", 
			UserMapper.class);
		User user=userMapper.getUserByUsername("laojin");
		System.out.println(user);
	}
	
	@Test
	public void testregist() {
		User user=new User();
		AbstractApplicationContext ac=new ClassPathXmlApplicationContext("spring-dao.xml","spring-service.xml");
		IUserService userService 
		= ac.getBean(
			"userService", 
			IUserService.class);
		
		user.setUsername("laojin8");
		user.setPassword("666666");
		user.setPhone("88888888");
		user.setEmail("66666@qq.com");
		userService.register(user);
	}
	
	public void testselectByEmail() {
		
		AbstractApplicationContext ac=new ClassPathXmlApplicationContext("spring-dao.xml","spring-service.xml");
		UserMapper userMapper 
		= ac.getBean(
			"userMapper", 
			UserMapper.class);
		
		System.out.println(userMapper.getCountByEmail("111"));
	}
	
	public void testselectByPhone() {
		
		AbstractApplicationContext ac=new ClassPathXmlApplicationContext("spring-dao.xml","spring-service.xml");
		UserMapper userMapper 
		= ac.getBean(
			"userMapper", 
			UserMapper.class);
		
		System.out.println(userMapper.getCountByPhone("123"));
	}
	
	public void testcheckUsername() {
		
		AbstractApplicationContext ac=new ClassPathXmlApplicationContext("spring-dao.xml","spring-service.xml");
		IUserService userService 
		= ac.getBean(
			"userService", 
			IUserService.class);
		System.out.println(userService.checkUsername("laojin6"));
	}
	@Test
	public void testcheckPhone() {
		AbstractApplicationContext ac=new ClassPathXmlApplicationContext("spring-dao.xml","spring-service.xml");
		IUserService userService 
		= ac.getBean(
			"userService", 
			IUserService.class);
		System.out.println(userService.checkPhone("1233"));
	}
	@Test
	public void testcheckEmail() {
		AbstractApplicationContext ac=new ClassPathXmlApplicationContext("spring-dao.xml","spring-service.xml");
		IUserService userService 
		= ac.getBean(
			"userService", 
			IUserService.class);
		System.out.println(userService.checkEmail("2222"));
	}
	@Test
	public void testLogin() {
		AbstractApplicationContext ac=new ClassPathXmlApplicationContext("spring-dao.xml","spring-service.xml");
		IUserService userService 
		= ac.getBean(
			"userService", 
			IUserService.class);
		
		System.out.println(userService.Login("laojin", "2222"));
	}
	@Test
	public void testUpdate() {
		AbstractApplicationContext ac=new ClassPathXmlApplicationContext("spring-dao.xml","spring-service.xml");
		UserMapper userMapper 
		= ac.getBean(
			"userMapper", 
			UserMapper.class);
		User user=new User();
		user.setId(1);
		
		user.setPassword("666666");
		user.setPhone("0000000");
		user.setEmail("66666@qq.com");
		userMapper.update(user);
		ac.close();
		
	}
	@Test
	public void testchangepassword() {
		AbstractApplicationContext ac=new ClassPathXmlApplicationContext("spring-dao.xml","spring-service.xml");
		IUserService userService 
		= ac.getBean(
			"userService", 
			IUserService.class);
		userService.changePassword(9, "666666", "8888888");
	}
	
	@Test
	public void testUpdateUser() {
		AbstractApplicationContext ac=new ClassPathXmlApplicationContext("spring-dao.xml","spring-service.xml");
		IUserService userService 
		= ac.getBean(
			"userService", 
			IUserService.class);
		userService.updatePerson(1, "laojin3", 1, "", "laojin123@qq.com");
	}
	
	

}
