package siat.bestdesign.chat.service;

import java.util.ArrayList;
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

	@Override
	public void insertChat(ChatVO vo) {
		chatDAO.insertChat(vo);
	}

	@Override
	public String getTen(ChatVO vo) {
		StringBuffer result = new StringBuffer("");
		result.append("{\"result\":[");
		vo.setChatId(100);
		List<ChatVO> cList = chatDAO.getChatListByRecent(vo);//동빈나가 바꾸라함
		if(cList.size() == 0) {
			return "";
		}
		for(int i = 0; i < cList.size(); i++) {
			result.append("[{\"value\": \"" + cList.get(i).getChatFromId() + "\"},");
			result.append("{\"value\": \"" + cList.get(i).getChatToId() + "\"},");
			result.append("{\"value\": \"" + cList.get(i).getChatContent() + "\"},");
			result.append("{\"value\": \"" + cList.get(i).getChatDate() + "\"}]");
			if(i != cList.size() -1) {
				result.append(",");
			}
		}
		result.append("], \"last\":\""+cList.get(cList.size()-1).getChatId()+"\"}");
		chatDAO.readChat(vo);//읽음 처리DB
		return result.toString();
	}

	@Override
	public String getID(ChatVO vo) {
		StringBuffer result = new StringBuffer("");
		result.append("{\"result\":[");
		List<ChatVO> cList = chatDAO.getChatListByID(vo);//동빈나가 바꾸라함
		if(cList.size() == 0) {
			return "";
		}
		for(int i = 0; i < cList.size(); i++) {
			result.append("[{\"value\": \"" + cList.get(i).getChatFromId() + "\"},");
			result.append("{\"value\": \"" + cList.get(i).getChatToId() + "\"},");
			result.append("{\"value\": \"" + cList.get(i).getChatContent() + "\"},");
			result.append("{\"value\": \"" + cList.get(i).getChatDate() + "\"}]");
			if(i != cList.size() -1) {
				result.append(",");
			}
		}
		result.append("], \"last\":\""+cList.get(cList.size()-1).getChatId()+"\"}");
		chatDAO.readChat(vo);//읽음 처리DB
		return result.toString();
	}

	@Override
	public String unReadChat(ChatVO vo) {
		return chatDAO.unReadChat(vo);
	}

	@Override
	public String getBox(ChatVO vo) {
		StringBuffer result = new StringBuffer("");
		List<ChatVO> cList = chatDAO.getBox(vo);
		if(cList.size() == 0) {
			return "";
		}
		for(int i = 0; i < cList.size(); i++) {
			result.append(cList.get(i).getChatFromId());
			if(i != cList.size() -1) {
				result.append("|");
			}
		}
		return result.toString();
	}
	
}
