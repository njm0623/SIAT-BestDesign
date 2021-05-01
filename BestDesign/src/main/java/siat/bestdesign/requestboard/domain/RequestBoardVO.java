package siat.bestdesign.requestboard.domain;

public class RequestBoardVO {
	private int requestNum;
	private String userId;
	private String requestTitle;
	private String requestContent;
	private String requestDate;
	private int requestState;
	private String requestImage;
	private int requestView;
	
	public int getRequestView() {
		return requestView;
	}
	public void setRequestView(int requestView) {
		this.requestView = requestView;
	}
	public int getRequestNum() {
		return requestNum;
	}
	public void setRequestNum(int requestNum) {
		this.requestNum = requestNum;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getRequestTitle() {
		return requestTitle;
	}
	public void setRequestTitle(String requestTitle) {
		this.requestTitle = requestTitle;
	}
	public String getRequestContent() {
		return requestContent;
	}
	public void setRequestContent(String requestContent) {
		this.requestContent = requestContent;
	}
	public String getRequestDate() {
		return requestDate;
	}
	public void setRequestDate(String requestDate) {
		this.requestDate = requestDate;
	}
	public int getRequestState() {
		return requestState;
	}
	public void setRequestState(int requestState) {
		this.requestState = requestState;
	}
	public String getRequestImage() {
		return requestImage;
	}
	public void setRequestImage(String requestImage) {
		this.requestImage = requestImage;
	}
}
