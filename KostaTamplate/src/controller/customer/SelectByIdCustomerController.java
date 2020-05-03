package controller.customer;

import javax.servlet.http.HttpServletRequest; 
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import controller.ModelAndView;
import exception.NotFoundException;
import model.domain.Customer;
import model.service.CustomerService;

	public class SelectByIdCustomerController implements Controller {
		@Override
		public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {

			String id = request.getParameter("id");
			
			if (id == null || id.equals("")) {
				throw new NotFoundException("입력값이 부족합니다.");
			}
			
	 		Customer customer = CustomerService.selectById(id); 
	 		 
	 		request.setAttribute("customer", customer); 
	 		 
	 		ModelAndView mv = new ModelAndView(); 
	 		mv.setViewName(""); 
			 
	 		return mv; 
		} 


}
