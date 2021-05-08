package siat.bestdesign.saleboard.domain;

public class SaleBoardDealVO {
	private int dealNum;		// 드로잉샵 거래 번호
	private int saleNum;		// 드로잉샵 게시글 번호
	private String saleTitle;	// 드로잉샵 게시글 제목
	private String dealBuyerId;	// 드로잉샵 구매자 아이디
	private String dealSellerId;	// 드로잉샵 판매자 아이디
	private int dealPrice;		// 드로잉샵 거래 가격
	private String dealDate;	// 드로잉샵 거래 날짜
	private String dealImage;	// 드로잉샵 거래 
	
	public String getSaleTitle() {
		return saleTitle;
	}
	public void setSaleTitle(String saleTitle) {
		this.saleTitle = saleTitle;
	}
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
