package com.editor.VO;

import org.springframework.web.multipart.MultipartFile;

public class PhotoVo {
	private MultipartFile Filedata;
	
	public MultipartFile getFiledata() {
		return Filedata;
	}
	
	public void setFiledata(MultipartFile filedata) {
		Filedata = filedata;
	}

}