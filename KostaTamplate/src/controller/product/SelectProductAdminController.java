package controller.product;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.Controller;
import controller.ModelAndView;
import exception.NotLoginExeception;
import model.domain.GangiMokRok;
import model.service.ProductService;

public class SelectProductAdminController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String adminId = (String) request.getSession().getAttribute("userId");
		Integer userStatus = (Integer) request.getSession().getAttribute("userStatus");

		if (adminId == null || adminId.equals("") || userStatus != 3) {
			throw new NotLoginExeception();
		}
		
		System.out.println("¾îµå¹ÎÄÁÆ®·Ñ·¯ È£ÃâµÊ....");
		
		List<GangiMokRok> list = ProductService.selectGangiMokRokAll();
		
		HttpSession session = request.getSession();
		
		session.setAttribute("Gangi", list);
		
 		ModelAndView mv = new ModelAndView();
 		mv.setRedirect(true); 		
 		mv.setViewName("Admin/table.jsp"); 
		 
 		return mv; 
	}

}
