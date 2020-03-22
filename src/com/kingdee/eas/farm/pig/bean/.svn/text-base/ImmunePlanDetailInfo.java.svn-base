package com.kingdee.eas.farm.pig.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import com.kingdee.eas.basedata.assistant.MeasureUnitInfo;
import com.kingdee.eas.basedata.master.material.MaterialInfo;
import com.kingdee.eas.farm.pig.ImmuneMode;
import com.kingdee.eas.farm.pig.PigFarmType;
import com.kingdee.eas.farm.pig.immuneSourceType;

/**
 * 免疫计划明细 BEAN
 * 保存免疫计划 基本信息  每条 是一个明细的免疫计划
 * 
 * @author Administrator
 *
 */
public class ImmunePlanDetailInfo implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -6984392623187001510L;
	
	// 猪舍类别
	private PigFarmType pigFarmType;
	// 疫苗
	private MaterialInfo immuneMaterial;
	
	// 免疫方式
	private ImmuneMode immuneMode;
	// 单位
	private MeasureUnitInfo unit;
	// 数量         （单位/头）
	private BigDecimal qtyPer;
	// 生效日期
	private Date activeDate;
	// 失效日期
	private Date disableDate;
	// 免疫开始时间
	private Date immuneBeginDate;
	// 免疫结束时间 
	private Date immuneEndDate;
	// 免疫来源
	private immuneSourceType sourceType;
	// 来源分录ID
	private String sourceEntryID;
	
	
	public immuneSourceType getSourceType() {
		return sourceType;
	}
	public void setSourceType(immuneSourceType sourceType) {
		this.sourceType = sourceType;
	}
	public String getSourceEntryID() {
		return sourceEntryID;
	}
	public void setSourceEntryID(String sourceEntryID) {
		this.sourceEntryID = sourceEntryID;
	}
	public PigFarmType getPigFarmType() {
		return pigFarmType;
	}
	public void setPigFarmType(PigFarmType pigFarmType) {
		this.pigFarmType = pigFarmType;
	}
	public MaterialInfo getImmuneMaterial() {
		return immuneMaterial;
	}
	public void setImmuneMaterial(MaterialInfo immuneMaterial) {
		this.immuneMaterial = immuneMaterial;
	}
	public ImmuneMode getImmuneMode() {
		return immuneMode;
	}
	public void setImmuneMode(ImmuneMode immuneMode) {
		this.immuneMode = immuneMode;
	}
	public MeasureUnitInfo getUnit() {
		return unit;
	}
	public void setUnit(MeasureUnitInfo unit) {
		this.unit = unit;
	}
	public BigDecimal getQtyPer() {
		return qtyPer;
	}
	public void setQtyPer(BigDecimal qtyPer) {
		this.qtyPer = qtyPer;
	}
	public Date getActiveDate() {
		return activeDate;
	}
	public void setActiveDate(Date activeDate) {
		this.activeDate = activeDate;
	}
	public Date getDisableDate() {
		return disableDate;
	}
	public void setDisableDate(Date disableDate) {
		this.disableDate = disableDate;
	}
	public Date getImmuneBeginDate() {
		return immuneBeginDate;
	}
	public void setImmuneBeginDate(Date immuneBeginDate) {
		this.immuneBeginDate = immuneBeginDate;
	}
	public Date getImmuneEndDate() {
		return immuneEndDate;
	}
	public void setImmuneEndDate(Date immuneEndDate) {
		this.immuneEndDate = immuneEndDate;
	}
}
