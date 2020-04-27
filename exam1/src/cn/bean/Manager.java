package cn.bean;

/**
 * ����Ա��Ϣ
 */
public class Manager {
	/** ����Ա��� */
	private int managerId;
	/** ����Ա���� */
	private String managerName;
	/** ����Ա���� */
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
