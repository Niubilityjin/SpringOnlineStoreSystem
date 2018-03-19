package cn.tedu.store.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.tedu.store.bean.ResponseResult;
import cn.tedu.store.bean.User;
import cn.tedu.store.mapper.UserMapper;
import cn.tedu.store.service.IUserService;
import cn.tedu.store.service.Ex.PasswordNotMatchException;
import cn.tedu.store.service.Ex.UserNotFoundException;
import cn.tedu.store.service.Ex.UsernameAlreadyExistException;


@Controller
@RequestMapping("/user")
public class UserController extends BaseController{
	@Resource
	private IUserService userService;
	@RequestMapping("/showRegister.do")
	public String showRegister() {
		return "register";
	}
	@RequestMapping("/checkUsername.do")
	@ResponseBody
	public ResponseResult<Void> checkUsername(String username){
		ResponseResult<Void> rr;
		//返回true说明用户名存在
		//返回false说明用户名不存在
		if(userService.checkUsername(username)) {
			rr=new ResponseResult<Void>(0, "用户名已存在");
		}else {
			rr=new ResponseResult<Void>(1, "用户名可以使用");
		}
		return rr;
	}
	@RequestMapping("/checkPhone.do")
	@ResponseBody
	public ResponseResult<Void> checkPhone(String phone){
		ResponseResult<Void> rr;
		//返回true说明用户名存在
		//返回false说明用户名不存在
		if(userService.checkPhone(phone)) {
			rr=new ResponseResult<Void>(0, "该手机号码已存在");
		}else {
			rr=new ResponseResult<Void>(1, "该手机号码可以使用");
		}
		return rr;
	}
	@RequestMapping("/checkEmail.do")
	@ResponseBody
	public ResponseResult<Void> checkEmail(String email){
		ResponseResult<Void> rr;
		//返回true说明用户名存在
		//返回false说明用户名不存在
		if(userService.checkEmail(email)) {
			rr=new ResponseResult<Void>(0, "该邮箱地址已存在");
		}else {
			rr=new ResponseResult<Void>(1, "该邮箱地址可以使用");
		}
		return rr;
	}
	@RequestMapping("/showLogin.do")
	public String showLogin() {
		return "login";
	}
	
	@RequestMapping("/register.do")
	//响应JSON回来
	@ResponseBody
	public ResponseResult<Void> register(
			@RequestParam("uname") String username,
			@RequestParam("upwd") String password,
			String email,String phone){
		ResponseResult<Void> rr;
		System.out.println("++++++"+username+password+email+phone);
		User user=new User();
		user.setUsername(username);
		user.setPassword(password);
		user.setPhone(phone);
		user.setEmail(email);
		try {
			userService.register(user);
			rr=new ResponseResult<Void>(1, "注册成功");
		} catch (UsernameAlreadyExistException e) {
			rr=new ResponseResult<Void>(0, e.getMessage());
		}
		return rr;
		
	}
	
	@RequestMapping("/login.do")
	//响应JSON回来
	@ResponseBody
	public ResponseResult<Void> login(
			String username,
			String password,
			HttpSession session){
		System.out.println("++++login"+username+",,,"+password);
		System.out.println("login.do开始执行");
		ResponseResult<Void> rr;
		try {
			
			User user=userService.Login(username, password);
			session.setAttribute("user", user);
			System.out.println("oooo");
			rr=new ResponseResult<Void>(1, "登录成功");
			
		} catch (UserNotFoundException e) {
			System.out.println("hahahaha");
			rr=new ResponseResult<Void>(0, e.getMessage());
			
		
		}catch(PasswordNotMatchException e) {
			System.out.println("xixixixi");
			rr=new ResponseResult<Void>(-1, e.getMessage());
			
		}
		
		
		return rr;}
	//让Session失效
			@RequestMapping("/logout.do")
		public String logout(HttpSession session) {
			session.invalidate();
			return "redirect:../main/showIndex.do";
		}
		@RequestMapping("/showPassword.do")
		public String showPassword() {
			return "personal_password";
		}
		
		@RequestMapping("/updatePassword.do")
		@ResponseBody
		public ResponseResult<Void> updatePassword(HttpSession session,
				String oldPassword,
				String newPassword){
				ResponseResult<Void> rr;
			
				try {
					Integer id=this.getUid(session);
					userService.changePassword(id, oldPassword, newPassword);
					rr=new ResponseResult<Void>(1, "修改成功");
				} catch (RuntimeException e) {
					
					rr=new ResponseResult<Void>(0, e.getMessage());
				}
			
			return rr;		
		}
		@RequestMapping("/showPerson.do")
		public String showPerson() {
			return "person";
		}
		@RequestMapping("/updatePerson.do")
		@ResponseBody
		public ResponseResult<Void> updatePerson(HttpSession session,String username,Integer gender,String phone,String email){
			ResponseResult<Void> rr;
			System.out.println("updatePerson is running");
			try {
				Integer id=this.getUid(session);
				
				userService.updatePerson(id, username, gender, phone, email);
				User user=userService.getUserById(id);
				session.setAttribute("user", user);
				rr=new ResponseResult<Void>(1, "修改成功");
			} catch (RuntimeException e) {
				
				rr=new ResponseResult<Void>(0, e.getMessage());
			}
			return rr;
			
		}
}
