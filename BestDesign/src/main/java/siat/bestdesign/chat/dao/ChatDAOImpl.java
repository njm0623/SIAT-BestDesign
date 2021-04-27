package siat.bestdesign.chat.dao;

import java.util.ArrayList;
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


	public void insertChat(ChatVO vo) {
		mybatis.insert("chat.insertChat",vo);
	}


	public List<ChatVO> getChatListByRecent(ChatVO vo) {
		List<ChatVO> cList = mybatis.selectList("chat.getChatListByRecent",vo);
		ArrayList<ChatVO> c = new ArrayList<ChatVO>();
		for(ChatVO cc : cList) {
			ChatVO c2 = new ChatVO();
			c2.setChatId(cc.getChatId());
			c2.setChatFromId(cc.getChatFromId().replaceAll(" " , "&nbsp;").replaceAll("<", "&lt").replaceAll(">" , "&gt;").replaceAll("\n" , "<br>"));
			c2.setChatToId(cc.getChatToId().replaceAll(" " , "&nbsp;").replaceAll("<", "&lt").replaceAll(">" , "&gt;").replaceAll("\n" , "<br>"));
			c2.setChatContent(cc.getChatContent().replaceAll(" " , "&nbsp;").replaceAll("<", "&lt").replaceAll(">" , "&gt;").replaceAll("\n" , "<br>"));
			int chatDate = Integer.parseInt(cc.getChatDate().substring(11,13));
			String timeType = "오전";
			if(chatDate >= 12) {
				timeType = "오후";
				chatDate -= 12;
			}
			c2.setChatDate(cc.getChatDate().substring(0,11) + " " + timeType + " " + chatDate + " : " + cc.getChatDate().substring(14, 16) + " ");
			c.add(c2);
		}
		return c;
	}


	public void readChat(ChatVO vo) {
		mybatis.update("chat.readChat",vo);
		
	}


	public List<ChatVO> getChatListByID(ChatVO vo) {
		List<ChatVO> cList = mybatis.selectList("chat.getChatListByID",vo);
		ArrayList<ChatVO> c = new ArrayList<ChatVO>();
		for(ChatVO cc : cList) {
			ChatVO c2 = new ChatVO();
			c2.setChatId(cc.getChatId());
			c2.setChatFromId(cc.getChatFromId().replaceAll(" " , "&nbsp;").replaceAll("<", "&lt").replaceAll(">" , "&gt;").replaceAll("\n" , "<br>"));
			c2.setChatToId(cc.getChatToId().replaceAll(" " , "&nbsp;").replaceAll("<", "&lt").replaceAll(">" , "&gt;").replaceAll("\n" , "<br>"));
			c2.setChatContent(cc.getChatContent().replaceAll(" " , "&nbsp;").replaceAll("<", "&lt").replaceAll(">" , "&gt;").replaceAll("\n" , "<br>"));
			int chatDate = Integer.parseInt(cc.getChatDate().substring(11,13));
			String timeType = "오전";
			if(chatDate >= 12) {
				timeType = "오후";
				chatDate -= 12;
			}
			c2.setChatDate(cc.getChatDate().substring(0,11) + " " + timeType + " " + chatDate + " : " + cc.getChatDate().substring(14, 16) + " ");
			c.add(c2);
		}
		return c;
	}


	public String unReadChat(ChatVO vo) {
		List<ChatVO> c = mybatis.selectList("chat.unReadChat",vo);
		return Integer.toString(c.size());
	}


	public List<ChatVO> getBox(ChatVO vo) {
		List<ChatVO> cList = mybatis.selectList("chat.getBox",vo);
		ArrayList<ChatVO> c = new ArrayList<ChatVO>();
		for(ChatVO cc : cList) {
			ChatVO c2 = new ChatVO();
			System.out.println(cc.getChatFromId());
			c2.setChatFromId(cc.getChatFromId().replaceAll(" " , "&nbsp;").replaceAll("<", "&lt").replaceAll(">" , "&gt;").replaceAll("\n" , "<br>"));
			c.add(c2);
		}
		return c;
	}

	
}
