package siat.bestdesign.main.domain;

public class MainVO {
	private String designerId;
	private String designerImage;
	private int dCount;
	private int saleNum;
	private String saleTitle;
	private String saleImage;
	private double saleRate;
	
	public MainVO() {}

	
	
	public MainVO(String designerId, String designerImage, int dCount, int saleNum, String saleTitle, String saleImage,
			double saleRate) {
		super();
		this.designerId = designerId;
		this.designerImage = designerImage;
		this.dCount = dCount;
		this.saleNum = saleNum;
		this.saleTitle = saleTitle;
		this.saleImage = saleImage;
		this.saleRate = saleRate;
	}


	public String getDesignerId() {
		return designerId;
	}

	public void setDesignerId(String designerId) {
		this.designerId = designerId;
	}

	public String getDesignerImage() {
		return designerImage;
	}

	public void setDesignerImage(String designerImage) {
		this.designerImage = designerImage;
	}

	public int getdCount() {
		return dCount;
	}

	public void setdCount(int dCount) {
		this.dCount = dCount;
	}


	public int getSaleNum() {
		return saleNum;
	}


	public void setSaleNum(int saleNum) {
		this.saleNum = saleNum;
	}


	public String getSaleTitle() {
		return saleTitle;
	}


	public void setSaleTitle(String saleTitle) {
		this.saleTitle = saleTitle;
	}


	public String getSaleImage() {
		return saleImage;
	}


	public void setSaleImage(String saleImage) {
		this.saleImage = saleImage;
	}


	public double getSaleRate() {
		return saleRate;
	}


	public void setSaleRate(double saleRate) {
		this.saleRate = saleRate;
	}


	
	

}
