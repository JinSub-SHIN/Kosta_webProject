package controller.productDetail;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import controller.ModelAndView;
import exception.AddException;
import model.domain.Product;
import model.domain.ProductDetail;
import model.domain.Storage;
import model.service.ProductDetailService;

public class InsertProductDetailController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {

		String chapter = request.getParameter("chapter");
		String url = request.getParameter("url");
		String title = request.getParameter("prodTitle");
		String fileId = request.getParameter("fileId");
		String prodId = request.getParameter("prodId");
		if (chapter == null || chapter.equals("") || url == null || url.equals("") || title == null || title.equals("")
				|| fileId == null || fileId.equals("") || prodId == null || prodId.equals("")) {
			new AddException("인자가 부족합니다.");
		}
		
		Storage storage = new Storage();
		storage.setId(fileId);
		
		Product product = new Product();
		product.setId(prodId);
		
		ProductDetail productDetail = new ProductDetail(chapter, url, title, storage, product);
		
		ProductDetailService.insert(productDetail);

		ModelAndView mv = new ModelAndView();
		mv.setRedirect(true);
		mv.setViewName("");
		return mv;

	}

}
