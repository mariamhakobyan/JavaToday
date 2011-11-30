package co.javatoday.web.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import static org.springframework.web.context.request.RequestAttributes.*;

@Controller
public class QuestionsController {
	
	@RequestMapping(value={"/q/**"}, method = RequestMethod.GET)
	public ModelAndView view(WebRequest request) {
		System.out.println(request.getAttribute("javax.servlet.forward.request_uri", SCOPE_REQUEST));
		ModelAndView mav = new ModelAndView();
		mav.setViewName("welcomePage");
		return mav;
	}
}