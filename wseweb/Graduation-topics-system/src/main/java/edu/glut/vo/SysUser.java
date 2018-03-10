package edu.glut.vo;

public class SysUser {
	int usrId; // --主键
	String usrName; // --用户名
	String usrPassword;// --密码
	int usrFlag;// --用户备注
	int usrRoleId;// --角色(0：系统管理员，1：销售主管，2：客户经理，3：总经理，5:普通员工)

	public SysUser() {
		super();
	}

	public SysUser(int usrId, String usrName, String usrPassword, int usrFlag,
			int usrRoleId) {
		super();
		this.usrId = usrId;
		this.usrName = usrName;
		this.usrPassword = usrPassword;
		this.usrFlag = usrFlag;
		this.usrRoleId = usrRoleId;
	}

	public int getUsrId() {
		return usrId;
	}

	public void setUsrId(int usrId) {
		this.usrId = usrId;
	}

	public String getUsrName() {
		return usrName;
	}

	public void setUsrName(String usrName) {
		this.usrName = usrName;
	}

	public String getUsrPassword() {
		return usrPassword;
	}

	public void setUsrPassword(String usrPassword) {
		this.usrPassword = usrPassword;
	}

	public int getUsrFlag() {
		return usrFlag;
	}

	public void setUsrFlag(int usrFlag) {
		this.usrFlag = usrFlag;
	}

	public int getUsrRoleId() {
		return usrRoleId;
	}

	public void setUsrRoleId(int usrRoleId) {
		this.usrRoleId = usrRoleId;
	}

	@Override
	public String toString() {
		return "SysUser [usrId=" + usrId + ", usrName=" + usrName
				+ ", usrPassword=" + usrPassword + ", usrFlag=" + usrFlag
				+ ", usrRoleId=" + usrRoleId + "]";
	}

}
