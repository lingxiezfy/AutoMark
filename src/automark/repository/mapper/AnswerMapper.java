package automark.repository.mapper;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import automark.model.Answer;

public class AnswerMapper implements RowMapper<Answer>,Serializable{

	@Override
	public Answer mapRow(ResultSet rs, int rowNum) throws SQLException {
		Answer answer = new Answer();
		answer.setAid(rs.getInt("aid"));
		answer.setQid(rs.getInt("qid"));
		answer.setInput(rs.getString("input"));
		answer.setOutput(rs.getString("output"));
		return answer;
	}

}
