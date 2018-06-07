package automark.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import automark.vo.ExamGrade;

@Controller
public class GradeController {
	
	/**
	 * 进入gradeView页面
	 * @return
	 */
	@RequestMapping(value="/teacher/grade")
	public String teacherGrade() {
		return "teacher/gradeView";
	}
	
	/**
	 * 获取测试成绩信息
	 * @param uid 教师id
	 * @param classessId 班级id
	 * @param eid 需要获取的测试列表 
	 * @return
	 */
	@RequestMapping(value="/json/grade")
	@ResponseBody
	public List<ExamGrade> jsonGrade(int uid,int classessId,int[] eid){
		List<ExamGrade> list = new ArrayList<>();
		return list;
	}
}
