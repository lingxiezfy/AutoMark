package automark.repository.mapper;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;


import automark.model.Question;

public class QuestionMapper implements RowMapper<Question>,Serializable{

	@Override
	public Question mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		Question question = new Question();
		question.setQid(rs.getInt("qid"));
		question.setTitle(rs.getString("title"));
		question.setJtid(rs.getInt("jtid"));
		question.setQtid(rs.getInt("qtid"));
		question.setReadGrant(rs.getInt("readgrant"));
		question.setUid(rs.getInt("uid"));
		question.setDescription(rs.getString("description"));
		return question;
	}

}
