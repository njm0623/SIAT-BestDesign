package siat.bestdesign.chat.dao;

import java.util.ArrayList;
import java.util.List;

import siat.bestdesign.chat.domain.ChatVO;

public interface ChatDAO {
	
	List<ChatVO> getAllChat();
	
	void insertChat(ChatVO vo);
	
	List<ChatVO> getChatListByRecent(ChatVO vo);
	
	List<ChatVO> getChatListByID(ChatVO vo);
	
	void readChat(ChatVO vo);
	
	String unReadChat(ChatVO vo);
	
	List<ChatVO> getBox(ChatVO vo);
}
