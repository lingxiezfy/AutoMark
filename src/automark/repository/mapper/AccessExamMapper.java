package automark.repository.mapper;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import automark.dto.AccessExamDto;
import automark.model.Exam;
import automark.model.JudgeGrant;

public class AccessExamMapper implements RowMapper<AccessExamDto>,Serializable {

	@Override
	public AccessExamDto mapRow(ResultSet rs, int rowNum) throws SQLException {
		AccessExamDto accessExamDto = new AccessExamDto();
		JudgeGrant judgeGrant = new JudgeGrant();
		judgeGrant.setJgid(rs.getInt("jgid"));
		judgeGrant.setEid(rs.getInt("eid"));
		judgeGrant.setUid(rs.getInt("jguid"));
		Exam accessExam = new Exam();
		accessExam.setUid(rs.getInt("uid"));
		accessExam.setEid(rs.getInt("eid"));
		accessExam.setPid(rs.getInt("pid"));
		accessExam.setTitle(rs.getString("title"));
		accessExam.setType(rs.getInt("type"));
		accessExam.setStartTime(rs.getTimestamp("startTime"));
		accessExam.setEndTime(rs.getTimestamp("endTime"));
		accessExamDto.setAccessExam(accessExam);
		accessExamDto.setJudgeGrant(judgeGrant);
		return accessExamDto;
	}
	
}
