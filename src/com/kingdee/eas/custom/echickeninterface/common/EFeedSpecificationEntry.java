package com.kingdee.eas.custom.echickeninterface.common;

public class EFeedSpecificationEntry {

	//��Ʒ��
	private int fdays;
	private String fslname;
	private String fslid;
	private String fslnumber;
	private String cfqtyperday;
	private String cfstandardweight;
	//���ɲ���
	private int fweek;
	private String cfhenmaterialname;//ĸ����������
	private String cfhenqtyperday;
	private String cfcockmaterialname;//������������
	private String cfcockqtyperday;

	private String cfbreedtime;//��ιʱ��
	private String cflightingtime;//����ʱ��
	private String cfdailydcrate;
	
	public int getFdays() {
		return fdays;
	}
	public void setFdays(int fdays) {
		this.fdays = fdays;
	}
	public String getFslname() {
		return fslname;
	}
	public void setFslname(String fslname) {
		this.fslname = fslname;
	}
	public String getCfqtyperday() {
		return cfqtyperday;
	}
	public void setCfqtyperday(String cfqtyperday) {
		this.cfqtyperday = cfqtyperday;
	}
	public String getCfbreedtime() {
		return cfbreedtime;
	}
	public void setCfbreedtime(String cfbreedtime) {
		this.cfbreedtime = cfbreedtime;
	}
	public String getCflightingtime() {
		return cflightingtime;
	}
	public void setCflightingtime(String cflightingtime) {
		this.cflightingtime = cflightingtime;
	}

	public String getCfdailydcrate() {
		return cfdailydcrate;
	}
	public void setCfdailydcrate(String cfdailydcrate) {
		this.cfdailydcrate = cfdailydcrate;
	}
	public String getCfstandardweight() {
		return cfstandardweight;
	}
	public void setCfstandardweight(String cfstandardweight) {
		this.cfstandardweight = cfstandardweight;
	}
	public int getFweek() {
		return fweek;
	}
	public void setFweek(int fweek) {
		this.fweek = fweek;
	}
	public String getCfhenmaterialname() {
		return cfhenmaterialname;
	}
	public void setCfhenmaterialname(String cfhenmaterialname) {
		this.cfhenmaterialname = cfhenmaterialname;
	}
	public String getCfhenqtyperday() {
		return cfhenqtyperday;
	}
	public void setCfhenqtyperday(String cfhenqtyperday) {
		this.cfhenqtyperday = cfhenqtyperday;
	}

	public String getCfcockmaterialname() {
		return cfcockmaterialname;
	}
	public void setCfcockmaterialname(String cfcockmaterialname) {
		this.cfcockmaterialname = cfcockmaterialname;
	}
	public String getCfcockqtyperday() {
		return cfcockqtyperday;
	}
	public void setCfcockqtyperday(String cfcockqtyperday) {
		this.cfcockqtyperday = cfcockqtyperday;
	}
	public String getFslid() {
		return fslid;
	}
	public void setFslid(String fslid) {
		this.fslid = fslid;
	}
	public String getFslnumber() {
		return fslnumber;
	}
	public void setFslnumber(String fslnumber) {
		this.fslnumber = fslnumber;
	}
}
