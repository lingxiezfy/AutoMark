package automark.web;


import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import automark.model.Classes;
import automark.model.Teach;
import automark.model.User;
import automark.service.ClassesService;
import automark.service.UserService;



@Controller
public class UserController {
	@Autowired
	private UserService userService;
	@Autowired
	private ClassesService classesService;
	/**
	 * 验证用户登录
	 * @param account 学号或工号
	 * @param password 密码
	 * @param type 类型，1代表学生，2代表老师
	 * @param session
	 * @return
	 */
	@RequestMapping(value="/login/check",method = RequestMethod.POST)
	public String checkLogin(String account, String password,int type, HttpSession session) {	
		User user = userService.verifyUser(account, password, type);
		if(user != null) {
			session.setAttribute("user", user);
			if(user.getType() == 1) {
				Classes classes = classesService.findClassesByStudentId(user.getUid());
				session.setAttribute("classes", classes);
				return "redirect: /automark/exam/student";
			}
			List<Teach> teaches =  classesService.findTeachesByTeacherId(user.getUid());
			if(teaches != null || teaches.size() >0) {
				session.setAttribute("teaches", teaches);
			}
			return "redirect: /automark/question/teacher";
		}
		session.setAttribute("errorCode", 1); //帐号或密码错误提示
		return "redirect: /automark/";
	}
	
	/**
	 * 退出系统
	 * @param session
	 * @return
	 */
	@RequestMapping(value="/logout")
	public String loginOut(HttpSession session) {
		session.removeAttribute("user");
		session.setAttribute("errorCode", 2);//退出成功提示
		return "redirect: /automark/";
	}
	
	/**
	 * 获取某班级学生的json数据
	 * @return
	 */
	@RequestMapping(value="/json/class/users")
	@ResponseBody
	public List<User> jsonClassUsers(int classesId){
		List<User> list = userService.findStudentsByClassId(classesId);
		return list;
	}
	/**
	 * 获取所有教师的json数据
	 * @return
	 */
	@RequestMapping(value="/json/teachers")
	@ResponseBody
	public List<User> jsonTeachers(){
		List<User> list = userService.findAllTeachers();
		return list;
	}
}
