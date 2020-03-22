package com.kingdee.eas.farm.breed.comm;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.RoundingMode;

import com.kingdee.eas.basedata.master.material.MaterialInfo;

/**
 * ��Ʒ���������Ϲ淶��ϸ
 * 
 * ������ ������ ��������Ʒ�֡������������ۺϳ���
 * @author USER
 *
 */
public class CCSendFodderStandardDetail implements Serializable{

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 5255645811784541265L;
	// ����
	private int days;
	// ��
	private MaterialInfo materialInfo;
	
	// ����������  ����
	private BigDecimal perhouseFodderQtyT;
	// ����������  ����
	private BigDecimal perhouseFodderCars;
	/**
	 * ��ȡ �����ᵥ�� �������󳵴�
	 * @return
	 */
	public int getFodderCars(int houseQty){
		if(perhouseFodderCars != null){
			
			
			BigDecimal fodderCarsRound = perhouseFodderCars.multiply(new BigDecimal(houseQty));
			// ��������
			fodderCarsRound = fodderCarsRound.divide(new BigDecimal("1"), 1, RoundingMode.HALF_UP);
			return fodderCarsRound.intValue();
		}else{
			return 0;
		}
	}
	/**
	 * ��ȡ �����ᵥ�� �������󳵴�
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
