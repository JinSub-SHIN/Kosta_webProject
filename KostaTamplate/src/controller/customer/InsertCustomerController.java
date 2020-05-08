package controller.customer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import controller.ModelAndView;
import exception.NotFoundException;
import model.domain.Customer;
import model.domain.Person;
import model.service.CustomerService;

public class InsertCustomerController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		String name = request.getParameter("name");
		String phone = request.getParameter("phone");
		String gender = request.getParameter("gender");

		String age = request.getParameter("age");
		String email = request.getParameter("email");
		//String howToCome = request.getParameter("howToCome");
		
		if(id==null||id.equals("")||id==null||pwd.equals("")||name==null||name.equals("")
				||phone==null||phone.equals("")||gender==null||gender.equals("")||age==null||age.equals("")
				||email==null||email.equals("")) {
			
			throw new NotFoundException("입력값이 부족합니다.");
		}
		
		Customer customer = new Customer(id, pwd, name, phone, gender, 0
				, Integer.parseInt(age), email, null, null, null);
		
		CustomerService.insert(customer);
		
		ModelAndView mv = new ModelAndView(true, "Admin/insertOk.jsp");
		return mv;
	}

}
