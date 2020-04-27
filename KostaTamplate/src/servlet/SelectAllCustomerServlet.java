package servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.org.apache.bcel.internal.generic.NEWARRAY;

import controller.ModelAndView;
import model.dao.CustomerDAO;
import model.dao.impl.CustomerDAOImpl;
import model.domain.Customer;
import model.domain.Product;
import model.service.CustomerService;

/**
 * Servlet implementation class selectAllCustomerServlet
 */
@WebServlet(name = "SelectAllCustomerServlet", urlPatterns = { "/selectUser" }, loadOnStartup = 1)
public class SelectAllCustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		CustomerDAO dao = new CustomerDAOImpl();
		//list = CustomerService.selectAll(); nullPoint
		//List<Customer> list = dao.selectAll();
		Customer customer = new Customer("id1", "p1", "이름1", "011-123-456", "여자", 1, 20, null, null, null, new Date());
		List<Customer> list = new ArrayList<Customer>();
		list.add(customer);
		list.add(new Customer("id2", "p2", "이름2", "011-123-456", "남자", 4, 30, null, null, null, new Date()));
		request.setAttribute("list", list); 
		 
 		request.getRequestDispatcher("user/user.jsp").forward(request, response);
 		 
 		
		 
 		
	}

}
