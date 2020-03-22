package com.kingdee.eas.farm.food.app;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.Context;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.bos.metadata.entity.FilterInfo;
import com.kingdee.bos.metadata.entity.FilterItemInfo;
import com.kingdee.bos.metadata.query.util.CompareType;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.delivery.basedata.DeliveryLineCollection;
import com.kingdee.eas.delivery.basedata.DeliveryLineFactory;
import com.kingdee.eas.delivery.basedata.DeliveryLineInfo;
import com.kingdee.eas.farm.breed.comm.CCBatchAgeDetailInfo;
import com.kingdee.eas.farm.breed.comm.CCBatchAgeInfo;
import com.kingdee.eas.farm.food.FoodBaseDataCollection;
import com.kingdee.eas.farm.food.FoodBaseDataFactory;
import com.kingdee.eas.farm.food.FoodBaseDataInfo;
import com.kingdee.eas.farm.rpt.CCProductPlanRptCommonFacadeFactory;
import com.kingdee.eas.farm.rpt.app.CCProductPlanRptBean;
import com.kingdee.eas.util.app.DbUtil;
import com.kingdee.jdbc.rowset.IRowSet;
import com.kingdee.util.NumericExceptionSubItem;

public class SendCarPlanFacadeControllerBean extends AbstractSendCarPlanFacadeControllerBean {
	private static Logger logger = Logger.getLogger("com.kingdee.eas.farm.food.app.SendCarPlanFacadeControllerBean");

	@Override
	protected ArrayList _getRowSet(Context ctx, HashMap hashMap) throws BOSException, EASBizException {
		int transferTime=(Integer) hashMap.get("transferTime");//ת��ʱ��
		if(transferTime>0)
			return getSendPlan4(ctx, hashMap);
		else
			return getSendPlan1(ctx, hashMap);
	}

	protected ArrayList getSendPlan1(Context ctx, HashMap hashMap) throws BOSException, EASBizException {

		String storageOrgID = (String) hashMap.get("storageOrgID");// ��ǰ�����֯
		int carCount = (Integer) hashMap.get("carCount");// ��������
		Timestamp beginHitchTime = (Timestamp) hashMap.get("hitchTime");// ��ʼ�Ҽ�ʱ��
		int transferTime=(Integer) hashMap.get("transferTime");//ת��ʱ��

		ArrayList<HashMap<String, Object>> tempCarList = new ArrayList<HashMap<String, Object>>();// ��ʱ��������
		// HashMap<Integer,Object> carMap=new HashMap<Integer,Object>();//��������
		// for(int i=0;i<carCount;i++) {
		// tempCarList.add(new HashMap<String,Object>());
		// // carMap.put(i, null);//��ʼʱ��Ϊ��ʼ�Ҽ�ʱ��
		// }

		FoodBaseDataInfo dataSettingInfo = this.getDataSettingInfo(ctx, storageOrgID);
		int basketUnitQty = dataSettingInfo.getUnitQty().intValue();// ƽ��ÿ������
		int basketQty = dataSettingInfo.getBasketQty();// ����
		if (basketQty <= 0)
			basketQty = 210;
		int everyCarQty = basketUnitQty * basketQty;// ÿ��������
		int everyCarCount = dataSettingInfo.getEveryCarCount();// ÿ���ɳ�����
		if (everyCarCount <= 0) {
			everyCarCount = 2;
		}
		if (carCount % everyCarCount > 0) {
			throw new EASBizException(new NumericExceptionSubItem("001", "���ɳ�������Ϊÿ���ɳ�������������"));
		}
		BigDecimal avgHitchTime = dataSettingInfo.getCarHandlingTime();//ÿ��װжʱ��//;dataSettingInfo.getHitchTime();// ÿ���Ҽ�ʱ��
		if(avgHitchTime==null) {
			avgHitchTime=BigDecimal.ZERO;
		}
		BigDecimal avgWeightTime=dataSettingInfo.getWeghtTimeCost();//ÿ������ʱ��
		if(avgWeightTime==null) {
			avgWeightTime=BigDecimal.ZERO;
		}
		BigDecimal avgCatchTime = dataSettingInfo.getCatchTime();// ÿ��ץ��ʱ��

		int avgTime;// ÿ���г�ʱ��
		
		ArrayList<Object> tempList = new ArrayList<Object>();//(ArrayList<Object>) hashMap.get("details");
		ArrayList<Object> dataList = (ArrayList<Object>) hashMap.get("details");
		//������Ʒ��������
		String orgID,orgIDKeep = "";
		BigDecimal sumQty=BigDecimal.ZERO,tempQtyBigDecimal=BigDecimal.ZERO;
		HashMap<String,Object> tempMap1,tempMap2;
		for(int index=0;index<dataList.size();index++) {
			tempMap1=(HashMap<String, Object>) dataList.get(index);
			orgID=(String) tempMap1.get("orgID");
			tempQtyBigDecimal=(BigDecimal) tempMap1.get("qty");
			if(index==0) {
				orgIDKeep=orgID;
			}
			if(!orgIDKeep.equals(orgID)) {
				HashMap<String, Object> tempMap=new HashMap<String, Object>();
				tempMap.put("orgID", orgIDKeep);
				tempMap.put("qty", sumQty);
				tempList.add(tempMap);
				orgIDKeep=orgID;
				sumQty=BigDecimal.ZERO;
			}
			sumQty=sumQty.add(tempQtyBigDecimal);
			if(index==(dataList.size()-1)) {//���һ��
				HashMap<String, Object> tempMap=new HashMap<String, Object>();
				tempMap.put("orgID", orgIDKeep);
				tempMap.put("qty", sumQty);
				tempList.add(tempMap);
			}
		}

		
		HashMap<String, Object> tempMap;
		String  batchID, henhouseID;
		int dayAge, qty, tempQty;
		int nowIndex = 0;// ������
		int round=0;//�ִ�
		Date tempStartTime = null;// ����ʱ��
		Date tempReachTime;// ����ʱ��
		Date tempBeginCatchTime;//��ʼץ��ʱ��
		Date tempLeaveTime;// �뿪����ʱ��
		Date tempBackTime;// ����ʳƷ��ʱ��
		Date tempStartTime2 = null;// �ٴγ���ʱ��
		Calendar cal = java.util.Calendar.getInstance();
		cal.setTime(beginHitchTime);// ������ʼʱ��Ϊ��ʼ�Ҽ�ʱ��
		cal.add(Calendar.MINUTE, (-1)*avgWeightTime.intValue());//add 20150729 ��ȥ����ʱ��
		ArrayList<HashMap<String, Object>> list = new ArrayList<HashMap<String, Object>>();// ���ؽ����
		// HashMap<String,Object> tempCarMap=new
		// HashMap<String,Object>();//������ʱ����
		int carIndex = 0;// ����˳������
		try {
			int j = 0;
			orgIDKeep="";
			for (int index = 0; index < tempList.size(); index++) {
				tempMap = (HashMap<String, Object>) tempList.get(index);
				orgID = (String) tempMap.get("orgID");// ��ֳ�� �����֯id
				// batchID=(String) tempMap.get("batchID");// ����id
				// henhouseID=(String) tempMap.get("henhouseID");//����id
				// dayAge=((BigDecimal) tempMap.get("dayAge")).intValue();//����
				qty = ((BigDecimal) tempMap.get("qty")).intValue();
				;// ����
				tempQty = qty;

				avgTime = getAvgTime(ctx, storageOrgID, orgID)[0];// ÿ���г�ʱ��
				
				//*******
				if(index==0){
					orgIDKeep=orgID;
				}
				if(!orgIDKeep.equalsIgnoreCase(orgID)) {//�����ֳ���ı䣬ȥ����ֳ����Ĭ���ɳ��� ���һ�в��ô���
					carCount=getAvgTime(ctx, storageOrgID, orgID)[1];//����֯��Ĭ���ɳ���
					orgIDKeep=orgID;
				}
				//*************
				
				while (true) {// ���������Ϊ0��һֱѭ���ݼ�;
					if (nowIndex == 0) {// ��һ��ִ�� ���㿪ʼʱ��
						round=0;
						cal.add(Calendar.MINUTE, (-1) * avgCatchTime.intValue());// ��ȥץ��ʱ��
						cal.add(Calendar.MINUTE, (-1) * 2 * avgTime);// ��ȥ·;ʱ��
						tempStartTime = cal.getTime();
					} else {
						if ((carIndex + 1) > carCount) {// �������>�ܳ�����=�µ�һ��
							carIndex = 0;
							round++;
							tempStartTime=getDateByRound(list, carIndex, "tempStartTime2", round-1);//��һ�ֵ��ٴγ���ʱ��
						} else {//�����µ�һ��
							if(round<1) {//��һ��
								tempStartTime = getDateByRound(list, carIndex-everyCarCount, "tempStartTime", round);//������һ���εĳ���ʱ��
								cal.setTime(tempStartTime);
								cal.add(Calendar.MINUTE, avgCatchTime.intValue());// ����ץ��ʱ��
								tempStartTime = cal.getTime();
							}else {
								tempStartTime=getDateByRound(list, carIndex, "tempStartTime2", round-1);//��һ�ֵ��ٴγ���ʱ��
							}
						}
					}
					cal.setTime(tempStartTime);
					cal.add(Calendar.MINUTE, avgTime);// ����·;ʱ��
					tempReachTime = cal.getTime();//������ֳ��ʱ��
					if(round>0) {//���ǵ�һ��
						Date tempD;
						if(carIndex<everyCarCount) {//�������С�� ÿ���ɳ��� �� ��ǰһ�ֵĵ�һ�� 
							tempD=getDateByRound(list, carCount-1, "tempLeaveTime", round-1);//�����뿪����ʱ��
							if(tempReachTime.compareTo(tempD)>0) {//����ʱ�����һ���뿪������ʱ������ץ��ʱ��Ϊ����ʱ��
								tempD=tempReachTime;
							}
						}else { 
							tempD=getDateByRound(list, carIndex-everyCarCount, "tempLeaveTime", round);//������һ���εĳ���ʱ��
						}
						cal.setTime(tempD);
					}
					tempBeginCatchTime=cal.getTime();//��ʼץ��ʱ��
					cal.add(Calendar.MINUTE, avgCatchTime.intValue());// ����ץ��ʱ��
					tempLeaveTime = cal.getTime(); 
					cal.add(Calendar.MINUTE, avgTime);// ����·;ʱ��
					tempBackTime = cal.getTime();//����ʳƷ��ʱ��
					cal.add(Calendar.MINUTE, avgWeightTime.intValue());//���Ϲ���ʱ��
					cal.add(Calendar.MINUTE, avgHitchTime.intValue());//����װ��ʱ��
					tempStartTime2 = cal.getTime();// �ٴγ���ʱ��

					// nowIndex++;

					for (; j < everyCarCount;) {// ����ÿ�η����� ���ӷ��ؼ�¼
						HashMap<String, Object> map = new HashMap<String, Object>();
						map.put("orgID", orgID);
						map.put("carNo", carIndex);// ��ǰ��������
						map.put("storageOrgUnitID", orgID);
						map.put("tempStartTime", tempStartTime);
						map.put("tempReachTime", tempReachTime);
						map.put("tempBeginCatchTime", tempBeginCatchTime);//��ʼץ��ʱ��
						map.put("tempLeaveTime", tempLeaveTime);
						map.put("tempBackTime", tempBackTime);
						map.put("tempStartTime2", tempStartTime2);
						map.put("round", round);

						/*
						 * HashMap<String,Object> tempCarMap=new
						 * HashMap<String,Object>();//������ʱ����
						 * tempCarMap.put("carNo", carIndex);//���泵��
						 * tempCarMap.put("startTime", tempStartTime);//�������淢��ʱ��
						 * tempCarMap.put("startTime2", tempStartTime2);//��������
						 * �ٷ���ʱ�� tempCarList.add(tempCarMap)
						 */;
						nowIndex++;
						carIndex++;// �������+1
						if (tempQty > everyCarQty) {
							map.put("qty", everyCarQty);
							tempQty -= everyCarQty;
						} else {
							map.put("qty", tempQty);
							tempQty = 0;
						}
						list.add(map);// ���List
						j++;
						if (tempQty <= 0) {
							break;
						}
						if ((carIndex + 1) > carCount) {// ��ǰ������=�ճ�����
							break;
						}
						if (carCount < everyCarCount) {// ������<ÿ�η�����
							break;
						}
					}
					if (tempQty <= 0) {
						break;
					}
					j = 0;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	/**
	 * ��� ת��ʱ��
	 * @param ctx
	 * @param hashMap
	 * @return
	 * @throws BOSException
	 * @throws EASBizException
	 */
	protected ArrayList getSendPlan4(Context ctx, HashMap hashMap) throws BOSException, EASBizException {

		String storageOrgID = (String) hashMap.get("storageOrgID");// ��ǰ�����֯
		int carCount = (Integer) hashMap.get("carCount");// ��������
		Timestamp beginHitchTime = (Timestamp) hashMap.get("hitchTime");// ��ʼ�Ҽ�ʱ��
		int transferTime=(Integer) hashMap.get("transferTime");//ת��ʱ��
		BigDecimal allQty=(BigDecimal) hashMap.get("allQty");//�ֹ��޸���ʱ��
		//Boolean isAhead=(Boolean) hashMap.get("isAhead");//�Ƿ���ǰ���������ת��ʱ��
		Boolean isAhead=true;
		if(transferTime<=0)
			isAhead=false;
		int aheadTime=(Integer) hashMap.get("aheadTime");//��ǰ����ʱ��
		
		ArrayList<HashMap<String, Object>> tempCarList = new ArrayList<HashMap<String, Object>>();// ��ʱ��������

		FoodBaseDataInfo dataSettingInfo = this.getDataSettingInfo(ctx, storageOrgID);
		int basketUnitQty = dataSettingInfo.getUnitQty().intValue();// ƽ��ÿ������
		int basketQty = dataSettingInfo.getBasketQty();// ����
		if (basketQty <= 0)
			basketQty = 210;
		int everyCarQty = basketUnitQty * basketQty;// ÿ��������
		int everyCarCount = dataSettingInfo.getEveryCarCount();// ÿ���ɳ�����
		if (everyCarCount <= 0) {
			everyCarCount = 2;
		}
		if (carCount % everyCarCount > 0) {
			throw new EASBizException(new NumericExceptionSubItem("001", "���ɳ�������Ϊÿ���ɳ�������������"));
		}
		BigDecimal carHandlingTime = dataSettingInfo.getCarHandlingTime();//ÿ��װжʱ��//;dataSettingInfo.getHitchTime();// ÿ���Ҽ�ʱ��
		if(carHandlingTime==null) {//avgHitchTime
			carHandlingTime=BigDecimal.ZERO;
		}
		BigDecimal avgHitchTime=dataSettingInfo.getHitchTime();//ÿ���Ҽ�ʱ��
		
		BigDecimal avgWeightTime=dataSettingInfo.getWeghtTimeCost();//ÿ������ʱ��
		if(avgWeightTime==null) {
			avgWeightTime=BigDecimal.ZERO;
		}
		BigDecimal avgCatchTime = dataSettingInfo.getCatchTime();// ÿ��ץ��ʱ��
		
		BigDecimal transDeviceTime= dataSettingInfo.getTransDeviceTime();// ץ���豸ת��ʱ��
		if(transDeviceTime==null)
			transDeviceTime=BigDecimal.ZERO;

		String orgID,orgIDKeep = "";
		HashMap<String,Object> tempMap1;
//		HashMap<String, BigDecimal> companyMinQtyMap = new HashMap<String, BigDecimal>();//��˾��������������
		HashMap<String, Integer> companyHenhouseCountMap = new HashMap<String, Integer>();//��˾�������������
		BigDecimal tempQty1,tempQty2;
		ArrayList<Object> dataList = (ArrayList<Object>) hashMap.get("details");//��Ҫִ�еķ�¼
		//�õ�ÿ����˾ �ļ�����
		for(int index=0;index<dataList.size();index++) {
			tempMap1=(HashMap<String, Object>) dataList.get(index);
			orgID=(String)tempMap1.get("orgID");
//			tempQty1=(BigDecimal) tempMap1.get("qty");
			if(!companyHenhouseCountMap.containsKey(orgID)) {
				companyHenhouseCountMap.put(orgID, 0);
			}
			companyHenhouseCountMap.put(orgID, companyHenhouseCountMap.get(orgID)+1);
			//�����������˾
			/*if(!companyMinQtyMap.containsKey(orgID)) {
				companyMinQtyMap.put(orgID, tempQty1);
				companyHenhouseCountMap.put(orgID, 1);
			}else {
				tempQty2=companyMinQtyMap.get(orgID);
				companyHenhouseCountMap.put(orgID, companyHenhouseCountMap.get(orgID)+1);
				if(tempQty2.compareTo(tempQty1)>0) {
					companyMinQtyMap.put(orgID, tempQty1);
				}
			}*/
		}
		
		BigDecimal sumQty=BigDecimal.ZERO;
		tempQty1=BigDecimal.ZERO;
		ArrayList<HashMap<String,Object>> tempList=new ArrayList<HashMap<String,Object>>();
		//��ȡ��������������̯
		for(int index=0;index<dataList.size();index++) {
			tempMap1=(HashMap<String, Object>) dataList.get(index);
			tempQty1=(BigDecimal) tempMap1.get("qty");
			sumQty=sumQty.add(tempQty1);
		}
		
		BigDecimal proportion=allQty.divide(sumQty,BigDecimal.ROUND_HALF_UP,4);//�������  �Զ���������ԭʼ����
		if(proportion==null||proportion.compareTo(BigDecimal.ZERO)==0) {
			proportion=BigDecimal.ONE;
		}
		
		sumQty=BigDecimal.ZERO;
		tempQty1=BigDecimal.ZERO;
		//��˾������ʼ�ۼ�
		for(int index=0;index<dataList.size();index++) {
			tempMap1=(HashMap<String, Object>) dataList.get(index);
			orgID=(String) tempMap1.get("orgID");
			tempQty1=(BigDecimal) tempMap1.get("qty");
			if(index==0) {
				orgIDKeep=orgID;
			}
			if(!orgIDKeep.equals(orgID)) {
				HashMap<String, Object> tempMap=new HashMap<String, Object>();
				tempMap.put("orgID", orgIDKeep);
				tempMap.put("qty", sumQty);
				tempList.add(tempMap);
				orgIDKeep=orgID;
				sumQty=BigDecimal.ZERO;
			}
			sumQty=sumQty.add(tempQty1);
			if(index==(dataList.size()-1)) {//���һ��
				HashMap<String, Object> tempMap=new HashMap<String, Object>();
				tempMap.put("orgID", orgIDKeep);
				tempMap.put("qty", sumQty);
				tempList.add(tempMap);
			}
		}
		

		int avgTime;// ÿ���г�ʱ��
		HashMap<String, Object> tempMap;
		String  batchID, henhouseID;
		int dayAge, qty,tempQty,avgQty,transCount,nowTransCount;
		int nowIndex = 0;// ������
		int round=0;//�ִ�
		Date tempStartTime = null;// ����ʱ��
		Date tempReachTime;// ����ʱ��
		Date tempBeginCatchTime;//��ʼץ��ʱ��
		Date tempLeaveTime;// �뿪����ʱ��
		Date tempBackTime;// ����ʳƷ��ʱ��
		Date tempHitchTime=null;// �Ҽ�ʱ��
		Date tempStartTime2 = null;// �ٴγ���ʱ��
		Calendar cal = java.util.Calendar.getInstance();
		cal.setTime(beginHitchTime);// ������ʼʱ��Ϊ��ʼ�Ҽ�ʱ��
		cal.add(Calendar.MINUTE, (-1)*avgWeightTime.intValue());//add 20150729 ��ȥ����ʱ��
		ArrayList<HashMap<String, Object>> list = new ArrayList<HashMap<String, Object>>();// ���ؽ����
		// HashMap<String,Object> tempCarMap=new
		// HashMap<String,Object>();//������ʱ����
		Calendar cal2 = java.util.Calendar.getInstance();//�Ҽ�ʱ�仺��
		cal2.setTime(beginHitchTime);// ������ʼʱ��Ϊ��ʼ�Ҽ�ʱ��
		int carIndex = 0;// ����˳������
		try {
			int j = 0;
			for (int index = 0; index < tempList.size(); index++) {
				tempMap = (HashMap<String, Object>) tempList.get(index);
				orgID = (String) tempMap.get("orgID");// ��ֳ�� �����֯id
				// batchID=(String) tempMap.get("batchID");// ����id
				// henhouseID=(String) tempMap.get("henhouseID");//����id
				// dayAge=((BigDecimal) tempMap.get("dayAge")).intValue();//����
				qty = ((BigDecimal) tempMap.get("qty")).multiply(proportion).intValue();
				;// ����
				tempQty = qty;
				
				avgQty=0;//����֯������ƽ������
				transCount=0;//��ת�����
				nowTransCount=0;
				if(companyHenhouseCountMap.get(orgID)!=null){
					avgQty=qty/companyHenhouseCountMap.get(orgID).intValue();//ƽ����������
					if(companyHenhouseCountMap.get(orgID)>everyCarCount)//��������>ÿ���ɳ���
						transCount=companyHenhouseCountMap.get(orgID)/everyCarCount;//������/ÿ�γ���=ת�����
				}

				avgTime = getAvgTime(ctx, storageOrgID, orgID)[0];// ÿ���г�ʱ��
				
				//*******
				if(index==0){
					orgIDKeep=orgID;
				}
				if(!orgIDKeep.equalsIgnoreCase(orgID)) {//�����ֳ���ı䣬ȥ����ֳ����Ĭ���ɳ��� ���һ�в��ô���
					carCount=getAvgTime(ctx, storageOrgID, orgID)[1];//����֯��Ĭ���ɳ���
					orgIDKeep=orgID;
//					cal.add(Calendar.MINUTE, transDeviceTime.intValue());// �����Ļ���ת���豸ʱ��
				}
				//*************
				
				while (true) {// ���������Ϊ0��һֱѭ���ݼ�;
					if (nowIndex == 0) {// ��һ��ִ�� ���㿪ʼʱ��
						round=0;
						if(aheadTime>0) {//��ǰ����
							cal.add(Calendar.MINUTE, (-1) * aheadTime);// ��ȥ��ǰ����ʱ��
						}
						cal.add(Calendar.MINUTE, (-1) * avgCatchTime.intValue());// ��ȥץ��ʱ��
						cal.add(Calendar.MINUTE, (-1) * 2 * avgTime);// ��ȥ·;ʱ��
						tempStartTime = cal.getTime();
						tempHitchTime=beginHitchTime;//�Ҽ�ʱ��
					} else {
						if ((carIndex + 1) > carCount) {// �������>�ܳ�����=�µ�һ��
							carIndex = 0;
							round++;
							tempStartTime=getDateByRound(list, carIndex, "tempStartTime2", round-1);//��һ�ֵ��ٴγ���ʱ��
						} else {//�����µ�һ��
							if(round<1) {//��һ��
								tempStartTime = getDateByRound(list, carIndex-everyCarCount, "tempStartTime", round);//������һ���εĳ���ʱ��
								cal.setTime(tempStartTime);
								cal.add(Calendar.MINUTE, avgCatchTime.intValue());// ����ץ��ʱ��
								tempStartTime = cal.getTime();
							}else {
								tempStartTime=getDateByRound(list, carIndex, "tempStartTime2", round-1);//��һ�ֵ��ٴγ���ʱ��
							}
						}
					}
					cal.setTime(tempStartTime);
					cal.add(Calendar.MINUTE, avgTime);// ����·;ʱ��
					tempReachTime = cal.getTime();//������ֳ��ʱ��
					if(round>0) {//���ǵ�һ��
						Date tempD;
						if(carIndex<everyCarCount) {//�������С�� ÿ���ɳ��� �� ��ǰһ�ֵĵ�һ�� 
							tempD=getDateByRound(list, carCount-1, "tempLeaveTime", round-1);//�����뿪����ʱ��
							if(tempReachTime.compareTo(tempD)>0) {//����ʱ�����һ���뿪������ʱ������ץ��ʱ��Ϊ����ʱ��
								tempD=tempReachTime;
							}
						}else { 
							tempD=getDateByRound(list, carIndex-everyCarCount, "tempLeaveTime", round);//������һ���εĳ���ʱ��
						}
						cal.setTime(tempD);
					}
					tempBeginCatchTime=cal.getTime();//��ʼץ��ʱ��
					cal.add(Calendar.MINUTE, avgCatchTime.intValue());// ����ץ��ʱ��
					if(nowTransCount<transCount&&((qty-tempQty)>everyCarCount*avgQty*(nowTransCount+1))) {//�Ѿ�ת����<��Ҫת����&&  �Ѿ�ץȡ������/����>�������ٵ�����  ---->Ҫת����
						cal.add(Calendar.MINUTE, transferTime);//����ת��ʱ��
						nowTransCount++;
						isAhead=false;
					}
					
					tempLeaveTime = cal.getTime(); 
					cal.add(Calendar.MINUTE, avgTime);// ����·;ʱ��
					tempBackTime = cal.getTime();//����ʳƷ��ʱ��
					
					if(nowIndex>0) {
						cal2.setTime(cal2.getTime());
						cal2.add(Calendar.MINUTE,avgHitchTime.intValue()*2);
						tempHitchTime=cal2.getTime();
						if(tempHitchTime.compareTo(tempBackTime)<0){
							cal2.setTime(tempBackTime);
							cal2.add(Calendar.MINUTE,avgWeightTime.intValue());
							tempHitchTime=cal2.getTime();
						}
					}
					
					cal.add(Calendar.MINUTE, avgWeightTime.intValue());//���Ϲ���ʱ��
					cal.add(Calendar.MINUTE, carHandlingTime.intValue());//����װ��ʱ��
					if(isAhead&&round==0) {
						//cal.add(Calendar.MINUTE,  transferTime);// ����ת��ʱ��
					}
					//tempHitchTime=cal.getTime();
					
					tempStartTime2 = cal.getTime();// �ٴγ���ʱ��

					// nowIndex++;
 
					for (; j < everyCarCount;) {// ����ÿ�η����� ���ӷ��ؼ�¼
						HashMap<String, Object> map = new HashMap<String, Object>();
						map.put("orgID", orgID);
						map.put("carNo", carIndex);// ��ǰ��������
						map.put("storageOrgUnitID", orgID);
						map.put("tempStartTime", tempStartTime);
						map.put("tempReachTime", tempReachTime);
						map.put("tempBeginCatchTime", tempBeginCatchTime);//��ʼץ��ʱ��
						map.put("tempLeaveTime", tempLeaveTime);
						map.put("tempBackTime", tempBackTime);
						map.put("tempHitchTime", tempHitchTime);
						map.put("tempStartTime2", tempStartTime2);
						map.put("carCount",0);// getCarCount(list, tempHitchTime, avgWeightTime.intValue(), avgHitchTime.intValue()));
						map.put("round", round);

						/*
						 * HashMap<String,Object> tempCarMap=new
						 * HashMap<String,Object>();//������ʱ����
						 * tempCarMap.put("carNo", carIndex);//���泵��
						 * tempCarMap.put("startTime", tempStartTime);//�������淢��ʱ��
						 * tempCarMap.put("startTime2", tempStartTime2);//��������
						 * �ٷ���ʱ�� tempCarList.add(tempCarMap)
						 */;
						nowIndex++;
						carIndex++;// �������+1
						if (tempQty > everyCarQty) {
							map.put("qty", everyCarQty);
							tempQty -= everyCarQty;
						} else {
							map.put("qty", tempQty);
							tempQty = 0;
						}
						list.add(map);// ���List
						j++;
						if (tempQty <= 0) {
							break;
						}
						if ((carIndex + 1) > carCount) {// ��ǰ������=�ճ�����
							break;
						}
						if (carCount < everyCarCount) {// ������<ÿ�η�����
							break;
						}
					}
					if (tempQty <= 0) {
						break;
					}
					j = 0;
				}
			}
			for(int index=0;index<list.size();index++){
				HashMap<String, Object> map = list.get(index);
				map.put("carCount",getCarCount(list, (java.util.Date)map.get("tempHitchTime"), avgWeightTime.intValue(), avgHitchTime.intValue()));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	/**
	 * �õ�������
	 * @return
	 */
	private int getCarCount(ArrayList<HashMap<String, Object>> list,Date time,int weightTime,int avgHitchTime) {
		int carCount=0;
		Calendar cal = java.util.Calendar.getInstance();
		HashMap<String, Object> map;
		for (int i = (list.size() - 1); i >= 0; i--) {
			map = list.get(i);
			cal.setTime((java.util.Date)map.get("tempBackTime"));
			cal.add(Calendar.MINUTE, weightTime);
			if(cal.getTime().compareTo(time)<=0&&time.compareTo((java.util.Date)map.get("tempHitchTime"))<=0) {
				carCount++;
			}
		}
		return carCount;
	}
	
	/**
	 * �õ�ĳһ�ִε� ʱ��
	 * @param list
	 * @param carNo
	 * @param key
	 * @param round
	 * @return
	 */
	private Date getDateByRound(ArrayList<HashMap<String, Object>> list, int carNo, String key,int round) {
		HashMap<String, Object> map;
		for (int i = (list.size() - 1); i >= 0; i--) {
			map = list.get(i);
			if (map.get("carNo").equals(carNo)&&map.get("round").equals(round)) {//������ͬ���ִ���ͬ
				return (Date) map.get(key);
			}
		}
		return null;
	}
	
	/**
	 * ���з�ʽʵ��
	 * @param ctx
	 * @param hashMap
	 * @return
	 * @throws BOSException
	 * @throws EASBizException
	 */
	protected ArrayList getSendPlan2(Context ctx, HashMap hashMap) throws BOSException, EASBizException {
		String storageOrgID = (String) hashMap.get("storageOrgID");// ��ǰ�����֯
		int carCount = (Integer) hashMap.get("carCount");// ��������
		Timestamp beginHitchTime = (Timestamp) hashMap.get("hitchTime");// ��ʼ�Ҽ�ʱ��
		java.util.Queue<HashMap<String,Object> > foodCarQueue=new LinkedList<HashMap<String,Object>>();//ʳƷ����������
		java.util.Queue<HashMap<String,Object> > breedCarQueue=new LinkedList<HashMap<String,Object>>();//��ֳ����������
		for(int i=0;i<carCount;i++) {
			HashMap<String,Object> tempMap=new HashMap<String, Object>();
			tempMap.put("carNo", i);
//			tempMap.put("startTime", null);//����ʱ��
//			tempMap.put("backTime", null);//���ص���ʱ��
			foodCarQueue.offer(tempMap);
		}
		
		FoodBaseDataInfo dataSettingInfo = this.getDataSettingInfo(ctx, storageOrgID);
		int basketUnitQty = dataSettingInfo.getUnitQty().intValue();// ƽ��ÿ������
		int basketQty = dataSettingInfo.getBasketQty();// ����
		if (basketQty <= 0)
			basketQty = 210;
		int eachCarQty = basketUnitQty * basketQty;// ÿ��������
		int eachCarCount = dataSettingInfo.getEveryCarCount();// ÿ���ɳ�����(ͷ)
		if (eachCarCount <= 0) {
			eachCarCount = 2;
		}
		if (carCount % eachCarCount > 0) {
			//throw new EASBizException(new NumericExceptionSubItem("001", "���ɳ�������Ϊÿ���ɳ�������������"));
		}
		int avgHitchTime = dataSettingInfo.getHitchTime().intValue();// ÿ���Ҽ�ʱ��
		int avgCatchTime = dataSettingInfo.getCatchTime().intValue();// ÿ��ץ��ʱ��
		int eachHitchCount=1;//ÿ�ιҼ�����
		
		ArrayList<Object> detailList = (ArrayList<Object>) hashMap.get("details");//��ϸ ��������������������֯��������
		HashMap<String, Object> tempMap;
		String orgID;//��ֳ��
		int qty,tempQty;//��������
		int avgTime=0;//·;ʱ�� ����
		Calendar calStart=Calendar.getInstance();//��ʼʱ��
		Calendar calEnd=Calendar.getInstance();//����ʱ��
		ArrayList<HashMap<String, Object>> resultList = new ArrayList<HashMap<String, Object>>();// ���ؽ����
		Date tempStartTime = null;// ����ʱ��
		Date tempReachTime;// ����ʱ��
		Date tempLeaveTime;// �뿪����ʱ��
		Date tempBackTime;// ����ʳƷ��ʱ��
		Date tempStartTime2 = null;// �ٴγ���ʱ��
		for(int index=0;index<detailList.size();index++) {
			tempMap=(HashMap<String, Object>) detailList.get(index);
			orgID = (String) tempMap.get("orgID");// ��ֳ�� �����֯id
			qty = ((BigDecimal) tempMap.get("qty")).intValue();
			tempQty=qty;
			
			if(index==0) {//��һ�η���
				calStart.add(Calendar.MINUTE, (-1) * avgCatchTime);// ��ȥץ��ʱ��
				calStart.add(Calendar.MINUTE, (-1) * 2 * avgTime);// ��ȥ·;ʱ��
//				calEnd.setTime(beginHitchTime);//�Ҽ�ʱ��
				tempStartTime=calStart.getTime();
				calStart.add(Calendar.MINUTE, avgTime);// ����·;ʱ��
				tempReachTime = calStart.getTime();
				calStart.add(Calendar.MINUTE, avgCatchTime);// ����ץ��ʱ��
				tempLeaveTime = calStart.getTime();
				calStart.add(Calendar.MINUTE, avgTime);// ����·;ʱ��
				tempBackTime = calStart.getTime();
				calStart.add(Calendar.MINUTE, avgHitchTime);// ���ϹҼ�ʱ��
				tempStartTime2 = calStart.getTime();// �ٴγ���ʱ��
				for(int i=0;i<eachCarCount;i++) {//��һ�η���������
					HashMap<String,Object> map = foodCarQueue.peek();
					map.put("orgID", orgID);
					map.put("tempStartTime", tempStartTime);
					map.put("tempReachTime", tempReachTime);
					map.put("tempLeaveTime", tempLeaveTime);
					map.put("tempBackTime", tempBackTime);
					calEnd.setTime(tempStartTime2);
					calEnd.add(Calendar.MINUTE, avgHitchTime*(i/eachHitchCount));// ���ϹҼ�ʱ��*�Ҽ�����/ÿ�ιһ�������
					map.put("tempStartTime2", calEnd.getTime());
					
					breedCarQueue.offer(map);//��ֳ������
					resultList.add(map);
					if(tempQty>eachCarCount) {
						map.put("qty", eachCarCount);
						tempQty-=eachCarCount;
					}else {
						map.put("qty", tempQty);
						tempQty=0;
						break;
					}
				}
			}
			if(tempQty<=0) {
				continue;
			}
			//���������� ����֮��
			
			
		}
		
		return null;
	}
	
	protected ArrayList getSendPlan3(Context ctx, HashMap hashMap) throws BOSException, EASBizException {
		String storageOrgID = (String) hashMap.get("storageOrgID");// ��ǰ�����֯
		int carCount = (Integer) hashMap.get("carCount");// ��������
		Timestamp beginHitchTime = (Timestamp) hashMap.get("hitchTime");// ��ʼ�Ҽ�ʱ��
		int transferTime=(Integer) hashMap.get("transferTime");//ת��ʱ��

		ArrayList<HashMap<String, Object>> tempCarList = new ArrayList<HashMap<String, Object>>();// ��ʱ��������

		FoodBaseDataInfo dataSettingInfo = this.getDataSettingInfo(ctx, storageOrgID);
		int basketUnitQty = dataSettingInfo.getUnitQty().intValue();// ƽ��ÿ������
		int basketQty = dataSettingInfo.getBasketQty();// ����
		if (basketQty <= 0)
			basketQty = 210;
		int everyCarQty = basketUnitQty * basketQty;// ÿ��������
		int everyCarCount = dataSettingInfo.getEveryCarCount();// ÿ���ɳ�����
		if (everyCarCount <= 0) {
			everyCarCount = 2;
		}
		if (carCount % everyCarCount > 0) {
			throw new EASBizException(new NumericExceptionSubItem("001", "���ɳ�������Ϊÿ���ɳ�������������"));
		}
		BigDecimal avgHitchTime = dataSettingInfo.getCarHandlingTime();//ÿ��װжʱ��//;dataSettingInfo.getHitchTime();// ÿ���Ҽ�ʱ��
		if(avgHitchTime==null) {
			avgHitchTime=BigDecimal.ZERO;
		}
		BigDecimal avgWeightTime=dataSettingInfo.getWeghtTimeCost();//ÿ������ʱ��
		if(avgWeightTime==null) {
			avgWeightTime=BigDecimal.ZERO;
		}
		BigDecimal avgCatchTime = dataSettingInfo.getCatchTime();// ÿ��ץ��ʱ��

		int avgTime;// ÿ���г�ʱ��

		ArrayList<Object> tempList = (ArrayList<Object>) hashMap.get("details");
		HashMap<String, Object> tempMap;
		String orgID, batchID, henhouseID;
		int dayAge, qty, tempQty;
		int nowIndex = 0;// ������
		int round=0;//�ִ�
		Date tempStartTime = null;// ����ʱ��
		Date tempReachTime;// ����ʱ��
		Date tempBeginCatchTime;//��ʼץ��ʱ��
		Date tempLeaveTime;// �뿪����ʱ��
		Date tempBackTime;// ����ʳƷ��ʱ��
		Date tempStartTime2 = null;// �ٴγ���ʱ��
		Calendar cal = java.util.Calendar.getInstance();
		cal.setTime(beginHitchTime);// ������ʼʱ��Ϊ��ʼ�Ҽ�ʱ��
		cal.add(Calendar.MINUTE, (-1)*avgWeightTime.intValue());//add 20150729 ��ȥ����ʱ��
		ArrayList<HashMap<String, Object>> list = new ArrayList<HashMap<String, Object>>();// ���ؽ����
		// HashMap<String,Object> tempCarMap=new
		// HashMap<String,Object>();//������ʱ����
		int carIndex = 0;// ����˳������
		try {
			ArrayList<String> orgList=new ArrayList<String>();
			for(int index=0;index<tempList.size();index++) {//������֯-��ֳ��
				tempMap = (HashMap<String, Object>) tempList.get(index);
				orgID = (String) tempMap.get("orgID");// ��ֳ�� �����֯id
				if(!orgList.contains(orgID))
					orgList.add(orgID);
			}
			for(String tempOrgID:orgList) {//������֯
				ArrayList<HashMap<String, Object>> tempOrgList=new ArrayList<HashMap<String, Object>>();
				for (int index = 0; index < tempList.size(); index++) {
					tempMap = (HashMap<String, Object>) tempList.get(index);
					orgID = (String) tempMap.get("orgID");// ��ֳ�� �����֯id
					if(orgID.equalsIgnoreCase(tempOrgID)) {
						tempOrgList.add(tempMap);
					}
				}
				Object[] objs;
				if(tempOrgList.size()>everyCarCount) {//������������ÿ���ɳ���
					objs=new Object[2];
				}else {
					objs=new Object[tempOrgList.size()];
				}
				carIndex=0;
				while(true) {
					for(int index=0;index<objs.length;index++) {
						//ÿ��װ����everyCarQty;
						tempMap=(HashMap<String, Object>) objs[index];
						qty = ((BigDecimal) tempMap.get("qty")).intValue();
						if(qty<everyCarQty) {//ʣ������С��ÿ��װ����
							
						}
					}
				}
				
				
			}
			
			
			int j = 0;
			String orgIDKeep="";
			for (int index = 0; index < tempList.size(); index++) {
				tempMap = (HashMap<String, Object>) tempList.get(index);
				orgID = (String) tempMap.get("orgID");// ��ֳ�� �����֯id
				// batchID=(String) tempMap.get("batchID");// ����id
				// henhouseID=(String) tempMap.get("henhouseID");//����id
				// dayAge=((BigDecimal) tempMap.get("dayAge")).intValue();//����
				qty = ((BigDecimal) tempMap.get("qty")).intValue();
				;// ����
				tempQty = qty;

				avgTime = getAvgTime(ctx, storageOrgID, orgID)[0];// ÿ���г�ʱ��
				
				//*******
				if(index==0){
					orgIDKeep=orgID;
				}
				if(!orgIDKeep.equalsIgnoreCase(orgID)) {//�����ֳ���ı䣬ȥ����ֳ����Ĭ���ɳ��� ���һ�в��ô���
					carCount=getAvgTime(ctx, storageOrgID, orgID)[1];//����֯��Ĭ���ɳ���
					orgIDKeep=orgID;
				}
				//*************
				
				while (true) {// ���������Ϊ0��һֱѭ���ݼ�;
					if (nowIndex == 0) {// ��һ��ִ�� ���㿪ʼʱ��
						round=0;
						cal.add(Calendar.MINUTE, (-1) * avgCatchTime.intValue());// ��ȥץ��ʱ��
						cal.add(Calendar.MINUTE, (-1) * 2 * avgTime);// ��ȥ·;ʱ��
						tempStartTime = cal.getTime();
					} else {
						if ((carIndex + 1) > carCount) {// �������>�ܳ�����=�µ�һ��
							carIndex = 0;
							round++;
							tempStartTime=getDateByRound(list, carIndex, "tempStartTime2", round-1);//��һ�ֵ��ٴγ���ʱ��
						} else {//�����µ�һ��
							if(round<1) {//��һ��
								tempStartTime = getDateByRound(list, carIndex-everyCarCount, "tempStartTime", round);//������һ���εĳ���ʱ��
								cal.setTime(tempStartTime);
								cal.add(Calendar.MINUTE, avgCatchTime.intValue());// ����ץ��ʱ��
								tempStartTime = cal.getTime();
							}else {
								tempStartTime=getDateByRound(list, carIndex, "tempStartTime2", round-1);//��һ�ֵ��ٴγ���ʱ��
							}
						}
					}
					cal.setTime(tempStartTime);
					cal.add(Calendar.MINUTE, avgTime);// ����·;ʱ��
					tempReachTime = cal.getTime();//������ֳ��ʱ��
					if(round>0) {//���ǵ�һ��
						Date tempD;
						if(carIndex<everyCarCount) {//�������С�� ÿ���ɳ��� �� ��ǰһ�ֵĵ�һ�� 
							tempD=getDateByRound(list, carCount-1, "tempLeaveTime", round-1);//�����뿪����ʱ��
							if(tempReachTime.compareTo(tempD)>0) {//����ʱ�����һ���뿪������ʱ������ץ��ʱ��Ϊ����ʱ��
								tempD=tempReachTime;
							}
						}else { 
							tempD=getDateByRound(list, carIndex-everyCarCount, "tempLeaveTime", round);//������һ���εĳ���ʱ��
						}
						cal.setTime(tempD);
					}
					tempBeginCatchTime=cal.getTime();//��ʼץ��ʱ��
					cal.add(Calendar.MINUTE, avgCatchTime.intValue());// ����ץ��ʱ��
					tempLeaveTime = cal.getTime(); 
					cal.add(Calendar.MINUTE, avgTime);// ����·;ʱ��
					tempBackTime = cal.getTime();//����ʳƷ��ʱ��
					cal.add(Calendar.MINUTE, avgWeightTime.intValue());//���Ϲ���ʱ��
					cal.add(Calendar.MINUTE, avgHitchTime.intValue());//����װ��ʱ��
					tempStartTime2 = cal.getTime();// �ٴγ���ʱ��

					// nowIndex++;

					for (; j < everyCarCount;) {// ����ÿ�η����� ���ӷ��ؼ�¼
						HashMap<String, Object> map = new HashMap<String, Object>();
						map.put("orgID", orgID);
						map.put("carNo", carIndex);// ��ǰ��������
						map.put("storageOrgUnitID", orgID);
						map.put("tempStartTime", tempStartTime);
						map.put("tempReachTime", tempReachTime);
						map.put("tempBeginCatchTime", tempBeginCatchTime);//��ʼץ��ʱ��
						map.put("tempLeaveTime", tempLeaveTime);
						map.put("tempBackTime", tempBackTime);
						map.put("tempStartTime2", tempStartTime2);
						map.put("round", round);

						/*
						 * HashMap<String,Object> tempCarMap=new
						 * HashMap<String,Object>();//������ʱ����
						 * tempCarMap.put("carNo", carIndex);//���泵��
						 * tempCarMap.put("startTime", tempStartTime);//�������淢��ʱ��
						 * tempCarMap.put("startTime2", tempStartTime2);//��������
						 * �ٷ���ʱ�� tempCarList.add(tempCarMap)
						 */;
						nowIndex++;
						carIndex++;// �������+1
						if (tempQty > everyCarQty) {
							map.put("qty", everyCarQty);
							tempQty -= everyCarQty;
						} else {
							map.put("qty", tempQty);
							tempQty = 0;
						}
						list.add(map);// ���List
						j++;
						if (tempQty <= 0) {
							break;
						}
						if ((carIndex + 1) > carCount) {// ��ǰ������=�ճ�����
							break;
						}
						if (carCount < everyCarCount) {// ������<ÿ�η�����
							break;
						}
					}
					if (tempQty <= 0) {
						break;
					}
					j = 0;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	/**
	 * ���ݷ���·�߻�ȡƽ����ʱ
	 * 
	 * @param ctx
	 * @param fromOrgID
	 * @param toOrgID
	 * @return
	 * @throws BOSException
	 * @throws EASBizException
	 */
	private int[] getAvgTime(Context ctx, String fromOrgID, String toOrgID) throws BOSException, EASBizException {
		int[] result=new int[]{0,0};
		EntityViewInfo ev = new EntityViewInfo();
		FilterInfo filter = new FilterInfo();
		filter.getFilterItems().add(new FilterItemInfo("fromStorageOrg.id", fromOrgID, CompareType.EQUALS));
		filter.getFilterItems().add(new FilterItemInfo("toStorageOrg.id", toOrgID, CompareType.EQUALS));
		ev.setFilter(filter);
		DeliveryLineCollection col = DeliveryLineFactory.getLocalInstance(ctx).getDeliveryLineCollection(ev);
		if (col != null && col.size() > 0) {
			DeliveryLineInfo info = DeliveryLineFactory.getLocalInstance(ctx).getDeliveryLineInfo(new ObjectUuidPK(col.get(0).getId()));
			int avgHour = 0;
			if(info.getAvgHour()!=null)
				avgHour=info.getAvgHour().intValue();
			int avgMinute = 0;
			if(info.getAvgMinute()!=null)
				avgMinute=info.getAvgMinute().intValue();
			int avgTime = 60 * avgHour + avgMinute;// ÿ���г�ʱ��
			result[0]=avgTime;//ƽ������ʱ�� min
			result[1]=info.getDefaultCarCount();//Ĭ���ɳ���
			info = null;
			return result;
		}
		return result;
	}


	/**
	 * ��ȡʳƷ����������
	 * 
	 * @param ctx
	 * @param orgID
	 * @return
	 * @throws BOSException
	 * @throws EASBizException
	 */
	private FoodBaseDataInfo getDataSettingInfo(Context ctx, String storageOrgID) throws BOSException, EASBizException {
		// ʳƷ����������
		EntityViewInfo ev = new EntityViewInfo();
		FilterInfo filter = new FilterInfo();
		filter.getFilterItems().add(new FilterItemInfo("storageOrgUnit.id", storageOrgID, CompareType.EQUALS));
		ev.setFilter(filter);
		FoodBaseDataCollection col = FoodBaseDataFactory.getLocalInstance(ctx).getFoodBaseDataCollection(ev);
		if (col != null && col.size() <= 0) {
			throw new EASBizException(new NumericExceptionSubItem("001", "���Ƚ���ʳƷ���������ã�"));
		}
		FoodBaseDataInfo dataSettingInfo = FoodBaseDataFactory.getLocalInstance(ctx).getFoodBaseDataInfo(
				new ObjectUuidPK(col.get(0).getString("id")));
		return dataSettingInfo;
	}

	/**
	 * �õ�������������ڣ�����������
	 * 
	 * @param ctx
	 * @param ids
	 * @return
	 * @throws BOSException
	 * @throws SQLException
	 */
	private String getMinIncoopDateId(Context ctx, ArrayList<String> idLists) throws BOSException, SQLException {
		String ids = "";
		for (int i = 0; i < idLists.size(); i++) {
			if (i > 0)
				ids += ",";
			ids = ids + "'" + idLists.get(i) + "'";
		}

		StringBuilder sb = new StringBuilder();// ȡ��С�ĳ�������
		sb.append(" select  t.fid  from ct_fm_breedbatch t ");
		sb.append(" inner join t_org_storage ts on t.cfstoorgid = ts.fid ");
		sb.append(" inner join T_BD_CostObject tc on t.CFCOSTOBJECTID = tc.fid ");
		sb.append(" inner join ct_fm_breedbatchentry te on t.fid = te.fparentid ");
		sb.append(" where te.cfismarket <>1 and te.cfincoopdate is not null ");// δ��ȫ����
																				// �������ڲ�ΪNull
		if (org.apache.commons.lang.StringUtils.isNotBlank(ids))
			sb.append(" and t.fid not in (").append(ids).append(")");
		sb.append(" and cfincoopDate in (");
		sb.append(" select  min(te.cfincoopDate) cfincoopDate  from ct_fm_breedbatch t ");
		sb.append(" inner join t_org_storage ts on t.cfstoorgid = ts.fid ");
		sb.append(" inner join T_BD_CostObject tc on t.CFCOSTOBJECTID = tc.fid ");
		sb.append(" inner join ct_fm_breedbatchentry te on t.fid = te.fparentid ");
		sb.append(" where te.cfismarket <>1 and te.cfincoopdate is not null ");// δ��ȫ����
																				// �������ڲ�ΪNull
		if (org.apache.commons.lang.StringUtils.isNotBlank(ids))
			sb.append(" and t.fid not in (").append(ids).append(")");
		sb.append(" )");
		IRowSet rs = DbUtil.executeQuery(ctx, sb.toString());
		if (rs.next()) {
			return rs.getString("fid");
		}
		return null;
	}

	/**
	 * ���ָ������ ָ�������� ��ֳ������Ϣ�� ��ѯϵͳ��
	 */
	protected ArrayList _getCCBatchAgeAndQty(Context ctx, Date bizDate, int breedDays, int count) throws BOSException {

		try {

			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

			StringBuilder sb = new StringBuilder();
			sb.append(" select t.fid,t.fnumber batchNumber,tc.fname_l2 batchName,ts.fid stoOrgID,ts.fnumber stoOrgNumber, ts.fname_l2 stoOrgName ");
			sb.append(" from ct_fm_breedbatch t");
			sb.append(" inner join t_org_storage ts on t.cfstoorgid = ts.fid ");
			sb.append(" inner join T_BD_CostObject tc on t.CFCOSTOBJECTID = tc.fid ");
			sb.append(" inner join ct_fm_breedbatchentry te on t.fid = te.fparentid ");
			sb.append(" where te.cfismarket <>1 and te.cfincoopdate is not null ");// δ��ȫ����  �������ڲ�ΪNull
			sb.append(" and te.cfincoopdate>=({d '").append(sdf.format(bizDate)).append("'}-").append(breedDays).append(")");// ����������
			sb.append(" order by te.cfincoopdate asc ");
			IRowSet rs = DbUtil.executeQuery(ctx, sb.toString());
			String nowBatchID = "";
			int batchCount = 1;
			ArrayList<CCBatchAgeInfo> batchInfos = new ArrayList<CCBatchAgeInfo>();
			
			String stoOrgID ;
			String stoOrgNumber ;
			String stoOrgName ;

			String batchNumber ;
			String batchName ;		
			
			while (rs.next()) {
				String batchID = rs.getString("fid");
				if(rs.getRow()==1)
					nowBatchID=batchID;
				if(rs.getRow()>1&&nowBatchID.equals(batchID)) {
					continue;
				}
				if(batchCount>count){
					break;
				}
				nowBatchID=batchID;
				batchCount++;
				
				stoOrgID = rs.getString("stoOrgID");
				stoOrgNumber = rs.getString("stoOrgNumber");
				stoOrgName = rs.getString("stoOrgName");

				batchNumber = rs.getString("batchNumber");
				batchName = rs.getString("batchName");
				
				CCBatchAgeInfo batchAgeInfo = new CCBatchAgeInfo();
				batchAgeInfo.setBatchID(batchID);
				batchAgeInfo.setBatchNumber(batchNumber);
				batchAgeInfo.setBatchName(batchName);
				batchAgeInfo.setStoOrgID(stoOrgID);
				batchAgeInfo.setStoOrgNumber(stoOrgNumber);
				batchAgeInfo.setStoOrgName(stoOrgName);

				batchAgeInfo = this.setBatchAgeDetailInfo(ctx, batchAgeInfo, breedDays, batchID, bizDate);
				batchInfos.add(batchAgeInfo);
			}
			return batchInfos;
		} catch (SQLException sqle) {
			sqle.printStackTrace();
			throw new BOSException(sqle);
		}

	}

	/**
	 * ����������ϸ��Ϣ
	 * 
	 * @param ctx
	 * @param ccRptBean
	 * @param param
	 * @return
	 * @throws BOSException
	 * @throws EASBizException
	 * @throws SQLException
	 * @throws ParseException
	 */
	private CCBatchAgeInfo setBatchAgeDetailInfo(Context ctx, CCBatchAgeInfo ageInfo, int breedDays, String batchID,
			Date bizDate) throws BOSException {
		List<CCProductPlanRptBean> batchDetailInfos = new ArrayList<CCProductPlanRptBean>();
		// ��ȡ������ϸ��Ϣ
		if (StringUtils.isNotBlank(batchID)) {
			// ��ȡ ������ϸ��Ϣ
			// �ж����� �������� �͵�ǰʱ��Ƚ� �����Ƿ��� ��ǰʱ����
			StringBuilder sb = new StringBuilder();
			sb.append("select t.fid billID,te.fid entryID,");
			sb.append(" te.cfhenhouseid,th.fnumber henhouseNumber, th.cfname henhouseName,th.CFName cfhenhouseName,te.cfincoopdate, ");
			// sb.append(
			// " ts.fid stoOrgID,ts.fnumber stoOrgNumber, ts.fname_l2 stoOrgName,"
			// );
			sb.append(" te.cfinitqty,te.cfincoopdate,t.fbizdate billBizdate ");
			sb.append(" from CT_FM_BreedBatch t inner join CT_FM_BreedBatchEntry te on t.fid = te.fparentid ");
			//sb.append(" inner join t_org_storage ts on t.cfstoorgid = ts.fid "
			// );
			sb.append(" inner join CT_FM_Henhouse th on te.cfhenhouseid = th.fid ");
			sb.append(" where t.fid ='");
			sb.append(batchID);
			sb.append("'  order by te.cfincoopdate asc,th.FNumber asc");

			IRowSet rs = DbUtil.executeQuery(ctx, sb.toString());

			// Date currEntryInDate = new Date();
			Date currEntryOutDate = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			String currEntryDateStr = "";
			List<String> entryHenhouseIDs = new ArrayList<String>();
			int currIncoopQty = 0;
			int currEntryDays;
			Date batchFirstIncoopDate = null;
			try {
				// ��ȡ����������ϸ��Ϣ
				List<CCBatchAgeDetailInfo> batchEntryDetailBean = new ArrayList<CCBatchAgeDetailInfo>();

				while (rs.next()) {

					String billID = rs.getString("billID");
					String entryID = rs.getString("entryID");
					String cfhenhouseid = rs.getString("cfhenhouseid");
					String henhouseNumber = rs.getString("henhouseNumber");
					String cfhenhouseName = rs.getString("cfhenhouseName");

					int cfinitqty = rs.getInt("cfinitqty");
					// ��������
					Date cfincoopdate = rs.getDate("cfincoopdate");
					// ���� ���� �״���������
					if (batchFirstIncoopDate == null) {
						batchFirstIncoopDate = cfincoopdate;
					}
					if (cfincoopdate == null) {
						cfincoopdate = rs.getDate("billBizdate");
					}

					currEntryDateStr = sdf.format(cfincoopdate);
					entryHenhouseIDs = new ArrayList<String>();
					entryHenhouseIDs.add(cfhenhouseid);
					// ��ǰ�����������ڵ�ǰ��
					currIncoopQty = cfinitqty;
					// ��ϸ
					CCBatchAgeDetailInfo newDetail = new CCBatchAgeDetailInfo();
					newDetail.setHenhouseID(cfhenhouseid);
					newDetail.setHenhouseNumber(henhouseNumber);
					newDetail.setHenhouseName(cfhenhouseName);

					newDetail.setIncoopDate(cfincoopdate);
					newDetail.setIncoopQty(cfinitqty);
					newDetail.setNowDate(bizDate);

					Calendar cal = Calendar.getInstance();

					// ���ȡ�õĳ�������Ϊnull����������۳���ʱ�� �������ڼ��� 38��
					if (currEntryOutDate == null) {
						cal.setTime(cfincoopdate);
						cal.add(Calendar.DATE, breedDays);

						currEntryOutDate = cal.getTime();
					}

					// ������������
					int qty = cfinitqty;
					// ��¼��ǰ�������ڵ� ʱ���

					Calendar currCal = Calendar.getInstance();
					Date currDate = null;
					for (int i = 1; i <= breedDays; i++) {

						currCal.setTime(cfincoopdate);
						currCal.add(Calendar.DATE, i);

						// ��ȡ��ǰѭ����������
						currDate = currCal.getTime();

						// ��ȡ�����ʵ�ʴ���������ͷһ���ձ��� ��������ã����δȡ������ͷһ������� ������
						// ���������Ա��������ô�����
						qty = CCProductPlanRptCommonFacadeFactory.getLocalInstance(ctx).getCCPredateHenqty(
								ageInfo.getStoOrgID(), batchID, currDate, "", cfhenhouseid, qty);
						if (qty <= 0) {
							continue;
						}

						if (sdf.format(currDate).equals(sdf.format(bizDate))) {
							newDetail.setNowQty(qty);
							newDetail.setNowDate(currDate);
						}

					}

					newDetail.setOutDate(currDate);
					newDetail.setOutQty(qty);
					// if(newDetail.getNowQty()>0)//add by dai
					batchEntryDetailBean.add(newDetail);

					// ��ӵ��������
					// ageInfo.setDetails(batchEntryDetailBean);
					// return ageInfo;

				}
				// ��ӵ��������
				ageInfo.setDetails(batchEntryDetailBean);
				return ageInfo;
			} catch (SQLException sqle) {
				sqle.printStackTrace();
				throw new BOSException(sqle);

			}
		}

		return ageInfo;
	}
}