//package users.command;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import user.UserDAO;
//
//public class UserDelete implements User {
//	private String next;
//
//	public UserDelete( String _next ){
//		next = _next;
//	}
//	
//	public String execute(HttpServletRequest request, HttpServletResponse response  ) throws UserException {
//
//		try{
//				
//			int messageId = Integer.parseInt(request.getParameter("messageId"));
//			String password = request.getParameter("password");
//			
//			int resultCnt = UserDAO.getInstance().delete(messageId, password);
//			
//			request.setAttribute("result", resultCnt);
//		}catch( UserException ex ){
//			throw new UserException("CommandDelete.java < 삭제시 > " + ex.toString() ); 
//		}
//		
//		return next;			
//	}
//
//}
