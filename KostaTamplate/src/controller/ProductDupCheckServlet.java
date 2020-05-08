package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.domain.Product;
import model.service.ProductService;

@WebServlet("/prodCheck")
public class ProductDupCheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("id");
		
		PrintWriter out = response.getWriter();
		
		try {
			Product product = ProductService.selectById(id);
			if(product == null) {
				// 등록가능
				out.print("o");
			} else {
				out.print("x");				
			}
			
		} catch (SQLException e) {			
			e.printStackTrace();
		}
		
	}

}
