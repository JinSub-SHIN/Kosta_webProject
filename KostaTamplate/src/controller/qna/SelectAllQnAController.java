package controller.qna;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.Controller;
import controller.ModelAndView;
import model.dao.OrderLineDAO;
import model.dao.impl.OrderLineDAOImpl;
import model.domain.OrderItem;
import model.domain.QnABoard;
import model.service.QnAService;

public class SelectAllQnAController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		String userId = (String) request.getSession().getAttribute("userId");
		
		List<QnABoard> list = QnAService.selectAll();
		request.setAttribute("QnAList", list);
		
		OrderLineDAO dao = new OrderLineDAOImpl();
		List<OrderItem> itemList = dao.selectByCustomerId(userId);
		if(itemList!=null) session.setAttribute("itemList", itemList); //id에 해당하는 구매내역이 있다면 세션에 저장
		

		ModelAndView mv = new ModelAndView();
		mv.setViewName("community/Q&Aboard.jsp");
		return mv;
	}

}
