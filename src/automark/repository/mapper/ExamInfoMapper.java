package automark.repository.mapper;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import automark.dto.ExamInfoDto;
import automark.model.Exam;
import automark.model.ExamDo;
import automark.model.User;

public class ExamInfoMapper implements RowMapper<ExamInfoDto>,Serializable{

	@Override
	public ExamInfoDto mapRow(ResultSet rs, int rowNum) throws SQLException {
		ExamInfoDto examInfoDto = new ExamInfoDto();
		examInfoDto.setTeach(null);
		ExamDo examDo = new ExamDo();
		examDo.setEdid(rs.getInt("edid"));
		examDo.setUid(rs.getInt("uid"));
		examDo.setNowstatus(rs.getInt("nowstatus"));
		examDo.setTotalgrade(rs.getInt("totalgrade"));
		
		Exam exam = new Exam();
		
		exam.setEid(rs.getInt("eid"));
		exam.setPid(rs.getInt("pid"));
		exam.setType(rs.getInt("type"));
		exam.setStartTime(rs.getTimestamp("starttime"));
		exam.setEndTime(rs.getTimestamp("endTime"));
		exam.setTitle(rs.getString("examtitle"));
		
		User examTeacher = new User();
		examTeacher.setUid(rs.getInt("teacherid"));
		examTeacher.setName(rs.getString("teachername"));
		
		exam.setExamTeacher(examTeacher);
		examDo.setExam(exam);
		examInfoDto.setExamDo(examDo);
		return examInfoDto;
	}

}
