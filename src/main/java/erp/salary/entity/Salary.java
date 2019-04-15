package erp.salary.entity;

import java.io.Serializable;

public class Salary implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer salaryno;
	private Integer employeeID;
	private double basicssalary;
	private double ranksalary;
	private double achievements;
	private double mealsalary;
	private double housesalary;
	private double travelexpenses;
	private double totalsalary;
	private String attribute;
	private String attribute1;
	private String note;
	private String createdTime;
	private String modifiedTime;
	private String createdUser;
	private String modifiedUser;
	public Integer getSalaryno() {
		return salaryno;
	}
	public void setSalaryno(Integer salaryno) {
		this.salaryno = salaryno;
	}
	public Integer getEmployeeID() {
		return employeeID;
	}
	public void setEmployeeID(Integer employeeID) {
		this.employeeID = employeeID;
	}
	public double getBasicssalary() {
		return basicssalary;
	}
	public void setBasicssalary(double basicssalary) {
		this.basicssalary = basicssalary;
	}
	public double getRanksalary() {
		return ranksalary;
	}
	public void setRanksalary(double ranksalary) {
		this.ranksalary = ranksalary;
	}
	public double getAchievements() {
		return achievements;
	}
	public void setAchievements(double achievements) {
		this.achievements = achievements;
	}
	public double getMealsalary() {
		return mealsalary;
	}
	public void setMealsalary(double mealsalary) {
		this.mealsalary = mealsalary;
	}
	public double getHousesalary() {
		return housesalary;
	}
	public void setHousesalary(double housesalary) {
		this.housesalary = housesalary;
	}
	public double getTravelexpenses() {
		return travelexpenses;
	}
	public void setTravelexpenses(double travelexpenses) {
		this.travelexpenses = travelexpenses;
	}
	public double getTotalsalary() {
		return totalsalary;
	}
	public void setTotalsalary(double totalsalary) {
		this.totalsalary = totalsalary;
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
		return "Salary [salaryno=" + salaryno + ", employeeID=" + employeeID + ", basicssalary="
				+ basicssalary + ", ranksalary=" + ranksalary + ", achievements=" + achievements + ", mealsalary="
				+ mealsalary + ", housesalary=" + housesalary + ", travelexpenses=" + travelexpenses + ", totalsalary="
				+ totalsalary + ", attribute=" + attribute + ", attribute1=" + attribute1 + ", note=" + note
				+ ", createdTime=" + createdTime + ", modifiedTime=" + modifiedTime + ", createdUser=" + createdUser
				+ ", modifiedUser=" + modifiedUser + "]";
	}
	
	
	
	
	
	
	
}
