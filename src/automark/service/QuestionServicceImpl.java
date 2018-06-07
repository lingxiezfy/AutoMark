package automark.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import automark.dto.QuestionDto;
import automark.model.Answer;
import automark.model.Question;
import automark.model.QuestionType;
import automark.repository.AnswerRepository;
import automark.repository.QuestionRepository;

@Service
public class QuestionServicceImpl implements QuestionService {
	@Autowired
	QuestionRepository questionRepository ;
	@Autowired
	AnswerRepository answerRepository;
	
	@Override
	
	public List<QuestionType> findAllQuestionTypes() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<QuestionDto> findPagedQuestionsByTeacherId(int uid, int currPage) {
		List<QuestionDto> list = questionRepository.findPagedQuestionsByTeacherId(uid,currPage);
		for (QuestionDto questionDto : list) {
			if(questionDto.getjType().getJtid() == 3) {
				List<Answer> answers = answerRepository.findAnswersByQid(questionDto.getQid());
				questionDto.setAnswers(answers);
			}
		}
		return list;
	}
	@Override
	public int countQuestionsByTeacherId(int uid) {
		return questionRepository.countQuestionsByTeacherId(uid);
	}
	@Override
	public List<QuestionDto> findPagedQuestionsByKeys(int uid, int qtid, int readgrant,String key, int currPage) {
		List<QuestionDto> list = questionRepository.findPagedQuestionsByKeys(uid,qtid,readgrant, key, currPage);
		return list;
	}
	@Override
	public int countQuestionsByKeys(int uid, int qtid, int readgrant,String key) {
		return questionRepository.countQuestionsByKeys(uid,qtid,readgrant,key);
	}

	@Override
	public int deleteById(int qid) {
		return questionRepository.deleteById(qid);
	}

	@Override
	public int updateQuestionReadGrant(int qid, int readGrant) {
		readGrant = (readGrant == 1 ? 2 :1);
		return questionRepository.updateQuestionReadGrant(qid,readGrant);
	}

	@Override
	public Question findQuestionById(int qid) {
		return questionRepository.findQuestionById(qid);
	}

	@Override
	public List<Answer> findAnswersByQuestionId(int qid) {
		return questionRepository.findAnswersByQuestionId(qid);
	}

	@Override
	public int addQuestion(Question question) {
		return questionRepository.addQuestion(question);
	}

	@Override
	public int updateQuestion(Question question) {
		return questionRepository.updateQuestion(question);
	}

	@Override
	public List<Question> findQuestionsAll(int uid) {
		return questionRepository.findQuestionsAll(uid);
	}




}
