package controller.estimate;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.Controller;
import controller.ModelAndView;
import model.dao.OrderLineDAO;
import model.dao.impl.OrderLineDAOImpl;
import model.domain.EstimateBoard;
import model.domain.OrderItem;
import model.service.EstimateService;

public class SelectAllEstController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		String userId = (String) request.getSession().getAttribute("userId");
		
		if(userId!=null) {
			OrderLineDAO dao = new OrderLineDAOImpl();
			List<OrderItem> itemList = dao.selectByCustomerId(userId);
			if(itemList!=null) session.setAttribute("itemList", itemList); //id에 해당하는 구매내역이 있다면 세션에 저장
		}
		
		List<EstimateBoard> estimateList = EstimateService.selectAll();
		request.setAttribute("estimateList", estimateList);
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("community/evaluation.jsp");
		return mv;
	}

}
