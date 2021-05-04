package siat.bestdesign.requestboard.domain;

public class RequestBoardDealVO {
	private int dealNum;
	private int requestNum;
	private String requestTitle;
	private String dealBuyerId;
	private String dealSellerId;
	private int dealPrice;
	private String dealDate;
	private String dealImage;
	
	public String getRequestTitle() {
		return requestTitle;
	}
	public void setRequestTitle(String requestTitle) {
		this.requestTitle = requestTitle;
	}
	public int getDealNum() {
		return dealNum;
	}
	public void setDealNum(int dealNum) {
		this.dealNum = dealNum;
	}
	public int getRequestNum() {
		return requestNum;
	}
	public void setRequestNum(int requestNum) {
		this.requestNum = requestNum;
	}
	public String getDealBuyerId() {
		return dealBuyerId;
	}
	public void setDealBuyerId(String dealBuyerId) {
		this.dealBuyerId = dealBuyerId;
	}
	public String getDealSellerId() {
		return dealSellerId;
	}
	public void setDealSellerId(String dealSellerId) {
		this.dealSellerId = dealSellerId;
	}
	public int getDealPrice() {
		return dealPrice;
	}
	public void setDealPrice(int dealPrice) {
		this.dealPrice = dealPrice;
	}
	public String getDealDate() {
		return dealDate;
	}
	public void setDealDate(String dealDate) {
		this.dealDate = dealDate;
	}
	public String getDealImage() {
		return dealImage;
	}
	public void setDealImage(String dealImage) {
		this.dealImage = dealImage;
	}
}
