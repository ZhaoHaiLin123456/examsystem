package cn.bean;

/**
 * 管理员信息
 */
public class Manager {
	/** 管理员编号 */
	private int managerId;
	/** 管理员姓名 */
	private String managerName;
	/** 管理员密码 */
	private String managerPassword;

	public Manager() {
		super();
	}

	public Manager(String managerName, String managerPassword) {
		super();
		this.managerName = managerName;
		this.managerPassword = managerPassword;
	}

	public int getManagerId() {
		return managerId;
	}

	public void setManagerId(int managerId) {
		this.managerId = managerId;
	}

	public String getManagerName() {
		return managerName;
	}

	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}

	public String getManagerPassword() {
		return managerPassword;
	}

	public void setManagerPassword(String managerPassword) {
		this.managerPassword = managerPassword;
	}

	@Override
	public String toString() {
		return "Manager [managerId=" + managerId + ", managerName=" + managerName + ", managerPassword="
				+ managerPassword + "]";
	}

}
