package controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import exception.NotFoundException;
import exception.NotLoginExeception;

/**
 * View의 모든 요청을 중앙집중적으로 관리하기 위한
 * FrontController의 역할이다.
 * : 요청을 받아 Model(Service-BusinessLogin, DAO)쪽으로 전달하고
 *   그 결과를 받아서 결과뷰로 이동하는 역할.
 */
@WebServlet(urlPatterns="/javaChip", loadOnStartup=1)
public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	Map<String, Controller> map;
    @Override
    	public void init() throws ServletException {
    		ServletContext application = super.getServletContext();
    		map = (Map<String, Controller>)application.getAttribute("map");
    	}
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				
		String key = request.getParameter("command");
		System.out.println("key = " + key);
		
		if(key==null || key.equals("")) key="list"; 
		
		Controller controller = map.get(key);
		
		ModelAndView mv = null;
		
		try {
			mv = controller.handleRequest(request, response);
		}catch (NotLoginExeception e) {
			e.printStackTrace();
			request.setAttribute("errorMsg", e.getMessage());
			request.getRequestDispatcher("Login/login.jsp").forward(request, response);
		}catch (NotFoundException e) {
			e.printStackTrace();
			request.setAttribute("errorMsg", e.getMessage());
			request.getRequestDispatcher("successView/noData.jsp").forward(request, response);
		} catch (Exception e) {			
			e.printStackTrace();
			request.setAttribute("errorMsg", e.getMessage());
			request.getRequestDispatcher("errorView/error.jsp").forward(request, response);
		}
		
		if(mv.isRedirect()) {
			// redirect방식으로 이동한다.
			response.sendRedirect(mv.getViewName());			
		} else {
			// forward 방식
			request.getRequestDispatcher(mv.getViewName()).forward(request, response);
		}
	}

}
