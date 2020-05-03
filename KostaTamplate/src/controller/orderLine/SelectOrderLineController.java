package controller.orderLine;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import controller.ModelAndView;
import model.domain.OrderLine;
import model.service.OrderLineService;

public class SelectOrderLineController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// 전체 검색
		List<OrderLine> list = OrderLineService.selectAll();

		request.setAttribute("list", list);

		ModelAndView mv = new ModelAndView();
		mv.setViewName("");

		return mv;
	}

}
