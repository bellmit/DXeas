package com.kingdee.eas.custom.salediscount;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import com.kingdee.eas.basedata.master.cssp.CustomerInfo;

/**
 * 客户折让信息 ，在计算客户 折让调整时使用
 * @author Administrator
 *
 */
public class CustomerDiscountInfo implements Serializable{
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -5403648129104518729L;
	private CustomerInfo customerInfo; // 客户
	private BigDecimal allSaleQty;     // 总销量
	private BigDecimal discountSaleQty;// 折让销量
	private List<CustomerMaterialDSInfo> MaterialDiscountInfos; // 物料折让明细
	
	
	public CustomerInfo getCustomerInfo() {
		return customerInfo;
	}
	public void setCustomerInfo(CustomerInfo customerInfo) {
		this.customerInfo = customerInfo;
	}
	public BigDecimal getAllSaleQty() {
		return allSaleQty;
	}
	public void setAllSaleQty(BigDecimal allSaleQty) {
		this.allSaleQty = allSaleQty;
	}
	public BigDecimal getDiscountSaleQty() {
		return discountSaleQty;
	}
	public void setDiscountSaleQty(BigDecimal discountSaleQty) {
		this.discountSaleQty = discountSaleQty;
	}
	public List<CustomerMaterialDSInfo> getMaterialDiscountInfos() {
		return MaterialDiscountInfos;
	}
	public void setMaterialDiscountInfos(
			List<CustomerMaterialDSInfo> materialDiscountInfos) {
		MaterialDiscountInfos = materialDiscountInfos;
	}
	
}
