package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.CartDAO;
import model.dao.impl.CartDAOImpl;
import model.domain.Product;

/**
 * Servlet implementation class selectCartServlet
 */
@WebServlet(name = "SelectCartServlet", urlPatterns = { "/selectCart" })
public class selectCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("1111");
		
		//웹 테스트를 위한 서블릿 임시 기능
		String url="errorView/error.jsp";
		CartDAO dao = new CartDAOImpl();
		//List<Product> list = dao.selectAll("id1");
		//--------------------
		//test를 위한 데이터 세팅
		Product prod = new Product("prod1", "상품이름1", 1000, "상품설명1", "lv1", null, null, null, 30);
		List<Product> list = new ArrayList<Product>();
		list.add(prod);
		request.setAttribute("cartList", list);
		String userId = "user1";
		request.setAttribute("userId", userId);
		url = "mycart/cart/myCart.jsp";
		request.getRequestDispatcher(url).forward(request, response);
	}

}
