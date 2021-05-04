package siat.bestdesign.saleboard.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import siat.bestdesign.saleboard.domain.SaleBoardPagingVO;
import siat.bestdesign.saleboard.domain.SaleBoardVO;
import siat.bestdesign.saleboard.service.SaleBoardService;

@Controller
@RequestMapping("saleboard")
public class SaleBoardController {
	@Autowired
	private SaleBoardService saleBoardService;
	
	@RequestMapping("/{step}.do")
	public String viewPage(@PathVariable String step) {
		System.out.println("saleboard에서 자신 반환하는 모든 동작 : " + step);
		return "saleboard/"+step;
	}
	
	@RequestMapping("/insertSaleBoard.do")
	public String insertSaleBoard(SaleBoardVO vo) {
		System.out.println("insertSaleBoardList 컨트롤러 호출");
		saleBoardService.insertSaleBoard(vo);
		return "redirect:/saleboard/getSaleBoardList.do";
	}
	
	@RequestMapping("/modifySaleBoard.do")
	public String modifySaleBoard(SaleBoardVO vo, Model model) {
		System.out.println("modifySaleBoard 컨트롤러 호출");
		model.addAttribute("saleBoard", saleBoardService.getSaleBoard(vo));
		return "saleboard/saleModifyBoard";
	}
	
	@RequestMapping("/updateSaleBoard.do")
	public String updateSaleBoard(SaleBoardVO vo) {
		System.out.println("updateSaleBoardList 컨트롤러 호출");
		saleBoardService.updateSaleBoard(vo);
		return "redirect:/saleboard/getSaleBoard.do?saleNum="+vo.getSaleNum();
	}
	
	@RequestMapping("/deleteSaleBoard.do")
	public String deleteSaleBoard(SaleBoardVO vo) {
		System.out.println("deleteSaleBoardList 컨트롤러 호출");
		saleBoardService.deleteSaleBoard(vo);
		return "redirect:/saleboard/getSaleBoardList.do";
	}
	
	@RequestMapping("/getSaleBoard.do")
	public String getSaleBoard(SaleBoardVO vo, Model model) {
		System.out.println("getSaleBoard 컨트롤러 호출");
		model.addAttribute("saleBoard", saleBoardService.getSaleBoard(vo));
		saleBoardService.updateSaleBoardView(vo);
		return "saleboard/saleBoard";
	}
	
	@RequestMapping("/getSaleBoardList.do")
	public String getSaleBoardList(SaleBoardPagingVO vo, Model model, @RequestParam(value="search", required = false) String search, @RequestParam(value="orderby", required = false) String orderby, @RequestParam(value="nowPage", required = false) String nowPage, @RequestParam(value="cntPerPage", required = false) String cntPerPage) {
		System.out.println("getSaleBoardList 컨트롤러 호출");
		System.out.println(orderby);
		System.out.println(search);
		
		if (orderby == null) orderby="newestDate";
		
		HashMap param = new HashMap();
		param.put("orderby",orderby);
		param.put("search", search);
		
		int total = saleBoardService.countSaleBoardList(param);
		System.out.println("total: " + total);
		
		if (nowPage == null && cntPerPage == null) {
			nowPage = "1";
			cntPerPage = "9";
		} else if (nowPage == null) {
			nowPage = "1";
		} else if (cntPerPage == null) { 
			cntPerPage = "3";
		}
		
		vo = new SaleBoardPagingVO(total, Integer.parseInt(nowPage), Integer.parseInt(cntPerPage), orderby, search);
		
		model.addAttribute("saleBoardListPaging", vo);
		model.addAttribute("saleBoardList", saleBoardService.getSaleBoardList(vo));
		return "saleboard/saleList";
	}
}