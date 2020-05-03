package controller.teacher;

import javax.servlet.http.HttpServletRequest; 
import javax.servlet.http.HttpServletResponse; 
 
import controller.Controller; 
import controller.ModelAndView; 
import model.domain.Teacher; 
import model.service.TeacherService; 
 

public class SelectByNameTeacherController implements Controller {
	@Override
 	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception { 
		String teacherName = request.getParameter("teacherName");
		
 		Teacher teacher = TeacherService.selectByName(teacherName); 
 		 
 		request.setAttribute("teacher", teacher); 
 		 
 		ModelAndView mv = new ModelAndView(); 
 		mv.setViewName(""); 
		 
 		return mv; 
 	} 

}

