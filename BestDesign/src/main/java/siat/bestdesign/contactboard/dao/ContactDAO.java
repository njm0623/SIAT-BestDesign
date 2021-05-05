package siat.bestdesign.contactboard.dao;

import java.util.HashMap;
import java.util.List;

import siat.bestdesign.contactboard.domain.ContactVO;

public interface ContactDAO {

	List<ContactVO> getContactBoardList(HashMap map);

	void insertContact(ContactVO vo);

	int getGroupId();
	
	int getTotalCount(HashMap map);

	ContactVO selectById(int contactNum);

	void updateCount(int contactNum);

	String selectLastSequenceNumber(String max, String min);

	void boardModify(ContactVO vo);

	void boardDelete(int contactNum);
}
