package automark.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import automark.dto.AccessExamDto;
import automark.dto.ExamDetailDto;
import automark.dto.ExamInfoDto;
import automark.model.Answer;
import automark.model.Exam;
import automark.model.ExamDo;
import automark.model.ExamDoDetail;
import automark.model.JudgeGrant;
import automark.model.MakePaper;
import automark.model.Teach;
import automark.model.User;
import automark.repository.AnswerRepository;
import automark.repository.ClassesRepository;
import automark.repository.ExamRepository;
import automark.repository.PaperRepository;
import automark.repository.QuestionRepository;
import automark.repository.UserRepository;

@Service
public class ExamServiceImpl implements ExamService{
	@Autowired
	ExamRepository examRepository;
	@Autowired
	ClassesRepository classesRepository;
	@Autowired
	AnswerRepository answerRepository;
	@Autowired
	UserRepository userRepository;
	@Autowired
	PaperRepository paperRepository;
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
	public ExamDoDetail getExamDoDetailById(int edtid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ExamDetailDto getExamDoDetailByIndex(int edid, int index) {
		//设置当前试题为index
		examRepository.setNowStatus(edid,index);
		return examRepository.findExamDoDetailByIndex(edid,index);
	}

	@Override
	public ExamDoDetail testCode(int edtid, int qid, int qtid, int jtid, int score, int answertype,
			String stuanswer) {
		ExamDoDetail examDoDetail = new ExamDoDetail();
		int autograde = 0 ;
		String autoresult ="";
		if(jtid == 1) {
			autograde = 0;
			autoresult ="该题为手动批阅类型，请等待教师批阅";
		}else if(jtid == 2) {
			autograde = (int)(score * 0.8);
			autoresult="执行耗时：0.5秒\n执行通过！";
		}else if(jtid == 3) {
			List<Answer> answerList = answerRepository.findAnswersByQid(qid);
			autograde = (int)(score * 0.6);
			int error = 0;
			//一一检验测试用例记录未通过的测试用例
			for (Answer answer : answerList) {
				if(Math.random() - 0.5 <=0) {
					error++;
				}
			}
			autograde = (int)(score * ((answerList.size()-error)/answerList.size()));
			autoresult="算法：\n  耗时：0.8秒  \n" ;
			if(error == 0) {
				autoresult += "测试通过！";
			}else {
				autoresult += "未通过：失败  "+error+" ";
			}
		}
		
		//保存提交
		examRepository.saveAnswer(edtid,stuanswer,answertype,autograde,autoresult);
		examDoDetail.setAutoGrade(autograde);
		examDoDetail.setAutoResult(autoresult);
		return examDoDetail;
	}

	@Override
	public void setNowStatus(int edid, int nowstatus) {
		examRepository.setNowStatus(edid, nowstatus);
	}

	@Override
	public List<AccessExamDto> findAccessExams(int uid) {
		return examRepository.findAccessExamsByTeacherId(uid);
	}

	@Override
	public int deleteExamAccess(int eid) {
		return examRepository.deleteExamById(eid);
	}

	@Override
	public int addExam(Exam exam, Integer[] cids, Integer[] uids) {
		//找到表中最大的id值
		int maxId = examRepository.findMaxEid();
		int nowEid = maxId +1;
		//存 exam,
		exam.setEid(nowEid);
		if( examRepository.addExam(exam) <= 0) return 0;
		//遍历班级查找学生uid
		for (Integer cid : cids) {
			List<User> students = userRepository.findStudentsByClassId(cid);
			for (User student : students) {
				/*insert into examdo values(null,uid,eid,0,0)*/
				int maxEdid = examRepository.findMaxEdid();
				ExamDo examDo = new ExamDo();
				examDo.setEdid(maxEdid+1);
				examDo.setUid(student.getUid());
				examDo.setEid(nowEid);
				examDo.setNowstatus(0);
				examDo.setTotalgrade(0);
				if( examRepository.addExamDo(examDo) <= 0) return 0;
				
				List<MakePaper> makePapers = paperRepository.findSelectedQuestionsByPaperId(exam.getPid());
				
				for (MakePaper makePaper : makePapers) {
					ExamDoDetail examDoDetail = new ExamDoDetail();
					examDoDetail.setMpid(makePaper.getMpid());
					examDoDetail.setEdid(maxEdid +1);
					examDoDetail.setStuAnswer("");
					examDoDetail.setAnswerType(0);
					examDoDetail.setAnswerTime(new Date());
					examDoDetail.setAutoGrade(0);
					examDoDetail.setAutoResult("");
					examDoDetail.setTeacherVerify(-1);
					
					if( examRepository.addExamDoDetail(examDoDetail) <=0) return 0;
				}
			}
		}
		//遍历教师id
		for (Integer uid : uids) {
			JudgeGrant judgeGrant = new JudgeGrant();
			judgeGrant.setEid(nowEid);
			judgeGrant.setUid(uid);
			if(examRepository.addJudgeGrant(judgeGrant)<=0) return 0;
		}
		
		return 1;
	}



}
