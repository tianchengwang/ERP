package erp.employee.entity;
import java.io.Serializable;

/**Ա����Ϣʵ�����:
 * ��Ӧ�ı�:erp_employee
 * */
/**
 * @author amarsoft
 *
 */
public class Employee implements Serializable{
	private static final long serialVersionUID = 5850357988911265658L;
	private Integer id;
	/**id,��Ӧ���е�����ֵ*/
	private String employeeID;
	/**Ա������*/
	private String employeeName;
	/**���֤��*/
	private String certID;
	/**�Ա�*/
	private String sex;
	/**�Ա�*/
	private String birthday;
	/**ְ��*/
	private String grade;
	/**��ְ����*/
	private String  inDate;
	/**ת������*/
	private String  regularDate;
	/**��ͬ��ʼʱ��*/
	private String contractDate;
	/**��ͬ����ʱ��*/
	private String endDate;
	/**ѧ��*/
	private String education;
	/**��ҵԺУ*/
	private String university;
	/**��ҵʱ��*/
	private String graduatedDate;
	/**����*/
	private String nativePlace;
	/**�������ڵ�*/
	private String registeredResidence;
	/**�������ڵ�*/
	private String fileLocation;
	/**�ֻ�*/
	private String 	mobilePhone;
	/**�칫�绰*/
	private String officePhone;
	/**������ϵ��*/
	private String emergencyContact;
	/**������ϵ�绰*/
	private String emergencyContactPhone;
	/**��˾*/
	private String company;
	/**��ע*/
	private Integer valid;
	/**��ע*/
	private String note;
	/**����ʱ��*/
	private String createdTime;
	/**�޸�ʱ��*/
	private String modifiedTime;
	/**�����û�*/
	private String createdUser;
	/**�޸��û�*/
	private String modifiedUser;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getEmployeeID() {
		return employeeID;
	}
	public void setEmployeeID(String employeeID) {
		this.employeeID = employeeID;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public String getCertID() {
		return certID;
	}
	public void setCertID(String certID) {
		this.certID = certID;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public String getInDate() {
		return inDate;
	}
	public void setInDate(String inDate) {
		this.inDate = inDate;
	}
	public String getRegularDate() {
		return regularDate;
	}
	public void setRegularDate(String regularDate) {
		this.regularDate = regularDate;
	}
	public String getContractDate() {
		return contractDate;
	}
	public void setContractDate(String contractDate) {
		this.contractDate = contractDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public String getEducation() {
		return education;
	}
	public void setEducation(String education) {
		this.education = education;
	}
	public String getUniversity() {
		return university;
	}
	public void setUniversity(String university) {
		this.university = university;
	}
	public String getGraduatedDate() {
		return graduatedDate;
	}
	public void setGraduatedDate(String graduatedDate) {
		this.graduatedDate = graduatedDate;
	}
	public String getNativePlace() {
		return nativePlace;
	}
	public void setNativePlace(String nativePlace) {
		this.nativePlace = nativePlace;
	}
	public String getRegisteredResidence() {
		return registeredResidence;
	}
	public void setRegisteredResidence(String registeredResidence) {
		this.registeredResidence = registeredResidence;
	}
	public String getFileLocation() {
		return fileLocation;
	}
	public void setFileLocation(String fileLocation) {
		this.fileLocation = fileLocation;
	}
	public String getMobilePhone() {
		return mobilePhone;
	}
	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}
	public String getOfficePhone() {
		return officePhone;
	}
	public void setOfficePhone(String officePhone) {
		this.officePhone = officePhone;
	}
	public String getEmergencyContact() {
		return emergencyContact;
	}
	public void setEmergencyContact(String emergencyContact) {
		this.emergencyContact = emergencyContact;
	}
	public String getEmergencyContactPhone() {
		return emergencyContactPhone;
	}
	public void setEmergencyContactPhone(String emergencyContactPhone) {
		this.emergencyContactPhone = emergencyContactPhone;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	
	public Integer getValid() {
		return valid;
	}
	public void setValid(Integer valid) {
		this.valid = valid;
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
		return "Employee [id=" + id + ", employeeID=" + employeeID + ", employeeName=" + employeeName + ", certID="
				+ certID + ", sex=" + sex + ", birthday=" + birthday + ", grade=" + grade + ", inDate=" + inDate
				+ ", regularDate=" + regularDate + ", contractDate=" + contractDate + ", endDate=" + endDate
				+ ", education=" + education + ", university=" + university + ", graduatedDate=" + graduatedDate
				+ ", nativePlace=" + nativePlace + ", registeredResidence=" + registeredResidence + ", fileLocation="
				+ fileLocation + ", mobilePhone=" + mobilePhone + ", officePhone=" + officePhone + ", emergencyContact="
				+ emergencyContact + ", emergencyContactPhone=" + emergencyContactPhone + ", company=" + company
				+ ", valid=" + valid + ", note=" + note + ", createdTime=" + createdTime + ", modifiedTime="
				+ modifiedTime + ", createdUser=" + createdUser + ", modifiedUser=" + modifiedUser + "]";
	}
	
	
	
	
}
