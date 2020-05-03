package controller.product;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import controller.ModelAndView;

public class SelectByJogunProductController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		/**
		 * Product를 List형태로 여러개 받아와야 함 > request or session or application영역에서 setAttribute한걸 getAttribute로...
		 */ 
		 
		ModelAndView mv = new ModelAndView(); 
		mv.setViewName(""); 
		 
		return mv; 
	}

}
