package siat.bestdesign.user.dao;

import siat.bestdesign.user.domain.UserVO;

public interface UserDAO {

	void insertUser(UserVO vo);
	
	UserVO selectLogin(UserVO vo);

	int userUpdate(UserVO vo);

	void withdrawal(UserVO vo);
}
