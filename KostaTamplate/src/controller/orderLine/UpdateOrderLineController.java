package controller.orderLine;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import controller.ModelAndView;
import exception.NotFoundException;
import model.service.OrderLineService;

public class UpdateOrderLineController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String lineNo = request.getParameter("lineNo");
		String prodId = request.getParameter("prodId");

		if (lineNo == null || lineNo.equals("") || prodId == null || prodId.equals("")) {
			throw new NotFoundException("입력값이 부족합니다.");
		}
		
		OrderLineService.update(Integer.parseInt(lineNo), prodId);

		ModelAndView mv = new ModelAndView(true, "");
		
		return mv;
	}

}
