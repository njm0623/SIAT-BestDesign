package siat.bestdesign.contactboard.domain;

public class ContactVO {
	
	private int contactNum;
	private String userId;
	private String contactTitle;
	private String contactContent;
	private String contactDate;
	private String contactIsPublic;
	private String contactFile;
	private int contactGroupNum;
	private String contactSeqNum;
	private String contactCount;
	
	public ContactVO() {}
	
	
	public ContactVO(int contactNum, String userId, String contactTitle, String contactContent, String contactDate,
			String contactIsPublic, String contactFile, int contactGroupNum, String contactSeqNum,
			String contactCount) {
		super();
		this.contactNum = contactNum;
		this.userId = userId;
		this.contactTitle = contactTitle;
		this.contactContent = contactContent;
		this.contactDate = contactDate;
		this.contactIsPublic = contactIsPublic;
		this.contactFile = contactFile;
		this.contactGroupNum = contactGroupNum;
		this.contactSeqNum = contactSeqNum;
		this.contactCount = contactCount;
	}
	public int getContactNum() {
		return contactNum;
	}
	public void setContactNum(int contactNum) {
		this.contactNum = contactNum;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getContactTitle() {
		return contactTitle;
	}
	public void setContactTitle(String contactTitle) {
		this.contactTitle = contactTitle;
	}
	public String getContactContent() {
		return contactContent;
	}
	public void setContactContent(String contactContent) {
		this.contactContent = contactContent;
	}
	public String getContactDate() {
		return contactDate;
	}
	public void setContactDate(String contactDate) {
		this.contactDate = contactDate;
	}
	public String getContactIsPublic() {
		return contactIsPublic;
	}
	public void setContactIsPublic(String contactIsPublic) {
		this.contactIsPublic = contactIsPublic;
	}
	public String getContactFile() {
		return contactFile;
	}
	public void setContactFile(String contactFile) {
		this.contactFile = contactFile;
	}
	public int getContactGroupNum() {
		return contactGroupNum;
	}
	public void setContactGroupNum(int contactGroupNum) {
		this.contactGroupNum = contactGroupNum;
	}
	public String getContactSeqNum() {
		return contactSeqNum;
	}
	public void setContactSeqNum(String contactSeqNum) {
		this.contactSeqNum = contactSeqNum;
	}
	public String getContactCount() {
		return contactCount;
	}
	public void setContactCount(String contactCount) {
		this.contactCount = contactCount;
	}
	
	public int getLevel()
	{
		if( contactSeqNum == null			)	{ return -1; }
		if( contactSeqNum.length() != 16 	) 	{ return -1; }
		if( contactSeqNum.endsWith("999999")) 	{ return 0; }
		if( contactSeqNum.endsWith("9999")	) 	{ return 1; }
		if( contactSeqNum.endsWith("99")	) 	{ return 2; }
		return 3;
	}

}
