package siat.bestdesign.contactboard.controller;

import java.text.DecimalFormat;
import java.util.Date;
import java.util.HashMap;

import javax.xml.ws.RequestWrapper;

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
	public void boardList(Model m, String firstRow, String endRow, String menu, String search) {
		System.out.println("contactboard 에서 boardList.do");
		if(firstRow==null) {
			firstRow="1";
			endRow="10";
		}
		HashMap map = new HashMap();
		map.put("first", Integer.parseInt(firstRow));
		map.put("end", Integer.parseInt(endRow));
		if(menu!=null && search!=null) {
			map.put("key", menu);
			map.put("val", search);
			m.addAttribute("menu",menu);
			m.addAttribute("search",search);			
		}
		m.addAttribute("boardList",contactService.getContactBoardList(map));
		m.addAttribute("perPage",contactService.getTotalPage(map));
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
		contactService.updateCount(contactNum);
		m.addAttribute("rec",contactService.selectByIdView(contactNum));
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
	
	@RequestMapping("BoardModifyForm.do")
	public void boardModifyForm(Model m, int contactNum) {
		System.out.println("contactboard에서 BoardModifyForm");
		m.addAttribute("list", contactService.selectById(contactNum));
	}
	@RequestMapping("BoardModify.do")
	public String boardModify(ContactVO vo) {
		System.out.println("contactboard에서 BoardModify");		
		contactService.boardModify(vo);
		return "redirect:/contactboard/boardList.do";
	}
	@RequestMapping("BoardDelete.do")
	public String boardDelete(int contactNum) {
		System.out.println("contactboard에서 BoardDelete");		
		contactService.boardDelete(contactNum);
		return "redirect:/contactboard/boardList.do";
	}

}
