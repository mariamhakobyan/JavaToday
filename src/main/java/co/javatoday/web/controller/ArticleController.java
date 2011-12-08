package co.javatoday.web.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import co.javatoday.ApplicationAttributes;
import co.javatoday.data.model.Article;
import co.javatoday.service.Service;

@Controller
public class ArticleController {
	
	@Autowired
	@Qualifier("articleService")
	private Service articleService;
	
	@RequestMapping(value={"/a/**"}, method = RequestMethod.GET)
	public ModelAndView view() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("articlePage");
		return mav;
	}
	
	@RequestMapping(value={"/vote-up"}, method = RequestMethod.GET)
	public ModelAndView voteUp() {
		ModelAndView mav = new ModelAndView();
		return mav;
	}
	
	@RequestMapping(value={"/vote-down"}, method = RequestMethod.GET)
	public ModelAndView voteDown() {
		ModelAndView mav = new ModelAndView();
		return mav;
	}
	
	@RequestMapping(value={"/articles/recent"}, method = RequestMethod.GET)
	public ModelAndView recentArticles(@RequestParam(value="page", required=false) String page) {
		if(page == null || page.trim().equals("")) {
			page = "1";
		}
		
		PageRequest pageRequest = new PageRequest(Integer.parseInt(page) - 1, ApplicationAttributes.ATTR_ITEMS_PER_PAGE);
		
		Page<Article> articles = (Page<Article>) articleService.findAll(pageRequest);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("articles", articles);
		mav.setViewName("welcomePage");
		return mav;
	}
	
	@RequestMapping(value={"/articles/recent-ajax"}, method = RequestMethod.GET)
	public @ResponseBody Page<Article> recentAjaxArticles(@RequestParam(value="page", required=false) String page) {
		if(page == null || page.trim().equals("")) {
			page = "1";
		}
		
		PageRequest pageRequest = new PageRequest(Integer.parseInt(page) - 1, ApplicationAttributes.ATTR_ITEMS_PER_PAGE);
		
		Page<Article> articles = (Page<Article>) articleService.findAll(pageRequest);
		
		return articles;
	}
	
	@RequestMapping(value={"/articles/top"}, method = RequestMethod.GET)
	public ModelAndView topArticles(@RequestParam(value="page", required=false) String page) {
		if(page == null || page.trim().equals("")) {
			page = "1";
		}
		
		PageRequest pageRequest = new PageRequest(Integer.parseInt(page) - 1, ApplicationAttributes.ATTR_ITEMS_PER_PAGE);
		
		Page<Article> articles = (Page<Article>) articleService.findAll(pageRequest);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("articles", articles);
		mav.setViewName("welcomePage");
		return mav;
	}
	
	@RequestMapping(value={"/articles/later"}, method = RequestMethod.GET)
	public ModelAndView laterArticles(@RequestParam(value="page", required=false) String page) {
		if(page == null || page.trim().equals("")) {
			page = "1";
		}
		
		PageRequest pageRequest = new PageRequest(Integer.parseInt(page) - 1, ApplicationAttributes.ATTR_ITEMS_PER_PAGE);
		
		Page<Article> articles = (Page<Article>) articleService.findAll(pageRequest);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("articles", articles);
		mav.setViewName("welcomePage");
		return mav;
	}
	
	@RequestMapping(value={"/articles/favorite"}, method = RequestMethod.GET)
	public ModelAndView favoriteArticles(@RequestParam(value="page", required=false) String page) {
		if(page == null || page.trim().equals("")) {
			page = "1";
		}
		
		PageRequest pageRequest = new PageRequest(Integer.parseInt(page) - 1, ApplicationAttributes.ATTR_ITEMS_PER_PAGE);
		
		Page<Article> articles = (Page<Article>) articleService.findAll(pageRequest);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("articles", articles);
		mav.setViewName("welcomePage");
		return mav;
	}
}