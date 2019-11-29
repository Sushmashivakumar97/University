package com.univ.model;

import javax.persistence.Id;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Placement {
	@Id
	private int companyId;
	private String companyName;
	private String compensation;
	private boolean eligibility;
	
	public Placement() {
		super();
	}

	public Placement(int companyId, String companyName, String compensation, boolean eligibility) {
		super();
		this.companyId = companyId;
		this.companyName = companyName;
		this.compensation = compensation;
		this.eligibility = eligibility;
	}

	public int getCompanyId() {
		return companyId;
	}

	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getCompensation() {
		return compensation;
	}

	public void setCompensation(String compensation) {
		this.compensation = compensation;
	}

	public boolean isEligibility() {
		return eligibility;
	}

	public void setEligibility(boolean eligibility) {
		this.eligibility = eligibility;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + companyId;
		result = prime * result + ((companyName == null) ? 0 : companyName.hashCode());
		result = prime * result + ((compensation == null) ? 0 : compensation.hashCode());
		result = prime * result + (eligibility ? 1231 : 1237);
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
		Placement other = (Placement) obj;
		if (companyId != other.companyId)
			return false;
		if (companyName == null) {
			if (other.companyName != null)
				return false;
		} else if (!companyName.equals(other.companyName))
			return false;
		if (compensation == null) {
			if (other.compensation != null)
				return false;
		} else if (!compensation.equals(other.compensation))
			return false;
		if (eligibility != other.eligibility)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Placement [companyId=" + companyId + ", companyName=" + companyName + ", compensation=" + compensation
				+ ", eligibility=" + eligibility + "]";
	}

	
	
	

}