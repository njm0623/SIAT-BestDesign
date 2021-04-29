package siat.bestdesign.contactboard.controller;

import java.text.DecimalFormat;
import java.util.Date;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import siat.bestdesign.contactboard.domain.ContactVO;
import siat.bestdesign.contactboard.service.ContactService;

@Controller
@RequestMapping("contactboard")
public class ContactBoardController {
	
	@Autowired
	ContactService contactService;
	
	@RequestMapping("/{step}.do")
	public String viewPage(@PathVariable String step) {
		System.out.println("자신 반환하는 모든 동작 : " + step);
		return "contactboard/"+step;
	}
	
	@RequestMapping("boardList.do")
	public void boardList(Model m, String firstRow, String endRow) {
		System.out.println("contactboard 에서 boardList.do");
		if(firstRow==null) {
			firstRow="1";
			endRow="10";
		}
		HashMap map = new HashMap();
		map.put("first", Integer.parseInt(firstRow));
		map.put("end", Integer.parseInt(endRow));
		m.addAttribute("boardList",contactService.getContactBoardList(map));
		m.addAttribute("perPage",contactService.getTotalPage());
	}
	
	@RequestMapping("BoardSave.do")
	public String boardSave(ContactVO vo) {
		System.out.println("contactboard에서 boardsave.do");
		vo.setContactGroupNum(contactService.getGroupId());
		DecimalFormat dformat = new DecimalFormat("0000000000");
		vo.setContactSeqNum(dformat.format(vo.getContactGroupNum())+"999999");
		contactService.insertContact(vo);
		return "redirect:/contactboard/boardList.do";
	}
	
	@RequestMapping("BoardView.do")
	public void boardView(Model m, int contactNum) {
		System.out.println("contactboard에서 boardView.do");
		m.addAttribute("rec",contactService.selectById(contactNum));
		contactService.updateCount(contactNum);
	}
	
	@RequestMapping("BoardReply.do")
	public String BoardReplyForm(int parentId, ContactVO vo) {
		System.out.println("contactboard에서 BoardRepy");		
		ContactVO parent = contactService.selectById(parentId);
		String maxSeqNum = parent.getContactSeqNum();
		String minSeqNum = contactService.getSearchMinSeqNum(parent);
		String lastChildSeq = contactService.selectLastSequenceNumber( maxSeqNum, minSeqNum );
		String sequenceNumber = contactService.getSequenceNumber( parent,lastChildSeq);
		vo.setContactGroupNum(parent.getContactGroupNum());
		vo.setContactSeqNum(sequenceNumber);
		vo.setContactDate((new Date()).toString());
		contactService.insertContact(vo);
		return "redirect:/contactboard/boardList.do";
	}

}
