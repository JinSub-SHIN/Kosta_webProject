package controller.customer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import controller.ModelAndView;
import exception.NotFoundException;
import model.domain.Customer;
import model.service.CustomerService;

public class UpdateCustomerController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");

		if (id == null || id.equals("") || pwd == null || pwd.equals("") || phone == null || phone.equals("")
				|| email == null || email.equals("")) {
			throw new NotFoundException("입력값이 부족합니다.");
		}

		Customer customer = new Customer(id, pwd, phone, email);
		CustomerService.update(customer);

		ModelAndView mv = new ModelAndView(true, "");
		return mv;
	}

}
