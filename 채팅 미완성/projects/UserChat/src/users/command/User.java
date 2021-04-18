package users.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface User {//인터페이스는 오버라이딩 필수
	public String execute( HttpServletRequest request, HttpServletResponse response  ) throws UserException;
}
