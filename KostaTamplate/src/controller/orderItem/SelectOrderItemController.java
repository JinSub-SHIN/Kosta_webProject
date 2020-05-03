package controller.orderItem;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import controller.ModelAndView;
import exception.NotFoundException;
import model.domain.OrderItem;
import model.service.OrderItemService;

public class SelectOrderItemController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {		
		
		int num = OrderItemService.selectAll();

		request.setAttribute("itemList", num);

		ModelAndView mv = new ModelAndView();
		mv.setViewName("community/writeform.jsp");

		return mv;
	}

}
