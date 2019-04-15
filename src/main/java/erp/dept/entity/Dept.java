package erp.dept.entity;

import java.io.Serializable;

public class Dept implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer deptNo;
	private String deptName;
	private String local;
	private String deptleader;
	private String note;
	private String createdTime;
	private String modifiedTime;
	private String createdUser;
	private String modifiedUser;
	public Integer getDeptNo() {
		return deptNo;
	}
	public void setDeptNo(Integer deptNo) {
		this.deptNo = deptNo;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public String getLocal() {
		return local;
	}
	public void setLocal(String local) {
		this.local = local;
	}
	public String getDeptleader() {
		return deptleader;
	}
	public void setDeptleader(String deptleader) {
		this.deptleader = deptleader;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public String getCreatedTime() {
		return createdTime;
	}
	public void setCreatedTime(String createdTime) {
		this.createdTime = createdTime;
	}
	public String getModifiedTime() {
		return modifiedTime;
	}
	public void setModifiedTime(String modifiedTime) {
		this.modifiedTime = modifiedTime;
	}
	public String getCreatedUser() {
		return createdUser;
	}
	public void setCreatedUser(String createdUser) {
		this.createdUser = createdUser;
	}
	public String getModifiedUser() {
		return modifiedUser;
	}
	public void setModifiedUser(String modifiedUser) {
		this.modifiedUser = modifiedUser;
	}
	@Override
	public String toString() {
		return "Dept [deptNo=" + deptNo + ", deptName=" + deptName + ", local=" + local + ", deptleader=" + deptleader
				+ ", note=" + note + ", createdTime=" + createdTime + ", modifiedTime=" + modifiedTime
				+ ", createdUser=" + createdUser + ", modifiedUser=" + modifiedUser + "]";
	}
	
	
	
	
}
