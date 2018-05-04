package com.secondProject.mhk.vo;

import java.util.Date;

public class Company {
	private int companyNum;
	private String companyName, companyCEO, companyEmail, companyPhone, companyAddress;
	private String companyField;
	private int companyPayment;
	private int companyWorkingTime, companyEmployee, companyCapital;
	private String companyFoundation;
	private String companyHomepage;
	private Date companyRegisteredDate;
	private int companyDeletedStatus;
	private String companyDeletedBy;
	private Date companyDeletedTime;
	private String companyUpdatedBy;
	private Date companyUpdatedTime;
	private String companyImageFileRoot;

	public Company(int companyNum, String companyName, String companyCEO, String companyEmail, String companyPhone,
			String companyAddress, double companyAddressLatitude, double companyAddressLongitude, String companyField,
			int companyPayment, String companyWorkingEnvironment, int companyWorkingTime, int companyEmployee,
			int companyCapital, String companyFoundation, String companyHomepage, Date companyRegisteredDate,
			int companyDeletedStatus, String companyDeletedBy, Date companyDeletedTime, String companyUpdatedBy,
			Date companyUpdatedTime, String companyImageFile, String companyImageFileRoot) {
		super();
		this.companyNum = companyNum;
		this.companyName = companyName;
		this.companyCEO = companyCEO;
		this.companyEmail = companyEmail;
		this.companyPhone = companyPhone;
		this.companyAddress = companyAddress;

		this.companyField = companyField;
		this.companyPayment = companyPayment;

		this.companyWorkingTime = companyWorkingTime;
		this.companyEmployee = companyEmployee;
		this.companyCapital = companyCapital;
		this.companyFoundation = companyFoundation;
		this.companyHomepage = companyHomepage;
		this.companyRegisteredDate = companyRegisteredDate;
		this.companyDeletedStatus = companyDeletedStatus;
		this.companyDeletedBy = companyDeletedBy;
		this.companyDeletedTime = companyDeletedTime;
		this.companyUpdatedBy = companyUpdatedBy;
		this.companyUpdatedTime = companyUpdatedTime;
		this.companyImageFileRoot = companyImageFileRoot;
	}

	public Company() {
		super();
	}

	public int getCompanyNum() {
		return companyNum;
	}

	public void setCompanyNum(int companyNum) {
		this.companyNum = companyNum;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getCompanyCEO() {
		return companyCEO;
	}

	public void setCompanyCEO(String companyCEO) {
		this.companyCEO = companyCEO;
	}

	public String getCompanyEmail() {
		return companyEmail;
	}

	public void setCompanyEmail(String companyEmail) {
		this.companyEmail = companyEmail;
	}

	public String getCompanyPhone() {
		return companyPhone;
	}

	public void setCompanyPhone(String companyPhone) {
		this.companyPhone = companyPhone;
	}

	public String getCompanyAddress() {
		return companyAddress;
	}

	public void setCompanyAddress(String companyAddress) {
		this.companyAddress = companyAddress;
	}

	public String getCompanyField() {
		return companyField;
	}

	public void setCompanyField(String companyField) {
		this.companyField = companyField;
	}

	public int getCompanyPayment() {
		return companyPayment;
	}

	public void setCompanyPayment(int companyPayment) {
		this.companyPayment = companyPayment;
	}

	public int getCompanyWorkingTime() {
		return companyWorkingTime;
	}

	public void setCompanyWorkingTime(int companyWorkingTime) {
		this.companyWorkingTime = companyWorkingTime;
	}

	public int getCompanyEmployee() {
		return companyEmployee;
	}

	public void setCompanyEmployee(int companyEmployee) {
		this.companyEmployee = companyEmployee;
	}

	public int getCompanyCapital() {
		return companyCapital;
	}

	public void setCompanyCapital(int companyCapital) {
		this.companyCapital = companyCapital;
	}

	public String getCompanyFoundation() {
		return companyFoundation;
	}

	public void setCompanyFoundation(String companyFoundation) {
		this.companyFoundation = companyFoundation;
	}

	public String getCompanyHomepage() {
		return companyHomepage;
	}

	public void setCompanyHomepage(String companyHomepage) {
		this.companyHomepage = companyHomepage;
	}

	public Date getCompanyRegisteredDate() {
		return companyRegisteredDate;
	}

	public void setCompanyRegisteredDate(Date companyRegisteredDate) {
		this.companyRegisteredDate = companyRegisteredDate;
	}

	public int getCompanyDeletedStatus() {
		return companyDeletedStatus;
	}

	public void setCompanyDeletedStatus(int companyDeletedStatus) {
		this.companyDeletedStatus = companyDeletedStatus;
	}

	public String getCompanyDeletedBy() {
		return companyDeletedBy;
	}

	public void setCompanyDeletedBy(String companyDeletedBy) {
		this.companyDeletedBy = companyDeletedBy;
	}

	public Date getCompanyDeletedTime() {
		return companyDeletedTime;
	}

	public void setCompanyDeletedTime(Date companyDeletedTime) {
		this.companyDeletedTime = companyDeletedTime;
	}

	public String getCompanyUpdatedBy() {
		return companyUpdatedBy;
	}

	public void setCompanyUpdatedBy(String companyUpdatedBy) {
		this.companyUpdatedBy = companyUpdatedBy;
	}

	public Date getCompanyUpdatedTime() {
		return companyUpdatedTime;
	}

	public void setCompanyUpdatedTime(Date companyUpdatedTime) {
		this.companyUpdatedTime = companyUpdatedTime;
	}

	public String getCompanyImageFileRoot() {
		return companyImageFileRoot;
	}

	public void setCompanyImageFileRoot(String companyImageFileRoot) {
		this.companyImageFileRoot = companyImageFileRoot;
	}

	@Override
	public String toString() {
		return "Company [companyNum=" + companyNum + ", companyName=" + companyName + ", companyCEO=" + companyCEO
				+ ", companyEmail=" + companyEmail + ", companyPhone=" + companyPhone + ", companyAddress="
				+ companyAddress + ", companyAddressLatitude=" + ", companyAddressLongitude=" + ", companyField="
				+ companyField + ", companyPayment=" + companyPayment + ", companyWorkingEnvironment="
				+ ", companyWorkingTime=" + companyWorkingTime + ", companyEmployee=" + companyEmployee
				+ ", companyCapital=" + companyCapital + ", companyFoundation=" + companyFoundation
				+ ", companyHomepage=" + companyHomepage + ", companyRegisteredDate=" + companyRegisteredDate
				+ ", companyDeletedStatus=" + companyDeletedStatus + ", companyDeletedBy=" + companyDeletedBy
				+ ", companyDeletedTime=" + companyDeletedTime + ", companyUpdatedBy=" + companyUpdatedBy
				+ ", companyUpdatedTime=" + companyUpdatedTime + ", companyImageFile=" + ", companyImageFileRoot=" + companyImageFileRoot + "]";
	}

}
