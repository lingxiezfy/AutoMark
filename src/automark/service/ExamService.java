package automark.service;

import java.util.List;

import automark.dto.ExamDetailDto;
import automark.dto.ExamInfoDto;

public interface ExamService {

	/**
	 * 取得学生应试信息的列表
	 * @param uid
	 * @return
	 */
	List<ExamInfoDto> findExamInfoByStudentId(int uid,int cid);
	/**
	 * 取得本次应试题目详情标识edtid的列表
	 * @param edit 应试标识
	 * @return
	 */
	List<Integer> getExamDoDetailIdList(int edid);
	/**
	 * 通过题序获取当前试题详情
	 * @param edid 应试id
	 * @param index 题序
	 * @return
	 */
	ExamDetailDto getExamDoDetailByIndex(int edid,int index);
	ExamDetailDto getExamDoDetailById(int edtid);
	
}
