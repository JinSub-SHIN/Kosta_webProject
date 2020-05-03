package controller.qna;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import controller.ModelAndView;
import exception.NotFoundException;
import model.service.QnAService;

public class SelectQnAByIdController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String id = request.getParameter("id");
		if(id==null||id.equals("")) {
			new NotFoundException("인자가부족합니다.");
		}
		QnAService.selectById(id);
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("");
		return mv;
	}

}
