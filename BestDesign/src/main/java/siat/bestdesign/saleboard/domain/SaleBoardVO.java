package siat.bestdesign.saleboard.domain;

public class SaleBoardVO {
	private int saleNum;		// 드로잉샵 게시글 번호
	private String designerId;	// 드로잉샵 게시글 등록 디자이너 아이디
	private String saleTitle;	// 드로잉샵 게시글 제목
	private String saleContent;	// 드로잉샵 게시글 상세 내용
	private String saleImage;	// 드로잉샵 판매 이미지
	private String saleDate;	// 드로잉샵 게시글 등록 날짜
	private int salePrice;		// 드로잉샵 판매 가격
	private String saleCate;	// 드로잉샵 게시글 카테고리
	private int saleView;		// 드로잉샵 게시글 조회수
	private double saleRate;	// 드로잉샵 게시글 평점
	private String designerNickname;// 드로잉샵 게시글 등록 디자이너 닉네임
	
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
		return saleView;
	}
	public void setSaleView(int saleView) {
		this.saleView = saleView;
	}
	
}
