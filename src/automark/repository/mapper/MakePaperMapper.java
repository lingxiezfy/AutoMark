package automark.repository.mapper;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import automark.model.MakePaper;
import automark.model.Question;

public class MakePaperMapper implements RowMapper<MakePaper>,Serializable{

	@Override
	public MakePaper mapRow(ResultSet rs, int rowNum) throws SQLException {
		MakePaper makePaper = new  MakePaper();
		Question question = new Question();
		makePaper.setMpid(rs.getInt("mpid"));
		makePaper.setPid(rs.getInt("pid"));
		makePaper.setQid(rs.getInt("qid"));
		makePaper.setScore(rs.getInt("score"));
		question.setQid(rs.getInt("qid"));
		question.setTitle(rs.getString("title"));
		makePaper.setQuestion(question);
		return makePaper;
	}

}
