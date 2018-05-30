package automark.repository.mapper;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import automark.dto.ExamDetailDto;
import automark.model.ExamDoDetail;
import automark.model.Question;

public class ExamDetailMapper implements RowMapper<ExamDetailDto>,Serializable{

	@Override
	public ExamDetailDto mapRow(ResultSet rs, int rowNum) throws SQLException {
		ExamDetailDto examDetailDto = new ExamDetailDto();
		ExamDoDetail examDoDetail =new ExamDoDetail();
		examDoDetail.setEdtid(rs.getInt("edtid"));
		examDoDetail.setMpid(rs.getInt("mpid"));
		examDoDetail.setEdid(rs.getInt("edid"));
		examDoDetail.setStuAnswer(rs.getString("stuanswer"));
		examDoDetail.setAnswerType(rs.getInt("answertype"));
		examDoDetail.setAnswerTime(rs.getTimestamp("answertime"));
		examDoDetail.setAutoGrade(rs.getInt("autograde"));
		examDoDetail.setAutoResult(rs.getString("autoresult"));
		examDoDetail.setTeacherVerify(rs.getInt("teacherverify"));
		Question question = new Question();
		
		question.setQid(rs.getInt("qid"));
		question.setUid(rs.getInt("uid"));
		question.setQtid(rs.getInt("qtid"));
		question.setJtid(rs.getInt("jtid"));
		question.setReadGrant(rs.getInt("readgrant"));
		question.setTitle(rs.getString("title"));
		question.setDescription(rs.getString("description"));
		examDetailDto.setScore(rs.getInt("score"));
		examDetailDto.setExamDoDetail(examDoDetail);
		examDetailDto.setQuestion(question);
		return examDetailDto;
	}
	
	
	
}
