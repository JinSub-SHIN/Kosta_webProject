package controller.orderItem;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import controller.ModelAndView;
import model.service.OrderItemService;

public class RefundCustomerController implements Controller {

	@Override 
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String customerId = (String)request.getSession().getAttribute("userId");		
		String orderNo = request.getParameter("orderNo");
		
		OrderItemService.refund(customerId, Integer.parseInt(orderNo));
		
		ModelAndView mv = new ModelAndView(true, "javaChip?command=selectByCusIdOrderLine");
				
		return mv;
	}

}
