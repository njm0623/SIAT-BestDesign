package chat.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import users.command.UserException;

public class ChatDAO {

	// Single Pattern 
	private static ChatDAO instance;
	
	// DB 연결시  관한 변수 
	private static final String 	dbDriver	=	"oracle.jdbc.driver.OracleDriver";
	private static final String		dbUrl		=	"jdbc:oracle:thin:@127.0.0.1:1521:xe";
	private static final String		dbUser		=	"SCOTT";
	private static final String		dbPass		=	"TIGER";
	
	
	private Connection	 		con;	
	
	//--------------------------------------------
	//#####	 객체 생성하는 메소드 
	public static ChatDAO getInstance(){
		if( instance == null ){
			instance = new ChatDAO();
		}
		return instance;
	}
	
	private ChatDAO()
	{
		try {
			Class.forName( dbDriver );	
		}catch( Exception ex ){
			
		}
		
	}
	
	public ArrayList<Chat> getChatListByID(Chat chat) throws ChatException{
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<Chat> cList= null;
		try {
			con	= DriverManager.getConnection( dbUrl, dbUser, dbPass );
			String sql = "SELECT * FROM chat WHERE ((fromID = ? and toID = ?) or (fromID = ? and toID = ?)) and chatID > ? order by chatTime";  
			ps = con.prepareStatement( sql );
			ps.setString(1, chat.getFromID());
			ps.setString(2, chat.getToID());
			ps.setString(3, chat.getToID());
			ps.setString(4, chat.getFromID());
			ps.setInt(5,chat.getChatID());
			rs = ps.executeQuery();
			cList = new ArrayList<Chat>();
			while(rs.next()) {
				Chat c = new Chat();
				c.setChatID(rs.getInt("chatID"));
				c.setFromID(rs.getString("fromID").replaceAll(" " , "&nbsp;").replaceAll("<", "&lt").replaceAll(">" , "&gt;").replaceAll("\n" , "<br>"));
				c.setToID(rs.getString("toID").replaceAll(" " , "&nbsp;").replaceAll("<", "&lt").replaceAll(">" , "&gt;").replaceAll("\n" , "<br>"));
				c.setChatContent(rs.getString("chatContent").replaceAll(" " , "&nbsp;").replaceAll("<", "&lt").replaceAll(">" , "&gt;").replaceAll("\n" , "<br>"));
				int chatTime = Integer.parseInt(rs.getString("chatTime").substring(11,13));
				String timeType = "오전";
				if(chatTime >= 12) {
					timeType = "오후";
					chatTime -= 12;
				}
				c.setChatTime(rs.getString("chatTime").substring(0,11) + " " + timeType + " " + chatTime + " : " + rs.getString("chatTime").substring(14, 16) + " ");
				cList.add(c);
			}
			return cList;
					
		}catch( Exception ex ){
			throw new ChatException("방명록 ) DB에 입력시 오류  : " + ex.toString() );
		} finally{
			if( ps   != null ) { try{ ps.close();  } catch(SQLException ex){} }
			if( con  != null ) { try{ con.close(); } catch(SQLException ex){} }
		}
	}
	
	
	public ArrayList<Chat> getChatListByRecent(Chat chat, int num) throws ChatException{//대화 내역 최근 것 만
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<Chat> cList= null;
		try {
			con	= DriverManager.getConnection( dbUrl, dbUser, dbPass );
			String sql = "SELECT * FROM chat WHERE ((fromID = ? and toID = ?) or (fromID = ? and toID = ?)) and chatID > (select max(chatID) - ? from chat) order by chatTime"; 
			ps = con.prepareStatement( sql );
			ps.setString(1, chat.getFromID());
			ps.setString(2, chat.getToID());
			ps.setString(3, chat.getToID());
			ps.setString(4, chat.getFromID());
			ps.setInt(5, num);
			rs = ps.executeQuery();
			cList = new ArrayList<Chat>();
			while(rs.next()) {
				Chat c = new Chat();
				c.setChatID(rs.getInt("chatID"));
				c.setFromID(rs.getString("fromID").replaceAll(" " , "&nbsp;").replaceAll("<", "&lt").replaceAll(">" , "&gt;").replaceAll("\n" , "<br>"));
				c.setToID(rs.getString("toID").replaceAll(" " , "&nbsp;").replaceAll("<", "&lt").replaceAll(">" , "&gt;").replaceAll("\n" , "<br>"));
				c.setChatContent(rs.getString("chatContent").replaceAll(" " , "&nbsp;").replaceAll("<", "&lt").replaceAll(">" , "&gt;").replaceAll("\n" , "<br>"));
				int chatTime = Integer.parseInt(rs.getString("chatTime").substring(11,13));
				String timeType = "오전";
				if(chatTime >= 12) {
					timeType = "오후";
					chatTime -= 12;
				}
				c.setChatTime(rs.getString("chatTime").substring(0,11) + " " + timeType + " " + chatTime + " : " + rs.getString("chatTime").substring(14, 16) + " ");
				cList.add(c);
			}
			return cList;
			
		}catch( Exception ex ){
			throw new ChatException("방명록 ) DB에 입력시 오류  : " + ex.toString() );
		} finally{
			if( ps   != null ) { try{ ps.close();  } catch(SQLException ex){} }
			if( con  != null ) { try{ con.close(); } catch(SQLException ex){} }
		}
	}
	
	public int submit(Chat chat) throws ChatException{//대화 내역 최근 것 만
		PreparedStatement ps = null;
		try {
			con	= DriverManager.getConnection( dbUrl, dbUser, dbPass );
			String sql = "INSERT INTO chat values(seq_chatID.nextval, ?, ? ,? , sysdate)"; 
			ps = con.prepareStatement( sql );
			ps.setString(1, chat.getFromID());
			ps.setString(2, chat.getToID());
			ps.setString(3, chat.getChatContent());
			return ps.executeUpdate();
			
		}catch( Exception ex ){
			throw new ChatException("방명록 ) DB에 입력시 오류  : " + ex.toString() );
		} finally{
			if( ps   != null ) { try{ ps.close();  } catch(SQLException ex){} }
			if( con  != null ) { try{ con.close(); } catch(SQLException ex){} }
		}
	}
	
	public String getTen(Chat chat) throws ChatException {
		StringBuffer result = new StringBuffer("");
		result.append("{\"result\":[");
		ChatDAO dao = ChatDAO.getInstance();
		ArrayList<Chat> cList = dao.getChatListByRecent(chat, 10);
		if(cList.size() == 0) {
			return "";
		}
		for(int i = 0; i < cList.size(); i++) {
			result.append("[{\"value\": \"" + cList.get(i).getFromID() + "\"},");
			result.append("{\"value\": \"" + cList.get(i).getToID() + "\"},");
			result.append("{\"value\": \"" + cList.get(i).getChatContent() + "\"},");
			result.append("{\"value\": \"" + cList.get(i).getChatTime() + "\"}]");
			if(i != cList.size() -1) {
				result.append(",");
			}
		}
		result.append("], \"last\":\""+cList.get(cList.size()-1).getChatID()+"\"}");
		return result.toString();
	}
	public String getID(Chat chat) throws ChatException {
		StringBuffer result = new StringBuffer("");
		result.append("{\"result\":[");
		ChatDAO dao = ChatDAO.getInstance();
		ArrayList<Chat> cList = dao.getChatListByID(chat);
		if(cList.size() == 0) {
			return "";
		}
		for(int i = 0; i < cList.size(); i++) {
			result.append("[{\"value\": \"" + cList.get(i).getFromID() + "\"},");
			result.append("{\"value\": \"" + cList.get(i).getToID() + "\"},");
			result.append("{\"value\": \"" + cList.get(i).getChatContent() + "\"},");
			result.append("{\"value\": \"" + cList.get(i).getChatTime() + "\"}]");
			if(i != cList.size() -1) {
				result.append(",");
			}
		}
		result.append("], \"last\":\""+cList.get(cList.size()-1).getChatID()+"\"}");
		return result.toString();
	}
}
