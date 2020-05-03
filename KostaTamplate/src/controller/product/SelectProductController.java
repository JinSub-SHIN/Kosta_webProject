package controller.product;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import controller.ModelAndView;
import model.domain.Category;
import model.domain.GangiMokRok;
import model.domain.Product;
import model.service.CategoryService;
import model.service.ProductService;

public class SelectProductController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {

 		List<GangiMokRok> list = ProductService.selectGangiMokRokAll();
 		List<Category> catelist = CategoryService.selectAll();
 		Set<String> set = new HashSet<String>();
 		Set<String> set2 = new HashSet<String>();
 		
 		for(GangiMokRok g : list) {
 			
 			String name = g.getProduct().getTeacher().getName();
 			set.add(name);
 			
 		}
 		
 		for(GangiMokRok g : list) {
 			
 			String level = g.getProduct().getLevel();
 			set2.add(level);
 			
 		}
 		
 		request.setAttribute("Gangi", list);
 		request.setAttribute("cate", catelist);
 		request.setAttribute("set", set);
 		request.setAttribute("set2", set2);
 		 
 		
 		ModelAndView mv = new ModelAndView(); 
 		mv.setViewName("classlist/cart.jsp"); 
		 
 		return mv; 
	}

}
