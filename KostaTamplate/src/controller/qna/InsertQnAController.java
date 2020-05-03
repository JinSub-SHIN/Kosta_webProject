package controller.qna;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import controller.ModelAndView;
import exception.AddException;
import model.domain.Customer;
import model.domain.Product;
import model.domain.QnABoard;
import model.service.QnAService;

public class InsertQnAController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String subject = request.getParameter("content");
		//String id = request.getParameter("id");
		String id = (String) request.getSession().getAttribute("userId"); //세션에서 받는 것으로 수정
		String prodId = request.getParameter("prodId");
		String title = request.getParameter("title");
		
		if (subject == null || subject.equals("") || title == null || title.equals("") || prodId == null
				|| prodId.equals("") || id == null || id.equals("")) {
			new AddException("게시글 추가에 필요한 입력값이 부족합니다.");
		}
		
		Customer customer = new Customer();
		customer.setId(id);
		
		Product product = new Product();
		product.setId(prodId);

		QnABoard qaBoard = new QnABoard(subject, customer, product, title);

		QnAService.insert(qaBoard);
		
		ModelAndView mv = new ModelAndView(true, "javaChip?command=selectAllQnA");
		
		return mv;
	}

}
