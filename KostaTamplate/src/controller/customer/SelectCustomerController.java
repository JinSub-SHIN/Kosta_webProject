package controller.customer;

import java.text.DecimalFormat;
import java.util.List; 
 
 
import javax.servlet.http.HttpServletRequest; 
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.Controller; 
import controller.ModelAndView; 
import model.domain.Customer;
import model.domain.OrderItem;
import model.service.CustomerService;
import model.service.OrderItemService; 


public class SelectCustomerController implements Controller {
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception  { 
			
			System.out.println("selectCustomer »£√‚µ ...");
			
	 		List<Customer> cuslist = CustomerService.selectAll();
	 		int num = OrderItemService.selectAll();
	 		int sevennum = OrderItemService.selectSevenDayAll();
	 		long lo = OrderItemService.selectTotal();
	 		List<OrderItem> orderlist = OrderItemService.selectBySevenitemlist();	 		
	 		
	 		DecimalFormat formatter = new DecimalFormat("###,###");
	 		String total = formatter.format(lo);
	 		System.out.println(total);
	 		
	 		HttpSession session = request.getSession();
	 		session.setAttribute("size", cuslist.size());
	 		session.setAttribute("num", num);
	 		session.setAttribute("seven", sevennum);
	 		session.setAttribute("total", total); 
	 		session.setAttribute("orderlist", orderlist);
	 		
	 		ModelAndView mv = new ModelAndView(); 
	 		mv.setRedirect(true);
	 		mv.setViewName("Admin/index.jsp"); 
			 
	 		return mv; 
	} 


}
