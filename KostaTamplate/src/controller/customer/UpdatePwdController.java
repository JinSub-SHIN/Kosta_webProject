package controller.customer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.Controller;
import controller.ModelAndView;
import exception.NotFoundException;
import model.service.CustomerService;

public class UpdatePwdController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("userId");
		String pwd = request.getParameter("pwd");
		
		if(id==null || id.equals("") || pwd==null|| pwd.equals("")) {
			throw new NotFoundException("입력값이 부족합니다");
		}
		
		CustomerService.updatePwd(id, pwd);
		
		ModelAndView mv = new ModelAndView(false, "successView/completeUpdatePwd.jsp");//Admin/insertOk.jsp
		return mv;
	}

}
