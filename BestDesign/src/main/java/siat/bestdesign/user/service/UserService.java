package siat.bestdesign.user.service;

import java.util.Map;


import siat.bestdesign.user.domain.UserVO;

public interface UserService {

	UserVO mapToUser(Map<String, Object> map);

	void insertUser(UserVO vo);

	UserVO selectLogin(UserVO vo);

	int checkId(UserVO vo);

	int checkType(UserVO vo);

	//ȸ�� ��������
	int userUpdate(UserVO vo);
	
	//ȸ�� ����
	void withdrawal(UserVO vo);



}
