package automark.repository.mapper;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import automark.model.Classes;
import automark.model.Teach;

public class TeachMapper implements RowMapper<Teach>,Serializable{

	@Override
	public Teach mapRow(ResultSet rs, int rowNum) throws SQLException {
		Classes classes = new Classes();
		Teach teach = new Teach();
		classes.setCid(rs.getInt("cid")); 
		classes.setName(rs.getString("name"));
		teach.setClasses(classes);
		teach.setTid(rs.getInt("tid"));
		teach.setCourse(rs.getString("course"));
		teach.setUid(rs.getInt("uid"));
		return teach;
	}

}
