package automark.web;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import automark.dto.ExamDetailDto;
import automark.dto.ExamInfoDto;
import automark.model.Classes;
import automark.model.Exam;
import automark.model.ExamDoDetail;
import automark.model.User;
import automark.service.ExamService;
import automark.model.ExamDo;
import automark.vo.Message;

@Controller
public class ExamController {
	@Autowired
	private ExamService examService;
	/**
	 * 进入student页面,取得学生应试列表信息
	 * @param uid
	 * @return
	 */
	@RequestMapping(value="/exam/student")
	public String studentExam(HttpSession session) {
		User user = (User) session.getAttribute("user");
		System.out.println("ExamController: "+user.getName()+" "+user.getUid());
		Classes classes = (Classes) session.getAttribute("classes");
		System.out.println("ExamController: "+classes.getName()+" "+classes.getCid());
		List<ExamInfoDto> examInfoList = examService.findExamInfoByStudentId(user.getUid(),classes.getCid());
		session.setAttribute("examInfoList", examInfoList);
		session.setAttribute("errorCode", 0);
		return "student/student";
	}
	
	/**
	 * 进入doExam页面
	 * @param edid 应试的标识
	 * @param nowstatus 当前状态
	 * @return
	 */
	@RequestMapping(value="/exam/do")
	public String doExam(int edid,int nowstatus,HttpSession session) {
		//取得当前应试题目的详情信息(nowstatus)
		//取得本次应试详情id的列表(edtid)
		if(nowstatus <= 0) {
			nowstatus = 1;
		}
		ExamDetailDto examDetailDto = examService.getExamDoDetailByIndex(edid, nowstatus);
		List<Integer> edtidList = examService.getExamDoDetailIdList(edid);
		session.setAttribute("examDetail", examDetailDto);
		session.setAttribute("edtidList",edtidList);
		session.setAttribute("edid", edid);
		session.setAttribute("nowstatus", nowstatus);
		return "student/doExam";
	}
	
	/**
	 * 通过详情id获取应试详情信息json数据
	 * @param detid
	 * @return
	 */
	@RequestMapping(value="/json/exam/detail")
	@ResponseBody
	public ExamDetailDto jsonExamDetail(int edtid) {
		ExamDetailDto examDetail = examService.getExamDoDetailById(edtid);
		//同时将当前试题修改为该id
		return examDetail;
	}
	
	/**
	 * 测试代码，返回测试结果
	 * @return
	 */
	@RequestMapping(value="/json/exam/test")
	@ResponseBody
	public ExamDoDetail jsonExamTest(ExamDoDetail examDoDetail) {
		ExamDoDetail examDetailResult = new ExamDoDetail();
		return examDetailResult;
	}
	
	/**
	 * 保存测试详情
	 * @param examDetail
	 */
	@RequestMapping(value="/json/examDetail/save")
	@ResponseBody
	public Message jsonExamDetailSave(ExamDoDetail examDetail) {
		//返回保存状态信息
		Message message = new Message();
		return message;
	}
	
	/**
	 * 进入 平时测验管理页面
	 * @return
	 */
	@RequestMapping(value="/exam/daliy")
	public String daliyExam(int uid, Model model) {
		//取得教师教学的班级信息
		return "exam/daliyExam";
	}
	
	/**
	 * 进入 评估统考管理页面
	 * @return
	 */
	@RequestMapping(value="/exam/assess")
	public String assessExam(int uid, Model model) {
		//取得教师可见的统考信息列表（可批阅的+教师自创的）
		return "exam/assessExam";
	}
	/**
	 * 获取教师所带班级的测试列表 json数据
	 * @param uid 教师id
	 * @param classesId 班级id
	 * @return
	 */
	@RequestMapping(value="/json/exam/class/teach")
	@ResponseBody
	public List<ExamDo> jsonExamClassDo(int uid ,int classesId){
		List<ExamDo> list = new ArrayList<>();
		return list;
	}
	
	/**
	 * 发布测验
	 * @param title 测试名
	 * @param pid 选用的试卷id
	 * @param classes 班级列表
	 * @param startTime 开始时间
	 * @param endTime 结束时间
	 * @return
	 */
	@RequestMapping(value="/json/exam/daliy/add")
	@ResponseBody
	public Message jsonExamDaliyAdd(String title,
			int pid,
			int[] classes[],
			String startTime,
			String endTime){
		
		Message message = new Message();
		return message;
	}
	
	/**
	 * 通过id获取测试信息
	 * @param eid
	 * @return
	 */
	@RequestMapping("/json/exam/info")
	@ResponseBody
	public Exam jsonExamInfo(int eid) {
		Exam exam = new Exam();
		return exam;
	}
	
	/**
	 * 更新测试信息
	 * @param exam
	 * @return
	 */
	@RequestMapping(value="/json/exam/update")
	@ResponseBody
	public Message jsonExamUpdate(Exam exam) {
		Message message = new Message();
		return message;
	}
	
	/**
	 * 删除某个班级的某个测试信息
	 * @param classesId 班级id
	 * @param eid 测试id
	 * @return
	 */
	@RequestMapping(value="/json/exam/delete")
	@ResponseBody
	public Message jsonExamDelete(int classesId,int eid) {
		Message message = new Message();
		return message;
	}
	/**
	 * 删除统考信息
	 * @param eid 统考id
	 * @return
	 */
	@RequestMapping(value="/json/exam/access/delete")
	@ResponseBody
	public Message jsonExamAccessDelete(int eid) {
		Message message = new Message();
		return message;
	}
	
	/**
	 * 进入批阅页面（班级平时测试批阅）
	 * @param eid 需要批阅的测试id
	 * @param classesId 班级id
	 * @return
	 */
	@RequestMapping(value="/exam/read")
	public String examRead(int eid,int classesId,Model model) {
		//取得第一位同学的应试详情信息 及 该学生信息
		//取得试卷的题目列表信息
		//取得班级学生的列表信息
		return "exam/examRead";
	}
	/**
	 * 进入批阅页面（统考批阅）
	 * @param eid 需要批阅的统考id
	 * @return
	 */
	@RequestMapping(value="/exam/assess/read")
	public String examAssessRead(int eid,Model model) {
		//取得第一位同学的应试详情信息 
		//取得试卷的题目列表信息
		//取得应试学生的列表信息
		return "exam/examRead";
	}
}
