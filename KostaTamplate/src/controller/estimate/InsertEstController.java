package controller.estimate;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import controller.ModelAndView;
import exception.NotFoundException;
import model.domain.Customer;
import model.domain.EstimateBoard;
import model.domain.Product;
import model.service.EstimateService;

public class InsertEstController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String content = request.getParameter("content");
		String customerId = (String) request.getSession().getAttribute("userId");//id는 세션에서 가져오는 것으로 수정
		String prodId = request.getParameter("prodId");
		String grade = request.getParameter("grade");
		System.out.println(customerId);
		if (content == null || content.equals("") || customerId == null || customerId.equals("") || prodId == null
				|| prodId.equals("") || grade == null || grade.equals("")) {
			throw new NotFoundException("인자값이 부족합니다.");
		}

		Customer customer = new Customer();
		customer.setId(customerId);

		Product product = new Product();
		product.setId(prodId);

		EstimateBoard estBoard = new EstimateBoard(content, customer, product, Integer.parseInt(grade));
		EstimateService.insert(estBoard);
		ModelAndView mv = new ModelAndView(true, "javaChip?command=selectAllEst");
		return mv;
	}

}
