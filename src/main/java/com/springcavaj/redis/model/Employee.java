/**
 * 
 */
package com.springcavaj.redis.model;

import java.io.Serializable;
import java.util.Objects;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * 
 * @author springcavaj
 * 
 */
@Document(collection = "Employee")
public class Employee implements Serializable {

	private static final long serialVersionUID = -4071260833446936926L;
	
	@Id
	private String employeeId;
	private String panCard;
	private String empName;
	public String getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}
	public String getPanCard() {
		return panCard;
	}
	public void setPanCard(String panCard) {
		this.panCard = panCard;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	@Override
	public int hashCode() {
		return Objects.hash(empName, employeeId, panCard);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Employee))
			return false;
		Employee other = (Employee) obj;
		return Objects.equals(empName, other.empName) && Objects.equals(employeeId, other.employeeId)
				&& Objects.equals(panCard, other.panCard);
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Employee [employeeId=");
		builder.append(employeeId);
		builder.append(", panCard=");
		builder.append(panCard);
		builder.append(", empName=");
		builder.append(empName);
		builder.append("]");
		return builder.toString();
	}
}
