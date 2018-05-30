package automark.web;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import automark.dto.QuestionDto;
import automark.model.Question;
import automark.model.User;
import automark.service.QuestionService;
import automark.vo.Message;

@Controller
public class QuestionController {
	
	private QuestionService questionService;
	/**
	 * 进入teacher页面
	 * @param session
	 * @return
	 */
	@RequestMapping(value="/question/teacher")
	public String teacherQueation(HttpSession session) {
		//取的教师可见的全部题目列表（并分页）
		User user = (User)session.getAttribute("user");
		if(user != null) {
			List<QuestionDto> list = questionService.findQuestionsByTeacherId(user.getUid());
			session.setAttribute("questionList", list);
			return "teacher/teacher";
		}else {
			return "login";
		}
		
	}
	
	/**
	 * 删除一个题目
	 * @param qid
	 * @return
	 */
	@RequestMapping(value="/json/question/delete")
	@ResponseBody
	public Message jsonQuestionDelete(int qid) {
		Message message = new Message();
		return message;
	}
	
	/**
	 * 增加一个题目
	 * @param question
	 * @return
	 */
	@RequestMapping(value="/json/question/Add")
	@ResponseBody
	public Message jsonQuestionAdd(Question question) {
		Message message = new Message();
		
		return message;
	}
	/**
	 * 进入修改页面
	 * @param qid
	 * @return
	 */
	@RequestMapping(value="/question/update")
	public String updateQuestion(int qid,HttpSession session) {
		//取得要修改的题目信息
		return "addQuestion";
	}
	
	/**
	 * 更新一个问题
	 * @param question
	 * @return
	 */
	@RequestMapping(value="/json/question/update")
	@ResponseBody
	public Message jsonQuestionUpdate(Question question) {
		Message message = new Message();
		
		return message;
	}
	
	/**
	 * 单独修改浏览权限
	 * @param qid 修改的问题id
	 * @param readGrant 当前的权限
	 * @return
	 */
	@RequestMapping(value="/json/question/readGrant/update")
	@ResponseBody
	public Message jsonQuestionReadGrantUpdate(int qid,int readGrant) {
		Message message = new Message();
		return message;
	}
	
	/**
	 * 条件检索题目列表
	 * @param qtid 题目类型id
	 * @param jtid 批阅方式id
	 * @param title 标题
	 * @return
	 */
	@RequestMapping(value="/json/question/find")
	@ResponseBody
	public List<Question> jsonFindQuestions(int qtid,int jtid,String title){
		List<Question> list = new ArrayList<>();
		//模糊搜索题目列表
		return list;
	}
	
	/**
	 * 获取教师可浏览的全部题目列表json数据
	 * @param uid
	 * @return
	 */
	@RequestMapping(value="/json/teacher/questions")
	@ResponseBody
	public List<Question> jsonQuestions(int uid){
		List<Question> list = new ArrayList<>();
		return list;
	}
	
	
	
}
