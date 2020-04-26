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
		String id = request.getParameter("id");//user_id
		//product객체를 리스트 타입으로 가져와야 한다 --> front에서 list형태로 저장해야 함
		Product product = (Product) request.getAttribute("product");
		

		//Product product = new Product(prodId);
		//list.add(product);
		
		//CartService.delete(list);
		//request.setAttribute("list", list);
		ModelAndView mv = new ModelAndView();
		mv.setRedirect(true);
		mv.setViewName("");
		return null;
	}

}
