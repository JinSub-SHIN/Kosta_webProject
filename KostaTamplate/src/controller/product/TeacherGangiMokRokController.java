package controller.product;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.Controller;
import controller.ModelAndView;
import model.domain.Person;
import model.domain.Product;
import model.service.PersonService;
import model.service.ProductService;

public class TeacherGangiMokRokController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		HttpSession session = request.getSession();
		String teacherId = (String)session.getAttribute("userId");
		System.out.println(teacherId);
		
		List<Product> list = ProductService.selectByTeacherId(teacherId);
		Person person = PersonService.selectByTeacherid(teacherId);
		
		request.setAttribute("list", list);
		request.setAttribute("person", person);
		
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("mypage/teachermypage.jsp");
		
		return mv;
	}

}
