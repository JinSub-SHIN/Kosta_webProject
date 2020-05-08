package controller.qna;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import controller.ModelAndView;
import model.dao.impl.OrderLineDAOImpl;
import model.dao.impl.PersonDAOImpl;
import model.domain.OrderItem;
import model.domain.Person;
import model.domain.QnABoard;

import model.service.QnAService;

public class SelectAllQnAController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String userId = (String) request.getSession().getAttribute("userId");

		// userId로 person의 status를 세션에 저장
		if (userId != null) {
			Person person = new PersonDAOImpl().selectById(userId);
			int userStatus = person.getStatus();
			request.getSession().setAttribute("userStatus", userStatus);

			if (userStatus == 1) {// customer
				List<OrderItem> itemList = new OrderLineDAOImpl().selectByCustomerId(userId);
				request.getSession().setAttribute("itemList", itemList);
			}
		}
		
		List<QnABoard> list = QnAService.selectAll(); 
		request.setAttribute("QnAList", list);

		ModelAndView mv = new ModelAndView();
		mv.setViewName("community/Q&Aboard.jsp");
		return mv;
	}

}
