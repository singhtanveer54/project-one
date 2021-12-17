package com.revature.model;

import java.util.Objects;

public class Reimbursement {
	
	private int id;
	private double amount;
	private String submitted;
	private String resolved;
	private String description;
	private int authorId;
	private int resolverId;
	private String status;
	private String reimType;
	private String aFirstName;
	private String aLastName;
	private String rFirstName;
	
	
	


	public Reimbursement(int id, double amount, String submitted, String resolved, String description, int authorId,
			int resolverId, String status, String reimType, String aFirstName, String aLastName, String rFirstName) {
		super();
		this.id = id;
		this.amount = amount;
		this.submitted = submitted;
		this.resolved = resolved;
		this.description = description;
		this.authorId = authorId;
		this.resolverId = resolverId;
		this.status = status;
		this.reimType = reimType;
		this.aFirstName = aFirstName;
		this.aLastName = aLastName;
		this.rFirstName = rFirstName;
	}
	
	

	public String getaFirstName() {
		return aFirstName;
	}



	public void setaFirstName(String aFirstName) {
		this.aFirstName = aFirstName;
	}



	public String getaLastName() {
		return aLastName;
	}



	public void setaLastName(String aLastName) {
		this.aLastName = aLastName;
	}



	public String getrFirstName() {
		return rFirstName;
	}



	public void setrFirstName(String rFirstName) {
		this.rFirstName = rFirstName;
	}



	public Reimbursement(int id, double amount, String submitted, String resolved, String description, int authorId,
			int resolverId, String status, String reimType) {
		super();
		this.id = id;
		this.amount = amount;
		this.submitted = submitted;
		this.resolved = resolved;
		this.description = description;
		this.authorId = authorId;
		this.resolverId = resolverId;
		this.status = status;
		this.reimType = reimType;
	}

	public Reimbursement() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getSubmitted() {
		return submitted;
	}

	public void setSubmitted(String submitted) {
		this.submitted = submitted;
	}

	public String getResolved() {
		return resolved;
	}

	public void setResolved(String resolved) {
		this.resolved = resolved;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getAuthorId() {
		return authorId;
	}

	public void setAuthorId(int authorId) {
		this.authorId = authorId;
	}

	public int getResolverId() {
		return resolverId;
	}

	public void setResolverId(int resolverId) {
		this.resolverId = resolverId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getReimType() {
		return reimType;
	}

	public void setReimType(String reimType) {
		this.reimType = reimType;
	}

	@Override
	public int hashCode() {
		return Objects.hash(aFirstName, aLastName, amount, authorId, description, id, rFirstName, reimType, resolved,
				resolverId, status, submitted);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Reimbursement other = (Reimbursement) obj;
		return Objects.equals(aFirstName, other.aFirstName) && Objects.equals(aLastName, other.aLastName)
				&& Double.doubleToLongBits(amount) == Double.doubleToLongBits(other.amount)
				&& authorId == other.authorId && Objects.equals(description, other.description) && id == other.id
				&& Objects.equals(rFirstName, other.rFirstName) && Objects.equals(reimType, other.reimType)
				&& Objects.equals(resolved, other.resolved) && resolverId == other.resolverId
				&& Objects.equals(status, other.status) && Objects.equals(submitted, other.submitted);
	}

	@Override
	public String toString() {
		return "Reimbursement [id=" + id + ", amount=" + amount + ", submitted=" + submitted + ", resolved=" + resolved
				+ ", description=" + description + ", authorId=" + authorId + ", resolverId=" + resolverId + ", status="
				+ status + ", reimType=" + reimType + ", aFirstName=" + aFirstName + ", aLastName=" + aLastName
				+ ", rFirstName=" + rFirstName + "]";
	}
	
	
	

	
	
	

}
