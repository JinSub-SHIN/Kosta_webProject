package controller.orderLine;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import controller.Controller;
import controller.ModelAndView;
import exception.NotLoginExeception;
import model.domain.Customer;
import model.domain.OrderItem;
import model.service.CustomerService;
import model.service.OrderLineService;

public class SelectByCustomerIdOrderLineController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String customerId = (String)request.getSession().getAttribute("userId");	//세션에서 로그인한 회원의 아이디를 받아온다
		 		
		if (customerId == null || customerId.equals("")) {
			throw new NotLoginExeception();
		}
		 
		List<OrderItem> orderList = OrderLineService.selectByCustomerId(customerId);
		Customer customer = CustomerService.selectById(customerId);
		
		for(OrderItem oi : orderList) {
			boolean result = false;
			
			oi.getOrderLine().setCanrefund(result);
		}
		request.setAttribute("user", customer);
		
		List<OrderItem> myLectureList = new ArrayList<OrderItem>();
		for(OrderItem item : orderList) {
			if(item.getIsRefund()==1) {
				myLectureList.add(item);
				
				Date sysdate = new Date();
				Date date = item.getOrderLine().getPayDate();
				Calendar cal = Calendar.getInstance();			
				 
				cal.setTime(date);			
				cal.add(Calendar.DATE, 7); 
				
				//7일이전이면 환불가능..
				boolean result = sysdate.before(cal.getTime());
				
				item.getOrderLine().setCanrefund(result);
			}
		}
		
		request.setAttribute("orderList", orderList);
		request.setAttribute("myLectureList", myLectureList);

		ModelAndView mv = new ModelAndView();
		mv.setViewName("mypage/mypage.jsp");

		return mv;
	}

}
