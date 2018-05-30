package automark.repository;

import java.util.List;

import automark.model.QuestionType;

public interface QuestionTypeRepository {
	List<QuestionType> findAllQuestionTypes();
}
