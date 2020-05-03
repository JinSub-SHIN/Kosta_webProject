package controller.cart;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import controller.ModelAndView;
import exception.NotFoundException;
import model.domain.Cart;
import model.service.CartService;

public class SelectCartController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("selectCart...");
		String customerId = (String) request.getSession().getAttribute("userId");
		if(customerId==null || customerId.equals("")) {
			throw new NotFoundException("장바구니 조회를 위한 고객 id를 찾을 수 없습니다.");
		}
		List<Cart> list = CartService.selectAll(customerId);
		request.setAttribute("cartList", list);
		
		ModelAndView mv = new ModelAndView();
		mv.setRedirect(false);
		mv.setViewName("mycart/newmycart.jsp");
		return mv;
	}

}
