package controller.qna;

import java.io.NotActiveException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import controller.ModelAndView;
import model.service.QnAService;

public class SelectByKeywordQnAController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String keyField = request.getParameter("keyField");
		String keyword = request.getParameter("keyword");
		
		if(keyField==null||keyField.equals("")||keyword==null||keyword.equals("")) {
			throw new NotActiveException("인자가 부족합니다.");
		}
		
		QnAService.selectByKeyword(keyField, keyword);
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("");
		return mv;
	}

}
