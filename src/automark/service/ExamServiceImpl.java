package automark.service;

import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Date;
import java.util.List;

import javax.tools.JavaCompiler;
import javax.tools.JavaFileObject;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import javax.tools.JavaCompiler.CompilationTask;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import automark.compiler.DynamicEngine;
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
		System.out.println(edtid+","+qid+","+qtid+","+jtid+","+score+","+answertype+"\""+stuanswer+"\"");
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
			//获取测试用例列表
			List<Answer> answerList = answerRepository.findAnswersByQid(qid);
			System.out.println("测试用例数："+answerList.size());
			//记录评分
			autograde = 0;
			//记录错误数
			int error = 0;
			if(answerList.size() == 0) {
				autoresult += "暂无测试用例，请等待手动批阅";
			}else {
				try {
					String className ="Main";
					DynamicEngine de = DynamicEngine.getInstance(); 
					String result = de.javaCodeCompile(className, stuanswer);
					if(result == null) {
					//编译成功
						long start = System.currentTimeMillis(); 
						Object object = de.javaCodeToObject(className, stuanswer);
						long end = System.currentTimeMillis(); 
						autoresult += "编译成功，用时:" + (end - start) + "ms\n";
						System.out.println("编译成功，用时:" + (end - start) + "ms\n");
						//获取编译类
						Class<?> c = de.getCompilerClass();
						
				        //一一检验测试用例，记录未通过的测试用例
						for (Answer answer : answerList) {
							//输入及输出重定向
							PrintStream outStream = System.out;
							System.setIn(new ByteArrayInputStream(answer.getInput().getBytes()));
							ByteArrayOutputStream outContent = new ByteArrayOutputStream();  
					        System.setOut(new PrintStream(outContent)); 
							//反射执行
					        Method method = c.getMethod("main",String[].class);
					        method.invoke(object,(Object)new String[] {});
					        //获取输出并判断结果
					        if(!outContent.toString().trim().equals(answer.getOutput().trim())) {
					        	error ++;
					        }
					        System.setOut(outStream);
					        System.out.println(outContent.toString());
						}
						if(error == 0) {
							autoresult += "测试通过！\n";
						}else {
							autoresult += "测试未通过：失败  "+error+"个用例\n";
						}
						double pre = (answerList.size()-error)/(answerList.size()*1.0);
						autograde = (int)(score * pre);
						autoresult +="评分:"+ autograde +"/"+score;
					}else {
					//编译失败
						autoresult += "编译失败:\n" + result;
						System.out.println("编译失败:\n" + result);
					}
				}catch (Exception e) {
					autoresult += "系统暂时不可用，请联系管理员！";
				}
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
