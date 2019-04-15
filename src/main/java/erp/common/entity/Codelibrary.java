package erp.common.entity;
import java.io.Serializable;


public class Codelibrary implements Serializable{
	private static final long serialVersionUID = 5850357988911265658L;
	
	

	private String codeno;
	/**员工名称*/
	private String itemno;
	/**身份证号*/
	private String itemname;
	/**性别*/
	private String isinuse;
	/**性别*/
	private String itemdescribe;
	/**职级*/
	private String itemattribute;
	
	private String relativecode;
	
	private String attribute1;
	
	private String attribute2;
	private String attribute3;
	private String attribute4;
	private String attribute5;
	private String attribute6;
	private String attribute7;
	private String attribute8;
	
	
	
	private String note;
	/**创建时间*/
	private String createdTime;
	/**修改时间*/
	private String modifiedTime;
	/**创建用户*/
	private String createdUser;
	/**修改用户*/
	private String modifiedUser;
	public String getCodeno() {
		return codeno;
	}
	public void setCodeno(String codeno) {
		this.codeno = codeno;
	}
	public String getItemno() {
		return itemno;
	}
	public void setItemno(String itemno) {
		this.itemno = itemno;
	}
	public String getItemname() {
		return itemname;
	}
	public void setItemname(String itemname) {
		this.itemname = itemname;
	}
	public String getIsinuse() {
		return isinuse;
	}
	public void setIsinuse(String isinuse) {
		this.isinuse = isinuse;
	}
	public String getItemdescribe() {
		return itemdescribe;
	}
	public void setItemdescribe(String itemdescribe) {
		this.itemdescribe = itemdescribe;
	}
	public String getItemattribute() {
		return itemattribute;
	}
	public void setItemattribute(String itemattribute) {
		this.itemattribute = itemattribute;
	}
	public String getRelativecode() {
		return relativecode;
	}
	public void setRelativecode(String relativecode) {
		this.relativecode = relativecode;
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
	public String getAttribute5() {
		return attribute5;
	}
	public void setAttribute5(String attribute5) {
		this.attribute5 = attribute5;
	}
	public String getAttribute6() {
		return attribute6;
	}
	public void setAttribute6(String attribute6) {
		this.attribute6 = attribute6;
	}
	public String getAttribute7() {
		return attribute7;
	}
	public void setAttribute7(String attribute7) {
		this.attribute7 = attribute7;
	}
	public String getAttribute8() {
		return attribute8;
	}
	public void setAttribute8(String attribute8) {
		this.attribute8 = attribute8;
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
		return "codelibrary [codeno=" + codeno + ", itemno=" + itemno + ", itemname=" + itemname + ", isinuse="
				+ isinuse + ", itemdescribe=" + itemdescribe + ", itemattribute=" + itemattribute + ", relativecode="
				+ relativecode + ", attribute1=" + attribute1 + ", attribute2=" + attribute2 + ", attribute3="
				+ attribute3 + ", attribute4=" + attribute4 + ", attribute5=" + attribute5 + ", attribute6="
				+ attribute6 + ", attribute7=" + attribute7 + ", attribute8=" + attribute8 + ", note=" + note
				+ ", createdTime=" + createdTime + ", modifiedTime=" + modifiedTime + ", createdUser=" + createdUser
				+ ", modifiedUser=" + modifiedUser + "]";
	}
	
	
	
	
	
	
}