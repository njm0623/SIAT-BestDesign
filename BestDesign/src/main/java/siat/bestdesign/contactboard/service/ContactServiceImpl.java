package siat.bestdesign.contactboard.service;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import siat.bestdesign.contactboard.dao.ContactDAO;
import siat.bestdesign.contactboard.domain.ContactVO;

@Service("ContactService")
public class ContactServiceImpl implements ContactService{
	
	@Autowired
	ContactDAO contactDAO;

	@Override
	public List<ContactVO> getContactBoardList(HashMap map) {
		return contactDAO.getContactBoardList(map);
	}

	@Override
	public void insertContact(ContactVO vo) {
		contactDAO.insertContact(vo);
	}

	@Override
	public int getGroupId() {
		return contactDAO.getGroupId();
	}

	@Override
	public int getTotalPage() {
		double t =  Math.ceil(contactDAO.getTotalCount()/10);
		return (int)t;
	}

	@Override
	public ContactVO selectByIdView(int contactNum) {
		ContactVO vo2 = contactDAO.selectById(contactNum);
		vo2.setContactContent(vo2.getContactContent().replace("\r\n","<br>"));
		return vo2;
	}

	@Override
	public void updateCount(int contactNum) {
		contactDAO.updateCount(contactNum);
		
	}

	@Override
	public String getSearchMinSeqNum(ContactVO parent) {
		String parentSeqNum = parent.getContactSeqNum();
		DecimalFormat dFormat = new DecimalFormat("0000000000000000");
		long parentSeqLongValue = Long.parseLong(parentSeqNum);
		long searchMinLongValue = 0;
		
		switch( parent.getLevel())
		{
		case 0 : searchMinLongValue = parentSeqLongValue / 1000000L * 1000000L; break;
		case 1 : searchMinLongValue = parentSeqLongValue / 10000L * 10000L; break;
		case 2 : searchMinLongValue = parentSeqLongValue / 100L * 100L; break;
		}
		return dFormat.format(searchMinLongValue);
	}

	@Override
	public String selectLastSequenceNumber(String max, String min) {
		return contactDAO.selectLastSequenceNumber(max, min);
	}

	@Override
	public String getSequenceNumber(ContactVO parent, String lastChildSeq) {
		long parentSeqLong	= Long.parseLong( parent.getContactSeqNum());
		int  parentLevel	= parent.getLevel();
		
		long decUnit = 0;
		if		( parentLevel == 0 ){	decUnit = 10000L;	}
		else if	( parentLevel == 1 ){	decUnit = 100L;		}
		else if ( parentLevel == 2 ){	decUnit = 1L;		}
		
		String sequenceNumber = null;
		
		DecimalFormat dFormat = new DecimalFormat("0000000000000000");
		if( lastChildSeq == null ){			// 답변글이 없다면
			sequenceNumber = dFormat.format(parentSeqLong-decUnit);
		} else {							// 답변글이 있다면, 마지막 답변글인지 확인
			String orderOfLastChildSeq = null;
			if( parentLevel == 0 ){
				orderOfLastChildSeq = lastChildSeq.substring(10,12);
				sequenceNumber = lastChildSeq.substring(0, 12) + "9999";
			}else if( parentLevel == 1 ){
				orderOfLastChildSeq = lastChildSeq.substring(12,14);
				sequenceNumber = lastChildSeq.substring(0, 14) + "99";				
			}else if( parentLevel == 2 ){
				orderOfLastChildSeq = lastChildSeq.substring(14,16);
				sequenceNumber = lastChildSeq;			
			}
			
			if( orderOfLastChildSeq.equals("00")){
				System.out.println("마지막 자식 글이 이미 존재합니다.");
			}
			
			long seq = Long.parseLong(sequenceNumber) - decUnit;
			sequenceNumber = dFormat.format(seq);
			
			return sequenceNumber; 
		}
		return sequenceNumber;
	}

	@Override
	public void boardModify(ContactVO vo) {
		contactDAO.boardModify(vo);
	}

	@Override
	public void boardDelete(int contactNum) {
		contactDAO.boardDelete(contactNum);
		
	}

	@Override
	public ContactVO selectById(int contactNum) {
		return contactDAO.selectById(contactNum);
	}

}
