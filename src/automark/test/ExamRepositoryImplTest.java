package automark.test;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import automark.model.ExamDoDetail;
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
	@Test
	public void tesTestCode() {
		ExamDoDetail examDoDetail = examService.testCode(1, 1, 1, 1, 30, 1, "我的答题");
	//	int count = examRepository.saveAnswer(1, "哈哈哈", 1, 30, "通过");
		System.out.println("更新："+examDoDetail.getAutoResult());
	}
	
	@Test
	public void testSetNowStatus() {
	//	examService.setNowStatus(1, -1);
		
		ExamDoDetail examDoDetail = new ExamDoDetail();
		examDoDetail.setMpid(1);
		examDoDetail.setEdid(1);
		examDoDetail.setStuAnswer("");
		examDoDetail.setAnswerType(0);
		examDoDetail.setAnswerTime(new Date());
		examDoDetail.setAutoGrade(0);
		examDoDetail.setAutoResult("");
		examDoDetail.setTeacherVerify(-1);
		System.out.println(examRepository.addExamDoDetail(examDoDetail));
	}
	
	
}
