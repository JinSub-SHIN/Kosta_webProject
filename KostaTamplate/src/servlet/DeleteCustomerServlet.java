package servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.PersonDAO;
import model.dao.impl.PersonDAOImpl;
import model.domain.Person;


/**
 * Servlet implementation class DeleteCustomerServlet
 */
@WebServlet("/deleteUser")
public class DeleteCustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		PersonDAO dao = new PersonDAOImpl();
		
		response.sendRedirect("selectUser");
	}

}
