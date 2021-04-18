package users.command;

import java.util.List;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import users.user.UserDAO;
import users.user.UserDTO;

public class UserInput implements User {
	private String next;

	public UserInput( String _next ){
		next = _next;
	}
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response  ) throws UserException {
		try{

			UserDTO msg = new UserDTO();
			msg.setUserID( request.getParameter("USERID"));
			msg.setUserPassword(request.getParameter("USERPASSWORD"));
			msg.setUserName( request.getParameter("USERNAME"));
			msg.setUserAge( Integer.parseInt(request.getParameter("USERAGE")));
			msg.setUserGender( request.getParameter("USERGENDER"));
			msg.setUserEmail( request.getParameter("USEREMAIL"));
			msg.setUserProfile( request.getParameter("USERPROFILE"));
			
			UserDAO.getInstance().insert(msg);
			
		}catch( UserException ex ){
			throw new UserException("UserInput.java < 입력시 > " + ex.toString() ); 
		}
		return next;
	}

}
