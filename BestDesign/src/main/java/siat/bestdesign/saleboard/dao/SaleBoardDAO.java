package siat.bestdesign.saleboard.dao;

import java.util.HashMap;
import java.util.List;

import siat.bestdesign.saleboard.domain.SaleBoardPagingVO;
import siat.bestdesign.saleboard.domain.SaleBoardVO;

public interface SaleBoardDAO {

	void insertSaleBoard(SaleBoardVO vo);

	void updateSaleBoard(SaleBoardVO vo);

	void deleteSaleBoard(SaleBoardVO vo);

	SaleBoardVO getSaleBoard(SaleBoardVO vo);

	List<SaleBoardVO> getSaleBoardList(SaleBoardPagingVO vo);

	int countSaleBoardList(HashMap param);

	void updateSaleBoardView(SaleBoardVO vo);

}