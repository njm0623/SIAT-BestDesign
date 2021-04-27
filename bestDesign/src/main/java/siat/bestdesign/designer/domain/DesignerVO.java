package siat.bestdesign.designer.domain;

public class DesignerVO {
	
	private String designerId;
	private String designerPwd;
	private String designerName;
	private String designerEmail;
	private String designerBirth;
	private String designerPhone;
	private String designerProfile;
	private String designerImage;
	private String designerNickName;
	
	
	public DesignerVO(){}
	public DesignerVO(String designerId, String designerPwd, String designerName, String designerEmail,
			String designerBirth, String designerPhone) {
		super();
		this.designerId = designerId;
		this.designerPwd = designerPwd;
		this.designerName = designerName;
		this.designerEmail = designerEmail;
		this.designerBirth = designerBirth;
		this.designerPhone = designerPhone;
	}
	public DesignerVO(String designerId, String designerPwd, String designerName, String designerEmail,
			String designerBirth, String designerPhone, String designerProfile, String designerImage,
			String designerNickName) {
		super();
		this.designerId = designerId;
		this.designerPwd = designerPwd;
		this.designerName = designerName;
		this.designerEmail = designerEmail;
		this.designerBirth = designerBirth;
		this.designerPhone = designerPhone;
		this.designerProfile = designerProfile;
		this.designerImage = designerImage;
		this.designerNickName = designerNickName;
	}
	public String getDesignerId() {
		return designerId;
	}
	public void setDesignerId(String designerId) {
		this.designerId = designerId;
	}
	public String getDesignerPwd() {
		return designerPwd;
	}
	public void setDesignerPwd(String designerPwd) {
		this.designerPwd = designerPwd;
	}
	public String getDesignerName() {
		return designerName;
	}
	public void setDesignerName(String designerName) {
		this.designerName = designerName;
	}
	public String getDesignerEmail() {
		return designerEmail;
	}
	public void setDesignerEmail(String designerEmail) {
		this.designerEmail = designerEmail;
	}
	public String getDesignerBirth() {
		return designerBirth;
	}
	public void setDesignerBirth(String designerBirth) {
		this.designerBirth = designerBirth;
	}
	public String getDesignerPhone() {
		return designerPhone;
	}
	public void setDesignerPhone(String designerPhone) {
		this.designerPhone = designerPhone;
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
