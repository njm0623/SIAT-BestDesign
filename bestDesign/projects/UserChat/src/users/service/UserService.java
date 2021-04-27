package users.service;

import java.util.*;

import users.session.UserRepository;
import users.user.UserDTO;

public class UserService {

	private static UserService service;
	
	private UserService() {}
	public static UserService getInstance(){
		if( service == null) service = new UserService();
		return service;
	}
	private UserRepository repo = new UserRepository();//세션 클래스

	public List<UserDTO> selectUser(){
		return repo.selectUser();	
	}
	public UserDTO selectUserByPrimaryKey(long userId){
		return repo.selectUserByPrimaryKey(userId);	
	}
	
	public void insertUser(UserDTO user) {
		repo.insertUser(user);
	}
	
//	public void updateUser(User User) {
//		repo.updateUser(User);
//	}
//	
//	public void deleteUser(int UserNo) {
//		repo.deleteUser(UserNo);
//	}

}