package controller.product;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import controller.ModelAndView;
import exception.NotFoundException;
import model.domain.Category;
import model.domain.Product;
import model.domain.Teacher;
import model.service.ProductService;;

public class InsertProductController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String id = request.getParameter("prodId");
		String name = request.getParameter("prodName");
		String price = request.getParameter("price");
		String description = request.getParameter("description");
		String level = request.getParameter("level");
		String teacherId = request.getParameter("teacherId");
		String categoryId = request.getParameter("categoryId");
		String validDate = request.getParameter("validDate");

		if (id == null || id.equals("") || name == null || name.equals("") || price == null || price.equals("")
				|| description == null || description.equals("") || level == null || level.equals("")
				|| teacherId == null || teacherId.equals("") || categoryId == null || categoryId.equals("")
				|| validDate == null || validDate.equals("")) {

			throw new NotFoundException("입력값이 충분하지 않습니다..");
		}

		Category category = new Category();
		category.setId(Integer.parseInt(categoryId));
		
		Teacher teacher = new Teacher();
		teacher.setId(teacherId);

		Product product = new Product(id, name, Integer.parseInt(price), description, level, teacher, category, null,
				Integer.parseInt(validDate));

		ProductService.insert(product);
		ModelAndView mv = new ModelAndView(true, "");
		return mv;
	}

}
