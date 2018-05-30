package automark.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import automark.model.Classes;
import automark.model.Teach;
import automark.service.ClassesService;

@Controller
public class ClassesController {
	private ClassesService classService; 
	/**
	 * 返回全部班级列表json数据
	 * @return
	 */
	@RequestMapping(value="/json/classes",method = RequestMethod.POST)
	@ResponseBody
	public List<Classes> jsonClasses(){
		List<Classes> list = classService.findAllClasses();
		return list;
	}
	
	/**
	 * 返回教师教学列表
	 * @param uid 教师id
	 * @return
	 */
	@RequestMapping(value="/json/class/teach")
	public List<Teach> jsonClassTeach(int uid){
		List<Teach> list = classService.findTeachesByTeacherId(uid);
		return list;
	}
}
