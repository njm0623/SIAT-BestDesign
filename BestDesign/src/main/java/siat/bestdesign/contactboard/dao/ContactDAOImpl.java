package siat.bestdesign.contactboard.dao;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import siat.bestdesign.contactboard.domain.ContactVO;

@Repository("contactDAO")
public class ContactDAOImpl implements ContactDAO{
	
	@Autowired
	private SqlSessionTemplate mybatis;

	@Override
	public List<ContactVO> getContactBoardList(HashMap map) {
		return mybatis.selectList("contactBoard.getContactBoardList",map);
	}

	@Override
	public void insertContact(ContactVO vo) {
		mybatis.insert("contactBoard.insertContact",vo);
		
	}

	@Override
	public int getGroupId() {
		ContactVO vo = mybatis.selectOne("contactBoard.getGroupNum");
		return vo.getContactGroupNum();
	}

	@Override
	public int getTotalCount() {
		return mybatis.selectOne("contactBoard.getTotalCount");
	}

	@Override
	public ContactVO selectById(int contactNum) {
		return mybatis.selectOne("contactBoard.selectById",contactNum);
	}

	@Override
	public void updateCount(int contactNum) {
		mybatis.update("contactBoard.updateCount",contactNum);		
	}

	@Override
	public String selectLastSequenceNumber(String max, String min) {
		HashMap map = new HashMap();
		map.put("max", max);
		map.put("min", min);
		return mybatis.selectOne("contactBoard.selectLastSequenceNumber",map);
	}

}
