package controller.customer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.Controller;
import controller.ModelAndView;
import exception.NotFoundException;
import model.domain.Customer;
import model.service.CustomerService;

public class CheckPwdCustomerController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		
		System.out.println(id + " : " + pwd);
		
		if(id==null||id.equals("")||pwd==null||pwd.equals("")) {
			throw new NotFoundException("입력값이 부족합니다.");
		}
		
		Customer customer = CustomerService.selectById(id);
		
		if(!customer.getPwd().equals(pwd)) {
			throw new NotFoundException("잘못된 비밀번호입니다.");
		}
		
		ModelAndView mv = new ModelAndView();
		
		HttpSession session = request.getSession();
		session.setAttribute("sessonid", id);
		
		if(customer.getStatus()==3) {
			mv.setViewName("../../Admin/index.jsp");	
		}else {
			mv.setViewName("../../marga/index.jsp");
		}
		
		return mv;
	}

}
