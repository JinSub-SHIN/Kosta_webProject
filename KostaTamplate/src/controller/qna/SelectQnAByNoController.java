package controller.qna;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import controller.ModelAndView;
import model.dao.impl.PersonDAOImpl;
import model.domain.Person;
import model.domain.QnABoard;
import model.service.QnAService;

public class SelectQnAByNoController implements Controller{
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String no = request.getParameter("no");//게시판번호
		QnABoard qnaBoard = QnAService.selectByNo(Integer.parseInt(no));
		
		String userId = qnaBoard.getCustomer().getId();//no로 게시판을 작성한 사람의 id가져오기
		Person person = new PersonDAOImpl().selectById(userId);//id로 user의 status 가져오기
		int userStatus = person.getStatus();
		
		request.setAttribute("userStatus", userStatus);//작성자의 status
		request.setAttribute("qnaBoard", qnaBoard);
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("community//qnaDetail.jsp");
		return mv;
	}
}
