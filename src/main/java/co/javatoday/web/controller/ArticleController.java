package co.javatoday.web.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ArticleController {
	
	@RequestMapping(value={"/a/**"}, method = RequestMethod.GET)
	public ModelAndView view() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("welcomePage");
		return mav;
	}
}