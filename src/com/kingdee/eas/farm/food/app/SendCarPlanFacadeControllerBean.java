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
		int transferTime=(Integer) hashMap.get("transferTime");//转舍时间
		if(transferTime>0)
			return getSendPlan4(ctx, hashMap);
		else
			return getSendPlan1(ctx, hashMap);
	}

	protected ArrayList getSendPlan1(Context ctx, HashMap hashMap) throws BOSException, EASBizException {

		String storageOrgID = (String) hashMap.get("storageOrgID");// 当前库存组织
		int carCount = (Integer) hashMap.get("carCount");// 车辆数量
		Timestamp beginHitchTime = (Timestamp) hashMap.get("hitchTime");// 开始挂鸡时间
		int transferTime=(Integer) hashMap.get("transferTime");//转舍时间

		ArrayList<HashMap<String, Object>> tempCarList = new ArrayList<HashMap<String, Object>>();// 临时车辆缓存
		// HashMap<Integer,Object> carMap=new HashMap<Integer,Object>();//车辆缓存
		// for(int i=0;i<carCount;i++) {
		// tempCarList.add(new HashMap<String,Object>());
		// // carMap.put(i, null);//初始时间为开始挂鸡时间
		// }

		FoodBaseDataInfo dataSettingInfo = this.getDataSettingInfo(ctx, storageOrgID);
		int basketUnitQty = dataSettingInfo.getUnitQty().intValue();// 平均每筐数量
		int basketQty = dataSettingInfo.getBasketQty();// 筐数
		if (basketQty <= 0)
			basketQty = 210;
		int everyCarQty = basketUnitQty * basketQty;// 每车拉鸡数
		int everyCarCount = dataSettingInfo.getEveryCarCount();// 每次派车数量
		if (everyCarCount <= 0) {
			everyCarCount = 2;
		}
		if (carCount % everyCarCount > 0) {
			throw new EASBizException(new NumericExceptionSubItem("001", "总派车数必须为每次派车数的整数倍！"));
		}
		BigDecimal avgHitchTime = dataSettingInfo.getCarHandlingTime();//每车装卸时间//;dataSettingInfo.getHitchTime();// 每车挂鸡时间
		if(avgHitchTime==null) {
			avgHitchTime=BigDecimal.ZERO;
		}
		BigDecimal avgWeightTime=dataSettingInfo.getWeghtTimeCost();//每车过磅时间
		if(avgWeightTime==null) {
			avgWeightTime=BigDecimal.ZERO;
		}
		BigDecimal avgCatchTime = dataSettingInfo.getCatchTime();// 每车抓鸡时间

		int avgTime;// 每次行程时间
		
		ArrayList<Object> tempList = new ArrayList<Object>();//(ArrayList<Object>) hashMap.get("details");
		ArrayList<Object> dataList = (ArrayList<Object>) hashMap.get("details");
		//根据商品鸡场汇总
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
			if(index==(dataList.size()-1)) {//最后一行
				HashMap<String, Object> tempMap=new HashMap<String, Object>();
				tempMap.put("orgID", orgIDKeep);
				tempMap.put("qty", sumQty);
				tempList.add(tempMap);
			}
		}

		
		HashMap<String, Object> tempMap;
		String  batchID, henhouseID;
		int dayAge, qty, tempQty;
		int nowIndex = 0;// 计数器
		int round=0;//轮次
		Date tempStartTime = null;// 出车时间
		Date tempReachTime;// 到达时间
		Date tempBeginCatchTime;//开始抓鸡时间
		Date tempLeaveTime;// 离开鸡场时间
		Date tempBackTime;// 到达食品厂时间
		Date tempStartTime2 = null;// 再次出发时间
		Calendar cal = java.util.Calendar.getInstance();
		cal.setTime(beginHitchTime);// 设置起始时间为开始挂鸡时间
		cal.add(Calendar.MINUTE, (-1)*avgWeightTime.intValue());//add 20150729 减去过磅时间
		ArrayList<HashMap<String, Object>> list = new ArrayList<HashMap<String, Object>>();// 返回结果集
		// HashMap<String,Object> tempCarMap=new
		// HashMap<String,Object>();//车辆临时缓存
		int carIndex = 0;// 车辆顺序索引
		try {
			int j = 0;
			orgIDKeep="";
			for (int index = 0; index < tempList.size(); index++) {
				tempMap = (HashMap<String, Object>) tempList.get(index);
				orgID = (String) tempMap.get("orgID");// 养殖场 库存组织id
				// batchID=(String) tempMap.get("batchID");// 批次id
				// henhouseID=(String) tempMap.get("henhouseID");//鸡舍id
				// dayAge=((BigDecimal) tempMap.get("dayAge")).intValue();//日龄
				qty = ((BigDecimal) tempMap.get("qty")).intValue();
				;// 数量
				tempQty = qty;

				avgTime = getAvgTime(ctx, storageOrgID, orgID)[0];// 每次行程时间
				
				//*******
				if(index==0){
					orgIDKeep=orgID;
				}
				if(!orgIDKeep.equalsIgnoreCase(orgID)) {//如果养殖场改变，去新养殖场的默认派车数 最后一行不用处理
					carCount=getAvgTime(ctx, storageOrgID, orgID)[1];//该组织的默认派车数
					orgIDKeep=orgID;
				}
				//*************
				
				while (true) {// 如果数量不为0，一直循环递减;
					if (nowIndex == 0) {// 第一次执行 计算开始时间
						round=0;
						cal.add(Calendar.MINUTE, (-1) * avgCatchTime.intValue());// 减去抓鸡时间
						cal.add(Calendar.MINUTE, (-1) * 2 * avgTime);// 减去路途时间
						tempStartTime = cal.getTime();
					} else {
						if ((carIndex + 1) > carCount) {// 车辆序号>总出车数=新的一轮
							carIndex = 0;
							round++;
							tempStartTime=getDateByRound(list, carIndex, "tempStartTime2", round-1);//上一轮的再次出发时间
						} else {//不是新的一轮
							if(round<1) {//第一轮
								tempStartTime = getDateByRound(list, carIndex-everyCarCount, "tempStartTime", round);//本轮上一车次的出发时间
								cal.setTime(tempStartTime);
								cal.add(Calendar.MINUTE, avgCatchTime.intValue());// 加上抓鸡时间
								tempStartTime = cal.getTime();
							}else {
								tempStartTime=getDateByRound(list, carIndex, "tempStartTime2", round-1);//上一轮的再次出发时间
							}
						}
					}
					cal.setTime(tempStartTime);
					cal.add(Calendar.MINUTE, avgTime);// 加上路途时间
					tempReachTime = cal.getTime();//到达养殖场时间
					if(round>0) {//不是第一轮
						Date tempD;
						if(carIndex<everyCarCount) {//车辆序号小于 每次派车数 即 当前一轮的第一批 
							tempD=getDateByRound(list, carCount-1, "tempLeaveTime", round-1);//上轮离开鸡场时间
							if(tempReachTime.compareTo(tempD)>0) {//到达时间比上一轮离开鸡场的时间晚，则抓鸡时间为到达时间
								tempD=tempReachTime;
							}
						}else { 
							tempD=getDateByRound(list, carIndex-everyCarCount, "tempLeaveTime", round);//本轮上一车次的出发时间
						}
						cal.setTime(tempD);
					}
					tempBeginCatchTime=cal.getTime();//开始抓鸡时间
					cal.add(Calendar.MINUTE, avgCatchTime.intValue());// 加上抓鸡时间
					tempLeaveTime = cal.getTime(); 
					cal.add(Calendar.MINUTE, avgTime);// 加上路途时间
					tempBackTime = cal.getTime();//到达食品厂时间
					cal.add(Calendar.MINUTE, avgWeightTime.intValue());//加上过磅时间
					cal.add(Calendar.MINUTE, avgHitchTime.intValue());//加上装载时间
					tempStartTime2 = cal.getTime();// 再次出发时间

					// nowIndex++;

					for (; j < everyCarCount;) {// 根据每次发车数 增加返回记录
						HashMap<String, Object> map = new HashMap<String, Object>();
						map.put("orgID", orgID);
						map.put("carNo", carIndex);// 当前车辆索引
						map.put("storageOrgUnitID", orgID);
						map.put("tempStartTime", tempStartTime);
						map.put("tempReachTime", tempReachTime);
						map.put("tempBeginCatchTime", tempBeginCatchTime);//开始抓鸡时间
						map.put("tempLeaveTime", tempLeaveTime);
						map.put("tempBackTime", tempBackTime);
						map.put("tempStartTime2", tempStartTime2);
						map.put("round", round);

						/*
						 * HashMap<String,Object> tempCarMap=new
						 * HashMap<String,Object>();//车辆临时缓存
						 * tempCarMap.put("carNo", carIndex);//保存车号
						 * tempCarMap.put("startTime", tempStartTime);//车辆保存发车时间
						 * tempCarMap.put("startTime2", tempStartTime2);//车辆保存
						 * 再发车时间 tempCarList.add(tempCarMap)
						 */;
						nowIndex++;
						carIndex++;// 车辆序号+1
						if (tempQty > everyCarQty) {
							map.put("qty", everyCarQty);
							tempQty -= everyCarQty;
						} else {
							map.put("qty", tempQty);
							tempQty = 0;
						}
						list.add(map);// 添加List
						j++;
						if (tempQty <= 0) {
							break;
						}
						if ((carIndex + 1) > carCount) {// 当前车辆号=终车辆数
							break;
						}
						if (carCount < everyCarCount) {// 车辆数<每次发车数
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
	 * 添加 转舍时间
	 * @param ctx
	 * @param hashMap
	 * @return
	 * @throws BOSException
	 * @throws EASBizException
	 */
	protected ArrayList getSendPlan4(Context ctx, HashMap hashMap) throws BOSException, EASBizException {

		String storageOrgID = (String) hashMap.get("storageOrgID");// 当前库存组织
		int carCount = (Integer) hashMap.get("carCount");// 车辆数量
		Timestamp beginHitchTime = (Timestamp) hashMap.get("hitchTime");// 开始挂鸡时间
		int transferTime=(Integer) hashMap.get("transferTime");//转舍时间
		BigDecimal allQty=(BigDecimal) hashMap.get("allQty");//手工修改总时间
		//Boolean isAhead=(Boolean) hashMap.get("isAhead");//是否提前出车，规避转舍时间
		Boolean isAhead=true;
		if(transferTime<=0)
			isAhead=false;
		int aheadTime=(Integer) hashMap.get("aheadTime");//提前发车时间
		
		ArrayList<HashMap<String, Object>> tempCarList = new ArrayList<HashMap<String, Object>>();// 临时车辆缓存

		FoodBaseDataInfo dataSettingInfo = this.getDataSettingInfo(ctx, storageOrgID);
		int basketUnitQty = dataSettingInfo.getUnitQty().intValue();// 平均每筐数量
		int basketQty = dataSettingInfo.getBasketQty();// 筐数
		if (basketQty <= 0)
			basketQty = 210;
		int everyCarQty = basketUnitQty * basketQty;// 每车拉鸡数
		int everyCarCount = dataSettingInfo.getEveryCarCount();// 每次派车数量
		if (everyCarCount <= 0) {
			everyCarCount = 2;
		}
		if (carCount % everyCarCount > 0) {
			throw new EASBizException(new NumericExceptionSubItem("001", "总派车数必须为每次派车数的整数倍！"));
		}
		BigDecimal carHandlingTime = dataSettingInfo.getCarHandlingTime();//每车装卸时间//;dataSettingInfo.getHitchTime();// 每车挂鸡时间
		if(carHandlingTime==null) {//avgHitchTime
			carHandlingTime=BigDecimal.ZERO;
		}
		BigDecimal avgHitchTime=dataSettingInfo.getHitchTime();//每车挂鸡时间
		
		BigDecimal avgWeightTime=dataSettingInfo.getWeghtTimeCost();//每车过磅时间
		if(avgWeightTime==null) {
			avgWeightTime=BigDecimal.ZERO;
		}
		BigDecimal avgCatchTime = dataSettingInfo.getCatchTime();// 每车抓鸡时间
		
		BigDecimal transDeviceTime= dataSettingInfo.getTransDeviceTime();// 抓鸡设备转运时间
		if(transDeviceTime==null)
			transDeviceTime=BigDecimal.ZERO;

		String orgID,orgIDKeep = "";
		HashMap<String,Object> tempMap1;
//		HashMap<String, BigDecimal> companyMinQtyMap = new HashMap<String, BigDecimal>();//公司单鸡舍最少数量
		HashMap<String, Integer> companyHenhouseCountMap = new HashMap<String, Integer>();//公司包含鸡舍的数量
		BigDecimal tempQty1,tempQty2;
		ArrayList<Object> dataList = (ArrayList<Object>) hashMap.get("details");//需要执行的分录
		//得到每个公司 的鸡舍数
		for(int index=0;index<dataList.size();index++) {
			tempMap1=(HashMap<String, Object>) dataList.get(index);
			orgID=(String)tempMap1.get("orgID");
//			tempQty1=(BigDecimal) tempMap1.get("qty");
			if(!companyHenhouseCountMap.containsKey(orgID)) {
				companyHenhouseCountMap.put(orgID, 0);
			}
			companyHenhouseCountMap.put(orgID, companyHenhouseCountMap.get(orgID)+1);
			//不包含这个公司
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
		//获取总数量，比例分摊
		for(int index=0;index<dataList.size();index++) {
			tempMap1=(HashMap<String, Object>) dataList.get(index);
			tempQty1=(BigDecimal) tempMap1.get("qty");
			sumQty=sumQty.add(tempQty1);
		}
		
		BigDecimal proportion=allQty.divide(sumQty,BigDecimal.ROUND_HALF_UP,4);//计算比例  自定义数量和原始数量
		if(proportion==null||proportion.compareTo(BigDecimal.ZERO)==0) {
			proportion=BigDecimal.ONE;
		}
		
		sumQty=BigDecimal.ZERO;
		tempQty1=BigDecimal.ZERO;
		//公司数量开始累加
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
			if(index==(dataList.size()-1)) {//最后一行
				HashMap<String, Object> tempMap=new HashMap<String, Object>();
				tempMap.put("orgID", orgIDKeep);
				tempMap.put("qty", sumQty);
				tempList.add(tempMap);
			}
		}
		

		int avgTime;// 每次行程时间
		HashMap<String, Object> tempMap;
		String  batchID, henhouseID;
		int dayAge, qty,tempQty,avgQty,transCount,nowTransCount;
		int nowIndex = 0;// 计数器
		int round=0;//轮次
		Date tempStartTime = null;// 出车时间
		Date tempReachTime;// 到达时间
		Date tempBeginCatchTime;//开始抓鸡时间
		Date tempLeaveTime;// 离开鸡场时间
		Date tempBackTime;// 到达食品厂时间
		Date tempHitchTime=null;// 挂鸡时间
		Date tempStartTime2 = null;// 再次出发时间
		Calendar cal = java.util.Calendar.getInstance();
		cal.setTime(beginHitchTime);// 设置起始时间为开始挂鸡时间
		cal.add(Calendar.MINUTE, (-1)*avgWeightTime.intValue());//add 20150729 减去过磅时间
		ArrayList<HashMap<String, Object>> list = new ArrayList<HashMap<String, Object>>();// 返回结果集
		// HashMap<String,Object> tempCarMap=new
		// HashMap<String,Object>();//车辆临时缓存
		Calendar cal2 = java.util.Calendar.getInstance();//挂鸡时间缓存
		cal2.setTime(beginHitchTime);// 设置起始时间为开始挂鸡时间
		int carIndex = 0;// 车辆顺序索引
		try {
			int j = 0;
			for (int index = 0; index < tempList.size(); index++) {
				tempMap = (HashMap<String, Object>) tempList.get(index);
				orgID = (String) tempMap.get("orgID");// 养殖场 库存组织id
				// batchID=(String) tempMap.get("batchID");// 批次id
				// henhouseID=(String) tempMap.get("henhouseID");//鸡舍id
				// dayAge=((BigDecimal) tempMap.get("dayAge")).intValue();//日龄
				qty = ((BigDecimal) tempMap.get("qty")).multiply(proportion).intValue();
				;// 数量
				tempQty = qty;
				
				avgQty=0;//该组织单鸡舍平均数量
				transCount=0;//需转舍次数
				nowTransCount=0;
				if(companyHenhouseCountMap.get(orgID)!=null){
					avgQty=qty/companyHenhouseCountMap.get(orgID).intValue();//平均鸡舍数量
					if(companyHenhouseCountMap.get(orgID)>everyCarCount)//鸡舍数量>每次派车数
						transCount=companyHenhouseCountMap.get(orgID)/everyCarCount;//鸡舍数/每次车数=转舍次数
				}

				avgTime = getAvgTime(ctx, storageOrgID, orgID)[0];// 每次行程时间
				
				//*******
				if(index==0){
					orgIDKeep=orgID;
				}
				if(!orgIDKeep.equalsIgnoreCase(orgID)) {//如果养殖场改变，去新养殖场的默认派车数 最后一行不用处理
					carCount=getAvgTime(ctx, storageOrgID, orgID)[1];//该组织的默认派车数
					orgIDKeep=orgID;
//					cal.add(Calendar.MINUTE, transDeviceTime.intValue());// 换场的话，转运设备时间
				}
				//*************
				
				while (true) {// 如果数量不为0，一直循环递减;
					if (nowIndex == 0) {// 第一次执行 计算开始时间
						round=0;
						if(aheadTime>0) {//提前出车
							cal.add(Calendar.MINUTE, (-1) * aheadTime);// 减去提前发车时间
						}
						cal.add(Calendar.MINUTE, (-1) * avgCatchTime.intValue());// 减去抓鸡时间
						cal.add(Calendar.MINUTE, (-1) * 2 * avgTime);// 减去路途时间
						tempStartTime = cal.getTime();
						tempHitchTime=beginHitchTime;//挂鸡时间
					} else {
						if ((carIndex + 1) > carCount) {// 车辆序号>总出车数=新的一轮
							carIndex = 0;
							round++;
							tempStartTime=getDateByRound(list, carIndex, "tempStartTime2", round-1);//上一轮的再次出发时间
						} else {//不是新的一轮
							if(round<1) {//第一轮
								tempStartTime = getDateByRound(list, carIndex-everyCarCount, "tempStartTime", round);//本轮上一车次的出发时间
								cal.setTime(tempStartTime);
								cal.add(Calendar.MINUTE, avgCatchTime.intValue());// 加上抓鸡时间
								tempStartTime = cal.getTime();
							}else {
								tempStartTime=getDateByRound(list, carIndex, "tempStartTime2", round-1);//上一轮的再次出发时间
							}
						}
					}
					cal.setTime(tempStartTime);
					cal.add(Calendar.MINUTE, avgTime);// 加上路途时间
					tempReachTime = cal.getTime();//到达养殖场时间
					if(round>0) {//不是第一轮
						Date tempD;
						if(carIndex<everyCarCount) {//车辆序号小于 每次派车数 即 当前一轮的第一批 
							tempD=getDateByRound(list, carCount-1, "tempLeaveTime", round-1);//上轮离开鸡场时间
							if(tempReachTime.compareTo(tempD)>0) {//到达时间比上一轮离开鸡场的时间晚，则抓鸡时间为到达时间
								tempD=tempReachTime;
							}
						}else { 
							tempD=getDateByRound(list, carIndex-everyCarCount, "tempLeaveTime", round);//本轮上一车次的出发时间
						}
						cal.setTime(tempD);
					}
					tempBeginCatchTime=cal.getTime();//开始抓鸡时间
					cal.add(Calendar.MINUTE, avgCatchTime.intValue());// 加上抓鸡时间
					if(nowTransCount<transCount&&((qty-tempQty)>everyCarCount*avgQty*(nowTransCount+1))) {//已经转舍数<需要转舍数&&  已经抓取的数量/车数>鸡舍最少的数量  ---->要转舍了
						cal.add(Calendar.MINUTE, transferTime);//加上转舍时间
						nowTransCount++;
						isAhead=false;
					}
					
					tempLeaveTime = cal.getTime(); 
					cal.add(Calendar.MINUTE, avgTime);// 加上路途时间
					tempBackTime = cal.getTime();//到达食品厂时间
					
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
					
					cal.add(Calendar.MINUTE, avgWeightTime.intValue());//加上过磅时间
					cal.add(Calendar.MINUTE, carHandlingTime.intValue());//加上装载时间
					if(isAhead&&round==0) {
						//cal.add(Calendar.MINUTE,  transferTime);// 加上转舍时间
					}
					//tempHitchTime=cal.getTime();
					
					tempStartTime2 = cal.getTime();// 再次出发时间

					// nowIndex++;
 
					for (; j < everyCarCount;) {// 根据每次发车数 增加返回记录
						HashMap<String, Object> map = new HashMap<String, Object>();
						map.put("orgID", orgID);
						map.put("carNo", carIndex);// 当前车辆索引
						map.put("storageOrgUnitID", orgID);
						map.put("tempStartTime", tempStartTime);
						map.put("tempReachTime", tempReachTime);
						map.put("tempBeginCatchTime", tempBeginCatchTime);//开始抓鸡时间
						map.put("tempLeaveTime", tempLeaveTime);
						map.put("tempBackTime", tempBackTime);
						map.put("tempHitchTime", tempHitchTime);
						map.put("tempStartTime2", tempStartTime2);
						map.put("carCount",0);// getCarCount(list, tempHitchTime, avgWeightTime.intValue(), avgHitchTime.intValue()));
						map.put("round", round);

						/*
						 * HashMap<String,Object> tempCarMap=new
						 * HashMap<String,Object>();//车辆临时缓存
						 * tempCarMap.put("carNo", carIndex);//保存车号
						 * tempCarMap.put("startTime", tempStartTime);//车辆保存发车时间
						 * tempCarMap.put("startTime2", tempStartTime2);//车辆保存
						 * 再发车时间 tempCarList.add(tempCarMap)
						 */;
						nowIndex++;
						carIndex++;// 车辆序号+1
						if (tempQty > everyCarQty) {
							map.put("qty", everyCarQty);
							tempQty -= everyCarQty;
						} else {
							map.put("qty", tempQty);
							tempQty = 0;
						}
						list.add(map);// 添加List
						j++;
						if (tempQty <= 0) {
							break;
						}
						if ((carIndex + 1) > carCount) {// 当前车辆号=终车辆数
							break;
						}
						if (carCount < everyCarCount) {// 车辆数<每次发车数
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
	 * 得到车辆数
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
	 * 得到某一轮次的 时间
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
			if (map.get("carNo").equals(carNo)&&map.get("round").equals(round)) {//车号相同，轮次相同
				return (Date) map.get(key);
			}
		}
		return null;
	}
	
	/**
	 * 队列方式实现
	 * @param ctx
	 * @param hashMap
	 * @return
	 * @throws BOSException
	 * @throws EASBizException
	 */
	protected ArrayList getSendPlan2(Context ctx, HashMap hashMap) throws BOSException, EASBizException {
		String storageOrgID = (String) hashMap.get("storageOrgID");// 当前库存组织
		int carCount = (Integer) hashMap.get("carCount");// 车辆数量
		Timestamp beginHitchTime = (Timestamp) hashMap.get("hitchTime");// 开始挂鸡时间
		java.util.Queue<HashMap<String,Object> > foodCarQueue=new LinkedList<HashMap<String,Object>>();//食品厂车辆队列
		java.util.Queue<HashMap<String,Object> > breedCarQueue=new LinkedList<HashMap<String,Object>>();//养殖场车辆队列
		for(int i=0;i<carCount;i++) {
			HashMap<String,Object> tempMap=new HashMap<String, Object>();
			tempMap.put("carNo", i);
//			tempMap.put("startTime", null);//出发时间
//			tempMap.put("backTime", null);//返回到达时间
			foodCarQueue.offer(tempMap);
		}
		
		FoodBaseDataInfo dataSettingInfo = this.getDataSettingInfo(ctx, storageOrgID);
		int basketUnitQty = dataSettingInfo.getUnitQty().intValue();// 平均每筐数量
		int basketQty = dataSettingInfo.getBasketQty();// 筐数
		if (basketQty <= 0)
			basketQty = 210;
		int eachCarQty = basketUnitQty * basketQty;// 每车拉鸡数
		int eachCarCount = dataSettingInfo.getEveryCarCount();// 每次派车数量(头)
		if (eachCarCount <= 0) {
			eachCarCount = 2;
		}
		if (carCount % eachCarCount > 0) {
			//throw new EASBizException(new NumericExceptionSubItem("001", "总派车数必须为每次派车数的整数倍！"));
		}
		int avgHitchTime = dataSettingInfo.getHitchTime().intValue();// 每车挂鸡时间
		int avgCatchTime = dataSettingInfo.getCatchTime().intValue();// 每车抓鸡时间
		int eachHitchCount=1;//每次挂鸡车数
		
		ArrayList<Object> detailList = (ArrayList<Object>) hashMap.get("details");//明细 ，根据索引号排序后的组织汇总数量
		HashMap<String, Object> tempMap;
		String orgID;//养殖场
		int qty,tempQty;//拉鸡数量
		int avgTime=0;//路途时间 分钟
		Calendar calStart=Calendar.getInstance();//开始时间
		Calendar calEnd=Calendar.getInstance();//结束时间
		ArrayList<HashMap<String, Object>> resultList = new ArrayList<HashMap<String, Object>>();// 返回结果集
		Date tempStartTime = null;// 出车时间
		Date tempReachTime;// 到达时间
		Date tempLeaveTime;// 离开鸡场时间
		Date tempBackTime;// 到达食品厂时间
		Date tempStartTime2 = null;// 再次出发时间
		for(int index=0;index<detailList.size();index++) {
			tempMap=(HashMap<String, Object>) detailList.get(index);
			orgID = (String) tempMap.get("orgID");// 养殖场 库存组织id
			qty = ((BigDecimal) tempMap.get("qty")).intValue();
			tempQty=qty;
			
			if(index==0) {//第一次发出
				calStart.add(Calendar.MINUTE, (-1) * avgCatchTime);// 减去抓鸡时间
				calStart.add(Calendar.MINUTE, (-1) * 2 * avgTime);// 减去路途时间
//				calEnd.setTime(beginHitchTime);//挂鸡时间
				tempStartTime=calStart.getTime();
				calStart.add(Calendar.MINUTE, avgTime);// 加上路途时间
				tempReachTime = calStart.getTime();
				calStart.add(Calendar.MINUTE, avgCatchTime);// 加上抓鸡时间
				tempLeaveTime = calStart.getTime();
				calStart.add(Calendar.MINUTE, avgTime);// 加上路途时间
				tempBackTime = calStart.getTime();
				calStart.add(Calendar.MINUTE, avgHitchTime);// 加上挂鸡时间
				tempStartTime2 = calStart.getTime();// 再次出发时间
				for(int i=0;i<eachCarCount;i++) {//第一次发出车辆数
					HashMap<String,Object> map = foodCarQueue.peek();
					map.put("orgID", orgID);
					map.put("tempStartTime", tempStartTime);
					map.put("tempReachTime", tempReachTime);
					map.put("tempLeaveTime", tempLeaveTime);
					map.put("tempBackTime", tempBackTime);
					calEnd.setTime(tempStartTime2);
					calEnd.add(Calendar.MINUTE, avgHitchTime*(i/eachHitchCount));// 加上挂鸡时间*挂鸡车数/每次挂机数的商
					map.put("tempStartTime2", calEnd.getTime());
					
					breedCarQueue.offer(map);//养殖场车辆
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
			//发出车辆数 发走之后
			
			
		}
		
		return null;
	}
	
	protected ArrayList getSendPlan3(Context ctx, HashMap hashMap) throws BOSException, EASBizException {
		String storageOrgID = (String) hashMap.get("storageOrgID");// 当前库存组织
		int carCount = (Integer) hashMap.get("carCount");// 车辆数量
		Timestamp beginHitchTime = (Timestamp) hashMap.get("hitchTime");// 开始挂鸡时间
		int transferTime=(Integer) hashMap.get("transferTime");//转舍时间

		ArrayList<HashMap<String, Object>> tempCarList = new ArrayList<HashMap<String, Object>>();// 临时车辆缓存

		FoodBaseDataInfo dataSettingInfo = this.getDataSettingInfo(ctx, storageOrgID);
		int basketUnitQty = dataSettingInfo.getUnitQty().intValue();// 平均每筐数量
		int basketQty = dataSettingInfo.getBasketQty();// 筐数
		if (basketQty <= 0)
			basketQty = 210;
		int everyCarQty = basketUnitQty * basketQty;// 每车拉鸡数
		int everyCarCount = dataSettingInfo.getEveryCarCount();// 每次派车数量
		if (everyCarCount <= 0) {
			everyCarCount = 2;
		}
		if (carCount % everyCarCount > 0) {
			throw new EASBizException(new NumericExceptionSubItem("001", "总派车数必须为每次派车数的整数倍！"));
		}
		BigDecimal avgHitchTime = dataSettingInfo.getCarHandlingTime();//每车装卸时间//;dataSettingInfo.getHitchTime();// 每车挂鸡时间
		if(avgHitchTime==null) {
			avgHitchTime=BigDecimal.ZERO;
		}
		BigDecimal avgWeightTime=dataSettingInfo.getWeghtTimeCost();//每车过磅时间
		if(avgWeightTime==null) {
			avgWeightTime=BigDecimal.ZERO;
		}
		BigDecimal avgCatchTime = dataSettingInfo.getCatchTime();// 每车抓鸡时间

		int avgTime;// 每次行程时间

		ArrayList<Object> tempList = (ArrayList<Object>) hashMap.get("details");
		HashMap<String, Object> tempMap;
		String orgID, batchID, henhouseID;
		int dayAge, qty, tempQty;
		int nowIndex = 0;// 计数器
		int round=0;//轮次
		Date tempStartTime = null;// 出车时间
		Date tempReachTime;// 到达时间
		Date tempBeginCatchTime;//开始抓鸡时间
		Date tempLeaveTime;// 离开鸡场时间
		Date tempBackTime;// 到达食品厂时间
		Date tempStartTime2 = null;// 再次出发时间
		Calendar cal = java.util.Calendar.getInstance();
		cal.setTime(beginHitchTime);// 设置起始时间为开始挂鸡时间
		cal.add(Calendar.MINUTE, (-1)*avgWeightTime.intValue());//add 20150729 减去过磅时间
		ArrayList<HashMap<String, Object>> list = new ArrayList<HashMap<String, Object>>();// 返回结果集
		// HashMap<String,Object> tempCarMap=new
		// HashMap<String,Object>();//车辆临时缓存
		int carIndex = 0;// 车辆顺序索引
		try {
			ArrayList<String> orgList=new ArrayList<String>();
			for(int index=0;index<tempList.size();index++) {//遍历组织-养殖场
				tempMap = (HashMap<String, Object>) tempList.get(index);
				orgID = (String) tempMap.get("orgID");// 养殖场 库存组织id
				if(!orgList.contains(orgID))
					orgList.add(orgID);
			}
			for(String tempOrgID:orgList) {//遍历组织
				ArrayList<HashMap<String, Object>> tempOrgList=new ArrayList<HashMap<String, Object>>();
				for (int index = 0; index < tempList.size(); index++) {
					tempMap = (HashMap<String, Object>) tempList.get(index);
					orgID = (String) tempMap.get("orgID");// 养殖场 库存组织id
					if(orgID.equalsIgnoreCase(tempOrgID)) {
						tempOrgList.add(tempMap);
					}
				}
				Object[] objs;
				if(tempOrgList.size()>everyCarCount) {//鸡舍数量大于每次派车数
					objs=new Object[2];
				}else {
					objs=new Object[tempOrgList.size()];
				}
				carIndex=0;
				while(true) {
					for(int index=0;index<objs.length;index++) {
						//每车装鸡数everyCarQty;
						tempMap=(HashMap<String, Object>) objs[index];
						qty = ((BigDecimal) tempMap.get("qty")).intValue();
						if(qty<everyCarQty) {//剩余数量小于每车装鸡数
							
						}
					}
				}
				
				
			}
			
			
			int j = 0;
			String orgIDKeep="";
			for (int index = 0; index < tempList.size(); index++) {
				tempMap = (HashMap<String, Object>) tempList.get(index);
				orgID = (String) tempMap.get("orgID");// 养殖场 库存组织id
				// batchID=(String) tempMap.get("batchID");// 批次id
				// henhouseID=(String) tempMap.get("henhouseID");//鸡舍id
				// dayAge=((BigDecimal) tempMap.get("dayAge")).intValue();//日龄
				qty = ((BigDecimal) tempMap.get("qty")).intValue();
				;// 数量
				tempQty = qty;

				avgTime = getAvgTime(ctx, storageOrgID, orgID)[0];// 每次行程时间
				
				//*******
				if(index==0){
					orgIDKeep=orgID;
				}
				if(!orgIDKeep.equalsIgnoreCase(orgID)) {//如果养殖场改变，去新养殖场的默认派车数 最后一行不用处理
					carCount=getAvgTime(ctx, storageOrgID, orgID)[1];//该组织的默认派车数
					orgIDKeep=orgID;
				}
				//*************
				
				while (true) {// 如果数量不为0，一直循环递减;
					if (nowIndex == 0) {// 第一次执行 计算开始时间
						round=0;
						cal.add(Calendar.MINUTE, (-1) * avgCatchTime.intValue());// 减去抓鸡时间
						cal.add(Calendar.MINUTE, (-1) * 2 * avgTime);// 减去路途时间
						tempStartTime = cal.getTime();
					} else {
						if ((carIndex + 1) > carCount) {// 车辆序号>总出车数=新的一轮
							carIndex = 0;
							round++;
							tempStartTime=getDateByRound(list, carIndex, "tempStartTime2", round-1);//上一轮的再次出发时间
						} else {//不是新的一轮
							if(round<1) {//第一轮
								tempStartTime = getDateByRound(list, carIndex-everyCarCount, "tempStartTime", round);//本轮上一车次的出发时间
								cal.setTime(tempStartTime);
								cal.add(Calendar.MINUTE, avgCatchTime.intValue());// 加上抓鸡时间
								tempStartTime = cal.getTime();
							}else {
								tempStartTime=getDateByRound(list, carIndex, "tempStartTime2", round-1);//上一轮的再次出发时间
							}
						}
					}
					cal.setTime(tempStartTime);
					cal.add(Calendar.MINUTE, avgTime);// 加上路途时间
					tempReachTime = cal.getTime();//到达养殖场时间
					if(round>0) {//不是第一轮
						Date tempD;
						if(carIndex<everyCarCount) {//车辆序号小于 每次派车数 即 当前一轮的第一批 
							tempD=getDateByRound(list, carCount-1, "tempLeaveTime", round-1);//上轮离开鸡场时间
							if(tempReachTime.compareTo(tempD)>0) {//到达时间比上一轮离开鸡场的时间晚，则抓鸡时间为到达时间
								tempD=tempReachTime;
							}
						}else { 
							tempD=getDateByRound(list, carIndex-everyCarCount, "tempLeaveTime", round);//本轮上一车次的出发时间
						}
						cal.setTime(tempD);
					}
					tempBeginCatchTime=cal.getTime();//开始抓鸡时间
					cal.add(Calendar.MINUTE, avgCatchTime.intValue());// 加上抓鸡时间
					tempLeaveTime = cal.getTime(); 
					cal.add(Calendar.MINUTE, avgTime);// 加上路途时间
					tempBackTime = cal.getTime();//到达食品厂时间
					cal.add(Calendar.MINUTE, avgWeightTime.intValue());//加上过磅时间
					cal.add(Calendar.MINUTE, avgHitchTime.intValue());//加上装载时间
					tempStartTime2 = cal.getTime();// 再次出发时间

					// nowIndex++;

					for (; j < everyCarCount;) {// 根据每次发车数 增加返回记录
						HashMap<String, Object> map = new HashMap<String, Object>();
						map.put("orgID", orgID);
						map.put("carNo", carIndex);// 当前车辆索引
						map.put("storageOrgUnitID", orgID);
						map.put("tempStartTime", tempStartTime);
						map.put("tempReachTime", tempReachTime);
						map.put("tempBeginCatchTime", tempBeginCatchTime);//开始抓鸡时间
						map.put("tempLeaveTime", tempLeaveTime);
						map.put("tempBackTime", tempBackTime);
						map.put("tempStartTime2", tempStartTime2);
						map.put("round", round);

						/*
						 * HashMap<String,Object> tempCarMap=new
						 * HashMap<String,Object>();//车辆临时缓存
						 * tempCarMap.put("carNo", carIndex);//保存车号
						 * tempCarMap.put("startTime", tempStartTime);//车辆保存发车时间
						 * tempCarMap.put("startTime2", tempStartTime2);//车辆保存
						 * 再发车时间 tempCarList.add(tempCarMap)
						 */;
						nowIndex++;
						carIndex++;// 车辆序号+1
						if (tempQty > everyCarQty) {
							map.put("qty", everyCarQty);
							tempQty -= everyCarQty;
						} else {
							map.put("qty", tempQty);
							tempQty = 0;
						}
						list.add(map);// 添加List
						j++;
						if (tempQty <= 0) {
							break;
						}
						if ((carIndex + 1) > carCount) {// 当前车辆号=终车辆数
							break;
						}
						if (carCount < everyCarCount) {// 车辆数<每次发车数
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
	 * 根据发运路线获取平均耗时
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
			int avgTime = 60 * avgHour + avgMinute;// 每次行程时间
			result[0]=avgTime;//平均发车时间 min
			result[1]=info.getDefaultCarCount();//默认派车数
			info = null;
			return result;
		}
		return result;
	}


	/**
	 * 获取食品厂基础资料
	 * 
	 * @param ctx
	 * @param orgID
	 * @return
	 * @throws BOSException
	 * @throws EASBizException
	 */
	private FoodBaseDataInfo getDataSettingInfo(Context ctx, String storageOrgID) throws BOSException, EASBizException {
		// 食品厂基本设置
		EntityViewInfo ev = new EntityViewInfo();
		FilterInfo filter = new FilterInfo();
		filter.getFilterItems().add(new FilterItemInfo("storageOrgUnit.id", storageOrgID, CompareType.EQUALS));
		ev.setFilter(filter);
		FoodBaseDataCollection col = FoodBaseDataFactory.getLocalInstance(ctx).getFoodBaseDataCollection(ev);
		if (col != null && col.size() <= 0) {
			throw new EASBizException(new NumericExceptionSubItem("001", "请先进行食品厂基础设置！"));
		}
		FoodBaseDataInfo dataSettingInfo = FoodBaseDataFactory.getLocalInstance(ctx).getFoodBaseDataInfo(
				new ObjectUuidPK(col.get(0).getString("id")));
		return dataSettingInfo;
	}

	/**
	 * 得到最早的入栏日期，，最大的日龄
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

		StringBuilder sb = new StringBuilder();// 取最小的出栏日期
		sb.append(" select  t.fid  from ct_fm_breedbatch t ");
		sb.append(" inner join t_org_storage ts on t.cfstoorgid = ts.fid ");
		sb.append(" inner join T_BD_CostObject tc on t.CFCOSTOBJECTID = tc.fid ");
		sb.append(" inner join ct_fm_breedbatchentry te on t.fid = te.fparentid ");
		sb.append(" where te.cfismarket <>1 and te.cfincoopdate is not null ");// 未完全出栏
																				// 入栏日期不为Null
		if (org.apache.commons.lang.StringUtils.isNotBlank(ids))
			sb.append(" and t.fid not in (").append(ids).append(")");
		sb.append(" and cfincoopDate in (");
		sb.append(" select  min(te.cfincoopDate) cfincoopDate  from ct_fm_breedbatch t ");
		sb.append(" inner join t_org_storage ts on t.cfstoorgid = ts.fid ");
		sb.append(" inner join T_BD_CostObject tc on t.CFCOSTOBJECTID = tc.fid ");
		sb.append(" inner join ct_fm_breedbatchentry te on t.fid = te.fparentid ");
		sb.append(" where te.cfismarket <>1 and te.cfincoopdate is not null ");// 未完全出栏
																				// 入栏日期不为Null
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
	 * 获得指定日期 指定数量的 养殖批次信息， 查询系统中
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
			sb.append(" where te.cfismarket <>1 and te.cfincoopdate is not null ");// 未完全出栏  入栏日期不为Null
			sb.append(" and te.cfincoopdate>=({d '").append(sdf.format(bizDate)).append("'}-").append(breedDays).append(")");// 在养周期内
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
	 * 设置批次明细信息
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
		// 获取批次明细信息
		if (StringUtils.isNotBlank(batchID)) {
			// 获取 批次明细信息
			// 判断批次 入栏日期 和当前时间比较 批次是否在 当前时间内
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
				// 获取批次日龄明细信息
				List<CCBatchAgeDetailInfo> batchEntryDetailBean = new ArrayList<CCBatchAgeDetailInfo>();

				while (rs.next()) {

					String billID = rs.getString("billID");
					String entryID = rs.getString("entryID");
					String cfhenhouseid = rs.getString("cfhenhouseid");
					String henhouseNumber = rs.getString("henhouseNumber");
					String cfhenhouseName = rs.getString("cfhenhouseName");

					int cfinitqty = rs.getInt("cfinitqty");
					// 入栏日期
					Date cfincoopdate = rs.getDate("cfincoopdate");
					// 设置 批次 首次入栏日期
					if (batchFirstIncoopDate == null) {
						batchFirstIncoopDate = cfincoopdate;
					}
					if (cfincoopdate == null) {
						cfincoopdate = rs.getDate("billBizdate");
					}

					currEntryDateStr = sdf.format(cfincoopdate);
					entryHenhouseIDs = new ArrayList<String>();
					entryHenhouseIDs.add(cfhenhouseid);
					// 当前总入栏量等于当前行
					currIncoopQty = cfinitqty;
					// 明细
					CCBatchAgeDetailInfo newDetail = new CCBatchAgeDetailInfo();
					newDetail.setHenhouseID(cfhenhouseid);
					newDetail.setHenhouseNumber(henhouseNumber);
					newDetail.setHenhouseName(cfhenhouseName);

					newDetail.setIncoopDate(cfincoopdate);
					newDetail.setIncoopQty(cfinitqty);
					newDetail.setNowDate(bizDate);

					Calendar cal = Calendar.getInstance();

					// 如果取得的出栏日期为null，则计算理论出栏时间 入栏日期加上 38天
					if (currEntryOutDate == null) {
						cal.setTime(cfincoopdate);
						cal.add(Calendar.DATE, breedDays);

						currEntryOutDate = cal.getTime();
					}

					// 数量迭代计算
					int qty = cfinitqty;
					// 记录当前计算日期的 时间戳

					Calendar currCal = Calendar.getInstance();
					Date currDate = null;
					for (int i = 1; i <= breedDays; i++) {

						currCal.setTime(cfincoopdate);
						currCal.add(Calendar.DATE, i);

						// 获取当前循环到的日期
						currDate = currCal.getTime();

						// 获取当天的实际存栏量，从头一天日报的 存栏量获得，如果未取到则以头一天算出的 存栏量
						// 与理论死淘比例计算获得存栏量
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

					// 添加到结果集中
					// ageInfo.setDetails(batchEntryDetailBean);
					// return ageInfo;

				}
				// 添加到结果集中
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