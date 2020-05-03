package controller.customer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import controller.ModelAndView;
import exception.NotFoundException;
import model.service.CustomerService;

public class CheckIdCustomerController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String id = request.getParameter("id");
		
		if(id==null || id.equals("")) {
			throw new NotFoundException("입력값이 없습니다");
		}
		
		int result = CustomerService.idCheck(id);
		
		request.setAttribute("incheck", result);
		
		
		
		ModelAndView mv = new ModelAndView(false, "regForm/result.jsp");
		
		return mv;
	}

}
