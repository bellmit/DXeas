package com.kingdee.eas.farm.breed.comm;

import java.io.Serializable;

/**
 * botpִ�н��
 * @author USER
 *
 */
public class ExecBotpResultInfo implements Serializable{

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -1114215236323079048L;

	private String srcEntityBostype;   // Դ����bostype
	private String srcEntiryName;     // ԭ������������
	private String srcObjectNumber;		   // Դ���ݵ��ݱ���
	
	private String mappingName;				// ת������ ����
	private String mappingNumber;			// ת���������
	private String destEntityBostype;  // Ŀ�굥��bostype
	private String destEntityName;     // Ŀ�굥������
	private String destObjectNumber;   // Ŀ�굥�ݱ���
	private String destBillStatus;     // Ŀ�굥��״̬
	
	private String error;   // �쳣��Ϣ

	public String getSrcEntityBostype() {
		return srcEntityBostype;
	}

	public void setSrcEntityBostype(String srcEntityBostype) {
		this.srcEntityBostype = srcEntityBostype;
	}

	public String getSrcEntiryName() {
		return srcEntiryName;
	}

	public void setSrcEntiryName(String srcEntiryName) {
		this.srcEntiryName = srcEntiryName;
	}

	public String getSrcObjectNumber() {
		return srcObjectNumber;
	}

	public void setSrcObjectNumber(String srcObjectNumber) {
		this.srcObjectNumber = srcObjectNumber;
	}

	public String getMappingName() {
		return mappingName;
	}

	public void setMappingName(String mappingName) {
		this.mappingName = mappingName;
	}

	public String getMappingNumber() {
		return mappingNumber;
	}

	public void setMappingNumber(String mappingNumber) {
		this.mappingNumber = mappingNumber;
	}

	public String getDestEntityBostype() {
		return destEntityBostype;
	}

	public void setDestEntityBostype(String destEntityBostype) {
		this.destEntityBostype = destEntityBostype;
	}

	public String getDestEntityName() {
		return destEntityName;
	}

	public void setDestEntityName(String destEntityName) {
		this.destEntityName = destEntityName;
	}

	public String getDestObjectNumber() {
		return destObjectNumber;
	}

	public void setDestObjectNumber(String destObjectNumber) {
		this.destObjectNumber = destObjectNumber;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public void setDestBillStatus(String destBillStatus) {
		this.destBillStatus = destBillStatus;
	}

	public String getDestBillStatus() {
		return destBillStatus;
	}
	
	
}
