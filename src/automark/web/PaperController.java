package automark.web;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import automark.model.MakePaper;
import automark.model.Paper;
import automark.vo.Message;

@Controller
public class PaperController {
	
	/**
	 * 进入paperList页面
	 * @param session
	 * @return
	 */
	@RequestMapping(value="/paper/list")
	public String paperList(Model model) {
		//取得教师所能见的所有试卷信息(分页)
		return "paperList";
	}
	
	/**
	 * 增加一张试卷
	 * @param paper
	 * @return
	 */
	@RequestMapping(value="/json/paper/add")
	@ResponseBody
	public Message jsonPaperAdd(Paper paper) {
		Message message = new Message();
		return message;
	}
	
	/**
	 * 检索试卷
	 * @param title 检索条件 --标题
	 * @return
	 */
	@RequestMapping(value="/json/paper/find")
	@ResponseBody
	public List<Paper> jsonFindPapers(String title){
		List<Paper> list = new ArrayList<>();
		return list;
	}
	
	/**
	 * 删除一张试卷
	 * @param pid 试卷的Id
	 * @return
	 */
	@RequestMapping(value="/json/paper/delete")
	@ResponseBody
	public Message jsonPaperDelete(int pid) {
		Message message = new Message();
		return message;
	}
	
	/**
	 * 单独修改浏览权限
	 * @param pid 修改的试卷id
	 * @param readGrant 当前的权限
	 * @return
	 */
	@RequestMapping(value="/json/paper/readGrant/update")
	@ResponseBody
	public Message jsonPaperReadGrantUpdate(int pid,int readGrant) {
		Message message = new Message();
		return message;
	}
	
	/**
	 * 通过id获取试卷信息json数据
	 * @param pid 试卷的id
	 * @return
	 */
	@RequestMapping(value="/json/paper/info")
	@ResponseBody
	public Paper paperSelect(int pid) {
		Paper paper = new Paper();
		return paper;
	}
	
	/**
	 * 试卷选题操作
	 * @param makePapers
	 * @return
	 */
	@RequestMapping(value="/json/paper/selectQuestion")
	public Message jsonPaperSelectQuestion(List<MakePaper> makePapers) {
		Message message = new Message();
		return message;
	}
	/**
	 * 获取教师可见的全部试卷列表json数据
	 * @param uid
	 * @return
	 */
	@RequestMapping(value="/json/teacher/papers")
	@ResponseBody
	public List<Paper> jsonTeacherPapers(int uid){
		List<Paper> list = new ArrayList<>();
		return list;
	}
	
}
