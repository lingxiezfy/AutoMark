package automark.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import automark.repository.UserRepository;

public class UserRepositoryImplTest extends BaseTest {
	
	@Autowired
	private UserRepository userRepository;
	
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testFindUserByAccount() {
		userRepository.findUserByAccount("15201221");
	}

}
