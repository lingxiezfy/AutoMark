package automark.repository.mapper;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import automark.model.Classes;

public class ClassesMapper implements RowMapper<Classes> ,Serializable{

	@Override
	public Classes mapRow(ResultSet rs, int rowNum) throws SQLException {
		Classes classes = new Classes();
		classes.setCid(rs.getInt("cid"));
		classes.setName(rs.getString("name"));
		return classes;
	}

}
