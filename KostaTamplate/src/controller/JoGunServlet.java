package controller;


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.ProductDAO;
import model.dao.impl.ProductDAOImpl;
import model.domain.Category;
import model.domain.GangiMokRok;
import model.domain.Product;
import model.domain.Teacher;
import net.sf.json.JSONArray;

@WebServlet("/jogun")
public class JoGunServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String value = request.getParameter("value");
		String value2 = request.getParameter("value2");
		
		ProductDAO productdao = new ProductDAOImpl();
		List<GangiMokRok> list = null;
		List<GangiMokRok> reallist = new ArrayList<GangiMokRok>();
		
		try {
			list = productdao.GangiMokRokAll();
			
		} catch (SQLException e) {			
			e.printStackTrace();
		}
		
			if(value2 == null) {
			
				for(GangiMokRok g : list) {				
					if( (g.getCategory().getName()).equals(value)) {
						
						Product pro = g.getProduct();
						pro.setUploadDateConvert(pro.getUploadDate().toString());
						pro.setUploadDate(null);					
						reallist.add(g);
					}			
				}		
			} else {
			
				for(GangiMokRok g : list) {					
					
					if( g.getCategory().getName().equals(value) && g.getProduct().getTeacher().getName().equals(value2)) {
						
						Product pro = g.getProduct();
						pro.setUploadDateConvert(pro.getUploadDate().toString());
						pro.setUploadDate(null);					
						reallist.add(g);
					}					
				}				
			}
		
		System.out.println("reallist : " + reallist);
        
        JSONArray jsonArr = JSONArray.fromObject(reallist);
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println(jsonArr);
		
	}

}
