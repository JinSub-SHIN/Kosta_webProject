package controller.orderLine;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import controller.ModelAndView;
import exception.NotFoundException;
import model.domain.OrderLine;
import model.service.OrderLineService;

public class SelectByLineNoOrderLineController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String lineNo = request.getParameter("lineNo");

		if (lineNo == null || lineNo.equals("")) {
			throw new NotFoundException("입력값이 부족합니다.");
		}
		
		OrderLine orderLine = OrderLineService.selectByLineNo(Integer.parseInt(lineNo));
		request.setAttribute("orderLine", orderLine);

		ModelAndView mv = new ModelAndView();
		mv.setViewName("");

		return mv;
	}

}
