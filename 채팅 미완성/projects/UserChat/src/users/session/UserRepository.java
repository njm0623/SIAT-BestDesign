package users.session;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import users.user.UserDTO;

public class UserRepository {
	private SqlSessionFactory getSqlSessionFactory() {		
		InputStream inputStream;
		try {
			inputStream = Resources.getResourceAsStream("mybatis-config.xml");//연동 6단계를 읽어 관리
		} catch (IOException e) {
			throw new IllegalArgumentException(e);
		}
		SqlSessionFactory sessFactory =  new SqlSessionFactoryBuilder().build(inputStream);
		return sessFactory;
	}
	/*
	JDBC의 Connection = Mybatis의 SqlSeesion 
	*/
	
	public List<UserDTO> selectUser() {
		SqlSession sqlSess = getSqlSessionFactory().openSession();//연결 객체 얻어 오기
		try {
			return sqlSess.selectList("UserMapper.selectUser");//전송 후 select 값 반환, List<Comment> 형식
		}finally {
			sqlSess.close();//닫는 동작이 아닌 반환 동작
		}
	}
	public UserDTO selectUserByPrimaryKey(long userId) {
		SqlSession sqlSess = getSqlSessionFactory().openSession();//연결 객체 얻어 오기
		try {
			return sqlSess.selectOne("UserMapper.selectUserByPrimaryKey",userId);//전송 후 select 값 반환
		}finally {
			sqlSess.close();//닫는 동작이 아닌 반환 동작
		}
	}
	public void insertUser(UserDTO user) {
		SqlSession sqlSess = getSqlSessionFactory().openSession(true);//연결 객체 얻어 오기
		try {
			int result = sqlSess.insert("UserMapper.insertUser",user);
			if(result == 1){
				sqlSess.commit();
			}
		}finally {
			sqlSess.close();//닫는 동작이 아닌 반환 동작
		}		
	}
//	public void updateComment(UserDTO comment) {
//		SqlSession sqlSess = getSqlSessionFactory().openSession(true);//연결 객체 얻어 오기
//		try {
//			sqlSess.update("UserMapper.updateUser", comment);
//		}finally {
//			sqlSess.close();
//		}
//	}
//	public void deleteComment(int commentNo) {
//		SqlSession sqlSess = getSqlSessionFactory().openSession(true);//연결 객체 얻어 오기
//		try {
//			sqlSess.update("UserMapper.deleteUser", commentNo);
//		}finally {
//			sqlSess.close();
//		}
//		
//	}
}