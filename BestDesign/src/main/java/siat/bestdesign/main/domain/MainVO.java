package siat.bestdesign.main.domain;

public class MainVO {
	private String designerId;
	private String designerImage;
	private int dCount;
	
	public MainVO() {}
	
	public MainVO(String designerId, String designerImage, int dCount) {
		super();
		this.designerId = designerId;
		this.designerImage = designerImage;
		this.dCount = dCount;
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
	
	

}
