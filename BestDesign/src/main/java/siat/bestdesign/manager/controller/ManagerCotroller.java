package siat.bestdesign.manager.controller;


import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import siat.bestdesign.chat.controller.ChatController;
import siat.bestdesign.contactboard.domain.ContactVO;
import siat.bestdesign.manager.domain.ChartVO;
import siat.bestdesign.manager.domain.ManagerVO;
import siat.bestdesign.manager.domain.RequestChartVO;
import siat.bestdesign.manager.service.ManagerService;
import siat.bestdesign.requestboard.domain.RequestBoardVO;
import siat.bestdesign.review.domain.ReviewVO;
import siat.bestdesign.saleboard.domain.SaleBoardVO;
import siat.bestdesign.user.domain.UserVO;

@Controller
@RequestMapping("manager")
public class ManagerCotroller {

	private Logger log = LoggerFactory.getLogger(ManagerCotroller.class);
	
	@Autowired
	ManagerService managerService;
	
	@RequestMapping("/{step}.do")
	public String viewPage(@PathVariable String step) {
		log.info("manger에서" + step + "동작");
		System.out.println("manager에서 자신 반환하는 모든 동작 : " + step);
		return "manager/"+step;
	}
	
	@RequestMapping("login.do")
	public String login(ManagerVO vo, HttpSession session) {
		log.info("manager에서 login");
		System.out.println("login에서 자신 반환하는 모든 동작 : " + vo);
		System.out.println(vo.getManagerId() + " : " + vo.getManagerPwd());
		ManagerVO vo2 = managerService.selectLogin(vo);
		String msg = "", content = "", href = "";
		
		if(vo2!=null) {
			if(vo2.getManagerPwd().equals(vo.getManagerPwd())) {
				session.setAttribute("userID", vo2.getManagerId());
				session.setAttribute("type", "관리자");
				msg = "성공";
				content = "로그인에 성공했습니다.";
				href = "main/index.do";
			}else {
				msg = "오류";
				content = "비밀번호가 일치하지 않습니다.";
				href = "main/manager.do";
			}
		}else {
			msg = "오류";
			content = "아이디가 존재하지 않습니다.";
			href = "main/manager.do";
		}
		
		session.setAttribute("messageType", msg);
		session.setAttribute("messageContent", content);
		System.out.println(session.getAttribute("messageContent"));
		return "redirect:/"+href;
		
	}
		@RequestMapping("chart.do")
		@ResponseBody //요청해서 보내는 페이지와 리턴받는 뷰페이지가 일치할때 써준다
		public List<RequestChartVO> getChartList(String board, String deal) {
			System.out.println(managerService.getChartList(board,deal)+"데이터값");
				return managerService.getChartList(board, deal);//return 4ㄱ
		}
		//고객목록
		@RequestMapping("userBoardList.do")//model방식
		public void userBoard(Model m, UserVO vo) {
			log.info("manger에서 고객목록동작");
			System.out.println("고객 리스트목록");
			m.addAttribute("userBoard", managerService.getWriteList(vo));
		}
		//디자이너목록
		@RequestMapping("designBoardList.do")//model방식
		public void designBoard(Model m, UserVO vo) {
			log.info("manger에서 디자이너목록동작");
			System.out.println("디자이너 목록");
			m.addAttribute("designList", managerService.getDesignList(vo));
		}
		//디자이너 게시판
		@RequestMapping("designSaleList.do")//model방식
		public void designSaleList(Model m, SaleBoardVO vo) {

			log.info("manger에서 디자이너 게시판동작");
			System.out.println("디자이너 게시판");
			m.addAttribute("designSale", managerService.getDesignSale(vo));
		}
		//고객 ID별 게시판, 리뷰 목록
		@RequestMapping("registWriteList.do")//model방식
		public void registWriteList(Model m, ReviewVO vo, RequestBoardVO vo1 ,ContactVO vo2) {
			log.info("manger에서 고객 id별 게시판,리뷰동작");
			System.out.println("고객 id별 게시판,리뷰");
			m.addAttribute("registWrite", managerService.getRegiWrite(vo1));
			m.addAttribute("registContact", managerService.getRegiContact(vo2));
			m.addAttribute("registReview", managerService.getRegiReview(vo));
		}
		
		//그려주세요 리스트
		@RequestMapping("requestBoardList.do")//model방식
		public void requestBoardList(Model m, RequestBoardVO vo) {
			log.info("manger에서 그려주세요 리스트동작");
			System.out.println("그려주세요 리스트");
			m.addAttribute("requestList", managerService.getRequestList(vo));
		}
		
		//드로잉샵 리스트
		@RequestMapping("saleBoardList.do")//model방식
		public void requestBoardList(Model m, SaleBoardVO vo) {
			log.info("manger에서 드로잉샵 리스트동작");
			System.out.println("드로잉샵 리스트");
			m.addAttribute("saleList", managerService.getSaleList(vo));
		}
		
		//문의글 리스트
		@RequestMapping("contactBoardList.do")//model방식
		public void contactBoardList(Model m, ContactVO vo) {			
			log.info("manger에서 문의글 리스트동작");
			System.out.println("문의글 리스트");
			m.addAttribute("contactList", managerService.getContactList(vo));
		}
}


