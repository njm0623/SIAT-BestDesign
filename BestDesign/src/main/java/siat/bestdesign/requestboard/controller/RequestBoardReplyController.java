package siat.bestdesign.requestboard.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import siat.bestdesign.requestboard.domain.RequestBoardDealVO;
import siat.bestdesign.requestboard.domain.RequestBoardReplyVO;
import siat.bestdesign.requestboard.service.RequestBoardReplyService;

@Controller
@RequestMapping("requestboard")
public class RequestBoardReplyController {
	@Autowired
	private RequestBoardReplyService requestBoardReplyService;
	
	@RequestMapping(value="reply/new.do", produces="application/text; charset=utf8")
	@ResponseBody
	public void requestBoardReply(RequestBoardReplyVO vo) {
		requestBoardReplyService.insertReply(vo);
	}
	
	@RequestMapping("reply.do")
	@ResponseBody
	public List<RequestBoardReplyVO> requestBoardReplyList(String requestNum) {
		return requestBoardReplyService.selectAllReply(requestNum);
	}
	
	@RequestMapping("reply/delete.do")
	@ResponseBody
	public void requestBoardReplyDelete(String auctionNum) {
		requestBoardReplyService.deleteReply(auctionNum);
	}
	
	@RequestMapping(value="reply/modify.do", produces="application/text; charset=utf8")
	@ResponseBody
	public void requestBoardReplyModify(RequestBoardReplyVO vo) {
		requestBoardReplyService.modifyReply(vo);
	}
	
	@RequestMapping("reply/accept.do")
	public String requestBoardReplyAccept(RequestBoardDealVO vo) {
		requestBoardReplyService.insertRequestBoardDeal(vo);
		requestBoardReplyService.updateRequestBoardState(vo);
		System.out.println(vo.getRequestNum());
		return "redirect:/requestboard/getRequestBoard.do?requestNum="+vo.getRequestNum();
	}
}