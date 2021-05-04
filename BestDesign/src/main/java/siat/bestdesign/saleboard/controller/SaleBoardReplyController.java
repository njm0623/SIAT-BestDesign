package siat.bestdesign.saleboard.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import siat.bestdesign.saleboard.domain.SaleBoardDealVO;
import siat.bestdesign.saleboard.domain.SaleBoardReplyVO;
import siat.bestdesign.saleboard.service.SaleBoardReplyService;

@Controller
@RequestMapping("saleboard")
public class SaleBoardReplyController {
	@Autowired
	private SaleBoardReplyService saleBoardReplyService;
	
	@RequestMapping(value="reply/new.do", produces="application/text; charset=utf8")
	@ResponseBody
	public void saleBoardReply(SaleBoardReplyVO vo) {
		saleBoardReplyService.insertReply(vo);
		saleBoardReplyService.updateSaleBoardRate(vo);
	}
	
	@RequestMapping("reply.do")
	@ResponseBody
	public List<SaleBoardReplyVO> saleBoardReplyList(String saleNum) {
		return saleBoardReplyService.selectAllReply(saleNum);
	}
	
	@RequestMapping("reply/delete.do")
	@ResponseBody
	public void saleBoardReplyDelete(SaleBoardReplyVO vo) {
		saleBoardReplyService.deleteReply(vo);
		saleBoardReplyService.updateSaleBoardRate(vo);
	}
	
	@RequestMapping(value="reply/modify.do", produces="application/text; charset=utf8")
	@ResponseBody
	public void saleBoardReplyModify(SaleBoardReplyVO vo) {
		saleBoardReplyService.modifyReply(vo);
		saleBoardReplyService.updateSaleBoardRate(vo);
	}
}
