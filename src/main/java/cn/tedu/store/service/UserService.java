package cn.tedu.store.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.tedu.store.bean.User;
import cn.tedu.store.mapper.UserMapper;
import cn.tedu.store.service.Ex.PasswordNotMatchException;
import cn.tedu.store.service.Ex.UserNotFoundException;
import cn.tedu.store.service.Ex.UsernameAlreadyExistException;

@Service
public class UserService implements IUserService{
	@Resource
	private UserMapper userMapper;
	/**
	 * 1.进行用户名的验证
	 * 2.如果用户名不相同，实现插入数据
	 * 3.如果用户名相同则抛出异常
	 */
	public void register(User user) {
		User user1=userMapper.getUserByUsername(user.getUsername());
		//用户名不存在
		if(user1==null) {
			userMapper.insert(user);
		}else {
			throw new UsernameAlreadyExistException("用户名已经存在,请重新输入!");
		} 
		
	}
	
	/**
	 * 如果用户名存在返回true,不存在返回false
	 */
	public boolean checkUsername(String username) {
		System.out.println("++++++"+username);
		if(userMapper.getUserByUsername(username)==null) {
			return false;
		}else {
			return true;
		}
		
	}
	/**
	 * 返回false说明电话不存在
	 * 返回true说明存在
	 */
	public boolean checkPhone(String phone) {
		if(userMapper.getCountByPhone(phone)==0) {
			return false;
		}else {
			return true;
		}
	}
	/**
	 * 返回false说明邮箱不存在
	 * 返回true说明邮箱存在
	 */
	public boolean checkEmail(String email) {
		if(userMapper.getCountByEmail(email)==0) {
			return false;
		}else {
			return true;
		}
	}
	/**
	 * 传入username和password验证登录,验证验证成功后会返回user
	 */
	public User Login(String username, String password) {
		User user=userMapper.getUserByUsername(username);
		if(user==null) {
			throw new UserNotFoundException("用户名不存在");
		}else {
			if(user.getPassword().equals(password)) {
				return user;
			}else {
				throw new PasswordNotMatchException("密码不匹配");
			}
		}
		
	}

	public void changePassword(Integer id, String oldPassword, String newPassword) {
		User user=userMapper.getUserById(id);
		User user1=new User();
		if(user==null) {
			throw new UserNotFoundException("未根据id查询到用户");
		}else if(oldPassword.equals(user.getPassword())) {
			user1.setId(id);
			user1.setPassword(newPassword);
			userMapper.update(user1);
		}else {
			throw new PasswordNotMatchException("旧密码不正确");
		}
		
	}

	public void updatePerson(Integer id, String username, Integer gender, String phone, String email) {
		/**
		 * 1.调用getUserById();返回User u1,如果u1==null,抛出异常.
		 * 2.调用getUserByUsername();返回User u2,
		 * 如果u2==null,gei user.setUsername(username);
		 * 3.如果u2!=null,
		 * if(u1.getUsername().equals(username)){
		 *  //不做处理，不修改用户名
		 * }else{
		 * 抛出异常
		 * }
		 * User user=new User();
		 *  update(user);
		 */

		User user=new User();
		User userold=userMapper.getUserById(id);
		User usernew=userMapper.getUserByUsername(username);
		if(userold==null) {
			throw new UserNotFoundException("要修改的用户不存在");
		}else {
			if(usernew==null) {
				user.setUsername(username);
			}else {
				if(userold.getUsername().equals(username)) {
					
				}else {//else根据输入的username在表中查询到的资料结果和要修改用户不一样且不为空
					throw new UsernameAlreadyExistException("此用户名已被占用");
				}
				
			}
		}
		user.setId(id);
		user.setEmail(email);
		user.setPhone(phone);
		user.setGender(gender);
		
		userMapper.update(user);
	}

	public User getUserById(Integer id) {
		
		return userMapper.getUserById(id);
	}
	
}
