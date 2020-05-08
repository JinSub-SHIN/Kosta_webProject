package controller.qna;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import controller.ModelAndView;
import model.service.QnAService;

public class addViewCountController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String userId = (String) request.getSession().getAttribute("userId");
		String no = request.getParameter("no"); //게시글번호
		
		QnAService.addViewCount(Integer.parseInt(no));
		
		ModelAndView mv = new ModelAndView();
		mv.setRedirect(true);
		mv.setViewName("");
		return mv;
	}

}
