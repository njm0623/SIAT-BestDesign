package siat.bestdesign.chat.service;

import java.util.List;

import siat.bestdesign.chat.domain.ChatVO;

public interface ChatService {
	
	public List<ChatVO> getAllChat();

	public void insertChat(ChatVO vo);
	
	public String getTen(ChatVO vo);

	public String getID(ChatVO vo);

	public String unReadChat(ChatVO vo);

	public String getBox(ChatVO vo);

}
