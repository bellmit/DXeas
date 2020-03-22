package com.kingdee.eas.custom.salediscount;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import com.kingdee.eas.base.permission.UserInfo;
import com.kingdee.eas.basedata.assistant.PeriodInfo;
import com.kingdee.eas.basedata.master.cssp.CustomerInfo;
import com.kingdee.eas.basedata.master.material.MaterialInfo;

/**
 * 客户 物料折让信息
 * @author Administrator
 *
 */
public class CustomerMaterialDSInfo  implements Serializable{
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -5709173653935333315L;
	private CustomerInfo customerInfo;  // 客户
	private MaterialInfo materialInfo;  // 物料
	private BigDecimal saleQty;			// 对应销量
	private BigDecimal saleAmount;		// 对应销售额
	private BigDecimal saleOrderDiscountAmount; // 对应订单的 折让总额
	private BigDecimal saleOrderDiscountQty; // 对应订单的折让销量
	private BigDecimal adjustAmount; //  调整金额
	
	private int disRecordVision;
	private String disRecordNumber;
	private String disRecordID;
	private String disRecordEntryID;
	private com.kingdee.eas.custom.salediscount.billStatus disRecordStatus;
	private Date disRecordCreateTime;
	private Date disRecordBizdate;
	private UserInfo disRecordCreator;
	private String adjustType;   // 总量_总量    总量_已提     产品
	private PeriodInfo period;
	private BigDecimal disRecordAdustAmount;  // 分录调整金额
	private BigDecimal disRecordAllAdjust;    // 整单调整金额
	
	
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
