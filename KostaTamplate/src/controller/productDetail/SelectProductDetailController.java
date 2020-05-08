package controller.productDetail;

import java.util.ArrayList;
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
		String goTo = request.getParameter("goTo");

		if (customerId == null || customerId.equals("") || prodId == null || prodId.equals("")) {
			throw new NotFoundException("인자가 부족합니다.");
		}

		OrderItem item = ProductDetailService.selectProdStartEndDay(customerId, prodId);
		
		List<ProductDetail> list = ProductDetailService.selectAll(prodId);

		ModelAndView mv = new ModelAndView();
		if("mychapter".equals(goTo)) {
			request.setAttribute("startEndDay", item);
			request.setAttribute("prodDetailList", list);
			mv.setViewName("mychapter/mychapter.jsp");
		}
		else {
			String chapter = request.getParameter("chapter");
			List<ProductDetail> detailList = new ArrayList<ProductDetail>();
			for(ProductDetail prodDetail : list) {
				if(prodDetail.getChapter().equals(chapter)) {
					request.setAttribute("prodDetail", prodDetail);
				} else {
					detailList.add(prodDetail);
				}
			}
			request.setAttribute("detailList", detailList);
			mv.setViewName("myvideo/myvideo.jsp");
		}

		return mv;
	}

}
