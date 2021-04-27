package siat.bestdesign.customer.domain;

public class CustomerVO {
	
	private String customerId;
	private String customerPwd;
	private String customerName;
	private String customerEmail;
	private String customerBirth;
	private String customerPhone;
	
	public CustomerVO() {}
	
	public CustomerVO(String customerId, String customerPwd, String customerName, String customerEmail,
			String customerBirth, String customerPhone) {
		super();
		this.customerId = customerId;
		this.customerPwd = customerPwd;
		this.customerName = customerName;
		this.customerEmail = customerEmail;
		this.customerBirth = customerBirth;
		this.customerPhone = customerPhone;
	}
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public String getCustomerPwd() {
		return customerPwd;
	}
	public void setCustomerPwd(String customerPwd) {
		this.customerPwd = customerPwd;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getCustomerEmail() {
		return customerEmail;
	}
	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}
	public String getCustomerBirth() {
		return customerBirth;
	}
	public void setCustomerBirth(String customerBirth) {
		this.customerBirth = customerBirth;
	}
	public String getCustomerPhone() {
		return customerPhone;
	}
	public void setCustomerPhone(String customerPhone) {
		this.customerPhone = customerPhone;
	}

}
