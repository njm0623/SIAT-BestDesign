package siat.bestdesign.manager.domain;

public class RequestChartVO {

	private int year;
	private int month; 
	private int amount;
	private int writecnt;
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		this.month = month;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public int getWritecnt() {
		return writecnt;
	}
	public void setWritecnt(int writecnt) {
		this.writecnt = writecnt;
	}
	public RequestChartVO() {}
	
	public RequestChartVO(int year, int month, int amount, int writecnt) {
		super();
		this.year = year;
		this.month = month;
		this.amount = amount;
		this.writecnt = writecnt;
	}
	@Override
	public String toString() {
		return "RequestChartVO [year=" + year + ", month=" + month + ", amount=" + amount + ", writecnt=" + writecnt
				+ "]";
	}
	
	
}
