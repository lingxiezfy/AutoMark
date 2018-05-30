package automark.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;




@Controller
public class HomeController {
	/**
	 * 进入登录页面
	 * @return
	 */
	@RequestMapping(value="/")
	public String login() {
		return "login";
	}
	
	
}
