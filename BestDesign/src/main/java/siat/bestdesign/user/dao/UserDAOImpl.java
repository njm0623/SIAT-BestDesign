package siat.bestdesign.user.dao;

import javax.xml.stream.events.Namespace;

import org.apache.ibatis.jdbc.SQL;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import siat.bestdesign.designer.domain.DesignerVO;
import siat.bestdesign.user.domain.UserVO;

@Repository("userDAO")
public class UserDAOImpl implements UserDAO{
	
	@Autowired
	private SqlSessionTemplate mybatis;

	public void insertUser(UserVO vo) {
		mybatis.insert("users.userInsert", vo);
		if(vo.getUserType()==2) {
			mybatis.insert("designer.designerInsert", vo);
		}
	}

	@Override
	public UserVO selectLogin(UserVO vo) {
		return mybatis.selectOne("users.userLogin",vo);
	}

	@Override
	public int userUpdate(UserVO vo) {
		return mybatis.update("users.userUpdate",vo);
	}

	@Override
	public void withdrawal(UserVO vo) {
		mybatis.delete("users.withdrawal",vo);
	}


	

}
