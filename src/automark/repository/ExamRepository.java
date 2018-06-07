package automark.repository;

import java.util.List;

import automark.dto.AccessExamDto;
import automark.dto.ExamDetailDto;
import automark.dto.ExamInfoDto;
import automark.model.Exam;
import automark.model.ExamDo;
import automark.model.ExamDoDetail;
import automark.model.JudgeGrant;

public interface ExamRepository {
	
	/**
	 * 获取学生的测试信息
	 * @param uid 学生id
	 * @return
	 */
	List<ExamInfoDto> findExamInfoByStudentId(int uid);
	/**
	 * 获取详细测试id列表
	 * @param edid
	 * @return
	 */
	List<Integer> findExamDetailIdList(int edid);
	/**
	 * 通过题序来获取测试信息
	 * @param edid
	 * @param index
	 * @return
	 */
	ExamDetailDto findExamDoDetailByIndex(int edid, int index);
	/**
	 * 保存学生答案以及批阅信息
	 * @param edtid
	 * @param stuanswer
	 * @param answertype
	 * @param autograde
	 * @param autoresult
	 * @return
	 */
	int saveAnswer(int edtid, String stuanswer, int answertype, int autograde, String autoresult);
	/**
	 * 修改nowstatus 字段
	 * @param edid 主键
	 * @param index 新值
	 */
	void setNowStatus(int edid, int index);
	/**
	 * 获取教师可见的统考列表
	 * @param uid
	 * @return
	 */
	List<AccessExamDto> findAccessExamsByTeacherId(int uid);
	/**
	 * 删除测试
	 * @param eid
	 * @return
	 */
	int deleteExamById(int eid);
	/**
	 * 查找当前测试序列最大值
	 * @return
	 */
	int findMaxEid();
	/**
	 * 增加一个测试
	 * @param exam
	 * @return
	 */
	int addExam(Exam exam);
	/**
	 * 查找当前测试详情序列最大值
	 * @return
	 */
	int findMaxEdid();
	/**
	 * 增加一个应试试详情
	 * @param examDo
	 * @return
	 */
	int addExamDo(ExamDo examDo);
	/**
	 * 增加一个测试详细的具体信息
	 * @param examDoDetail
	 * @return
	 */
	int addExamDoDetail(ExamDoDetail examDoDetail);
	/**
	 * 增加阅卷权限
	 * @param judgeGrant
	 * @return
	 */
	int addJudgeGrant(JudgeGrant judgeGrant);
	
}
