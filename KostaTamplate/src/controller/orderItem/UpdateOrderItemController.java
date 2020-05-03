package controller.orderItem;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import controller.ModelAndView;
import exception.NotFoundException;
import model.domain.OrderItem;
import model.domain.OrderLine;
import model.domain.Product;
import model.service.OrderItemService;

public class UpdateOrderItemController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		/**
		 * 객체를 리스트에 담아 넘겨받아 처리해야함 수정할 것
		 */
		String itemNo = request.getParameter("itemNo");
		String lineNo = request.getParameter("lineNo");
		String productId = request.getParameter("productId");
		
		if (itemNo == null || itemNo.equals("") || lineNo == null
				|| lineNo.equals("") || productId == null || productId.equals("")) {
			throw new NotFoundException("입력값이 부족합니다.");
		}
		
		OrderLine orderLine = new OrderLine();
		orderLine.setLineNo(Integer.parseInt(lineNo));
		
		Product product = new Product();
		product.setId(productId);

		OrderItem orderItem = new OrderItem(Integer.parseInt(itemNo)
				, new Date(), 1, orderLine, product);

		//OrderItemService.update(orderItem);
		
		ModelAndView mv = new ModelAndView(true, "");
		
		return mv;
	}

}
