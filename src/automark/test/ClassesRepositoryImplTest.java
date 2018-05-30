package automark.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import automark.repository.ClassesRepository;

public class ClassesRepositoryImplTest extends BaseTest{
	@Autowired
	ClassesRepository classesRepository;
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
		classesRepository.findTeachInfoByTeacherIdAndClassId(2, 3);
	}

}
