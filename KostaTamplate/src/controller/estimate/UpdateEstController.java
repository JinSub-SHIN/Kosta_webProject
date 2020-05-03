package controller.estimate;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import controller.ModelAndView;
import exception.NotFoundException;
import model.domain.EstimateBoard;
import model.service.EstimateService;
import oracle.net.aso.s;

public class UpdateEstController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String estimateNo = request.getParameter("estimateNo");
		String subject = request.getParameter("subject");
		String grade = request.getParameter("grade");

		if (estimateNo == null || estimateNo.equals("") || subject == null || subject.equals("") || grade == null
				|| grade.equals("")) {
			throw new NotFoundException("인자가 부족합니다.");
		}
		
		EstimateBoard estBoard = new EstimateBoard(Integer.parseInt(estimateNo), subject, Integer.parseInt(grade));

		EstimateService.update(estBoard);

		ModelAndView mv = new ModelAndView(true, "");

		return mv;
	}

}
