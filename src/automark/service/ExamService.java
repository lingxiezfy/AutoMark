package automark.service;

import java.util.List;

import automark.dto.AccessExamDto;
import automark.dto.ExamDetailDto;
import automark.dto.ExamInfoDto;
import automark.model.Exam;
import automark.model.ExamDoDetail;

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
	/**
	 * 通过id获取应试详细信息
	 * @param edtid
	 * @return
	 */
	ExamDoDetail getExamDoDetailById(int edtid);
	/**
	 * 测试代码 
	 * @param edtid 应试详情
	 * @param qid 题目id
	 * @param qtid 题目类型id
	 * @param jtid 判题类型id
	 * @param score 题目分数
	 * @param answertype 提交类型
	 * @param stuanswer 学生答案
	 * @return
	 */
	ExamDoDetail testCode(int edtid, int qid, int qtid, int jtid, int score, int answertype,
			String stuanswer);
	/**
	 * 修改当前考试状态
	 * @param edid
	 * @param nowstatus
	 */
	void setNowStatus(int edid, int nowstatus);
	/**
	 * 返回教师可见的统考列表
	 * @param uid
	 * @return
	 */
	List<AccessExamDto> findAccessExams(int uid);
	/**
	 * 通过统考id删除统考
	 * @param eid
	 * @return
	 */
	int deleteExamAccess(int eid);
	/**
	 * 增加统考，并增加其关联信息
	 * @param exam
	 * @param cids // 关联的班级
	 * @param uids // 关联的阅卷教师
	 * @return
	 */
	int addExam(Exam exam, Integer[] cids, Integer[] uids);
	
	
}
