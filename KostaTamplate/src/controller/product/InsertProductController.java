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
		
		String id = request.getParameter("model_num");
		String name = request.getParameter("model_name");
		String price = request.getParameter("price");
		String description = request.getParameter("description");
		String level = request.getParameter("level");
		String teacherId = request.getParameter("teacher");
		String categoryId = request.getParameter("cate");
		String validDate = request.getParameter("validDate");
		
		String jicjub = request.getParameter("levelinput");

		if (id == null || id.equals("") || name == null || name.equals("") || price == null || price.equals("")
				|| description == null || description.equals("") || level == null || level.equals("")
				|| teacherId == null || teacherId.equals("") || categoryId == null || categoryId.equals("")
				|| validDate == null || validDate.equals("")) {

			throw new NotFoundException("입력값이 충분하지 않습니다..");
		}
		
		if(level.equals("직접입력")) {
			
			level = jicjub;
		}
				
		String[] categoryArray = categoryId.split("-");
		System.out.println(categoryArray[0] + " : " + categoryArray[1]);
				
		Category category = new Category();
		category.setId(Integer.parseInt(categoryArray[0]));
		category.setName(categoryArray[1]);
		
		String[] teacherArray = teacherId.split("-");
		
		Teacher teacher = new Teacher();
		teacher.setId(teacherArray[0]);

		Product product = new Product(id, name, Integer.parseInt(price), description, level, teacher, category, null,
				Integer.parseInt(validDate));

		ProductService.insert(product);
		ModelAndView mv = new ModelAndView(true, "Admin/insertOk.jsp");
		return mv;
		
	}
}
