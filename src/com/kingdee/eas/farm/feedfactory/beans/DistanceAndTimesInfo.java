package com.kingdee.eas.farm.feedfactory.beans;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * ���������ʱ��BEAN
 * @author USER
 *
 */
public class DistanceAndTimesInfo implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 8182070464918582533L;
	
	// ���
	private String beginPlace;
	// �յ�
	private String endPlace;
	
	// ����
	private BigDecimal distance;
	// �Ƿ��س�
	private boolean isLoadFooder;
	// ����ʱ��
	private int minutes;
	
	
	public String getBeginPlace() {
		return beginPlace;
	}
	public void setBeginPlace(String beginPlace) {
		this.beginPlace = beginPlace;
	}
	public String getEndPlace() {
		return endPlace;
	}
	public void setEndPlace(String endPlace) {
		this.endPlace = endPlace;
	}
	public BigDecimal getDistance() {
		return distance;
	}
	public void setDistance(BigDecimal distance) {
		this.distance = distance;
	}
	public boolean isLoadFooder() {
		return isLoadFooder;
	}
	public void setLoadFooder(boolean isLoadFooder) {
		this.isLoadFooder = isLoadFooder;
	}
	public int getMinutes() {
		return minutes;
	}
	public void setMinutes(int minutes) {
		this.minutes = minutes;
	}
}
