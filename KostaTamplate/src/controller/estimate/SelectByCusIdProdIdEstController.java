package controller.estimate;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import controller.ModelAndView;
import exception.NotFoundException;
import model.dao.impl.OrderLineDAOImpl;
import model.domain.EstimateBoard;
import model.domain.OrderItem;
import model.service.EstimateService;

public class SelectByCusIdProdIdEstController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String customerId = (String) request.getSession().getAttribute("userId");
		
		if (customerId == null || customerId.equals("")) {
			throw new NotFoundException("인자가 부족합니다.");
		}
		//이 컨트롤러에서 하는 일 : userId의 orderProdId 리스트를 구함
		//작성한 강의평 강의id를 구함
		//두개를 비교해서 아직 작성하지 않은 과목id만 setAttr로 전송함
		List<OrderItem> itemList = new OrderLineDAOImpl().selectByCustomerId(customerId);
		if(!itemList.isEmpty()) {
			List<String> prodIdList = new ArrayList<String>(); //구매한 상품의 id 리스트
			for(OrderItem item:itemList) {
				prodIdList.add(item.getProduct().getId());//상품의 id 구하기
			}
			
			//request.getSession().setAttribute("itemList", itemList);필요하면 전송
			List<EstimateBoard> estimateList = EstimateService.selectByCustomerId(customerId);//유저가 작성한 강의평 리스트
			//request.setAttribute("estimateList", estimateList); //필요하면 전송
			List<String> estProdIdList = new ArrayList<String>(); //강의평 등록한 상품 id 리스트
			for(EstimateBoard estBoard:estimateList) {
				estProdIdList.add(estBoard.getProduct().getId());
			}
		
			for(int i=0 ; i<prodIdList.size() ;i++) {
				for(int j=0 ;j<estProdIdList.size() ;j++) {
					if(prodIdList.get(i).equals(estProdIdList.get(j))) {//강의평리스트에 있으면 이미 작성함, 리스트에서 제거
						prodIdList.remove(i);
					}//end if
				}//end for j
			}//end for i
			//request.setAttribute("estPosList", prodIdList);//아직 강의평 작성하지 않은 상품id 리스트
			for(OrderItem item:itemList) {
				for(String prodId :prodIdList) {
					if(!item.getProduct().getId().equals(prodId)) {
						itemList.remove(item);
					}
				}
			}
			request.setAttribute("estPosList", itemList);//아직 강의평 작성하지 않은 상품id 리스트
		}
		ModelAndView mv=new ModelAndView();
		mv.setRedirect(false);
		mv.setViewName("community/evaluateForm.jsp");
		return mv;
	}

}
