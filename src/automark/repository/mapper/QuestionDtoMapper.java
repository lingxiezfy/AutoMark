package automark.repository.mapper;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import automark.dto.QuestionDto;
import automark.model.JudgeType;
import automark.model.QuestionType;
import automark.model.User;

public class QuestionDtoMapper implements RowMapper<QuestionDto>,Serializable{

	@Override
	public QuestionDto mapRow(ResultSet rs, int rowNum) throws SQLException {
		/*select q.*,u.name,qt.qtname,jt.jtname from question q left join user u on q.uid=u.uid 
		 left join questiontype qt on q.qtid=qt.qtid left join judgetype jt on q.jtid=jt.jtid
		 where q.uid=2 or q.readgrant=2 limit 0,10;
		  */
		
		QuestionDto questionDto = new QuestionDto();
		questionDto.setQid(rs.getInt("qid"));
		questionDto.setReadGrant(rs.getInt("readgrant"));
		questionDto.setTitle(rs.getString("title"));
		questionDto.setDescription(rs.getString("description"));
		User user = new User();
		user.setUid(rs.getInt("uid"));
		user.setName(rs.getString("name"));
		questionDto.setUser(user);
		QuestionType qType = new QuestionType();
		qType.setQtid(rs.getInt("qid"));
		qType.setQtName(rs.getString("qtname"));
		questionDto.setqType(qType);
		JudgeType jType = new JudgeType();
		jType.setJtid(rs.getInt("jtid"));
		jType.setJtName(rs.getString("jtname"));
		questionDto.setjType(jType);
		questionDto.setAnswers(null);
		return questionDto;
	}

}
