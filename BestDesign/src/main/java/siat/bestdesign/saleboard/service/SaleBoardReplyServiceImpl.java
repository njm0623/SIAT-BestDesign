package siat.bestdesign.saleboard.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import siat.bestdesign.saleboard.dao.SaleBoardReplyDAOImpl;
import siat.bestdesign.saleboard.domain.SaleBoardDealVO;
import siat.bestdesign.saleboard.domain.SaleBoardReplyVO;

@Service("saleBoardReplyService")
// 드로잉샵 댓글 및 평점, 거래 기능 Service
public class SaleBoardReplyServiceImpl implements SaleBoardReplyService {
	@Autowired
	private SaleBoardReplyDAOImpl saleBoardReplyDAO;

	@Override
	// 드로잉샵 댓글 등록 Service
	public Integer insertReply(SaleBoardReplyVO vo) {
		return saleBoardReplyDAO.insertReply(vo);
	}

	@Override
	// 드로잉샵 댓글 목록 불러오기 Service
	public List<SaleBoardReplyVO> selectAllReply(String saleNum) {	
		return saleBoardReplyDAO.selectAllReply(saleNum);
	}

	@Override
	// 드로잉샵 댓글 삭제 Service
	public int deleteReply(SaleBoardReplyVO vo) {
		return saleBoardReplyDAO.deleteReply(vo);
	}
	
	@Override
	// 드로잉샵 댓글 수정 Service
	public int modifyReply(SaleBoardReplyVO vo) {
		return saleBoardReplyDAO.modifyReply(vo);
	}
	
	@Override
	// 드로잉샵 거래 내역 추가 Service
	public void insertSaleBoardDeal(SaleBoardDealVO vo) {
		saleBoardReplyDAO.insertSaleBoardDeal(vo);
	}
	
	@Override
	// 드로잉샵 평점 갱신 Service
	public void updateSaleBoardRate(SaleBoardReplyVO vo) {
		saleBoardReplyDAO.updateSaleBoardRate(vo);
	}
}
