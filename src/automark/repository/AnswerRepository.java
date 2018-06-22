package automark.repository;

import java.util.List;

import automark.model.Answer;

public interface AnswerRepository {
	/**
	 * 查找通过题目id获取答案列表
	 * @param qid
	 * @return
	 */
	List<Answer> findAnswersByQid(int qid);
	int add(Answer answer);
	int delete(int aid);
	int deleteAllByQid(int qid);
	int update(Answer answer);
	List<Integer> fingAnswersIdSeqByQid(int qid);
}
