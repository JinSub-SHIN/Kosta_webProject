package servlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.domain.Customer;

/**
 * Servlet implementation class SelectCustomerServlet
 */
@WebServlet("/selectByIdCustomer")
public class SelectByIdCustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userId = request.getParameter("userId");
		
		request.setAttribute("customer", new Customer("id1", "p1", "name1", "123-456"
				,"³²ÀÚ", 1, 25, "test@google.com", null, null, new Date())); 
 		
 		request.getRequestDispatcher("user/userDetail.jsp").forward(request, response);
	}

}
