package com.kingdee.eas.farm.feedfactory.beans;

import java.io.Serializable;
import java.sql.Time;

/**
 * ���Ͽ� ����ʱ���¼ 
 * @author USER
 *
 */
public class DischargeDotInfo implements Serializable{

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -3128451502939684652L;
	
	// �Ͽڱ��
	private int num;
	// װ�����ʱ��
	private Time entruckingOverTime;
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public Time getEntruckingOverTime() {
		return entruckingOverTime;
	}
	public void setEntruckingOverTime(Time entruckingOverTime) {
		this.entruckingOverTime = entruckingOverTime;
	}
	
	
}
