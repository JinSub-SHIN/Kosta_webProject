package controller.estimate;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import controller.ModelAndView;
import exception.NotFoundException;
import model.domain.EstimateBoard;
import model.service.EstimateService;

public class SelectByCustomerIdEstController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String customerId = request.getParameter("id");

		if (customerId == null || customerId.equals("")) {
			throw new NotFoundException("인자가 부족합니다.");
		}
		List<EstimateBoard> estimateList = EstimateService.selectByCustomerId(customerId);

		request.setAttribute("estimateList", estimateList);

		ModelAndView mv = new ModelAndView();
		mv.setViewName("");

		return mv;
	}

}
