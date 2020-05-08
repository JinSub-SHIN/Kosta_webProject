package controller.admin;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import controller.Controller;
import controller.ModelAndView;
import model.domain.Category;
import model.domain.Product;
import model.domain.Teacher;
import model.service.CategoryService;
import model.service.ProductService;
import model.service.TeacherService;

public class InPutDataController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("어드민인풋컨트롤러 호출됨...");	 	
		
		// 레벨 Number 로 바꾸기?
		
		List<Teacher> tlist = TeacherService.selectAll();
		List<Category> clist = CategoryService.selectAll();
		List<Product> plist = ProductService.selectAll();
		Set<String> set = new HashSet<String>();
		
		for(Product p : plist) {
			
			set.add(p.getLevel());
		}
		
		List<String> list = new ArrayList<String>(set);
		Collections.sort(list);
		
		request.setAttribute("tlist", tlist);
		request.setAttribute("clist", clist);
		request.setAttribute("list", list);
		
		ModelAndView mv = new ModelAndView();		
		mv.setViewName("Admin/write.jsp");	
		
		return mv;
	}

}
