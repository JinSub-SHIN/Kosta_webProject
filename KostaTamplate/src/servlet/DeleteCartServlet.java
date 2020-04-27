package servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.CartDAO;
import model.dao.impl.CartDAOImpl;
import model.domain.Cart;
import model.service.CartService;

/**
 * Servlet implementation class DeleteCartServlet
 */
@WebServlet(urlPatterns = "/deleteProduct", loadOnStartup = 1)
public class DeleteCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String customerId = request.getParameter("userId");
		String prodId = request.getParameter("prodId");
		
		List<String> prodIdList = new ArrayList<>();;
		prodIdList.add(prodId);
		
		//데이터 확인
		System.out.print(customerId);
		for(String prod:prodIdList) {
			System.out.println(prod);
		}
		//CartService.delete(customerId, prodIdList);
		response.sendRedirect("selectCart");
	}

}
