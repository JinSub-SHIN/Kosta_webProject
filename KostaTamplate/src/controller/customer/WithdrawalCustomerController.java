package controller.customer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.Controller;
import controller.ModelAndView;
import exception.NotFoundException;
import model.domain.Customer;
import model.service.CustomerService;

public class WithdrawalCustomerController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("userId");
		String pwd = request.getParameter("pwd");
		
		if (id == null || id.equals("")) {
			throw new NotFoundException("입력값이 부족합니다.");
		}
		
		Customer customer = CustomerService.selectById(id);
		String getpwd = customer.getPwd();
		
		if(!pwd.equals(getpwd)) {
			throw new NotFoundException("잘못된 비밀번호입니다");
		}
		
		CustomerService.withdrawal(id);
		session.invalidate();
		ModelAndView mv = new ModelAndView(true, "Admin/deleteOk.jsp");
		return mv;
	}

}
