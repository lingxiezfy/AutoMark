package automark.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import automark.model.Answer;
import automark.repository.AnswerRepository;

public class AnswerRepositoryImplTest extends BaseTest{
	
	@Autowired
	AnswerRepository answerRepository;
	
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testFindAnswersByQid() {
		List<Answer> list = answerRepository.findAnswersByQid(1);
		System.out.println(list.size());
	}

}
