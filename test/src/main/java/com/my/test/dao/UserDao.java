package com.my.test.dao;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.my.test.vo.User;

public class UserDao extends SqlSessionDaoSupport{
	public List<User> getAllUser() {
		return this.getSqlSession().selectList("ns_user.getAllUser");
	}
	
	public User getOneUser(int user_idx) {
		return this.getSqlSession().selectOne("ns_user.getOneUser", user_idx);
	} 
	
	public int insertUser(User user) {
		return this.getSqlSession().insert("ns_user.insertUser", user);
	}
	
	public int updateUser(User user) {
		return this.getSqlSession().update("ns_user.updateUser", user);
	}

 	public int deleteUser(int user_idx) {
		return this.getSqlSession().delete("ns_user.deleteUser", user_idx);
	}
 	
 	public User getUserByIdAndPw(User user) {
		return this.getSqlSession().selectOne("ns_user.getUserByIdAndPw",user);
	} 
}