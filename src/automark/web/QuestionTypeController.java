package automark.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import automark.model.QuestionType;
import automark.service.QuestionService;

@Controller
public class QuestionTypeController {
	
	private QuestionService questionService;
	/**
	 * 获取题目类型列表json数据
	 * @return
	 */
	@RequestMapping(value="/json/question/types")
	@ResponseBody
	public List<QuestionType> jsonQuestionTypes(){
		List<QuestionType> list = questionService.findAllQuestionTypes();
		return list;
	}
}
