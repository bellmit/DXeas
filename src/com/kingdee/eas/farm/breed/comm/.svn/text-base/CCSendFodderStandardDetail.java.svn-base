package com.kingdee.eas.farm.breed.comm;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.RoundingMode;

import com.kingdee.eas.basedata.master.material.MaterialInfo;

/**
 * 商品鸡饲料送料规范明细
 * 
 * 单日龄 单鸡舍 所需饲料品种、饲料数量、折合车次
 * @author USER
 *
 */
public class CCSendFodderStandardDetail implements Serializable{

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 5255645811784541265L;
	// 日龄
	private int days;
	// 料
	private MaterialInfo materialInfo;
	
	// 单舍需料量  吨数
	private BigDecimal perhouseFodderQtyT;
	// 单舍需料量  车次
	private BigDecimal perhouseFodderCars;
	/**
	 * 获取 两个舍单日 饲料需求车次
	 * @return
	 */
	public int getFodderCars(int houseQty){
		if(perhouseFodderCars != null){
			
			
			BigDecimal fodderCarsRound = perhouseFodderCars.multiply(new BigDecimal(houseQty));
			// 四舍五入
			fodderCarsRound = fodderCarsRound.divide(new BigDecimal("1"), 1, RoundingMode.HALF_UP);
			return fodderCarsRound.intValue();
		}else{
			return 0;
		}
	}
	/**
	 * 获取 两个舍单日 饲料需求车次
	 * @return
	 */
	public int getTwohouseFodderCars(){
		if(perhouseFodderCars != null){
			BigDecimal fodderCars = perhouseFodderCars.multiply(new BigDecimal("2"));
			
			BigDecimal fodderCarsRound = fodderCars.divide(new BigDecimal("1"), 0, RoundingMode.HALF_UP);
			return fodderCarsRound.intValue();
		}else{
			return 0;
		}
	}
	
	
	
	public int getDays() {
		return days;
	}
	public void setDays(int days) {
		this.days = days;
	}
	public MaterialInfo getMaterialInfo() {
		return materialInfo;
	}
	public void setMaterialInfo(MaterialInfo materialInfo) {
		this.materialInfo = materialInfo;
	}
	public BigDecimal getPerhouseFodderQtyT() {
		return perhouseFodderQtyT;
	}
	public void setPerhouseFodderQtyT(BigDecimal perhouseFodderQtyT) {
		this.perhouseFodderQtyT = perhouseFodderQtyT;
	}
	public BigDecimal getPerhouseFodderCars() {
		return perhouseFodderCars;
	}
	public void setPerhouseFodderCars(BigDecimal perhouseFodderCars) {
		this.perhouseFodderCars = perhouseFodderCars;
	}
	
	
	
}
