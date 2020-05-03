package controller.category;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import controller.ModelAndView;
import exception.AddException;
import model.service.CategoryService;

public class InsertCategoryController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String categoryName = request.getParameter("categoryName");

		if (categoryName == null || categoryName.equals("")) {
			throw new AddException("입력값이 부족합니다");
		}
		
		CategoryService.insert(categoryName);

		ModelAndView mv = new ModelAndView(true, "");

		return mv;
	}

}
