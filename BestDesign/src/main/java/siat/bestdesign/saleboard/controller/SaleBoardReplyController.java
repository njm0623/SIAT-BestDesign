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
	// 드로잉샵 댓글 추가 및 평점 갱신 컨트롤러
	public void saleBoardReply(SaleBoardReplyVO vo) {
		log.info("saleboard동작");
		System.out.println("saleboard동작");
		
		// 댓글 추가
		saleBoardReplyService.insertReply(vo);
		// 평점 갱신
		saleBoardReplyService.updateSaleBoardRate(vo);
	}
	
	@RequestMapping("reply.do")
	@ResponseBody
	// 드로잉샵 댓글 목록 불러오기 컨트롤러
	public List<SaleBoardReplyVO> saleBoardReplyList(String saleNum) {
		log.info("saleboard" + saleNum + "list동작");
		System.out.println("saleboardlist동작" + saleNum);
		
		// 댓글 목록 불러오기
		return saleBoardReplyService.selectAllReply(saleNum);
	}
	
	@RequestMapping("reply/delete.do")
	@ResponseBody
	// 드로잉샵 댓글 삭제 및 평점 갱신 컨트롤러
	public void saleBoardReplyDelete(SaleBoardReplyVO vo) {
		log.info("saleboard Delect동작");
		System.out.println("saleboardlist Delect동작");
		
		// 댓글 삭제
		saleBoardReplyService.deleteReply(vo);
		// 평점 갱신
		saleBoardReplyService.updateSaleBoardRate(vo);
	}
	
	@RequestMapping(value="reply/modify.do", produces="application/text; charset=utf8")
	@ResponseBody
	// 드로잉샵 댓글 수정 및 평점 갱신 컨트롤러
	public void saleBoardReplyModify(SaleBoardReplyVO vo) {
		log.info("saleboard Modify동작");
		System.out.println("saleboardlist Modify동작");
		
		// 댓글 수정
		saleBoardReplyService.modifyReply(vo);
		// 평점 갱신
		saleBoardReplyService.updateSaleBoardRate(vo);
	}
}
