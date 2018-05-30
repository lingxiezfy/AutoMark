package automark.service;

import java.util.List;

import automark.dto.QuestionDto;
import automark.model.QuestionType;

public interface QuestionService {
	/**
	 * 获取问题类型列表
	 * @return
	 */
	public List<QuestionType> findAllQuestionTypes();
	/**
	 * 取的教师可见的全部题目列表
	 * @param uid 教师id
	 * @return
	 */
	public List<QuestionDto> findQuestionsByTeacherId(int uid);
}
