package com.kingdee.eas.farm.stocking.hatch.app;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.Context;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.bos.metadata.bot.BOTMappingCollection;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;
import com.kingdee.bos.ui.face.UIRuleUtil;
import com.kingdee.bos.util.BOSUuid;
import com.kingdee.eas.base.codingrule.CodingRuleFactory;
import com.kingdee.eas.base.codingrule.CodingRuleInfo;
import com.kingdee.eas.base.codingrule.CodingRuleManagerFactory;
import com.kingdee.eas.base.codingrule.ICodingRuleManager;
import com.kingdee.eas.basedata.org.CompanyOrgUnit;
import com.kingdee.eas.basedata.org.CompanyOrgUnitInfo;
import com.kingdee.eas.basedata.org.OrgUnitInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.common.SysContextConstant;
import com.kingdee.eas.farm.hatch.EggSourceType;
//import com.kingdee.eas.farm.hatch.SettleCoeCollection;
//import com.kingdee.eas.farm.hatch.SettleCoeFactory;
import com.kingdee.eas.farm.stocking.basedata.EggPriceDataFactory;
import com.kingdee.eas.farm.stocking.basedata.EggPriceDataInfo;
import com.kingdee.eas.farm.stocking.basedata.FarmBaseStatusEnum;
import com.kingdee.eas.farm.stocking.basedata.FarmCollection;
import com.kingdee.eas.farm.stocking.basedata.FarmFactory;
import com.kingdee.eas.farm.stocking.basedata.FarmInfo;
import com.kingdee.eas.farm.stocking.basedata.FarmersTreeFactory;
import com.kingdee.eas.farm.stocking.basedata.FarmersTreeInfo;
import com.kingdee.eas.farm.stocking.basedata.ISettlementItem;
import com.kingdee.eas.farm.stocking.basedata.SettleItemType;
import com.kingdee.eas.farm.stocking.basedata.SettlementItemFactory;
import com.kingdee.eas.farm.stocking.basedata.SettlementItemInfo;
import com.kingdee.eas.farm.stocking.basedata.StatementsPolicyInfo;
import com.kingdee.eas.farm.stocking.basedata.StockingFarmTypeEnum;
import com.kingdee.eas.farm.stocking.common.BotpCommUtils;
import com.kingdee.eas.farm.stocking.common.StockingComm;
import com.kingdee.eas.farm.stocking.hatch.EggPriceType;
import com.kingdee.eas.farm.stocking.hatch.EggReceiveBillEntryFactory;
import com.kingdee.eas.farm.stocking.hatch.EggReceiveBillEntryInfo;
import com.kingdee.eas.farm.stocking.hatch.EggReceiveBillInfo;
import com.kingdee.eas.farm.stocking.hatch.EggSettleBillEntryCollection;
import com.kingdee.eas.farm.stocking.hatch.EggSettleBillEntryInfo;
import com.kingdee.eas.farm.stocking.hatch.EggSettleBillEntryPriceEntryCollection;
import com.kingdee.eas.farm.stocking.hatch.EggSettleBillEntryPriceEntryInfo;
import com.kingdee.eas.farm.stocking.hatch.EggSettleBillFactory;
import com.kingdee.eas.farm.stocking.hatch.EggSettleBillInfo;
import com.kingdee.eas.farm.stocking.hatch.StatisticsType;
import com.kingdee.eas.util.app.DbUtil;
import com.kingdee.jdbc.rowset.IRowSet;
import com.kingdee.util.NumericExceptionSubItem;


public class StockingHatchFacadeControllerBean extends AbstractStockingHatchFacadeControllerBean
{
	private static Logger logger =
		Logger.getLogger("com.kingdee.eas.farm.stocking.hatch.app.StockingHatchFacadeControllerBean");

	/**
	 * 生成结算单
	 */
	protected Object _createToEggSettleBill(Context ctx, Object obj) throws BOSException, EASBizException {
		EggReceiveBillInfo info=(EggReceiveBillInfo) obj;

		String destBillType="7DD0D62D";//EggSettleBillInfo
		BotpCommUtils btpIS = BotpCommUtils.getInstance(ctx);
		OrgUnitInfo orgInfo=info.getCompany();
		BOTMappingCollection btpCols = btpIS.getAllCanUsedBotps(ctx, orgInfo, info.getBOSType().toString(),destBillType,new String[]{info.getString("id")},new String[]{}, new ArrayList<String>(), null);
		if(btpCols==null||btpCols.size()<=0) {
			return info;
		}
		//		HashMap<Object[],Object[]> map=new HashMap<Object[], Object[]>();
		//		EggReceiveBillEntryInfo entryInfo=null;
		//		
		//		//循环遍历分录
		//		for(int i=0;i<info.getEntrys().size();i++){
		//			entryInfo = info.getEntrys().get(i);
		//			if(!info.getEntrys().get(i).isIsFormal())
		//				continue;
		//			
		//			//第一层   决定单子的数量
		//			Object[] type=new Object[2];
		//			type[0]=entryInfo.getFarmer();
		//			type[1]=entryInfo.getSendDate();
		//
		//			//相同，值叠罗汉
		//			if(map.containsKey(type)){
		//				
		//			}else{//不相同，另起炉灶
		//				HashMap<Object[],Object> entryMap=new HashMap<Object[], Object>();
		//				Object[] entryType=new Object[3];
		//				entryType[0]=entryInfo.getFarmer();
		//				entryType[1]=entryInfo.getHouse();
		//				entryType[2]=entryInfo.get;
		//				HashMap<String,Object> entryMap=new HashMap<String, Object>();
		//				entryMap.put("weekAge", entryInfo.getWeekAge());
		//				entryMap.put("dayAge", entryInfo.getDayAge());
		//				entryMap.put("brokenQty", entryInfo.getBrokenQty());
		//				entryMap.put("allQty", entryInfo.getAllQty());
		//				entryMap.put("effectAllQty", entryInfo.getEffectAllQty());
		//				entryMap.put("qc1lv1Qty", entryInfo.getQc1lv1Qty());
		//				entryMap.put("qc1lv2Qty", entryInfo.getQc1lv2Qty());
		//				entryMap.put("qc2lv2Qty", entryInfo.getQc2lv1Qty());
		//				entryMap.put("qc2lv1Qty", entryInfo.getQc2lv2Qty());
		//				entryMap.put("qc3lv1Qty", entryInfo.getQc3lv1Qty());
		//				entryMap.put("qc4lv1Qty", entryInfo.getQc4lv1Qty());
		//				entryMap.put("qc5lv2Qty", entryInfo.getQc5lv2Qty());
		//				entryMap.put("qc6lv2Qty", entryInfo.getQc6lv2Qty());
		//				entryMap.put("greensQty", entryInfo.getGreensQty());
		//				entryMap.put("dirtyQty", entryInfo.getDirtyQty());
		//				entryMap.put("doubleQty", entryInfo.getDoubleQty());
		//				entryMap.put("mutantQty", entryInfo.getMutantQty());
		//				entryMap.put("brokenSingeQty", entryInfo.getBrokenSingeQty());
		//				entryMap.put("flowQty", entryInfo.getFlowQty());
		//				entryMap.put("brokenDoubleQty", entryInfo.getBrokenDoubleQty());
		//				map.put(type, entryMap);
		//			}
		//		}
		//		return null;

		//		if(info.getEggSource().equals(EggSourceType.SubContract)) {
		try {
			HashMap<String,SettlementItemInfo> settleItemMap = getSettlementItem(ctx, info);
			Iterator<Entry<String, SettlementItemInfo>> itr=null;
			SettlementItemInfo settleItemInfo;
			EggReceiveBillEntryInfo entryInfo;//种蛋接收单分录
			String filedNum;//对应字段名字
			BigDecimal qty;//数量
			//				HashMap<String,Integer> qtyMap=new HashMap<String,Integer> ();//数量map

			//种蛋结算单分录
			EggSettleBillEntryCollection esbeCols=null;
			//种蛋结算分录价格明细分录
			EggSettleBillEntryPriceEntryCollection esbepeCols=null;

			//已经执行的养殖户
			ArrayList<String> hasCreateFarmerList=new ArrayList<String>();
			//全部养殖户
			ArrayList<String> allFarmerList=new ArrayList<String>();
			//当前养殖户
			String nowFarmerID=null;
			String tempFarmID="";
			BigDecimal sumNumQty;
			SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMdd");
			HashMap<String,BigDecimal> numQtyMap=new HashMap<String, BigDecimal>();//枚数map
			//				HashMap<String,BigDecimal> farmerQualityRateMap=new HashMap<String, BigDecimal>();//农户合格率
			//				HashMap<String,BigDecimal> badRateMap=new HashMap<String, BigDecimal>();//破损率
			BigDecimal totalEggQty = BigDecimal.ZERO;
			BigDecimal healthEggQty = BigDecimal.ZERO;
			BigDecimal badEggQty = BigDecimal.ZERO;
			ArrayList<FarmInfo> farm=new ArrayList<FarmInfo>();
			ArrayList<EggReceiveBillEntryInfo> entryInfoList=new ArrayList<EggReceiveBillEntryInfo>();
			for(int index=0;;index++) {
				entryInfo = info.getEntrys().get(index);
				if(entryInfo.getSettleBillID()!=null)
					continue;
				if(entryInfo==null)
					continue;
				//						throw new EASBizException(new NumericExceptionSubItem("001","当前单据没有任何分录"));
				if(entryInfo.getFarm()!=null)
					if(!farm.contains(entryInfo.getFarm()))
						farm.add(entryInfo.getFarm());
					else{}
				else if(index==info.getEntrys().size()-1&&farm.size()==0)
					break;
				else
					continue;
				//					if(entryInfo.getStatisticsType().equals(StatisticsType.AvgWeight)||!entryInfo.isIsFormal()) {
				//						continue;
				//					}

				//如果非平均值 + 已经转正
				if(!entryInfo.getStatisticsType().equals(StatisticsType.AvgWeight)) {
					FarmCollection coll = FarmFactory.getLocalInstance(ctx).getFarmCollection("where id='"+entryInfo.getFarm().getId().toString()+"'");
					if(coll.get(0).getFarmType()==null)
						throw new EASBizException(new NumericExceptionSubItem("","存在养殖场类别为空的场("+(index+1)+")"));

					if(coll.get(0).getFarmType().equals(StockingFarmTypeEnum.company))
						continue;
					if(info.getEggSource().equals(EggSourceType.SubContract)) {
						tempFarmID=entryInfo.getFarmer().getString("id");
					}
					if(info.getEggSource().equals(EggSourceType.Purchase)) {
						tempFarmID=entryInfo.getSupplier().getString("id");
					}
					//						if(info.getEggSource().equals(EggSourceType.InternalFarm)) {
					//							tempFarmID=entryInfo.getInternalFarm().getString("id");
					//						}
					if(entryInfo.getSendDate()==null)
						throw new EASBizException(new NumericExceptionSubItem("","存在交蛋日期为空的行("+(index+1)+")"));
					String sendDate = sdf.format(entryInfo.getSendDate());
					//全部用户list
					if(!allFarmerList.contains(tempFarmID+sendDate)) {
						allFarmerList.add(tempFarmID+sendDate);
					}


					//如果已经包含该养殖户，则退出
					if(hasCreateFarmerList.contains(tempFarmID+sendDate)) {
						continue;
					}
					if(StringUtils.isEmpty(nowFarmerID)) {
						nowFarmerID=tempFarmID+sendDate;

						esbeCols=new EggSettleBillEntryCollection();
					}
					//养殖户相同，则执行
					if(nowFarmerID.equals(tempFarmID+sendDate)) {
						itr = settleItemMap.entrySet().iterator();
						//遍历种蛋项目
						while(itr.hasNext()) {
							settleItemInfo=itr.next().getValue();
							//保存枚数
							if(entryInfo.getStatisticsType().equals(StatisticsType.NumQty)) {
								for(int j=0;j<settleItemInfo.getMaterialEntry().size();j++) {
									filedNum=settleItemInfo.getMaterialEntry().get(j).getFiledNum();
									if(entryInfo.containsKey(filedNum)) {
										numQtyMap.put(filedNum, entryInfo.getBigDecimal(filedNum));
									}
								}
							}

							//计量单位不一致，跳出
							if(!entryInfo.getUnit().getString("id").equals(settleItemInfo.getSettleUnit().getString("id"))) {
								continue;
							}

							//同一种蛋项目
							//									qtyMap.clear();
							qty=BigDecimal.ZERO;
							sumNumQty=BigDecimal.ZERO;
							esbepeCols=new EggSettleBillEntryPriceEntryCollection();
							for(int j=0;j<settleItemInfo.getMaterialEntry().size();j++) {
								filedNum=settleItemInfo.getMaterialEntry().get(j).getFiledNum();
//								if(!entryInfo.isIsFormal()){
//									if(settleItemInfo.getSettleItemType().equals(SettleItemType.qcEgg))
//										break;
//								}
								//分录包含该字段
								if(entryInfo.containsKey(filedNum)) {//entryInfo.getBigDecimal(filedNum)!=null
									qty=qty.add(entryInfo.getBigDecimal(filedNum)!=null&&!filedNum.equals("flowQty")?entryInfo.getBigDecimal(filedNum):BigDecimal.ZERO);

									//明细分录
									EggSettleBillEntryPriceEntryInfo esbepeInfo=new EggSettleBillEntryPriceEntryInfo();
									esbepeInfo.setId(BOSUuid.create(esbepeInfo.getBOSType().toString()));
									esbepeInfo.setMaterial(settleItemInfo.getMaterialEntry().get(j).getMaterial());
									esbepeInfo.setMaterialName(settleItemInfo.getMaterialEntry().get(j).getMaterial().getName());
									esbepeInfo.setModel(settleItemInfo.getMaterialEntry().get(j).getMaterial().getModel());
									if(filedNum.equals("flowQty"))
										esbepeInfo.setQty(BigDecimal.ZERO);
									else
										esbepeInfo.setQty(entryInfo.getBigDecimal(filedNum));
									esbepeInfo.setEggType(settleItemInfo.getMaterialEntry().get(j).getFiledName());
									esbepeCols.add(esbepeInfo);

									if(!entryInfo.getStatisticsType().equals(StatisticsType.NumQty)) {
										if(numQtyMap.containsKey(filedNum)&&numQtyMap.get(filedNum)!=null) {
											esbepeInfo.setNumQty(numQtyMap.get(filedNum)!=null?numQtyMap.get(filedNum).intValue():0);
											sumNumQty=sumNumQty.add(numQtyMap.get(filedNum));
										}
									}else {
										esbepeInfo.setNumQty(entryInfo.getBigDecimal(filedNum)!=null?entryInfo.getBigDecimal(filedNum).intValue():0);
										//										esbepeInfo.setNumQty(qty.intValue());
										sumNumQty=qty;
									}
								}
							}

							//农户合格率累计蛋数。破损率累计蛋数。统计总蛋数
							if(entryInfo.getStatisticsType().equals(StatisticsType.NumQty)){
								totalEggQty=totalEggQty.add(entryInfo.getAllQty()==null?BigDecimal.ZERO:entryInfo.getAllQty());
								healthEggQty=healthEggQty.add(entryInfo.getQc1lv1Qty()==null?BigDecimal.ZERO:entryInfo.getQc1lv1Qty());
								healthEggQty=healthEggQty.add(entryInfo.getQc1lv2Qty()==null?BigDecimal.ZERO:entryInfo.getQc1lv2Qty());
								badEggQty=badEggQty.add((entryInfo.getFlowQty()==null?BigDecimal.ZERO:entryInfo.getFlowQty()).
										add(entryInfo.getBrokenDoubleQty()==null?BigDecimal.ZERO:entryInfo.getBrokenDoubleQty()).
										add(entryInfo.getBrokenSingeQty()==null?BigDecimal.ZERO:entryInfo.getBrokenSingeQty()));
							}
							//配置结算信息分录
							entryInfoList.add(entryInfo);


							EggSettleBillEntryInfo esbInfo=new EggSettleBillEntryInfo();
							esbInfo.setId(BOSUuid.create(esbInfo.getBOSType().toString()));
							esbInfo.setSettleItem(settleItemInfo);
							esbInfo.setInternalBatch(entryInfo.getInternalBatch());
							esbInfo.setInternalFarm(entryInfo.getInternalFarm());
							//								esbInfo.setInternalHouse(entryInfo.get);
							esbInfo.setFarmer(entryInfo.getFarmer());
							esbInfo.setFarm(entryInfo.getFarm());
							esbInfo.setHouse(entryInfo.getHouse());
							esbInfo.setStockingBatch(entryInfo.getStockingBatch());
							esbInfo.setFarmerGroup(entryInfo.getFarmerGroup());
							esbInfo.setSupplier(entryInfo.getSupplier());
							esbInfo.setLot(entryInfo.getLot());
							esbInfo.setSendDate(entryInfo.getSendDate());
							esbInfo.setWeekAge(entryInfo.getWeekAge());
							esbInfo.setDayAge(entryInfo.getDayAge());
							esbInfo.setIsFormal(entryInfo.isIsFormal());
							esbInfo.setUnit(entryInfo.getUnit());
							esbInfo.setNum(sumNumQty.intValue());
							esbInfo.setWarehouse(entryInfo.getWarehouse());
							esbInfo.setQty(qty);
							if(!entryInfo.isIsFormal()){
								if(settleItemInfo.getSettleItemType().equals(SettleItemType.qcEgg))
									//									break;
									esbInfo.setQty(BigDecimal.ZERO);
							}
							esbInfo.setCostItem(null);
							esbInfo.getPriceEntry().addCollection(esbepeCols);

							//							//查询单价并计算金额
							//							if(entryInfo.getStockingBatch()!=null){
							//								entryInfo.getStockingBatch();
							//								SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
							//								if(settleItemInfo!=null)
							//									if(orgInfo.getId()!=null){
							//
							//										String str="/*dialect*/select t4.* from" 
							//											+"\nT_FM_StockingBatch                 t1"
							//											+"\ninner join T_FM_BatchContract      t2 on t2.FID=t1.FBatchContractID"
							//											+"\n           and t1.FID='"+entryInfo.getStockingBatch().getString("id")+"'"
							//											+"\ninner join CT_FM_EggPriceData      t3 on t1.FCompanyID='"+orgInfo.getString("id")+"'"
							//											+"\n           and to_char(t3.FEffectDate,'yyyy-MM-dd')<='"+sdf.format(new Date())+"'"
							//											+"\n           and to_char(t3.CFUnEffectDate,'yyyy-MM-dd')>='"+sdf.format(new Date())+"'"
							//											+"\n           and t2.FSettlementPolicyI=t3.FSettlePolicyID"
							//											+"\ninner join T_FM_EggPriceDataPriceEntry t4 on t3.FID=t4.FParentID"
							//											+"\n           and t4.FSettleItemID='"+settleItemInfo.getString("id")+"'";
							//										try {
							//											IRowSet rs = SQLExecutorFactory.getLocalInstance(ctx, str).executeSQL();
							//											if(rs.next()){
							//												esbInfo.setPrice(rs.getBigDecimal("FCurrentPrice"));
							//												if(esbInfo.getQty()!=null&&rs.getBigDecimal("FCurrentPrice")!=null)
							//													esbInfo.setAmount(rs.getBigDecimal("FCurrentPrice").multiply(esbInfo.getQty()));
							//											}else{
							////												throw new EASBizException(new NumericExceptionSubItem("001","有蛋品的价格没有维护"));
							//											}
							//										} catch (BOSException e) {
							//											// TODO Auto-generated catch block
							//											e.printStackTrace();
							//										} catch (SQLException e) {
							//											// TODO Auto-generated catch block
							//											e.printStackTrace();
							//										}
							//									}
							//
							//								esbeCols.add(esbInfo);
							//							}
							esbeCols.add(esbInfo);
						}
					}
				}

				//最后一行
				if(index==(info.getEntrys().size()-1)) {
					if(esbeCols!=null&&esbeCols.size()>0) {
						//生成结算单
						createToSettleBill(ctx, info, esbeCols,totalEggQty,healthEggQty,badEggQty,entryInfoList);
					}

					//执行新的养殖户 执行新的循环
					entryInfoList.clear();
					hasCreateFarmerList.add(nowFarmerID);
					nowFarmerID=null;
					index=hasCreateFarmerList.size()-1;
					totalEggQty=BigDecimal.ZERO;
					healthEggQty=BigDecimal.ZERO;
					badEggQty=BigDecimal.ZERO;
					//全部执行完成
					if(hasCreateFarmerList.size()>=allFarmerList.size()) {
						break;
					}
				}
			}
		}catch(Exception err){
			throw new EASBizException(new NumericExceptionSubItem("001",err.toString()));
		}
		//		}
		return null;
	}

	/**
	 * 生成种蛋结算单
	 * @param ctx
	 * @param info
	 * @param badEggQty 
	 * @param healthEggQty 
	 * @param totalEggQty 
	 * @param entryInfoList 
	 * @param entryInfo
	 */
	private void createToSettleBill(Context ctx,EggReceiveBillInfo info,EggSettleBillEntryCollection orderEntryCols, BigDecimal totalEggQty, BigDecimal healthEggQty, BigDecimal badEggQty, ArrayList<EggReceiveBillEntryInfo> entryInfoList) throws Exception {
		BotpCommUtils btpIS = BotpCommUtils.getInstance(ctx);
		OrgUnitInfo orgInfo=info.getCompany();
		String destBillType="7DD0D62D";//EggSettleBillInfo
		BOTMappingCollection btpCols = btpIS.getAllCanUsedBotps(ctx, orgInfo, info.getBOSType().toString(),destBillType,new String[]{info.getString("id")},new String[]{}, new ArrayList<String>(), null);
		for(int index=0;index<btpCols.size();index++) {
			EggSettleBillInfo tempInfo = (EggSettleBillInfo) btpIS.createToBill(ctx, info,destBillType, btpCols.get(index));
			if(tempInfo!=null) {
				
				tempInfo.setSrcRecBill(info.getNumber());
				tempInfo.setQualityRate(totalEggQty.compareTo(BigDecimal.ZERO)==0?null:
					(healthEggQty.divide(totalEggQty,4,BigDecimal.ROUND_HALF_EVEN).multiply(new BigDecimal(100))));
				tempInfo.setBadRate(totalEggQty.compareTo(BigDecimal.ZERO)==0?null:
					(badEggQty.divide(totalEggQty,4,BigDecimal.ROUND_HALF_EVEN).multiply(new BigDecimal(100))));
				tempInfo.getEntrys().addCollection(orderEntryCols);
				BigDecimal amount = new BigDecimal(0);
				if(orderEntryCols!=null&&orderEntryCols.size()>0) {
					tempInfo.setFarmer(orderEntryCols.get(0).getFarmer());
//					SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
//					SimpleDateFormat sdf1=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
//					tempInfo.setBizDate(sdf1.parse(sdf.format(orderEntryCols.get(0).getSendDate())+" 00:00:00"));
				}
				//执行结算
				this._exeEggSettle(ctx, tempInfo);
				for(int i=0;i<tempInfo.getEntrys().size();i++){
					amount=amount.add(tempInfo.getEntrys().get(i).getAmount()==null?new BigDecimal(0):tempInfo.getEntrys().get(i).getAmount());
				}
				tempInfo.setAmount(amount);
				String str = "00000000-0000-0000-0000-000000000000CCE7AED4";
				if(CodingRuleManagerFactory.getLocalInstance(ctx).isExist((IObjectValue)tempInfo, str)){
					ICodingRuleManager iCodingRuleManager = CodingRuleManagerFactory.getLocalInstance(ctx);
					String number = iCodingRuleManager.getNumber((IObjectValue)tempInfo, str);
					tempInfo.setNumber(number);
				}
				EggSettleBillFactory.getLocalInstance(ctx).submit(tempInfo);
				EggSettleBillFactory.getLocalInstance(ctx).audit(tempInfo);


				for(int i=0;i<entryInfoList.size();i++){
					entryInfoList.get(i).setSettleBillID(tempInfo.getString("id"));
					entryInfoList.get(i).setIsExistDownBill(true);
					EggReceiveBillEntryFactory.getLocalInstance(ctx).save(entryInfoList.get(i));
				}
			}
		}
	}


	/**
	 * 获取蛋品关系
	 * @param ctx
	 * @param info
	 * @throws Exception
	 */
	private HashMap<String,SettlementItemInfo> getSettlementItem(Context ctx,EggReceiveBillInfo info) throws Exception {
		HashMap<String,SettlementItemInfo> result=new HashMap<String,SettlementItemInfo> ();

		ISettlementItem ies = SettlementItemFactory.getLocalInstance(ctx);

		StringBuffer sql=new StringBuffer();
		sql.append(" select tmain.fid ")
		.append(" from T_FM_SettlementItem tmain")
		.append(" inner join T_FM_SettlementIME tentry on tentry.fparentid=tmain.fid")
		.append(" where tmain.fcompanyid='").append(info.getCompany().getString("id")).append("'")
		.append(" and tmain.fbaseStatus=").append(FarmBaseStatusEnum.ENABLE_VALUE)
		.append(" and (tmain.FSettleItemType=").append(SettleItemType.EGG_VALUE)
		.append(" or tmain.FSettleItemType=").append(SettleItemType.QCEGG_VALUE).append(")")
		;
		IRowSet rs=DbUtil.executeQuery(ctx, sql.toString());
		SelectorItemCollection slor=new SelectorItemCollection();
		slor.add("*");
		slor.add("MaterialEntry.*");
		slor.add("MaterialEntry.material.*");
		while(rs.next()) {
			result.put(rs.getString("fid"), ies.getSettlementItemInfo(new ObjectUuidPK(rs.getString("fid")),slor));
		}
		return result;
	}

	/**
	 * 执行结算
	 * @throws EASBizException 
	 */
	protected Object _exeEggSettle(Context ctx, Object param)throws BOSException, EASBizException
	{
		EggSettleBillInfo info=(EggSettleBillInfo) param;
		try {
			//			EggPriceDataInfo eggPriceInfo = (EggPriceDataInfo) checkEggPriceExist(ctx, info);
			//			if(eggPriceInfo==null) {
			//				throw new Exception("当日蛋品价格尚未维护！");
			//			}

			//放养
			//			if(info.getEggSource().equals(EggSourceType.SubContract)) {
			EggPriceDataInfo eggPriceInfo;
			EggSettleBillEntryInfo entryInfo;
			String settleItemID;//结算项目
			String unitID;
			BigDecimal price;
			boolean isExistDailyPrice;//是否存在日价格
			String farmerID,farmID,stockingBatchID;
			String contractID;
			StatementsPolicyInfo policyInfo;
			BigDecimal tempQty;
			for(int index=0;index<info.getEntrys().size();index++) {
				entryInfo = info.getEntrys().get(index);
				settleItemID=entryInfo.getSettleItem().getString("id");
				unitID=entryInfo.getUnit().getString("id");
				stockingBatchID=entryInfo.getStockingBatch().getString("id");

				price=BigDecimal.ZERO;
				isExistDailyPrice=false;

				//设置合同价
				//					setPolicyPriceByStockingBatch(ctx, entryInfo,stockingBatchID,settleItemID,unitID);
				eggPriceInfo=null;
				contractID = StockingComm.getContractIDByBatchID(ctx, stockingBatchID);
				if(StringUtils.isNotEmpty(contractID)&&entryInfo.getSendDate()!=null) {
					//结算政策
					policyInfo = StockingComm.getSettlePolicyByContractID(ctx, contractID);
					eggPriceInfo=(EggPriceDataInfo) checkEggPriceExist(ctx, info,policyInfo.getString("id"),entryInfo.getSendDate());
				}
				if(eggPriceInfo==null) {
					continue;
				}
				//遍历价格分录 取当日价格
				BigDecimal coe = new BigDecimal(0.05);
//				SettleCoeCollection coll = SettleCoeFactory.getLocalInstance(ctx).getSettleCoeCollection("where company = '"+info.getCompany().getString("id")+"'");
//				if(coll.size() > 0){
//					coe = UIRuleUtil.getBigDecimal(coll.get(0).getCoe());
//				}
				for(int j=0;j<eggPriceInfo.getPriceEntry().size();j++) {
					//结算项目和单位都一样
					if(eggPriceInfo.getPriceEntry().get(j).getSettleItem().getString("id").equals(settleItemID)&&eggPriceInfo.getPriceEntry().get(j).getUnit().getString("id").equals(unitID)) {
						/*price=eggPriceInfo.getPriceEntry().get(index).getPrice();
							//政策单价+今日浮动单价
							if(info.getEntrys().get(index).getPrice()!=null) {
								price=price.add(info.getEntrys().get(index).getPrice());
							}*/
						price=eggPriceInfo.getPriceEntry().get(j).getCurrentPrice();
						if(price==null) {
							price=BigDecimal.ZERO;
						}
						//设置价格
						info.getEntrys().get(index).setPrice(price);
						tempQty=info.getEntrys().get(index).getQty();
						if(tempQty==null) {
							tempQty=BigDecimal.ZERO;
						}
						if(info.getEntrys().get(index).getDayAge()>520&&info.getEntrys().get(index).getSettleItem()!=null&&info.getEntrys().get(index).getSettleItem().getName().equals("合格蛋")){
							info.getEntrys().get(index).setPrice(price.subtract(coe));
							info.getEntrys().get(index).setAmount(tempQty.multiply(price.subtract(coe)).setScale(2, BigDecimal.ROUND_HALF_UP));
						}
						else
							info.getEntrys().get(index).setAmount(tempQty.multiply(price).setScale(2, BigDecimal.ROUND_HALF_UP));
						info.getEntrys().get(index).setEggPriceType(EggPriceType.dailyPrice);
						for(int k=0;k<info.getEntrys().get(index).getPriceEntry().size();k++) {
							info.getEntrys().get(index).getPriceEntry().get(k).setPrice(price);
							tempQty=info.getEntrys().get(index).getPriceEntry().get(k).getQty();
							if(tempQty==null) {
								tempQty=BigDecimal.ZERO;
							}
							if(info.getEntrys().get(index).getDayAge()>520&&info.getEntrys().get(index).getSettleItem()!=null&&info.getEntrys().get(index).getSettleItem().getName().equals("合格蛋")){
								info.getEntrys().get(index).setPrice(price.subtract(coe));
								info.getEntrys().get(index).getPriceEntry().get(k).setAmount(price.multiply(tempQty.subtract(coe)).setScale(2,BigDecimal.ROUND_HALF_UP));
							}
							else
								info.getEntrys().get(index).getPriceEntry().get(k).setAmount(price.multiply(tempQty).setScale(2,BigDecimal.ROUND_HALF_UP));
						}
						isExistDailyPrice=true;
						break;
					}
				}
			}
			//			}
		}catch(Exception err) {
			throw new EASBizException(new NumericExceptionSubItem("001",err.getMessage()));
		}
		return info;
	}
	/**
	 * 检查蛋品价格是否存在
	 * @param ctx
	 * @throws Exception 
	 */
	private IObjectValue checkEggPriceExist(Context ctx,EggSettleBillInfo info,String policyID,Date bizDate) throws Exception {
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		StringBuffer sql=new StringBuffer();
		sql.append(" select tmain.fid from CT_FM_EggPriceData tmain")
		.append(" inner join T_FM_EggPriceDataPriceEntry tentry on tentry.fparentid=tmain.fid")
		.append(" where fcompanyid='").append(info.getCompany().getString("id")).append("'")
		.append(" and FEffectDate<={d '").append(sdf.format(bizDate)).append("'}")
		.append(" and CFUnEffectDate>={d '").append(sdf.format(bizDate)).append("'}")
		.append(" and FBaseStatus=").append(FarmBaseStatusEnum.ENABLE_VALUE);
		sql.append(" and FSettlePolicyID='").append(policyID).append("'");
		sql.append(" order by fcreatetime desc");
		IRowSet rs = DbUtil.executeQuery(ctx, sql.toString());
		//存在当日价格
		if(rs.next()) {
			SelectorItemCollection slor=new SelectorItemCollection();
			slor.add("*");
			slor.add("PriceEntry.*");
			slor.add("PriceEntry.settleItem.*");
			return EggPriceDataFactory.getLocalInstance(ctx).getDataBaseInfo(new ObjectUuidPK(rs.getString("fid")),slor);
		}
		return null;
	}

	/**
	 * 取政策价格
	 * @param ctx
	 * @param info
	 * @param stockingBatchID
	 * @param unitID
	 * @throws BOSException 
	 * @throws EASBizException 
	 */
	private void setPolicyPriceByStockingBatch(Context ctx,EggSettleBillEntryInfo entryInfo,String stockingBatchID,String settleItemID,String unitID) throws EASBizException, BOSException {
		String contractID = StockingComm.getContractIDByBatchID(ctx, stockingBatchID);
		if(StringUtils.isEmpty(contractID)) {
			return ;
		}
		//结算政策
		StatementsPolicyInfo policyInfo = StockingComm.getSettlePolicyByContractID(ctx, contractID);


		//遍历明细分录--设置有效数量（包含政策价格的）
		BigDecimal allQty=BigDecimal.ZERO,allAmount=BigDecimal.ZERO;
		BigDecimal amount,price=BigDecimal.ZERO;
		//结算项目物料 map
		for(int index=0;index<policyInfo.getRecycleEntry().size();index++){
			if(policyInfo.getRecycleEntry().get(index).getSettlementItem().getString("id").equalsIgnoreCase(settleItemID)&&policyInfo.getRecycleEntry().get(index).getUnit().getString("id").equals(unitID)) {
				price=policyInfo.getRecycleEntry().get(index).getBasePrice();
				break;
			}
		}
		for(int index=0;index<entryInfo.getPriceEntry().size();index++) {
			entryInfo.getPriceEntry().get(index).setPrice(price);
			amount=entryInfo.getPriceEntry().get(index).getQty().multiply(price).setScale(2, BigDecimal.ROUND_HALF_UP);
			entryInfo.getPriceEntry().get(index).setAmount(amount);

			allQty=allQty.add(entryInfo.getPriceEntry().get(index).getQty());
			allAmount=allAmount.add(amount);
		}
		entryInfo.setQty(allQty);
		entryInfo.setAmount(allAmount);
		if(allQty!=null&&allQty.signum()>0) {
			entryInfo.setPrice(allAmount.divide(allQty,4,BigDecimal.ROUND_HALF_UP));
		}
		if(allAmount.signum()>0) {
			entryInfo.setEggPriceType(EggPriceType.policyPrice);
		}else {
			entryInfo.setEggPriceType(EggPriceType.nonePrice);
		}

	}
}