package com.kingdee.eas.farm.breed.comm;

import java.io.Serializable;
import java.util.LinkedList;

import com.kingdee.eas.farm.breed.HenhouseInfo;
import com.kingdee.eas.farm.breed.ParentBreedBatchTransEntryInfo;

/**
 * ������ϸ��ϸ��Ϣ
 * @author USER
 *
 */
public class ParentBreedBatchEntryDetailInfo implements Serializable {
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -7303517468202786070L;
	private HenhouseInfo henhouse;
	// ��Ʒ�� �����ɼ� ������������̭�������������ѳ���������ǰ������
	private int initQty;
	private int fixedInitQty; // �൱�ڳ�ʼ������������ת����ĳ�ʼ����
	private int culledQty;
	private int deadQty;
	private int nowQty;
	private int marketQty;
	private int transQty; // ת����
	// �������ֹ���ĸ���ֱ𱣴�
	private int henInitQty;
	private int henFixedInitQty; // �൱�ڳ�ʼ������������ת����ĳ�ʼ����
	private int henCulledQty;
	private int henDeadQty;
	private int henNowQty;
	
	private int cockInitQty;
	private int cockFixedInitQty; // �൱�ڳ�ʼ������������ת����ĳ�ʼ����
	private int cockCulledQty;
	private int cockDeadQty;
	private int cockNowQty;
	// ת����ϸ
	private LinkedList<ParentBreedBatchTransEntryInfo> transInDetails;
	private LinkedList<ParentBreedBatchTransEntryInfo> transOutDetails;
	// ĸ�� ת����Ϣ
	private int henTransOutQty;
	private int henTransOutAsInitQty;
	
	private int henTransInQty;
	private int henTransInAsInitQty;
	// �ۺ��ֵ�����
	private int transOutEggQty;
	private int transInEggQty;

	// ����ת����Ϣ
	private int cockTransOutQty;
	private int cockTransOutAsInitQty;
	private int cockTransInQty;
	private int cockTransInAsInitQty;
	
	
	
	
	public HenhouseInfo getHenhouse() {
		return henhouse;
	}
	public void setHenhouse(HenhouseInfo henhouse) {
		this.henhouse = henhouse;
	}
	public int getInitQty() {
		return initQty;
	}
	public void setInitQty(int initQty) {
		this.initQty = initQty;
	}
	public int getCulledQty() {
		return culledQty;
	}
	public void setCulledQty(int culledQty) {
		this.culledQty = culledQty;
	}
	public int getDeadQty() {
		return deadQty;
	}
	public void setDeadQty(int deadQty) {
		this.deadQty = deadQty;
	}
	public int getNowQty() {
		return nowQty;
	}
	public void setNowQty(int nowQty) {
		this.nowQty = nowQty;
	}
	public int getHenInitQty() {
		return henInitQty;
	}
	public void setHenInitQty(int henInitQty) {
		this.henInitQty = henInitQty;
	}
	public int getHenCulledQty() {
		return henCulledQty;
	}
	public void setHenCulledQty(int henCulledQty) {
		this.henCulledQty = henCulledQty;
	}
	public int getHenDeadQty() {
		return henDeadQty;
	}
	public void setHenDeadQty(int henDeadQty) {
		this.henDeadQty = henDeadQty;
	}
	public int getHenNowQty() {
		return henNowQty;
	}
	public void setHenNowQty(int henNowQty) {
		this.henNowQty = henNowQty;
	}
	public int getCockInitQty() {
		return cockInitQty;
	}
	public void setCockInitQty(int cockInitQty) {
		this.cockInitQty = cockInitQty;
	}
	public int getCockCulledQty() {
		return cockCulledQty;
	}
	public void setCockCulledQty(int cockCulledQty) {
		this.cockCulledQty = cockCulledQty;
	}
	public int getCockDeadQty() {
		return cockDeadQty;
	}
	public void setCockDeadQty(int cockDeadQty) {
		this.cockDeadQty = cockDeadQty;
	}
	public int getCockNowQty() {
		return cockNowQty;
	}
	public void setCockNowQty(int cockNowQty) {
		this.cockNowQty = cockNowQty;
	}
	public int getMarketQty() {
		return marketQty;
	}
	public void setMarketQty(int marketQty) {
		this.marketQty = marketQty;
	}
	public void setTransQty(int transQty) {
		this.transQty = transQty;
	}
	public int getTransQty() {
		return transQty;
	}
	public int getHenTransOutQty() {
		return henTransOutQty;
	}
	public void setHenTransOutQty(int henTransOutQty) {
		this.henTransOutQty = henTransOutQty;
	}
	public int getHenTransOutAsInitQty() {
		return henTransOutAsInitQty;
	}
	public void setHenTransOutAsInitQty(int henTransOutAsInitQty) {
		this.henTransOutAsInitQty = henTransOutAsInitQty;
	}
	
	public int getHenTransInQty() {
		return henTransInQty;
	}
	public void setHenTransInQty(int henTransInQty) {
		this.henTransInQty = henTransInQty;
	}
	public int getHenTransInAsInitQty() {
		return henTransInAsInitQty;
	}
	public void setHenTransInAsInitQty(int henTransInAsInitQty) {
		this.henTransInAsInitQty = henTransInAsInitQty;
	}
	
	public int getCockTransOutQty() {
		return cockTransOutQty;
	}
	public void setCockTransOutQty(int cockTransOutQty) {
		this.cockTransOutQty = cockTransOutQty;
	}
	public int getCockTransOutAsInitQty() {
		return cockTransOutAsInitQty;
	}
	public void setCockTransOutAsInitQty(int cockTransOutAsInitQty) {
		this.cockTransOutAsInitQty = cockTransOutAsInitQty;
	}
	
	public int getCockTransInQty() {
		return cockTransInQty;
	}
	public void setCockTransInQty(int cockTransInQty) {
		this.cockTransInQty = cockTransInQty;
	}
	public int getCockTransInAsInitQty() {
		return cockTransInAsInitQty;
	}
	public void setCockTransInAsInitQty(int cockTransInAsInitQty) {
		this.cockTransInAsInitQty = cockTransInAsInitQty;
	}
	
	public LinkedList<ParentBreedBatchTransEntryInfo> getTransInDetails() {
		return transInDetails;
	}
	public void setTransInDetails(
			LinkedList<ParentBreedBatchTransEntryInfo> transInDetails) {
		this.transInDetails = transInDetails;
	}
	public LinkedList<ParentBreedBatchTransEntryInfo> getTransOutDetails() {
		return transOutDetails;
	}
	public void setTransOutDetails(
			LinkedList<ParentBreedBatchTransEntryInfo> transOutDetails) {
		this.transOutDetails = transOutDetails;
	}
	public int getTransOutEggQty() {
		return transOutEggQty;
	}
	public void setTransOutEggQty(int transOutEggQty) {
		this.transOutEggQty = transOutEggQty;
	}
	public int getTransInEggQty() {
		return transInEggQty;
	}
	public void setTransInEggQty(int transInEggQty) {
		this.transInEggQty = transInEggQty;
	}
	public int getFixedInitQty() {
		return fixedInitQty;
	}
	public void setFixedInitQty(int fixedInitQty) {
		this.fixedInitQty = fixedInitQty;
	}
	public int getHenFixedInitQty() {
		return henFixedInitQty;
	}
	public void setHenFixedInitQty(int henFixedInitQty) {
		this.henFixedInitQty = henFixedInitQty;
	}
	public int getCockFixedInitQty() {
		return cockFixedInitQty;
	}
	public void setCockFixedInitQty(int cockFixedInitQty) {
		this.cockFixedInitQty = cockFixedInitQty;
	}
	
}
