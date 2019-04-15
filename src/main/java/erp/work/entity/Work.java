package erp.work.entity;

import java.io.Serializable;

public class Work implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer workmonth;
	private Integer employeeID;
	private double workdays;
	private double traveldays;
	private double adddays;
	private String attribute;
	private String attribute1;
	private String attribute2;
	private String attribute3;
	private String attribute4;
	private String deptleader;
	private String note;
	private String createdTime;
	private String modifiedTime;
	private String createdUser;
	private String modifiedUser;
	public Integer getWorkmonth() {
		return workmonth;
	}
	public void setWorkmonth(Integer workmonth) {
		this.workmonth = workmonth;
	}
	public Integer getEmployeeID() {
		return employeeID;
	}
	public void setEmployeeID(Integer employeeID) {
		this.employeeID = employeeID;
	}
	public double getWorkdays() {
		return workdays;
	}
	public void setWorkdays(double workdays) {
		this.workdays = workdays;
	}
	public double getTraveldays() {
		return traveldays;
	}
	public void setTraveldays(double traveldays) {
		this.traveldays = traveldays;
	}
	public double getAdddays() {
		return adddays;
	}
	public void setAdddays(double adddays) {
		this.adddays = adddays;
	}
	public String getAttribute() {
		return attribute;
	}
	public void setAttribute(String attribute) {
		this.attribute = attribute;
	}
	public String getAttribute1() {
		return attribute1;
	}
	public void setAttribute1(String attribute1) {
		this.attribute1 = attribute1;
	}
	public String getAttribute2() {
		return attribute2;
	}
	public void setAttribute2(String attribute2) {
		this.attribute2 = attribute2;
	}
	public String getAttribute3() {
		return attribute3;
	}
	public void setAttribute3(String attribute3) {
		this.attribute3 = attribute3;
	}
	public String getAttribute4() {
		return attribute4;
	}
	public void setAttribute4(String attribute4) {
		this.attribute4 = attribute4;
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
		return "Work [workmonth=" + workmonth + ", employeeID=" + employeeID + ", workdays=" + workdays
				+ ", traveldays=" + traveldays + ", adddays=" + adddays + ", attribute=" + attribute + ", attribute1="
				+ attribute1 + ", attribute2=" + attribute2 + ", attribute3=" + attribute3 + ", attribute4="
				+ attribute4 + ", deptleader=" + deptleader + ", note=" + note + ", createdTime=" + createdTime
				+ ", modifiedTime=" + modifiedTime + ", createdUser=" + createdUser + ", modifiedUser=" + modifiedUser
				+ "]";
	}
	
	
	
}
