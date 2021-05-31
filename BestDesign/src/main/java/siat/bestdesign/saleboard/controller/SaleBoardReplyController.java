package siat.bestdesign.saleboard.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import siat.bestdesign.manager.controller.ManagerCotroller;
import siat.bestdesign.saleboard.domain.SaleBoardDealVO;
import siat.bestdesign.saleboard.domain.SaleBoardReplyVO;
import siat.bestdesign.saleboard.service.SaleBoardReplyService;

@Controller
@RequestMapping("saleboard")
public class SaleBoardReplyController {

	private Logger log = LoggerFactory.getLogger(ManagerCotroller.class);

	@Autowired
	private SaleBoardReplyService saleBoardReplyService;
	
	@RequestMapping(value="reply/new.do", produces="application/text; charset=utf8")
	@ResponseBody
	public void saleBoardReply(SaleBoardReplyVO vo) {
		log.info("saleboard동작");
		System.out.println("saleboard동작");
	
		saleBoardReplyService.insertReply(vo);
		saleBoardReplyService.updateSaleBoardRate(vo);
	}
	
	@RequestMapping("reply.do")
	@ResponseBody
	public List<SaleBoardReplyVO> saleBoardReplyList(String saleNum) {
		log.info("saleboard" + saleNum + "list동작");
		System.out.println("saleboardlist동작" + saleNum);
	
		return saleBoardReplyService.selectAllReply(saleNum);
	}
	
	@RequestMapping("reply/delete.do")
	@ResponseBody
	public void saleBoardReplyDelete(SaleBoardReplyVO vo) {
		log.info("saleboard Delect동작");
		System.out.println("saleboardlist Delect동작");
		
		saleBoardReplyService.deleteReply(vo);
		saleBoardReplyService.updateSaleBoardRate(vo);
	}
	
	@RequestMapping(value="reply/modify.do", produces="application/text; charset=utf8")
	@ResponseBody
	public void saleBoardReplyModify(SaleBoardReplyVO vo) {
		log.info("saleboard Modify동작");
		System.out.println("saleboardlist Modify동작");
		
		saleBoardReplyService.modifyReply(vo);
		saleBoardReplyService.updateSaleBoardRate(vo);
	}
}
