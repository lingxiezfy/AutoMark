package automark.web;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import automark.dto.QuestionDto;
import automark.model.MakePaper;
import automark.model.Paper;
import automark.model.Question;
import automark.model.User;
import automark.service.PaperService;
import automark.vo.Message;

@Controller
public class PaperController {
	@Autowired
	PaperService paperService;
	
	/**
	 * 进入paperList页面
	 * @param session
	 * @return
	 */
	@RequestMapping(value="/paper/list")
	public String paperList(String key,Integer currPage,HttpSession session) {
		//取得教师所能见的所有试卷信息(分页)
		User user = (User)session.getAttribute("user");
		List<Paper> list = null;
		int totalCount = 0;
		if(currPage == null) {
			currPage=1;
		}
		if(key==null) {
			System.out.println(user.getUid() +" 试卷  "+currPage);
			list = paperService.findPagedPapersByTeacherId(user.getUid(),currPage);
			totalCount = paperService.countPapersByTeacherId(user.getUid());
		}else {
			System.out.println("controller: "+user.getUid()+" "+key+" "+currPage);
			list = paperService.findPagedPapersByKeys(user.getUid(),key,currPage);
			//System.out.println("list："+list.size());
			totalCount = paperService.countPapersByKeys(user.getUid(),key);
			System.out.println("totalCOunt："+totalCount);
		}
		
		int totalPage = totalCount%10 == 0 ? (int)(totalCount/10) : 1+(int)(totalCount/10);
		
		session.setAttribute("paperList", list);
		session.setAttribute("key", key);
		session.setAttribute("currPage", currPage);
		session.setAttribute("totalPage", totalPage);
		return "teacher/paperList";
	}
	
	/**
	 * 检索试卷
	 * @param title 检索条件 --标题
	 * @return
	 */
	@RequestMapping(value="/json/paper/find")
	@ResponseBody
	public List<Paper> jsonFindPapers(HttpSession session){
		User user = (User)session.getAttribute("user");
		return paperService.findAllPapers(user.getUid());
	}
	
	/**
	 * 删除一张试卷
	 * @param pid 试卷的Id
	 * @return
	 */
	@RequestMapping(value="/json/paper/delete")
	@ResponseBody
	public Message jsonPaperDelete(int pid) {
		int count = paperService.deleteById(pid);
		Message message = new Message();
		if(count >0)
			message.setMsg("删除成功！");
		else 
			message.setMsg("删除失败");
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
		int count = paperService.updatePaperReadGrant(pid,readGrant);
		Message message = new Message();
		if(count >0)
			message.setMsg("删除成功！");
		else 
			message.setMsg("删除失败");
		return message;
	}
	
	/**
	 * 保存一个试卷
	 * @param question
	 * @return
	 */
	@RequestMapping(value="/json/paper/save")
	@ResponseBody
	public Message jsonPaperSave(Paper paper,HttpSession session) {
		int count = 0;
		System.out.println("qid:"+paper.getPid() +" desc :"+ paper.getTitle());
		if(paper.getPid() == 0) {
			//新增
			User user = (User) session.getAttribute("user");
			paper.setUid(user.getUid());
			System.out.println("新增");
			count = paperService.addPaper(paper);
		}else {
			//更新
			System.out.println("更新");
			System.out.println("qid:"+paper.getPid() +" desc :"+ paper.getTitle());
			count = paperService.updatePaper(paper);
		}
		Message message = new Message();
		if(count >0)
			message.setMsg("操作成功！");
		else 
			message.setMsg("操作失败");
		return message;
	}
	
	/**
	 * 通过id获取试卷信息json数据
	 * @param pid 试卷的id
	 * @return
	 */
	@RequestMapping(value="/json/paper/info")
	@ResponseBody
	public Paper paperInfo(int pid) {
		return paperService.findPaperById(pid);
	}
	
	/**
	 * 试卷选题操作
	 * @param makePapers
	 * @return
	 */
	@RequestMapping(value="/json/paper/select")
	public Message jsonPaperSelectQuestion(List<MakePaper> makePapers) {
		Message message = new Message();
		return message;
	}
	@RequestMapping(value="/json/paper/questions")
	@ResponseBody
	public List<MakePaper> jsonPaperSelectedQuestions(int pid){
		return paperService.findSeletedQuestions(pid);
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
