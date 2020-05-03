package controller.productDetail;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import controller.ModelAndView;
import exception.NotFoundException;
import model.domain.Product;
import model.domain.ProductDetail;
import model.service.ProductDetailService;

public class DeleteProductDetailController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {

		String prodId = request.getParameter("prodId");
		String chapter = request.getParameter("chapter");

		if (prodId == null || prodId.equals("") || chapter == null || chapter.equals("")) {
			throw new NotFoundException("인자가 부족합니다.");
		}

		Product product = new Product();
		product.setId(prodId);

		ProductDetail productDetail = new ProductDetail();
		productDetail.setChapter(chapter);
		productDetail.setProduct(product);

		ProductDetailService.delete(prodId, chapter);

		ModelAndView mv = new ModelAndView();
		mv.setRedirect(true);
		mv.setViewName("");
		return mv;
	}

}
