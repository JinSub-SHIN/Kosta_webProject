package session;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginPro extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//현재 창의 문서형태 알려주기 & 한글인코딩 설정하기
		response.setContentType("text/html;charset=UTF-8");
		
		String dbId="jang", dbPwd="1234";
		//넘어오는 data 받기
		String userId = request.getParameter("userId");
		String userPwd = request.getParameter("userPwd");
		String userName = request.getParameter("userName");
		
		if(dbId.equals(userId) && dbPwd.equals(userPwd)){		
			//인증된 사용자의 정보를 session에 저장한다.
			HttpSession session = request.getSession();
			session.setAttribute("sessionName", userName);
			session.setAttribute("sessionTime", new Date().toLocaleString());
												//로그인되어지는 그 순간의 시간
			
			//이동하기
			response.sendRedirect("session/LoginOk.jsp");
		}else{
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('"+userName+"님 정보를 확인해주세요.')");
			out.println("history.back()");
			out.println("</script>");
		}
	}
}
