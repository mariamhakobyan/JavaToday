package co.javatoday.web.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import co.javatoday.data.model.Article;
import co.javatoday.data.repository.ArticleRepository;

@Controller
public class WelcomeController {
	
	@Autowired
	ArticleRepository articleRepository;
	
	@RequestMapping(value={"/", "/welcome"}, method = RequestMethod.GET)
	public ModelAndView welcome() {
		
		Article article = new Article();
		article.setTitle("title");
		article.setText("text");
		/*
		articleRepository.save(article);
		*/
		System.out.println("articles::::");
		System.out.println(articleRepository.findAll());
		System.out.println("articles::::");
		
		ModelAndView mav = new ModelAndView();
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