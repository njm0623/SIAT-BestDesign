package siat.bestdesign.requestboard.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

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
	public String getRequestBoardList(RequestBoardVO vo, Model model) {
		System.out.println("getRequestBoardList 컨트롤러 호출");
		model.addAttribute("requestBoardList", requestBoardService.getRequestBoardList(vo));
		return "requestboard/requestList";
	}
}