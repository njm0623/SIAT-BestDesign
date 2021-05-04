package siat.bestdesign.saleboard.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import siat.bestdesign.saleboard.dao.SaleBoardReplyDAOImpl;
import siat.bestdesign.saleboard.domain.SaleBoardDealVO;
import siat.bestdesign.saleboard.domain.SaleBoardReplyVO;

@Service("saleBoardReplyService")
public class SaleBoardReplyServiceImpl implements SaleBoardReplyService {
	@Autowired
	private SaleBoardReplyDAOImpl saleBoardReplyDAO;

	@Override
	public Integer insertReply(SaleBoardReplyVO vo) {
		return saleBoardReplyDAO.insertReply(vo);
	}

	@Override
	public List<SaleBoardReplyVO> selectAllReply(String saleNum) {	
		return saleBoardReplyDAO.selectAllReply(saleNum);
	}

	@Override
	public int deleteReply(SaleBoardReplyVO vo) {
		return saleBoardReplyDAO.deleteReply(vo);
	}
	
	@Override
	public int modifyReply(SaleBoardReplyVO vo) {
		return saleBoardReplyDAO.modifyReply(vo);
	}
	
	@Override
	public void insertSaleBoardDeal(SaleBoardDealVO vo) {
		saleBoardReplyDAO.insertSaleBoardDeal(vo);
	}
	
	@Override
	public void updateSaleBoardRate(SaleBoardReplyVO vo) {
		saleBoardReplyDAO.updateSaleBoardRate(vo);
	}
}