package controller.admin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import controller.ModelAndView;
import exception.NotFoundException;
import exception.NotLoginExeception;
import model.service.PersonService;

public class KickOutCustomerController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String adminId = (String) request.getSession().getAttribute("userId");
		Integer userStatus = (Integer) request.getSession().getAttribute("userStatus");

		if (adminId == null || adminId.equals("") || userStatus != 3) {
			throw new NotLoginExeception();
		} 
		
		String customerId = request.getParameter("customerId");

		if (customerId == null || customerId.equals("")) {
			throw new NotFoundException("인자가 부족합니다.");
		}
		
		PersonService.updateStatus(adminId, customerId);
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("javaChip?command=SelectAllperson");
		
		return mv;
	}

}
