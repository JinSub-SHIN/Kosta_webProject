package controller.person;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import controller.ModelAndView;
import model.domain.Person;
import model.service.PersonService;

public class InsertPersonController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		String name = request.getParameter("name");
		String phone = request.getParameter("phone");
		String gender = request.getParameter("gender");
		String status = request.getParameter("status");
		
		if(id==null || id.equals("") || pwd==null || pwd.equals("") || name==null || name.equals("")
				|| phone==null || phone.equals("") || gender==null || gender.equals("") || status==null || status.equals("")) {
		}
		
		Person person = new Person(id, pwd, name, phone, gender, Integer.parseInt(status));
		
		PersonService.insert(person);
		ModelAndView mv = new ModelAndView();
		mv.setRedirect(true);
		mv.setViewName("selectUser");
		return mv;
	}

}
