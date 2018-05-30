package automark.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import automark.dto.ExamDetailDto;
import automark.dto.ExamInfoDto;
import automark.model.ExamDoDetail;
import automark.model.Teach;
import automark.repository.ClassesRepository;
import automark.repository.ExamRepository;

@Service
public class ExamServiceImpl implements ExamService{
	@Autowired
	ExamRepository examRepository;
	@Autowired
	ClassesRepository classesRepository;
	@Override
	public List<ExamInfoDto> findExamInfoByStudentId(int uid,int cid) {
		List<ExamInfoDto> list = examRepository.findExamInfoByStudentId(uid);
		for (ExamInfoDto examInfoDto : list) {
		System.out.println(examInfoDto.getExamDo().getExam().getTitle());	
			if(examInfoDto.getExamDo().getExam().getType() == 1) {
				Teach teach = classesRepository.findTeachInfoByTeacherIdAndClassId(
						examInfoDto.getExamDo().getExam().getExamTeacher().getUid(), 
						cid);
				System.out.println(
						examInfoDto.getExamDo().getExam().getExamTeacher().getName()+""
						+":"+teach.getCourse());
				examInfoDto.setTeach(teach);
			}
		}
		System.out.println("examService:"+list.size());
		return list;
	}

	@Override
	public List<Integer> getExamDoDetailIdList(int edid) {
		List<Integer> list =examRepository.findExamDetailIdList(edid);
		return list;
	}

	@Override
	public ExamDetailDto getExamDoDetailById(int edtid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ExamDetailDto getExamDoDetailByIndex(int edid, int index) {
		return examRepository.findExamDoDetailByIndex(edid,index);
	}



}
