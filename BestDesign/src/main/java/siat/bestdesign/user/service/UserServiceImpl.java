package siat.bestdesign.user.service;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import siat.bestdesign.user.dao.UserDAOImpl;
import siat.bestdesign.user.domain.UserVO;

@Service("userService")
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserDAOImpl userDAO;

	@Override
	public UserVO mapToUser(Map<String, Object> map) {
		UserVO vo = new UserVO((String)map.get("userID"), (String)map.get("userPassword"), (String)map.get("userName"), (String)map.get("userEmail"), (String)map.get("userBirth"), (String)map.get("userPhone"), (int)map.get("userType"));
		return vo;
	}

	@Override
	public void insertUser(UserVO vo) {
		userDAO.insertUser(vo);
		
	}

	@Override
	public UserVO selectLogin(UserVO vo) {
		return userDAO.selectLogin(vo);
	}

	@Override
	public int checkId(UserVO vo) {
		UserVO result = userDAO.selectLogin(vo);
		if(result!=null){
			return 1;//존재
		}else{
			if(vo.getUserId().length()==0){
				return 2;//아이디 먼저 입력해
			}else{
				return 0;//사용 가능
			}
		}
	}

	@Override
	public int checkType(UserVO vo) {
		UserVO result = userDAO.selectLogin(vo);
		if(result!=null){
			if(result.getUserType()!=vo.getUserType()) {
				return 0;
			}else {
				return 1;//존재하니 출력
			}
		}else{
			return 0;
		}
	}


}
