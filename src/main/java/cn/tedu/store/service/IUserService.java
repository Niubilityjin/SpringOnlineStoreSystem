package cn.tedu.store.service;

import cn.tedu.store.bean.User;

public interface IUserService {
	/**
	 * 用户注册
	 */
	void register(User user);
	boolean checkUsername(String username);
	boolean checkPhone(String phone);
	boolean checkEmail(String email);
	public User Login(String username,String password);
	/**
	 * 修改密码
	 * @param id 要修改的密码用户id
	 * @param oldPassword 旧密码
	 * @param newPassword 新密码
	 */
	
	void changePassword(Integer id,String oldPassword,String newPassword);
	
	void updatePerson(Integer id,String username,Integer gender,String phone,String email);
	User getUserById(Integer id);
}
