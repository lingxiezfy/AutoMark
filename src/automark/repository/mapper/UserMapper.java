package automark.repository.mapper;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import automark.model.User;

public class UserMapper implements RowMapper<User> , Serializable{

	@Override
	public User mapRow(ResultSet rs, int rowNum) throws SQLException {
		User user = new User();
		user.setUid(rs.getInt("uid"));
		user.setAccount(rs.getString("account"));
		user.setPassword(rs.getString("password"));
		user.setType(rs.getInt("type"));
		user.setName(rs.getString("name"));
		return user;
	}

}
