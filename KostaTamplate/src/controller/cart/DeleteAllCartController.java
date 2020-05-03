package controller.cart;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import controller.ModelAndView;
import exception.NotFoundException;
import model.service.CartService;

public class DeleteAllCartController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String customerId = request.getParameter("userId");

		if (customerId == null || customerId.equals("")) {
			throw new NotFoundException("입력값이 부족합니다.");
		}

		CartService.deleteAll(customerId);

		ModelAndView mv = new ModelAndView();
		mv.setRedirect(true);
		mv.setViewName("selectCart");
		return mv;
	}

}
