package automark.repository;

import java.util.List;

import automark.model.User;

public interface UserRepository {
	/**
	 * 通过帐号检索用户信息
	 * @param account
	 * @return
	 */
	public User findUserByAccount(String account);
/**
 * 查找一个班级的学生
 * @param cid
 * @return
 */
	public List<User> findStudentsByClassId(int cid);
/**
 * 获取所有的教师信息
 * @return
 */
	public List<User> findAllTeachers();
}
