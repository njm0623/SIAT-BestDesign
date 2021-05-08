package siat.bestdesign.saleboard.controller;

import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import siat.bestdesign.chat.domain.ChatVO;
import siat.bestdesign.chat.service.ChatService;
import siat.bestdesign.manager.controller.ManagerCotroller;
import siat.bestdesign.saleboard.domain.SaleBoardDealVO;
import siat.bestdesign.saleboard.domain.SaleBoardPagingVO;
import siat.bestdesign.saleboard.domain.SaleBoardVO;
import siat.bestdesign.saleboard.service.SaleBoardService;

@Controller
@RequestMapping("saleboard")
// 드로잉샵 게시글 컨트롤러
public class SaleBoardController {
	private Logger log = LoggerFactory.getLogger(ManagerCotroller.class);
	
	@Autowired
	private SaleBoardService saleBoardService;
	
	@Autowired
	ChatService chatService;
	
	@RequestMapping("/{step}.do")
	// 단순 페이지 이동
	public String viewPage(@PathVariable String step) {
		log.info("SaleBoard에서" + step + "동작");
		System.out.println("saleboard에서 자신 반환하는 모든 동작 : " + step);
		return "saleboard/"+step;
	}
	
	@RequestMapping("/insertSaleBoard.do")
	// 드로잉샵 게시글 등록 컨트롤러
	public String insertSaleBoard(SaleBoardVO vo) {
		log.info("saleBoard에서 insertSaleBoard");
		System.out.println("insertSaleBoardList 컨트롤러 호출");
		// 드로잉샵 게시글 등록
		saleBoardService.insertSaleBoard(vo);
		// 리다이렉트
		return "redirect:/saleboard/getSaleBoardList.do";
	}
	
	@RequestMapping("/modifySaleBoard.do")
	// 드로잉샵 게시글 수정 버튼 클릭 컨트롤러
	public String modifySaleBoard(SaleBoardVO vo, Model model) {
		log.info("saleBoard에서 modifySaleBoard");
		System.out.println("modifySaleBoard 컨트롤러 호출");
		// 모델 추가
		model.addAttribute("saleBoard", saleBoardService.getSaleBoard(vo));
		// 드로잉샵 게시글 수정 페이지로 이동
		return "saleboard/saleModifyBoard";
	}
	
	@RequestMapping("/updateSaleBoard.do")
	// 드로잉샵 게시글 수정 컨트롤러
	public String updateSaleBoard(SaleBoardVO vo) {
		log.info("saleBoard에서 updateSaleBoard");
		System.out.println("updateSaleBoardList 컨트롤러 호출");
		// 드로잉샵 게시글 갱신
		saleBoardService.updateSaleBoard(vo);
		// 리다이렉트
		return "redirect:/saleboard/getSaleBoard.do?saleNum="+vo.getSaleNum();
	}
	
	@RequestMapping("/deleteSaleBoard.do")
	// 드로잉샵 게시글 삭제 컨트롤러
	public String deleteSaleBoard(SaleBoardVO vo) {
		log.info("saleBoard에서 deleteSaleBoard");
		System.out.println("deleteSaleBoardList 컨트롤러 호출");
		// 드로잉샵 게시글 삭제
		saleBoardService.deleteSaleBoard(vo);
		// 리다이렉트
		return "redirect:/saleboard/getSaleBoardList.do";
	}
	
	@RequestMapping("/getSaleBoard.do")
	// 드로잉샵 게시글 상세 내용 불러오기 컨트롤러
	public String getSaleBoard(SaleBoardVO vo, Model model, HttpSession session) {
		log.info("saleBoard에서 getSaleBoard");
		System.out.println("getSaleBoard 컨트롤러 호출");
		// 모델 추가
		model.addAttribute("saleBoard", saleBoardService.getSaleBoard(vo));
		// 드로잉샵 게시글 조회수 갱신
		saleBoardService.updateSaleBoardView(vo);
		
		HashMap map = new HashMap();
		String userId = "";
		//  세션에 저장된 유저 아이디 불러와 저장
		if(session.getAttribute("userID")!=null) {
			userId = (String)session.getAttribute("userID");
		}
		// 유저 아이디 저장
		map.put("userId", userId);
		// 드로잉샵 게시글 번호 저장
		map.put("saleNum", vo.getSaleNum());
		
		String star = null;
		// 드로잉샵 게시글 찜 상태 조회 후 저장
		if(saleBoardService.checkCartView(map)!=null) {
			star = "찜 해제";
		}else {
			star = "찜하기";
		}
		
		// 모델 추가
		model.addAttribute("scart", star);
		
		// 게시글 상세 내용 불러오기 컨트롤러 호출
		return "saleboard/saleBoard";
	}
	
	@RequestMapping("/getSaleBoardList.do")
	// 드로잉샵 게시글 목록 불러오기 
	public String getSaleBoardList(SaleBoardPagingVO vo, Model model, HttpSession session) {
		if (vo.getOrderby() == null) vo.setOrderby("name");
		if (vo.getCart() == null) vo.setCart("off");
		if (vo.getSelectPrice() == null) vo.setSelectPrice("off");
		if (vo.getSelectRate() == null) vo.setSelectRate("off");
		if (vo.getSelectBox() == null) vo.setSelectBox("off");		
		
		System.out.println(vo.getEtc());
		
		String userId = "";
		// 세션에 저장된 유저 아이디 불러와 저장
		if(session.getAttribute("userID")!=null) {
			userId = (String)session.getAttribute("userID");
		}
		
		// 유저 아이디 저장
		vo.setUserId(userId);
		// 드로잉샵 전체 수 조회 및 저장
		vo.setTotal(saleBoardService.countSaleBoardList(vo));
		
		// NowPage, CntPerPage 변수 set
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
		
		// LastPage 변수 set
		vo.setLastPage((int)Math.ceil((double) vo.getTotal() / (double) vo.getCntPerPage()));
		
		// EndPage 변수 set
		vo.setEndPage((int) Math.ceil((double) vo.getNowPage() / (double) vo.getCntPage()) * vo.getCntPage());
		if (vo.getLastPage() < vo.getEndPage()) {
			vo.setEndPage(vo.getLastPage());
		}
		
		// StartPage 변수 set
		vo.setStartPage(vo.getEndPage() - vo.getCntPage() + 1);
		// StartPage 변수값이 0이면 1로 설정
		if (vo.getStartPage() < 1) {
			vo.setStartPage(1);
		}
		
		// SQL 쿼리문에 들어갈 end 변수 set
		vo.setEnd(vo.getNowPage() * vo.getCntPerPage());
		// SQL 쿼리문에 들어갈 start 변수 set
		vo.setStart(vo.getEnd() - vo.getCntPerPage() + 1);		
		
		// 모델 추가
		model.addAttribute("saleBoardListPaging", vo);
		// 모델 추가
		model.addAttribute("saleBoardList", saleBoardService.getSaleBoardList(vo));
		// 게시판 목록 불러오기 컨트롤러 호출
		return "saleboard/saleList";
	}
	
	@RequestMapping("purchase.do")
	// 드로잉샵 작품 구매 컨트롤러
	public String saleBoardPurchase(SaleBoardDealVO vo, HttpSession session) {
		log.info("saleBoard에서 purchase");
		System.out.println("purchase 호출");
		ChatVO chatvo1 = new ChatVO();
		// 채팅 보내는 유저 아이디 저장
		chatvo1.setChatFromId(vo.getDealSellerId());
		// 채팅 받는 유저 아이디 저장
		chatvo1.setChatToId(vo.getDealBuyerId());
		// 채팅 보낼 메시지 저장
		chatvo1.setChatContent(vo.getDealBuyerId() + "님, '" + vo.getSaleTitle() + "' 작품을 구매해주셔서 감사합니다.");
		// 채팅 전송
		chatService.insertChat(chatvo1);
		
		ChatVO chatvo2 = new ChatVO();
		// 채팅 보내는 유저 아이디 저장
		chatvo2.setChatFromId("manager1");
		// 채팅 받는 유저 아이디 저장
		chatvo2.setChatToId(vo.getDealSellerId());
		// 채팅 보낼 메시지 저장
		chatvo2.setChatContent(vo.getDealBuyerId() + "님께서  '" + vo.getSaleTitle() + "' 작품을 구매하셨습니다.");
		// 채팅 전송
		chatService.insertChat(chatvo2);
		
		// 드로잉샵 작품 
		saleBoardService.saleBoardPurchase(vo);
		// 세션 저장
		session.setAttribute("messageType", "성공");
		// 세션 저장
		session.setAttribute("messageContent", "구매에 성공했습니다.");
		// 리다이렉트
		return "redirect:/saleboard/getSaleBoard.do?saleNum="+vo.getSaleNum();
	}
	
	@RequestMapping(value="checkCart.do",produces="application/text; charset=utf-8")//아약스 인코딩
	@ResponseBody
	// 드로잉샵 게시글 찜 상태 불러오기, 등록, 해제 컨트롤러
	public String checkCart(String userId, int saleNum) {
		HashMap map = new HashMap();
		// 유저 아이디 저장
		map.put("userId", userId);
		// 드로잉샵 게시글 번호 저장
		map.put("saleNum", saleNum);
		// 드로잉샵 찜 상태 확인 후 동록 및 해제
		if(saleBoardService.checkCart(map)!=null) {
			return "찜하기";
		}else {
			return "찜 해제";
		}
	}
}
