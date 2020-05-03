package controller.orderLine;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import controller.ModelAndView;
import exception.NotFoundException;
import model.domain.Customer;
import model.domain.OrderItem;
import model.service.CustomerService;
import model.service.OrderLineService;

public class SelectByCustomerIdOrderLineController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String customerId = (String)request.getSession().getAttribute("userId");	//세션에서 로그인한 회원의 아이디를 받아온다

		if (customerId == null || customerId.equals("")) {
			throw new NotFoundException("입력값이 부족합니다.");
		}
		
		List<OrderItem> orderList = OrderLineService.selectByCustomerId(customerId);
		Customer customer = CustomerService.selectById(customerId);
		
		request.setAttribute("orderList", orderList);
		request.setAttribute("user", customer);

		ModelAndView mv = new ModelAndView();
		mv.setViewName("mypage/mypage.jsp");

		return mv;
	}

}
