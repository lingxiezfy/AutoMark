package automark.service;

import java.util.List;

import automark.dto.QuestionDto;
import automark.model.Answer;
import automark.model.Question;
import automark.model.QuestionType;

public interface QuestionService {
	/**
	 * 获取问题类型列表
	 * @return
	 */
	public List<QuestionType> findAllQuestionTypes();
	/**
	 * 取的教师可见的全部题目列表(分页)
	 * @param uid 教师id
	 * @param currPage 当前页
	 * @return
	 */
	public List<QuestionDto> findPagedQuestionsByTeacherId(int uid,int currPage);
	/**
	 * 条件检索
	 * @param uid 教师id
	 * @param qtid
	 * @param key
	 * @param currPage
	 * @return
	 */
	public List<QuestionDto> findPagedQuestionsByKeys(int uid,int qtid, int readgrant,String key, int currPage);
	/**
	 * 查找当前可见的所有问题总数
	 * @param uid
	 * @return
	 */
	public int countQuestionsByTeacherId(int uid);
	/**
	 * 计算当前条件下的问题总数
	 * @param uid
	 * @param qtid
	 * @param readgrant
	 * @param key
	 * @return
	 */
	public int countQuestionsByKeys(int uid, int qtid,int readgrant, String key);
	/**
	 * 删除一个问题
	 * @param qid
	 * @return
	 */
	public int deleteById(int qid);
	/**
	 * 更新问题浏览权限
	 * @param qid
	 * @param readGrant
	 * @return
	 */
	public int updateQuestionReadGrant(int qid, int readGrant);
	/**
	 * 通过id获取问题
	 * @param qid
	 * @return
	 */
	public Question findQuestionById(int qid);
	/**
	 * 查找问题的答案列表
	 * @param qid
	 * @return
	 */
	public List<Answer> findAnswersByQuestionId(int qid);
	/**
	 * 增加一个问题
	 * @param question
	 * @return
	 */
	public int addQuestion(Question question);
	/**
	 * 更新一个问题
	 * @param question
	 * @return
	 */
	public int updateQuestion(Question question);
	/**
	 * 获取所有可见问题
	 * @param uid
	 * @return
	 */
	public List<Question> findQuestionsAll(int uid);
}
