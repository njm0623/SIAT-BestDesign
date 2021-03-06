package siat.bestdesign.requestboard.controller;

import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import siat.bestdesign.manager.controller.ManagerCotroller;
import siat.bestdesign.requestboard.domain.RequestBoardDealVO;
import siat.bestdesign.requestboard.domain.RequestBoardPagingVO;
import siat.bestdesign.requestboard.domain.RequestBoardVO;
import siat.bestdesign.requestboard.service.RequestBoardService;

@Controller
@RequestMapping("requestboard")
public class RequestBoardController {

	
	private Logger log = LoggerFactory.getLogger(RequestBoardController.class);

	@Autowired
	private RequestBoardService requestBoardService;
	
	@RequestMapping("/{step}.do")
	public String viewPage(@PathVariable String step) {
		log.info("main에서"+step+"동작");
		System.out.println("requestboard에서 자신 반환하는 모든 동작 : " + step);
		return "requestboard/"+step;
	}
	
	@RequestMapping("/insertRequestBoard.do")
	public String insertRequestBoard(RequestBoardVO vo) {
		log.info("RequestBoard에서 insertRequestBoard동작");
		System.out.println("insertRequestBoardList 컨트롤러 호출");
		requestBoardService.insertRequestBoard(vo);
		return "redirect:/requestboard/getRequestBoardList.do";
	}
	
	@RequestMapping("/modifyRequestBoard.do")
	public String modifyRequestBoard(RequestBoardVO vo, Model model) {
		log.info("RequestBoard에서 modifyRequestBoard동작");
		System.out.println("modifyRequestBoard 컨트롤러 호출");
		model.addAttribute("requestBoard", requestBoardService.getRequestBoard(vo));
		return "requestboard/requestModifyBoard";
	}
	
	@RequestMapping("/updateRequestBoard.do")
	public String updateRequestBoard(RequestBoardVO vo) {
		log.info("RequestBoard에서 updateRequestBoard동작");
		System.out.println("updateRequestBoardList 컨트롤러 호출");
		requestBoardService.updateRequestBoard(vo);
		return "redirect:/requestboard/getRequestBoard.do?requestNum="+vo.getRequestNum();
	}
	
	@RequestMapping("/deleteRequestBoard.do")
	public String deleteRequestBoard(RequestBoardVO vo) {
		log.info("RequestBoard에서 deleteRequestBoard동작");
		System.out.println("deleteRequestBoardList 컨트롤러 호출");
		requestBoardService.deleteRequestBoard(vo);
		return "redirect:/requestboard/getRequestBoardList.do";
	}
	
	@RequestMapping("/getRequestBoard.do")
	public String getRequestBoard(RequestBoardVO vo, Model model) {
		log.info("RequestBoard에서 getRequestBoard동작");
		System.out.println("getRequestBoard 컨트롤러 호출");
		model.addAttribute("requestBoard", requestBoardService.getRequestBoard(vo));
		requestBoardService.updateRequestBoardView(vo);
		return "requestboard/requestBoard";
	}
	
	@RequestMapping("/getRequestBoardList.do")
	public String getRequestBoardList(RequestBoardPagingVO vo, Model model, @RequestParam(value="search", required = false) String search, @RequestParam(value="orderby", required = false) String orderby, @RequestParam(value="nowPage", required = false) String nowPage, @RequestParam(value="cntPerPage", required = false) String cntPerPage) {
		log.info("RequestBoard에서 getRequestBoardList동작");
		System.out.println("getRequestBoardList 컨트롤러 호출");
		System.out.println(orderby);
		System.out.println(search);
		
		if (orderby == null) orderby="newestDate";
		
		HashMap param = new HashMap();
		param.put("orderby",orderby);
		param.put("search", search);
		
		int total = requestBoardService.countRequestBoardList(param);
		System.out.println("total: " + total);
		
		if (nowPage == null && cntPerPage == null) {
			nowPage = "1";
			cntPerPage = "9";
		} else if (nowPage == null) {
			nowPage = "1";
		} else if (cntPerPage == null) { 
			cntPerPage = "3";
		}
		
		vo = new RequestBoardPagingVO(total, Integer.parseInt(nowPage), Integer.parseInt(cntPerPage), orderby, search);
		
		model.addAttribute("requestBoardListPaging", vo);
		model.addAttribute("requestBoardList", requestBoardService.getRequestBoardList(vo));
		return "requestboard/requestList";
	}
}