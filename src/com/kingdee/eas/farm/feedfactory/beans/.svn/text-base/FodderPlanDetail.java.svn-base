/**
 * 
 */
package com.kingdee.eas.farm.feedfactory.beans;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Time;
import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * 饲料需求明细BEAN
 * 
 *  包括送料计划明细信息
 * @author USER
 *
 */
public class FodderPlanDetail implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 699927959666048695L;
	
	// 行号
	private int rowNum;
	// 养殖场
	private String farmType;
	private String farmID;
	private String farmNumber;
	private String farmName;
	
	// 料塔信息
	private String towerID;
	private String towerNumber;
	private String towerName;
	// 当前库存
	private BigDecimal inventory;
	// 饲料信息
	private String materialID;
	private String materialNumber;
	private String materialName;
	private String materialModel;
	
	// 要料数量
	private BigDecimal qty;
	// 要料备注
	private String farmDesc;
	// 装料料口
	private String fodderPort;
	
	/*-------------以下是送料计划字段--------------*/
	// 派车 信息
	private String truckID;
	private String truckNumber;
	private String truckName;
	private String driveName;
	private String driveTel;
	
	// 所需总车次
	private int truckCount;
	// 合并的送料的 行号
	private int mergeTruckRowNum;
	
	// 到达时间
	private Time arriveTime;
	// 备注信息
	private String description;
	
	
	@Override
	public String toString() {
		return new ToStringBuilder(this).append("\nFidderOkabDetail:farmType", farmType).append("farmID", farmID).append(
				"farmNumber", farmNumber).append("farmName", farmName).append(
				"towerID", towerID).append("towerNumber", towerNumber).append(
				"towerName", towerName).append("inventory", inventory).append(
				"materialID", materialID).append("materialNumber",
				materialNumber).append("materialName", materialName).append(
				"materialModel", materialModel).append("qty", qty).append(
				"truckID", truckID).append("truckNumber", truckNumber).append(
				"truckName", truckName).append("driveName", driveName).append(
				"driveTel", driveTel).append("arriveTime", arriveTime).append(
				"description", description).toString();
	}
	/*-------------GET SET--------------*/
	public String getFarmID() {
		return farmID;
	}
	public void setFarmID(String farmID) {
		this.farmID = farmID;
	}
	public String getFarmNumber() {
		return farmNumber;
	}
	public void setFarmNumber(String farmNumber) {
		this.farmNumber = farmNumber;
	}
	public String getFarmName() {
		return farmName;
	}
	public void setFarmName(String farmName) {
		this.farmName = farmName;
	}
	public String getTowerID() {
		return towerID;
	}
	public void setTowerID(String towerID) {
		this.towerID = towerID;
	}
	public String getTowerNumber() {
		return towerNumber;
	}
	public void setTowerNumber(String towerNumber) {
		this.towerNumber = towerNumber;
	}
	public String getTowerName() {
		return towerName;
	}
	public void setTowerName(String towerName) {
		this.towerName = towerName;
	}
	public BigDecimal getInventory() {
		return inventory;
	}
	public void setInventory(BigDecimal inventory) {
		this.inventory = inventory;
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
	public String getMaterialModel() {
		return materialModel;
	}
	public void setMaterialModel(String materialModel) {
		this.materialModel = materialModel;
	}
	public BigDecimal getQty() {
		return qty;
	}
	public void setQty(BigDecimal qty) {
		this.qty = qty;
	}
	public String getTruckID() {
		return truckID;
	}
	public void setTruckID(String truckID) {
		this.truckID = truckID;
	}
	public String getTruckNumber() {
		return truckNumber;
	}
	public void setTruckNumber(String truckNumber) {
		this.truckNumber = truckNumber;
	}
	public String getTruckName() {
		return truckName;
	}
	public void setTruckName(String truckName) {
		this.truckName = truckName;
	}
	public String getDriveName() {
		return driveName;
	}
	public void setDriveName(String driveName) {
		this.driveName = driveName;
	}
	public String getDriveTel() {
		return driveTel;
	}
	public void setDriveTel(String driveTel) {
		this.driveTel = driveTel;
	}
	public Time getArriveTime() {
		return arriveTime;
	}
	public void setArriveTime(Time arriveTime) {
		this.arriveTime = arriveTime;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public void setFarmType(String farmType) {
		this.farmType = farmType;
	}
	public String getFarmType() {
		return farmType;
	}
	public void setTruckCount(int truckCount) {
		this.truckCount = truckCount;
	}
	public int getTruckCount() {
		return truckCount;
	}
	public int getMergeTruckRowNum() {
		return mergeTruckRowNum;
	}
	public void setMergeTruckRowNum(int mergeTruckNum) {
		this.mergeTruckRowNum = mergeTruckNum;
	}
	public void setRowNum(int rowNum) {
		this.rowNum = rowNum;
	}
	public int getRowNum() {
		return rowNum;
	}
	public String getFarmDesc() {
		return farmDesc;
	}
	public void setFarmDesc(String farmDesc) {
		this.farmDesc = farmDesc;
	}
	public String getFodderPort() {
		return fodderPort;
	}
	public void setFodderPort(String fodderPort) {
		this.fodderPort = fodderPort;
	}
	

}
