package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.service.ProductDetailService;

@WebServlet("/ChapterDupCheckServlet")
public class ChapterDupCheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
        
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("√©≈Õ√º≈© º≠∫Ì∏¥ »£√‚µ ...");
		
		String prodId = request.getParameter("id");		
		String chapter = request.getParameter("id2");
		int i = 0;
		
		try {
			i = ProductDetailService.checkChatper(prodId, chapter);
		} catch (SQLException e) {			
			e.printStackTrace();
		}
		
		PrintWriter out = response.getWriter();
		
		if(i==0) {			
			out.print("o");			
		} else {			
			out.print("x");
		}
		
	}

}
