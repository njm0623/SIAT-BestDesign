package siat.bestdesign.designer.domain;

import siat.bestdesign.user.domain.UserVO;

public class DesignerVO extends UserVO{
	
	private String designerId;
	private String designerProfile;
	private String designerImage;
	private String designerNickName;
	
	
	public DesignerVO(){}


	public DesignerVO(String designerId, String designerProfile, String designerImage, String designerNickName) {
		super();
		this.designerId = designerId;
		this.designerProfile = designerProfile;
		this.designerImage = designerImage;
		this.designerNickName = designerNickName;
	}
	


	public DesignerVO(String userId, String userPwd, String userName, String userEmail, String userBirth,
			String userPhone, int userType) {
		super(userId, userPwd, userName, userEmail, userBirth, userPhone, userType);
		// TODO Auto-generated constructor stub
	}


	public String getDesignerId() {
		return designerId;
	}


	public void setDesignerId(String designerId) {
		this.designerId = designerId;
	}


	public String getDesignerProfile() {
		return designerProfile;
	}


	public void setDesignerProfile(String designerProfile) {
		this.designerProfile = designerProfile;
	}


	public String getDesignerImage() {
		return designerImage;
	}


	public void setDesignerImage(String designerImage) {
		this.designerImage = designerImage;
	}


	public String getDesignerNickName() {
		return designerNickName;
	}


	public void setDesignerNickName(String designerNickName) {
		this.designerNickName = designerNickName;
	}

	
	
}
