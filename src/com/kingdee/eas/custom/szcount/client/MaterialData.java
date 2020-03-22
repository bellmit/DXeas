package com.kingdee.eas.custom.szcount.client;

import com.kingdee.eas.basedata.master.material.MaterialInfo;

public class MaterialData {
	private MaterialInfo	materialInfo;
	private String				quantity;
	private String			materialUnit;
	private	String			finishedProductType;
	private String			materNumber;
	public String getMaterNumber() {
		return materNumber;
	}
	public void setMaterNumber(String materNumber) {
		this.materNumber = materNumber;
	}
	public String getFinishedProductType() {
		return finishedProductType;
	}
	public void setFinishedProductType(String finishedProductType) {
		this.finishedProductType = finishedProductType;
	}
	public MaterialInfo getMaterialInfo() {
		return materialInfo;
	}
	public void setMaterialInfo(MaterialInfo materialInfo) {
		this.materialInfo = materialInfo;
	}
	public String getQuantity() {
		return quantity;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	public String getMaterialUnit() {
		return materialUnit;
	}
	public void setMaterialUnit(String materialUnit) {
		this.materialUnit = materialUnit;
	}
	
}
