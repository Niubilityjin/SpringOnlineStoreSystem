package cn.tedu.store.mapper;

import cn.tedu.store.bean.User;

public interface UserMapper {
	/**
	 * 添加用户信息
	 * @param user
	 */
	
	void insert(User user);
	/**
	 * 通过用户名查询用户信息
	 * @param username 用户名
	 * @return
	 */
	User getUserByUsername(String username);
	/**
	 * 通过邮箱查询数据,如果有,自然会返回
	 * @param email 要查询的邮箱
	 * @return 如果存在返回非0 如果不存在返回0
	 */
	Integer getCountByEmail(String email);
	Integer getCountByPhone(String Phone);
	void update(User user);
	User getUserById(Integer id);
}
