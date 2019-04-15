package erp.apply.entity;

import java.io.Serializable;

/**
 * @author amarsoft
 *
 */
public class Apply implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer applyno;
	private Integer employeeID;
	private String applytype;
	private String applytime;
	private String applystatus;
	private String applyman;
	private String applycontent;
	private String attribute;
	private String attribute1;
	private String note;
	private String createdTime;
	private String modifiedTime;
	private String createdUser;
	private String modifiedUser;
	public Integer getApplyno() {
		return applyno;
	}
	public void setApplyno(Integer applyno) {
		this.applyno = applyno;
	}
	public Integer getEmployeeID() {
		return employeeID;
	}
	public void setEmployeeID(Integer employeeID) {
		this.employeeID = employeeID;
	}
	public String getApplytype() {
		return applytype;
	}
	public void setApplytype(String applytype) {
		this.applytype = applytype;
	}
	public String getApplytime() {
		return applytime;
	}
	public void setApplytime(String applytime) {
		this.applytime = applytime;
	}
	public String getApplystatus() {
		return applystatus;
	}
	public void setApplystatus(String applystatus) {
		this.applystatus = applystatus;
	}
	
	public String getApplyman() {
		return applyman;
	}
	public void setApplyman(String applyman) {
		this.applyman = applyman;
	}
	public String getApplycontent() {
		return applycontent;
	}
	public void setApplycontent(String applycontent) {
		this.applycontent = applycontent;
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
		return "Apply [applyno=" + applyno + ", employeeID=" + employeeID + ", applytype=" + applytype + ", applytime="
				+ applytime + ", applystatus=" + applystatus + ", applyman=" + applyman + ", applycontent="
				+ applycontent + ", attribute=" + attribute + ", attribute1=" + attribute1 + ", note=" + note
				+ ", createdTime=" + createdTime + ", modifiedTime=" + modifiedTime + ", createdUser=" + createdUser
				+ ", modifiedUser=" + modifiedUser + "]";
	}
	
	
	
}
