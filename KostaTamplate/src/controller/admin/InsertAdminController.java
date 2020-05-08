package controller.admin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import controller.Controller;
import controller.ModelAndView;
import exception.NotLoginExeception;
import model.domain.Admin;
import model.domain.Category;
import model.domain.Person;
import model.domain.Teacher;
import model.service.PersonService;
import model.service.TeacherService;

public class InsertAdminController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String adminId = (String) request.getSession().getAttribute("userId");
		Integer userStatus = (Integer) request.getSession().getAttribute("userStatus");

		if (adminId == null || adminId.equals("") || userStatus != 3) {
			throw new NotLoginExeception();
		}
		
		String id = request.getParameter("Tid");
		String pwd = request.getParameter("Tpwd");
		String name = request.getParameter("Tname");
		String phone = request.getParameter("Tphone");
		String gender = request.getParameter("select");	
		
		Person person = new Person(id,pwd,name,phone,gender,3);
				
		PersonService.insert(person);
		
		ModelAndView mv = new ModelAndView();
		mv.setRedirect(true);
		mv.setViewName("Admin/insertOk2.jsp");
		
		return mv;
	}

}
