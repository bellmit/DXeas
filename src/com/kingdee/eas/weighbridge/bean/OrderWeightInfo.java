package com.kingdee.eas.weighbridge.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import com.kingdee.eas.weighbridge.WeighBizType;

/**
 * ����  ����ʱ��ȡ ��Ϣ
 * ������Դ�ڲɹ����������۶���
 * 
 * @author Administrator
 *
 */
public class OrderWeightInfo implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -7434864508990460602L;
	// ��������
	private String orderNumber;
	// ����ID
	private String orderID;
	// ԭ����¼ID   Ĭ��ֻ��һ�з�¼
	private String entryID;
	
	// ��������
	private Date bizDate;
	// ������ID,����,����
	private String cusSuppID;
	private String cusSuppNumber;
	private String cusSuppName;
	// ��������
	private String carNumber;
	// ������Ϣ
	private String materialID;
	private String materialNumber;
	private String materialName;
	// ������������
	private BigDecimal orderBaseQty;
//	// ���������۸�
//	private BigDecimal orderBasePrice;
//	
//	// �����۸�
//	private BigDecimal orderPrice;
	
	//����
	private BigDecimal bagQty;
	private String carId;
	
	private WeighBizType weighBizType;
	
	public String getCarId() {
		return carId;
	}
	public void setCarId(String carId) {
		this.carId = carId;
	}
	// ����״̬
	private com.kingdee.eas.scm.common.BillBaseStatusEnum baseStatusEnum;
	
	public String getOrderNumber() {
		return orderNumber;
	}
	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}
	public String getOrderID() {
		return orderID;
	}
	public void setOrderID(String orderID) {
		this.orderID = orderID;
	}
	
	public String getCarNumber() {
		return carNumber;
	}
	public void setCarNumber(String carNumber) {
		this.carNumber = carNumber;
	}
	public String getMaterialID() {
		return materialID;
	}
	public void setMaterialID(String materialID) {
		this.materialID = materialID;
	}
	public String getMaterialNumber() {
		return materialNumber;
	}
	public void setMaterialNumber(String materialNumber) {
		this.materialNumber = materialNumber;
	}
	public String getMaterialName() {
		return materialName;
	}
	public void setMaterialName(String materialName) {
		this.materialName = materialName;
	}
	public BigDecimal getOrderBaseQty() {
		return orderBaseQty;
	}
	public void setOrderBaseQty(BigDecimal orderBaseQty) {
		this.orderBaseQty = orderBaseQty;
	}
	public String getCusSuppID() {
		return cusSuppID;
	}
	public void setCusSuppID(String cusSuppID) {
		this.cusSuppID = cusSuppID;
	}
	public String getCusSuppNumber() {
		return cusSuppNumber;
	}
	public void setCusSuppNumber(String cusSuppNumber) {
		this.cusSuppNumber = cusSuppNumber;
	}
	public String getCusSuppName() {
		return cusSuppName;
	}
	public void setCusSuppName(String cusSuppName) {
		this.cusSuppName = cusSuppName;
	}
	public com.kingdee.eas.scm.common.BillBaseStatusEnum getBaseStatusEnum() {
		return baseStatusEnum;
	}
	public void setBaseStatusEnum(
			com.kingdee.eas.scm.common.BillBaseStatusEnum baseStatusEnum) {
		this.baseStatusEnum = baseStatusEnum;
	}
	public Date getBizDate() {
		return bizDate;
	}
	public void setBizDate(Date bizDate) {
		this.bizDate = bizDate;
	}
	public BigDecimal getBagQty() {
		return bagQty;
	}
	public void setBagQty(BigDecimal bagQty) {
		this.bagQty = bagQty;
	}
	public String getEntryID() {
		return entryID;
	}
	public void setEntryID(String entryID) {
		this.entryID = entryID;
	}
	public WeighBizType getWeighBizType() {
		return weighBizType;
	}
	public void setWeighBizType(WeighBizType weighBizType) {
		this.weighBizType = weighBizType;
	}

//	public BigDecimal getOrderBasePrice() {
//		return orderBasePrice;
//	}
//	public void setOrderBasePrice(BigDecimal orderBasePrice) {
//		this.orderBasePrice = orderBasePrice;
//	}
//	public BigDecimal getOrderPrice() {
//		return orderPrice;
//	}
//	public void setOrderPrice(BigDecimal orderPrice) {
//		this.orderPrice = orderPrice;
//	}
}
