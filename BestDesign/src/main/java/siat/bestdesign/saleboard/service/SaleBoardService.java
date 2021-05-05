package siat.bestdesign.saleboard.service;

import java.util.HashMap;
import java.util.List;

import siat.bestdesign.saleboard.domain.SaleBoardCartVO;
import siat.bestdesign.saleboard.domain.SaleBoardDealVO;
import siat.bestdesign.saleboard.domain.SaleBoardPagingVO;
import siat.bestdesign.saleboard.domain.SaleBoardVO;

public interface SaleBoardService {

	void insertSaleBoard(SaleBoardVO vo);

	void updateSaleBoard(SaleBoardVO vo);

	void deleteSaleBoard(SaleBoardVO vo);

	SaleBoardVO getSaleBoard(SaleBoardVO vo);

	List<SaleBoardVO> getSaleBoardList(SaleBoardPagingVO vo);

	int countSaleBoardList(SaleBoardPagingVO vo);

	void updateSaleBoardView(SaleBoardVO vo);

	void saleBoardPurchase(SaleBoardDealVO vo);
	
	public SaleBoardCartVO checkCart(HashMap map);

	public SaleBoardCartVO checkCartView(HashMap map);
}