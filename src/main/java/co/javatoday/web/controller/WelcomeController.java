package co.javatoday.web.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import co.javatoday.ApplicationAttributes;
import co.javatoday.data.model.Article;
import co.javatoday.data.model.PageImpl;
import co.javatoday.service.Service;

@Controller
public class WelcomeController {
	
	@Autowired
	@Qualifier("articleService")
	private Service articleService;
	
	@RequestMapping(value={"/", "/welcome"}, method = RequestMethod.GET)
	public ModelAndView welcome() {
		
		PageRequest pageRequest = new PageRequest(0, ApplicationAttributes.ATTR_ITEMS_PER_PAGE);
		
		Page<Article> articles = (Page<Article>) articleService.findAll(pageRequest);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("articles", new PageImpl<Article>(articles));
		mav.setViewName("welcomePage");
		return mav;
	}
	
	@RequestMapping(value={"/contacts", "/contact", "/contactus"}, method = RequestMethod.GET)
	public ModelAndView contactUs() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("contactPage");
		return mav;
	}
}