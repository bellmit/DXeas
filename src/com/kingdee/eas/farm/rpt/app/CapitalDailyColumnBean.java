package com.kingdee.eas.farm.rpt.app;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 手机端资金日报 后台pojo
 * @author USER
 *
 */
public class CapitalDailyColumnBean implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 5301114073539719256L;
	
	private String companyNumber;
	private String companyName;
	private String accountNumber;
	private String accountName;
	private String yestodayDer;
	private BigDecimal yestodayBalance;
	private String todayDer;
	private BigDecimal todayDebit;
	private BigDecimal todayCredit;
	private BigDecimal todayBalance;
	private int debitCount;
	private int creditCount;
	
	
	public String getAccountNumber() {
		if(accountNumber != null){
			return accountNumber;
		}else{
			return "";
		}
	}
	public void setAccountNumber(String accountNumber) {
		
		this.accountNumber = accountNumber;
	}
	public String getAccountName() {
		if(accountName != null){
			return accountName;
		}else{
			return "";
		}
	}
	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}
	public String getYestodayDer() {
		if(yestodayDer != null){
			return yestodayDer;
		}else{
			return "";
		}
	}
	public void setYestodayDer(String yestodayDer) {
		this.yestodayDer = yestodayDer;
	}
	public BigDecimal getYestodayBalance() {
		if(yestodayBalance != null){
			return yestodayBalance;
		}else{
			return new BigDecimal("0");
		}
	}
	public void setYestodayBalance(BigDecimal yestodayBalance) {
		this.yestodayBalance = yestodayBalance;
	}
	public String getTodayDer() {
		if(todayDer != null){
			return todayDer;
		}else{
			return "";
		}
	}
	public void setTodayDer(String todayDer) {
		this.todayDer = todayDer;
	}
	public BigDecimal getTodayDebit() {
		if(todayDebit != null){
			return todayDebit;
		}else{
			return new BigDecimal("0");
		}
	}
	public void setTodayDebit(BigDecimal todayDebit) {
		this.todayDebit = todayDebit;
	}
	public BigDecimal getTodayCredit() {
		if(todayCredit != null){
			return todayCredit;
		}else{
			return new BigDecimal("0");
		}
	}
	public void setTodayCredit(BigDecimal todayCredit) {
		this.todayCredit = todayCredit;
	}
	public BigDecimal getTodayBalance() {
		if(todayBalance != null){
			return todayBalance;
		}else{
			return new BigDecimal("0");
		}
	}
	public void setTodayBalance(BigDecimal todayBalance) {
		this.todayBalance = todayBalance;
	}
	public int getDebitCount() {
		
			return debitCount;
		
	}
	public void setDebitCount(int debitCount) {
		this.debitCount = debitCount;
	}
	public int getCreditCount() {
		
		return creditCount;
	}
	public void setCreditCount(int creditCount) {
		this.creditCount = creditCount;
	}
	public String getCompanyNumber() {
		return companyNumber;
	}
	public void setCompanyNumber(String companyNumber) {
		this.companyNumber = companyNumber;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
}
