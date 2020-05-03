package controller.cart;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import controller.ModelAndView;
import exception.NotFoundException;
import model.service.CartService;

public class InsertCartController implements Controller{

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {		
		String customerId = (String)request.getSession().getAttribute("userId");
		String prodId = request.getParameter("prodId");
		
		if(customerId==null || customerId.equals("") || prodId==null || prodId.equals("")) {
			throw new NotFoundException("입력값이 부족합니다.");
		}
		
		if(CartService.checkCart(customerId, prodId) == 0) {
			CartService.insert(customerId, prodId);
		}

		ModelAndView mv = new ModelAndView(true, "javaChip?command=selectCart");
		
		return mv;
	}

}
