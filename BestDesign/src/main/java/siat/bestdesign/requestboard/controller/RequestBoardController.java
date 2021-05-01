package siat.bestdesign.requestboard.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import siat.bestdesign.requestboard.domain.RequestBoardPagingVO;
import siat.bestdesign.requestboard.domain.RequestBoardVO;
import siat.bestdesign.requestboard.service.RequestBoardService;

@Controller
@RequestMapping("requestboard")
public class RequestBoardController {
	@Autowired
	private RequestBoardService requestBoardService;
	
	@RequestMapping("/{step}.do")
	public String viewPage(@PathVariable String step) {
		System.out.println("requestboard에서 자신 반환하는 모든 동작 : " + step);
		return "requestboard/"+step;
	}
	
	@RequestMapping("/insertRequestBoard.do")
	public String insertRequestBoard(RequestBoardVO vo) {
		System.out.println("insertRequestBoardList 컨트롤러 호출");
		requestBoardService.insertRequestBoard(vo);
		return "redirect:/requestboard/getRequestBoardList.do";
	}
	
	@RequestMapping("/modifyRequestBoard.do")
	public String modifyRequestBoard(RequestBoardVO vo, Model model) {
		System.out.println("modifyRequestBoard 컨트롤러 호출");
		model.addAttribute("requestBoard", requestBoardService.getRequestBoard(vo));
		return "requestboard/requestModifyBoard";
	}
	
	@RequestMapping("/updateRequestBoard.do")
	public String updateRequestBoard(RequestBoardVO vo) {
		System.out.println("updateRequestBoardList 컨트롤러 호출");
		requestBoardService.updateRequestBoard(vo);
		return "redirect:/requestboard/getRequestBoardList.do";
	}
	
	@RequestMapping("/deleteRequestBoard.do")
	public String deleteRequestBoard(RequestBoardVO vo) {
		System.out.println("deleteRequestBoardList 컨트롤러 호출");
		requestBoardService.deleteRequestBoard(vo);
		return "redirect:/requestboard/getRequestBoardList.do";
	}
	
	@RequestMapping("/getRequestBoard.do")
	public String getRequestBoard(RequestBoardVO vo, Model model) {
		System.out.println("getRequestBoard 컨트롤러 호출");
		model.addAttribute("requestBoard", requestBoardService.getRequestBoard(vo));
		return "requestboard/requestBoard";
	}
	
	@RequestMapping("/getRequestBoardList.do")
	public String getRequestBoardList(RequestBoardPagingVO vo, Model model, @RequestParam(value="nowPage", required = false) String nowPage, @RequestParam(value="cntPerPage", required = false) String cntPerPage) {
		System.out.println("getRequestBoardList 컨트롤러 호출");
		
		int total = requestBoardService.countRequestBoardList();
		if (nowPage == null && cntPerPage == null) {
			nowPage = "1";
			cntPerPage = "9";
		} else if (nowPage == null) {
			nowPage = "1";
		} else if (cntPerPage == null) { 
			cntPerPage = "3";
		}
		
		vo = new RequestBoardPagingVO(total, Integer.parseInt(nowPage), Integer.parseInt(cntPerPage));
		
		model.addAttribute("requestBoardListPaging", vo);
		model.addAttribute("requestBoardList", requestBoardService.getRequestBoardList(vo));
		return "requestboard/requestList";
	}
}