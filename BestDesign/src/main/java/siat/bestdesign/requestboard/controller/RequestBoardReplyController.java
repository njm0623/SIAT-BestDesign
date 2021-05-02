package siat.bestdesign.requestboard.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import siat.bestdesign.requestboard.domain.RequestBoardReplyVO;
import siat.bestdesign.requestboard.service.RequestBoardReplyService;

@RestController
@RequestMapping("requestboard")
public class RequestBoardReplyController {
	@Autowired
	private RequestBoardReplyService requestBoardReplyService;
	
	@RequestMapping(value="reply/new.do", produces="application/text; charset=utf8")
	public void requestBoardReply(RequestBoardReplyVO vo) {
		requestBoardReplyService.insertReply(vo);
	}
	
	@RequestMapping("reply.do")
	public List<RequestBoardReplyVO> requestBoardReplyList(String requestNum) {
		return requestBoardReplyService.selectAllReply(requestNum);
	}
	
	@RequestMapping("reply/delete.do")
	public void requestBoardReplyDelete(String auctionNum) {
		requestBoardReplyService.deleteReply(auctionNum);
	}
	
	@RequestMapping(value="reply/modify.do", produces="application/text; charset=utf8")
	@ResponseBody
	public void requestBoardReplyModify(RequestBoardReplyVO vo) {
		System.out.println("댓글 수정 컨트롤러 호출");
		requestBoardReplyService.modifyReply(vo);
	}
}
