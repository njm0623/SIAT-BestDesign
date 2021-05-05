package siat.bestdesign.designer.domain;

public class DesignerCartVO {
	
	private int cartNum;
	private String userId;
	private String designerId;
	
	public DesignerCartVO() {}
	
	public DesignerCartVO(int cartNum, String userId, String designerId) {
		super();
		this.cartNum = cartNum;
		this.userId = userId;
		this.designerId = designerId;
	}

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

	public String getDesignerId() {
		return designerId;
	}

	public void setDesignerId(String designerId) {
		this.designerId = designerId;
	}
	
	

}
