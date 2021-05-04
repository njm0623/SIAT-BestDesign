package siat.bestdesign.saleboard.domain;

public class SaleBoardVO {
	private int saleNum;
	private String designerId;
	private String saleTitle;
	private String saleContent;
	private String saleImage;
	private String saleDate;
	private int salePrice;
	private String saleCate;
	private int saleView;
	private double saleRate;
	private String designerNickname;
	
	public String getDesignerNickname() {
		return designerNickname;
	}
	public void setDesignerNickname(String designerNickname) {
		this.designerNickname = designerNickname;
	}
	public String getDesignerProfile() {
		return designerProfile;
	}
	public void setDesignerProfile(String designerProfile) {
		this.designerProfile = designerProfile;
	}
	private String designerProfile;
	
	public double getSaleRate() {
		return saleRate;
	}
	public void setSaleRate(double saleRate) {
		this.saleRate = saleRate;
	}
	public int getSaleNum() {
		return saleNum;
	}
	public void setSaleNum(int saleNum) {
		this.saleNum = saleNum;
	}
	public String getDesignerId() {
		return designerId;
	}
	public void setDesignerId(String designerId) {
		this.designerId = designerId;
	}
	public String getSaleTitle() {
		return saleTitle;
	}
	public void setSaleTitle(String saleTitle) {
		this.saleTitle = saleTitle;
	}
	public String getSaleContent() {
		return saleContent;
	}
	public void setSaleContent(String saleContent) {
		this.saleContent = saleContent;
	}
	public String getSaleImage() {
		return saleImage;
	}
	public void setSaleImage(String saleImage) {
		this.saleImage = saleImage;
	}
	public String getSaleDate() {
		return saleDate;
	}
	public void setSaleDate(String saleDate) {
		this.saleDate = saleDate;
	}
	public int getSalePrice() {
		return salePrice;
	}
	public void setSalePrice(int salePrice) {
		this.salePrice = salePrice;
	}
	public String getSaleCate() {
		return saleCate;
	}
	public void setSaleCate(String saleCate) {
		this.saleCate = saleCate;
	}
	public int getSaleView() {
		return SaleView;
	}
	public void setSaleView(int saleView) {
		SaleView = saleView;
	}
	
	
}
