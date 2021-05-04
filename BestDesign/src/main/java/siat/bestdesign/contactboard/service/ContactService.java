package siat.bestdesign.contactboard.service;

import java.util.HashMap;
import java.util.List;

import siat.bestdesign.contactboard.domain.ContactVO;


public interface ContactService {

	
	List<ContactVO> getContactBoardList(HashMap map);

	void insertContact(ContactVO vo);

	int getGroupId();
	
	int getTotalPage();

	ContactVO selectById(int contactNum);

	void updateCount(int contactNum);

	String getSearchMinSeqNum(ContactVO parent);

	String selectLastSequenceNumber(String max, String min);

	String getSequenceNumber(ContactVO parent, String lastChildSeq);

	void boardModify(ContactVO vo);

	void boardDelete(int contactNum);

	ContactVO selectByIdView(int contactNum);
	
}
