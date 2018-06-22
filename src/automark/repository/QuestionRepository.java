package automark.repository;

import java.util.List;

import automark.dto.QuestionDto;
import automark.model.Answer;
import automark.model.Question;

public interface QuestionRepository {
	/**
	 * 获取分页的问题列表
	 * @param uid
	 * @param currPage
	 * @return
	 */
	List<QuestionDto> findPagedQuestionsByTeacherId(int uid, int currPage);
/**
 * 计算所有的问题列表
 * @param uid
 * @return
 */
	int countQuestionsByTeacherId(int uid);
/**
 * 条件检索问题列表
 * @param uid
 * @param qtid
 * @param readgrant
 * @param key
 * @param currPage
 * @return
 */
	List<QuestionDto> findPagedQuestionsByKeys(int uid, int qtid, int readgrant, String key, int currPage);
/**
 * 计算问题总数（当前条件下）
 * @param uid
 * @param qtid
 * @param readgrant
 * @param key
 * @return
 */
	int countQuestionsByKeys(int uid, int qtid, int readgrant, String key);
/**
 * 通过id删除问题
 * @param qid
 * @return
 */
	int deleteById(int qid);
/**
 * 更新问题浏览权限
 * @param qid
 * @param readGrant
 * @return
 */
	int updateQuestionReadGrant(int qid, int readGrant);

/**
 * 通过id获取问题
 * @param qid
 * @return
 */
	Question findQuestionById(int qid);
/**
 * 查找问题答案
 * @param qid
 * @return
 */
	List<Answer> findAnswersByQuestionId(int qid);
/**
 * 增加问题
 * @param question
 * @return
 */
	int addQuestion(Question question);
/**
 * 更新问题
 * @param question
 * @return
 */
	int updateQuestion(Question question);
/**
 * 获取所有的问题列表
 * @param uid
 * @return
 */
	List<Question> findQuestionsAll(int uid);
	
	List<Question> findQuestionByTitle(String title);

}
