package siat.bestdesign.manager.domain;

public class ManagerVO {
	
	private String managerId;
	private String managerPwd;
	private String managerName;
	
	public ManagerVO() {}
	
	
	public ManagerVO(String managerId, String managerPwd, String managerName) {
		super();
		this.managerId = managerId;
		this.managerPwd = managerPwd;
		this.managerName = managerName;
	}

	public String getManagerId() {
		return managerId;
	}
	public void setManagerId(String managerId) {
		this.managerId = managerId;
	}
	public String getManagerPwd() {
		return managerPwd;
	}
	public void setManagerPwd(String managerPwd) {
		this.managerPwd = managerPwd;
	}
	public String getManagerName() {
		return managerName;
	}
	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}
}
