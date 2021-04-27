package com.editor.Controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.editor.VO.PhotoVo;

@Controller
public class EditorController {
	@RequestMapping("resources/editor/photo_uploader/popup/photoUpload")
	public String photoUpload(HttpServletRequest request, HttpServletResponse response, PhotoVo vo){
		System.out.println("단일 파일 업로드 컨트롤러 호출");
		String return1=request.getParameter("callback");
		String return2="?callback_func=" + request.getParameter("callback_func");
		String return3="";
		String name = "";
		
		System.out.println("callback: " + request.getParameter("callback"));
		System.out.println("callback_func: " + request.getParameter("callback_func"));
		
		try {
			if(vo.getFiledata() != null && vo.getFiledata().getOriginalFilename() != null && !vo.getFiledata().getOriginalFilename().equals("")) {
				// 기존 상단 코드를 막고 하단코드를 이용
				name = vo.getFiledata().getOriginalFilename().substring(vo.getFiledata().getOriginalFilename().lastIndexOf(File.separator)+1);
				System.out.println("name : " + name);
				String filename_ext = name.substring(name.lastIndexOf(".")+1);
				filename_ext = filename_ext.toLowerCase();
				String[] allow_file = {"jpg","png","bmp","gif"};
				int cnt = 0;
				for(int i=0; i<allow_file.length; i++) {
					if(filename_ext.equals(allow_file[i])) {
						cnt++;
					}
				}
				if(cnt == 0) {
					return3 = "&errstr="+name;
				}
				else {
					//파일 기본경로
					String dftFilePath = request.getSession().getServletContext().getRealPath("/");
					//파일 기본경로 _ 상세경로
					String filePath = dftFilePath + "resources"+ File.separator + "photo_upload" + File.separator;
					File file = new File(filePath);
					System.out.println("path: " + file);
					if(!file.exists()) {
						file.mkdirs();
					}
					String realFileNm = "";
					SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
					String today= formatter.format(new java.util.Date());
					realFileNm = today+UUID.randomUUID().toString() + name.substring(name.lastIndexOf("."));
					String rlFileNm = filePath + realFileNm;
					///////////////// 서버에 파일쓰기 /////////////////
					vo.getFiledata().transferTo(new File(rlFileNm));
					///////////////// 서버에 파일쓰기 /////////////////
					return3 += "&bNewLine=true";
					return3 += "&sFileName="+ name;
					return3 += "&sFileURL=resources/photo_upload/"+realFileNm;
					System.out.println("return3 : " + return3);
				}
			}
			else {
				return3 += "&errstr=error";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("return1+return2+return3: " + return1+return2+return3);
		return "redirect:"+return1+return2+return3;
	}

	@RequestMapping("multiplePhotoUpload")
	public void multiplePhotoUpload(HttpServletRequest request, HttpServletResponse response){
		System.out.println("멀티 업로드 컨트롤러");
		try {
			 //파일정보
			 String sFileInfo = "";
			 //파일명을 받는다 - 일반 원본파일명
			 String filename = request.getHeader("file-name");
			 //파일 확장자
			 String filename_ext = filename.substring(filename.lastIndexOf(".")+1);
			 //확장자를소문자로 변경
			 filename_ext = filename_ext.toLowerCase();
			 //파일 기본경로
			 String dftFilePath = request.getSession().getServletContext().getRealPath("/");
			 //파일 기본경로 _ 상세경로
			 String filePath = dftFilePath + "resources" + File.separator + "photo_upload" + File.separator;
			 File file = new File(filePath);
			 if(!file.exists()) {
			 	file.mkdirs();
			 }
			 String realFileNm = "";
			 SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
			 String today= formatter.format(new java.util.Date());
			 realFileNm = today+UUID.randomUUID().toString() + filename.substring(filename.lastIndexOf("."));
			 String rlFileNm = filePath + realFileNm;
			 ///////////////// 서버에 파일쓰기 ///////////////// 
			 InputStream is = request.getInputStream();
			 OutputStream os=new FileOutputStream(rlFileNm);
			 int numRead;
			 byte b[] = new byte[Integer.parseInt(request.getHeader("file-size"))];
			 while((numRead = is.read(b,0,b.length)) != -1){
			 	os.write(b,0,numRead);
			 }
			 if(is != null) {
			 	is.close();
			 }
			 os.flush();
			 os.close();
			 ///////////////// 서버에 파일쓰기 /////////////////
			 // 정보 출력
			 sFileInfo += "&bNewLine=true";
			 // img 태그의 title 속성을 원본파일명으로 적용시켜주기 위함
			 sFileInfo += "&sFileName="+ filename;;
			 sFileInfo += "&sFileURL=/resources/photo_upload/"+realFileNm;
			 PrintWriter print = response.getWriter();
			 print.print(sFileInfo);
			 print.flush();
			 print.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping("board")
	public void getBoard(HttpServletRequest request, Model m) throws Exception {
		m.addAttribute("message", request.getParameter("content"));
	}
}
