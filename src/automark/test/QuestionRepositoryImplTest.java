package automark.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import automark.dto.QuestionDto;
import automark.model.Question;
import automark.repository.QuestionRepository;
import automark.service.QuestionService;

public class QuestionRepositoryImplTest extends BaseTest{
	@Autowired
	QuestionRepository questionRepository;
	@Autowired
	QuestionService questionService;
	
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testFindPagedQuestionsByTeacherId() {
		List<QuestionDto> list = questionRepository.findPagedQuestionsByTeacherId(2, 1);
		System.out.println(list.size());
	}
	
	@Test
	public void testCountQuestionsByTeacherId() {
		System.out.println(questionRepository.countQuestionsByTeacherId(2));
	}
	
	@Test
	public void testCountFindPagedQuestionsByKeys() {
	//	System.out.println("这里执行"+questionRepository.findPagedQuestionsByKeys(2, 1, 1, "8", 1).size());
		
		System.out.println("这里执行"+questionRepository.countQuestionsByKeys(2, 1, 1, "8"));
	}
	
	@Test
	public void testQuestionById() {
	//	System.out.println("这里执行"+questionRepository.findPagedQuestionsByKeys(2, 1, 1, "8", 1).size());
		
		System.out.println(questionRepository.findQuestionById(90));
	}
	
	@Test
	public void testAnswersByQuestionId() {
	//	System.out.println("这里执行"+questionRepository.findPagedQuestionsByKeys(2, 1, 1, "8", 1).size());
		
		System.out.println(questionRepository.findAnswersByQuestionId(26).size());
	}
	@Test
	public void testAddQuestion() {
		//	System.out.println("这里执行"+questionRepository.findPagedQuestionsByKeys(2, 1, 1, "8", 1).size());
			Question question = new Question();
			question.setQid(0);
			question.setUid(5);
			question.setQtid(1);
			question.setJtid(1);
			question.setReadGrant(1);
			question.setTitle("题目30");
			question.setDescription("描述30");
			System.out.println(questionRepository.addQuestion(question));
	}
	
	
	@Test
	public void testUpdateQuestion() {
		//	System.out.println("这里执行"+questionRepository.findPagedQuestionsByKeys(2, 1, 1, "8", 1).size());
			Question question = new Question();
			question.setQid(1);
			question.setUid(5);
			question.setQtid(1);
			question.setJtid(1);
			question.setReadGrant(1);
			question.setTitle("题目30");
			question.setDescription("<p>修改的<%2Fp>%0D%0A");
			System.out.println(questionRepository.updateQuestion(question));
	}
	
}
