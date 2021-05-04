package siat.bestdesign.saleboard.dao;

import java.util.List;

import siat.bestdesign.saleboard.domain.SaleBoardDealVO;
import siat.bestdesign.saleboard.domain.SaleBoardReplyVO;

public interface SaleBoardReplyDAO {

	Integer insertReply(SaleBoardReplyVO vo);

	List<SaleBoardReplyVO> selectAllReply(String saleNum);

	int deleteReply(SaleBoardReplyVO vo);

	int modifyReply(SaleBoardReplyVO vo);

	void insertSaleBoardDeal(SaleBoardDealVO vo);

	void updateSaleBoardRate(SaleBoardReplyVO vo);

}