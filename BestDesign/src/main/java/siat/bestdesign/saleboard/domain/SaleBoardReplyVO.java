package siat.bestdesign.saleboard.domain;

public class SaleBoardReplyVO {
	private int reviewNum;		// 드로잉샵 리뷰 번호
	private int saleNum;		// 드로잉샵 게시글 번호
	private String userId;		// 드로잉샵 리뷰 등록 유저 아이디
	private String reviewDate;	// 드로잉샵 리뷰 등록 날짜
	private int reviewRate;		// 드로잉샵 리뷰 평점
	private String reviewComment;	// 드로잉샵 리뷰 내용
	
	public int getReviewNum() {
		return reviewNum;
	}
	public void setReviewNum(int reviewNum) {
		this.reviewNum = reviewNum;
	}
	public int getSaleNum() {
		return saleNum;
	}
	public void setSaleNum(int saleNum) {
		this.saleNum = saleNum;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getReviewDate() {
		return reviewDate;
	}
	public void setReviewDate(String reviewDate) {
		this.reviewDate = reviewDate;
	}
	public int getReviewRate() {
		return reviewRate;
	}
	public void setReviewRate(int reviewRate) {
		this.reviewRate = reviewRate;
	}
	public String getReviewComment() {
		return reviewComment;
	}
	public void setReviewComment(String reviewComment) {
		this.reviewComment = reviewComment;
	}
}
