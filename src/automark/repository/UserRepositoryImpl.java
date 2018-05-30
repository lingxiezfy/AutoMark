package automark.repository;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import automark.model.User;
import automark.repository.mapper.UserMapper;

@Repository
public class UserRepositoryImpl implements UserRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate ;

	@Override
	public User findUserByAccount(String account) {

		String sql = "select * from user where account = ? ";
		User user = null;
		try {
			user = jdbcTemplate.queryForObject(sql, new UserMapper(), account);
		}catch (DataAccessException e) {
			user = null;
		}
		return user;
	}

	@Override
	public List<User> findStudentsByClassId(int cid) {
		
		return null;
	}

}
