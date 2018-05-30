package automark.repository;

import java.util.List;

import automark.dto.ExamDetailDto;
import automark.dto.ExamInfoDto;

public interface ExamRepository {

	List<ExamInfoDto> findExamInfoByStudentId(int uid);

	List<Integer> findExamDetailIdList(int edid);

	ExamDetailDto findExamDoDetailByIndex(int edid, int index);

}
