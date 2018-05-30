package automark.repository;

import java.util.List;

import automark.model.Classes;
import automark.model.Teach;

public interface ClassesRepository {
	/**
	 * 根据学生id查找所在班级
	 * @param uid
	 * @return
	 */
	public Classes findClassesByStudentId(int uid);
	
	/**
	 * 查找教师教学列表
	 * @param uid
	 * @return
	 */
	public List<Teach> findTeachesByTeacherId(int uid);
	
	/**
	 * 查找具体的教学信息
	 * @param uid
	 * @param cid
	 * @return
	 */
	public Teach findTeachInfoByTeacherIdAndClassId(int uid,int cid);
}
