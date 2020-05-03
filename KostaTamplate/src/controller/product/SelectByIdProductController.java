package controller.product;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import controller.ModelAndView;
import exception.NotFoundException;
import model.domain.Product;
import model.service.ProductService;

public class SelectByIdProductController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String prodId = request.getParameter("prodId");
		
		if(prodId==null || prodId.equals("")) {
			throw new NotFoundException("입력값이 부족합니다.");
		}
		
		Product product = ProductService.selectById(prodId);
		request.setAttribute("product", product);
		 
		ModelAndView mv = new ModelAndView(); 
		mv.setViewName(""); 
		 
		return mv; 
	}

}
