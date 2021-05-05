package siat.bestdesign.saleboard.controller;

import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import siat.bestdesign.chat.domain.ChatVO;
import siat.bestdesign.chat.service.ChatService;
import siat.bestdesign.saleboard.domain.SaleBoardDealVO;
import siat.bestdesign.saleboard.domain.SaleBoardPagingVO;
import siat.bestdesign.saleboard.domain.SaleBoardVO;
import siat.bestdesign.saleboard.service.SaleBoardService;

@Controller
@RequestMapping("saleboard")
public class SaleBoardController {
	@Autowired
	private SaleBoardService saleBoardService;
	
	@Autowired
	ChatService chatService;
	
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
	public String getSaleBoard(SaleBoardVO vo, Model model, HttpSession session) {
		System.out.println("getSaleBoard 컨트롤러 호출");
		model.addAttribute("saleBoard", saleBoardService.getSaleBoard(vo));
		saleBoardService.updateSaleBoardView(vo);
		
		HashMap map = new HashMap();
		String userId = "";
		if(session.getAttribute("userID")!=null) {
			userId = (String)session.getAttribute("userID");
		}
		map.put("userId", userId);
		map.put("saleNum", vo.getSaleNum());
		String star = null;
		if(saleBoardService.checkCartView(map)!=null) {
			star = "찜 해제";
		}else {
			star = "찜하기";
		}
		System.out.println(star);
		model.addAttribute("scart", star);
		
		return "saleboard/saleBoard";
	}
	
	@RequestMapping("/getSaleBoardList.do")
	public String getSaleBoardList(SaleBoardPagingVO vo, Model model, HttpSession session) {
		if (vo.getOrderby() == null) vo.setOrderby("name");
		if (vo.getCart() == null) vo.setCart("off");
		if (vo.getSelectPrice() == null) vo.setSelectPrice("off");
		if (vo.getSelectRate() == null) vo.setSelectRate("off");
		if (vo.getSelectBox() == null) vo.setSelectBox("off");
		
		
		System.out.println(vo.getEtc());
		
		String userId = "";
		if(session.getAttribute("userID")!=null) {
			userId = (String)session.getAttribute("userID");
		}
		
		vo.setUserId(userId);
		vo.setTotal(saleBoardService.countSaleBoardList(vo));
		
		if (vo.getNowPage() == 0 && vo.getCntPerPage() == 0) {
			vo.setNowPage(1);
			vo.setCntPerPage(9);
		}
		else if (vo.getNowPage() == 0) {
			vo.setNowPage(1);
		}
		else if (vo.getCntPerPage() == 0) {
			vo.setCntPerPage(3);
		}
		
		vo.setLastPage((int)Math.ceil((double) vo.getTotal() / (double) vo.getCntPerPage()));
		
		vo.setEndPage((int) Math.ceil((double) vo.getNowPage() / (double) vo.getCntPage()) * vo.getCntPage());
		
		if (vo.getLastPage() < vo.getEndPage()) {
			vo.setEndPage(vo.getLastPage());
		}
		
		vo.setStartPage(vo.getEndPage() - vo.getCntPage() + 1);
		if (vo.getStartPage() < 1) {
			vo.setStartPage(1);
		}
		
		vo.setEnd(vo.getNowPage() * vo.getCntPerPage());
		vo.setStart(vo.getEnd() - vo.getCntPerPage() + 1);
		
		
		
		model.addAttribute("saleBoardListPaging", vo);
		model.addAttribute("saleBoardList", saleBoardService.getSaleBoardList(vo));
		return "saleboard/saleList";
	}
	
	@RequestMapping("purchase.do")
	public String saleBoardPurchase(SaleBoardDealVO vo) {
		ChatVO chatvo1 = new ChatVO();
		chatvo1.setChatFromId(vo.getDealSellerId());
		chatvo1.setChatToId(vo.getDealBuyerId());
		chatvo1.setChatContent(vo.getDealBuyerId() + "님, '" + vo.getSaleTitle() + "' 작품을 구매해주셔서 감사합니다.");
		chatService.insertChat(chatvo1);
		
		ChatVO chatvo2 = new ChatVO();
		chatvo2.setChatFromId("manager1");
		chatvo2.setChatToId(vo.getDealSellerId());
		chatvo2.setChatContent(vo.getDealBuyerId() + "님께서  '" + vo.getSaleTitle() + "' 작품을 구매하셨습니다.");
		chatService.insertChat(chatvo2);
		
		saleBoardService.saleBoardPurchase(vo);
		return "redirect:/saleboard/getSaleBoard.do?saleNum="+vo.getSaleNum();
	}
	
	@RequestMapping(value="checkCart.do",produces="application/text; charset=utf-8")//아약스 인코딩
	@ResponseBody
	public String checkCart(String userId, int saleNum) {
		HashMap map = new HashMap();
		map.put("userId", userId);
		map.put("saleNum", saleNum);
		if(saleBoardService.checkCart(map)!=null) {
			return "찜하기";
		}else {
			return "찜 해제";
		}
	}
}