package com.kingdee.eas.farm.feedfactory.beans;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import com.kingdee.eas.farm.feedfactory.TruckState;
import com.kingdee.eas.farm.feedfactory.TruckType;

/**
 * ���ϳ�������Ϣ
 * @author USER
 *ûɶ�ô�
 */
@Deprecated 
public class TruckBaseInfo implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -305609996259651733L;
	
	// ���ϳ����
	private TruckType truckType;
	// ���ƺ�
	private String licensePlate;
	// Ƥ��
	private String tare;
	// ˾������
	private String driverName;
	// ˾���绰
	private String driverTel;
	
	// ״̬
	private TruckState statu;
	// ��������
	private Date buyDate;
	// �Ϲ�����
	private int potCount;
	// ��������
	private BigDecimal potWeight;
	// ����ʱ��
	private int loadTimes;
	
	// ж��ʱ��
	private int unloadTimes;

}
