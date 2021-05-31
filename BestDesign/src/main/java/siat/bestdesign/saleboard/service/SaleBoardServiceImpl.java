package siat.bestdesign.saleboard.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import siat.bestdesign.saleboard.dao.SaleBoardDAOImpl;
import siat.bestdesign.saleboard.domain.SaleBoardCartVO;
import siat.bestdesign.saleboard.domain.SaleBoardDealVO;
import siat.bestdesign.saleboard.domain.SaleBoardPagingVO;
import siat.bestdesign.saleboard.domain.SaleBoardVO;

@Service("saleBoardService")
// 드로잉샵 게시판 기능 Service
public class SaleBoardServiceImpl implements SaleBoardService {
	@Autowired
	private SaleBoardDAOImpl saleBoardDAO;
	
	@Override
	// 드로잉샵 게시글 등록 Service
	public void insertSaleBoard(SaleBoardVO vo) {
		saleBoardDAO.insertSaleBoard(vo);
	}

	@Override
	// 드로잉샵 게시글 수정 Service
	public void updateSaleBoard(SaleBoardVO vo) {
		saleBoardDAO.updateSaleBoard(vo);
	}

	@Override
	// 드로잉샵 게시글  삭제 Service
	public void deleteSaleBoard(SaleBoardVO vo) {
		saleBoardDAO.deleteSaleBoard(vo);
	}

	@Override
	// 드로잉샵 게시글 내용 불러오기 Service
	public SaleBoardVO getSaleBoard(SaleBoardVO vo) {
		return saleBoardDAO.getSaleBoard(vo);
	}

	@Override
	// 드로잉샵 게시글 목록 불러오기 Service
	public List<SaleBoardVO> getSaleBoardList(SaleBoardPagingVO vo) {
		return saleBoardDAO.getSaleBoardList(vo);
	}
	
	@Override
	// 드로잉샵 게시글 수 불러오기 Service
	public int countSaleBoardList(SaleBoardPagingVO vo) {
		return saleBoardDAO.countSaleBoardList(vo);
	}

	@Override
	// 드로잉샵 게시글 조회수 갱신 Service
	public void updateSaleBoardView(SaleBoardVO vo) {
		saleBoardDAO.updateSaleBoardView(vo);
	}
	
	@Override
	// 드로잉샵 구매 Service
	public void saleBoardPurchase(SaleBoardDealVO vo) {
		saleBoardDAO.saleBoardPurchase(vo);
	}
	
	@Override
	// 드로잉샵 찜 등록, 해제 Service
	public SaleBoardCartVO checkCart(HashMap map) {
		return saleBoardDAO.checkCart(map);
	}

	@Override
	// 드로잉샵 찜 상태 불러오기 Service
	public SaleBoardCartVO checkCartView(HashMap map) {
		return saleBoardDAO.checkCartView(map);
	}
}
