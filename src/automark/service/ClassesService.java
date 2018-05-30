package automark.service;

import java.util.List;

import automark.model.Classes;
import automark.model.Teach;

public interface ClassesService {
	/**
	 * 获取所有的班级列表
	 * @return
	 */
	public List<Classes> findAllClasses();
	/**
	 * 获取教师的教学列表
	 * @param uid
	 * @return
	 */
	public List<Teach> findTeachesByTeacherId(int uid);
	
	/**
	 * 获取学生所在的班级
	 * @param uid
	 * @return
	 */
	public Classes findClassesByStudentId(int uid) ;
}
