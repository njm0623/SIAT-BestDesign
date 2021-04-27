package siat.bestdesign.chat.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import siat.bestdesign.chat.domain.ChatVO;

@Repository("chatDAO")
public class ChatDAOImpl implements ChatDAO {
	
	@Autowired
	private SqlSessionTemplate mybatis;
	
	
	//Mapper 호출

	
	@Override
	public List<ChatVO> getAllChat() {
		System.out.println("챗겟올");
		return mybatis.selectList("chat.getAllChat");
	}

	
}
