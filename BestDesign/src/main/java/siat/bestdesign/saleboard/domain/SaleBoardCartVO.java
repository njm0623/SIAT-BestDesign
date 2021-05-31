package siat.bestdesign.saleboard.domain;

public class SaleBoardCartVO {
	private int cartNum;	// 드로잉샵 찜 번호
	private String userId;	// 드로잉샵 찜 유저 아이디
	private int saleNum;	// 드로잉샵 게시글 번호
	
	public int getCartNum() {
		return cartNum;
	}
	public void setCartNum(int cartNum) {
		this.cartNum = cartNum;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public int getSaleNum() {
		return saleNum;
	}
	public void setSaleNum(int saleNum) {
		this.saleNum = saleNum;
	}
}
