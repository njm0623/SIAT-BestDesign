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
public class SaleBoardServiceImpl implements SaleBoardService {
	@Autowired
	private SaleBoardDAOImpl saleBoardDAO;
	
	@Override
	public void insertSaleBoard(SaleBoardVO vo) {
		saleBoardDAO.insertSaleBoard(vo);
	}

	@Override
	public void updateSaleBoard(SaleBoardVO vo) {
		saleBoardDAO.updateSaleBoard(vo);
	}

	@Override
	public void deleteSaleBoard(SaleBoardVO vo) {
		saleBoardDAO.deleteSaleBoard(vo);
	}

	@Override
	public SaleBoardVO getSaleBoard(SaleBoardVO vo) {
		return saleBoardDAO.getSaleBoard(vo);
	}

	@Override
	public List<SaleBoardVO> getSaleBoardList(SaleBoardPagingVO vo) {
		return saleBoardDAO.getSaleBoardList(vo);
	}
	
	@Override
	public int countSaleBoardList(SaleBoardPagingVO vo) {
		return saleBoardDAO.countSaleBoardList(vo);
	}

	@Override
	public void updateSaleBoardView(SaleBoardVO vo) {
		saleBoardDAO.updateSaleBoardView(vo);
	}
	
	@Override
	public void saleBoardPurchase(SaleBoardDealVO vo) {
		saleBoardDAO.saleBoardPurchase(vo);
	}
	
	@Override
	public SaleBoardCartVO checkCart(HashMap map) {
		return saleBoardDAO.checkCart(map);
	}

	@Override
	public SaleBoardCartVO checkCartView(HashMap map) {
		return saleBoardDAO.checkCartView(map);
	}
}
