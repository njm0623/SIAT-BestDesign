package users.control;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import users.command.User;
import users.command.UserException;

public class UserControl extends HttpServlet {
	
	private HashMap commandMap;
	private String	jspDir = "";
	private String  error = "error.jsp";
	

    public UserControl() {
        super();       
		initCommand();
	}

	private void initCommand(){
		commandMap = new HashMap();

//		commandMap.put("main-page",	new UserNull("main.jsp") );//DB 안갈 때
//		commandMap.put("list-page",	new UserList("listMessage.jsp") );//DB 갈 때
//		// 나머지도 추가하기		
//		commandMap.put("input-form", new UserNull("insertMessage.jsp") );
//		commandMap.put("input-do",	new UserInput("saveMessage.jsp") );//DB 갈 때
//		commandMap.put("delete-form", new UserNull("deleteMessage.jsp") );
//		commandMap.put("delete-do",	new UserDelete("deleteConfirm.jsp") );//DB 갈 때
		
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}
	

	private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");

		String nextPage = "";
		String cmdKey	= request.getParameter("cmd");
		if( cmdKey == null ){
			cmdKey = "main-page";
		}
		System.out.println(cmdKey);

		
		User cmd = null;

		try{
			
			if( commandMap.containsKey( cmdKey ) ){
				cmd = (User)commandMap.get( cmdKey);
			}else{
				throw new UserException("지정할 명령어가 존재하지 않음");
			}

			nextPage = cmd.execute( request, response  );

		}catch( UserException e ){
			request.setAttribute("javax.servlet.jsp.jspException", e );
			nextPage = error;
			System.out.println("오류 : " + e.getMessage() );
		}

		RequestDispatcher reqDp = getServletContext().getRequestDispatcher( jspDir + nextPage );
		reqDp.forward( request, response );
		
	}

}
