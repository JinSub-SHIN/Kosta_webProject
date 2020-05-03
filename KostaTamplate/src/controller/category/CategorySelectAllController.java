package controller.category;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import controller.ModelAndView;

public class CategorySelectAllController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		
		
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("classlist/cart.jsp");
		
		return null;
	}

}
