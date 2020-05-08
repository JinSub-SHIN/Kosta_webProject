package controller.customer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import controller.ModelAndView;
import exception.NotFoundException;
import model.service.CustomerService;

public class FindIdCustomerController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String name = request.getParameter("name");
		String phone = request.getParameter("phone");

		if (name == null || name.equals("") || phone == null || phone.equals("")) {
			throw new NotFoundException("입력값이 부족합니다.");
		}

		String findCustomerId = CustomerService.findId(name, phone);
		//System.out.println(findCustomerId);
		request.setAttribute("findCustomerId", findCustomerId);
		request.setAttribute("userName", name);
		ModelAndView mv = new ModelAndView(false, "successView/findIdResult.jsp");
		
		return mv;
	}

}
