package automark.test;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import automark.repository.ExamRepository;
import automark.service.ExamService;

public class ExamRepositoryImplTest extends BaseTest{
	@Autowired
	ExamRepository examRepository;
	@Autowired
	ExamService examService;
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testFindExamInfoByStudentId() {
		examService.findExamInfoByStudentId(1, 2);
	}
	
	@Test
	public void testFindExamDetailIdList() {
		List<Integer> list = examRepository.findExamDetailIdList(20);
		System.out.println(Arrays.toString(list.toArray()));
	}
	
	@Test
	public void testFindExamDoDetailByIndex() {
		examRepository.findExamDoDetailByIndex(1, 1);
	}
}
