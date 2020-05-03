package controller;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogoutController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		ModelAndView mv = new ModelAndView();
		
		ServletContext application = request.getServletContext();
		String path = application.getContextPath();
		
		HttpSession session = request.getSession();
		session.invalidate();
		
		mv.setRedirect(true);
		mv.setViewName(path+"/javaChip");
		
		return mv;
	}

}
