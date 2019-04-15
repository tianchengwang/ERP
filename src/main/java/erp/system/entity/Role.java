package erp.system.entity;

import java.io.Serializable;
import java.util.Date;

public class Role implements Serializable {
	private static final long serialVersionUID = -4947502179670638712L;
	private Integer r_id;
	private String r_name;
	private String r_node;
	private String remark;
	private String createdUser;
	private String modifiedUser;
	private String coreatedTime;
	private String modifiedTime;
	
	
	
	public Integer getR_id() {
		return r_id;
	}
	public void setR_id(Integer r_id) {
		this.r_id = r_id;
	}
	public String getR_name() {
		return r_name;
	}
	public void setR_name(String r_name) {
		this.r_name = r_name;
	}
	public String getR_node() {
		return r_node;
	}
	public void setR_node(String r_node) {
		this.r_node = r_node;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
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
	public String getCoreatedTime() {
		return coreatedTime;
	}
	public void setCoreatedTime(String coreatedTime) {
		this.coreatedTime = coreatedTime;
	}
	public String getModifiedTime() {
		return modifiedTime;
	}
	public void setModifiedTime(String modifiedTime) {
		this.modifiedTime = modifiedTime;
	}
	
	
	@Override
	public String toString() {
		return "SysRole [r_id=" + r_id + ", r_name=" + r_name + ", r_node=" + r_node + ", remark=" + remark
				+ ", createdUser=" + createdUser + ", modifiedUser=" + modifiedUser + ", coreatedTime=" + coreatedTime
				+ ", modifiedTime=" + modifiedTime + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((r_id == null) ? 0 : r_id.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Role other = (Role) obj;
		if (r_id == null) {
			if (other.r_id != null)
				return false;
		} else if (!r_id.equals(other.r_id))
			return false;
		return true;
	}

	
}
