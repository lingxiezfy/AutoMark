package automark.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import automark.repository.PaperRepository;

public class PaperRepositoryImplTest extends BaseTest{
	@Autowired
	PaperRepository PaperRepository;
	
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testFindPagedPapersByTeacherId() {
		fail("Not yet implemented");
	}

	@Test
	public void testCountPapersByTeacherId() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindPagedPapersByKeys() {
		fail("Not yet implemented");
	}

	@Test
	public void testCountPapersByKeys() {
		fail("Not yet implemented");
	}

}
