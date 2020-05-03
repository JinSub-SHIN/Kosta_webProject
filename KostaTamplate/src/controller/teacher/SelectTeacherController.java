package controller.teacher;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import controller.ModelAndView;
import model.domain.Teacher;
import model.service.TeacherService;

public class SelectTeacherController implements Controller {

	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {

		List<Teacher> list = TeacherService.selectAll();

		request.setAttribute("list", list);

		ModelAndView mv = new ModelAndView();
		mv.setViewName("");

		return mv;
	}

}
