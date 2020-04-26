package controller.cart;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import controller.ModelAndView;
import exception.AddException;
import model.service.CartService;

public class InsertCartController implements Controller{

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		//insertCart=insert into cart (cart_no, user_id, prod_id) values (cart_seq.nextval, ?, ?)
		
		String userId = request.getParameter("userId");
		String prodId = request.getParameter("prodId");
		
		if(userId==null || userId.equals("") || prodId==null || prodId.equals("")) {
			throw new AddException("장바구니 추가에 필요한 입력값이 부족합니다.");
		}
		CartService.insert(userId, prodId);

		ModelAndView mv = new ModelAndView();
		mv.setRedirect(true); //redirect
		mv.setViewName(""); // 보낼 view page
		return mv;
	}

}
