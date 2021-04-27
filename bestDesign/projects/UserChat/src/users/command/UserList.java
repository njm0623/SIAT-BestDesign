package users.command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import users.user.UserDAO;
import users.user.UserDTO;

public class UserList implements User 
{
	private String next;

	public UserList( String _next ){
		next = _next;
	}

	public String execute( HttpServletRequest request , HttpServletResponse response  ) throws UserException{
		List <UserDTO> mList = UserDAO.getInstance().selectList();	
		request.setAttribute("param", mList );
		
		return next;
	}
}
