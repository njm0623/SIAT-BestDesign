package siat.bestdesign.requestboard.domain;

public class RequestBoardReplyVO {
	private int auctionNum;
	private int requestNum;
	private String userId;
	private int auctionPrice;
	private String auctionDate;
	private int auctionState;
	private String auctionComment;
	
	public int getAuctionNum() {
		return auctionNum;
	}
	public void setAuctionNum(int auctionNum) {
		this.auctionNum = auctionNum;
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
	public int getAuctionPrice() {
		return auctionPrice;
	}
	public void setAuctionPrice(int auctionPrice) {
		this.auctionPrice = auctionPrice;
	}
	public String getAuctionDate() {
		return auctionDate;
	}
	public void setAuctionDate(String auctionDate) {
		this.auctionDate = auctionDate;
	}
	public int getAuctionState() {
		return auctionState;
	}
	public void setAuctionState(int auctionState) {
		this.auctionState = auctionState;
	}
	public String getAuctionComment() {
		return auctionComment;
	}
	public void setAuctionComment(String auctionComment) {
		this.auctionComment = auctionComment;
	}
}