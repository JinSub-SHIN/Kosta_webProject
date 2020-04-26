//package listener;
//
//import java.util.HashMap;
//import java.util.Map;
//import java.util.ResourceBundle;
//import java.util.Set;
//
//import javax.servlet.ServletContext;
//import javax.servlet.ServletContextEvent;
//import javax.servlet.ServletContextListener;
//import javax.servlet.annotation.WebListener;
//
//import controller.Controller;
//
///**
// * 사용자 요청에 해당하는 key에 따른 객체를 미리 생성해서 
// * Map에 저장한 후 모든 영역에서 사용할 수 있도록 application scope에
// * Map을 저장한다.
// */
//@WebListener
//public class HandlerMappingListener implements ServletContextListener {
//
//    public void contextDestroyed(ServletContextEvent e)  { }
//
//    public void contextInitialized(ServletContextEvent e)  { 
//    	Map<String, Controller> map = new HashMap<String, Controller>();
//    	ServletContext application = e.getServletContext();
//
//    	//key에 해당하는 className을 관리하는 properties문서로딩
//    	String fileName = application.getInitParameter("fileName");
//    	ResourceBundle rb = ResourceBundle.getBundle(fileName);	//ResourceBundle은 확장자를 주지 않는다
//    	Set<String> keys = rb.keySet();
//    	try {
//	    	for(String key : keys) {
//	    		String value = rb.getString(key);
//	    		//System.out.println(key + " = " + value);
//	    		//String value를 객체로(Controller) 만들어서 Map에 저장한다.
//	    		Controller controller = (Controller)Class.forName(value).newInstance();
//	    		System.out.println(key + " = " + controller);	//controller는 주소값이 출력
//	    		map.put(key, controller);
//	    	}
//    	}catch (Exception ex) {
//    		ex.printStackTrace();
//    	}
//    	
//    	//application영역에 저장한다.
//    	application.setAttribute("map", map);
//    }
//	
//}
