package users.user;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import users.command.UserException;

public class UserDAO {

	// Single Pattern 
	private static UserDAO instance;
	
	// DB 연결시  관한 변수 
	private static final String 	dbDriver	=	"oracle.jdbc.driver.OracleDriver";
	private static final String		dbUrl		=	"jdbc:oracle:thin:@127.0.0.1:1521:xe";
	private static final String		dbUser		=	"SCOTT";
	private static final String		dbPass		=	"TIGER";
	
	
	private Connection	 		con;	
	
	//--------------------------------------------
	//#####	 객체 생성하는 메소드 
	public static UserDAO getInstance(){
		if( instance == null ){
			instance = new UserDAO();
		}
		return instance;
	}
	
	private UserDAO()
	{
		try {
			Class.forName( dbDriver );	
		}catch( Exception ex ){
			
		}
		
	}
	
	public int login(UserDTO rec) throws UserException {
		PreparedStatement ps = null;
		ResultSet rs = null;
		try{

			con	= DriverManager.getConnection( dbUrl, dbUser, dbPass );
			
			String sql = "SELECT * FROM USERS WHERE USERID=?";  

			ps = con.prepareStatement( sql );
			
			ps.setString(1, rec.getUserID());
			
			rs = ps.executeQuery();
			
			if(rs.next()) {
				if(rs.getString("userPassword").equals(rec.getUserPassword())) {
					return 1;//성공
				}
				return 2;//비밀번호 틀릭
			}else {
				return 0;//사용자 존재하지 않음
			}
					
		}catch( Exception ex ){
			throw new UserException("방명록 ) DB에 입력시 오류  : " + ex.toString() );
		} finally{
			if( ps   != null ) { try{ ps.close();  } catch(SQLException ex){} }
			if( con  != null ) { try{ con.close(); } catch(SQLException ex){} }
		}
	}
	
	public int registerCheck(String userID) throws UserException {
		PreparedStatement ps = null;
		ResultSet rs = null;
		try{

			con	= DriverManager.getConnection( dbUrl, dbUser, dbPass );
			
			String sql = "SELECT * FROM USERS WHERE USERID=?";  

			ps = con.prepareStatement( sql );
			
			ps.setString(1, userID);
			
			rs = ps.executeQuery();
			
			if(rs.next()||userID.equals("")) {
				return 0;// 이미 존재하는 회원
			}else {
				return 1;// 가입 가능
			}
					
		}catch( Exception ex ){
			throw new UserException("방명록 ) DB에 입력시 오류  : " + ex.toString() );
		} finally{
			if( ps   != null ) { try{ ps.close();  } catch(SQLException ex){} }
			if( con  != null ) { try{ con.close(); } catch(SQLException ex){} }
		}
	}
	
	public int register(UserDTO rec) throws UserException {

		PreparedStatement ps = null;
		try{

			con	= DriverManager.getConnection( dbUrl, dbUser, dbPass );
			
			String sql		= "INSERT INTO USERS VALUES(?,?,?,?,?,?,?)";  

			ps		= con.prepareStatement( sql );
			
			ps.setString( 1, rec.getUserID()	);
			ps.setString( 2, rec.getUserPassword());
			ps.setString( 3, rec.getUserName()	);
			ps.setInt( 4, rec.getUserAge()	);
			ps.setString( 5, rec.getUserGender());
			ps.setString( 6, rec.getUserEmail() );
			ps.setString( 7, rec.getUserProfile());
			
			return ps.executeUpdate();
					
		}catch( Exception ex ){
			throw new UserException("방명록 ) DB에 입력시 오류  : " + ex.toString() );
		} finally{
			if( ps   != null ) { try{ ps.close();  } catch(SQLException ex){} }
			if( con  != null ) { try{ con.close(); } catch(SQLException ex){} }
		}
	}
	
	public boolean isDuplicatedId( String id ) throws UserException{
		boolean flag = false;
		try{
			Connection con = DriverManager.getConnection(dbUrl,dbUser,dbPass);
			String sql = "SELECT * FROM users WHERE userID=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, id);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				flag = true;
			}
		}catch( Exception ex ){
			throw new UserException("중복아이디 검사시 오류  : " + ex.toString() );			
		}
		return flag;
	}
	
	
	//===========================================================================
	/*
	 * 메세지를 입력하는 함수
	 */
	public int insert(UserDTO rec) throws UserException {

		PreparedStatement ps = null;
		try {
			con	= DriverManager.getConnection( dbUrl, dbUser, dbPass );
			String sql = "INSERT INTO USERS VALUES(?,?,?,?,?,?,?)";  
			ps		= con.prepareStatement( sql );
			ps.setString	( 1, rec.getUserID()	);
			ps.setString	( 2, rec.getUserPassword());
			ps.setString	( 3, rec.getUserName()	);
			ps.setInt		( 4, rec.getUserAge()	);
			ps.setString	( 5, rec.getUserGender());
			ps.setString	( 6, rec.getUserEmail() );
			ps.setString	( 7, rec.getUserProfile());
			
			return ps.executeUpdate();
					
		}catch( Exception ex ){
			throw new UserException("방명록 ) DB에 입력시 오류  : " + ex.toString() );
		} finally{
			if( ps   != null ) { try{ ps.close();  } catch(SQLException ex){} }
			if( con  != null ) { try{ con.close(); } catch(SQLException ex){} }
		}
	
	}
	
	/*
	 * 메세지 목록 전체를 얻어올 때
	 */
	public List<UserDTO> selectList() throws UserException
	{
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<UserDTO> mList = new ArrayList<UserDTO>();
		boolean isEmpty = true;
		
		try {

			con	= DriverManager.getConnection( dbUrl, dbUser, dbPass );
			String sql		= "SELECT * FROM users order by userid desc";  
			ps		= con.prepareStatement( sql );
			rs = ps.executeQuery();
			while( rs.next())
			{
				isEmpty = false;
				
				String USERID = rs.getString("USERID");
				String USERPASSWORD = rs.getString("USERPASSWORD");
				String USERNAME = rs.getString("USERNAME");
				int USERAGE = rs.getInt("USERAGE");
				String USERGENDER = rs.getString("USERGENDER");
				String USEREMAIL = rs.getString("USEREMAIL");
				String USERPROFILE = rs.getString("USERPROFILE");
				
				UserDTO dto = new UserDTO(USERID, USERPASSWORD, USERNAME, USERAGE, USERGENDER, USEREMAIL ,USERPROFILE);
				mList.add(dto);
			}
			
			if( isEmpty ) return Collections.emptyList();
			
			return mList;
		}catch( Exception ex ){
			throw new UserException("방명록 ) DB에 입력시 오류  : " + ex.toString() );
		} finally{
			if( rs   != null ) { try{ rs.close();  } catch(SQLException ex){} }
			if( ps   != null ) { try{ ps.close();  } catch(SQLException ex){} }
			if( con  != null ) { try{ con.close(); } catch(SQLException ex){} }
		}		
	}
	

	/* -------------------------------------------------------
	 * 현재 페이지에 보여울 메세지 목록  얻어올 때
	 */
//	public List<UserDTO> selectList(int firstRow, int endRow)
//	{
//		PreparedStatement ps = null;
//		ResultSet rs = null;
//		List<UserDTO> mList = new ArrayList<UserDTO>();
//		boolean isEmpty = true;
//		
//		try{
//
//			con	= DriverManager.getConnection( dbUrl, dbUser, dbPass );
//			String sql		= "SELECT * FROM guestTB	"
//								+ "WHERE message_id IN "
//								+ "	( SELECT message_id FROM ( SELECT message_id, rownum AS rnum "
//								+ "	  FROM ( SELECT message_id FROM guestTB  ORDER BY message_id DESC ) ) "
//								+ "	  WHERE rnum >= ? AND rnum <= ? ) "
//								+ " ORDER BY message_id DESC";  
//			ps		= con.prepareStatement( sql );
//			ps.setInt(1, firstRow);
//			ps.setInt(2, endRow );
//			rs = ps.executeQuery();
//			while( rs.next())
//			{
//				isEmpty = false;
//				
//				int message_id = rs.getInt("message_id");
//				String guest_name = rs.getString("guest_name");
//				String password = rs.getString("password");
//				String message = rs.getString("message");
//				
//				UserDTO m = new UserDTO(message_id, guest_name, password, message );
//				mList.add(m);
//			}
//			
//			if( isEmpty ) return Collections.emptyList();
//			
//			return mList;
//		}catch( Exception ex ){
//		} finally{
//			if( rs   != null ) { try{ rs.close();  } catch(SQLException ex){} }
//			if( ps   != null ) { try{ ps.close();  } catch(SQLException ex){} }
//			if( con  != null ) { try{ con.close(); } catch(SQLException ex){} }
//		}		
//	}
	
	
	
	/* -------------------------------------------------------
	 * 메세지 전체 레코드 수를 검색
	 */
	
//	public int getTotalCount() throws MessageException{
//		PreparedStatement ps = null;
//		ResultSet rs = null;
//		
//		try{
//			con	= DriverManager.getConnection( dbUrl, dbUser, dbPass );
//			String sql		= "SELECT count(*) FROM guestTB";  
//			ps		= con.prepareStatement( sql );
//			rs = ps.executeQuery();
//			rs.next();		
//			return  rs.getInt(1);
//			
//		}catch( Exception ex ){
//			throw new MessageException("방명록 ) DB에 목록 검색시 오류  : " + ex.toString() );	
//		} finally{
//			if( rs   != null ) { try{ rs.close();  } catch(SQLException ex){} }
//			if( ps   != null ) { try{ ps.close();  } catch(SQLException ex){} }
//			if( con  != null ) { try{ con.close(); } catch(SQLException ex){} }
//		}			
//	}
	
	/*
	 * 메세지 번호와 비밀번호에 의해 메세지 삭제
	 */
//	public int delete( int messageId, String password ) throws UserException 
//	{
//		PreparedStatement ps = null;
//		try{
//
//			con	= DriverManager.getConnection( dbUrl, dbUser, dbPass );
//			
//			String sql		= "DELETE FROM guestTB WHERE message_id=? AND password=?";  
//
//			ps		= con.prepareStatement( sql );
//			
//			ps.setInt	( 1, messageId	);
//			ps.setString	( 2, password	);
//			
//			return ps.executeUpdate();
//					
//		}catch( Exception ex ){
//			throw new UserException("방명록 ) DB에 입력시 오류  : " + ex.toString() );
//		} finally{
//			if( ps   != null ) { try{ ps.close();  } catch(SQLException ex){} }
//			if( con  != null ) { try{ con.close(); } catch(SQLException ex){} }
//		}		
//	}
}

