package siat.bestdesign.chat.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import siat.bestdesign.chat.dao.ChatDAOImpl;
import siat.bestdesign.chat.domain.ChatVO;

@Service("chatService")
public class ChatServiceImpl implements ChatService{

	@Autowired
	private ChatDAOImpl chatDAO;
	
	//DAO 호출
	
	@Override
	public List<ChatVO> getAllChat() {	
		return chatDAO.getAllChat();
	}
	
}
