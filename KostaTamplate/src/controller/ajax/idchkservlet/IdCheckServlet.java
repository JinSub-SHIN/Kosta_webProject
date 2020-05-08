package controller.ajax.idchkservlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.service.CustomerService;

/**
 * Servlet implementation class IdCheckServlet
 */
@WebServlet("/idCheckServlet")
public class IdCheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    @Override
    	protected void service(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("idcheckº≠∫Ì∏¥»£√‚µ ..."); 
    	String id = request.getParameter("id");
		
			try {
			     int result = CustomerService.idCheck(id);
			     PrintWriter out =resp.getWriter();
			     out.print(result);
	    	
			}catch (Exception e) {
				e.printStackTrace();
			}
    	}

}
