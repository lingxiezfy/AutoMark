package automark.service;

import java.util.List;

import automark.model.User;

public interface UserService {
	/**
	 * 验证用户
	 * @param account
	 * @param password
	 * @param type
	 * @return
	 */
	public User verifyUser(String account,String password,int type); 
	
	/**
	 * 获取所有的学生列表
	 * @return
	 */
	public List<User> findAllStudents();
	
	/**
	 * 获取所有教师列表
	 * @return
	 */
	public List<User> findAllTeachers();
	
	/**
	 * 获取某班级的学生列表
	 * @param id
	 * @return
	 */
	public List<User> findStudentsByClassId(int cid);
	/**
	 * 通过用户名获取用户
	 * @param name
	 * @return
	 */
	public User findUserByName(String name);
}
