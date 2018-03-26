package net.abhi.onlineshopping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import net.abhi.shoppingbackend.dao.CategoryDAO;

@Controller
	public class PageController {
		
		@Autowired
		/*private CategoryDAO categoryDAO;*/

		@RequestMapping(value={"/","/home","/index"})
		public ModelAndView index(){
			ModelAndView model=new ModelAndView("page");
			model.addObject("title","Home");
			//passing the list of categories
			/*model.addObject("categories", categoryDAO.list());*/
			model.addObject("userClickHome",true);
			return model;		
		}
		@RequestMapping(value="/about")
		public ModelAndView about(){
			ModelAndView model=new ModelAndView("page");
			model.addObject("title","About Us");
			model.addObject("userClickAbout",true);
			return model;		
		}
			
		@RequestMapping(value="/contact")
		public ModelAndView contact(){
			ModelAndView model=new ModelAndView("page");
			model.addObject("title","Contact Us");
			model.addObject("userClickContact",true);
			return model;		
		}


}
