package controller.cart;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import controller.ModelAndView;
import model.domain.Product;
import model.service.CartService;

public class DeleteCartController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String prodId = request.getParameter("prodId");
		String customerId = (String) request.getSession().getAttribute("userId");
		
		List<String> prodIdList = new ArrayList<>();;
		prodIdList.add(prodId);
		
		//데이터 확인
		for(String prod:prodIdList) {
			System.out.println(prod);
		}
		System.out.println("userId : "+customerId);
		CartService.delete(customerId, prodIdList);
		
		ModelAndView mv = new ModelAndView();
		mv.setRedirect(true);
		mv.setViewName("javaChip?command=selectCart");
		return mv;
	}

}
