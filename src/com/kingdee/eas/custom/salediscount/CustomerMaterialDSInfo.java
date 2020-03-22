package com.kingdee.eas.custom.salediscount;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import com.kingdee.eas.base.permission.UserInfo;
import com.kingdee.eas.basedata.assistant.PeriodInfo;
import com.kingdee.eas.basedata.master.cssp.CustomerInfo;
import com.kingdee.eas.basedata.master.material.MaterialInfo;

/**
 * �ͻ� ����������Ϣ
 * @author Administrator
 *
 */
public class CustomerMaterialDSInfo  implements Serializable{
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -5709173653935333315L;
	private CustomerInfo customerInfo;  // �ͻ�
	private MaterialInfo materialInfo;  // ����
	private BigDecimal saleQty;			// ��Ӧ����
	private BigDecimal saleAmount;		// ��Ӧ���۶�
	private BigDecimal saleOrderDiscountAmount; // ��Ӧ������ �����ܶ�
	private BigDecimal saleOrderDiscountQty; // ��Ӧ��������������
	private BigDecimal adjustAmount; //  �������
	
	private int disRecordVision;
	private String disRecordNumber;
	private String disRecordID;
	private String disRecordEntryID;
	private com.kingdee.eas.custom.salediscount.billStatus disRecordStatus;
	private Date disRecordCreateTime;
	private Date disRecordBizdate;
	private UserInfo disRecordCreator;
	private String adjustType;   // ����_����    ����_����     ��Ʒ
	private PeriodInfo period;
	private BigDecimal disRecordAdustAmount;  // ��¼�������
	private BigDecimal disRecordAllAdjust;    // �����������
	
	
	public CustomerInfo getCustomerInfo() {
		return customerInfo;
	}
	public void setCustomerInfo(CustomerInfo customerInfo) {
		this.customerInfo = customerInfo;
	}
	public MaterialInfo getMaterialInfo() {
		return materialInfo;
	}
	public void setMaterialInfo(MaterialInfo materialInfo) {
		this.materialInfo = materialInfo;
	}
	public BigDecimal getSaleQty() {
		return saleQty;
	}
	public void setSaleQty(BigDecimal saleQty) {
		this.saleQty = saleQty;
	}
	public BigDecimal getSaleAmount() {
		return saleAmount;
	}
	public void setSaleAmount(BigDecimal saleAmount) {
		this.saleAmount = saleAmount;
	}
	public BigDecimal getSaleOrderDiscountAmount() {
		return saleOrderDiscountAmount;
	}
	public void setSaleOrderDiscountAmount(BigDecimal saleOrderDiscountAmount) {
		this.saleOrderDiscountAmount = saleOrderDiscountAmount;
	}
	public BigDecimal getAdjustAmount() {
		return adjustAmount;
	}
	public void setAdjustAmount(BigDecimal adjustAmount) {
		this.adjustAmount = adjustAmount;
	}
	public BigDecimal getSaleOrderDiscountQty() {
		return saleOrderDiscountQty;
	}
	public void setSaleOrderDiscountQty(BigDecimal saleOrderDiscountQty) {
		this.saleOrderDiscountQty = saleOrderDiscountQty;
	}
	public String getDisRecordNumber() {
		return disRecordNumber;
	}
	public void setDisRecordNumber(String disRecordNumber) {
		this.disRecordNumber = disRecordNumber;
	}
	public com.kingdee.eas.custom.salediscount.billStatus getDisRecordStatus() {
		return disRecordStatus;
	}
	public void setDisRecordStatus(
			com.kingdee.eas.custom.salediscount.billStatus disRecordStatus) {
		this.disRecordStatus = disRecordStatus;
	}
	public Date getDisRecordCreateTime() {
		return disRecordCreateTime;
	}
	public void setDisRecordCreateTime(Date disRecordCreateTime) {
		this.disRecordCreateTime = disRecordCreateTime;
	}
	public Date getDisRecordBizdate() {
		return disRecordBizdate;
	}
	public void setDisRecordBizdate(Date disRecordBizdate) {
		this.disRecordBizdate = disRecordBizdate;
	}
	public UserInfo getDisRecordCreator() {
		return disRecordCreator;
	}
	public void setDisRecordCreator(UserInfo disRecordCreator) {
		this.disRecordCreator = disRecordCreator;
	}
	public String getAdjustType() {
		return adjustType;
	}
	public void setAdjustType(String adjustType) {
		this.adjustType = adjustType;
	}
	public int getDisRecordVision() {
		return disRecordVision;
	}
	public void setDisRecordVision(int disRecordVision) {
		this.disRecordVision = disRecordVision;
	}
	public PeriodInfo getPeriod() {
		return period;
	}
	public void setPeriod(PeriodInfo period) {
		this.period = period;
	}
	public BigDecimal getDisRecordAdustAmount() {
		return disRecordAdustAmount;
	}
	public void setDisRecordAdustAmount(BigDecimal disRecordAdustAmount) {
		this.disRecordAdustAmount = disRecordAdustAmount;
	}
	public BigDecimal getDisRecordAllAdjust() {
		return disRecordAllAdjust;
	}
	public void setDisRecordAllAdjust(BigDecimal disRecordAllAdjust) {
		this.disRecordAllAdjust = disRecordAllAdjust;
	}
	public String getDisRecordID() {
		return disRecordID;
	}
	public void setDisRecordID(String disRecordID) {
		this.disRecordID = disRecordID;
	}
	public String getDisRecordEntryID() {
		return disRecordEntryID;
	}
	public void setDisRecordEntryID(String disRecordEntryID) {
		this.disRecordEntryID = disRecordEntryID;
	}
	
	
}
