package controller.product;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import controller.ModelAndView;
import exception.NotFoundException;
import model.domain.EstimateBoard;
import model.domain.Product;
import model.domain.ProductDetail;
import model.service.ProductService;

public class SelectProductInfoController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String prodId = request.getParameter("prodId");

		if (prodId == null || prodId.equals("")) {
			throw new NotFoundException("존재하지 않는 상품번호입니다.");
		}
		
		List<Product> sameCateProd = ProductService.selectSameCateProd(prodId);
		request.setAttribute("sameCateProd", sameCateProd);
		
		Map<EstimateBoard, ProductDetail> map = ProductService.selectProdInfo(prodId);

		System.out.println(map + "map");
		List<EstimateBoard> estList = new ArrayList<EstimateBoard>();
		int aveGrade = 0;
		int count = 0;

		for (EstimateBoard key : map.keySet()) {
			request.setAttribute("prodDetail", map.get(key));
			request.setAttribute("salePrice", (int) (map.get(key).getProduct().getPrice() * 1.1));
			aveGrade += key.getGrade();
			if (count < 3) {
				estList.add(key); // 강의평가는 3개만 뿌려준다
			}
			count++;
		}

		request.setAttribute("estimateList", estList);

		if(count != 0) {
			request.setAttribute("aveGrade", aveGrade / count);
			request.setAttribute("whiteStar", 5 - aveGrade / count);
		}

		ModelAndView mv = new ModelAndView();
		mv.setViewName("detail_information/detail.jsp");

		return mv;
	}

}
