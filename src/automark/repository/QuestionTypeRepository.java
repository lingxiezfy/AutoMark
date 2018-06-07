package automark.repository;

import java.util.List;

import automark.model.QuestionType;

public interface QuestionTypeRepository {
	/**
	 * 获取所有的问题类型列表
	 * @return
	 */
	List<QuestionType> findAllQuestionTypes();
}
