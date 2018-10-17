package com.capgemini.bank.bean;

import java.sql.Date;

public class DemandDraft {
	private int transactionId;
	private String customerName, inFavorOf, ddDescription;
	private long ddCommission, phoneNo;
	private float ddAmount;
	java.util.Date dateOfTransaction;
	public DemandDraft() {
		super();
	}
	public DemandDraft(String customerName, String inFavorOf,
			String ddDescription, Date dateOfTransaction, long ddCommission,
			long phoneNo, float ddAmount) {
		super();
		this.customerName = customerName;
		this.inFavorOf = inFavorOf;
		this.ddDescription = ddDescription;
		this.dateOfTransaction = dateOfTransaction;
		this.phoneNo = phoneNo;
		this.ddAmount = ddAmount;
		if(ddAmount <= 5000) this.ddCommission = 10;
		else if (ddAmount > 5000 && ddAmount <= 10000) this.ddCommission = 41;
		else if (ddAmount > 10000 && ddAmount <= 100000) this.ddCommission = 51;
		else if (ddAmount > 100000 && ddAmount <= 500000) this.ddCommission = 306;
	}
	public DemandDraft(String customerName, String inFavorOf,
			String ddDescription,java.util.Date dateOfTransaction, long phoneNo, float ddAmount) {
		super();
		
		this.dateOfTransaction = dateOfTransaction;
		this.customerName = customerName;
		this.inFavorOf = inFavorOf;
		this.ddDescription = ddDescription;
		this.phoneNo = phoneNo;
		this.ddAmount = ddAmount;
		if(ddAmount <= 5000) this.ddCommission = 10;
		else if (ddAmount > 5000 && ddAmount <= 10000) this.ddCommission = 41;
		else if (ddAmount > 10000 && ddAmount <= 100000) this.ddCommission = 51;
		else if (ddAmount > 100000 && ddAmount <= 500000) this.ddCommission = 306;
	}
	public DemandDraft(int transactionId, String customerName,
			String inFavorOf, String ddDescription, Date dateOfTransaction,
			float ddAmount, long ddCommission, long phoneNo) {
		super();
		this.transactionId = transactionId;
		this.customerName = customerName;
		this.inFavorOf = inFavorOf;
		this.ddDescription = ddDescription;
		this.dateOfTransaction = dateOfTransaction;
		this.ddAmount = ddAmount;
		this.phoneNo = phoneNo;
		if(ddAmount <= 5000) this.ddCommission = 10;
		else if (ddAmount > 5000 && ddAmount <= 10000) this.ddCommission = 41;
		else if (ddAmount > 10000 && ddAmount <= 100000) this.ddCommission = 51;
		else if (ddAmount > 100000 && ddAmount <= 500000) this.ddCommission = 306;
	}
	public int getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getInFavorOf() {
		return inFavorOf;
	}
	public void setInFavorOf(String inFavorOf) {
		this.inFavorOf = inFavorOf;
	}
	public String getDdDescription() {
		return ddDescription;
	}
	public void setDdDescription(String ddDescription) {
		this.ddDescription = ddDescription;
	}
	public java.util.Date getDateOfTransaction() {
		return dateOfTransaction;
	}
	public void setDateOfTranasction(java.util.Date dateOfTransaction) {
		this.dateOfTransaction = dateOfTransaction;
	}
	public float getDdAmount() {
		return ddAmount;
	}
	public void setDdAmount(float ddAmount) {
		this.ddAmount = ddAmount;
	}
	public long getDdCommission() {
		return ddCommission;
	}
	public void setDdCommission(long ddCommission) {
		this.ddCommission = ddCommission;
	}
	public long getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(long phoneNo) {
		this.phoneNo = phoneNo;
	}
	@Override
	public String toString() {
		return "DemandDraft [transactionId=" + transactionId
				+ ", customerName=" + customerName + ", inFavorOf=" + inFavorOf
				+ ", ddDescription=" + ddDescription + ", dateOfTranasction="
				+ dateOfTransaction + ", ddCommission=" + ddCommission
				+ ", phoneNo=" + phoneNo + ", ddAmount=" + ddAmount + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((customerName == null) ? 0 : customerName.hashCode());
		result = prime
				* result
				+ ((dateOfTransaction == null) ? 0 : dateOfTransaction
						.hashCode());
		result = prime * result + Float.floatToIntBits(ddAmount);
		result = prime * result + (int) (ddCommission ^ (ddCommission >>> 32));
		result = prime * result
				+ ((ddDescription == null) ? 0 : ddDescription.hashCode());
		result = prime * result
				+ ((inFavorOf == null) ? 0 : inFavorOf.hashCode());
		result = prime * result + (int) (phoneNo ^ (phoneNo >>> 32));
		result = prime * result + transactionId;
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
		DemandDraft other = (DemandDraft) obj;
		if (customerName == null) {
			if (other.customerName != null)
				return false;
		} else if (!customerName.equals(other.customerName))
			return false;
		if (dateOfTransaction == null) {
			if (other.dateOfTransaction != null)
				return false;
		} else if (!dateOfTransaction.equals(other.dateOfTransaction))
			return false;
		if (Float.floatToIntBits(ddAmount) != Float
				.floatToIntBits(other.ddAmount))
			return false;
		if (ddCommission != other.ddCommission)
			return false;
		if (ddDescription == null) {
			if (other.ddDescription != null)
				return false;
		} else if (!ddDescription.equals(other.ddDescription))
			return false;
		if (inFavorOf == null) {
			if (other.inFavorOf != null)
				return false;
		} else if (!inFavorOf.equals(other.inFavorOf))
			return false;
		if (phoneNo != other.phoneNo)
			return false;
		if (transactionId != other.transactionId)
			return false;
		return true;
	}

}
