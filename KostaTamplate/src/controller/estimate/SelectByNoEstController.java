package controller.estimate;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import controller.ModelAndView;
import model.domain.EstimateBoard;
import model.service.EstimateService;

public class SelectByNoEstController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String no = request.getParameter("no"); //게시글 번호
		System.out.println(no);
		
		EstimateBoard estBoard = EstimateService.selectByNo(Integer.parseInt(no));	
		request.setAttribute("estBoard", estBoard);

		ModelAndView mv = new ModelAndView();
		mv.setViewName("community/estDetail.jsp");
		return mv;
	}

}
