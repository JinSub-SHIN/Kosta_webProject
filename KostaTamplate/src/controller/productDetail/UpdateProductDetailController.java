package controller.productDetail;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import controller.ModelAndView;
import exception.AddException;
import exception.NotFoundException;
import model.domain.Product;
import model.domain.ProductDetail;
import model.service.ProductDetailService;

public class UpdateProductDetailController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String chapter = request.getParameter("chapter");
		String fileId = request.getParameter("fileId");
		String prodId = request.getParameter("prodId");

		if (chapter == null || chapter.equals("") || fileId == null || fileId.equals("") || prodId == null
				|| prodId.equals("")) {
			new NotFoundException("인자가 부족합니다.");
		}

		Product product = new Product();
		product.setId(prodId);

		ProductDetail productDetail = new ProductDetail(chapter, null, null, fileId, product);

		ProductDetailService.update(productDetail);

		ModelAndView mv = new ModelAndView();
		mv.setRedirect(true);
		mv.setViewName("");
		return mv;

	}

}
