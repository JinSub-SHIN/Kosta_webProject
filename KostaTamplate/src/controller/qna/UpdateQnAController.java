package controller.qna;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import controller.ModelAndView;
import exception.NotFoundException;
import model.service.QnAService;

public class UpdateQnAController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String qaBoardNo = request.getParameter("qaBoardNo");
		String content = request.getParameter("content");

		if (qaBoardNo == null || qaBoardNo.equals("") || content == null || content.equals("")) {
			throw new NotFoundException("인자가 부족합니다.");
		}
		
		QnAService.update(Integer.parseInt(qaBoardNo), content);

		ModelAndView mv = new ModelAndView();
		mv.setRedirect(true);
		mv.setViewName("javaChip?command=selectAllQnA");
		
		return mv;
	}

}
