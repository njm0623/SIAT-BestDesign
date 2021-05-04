package siat.bestdesign.saleboard.domain;

public class SaleBoardDealVO {
	private int dealNum;
	private int saleNum;
	private String dealBuyerId;
	private String dealSellerId;
	private int dealPrice;
	private String dealDate;
	private String dealImage;
	
	public int getDealNum() {
		return dealNum;
	}
	public void setDealNum(int dealNum) {
		this.dealNum = dealNum;
	}
	public int getSaleNum() {
		return saleNum;
	}
	public void setSaleNum(int saleNum) {
		this.saleNum = saleNum;
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
