package automark.repository.mapper;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import automark.model.Paper;
import automark.model.User;

public class PaperMapper implements RowMapper<Paper>,Serializable{

	@Override
	public Paper mapRow(ResultSet rs, int rowNum) throws SQLException {
		Paper paper = new Paper();
		paper.setPid(rs.getInt("pid"));
		paper.setTitle(rs.getString("title"));
		paper.setTotalscore(rs.getInt("totalscore"));
		paper.setReadGrant(rs.getInt("readgrant"));
		paper.setUid(rs.getInt("uid"));
		User user = new User();
		user.setUid(rs.getInt("uid"));
		user.setName(rs.getString("name"));
		paper.setPaperTeacher(user);
		return paper;
	}

}
