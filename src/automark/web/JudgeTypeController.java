package automark.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import automark.model.JudgeType;

@Controller
public class JudgeTypeController {
	/**
	 * 返回批阅方式列表json数据
	 * @return
	 */
	@RequestMapping(value="/json/judgeTypes")
	@ResponseBody
	public List<JudgeType> jsonJudgeTypes(){
		List<JudgeType> list = new ArrayList<>();
		return list;
	}
}
