package controller.customer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import controller.ModelAndView;
import exception.NotFoundException;
import model.service.CustomerService;

public class FindPwdCustomerController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String phone = request.getParameter("phone");

		if (id == null || id.equals("") || name == null || name.equals("") || phone == null || phone.equals("")) {
			throw new NotFoundException("입력값이 부족합니다.");
		}
		
		String findCustomerPwd = CustomerService.findPwd(id, name, phone);
		System.out.println(findCustomerPwd);
		request.setAttribute("findCustomerPwd", findCustomerPwd);
		
		ModelAndView mv = new ModelAndView(false, "Login/pwdresult.jsp");

		return mv;
	}

}
