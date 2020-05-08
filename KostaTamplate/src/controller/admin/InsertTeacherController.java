package controller.admin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import controller.Controller;
import controller.ModelAndView;
import model.domain.Category;
import model.domain.Teacher;
import model.service.TeacherService;

public class InsertTeacherController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String saveDir = request.getServletContext().getRealPath("/save");
		int maxSize = 1024*1024*100; // 100M
		String encoding="UTF-8";		
		
		MultipartRequest m = new MultipartRequest(request, saveDir, maxSize, encoding, new DefaultFileRenamePolicy());
		
		String id = m.getParameter("Tid");
		String pwd = m.getParameter("Tpwd");
		String name = m.getParameter("Tname");
		String phone = m.getParameter("Tphone");
		String gender = m.getParameter("select");
		String cate = m.getParameter("radios");
		String filename = m.getFilesystemName("fileinput");
		
		String[] array = cate.split("-");
		Category category = new Category(Integer.parseInt(array[0]), array[1]);
		
		Teacher te = new Teacher(id, pwd, name, phone, gender, 2, category, filename);
		
		TeacherService.insert(te);
		
		ModelAndView mv = new ModelAndView();
		mv.setRedirect(true);
		mv.setViewName("Admin/insertOk2.jsp");
		
		return mv;
	}

}
