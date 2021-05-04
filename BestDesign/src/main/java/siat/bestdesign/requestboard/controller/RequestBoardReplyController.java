package siat.bestdesign.requestboard.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import siat.bestdesign.chat.domain.ChatVO;
import siat.bestdesign.chat.service.ChatService;
import siat.bestdesign.requestboard.domain.RequestBoardDealVO;
import siat.bestdesign.requestboard.domain.RequestBoardReplyVO;
import siat.bestdesign.requestboard.service.RequestBoardReplyService;

@Controller
@RequestMapping("requestboard")
public class RequestBoardReplyController {
	@Autowired
	private RequestBoardReplyService requestBoardReplyService;
	
	@Autowired
	ChatService chatService;
	
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
		ChatVO chatvo1 = new ChatVO();
		chatvo1.setChatFromId("manager1");
		chatvo1.setChatToId(vo.getDealBuyerId());
		chatvo1.setChatContent("'" + vo.getRequestTitle() + "'" + " 에 대한 '" + vo.getDealSellerId() + "'님의 댓글에 수락하셨습니다.");
		chatService.insertChat(chatvo1);		
		
		ChatVO chatvo2 = new ChatVO();
		chatvo2.setChatFromId("manager1");
		chatvo2.setChatToId(vo.getDealSellerId());
		chatvo2.setChatContent(vo.getDealBuyerId() + " 님께서  '" + vo.getRequestTitle() + "' 의뢰를 요청하셨습니다.");
		chatService.insertChat(chatvo2);
		
		requestBoardReplyService.insertRequestBoardDeal(vo);
		requestBoardReplyService.updateRequestBoardState(vo);
		
		return "redirect:/requestboard/getRequestBoard.do?requestNum="+vo.getRequestNum();
	}
}