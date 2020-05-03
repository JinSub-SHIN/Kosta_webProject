package controller.productDetail;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import controller.ModelAndView;
import exception.NotFoundException;
import model.domain.OrderItem;
import model.domain.ProductDetail;
import model.service.ProductDetailService;

public class SelectProductDetailController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String customerId = (String) request.getSession().getAttribute("userId");
		String prodId = request.getParameter("prodId");

		if (customerId == null || customerId.equals("") || prodId == null || prodId.equals("")) {
			throw new NotFoundException("인자가 부족합니다.");
		}

		OrderItem item = ProductDetailService.selectProdStartEndDay(customerId, prodId);
		request.setAttribute("startEndDay", item);
		
		List<ProductDetail> list = ProductDetailService.selectAll(prodId);
		request.setAttribute("prodDetailList", list);

		ModelAndView mv = new ModelAndView();
		mv.setViewName("mychapter/mychapter.jsp");

		return mv;
	}

}
