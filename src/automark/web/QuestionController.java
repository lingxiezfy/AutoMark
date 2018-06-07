package automark.web;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import automark.dto.QuestionDto;
import automark.model.Answer;
import automark.model.Question;
import automark.model.User;
import automark.service.QuestionService;
import automark.vo.Message;

@Controller
public class QuestionController {
	@Autowired
	private QuestionService questionService;
	/**
	 * 进入teacher页面
	 * @param session
	 * @return
	 */
	@RequestMapping(value="/question/teacher")
	public String teacherQueation(Integer qtid,Integer readgrant,String key,Integer currPage,HttpSession session) {
		//取的教师可见的全部题目列表（并分页）
		User user = (User)session.getAttribute("user");
		List<QuestionDto> list = null;
		int totalCount = 0;
		if(currPage == null) {
			currPage=1;
		}
		if(key==null) {
			list = questionService.findPagedQuestionsByTeacherId(user.getUid(),currPage);
			totalCount = questionService.countQuestionsByTeacherId(user.getUid());
		}else {
			System.out.println("controller: "+user.getUid()+" "+ qtid+""+readgrant+" "+key+" "+currPage);
			list = questionService.findPagedQuestionsByKeys(user.getUid(),qtid,readgrant,key,currPage);
			//System.out.println("list："+list.size());
			totalCount = questionService.countQuestionsByKeys(user.getUid(),qtid,readgrant,key);
			System.out.println("totalCOunt："+totalCount);
		}
		
		int totalPage = totalCount%10 == 0 ? (int)(totalCount/10) : 1+(int)(totalCount/10);
		
		session.setAttribute("questionList", list);
		session.setAttribute("qtid", qtid);
		session.setAttribute("key", key);
		session.setAttribute("readgrant", readgrant);
		session.setAttribute("currPage", currPage);
		session.setAttribute("totalPage", totalPage);
		return "teacher/teacher";
	}
	
	/**
	 * 删除一个题目
	 * @param qid
	 * @return
	 */
	@RequestMapping(value="/json/question/delete")
	@ResponseBody
	public Message jsonQuestionDelete(int qid) {
		int count = questionService.deleteById(qid);
		Message message = new Message();
		if(count >0)
			message.setMsg("删除成功！");
		else 
			message.setMsg("删除失败");
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
		int count = questionService.updateQuestionReadGrant(qid,readGrant);
		Message message = new Message();
		if(count >0)
			message.setMsg("删除成功！");
		else 
			message.setMsg("删除失败");
		return message;
	}
	
	/**
	 * 进入修改页面
	 * @param qid
	 * @return
	 */
	@RequestMapping(value="/question/edit")
	public String editQuestion(Integer qid,Model model) {
		Question question = null;
		String action = "";
		if(qid == null) {
			//增加
			question = new Question();
			question.setQid(0);
			question.setJtid(1);
			action = "增加";
		}else {
			//查看或修改
			//取得题目信息
			question = questionService.findQuestionById(qid);
			List<Answer> answers = questionService.findAnswersByQuestionId(qid);
			model.addAttribute("answers",answers);
			action="编辑";
		}
		model.addAttribute("question",question);
		model.addAttribute("action",action);
		return "teacher/editQuestion";
	}
	

	/**
	 * 保存一个问题
	 * @param question
	 * @return
	 */
	@RequestMapping(value="/json/question/save")
	@ResponseBody
	public Message jsonQuestionSave(Question question,HttpSession session) {
		int count = 0;
		System.out.println("qid:"+question.getQid() +" desc :"+ question.getDescription());
		if(question.getQid() == 0) {
			//新增
			User user = (User) session.getAttribute("user");
			question.setUid(user.getUid());
			System.out.println("新增");
			count = questionService.addQuestion(question);
		}else {
			//更新
			System.out.println("更新");
			System.out.println("qid:"+question.getQid() +" desc :"+ question.getDescription());
			count = questionService.updateQuestion(question);
		}
		Message message = new Message();
		if(count >0)
			message.setMsg("操作成功！");
		else 
			message.setMsg("操作失败");
		return message;
	}
	@RequestMapping(value="/json/question/all")
	@ResponseBody
	public List<Question> jsonQuestionsAll(HttpSession session){
		User user = (User)session.getAttribute("user");
		return questionService.findQuestionsAll(user.getUid());
	}
	
}
