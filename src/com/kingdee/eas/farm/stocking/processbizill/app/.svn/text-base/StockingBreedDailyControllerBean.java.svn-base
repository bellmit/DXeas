package com.kingdee.eas.farm.stocking.processbizill.app;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import net.sf.json.JSONArray;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.Context;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.bos.dao.query.ISQLExecutor;
import com.kingdee.bos.dao.query.SQLExecutorFactory;
import com.kingdee.bos.metadata.bot.BOTMappingCollection;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;
import com.kingdee.bos.ui.face.UIRuleUtil;
import com.kingdee.eas.basedata.org.OrgUnitInfo;
import com.kingdee.eas.basedata.person.PersonFactory;
import com.kingdee.eas.basedata.person.PersonInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.farm.carnivorous.basedata.FarmFactory;
import com.kingdee.eas.farm.stocking.basedata.BaseSysSettingInfo;
import com.kingdee.eas.farm.stocking.basedata.BreedDataFactory;
import com.kingdee.eas.farm.stocking.basedata.BreedDataInfo;
import com.kingdee.eas.farm.stocking.basedata.FarmInfo;
import com.kingdee.eas.farm.stocking.basedata.FarmStageEnum;
import com.kingdee.eas.farm.stocking.basedata.StockingBatch;
import com.kingdee.eas.farm.stocking.basedata.StockingBatchFactory;
import com.kingdee.eas.farm.stocking.basedata.StockingBatchHouseEntryInfo;
import com.kingdee.eas.farm.stocking.basedata.StockingBatchInfo;
import com.kingdee.eas.farm.stocking.common.BatchLastBean;
import com.kingdee.eas.farm.stocking.common.BotpCommUtils;
import com.kingdee.eas.farm.stocking.common.StockingComm;
import com.kingdee.eas.farm.stocking.processbizill.StockingBreedDailyFactory;
import com.kingdee.eas.farm.stocking.processbizill.StockingBreedDailyInfo;
import com.kingdee.eas.scm.common.BillBaseStatusEnum;
import com.kingdee.eas.util.app.ContextUtil;
import com.kingdee.eas.util.app.DbUtil;
import com.kingdee.eas.wlhlcomm.DateCommon;
import com.kingdee.jdbc.rowset.IRowSet;
import com.kingdee.util.IPropertyContainer;
import com.kingdee.util.NumericExceptionSubItem;

public class StockingBreedDailyControllerBean extends AbstractStockingBreedDailyControllerBean
{
	private static Logger logger =
		Logger.getLogger("com.kingdee.eas.farm.stocking.processbizill.app.StockingBreedDailyControllerBean");
	protected void _audit(Context ctx, IObjectValue model)throws BOSException, EASBizException
	{
		StockingBreedDailyInfo info = (StockingBreedDailyInfo) model;
		try {


			checkTransEntryLastStock(ctx, info);

			String houseIDs="";
			boolean isNeedRewrite=false;
			//启用棚舍管理
			for(int index=0;index<info.getAssEntrys().size();index++) {
				//已经完全出栏
				if(info.getAssEntrys().get(index).isIsMarketed()) {
					isNeedRewrite=true;
					if(info.getFarm().isIsHouseManager()) {
						if(houseIDs.length()>0){
							houseIDs+=",";
						}
						houseIDs+="'"+info.getAssEntrys().get(index).getHouse().getString("id")+"'";
					}
				}
			}
			//反写批次出栏标识
			if(isNeedRewrite){
				reWriteBatchIsAllOut(ctx, info.getStockingBatch().getString("id"),info.getBizDate(), houseIDs, info.getFarm().isIsHouseManager(), true);
			}

			//反写转育成，转产蛋日期
			reWritedate(ctx,info,true);


			dealTransEntryBatchInfo(ctx,info,true);

			info.setBaseStatus(BillBaseStatusEnum.AUDITED);
			info.setAuditTime(new java.util.Date());
			info.setAuditor(ContextUtil.getCurrentUserInfo(ctx));
			setBizPersonInfo(ctx,info);
			super._update(ctx, new ObjectUuidPK(info.getId()), info);


		} catch (Exception ex) {
			throw new EASBizException(new NumericExceptionSubItem("001",ex.getMessage()));
		}
		ArrayList<String> list = checkIsNeedRecalQty(ctx,info);
		for(int i=0;i<list.size();i++){
			//			_recalStockingByBatchID(ctx, list.get(i));
			_recalStockingByBatch(ctx, list.get(i),info);
		}
	}

	/**
	 * 反写转育成转产蛋日期
	 * @param ctx 
	 * @param info 
	 * @param isAudit 
	 */
	private void reWritedate(Context ctx, StockingBreedDailyInfo info, boolean isAudit) {
		// TODO Auto-generated method stub

		try {
			//获取批次
			StockingBatchInfo stockingbatchInfo = StockingBatchFactory.getLocalInstance(ctx).getStockingBatchInfo(new ObjectUuidPK(info.getStockingBatch().getId()));
			//获取品种资料
			BreedDataInfo breedDataInfo = BreedDataFactory.getLocalInstance(ctx).getBreedDataInfo(new ObjectUuidPK(stockingbatchInfo.getBreedData().getId()));

			int week = info.getWeek();
			int day = info.getWeekDay();

			//获取育成期，产蛋期开始周日龄
			String s1 = "/*dialect*/ select sum(t1.breedWeek)  breedWeek, sum(t1.breedDays)  breedDays,sum(t1.matureWeek)  matureWeek,sum(t1.matureDays)  matureDays" +
			" from ( select t2.FWeek breedWeek,t2.FDays breedDays,0 matureWeek,0 matureDays from  T_FM_BreedData t1 " +
			" inner join T_FM_BreedDataStageEntry t2 on t2.FParentID = t1.fid where t2.FFarmStage = 2 and  t1.fid ='"+breedDataInfo.getId()+"'" +
			" union all select 0  breedWeek,0  breedDays,t2.FWeek matureWeek,t2.FDays matureDays from  T_FM_BreedData t1" +
			" inner join T_FM_BreedDataStageEntry t2 on t2.FParentID = t1.fid where t2.FFarmStage = 3 and  t1.fid ='"+breedDataInfo.getId()+"')t1";
			IRowSet r1;
			r1 = DbUtil.executeQuery(ctx, s1);
			int  breedWeek = 0;
			int  breedDays = 0;
			int  matureWeek = 0;
			int  matureDays = 0;
			if(r1.next()){
				breedWeek = r1.getInt("breedWeek");
				breedDays = r1.getInt("breedDays");
				matureWeek = r1.getInt("matureWeek");
				matureDays = r1.getInt("matureDays");

				//如果 育成开始周日龄 等于 养殖日报周日龄  反写转育成日期
				if(breedWeek == week && breedDays == day){
					//反写转育成日期
					if(isAudit) {
						String s2 = "update t_fm_stockingBatch set FBreedDate= {d '"+info.getBizDate()+"'} where  fid='"+info.getStockingBatch().getId()+"'";
						com.kingdee.eas.util.app.DbUtil.execute(ctx, s2.toString());
					}else{
						String s2 = "update t_fm_stockingBatch set FBreedDate= '' where  fid='"+info.getStockingBatch().getId()+"'";
						com.kingdee.eas.util.app.DbUtil.execute(ctx, s2.toString());
					}
				}

				//反写转产蛋日期
				if(matureWeek == week && matureDays == day){
					if(isAudit) {
						String s2 = "update t_fm_stockingBatch set FMatureDate= {d '"+info.getBizDate()+"'} where  fid='"+info.getStockingBatch().getId()+"'";
						com.kingdee.eas.util.app.DbUtil.execute(ctx, s2.toString());
					}else{
						String s2 = "update t_fm_stockingBatch set FMatureDate= '' where  fid='"+info.getStockingBatch().getId()+"'";
						com.kingdee.eas.util.app.DbUtil.execute(ctx, s2.toString());
					}
				}
			}




		} catch (BOSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (EASBizException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}






	/**
	 * 重新计算该批次的存栏，包括当前单据
	 * @param ctx
	 * @param string
	 * @param info
	 * @throws BOSException 
	 */
	protected String _recalStockingByBatch(Context ctx, String batchID,
			StockingBreedDailyInfo info) throws BOSException {
		// TODO Auto-generated method stub

		StringBuffer sb=new StringBuffer();
		JSONArray json = new JSONArray();
		try {
			IRowSet rs = DbUtil.executeQuery(ctx,"select t1.Fnumber,t1.CFStockingBatchID,t1.FID dailyID,t2.FID entryID,t2.FSeq,t1.FBizDate,t2.FHouseID,t2.CFBreekingStock,t2.FFemaleBreedkingStock  from T_FM_StockingBreedDaily t1 inner join T_FM_StockingBDAE t2 on t1.FID=t2.FParentID where (t1.CFStockingBatchID='"+batchID+"'  ) and (t1.CFBaseStatus=4  or t1.fid= '"+info.getId()+"') order by t1.FBizDate");
			IRowSet rsA =null;
			String stockingBatchID;
			String entryHouseID;
			String dailyID;
			String entryID;
			Date FBizDate;
			Integer seq;
			String billNum;
			BigDecimal CFBreekingStock;
			BigDecimal FFemaleBreedkingStock;
			BigDecimal intMaleQty=BigDecimal.ZERO;
			BigDecimal intFeMaleQty=BigDecimal.ZERO;
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
			int i=0;
			while(rs.next()){
				intMaleQty=BigDecimal.ZERO;
				intFeMaleQty=BigDecimal.ZERO;

				stockingBatchID = rs.getString("CFStockingBatchID");//批次ID
				entryHouseID=rs.getString("FHouseID");//棚舍ID
				dailyID=rs.getString("dailyID");//日报ID
				if(!json.contains(dailyID)){
					json.add(dailyID+"\n");
				}
				entryID=rs.getString("entryID");
				FBizDate=rs.getDate("FBizDate");
				CFBreekingStock=rs.getBigDecimal("CFBreekingStock");//当前公鸭存栏
				FFemaleBreedkingStock=rs.getBigDecimal("FFemaleBreedkingStock");//当前母鸭存栏
				seq=rs.getInt("FSeq");
				billNum=rs.getString("Fnumber");

				if(StringUtils.isEmpty(stockingBatchID))
					continue;

				if(StringUtils.isEmpty(entryHouseID)){
					rsA=DbUtil.executeQuery(ctx,"select FBatchQty,FFemaleQty from T_FM_StockingBatch where FID=?",new String[]{stockingBatchID});
					if(rsA.next()){
						intMaleQty=UIRuleUtil.getBigDecimal(rsA.getBigDecimal("FBatchQty"));
						intFeMaleQty=UIRuleUtil.getBigDecimal(rsA.getBigDecimal("FFemaleQty"));
					}
					//累计死淘、调整、出栏
					rsA=DbUtil.executeQuery(ctx, "select sum(t2.CFDeathQty) CFDeathQty,sum(t2.CFCullQty) CFCullQty,sum(t2.FFemaleCullQty) FFemaleCullQty,sum(t2.FFemaleDeathQty) FFemaleDeathQty,sum(t2.FAdjustQty) FAdjustQty,sum(t2.FAdjustFemaleQty) FAdjustFemaleQty,sum(t2.FMarkedQty) FMarkedQty,sum(t2.FFemaleMarketed) FFemaleMarketed from T_FM_StockingBDAE t2 inner join T_FM_StockingBreedDaily t1 on t1.FID=t2.FParentID and t1.CFStockingBatchID=? and CFBaseStatus =4 and t1.FBizDate<{d '"+sdf.format(DateCommon.getNextDay(FBizDate))+"'}",new String[]{stockingBatchID});
					if(rsA.next()){
						intMaleQty=intMaleQty.subtract(UIRuleUtil.getBigDecimal(rsA.getBigDecimal("CFDeathQty"))).subtract(UIRuleUtil.getBigDecimal(rsA.getBigDecimal("CFCullQty"))).add(UIRuleUtil.getBigDecimal(rsA.getBigDecimal("FAdjustQty"))).subtract(UIRuleUtil.getBigDecimal(rsA.getBigDecimal("FMarkedQty")));
						intFeMaleQty=intFeMaleQty.subtract(UIRuleUtil.getBigDecimal(rsA.getBigDecimal("FFemaleDeathQty"))).subtract(UIRuleUtil.getBigDecimal(rsA.getBigDecimal("FFemaleCullQty"))).add(UIRuleUtil.getBigDecimal(rsA.getBigDecimal("FAdjustFemaleQty"))).subtract(UIRuleUtil.getBigDecimal(rsA.getBigDecimal("FFemaleMarketed")));
					}

					//调整入
					rsA=DbUtil.executeQuery(ctx, "select sum(t2.FTransQty) FTransQty,sum(t2.FTransFemaleQty) FTransFemaleQty from T_FM_StockingBDTE t2 inner join T_FM_StockingBreedDaily t1 on t1.FID=t2.FParentID and t1.CFStockingBatchID=? and CFBaseStatus =4  and t1.FBizDate<{d '"+sdf.format(DateCommon.getNextDay(FBizDate))+"'}",new String[]{stockingBatchID});
					if(rsA.next()){
						intMaleQty=intMaleQty.add(UIRuleUtil.getBigDecimal(rsA.getBigDecimal("FTransQty")));
						intFeMaleQty=intFeMaleQty.add(UIRuleUtil.getBigDecimal(rsA.getBigDecimal("FTransFemaleQty")));
					}
					//调整出
					rsA=DbUtil.executeQuery(ctx, "select sum(t2.FTransQty) FTransQty,sum(t2.FTransFemaleQty) FTransFemaleQty from T_FM_StockingBDTE t2 inner join T_FM_StockingBreedDaily t1 on t1.FID=t2.FParentID and t2.FFromStockingBatch=? and CFBaseStatus =4  and t1.FBizDate<{d '"+sdf.format(DateCommon.getNextDay(FBizDate))+"'}",new String[]{stockingBatchID});
					if(rsA.next()){
						intMaleQty=intMaleQty.subtract(UIRuleUtil.getBigDecimal(rsA.getBigDecimal("FTransQty")));
						intFeMaleQty=intFeMaleQty.subtract(UIRuleUtil.getBigDecimal(rsA.getBigDecimal("FTransFemaleQty")));
					}

					if(intMaleQty.compareTo(CFBreekingStock)!=0){
						sb.append(billNum+"   第"+seq+"条公鸡存栏不正确,正确存栏为"+intMaleQty+",当前值为"+CFBreekingStock).append("\n");
						DbUtil.execute(ctx, "update T_FM_StockingBDAE set CFBreekingStock="+intMaleQty+" where FParentID='"+dailyID+"' and FID='"+entryID+"'");
						//						throw new EASBizException(new NumericExceptionSubItem("001",billNum+"   第"+seq+"条公鸭存栏不正确,正确存栏为"+intMaleQty+",当前值为"+CFBreekingStock));
					}
					if(intFeMaleQty.compareTo(FFemaleBreedkingStock)!=0){
						sb.append(billNum+"   第"+seq+"条母鸡存栏不正确,正确存栏为"+intFeMaleQty+",当前值为"+FFemaleBreedkingStock).append("\n");
						DbUtil.execute(ctx, "update T_FM_StockingBDAE set FFemaleBreedkingStock="+intFeMaleQty+" where FParentID='"+dailyID+"' and FID='"+entryID+"'");
						//						throw new EASBizException(new NumericExceptionSubItem("001",billNum+"   第"+seq+"条母鸭存栏不正确,正确存栏为"+intFeMaleQty+",当前值为"+FFemaleBreedkingStock));
					}
				}else{
					//期初数据 
					rsA=DbUtil.executeQuery(ctx,"select t2.FQty,t2.FFemaleQty from T_FM_StockingBatch t1 inner join T_FM_StockingBatchHouseEntry t2 on t1.FID=t2.FParentID and t1.FID=? and t2.FHouseID=?",new String[]{stockingBatchID,entryHouseID});
					if(rsA.next()){
						intMaleQty= UIRuleUtil.getBigDecimal(rsA.getBigDecimal("FQty"));
						intFeMaleQty=UIRuleUtil.getBigDecimal(rsA.getBigDecimal("FFemaleQty"));
					}

					//累计死淘、调整、出栏
					rsA=DbUtil.executeQuery(ctx, "select sum(t2.CFDeathQty) CFDeathQty,sum(t2.CFCullQty) CFCullQty,sum(t2.FFemaleCullQty) FFemaleCullQty,sum(t2.FFemaleDeathQty) FFemaleDeathQty,sum(t2.FAdjustQty) FAdjustQty,sum(t2.FAdjustFemaleQty) FAdjustFemaleQty,sum(t2.FMarkedQty) FMarkedQty,sum(t2.FFemaleMarketed) FFemaleMarketed from T_FM_StockingBDAE t2 inner join T_FM_StockingBreedDaily t1 on t1.FID=t2.FParentID and t1.CFStockingBatchID=?  and CFBaseStatus =4  and t2.FHouseID=? and t1.FBizDate<{d '"+sdf.format(DateCommon.getNextDay(FBizDate))+"'}",new String[]{stockingBatchID,entryHouseID});
					if(rsA.next()){
						intMaleQty=intMaleQty.subtract(UIRuleUtil.getBigDecimal(rsA.getBigDecimal("CFDeathQty"))).subtract(UIRuleUtil.getBigDecimal(rsA.getBigDecimal("CFCullQty"))).add(UIRuleUtil.getBigDecimal(rsA.getBigDecimal("FAdjustQty"))).subtract(UIRuleUtil.getBigDecimal(rsA.getBigDecimal("FMarkedQty")));
						intFeMaleQty=intFeMaleQty.subtract(UIRuleUtil.getBigDecimal(rsA.getBigDecimal("FFemaleDeathQty"))).subtract(UIRuleUtil.getBigDecimal(rsA.getBigDecimal("FFemaleCullQty"))).add(UIRuleUtil.getBigDecimal(rsA.getBigDecimal("FAdjustFemaleQty"))).subtract(UIRuleUtil.getBigDecimal(rsA.getBigDecimal("FFemaleMarketed")));
					}

					//调整入
					rsA=DbUtil.executeQuery(ctx, "select sum(t2.FTransQty) FTransQty,sum(t2.FTransFemaleQty) FTransFemaleQty from T_FM_StockingBDTE t2 inner join T_FM_StockingBreedDaily t1 on t1.FID=t2.FParentID and t1.CFStockingBatchID=?  and t2.FHouseID=? and CFBaseStatus =4  and t1.FBizDate<{d '"+sdf.format(DateCommon.getNextDay(FBizDate))+"'}",new String[]{stockingBatchID,entryHouseID});
					if(rsA.next()){
						intMaleQty=intMaleQty.add(UIRuleUtil.getBigDecimal(rsA.getBigDecimal("FTransQty")));
						intFeMaleQty=intFeMaleQty.add(UIRuleUtil.getBigDecimal(rsA.getBigDecimal("FTransFemaleQty")));
					}
					//调整出
					rsA=DbUtil.executeQuery(ctx, "select sum(t2.FTransQty) FTransQty,sum(t2.FTransFemaleQty) FTransFemaleQty from T_FM_StockingBDTE t2 inner join T_FM_StockingBreedDaily t1 on t1.FID=t2.FParentID and t2.FFromStockingBatch=? and CFBaseStatus =4  and t2.FFromHouseID=? and t1.FBizDate<{d '"+sdf.format(DateCommon.getNextDay(FBizDate))+"'}",new String[]{stockingBatchID,entryHouseID});
					if(rsA.next()){
						intMaleQty=intMaleQty.subtract(UIRuleUtil.getBigDecimal(rsA.getBigDecimal("FTransQty")));
						intFeMaleQty=intFeMaleQty.subtract(UIRuleUtil.getBigDecimal(rsA.getBigDecimal("FTransFemaleQty")));
					}

					//转出单累计转入
					rsA=DbUtil.executeQuery(ctx, "select  sum(t2.CFOutmaleQty)  maleQty, sum(t2.CFOutFemaleQty)  CFOutFemaleQty  from CT_FM_TranIn t1 inner join CT_FM_TranInEntry t2 on t2.fparentid=t1.fid where t2.CFInBbatchID=?  and t2.CFInHouseID=? and t1.CFBaseStatus=3 and t1.FBizDate<{d '"+sdf.format(DateCommon.getNextDay(FBizDate))+"'}",new String[]{stockingBatchID,entryHouseID});
					if(rsA.next()){
						intMaleQty=intMaleQty.add(UIRuleUtil.getBigDecimal(rsA.getBigDecimal("maleQty")));
						intFeMaleQty=intFeMaleQty.add(UIRuleUtil.getBigDecimal(rsA.getBigDecimal("CFOutFemaleQty")));
					}
					//转出单累计转出
					rsA=DbUtil.executeQuery(ctx, "select  sum(t2.CFOutmaleQty)  maleQty, sum(t2.CFOutFemaleQty)  CFOutFemaleQty  from CT_FM_TranOut t1 inner join CT_FM_TranOutEntry t2 on t2.fparentid=t1.fid where t2.CFOutBatchID=?  and t2.CFOutHouseID=?  and t1.CFBaseStatus=3 and t1.FBizDate<{d '"+sdf.format(DateCommon.getNextDay(FBizDate))+"'}",new String[]{stockingBatchID,entryHouseID});
					if(rsA.next()){
						intMaleQty=intMaleQty.subtract(UIRuleUtil.getBigDecimal(rsA.getBigDecimal("maleQty")));
						intFeMaleQty=intFeMaleQty.subtract(UIRuleUtil.getBigDecimal(rsA.getBigDecimal("CFOutFemaleQty")));
					}

					System.out.println(FBizDate);
					if(intMaleQty.compareTo(CFBreekingStock)!=0){ 
						sb.append(billNum+"   第"+seq+"条公鸡存栏不正确,正确存栏为"+intMaleQty+",当前值为"+CFBreekingStock).append("\n");
						System.out.println("/*dialect*/update T_FM_StockingBDAE set CFBreekingStock="+intMaleQty+" where FParentID='"+dailyID+"' and FID='"+entryID+"'");


						rsA=DbUtil.executeQuery(ctx, "select CFBreekingStock  from T_FM_StockingBDAE where FParentID='"+dailyID+"' and FID='"+entryID+"'");
						if(rsA.next()){
							BigDecimal leQty=UIRuleUtil.getBigDecimal(rsA.getBigDecimal("CFBreekingStock"));
							System.out.println(leQty);
						}
						DbUtil.execute(ctx, "/*dialect*/update T_FM_StockingBDAE set CFBreekingStock="+intMaleQty+" where FParentID='"+dailyID+"' and FID='"+entryID+"'");
						rsA=DbUtil.executeQuery(ctx, "select CFBreekingStock  from T_FM_StockingBDAE where FParentID='"+dailyID+"' and FID='"+entryID+"'");
						if(rsA.next()){
							BigDecimal leQty=UIRuleUtil.getBigDecimal(rsA.getBigDecimal("CFBreekingStock"));
							System.out.println(leQty);
						}
					}
					if(intFeMaleQty.compareTo(FFemaleBreedkingStock)!=0){
						sb.append(billNum+"   第"+seq+"条母鸡存栏不正确,正确存栏为"+intFeMaleQty+",当前值为"+FFemaleBreedkingStock).append("\n");
						System.out.println("/*dialect*/update T_FM_StockingBDAE set FFemaleBreedkingStock="+intFeMaleQty+" where FParentID='"+dailyID+"' and FID='"+entryID+"'");
						DbUtil.execute(ctx, "/*dialect*/update T_FM_StockingBDAE set FFemaleBreedkingStock="+intFeMaleQty+" where FParentID='"+dailyID+"' and FID='"+entryID+"'");
					}
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			System.out.println(json.toString());
		}
		System.out.println(sb.toString());
		return null;

	}

	/**
	 * 查询是否需要重新计算其他批次的信息
	 * @param info 
	 * @param ctx 
	 */
	private ArrayList<String> checkIsNeedRecalQty(Context ctx, StockingBreedDailyInfo info) {
		// TODO Auto-generated method stub
		String batchID = info.getStockingBatch().getId().toString();
		Date bizDate = info.getBizDate();
		bizDate = DateCommon.getNextDay(bizDate);
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		ArrayList<String> list=new ArrayList<String>();
		try {
			IRowSet rs = DbUtil.executeQuery(ctx, " select * from T_FM_StockingBreedDaily where fbizdate>={d '"+sdf.format(bizDate)+"'} and CFStockingBatchID='"+batchID+"'");
			if(rs.size()>0){
				list.add(batchID);
			}

			for(int i=0;i<info.getTransEntry().size();i++){
				if(info.getTransEntry().get(i).getFromStockingBatch()!=null&&!list.contains(info.getTransEntry().get(i).getFromStockingBatch().getId().toString())){
					list.add(info.getTransEntry().get(i).getFromStockingBatch().getId().toString());
				}else{
					if(!list.contains(batchID))
						list.add(batchID);
				}
			}
		} catch (BOSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}


	/**
	 * 检查转出分录转出批次存栏量
	 * @param ctx
	 * @param info
	 * @throws Exception 
	 */
	private void checkTransEntryLastStock(Context ctx,StockingBreedDailyInfo info) throws Exception {
		int transQty,transFemaleQty;
		String houseID;
		BatchLastBean bean;
		for(int index=0;index<info.getTransEntry().size();index++) {
			transQty=info.getTransEntry().get(index).getTransQty();
			transFemaleQty=info.getTransEntry().get(index).getTransFemaleQty();
			houseID=null;
			if(info.getTransEntry().get(index).getFromStockingBatch()==null) {
				continue;
			}
			if(info.getTransEntry().get(index).getFromHouse()!=null) {
				houseID=info.getTransEntry().get(index).getFromHouse().getString("id");
			}
			bean = StockingComm.getEntryHouseBatchBean(ctx, null, info.getCompany().getString("id"), info.getBizDate(),info.getTransEntry().get(index).getFromStockingBatch().getString("id"), houseID);

			//计算这一天之前，该公司，该批次，该棚舍的公禽的转入，转出
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			String sql1 = "/*dialect*/  select sum(t.maleQty) maleQty from " +
			"( " +
			"select   (-1)*sum(t2.CFOutmaleQty)  maleQty  from CT_FM_TranOut t1 inner join CT_FM_TranOutEntry t2 on t2.fparentid=t1.fid" +
			" where t2.CFOutFarmID='"+info.getTransEntry().get(index).getFromFarm().getId().toString()+
			"' and t2.CFOutBatchID='"+info.getTransEntry().get(index).getFromStockingBatch().getId().toString()+
			"' and t2.CFOutHouseID='"+houseID+"'  and t1.CFBaseStatus=3 and t1.fbizdate<= { d'"+sdf.format(info.getBizDate())+"'}"+
			" union all "+
			"select   sum(t2.CFOutmaleQty)  maleQty  from CT_FM_TranIn t1 inner join CT_FM_TranInEntry t2 on t2.fparentid=t1.fid" +
			" where t2.CFInFarmID='"+info.getTransEntry().get(index).getFromFarm().getId().toString()+
			"' and t2.CFInBbatchID='"+info.getTransEntry().get(index).getFromStockingBatch().getId().toString()+
			"' and t2.CFInHouseID='"+houseID+"'  and t1.CFBaseStatus=3 and t1.fbizdate<= { d'" +sdf.format(info.getBizDate())+"'}"+
			") t";
			IRowSet rs1;
			BigDecimal maleQty = BigDecimal.ZERO;
			BigDecimal femaleQty = BigDecimal.ZERO;
			try {
				rs1 = DbUtil.executeQuery(ctx, sql1);
				if(rs1.next()){
					maleQty = rs1.getBigDecimal("maleQty");
					if(maleQty == null){
						maleQty = BigDecimal.ZERO;
					}else{
						maleQty = rs1.getBigDecimal("maleQty");
					}
				}

				//计算这一天之前，该公司，该养殖场，该棚舍的母禽的转入、转出
				String sql2 ="/*dialect*/  select sum(t.CFOutFemaleQty) femaleQty from " +
				"( " +
				"select  (-1)*sum(t2.CFOutFemaleQty)  CFOutFemaleQty  from CT_FM_TranOut t1 inner join CT_FM_TranOutEntry t2 on t2.fparentid=t1.fid" +
				" where t2.CFOutFarmID='"+info.getTransEntry().get(index).getFromFarm().getId().toString()+
				"' and t2.CFOutBatchID='"+info.getTransEntry().get(index).getFromStockingBatch().getId().toString()+
				"' and t2.CFOutHouseID='"+houseID+"'  and t1.CFBaseStatus=3 and t1.fbizdate<= { d '"+sdf.format(info.getBizDate())+"'}"+
				" union all "+
				"select   sum(t2.CFOutFemaleQty)  CFOutFemaleQty  from CT_FM_TranIn t1 inner join CT_FM_TranInEntry t2 on t2.fparentid=t1.fid" +
				" where t2.CFInFarmID='"+info.getTransEntry().get(index).getFromFarm().getId().toString()+
				"' and t2.CFInBbatchID='"+info.getTransEntry().get(index).getFromStockingBatch().getId().toString()+
				"' and t2.CFInHouseID='"+houseID+"'  and t1.CFBaseStatus=3 and t1.fbizdate <= { d '" +sdf.format(info.getBizDate())+
				"'}) t";
				IRowSet rs2 = DbUtil.executeQuery(ctx, sql2);
				if(rs2.next()){
					femaleQty = rs2.getBigDecimal("femaleQty");
					if(femaleQty == null){
						femaleQty = BigDecimal.ZERO;
					}else{
						femaleQty = rs2.getBigDecimal("femaleQty");
					}
				}
			} catch (BOSException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			int lastStock=bean.getLaskStock().add(maleQty).intValue();
			int femaleLaskStock=bean.getFemaleLaskStock().add(femaleQty).intValue();

			if(bean!=null) {
				if(lastStock<transQty) {
					throw new Exception("第"+(index+1)+"行转栏分录，转出批次公禽存栏量不足,存栏量为："+bean.getLaskStock());
				}
				if(femaleLaskStock<transFemaleQty) {
					throw new Exception("第"+(index+1)+"行转栏分录，转出批次母禽存栏量不足,存栏量为："+bean.getFemaleLaskStock());
				}
			}
		}
	}
	/**
	 * 处理转栏分录
	 * @param ctx
	 * @param info
	 * @throws BOSException 
	 * @throws EASBizException 
	 */
	private void dealTransEntryBatchInfo(Context ctx,StockingBreedDailyInfo info,boolean isAudit) throws EASBizException, BOSException {
		String houseID=null;
		SelectorItemCollection slor=new SelectorItemCollection();
		slor.add("*");
		slor.add("HouseEntry.*");
		slor.add("HouseEntry.house.*");
		StockingBatchInfo batchInfo = StockingBatchFactory.getLocalInstance(ctx).getStockingBatchInfo(new ObjectUuidPK(info.getStockingBatch().getId()),slor);
		boolean isExist;
		boolean hasModifyed=false;
		for(int index=0;index<info.getTransEntry().size();index++) {
			if(info.getTransEntry().get(index).getHouse()==null) {
				continue;
			}
			houseID=info.getTransEntry().get(index).getHouse().getString("id");
			//审核 如果不存在新增
			if(isAudit) {
				isExist=false;
				for(int j=0;j<batchInfo.getHouseEntry().size();j++) {
					if(batchInfo.getHouseEntry().get(j).getHouse().getString("id").equals(houseID)) {
						isExist=true;
						break;
					}
				}
				if(!isExist) {
					StockingBatchHouseEntryInfo entryInfo=new StockingBatchHouseEntryInfo();
					entryInfo.setHouse(info.getTransEntry().get(index).getHouse());
					entryInfo.setInData(batchInfo.getInDate());
					entryInfo.setRlData(info.getBizDate());
					entryInfo.setQty(BigDecimal.ZERO);
					entryInfo.setFemaleQty(BigDecimal.ZERO);
					//					entryInfo.setQty(new BigDecimal(info.getTransEntry().get(index).getTransQty()));
					//					entryInfo.setFemaleQty(new BigDecimal(info.getTransEntry().get(index).getTransFemaleQty()));
					batchInfo.getHouseEntry().add(entryInfo);
					hasModifyed=true;
				}
			}else {
				//反审核，如果不存在填写日报并且期初为0则删除
				for(int j=0;j<batchInfo.getHouseEntry().size();j++) {
					if(batchInfo.getHouseEntry().get(j).getHouse().getString("id").equals(houseID)&&((batchInfo.getHouseEntry().get(j).getQty()==null||batchInfo.getHouseEntry().get(j).getQty().signum()<=0)||(batchInfo.getHouseEntry().get(j).getFemaleQty()==null||batchInfo.getHouseEntry().get(j).getFemaleQty().signum()<=0))) {
						StringBuffer sql=new StringBuffer();
						sql.append(" select 1 from T_FM_StockingBDAE tentry")
						.append(" inner join T_FM_StockingBreedDaily tmain on tentry.fparentid=tmain.fid")
						.append(" where tmain.fcompanyid='").append(info.getCompany().getString("id")).append("'")
						.append(" and tmain.cfstockingbatchid='").append(batchInfo.get("id")).append("'")
						.append(" and tentry.fhouseid='").append(houseID).append("'")
						.append(" and tmain.fid!='").append(info.getString("id")).append("'")
						.append(" union all")
						.append(" select 1 from T_FM_StockingBDTE tentry")
						.append(" inner join T_FM_StockingBreedDaily tmain on tentry.fparentid=tmain.fid")
						.append(" where tmain.fcompanyid='").append(info.getCompany().getString("id")).append("'")
						.append(" and tmain.cfstockingbatchid='").append(batchInfo.get("id")).append("'")
						.append(" and (tentry.fhouseid='").append(houseID).append("'")
						.append(" or tentry.ffromhouseid='").append(houseID).append("')")
						.append(" and tmain.fid!='").append(info.getString("id")).append("'")
						;
						IRowSet rs = DbUtil.executeQuery(ctx, sql.toString());
						if(rs.size()<=0) {
							batchInfo.getHouseEntry().removeObject(j);
							hasModifyed=true;
						}
						break;
					}
				}
			}
		}
		if(hasModifyed) {
			StockingBatchFactory.getLocalInstance(ctx).update(new ObjectUuidPK(batchInfo.getId()),batchInfo);
		}
	}

	/**
	 * 反写批次是否完全出栏
	 * @param ctx
	 * @param batchID
	 * @param houseIDs
	 * @param isPlus
	 */
	private void reWriteBatchIsAllOut(Context ctx,String batchID,Date bizDate,String houseIDs,boolean isHouseMananger,boolean isPlus) {
		try {
			int isAllout=1;
			if(!isPlus) {
				isAllout=0;
			}
			StringBuffer sql=new StringBuffer();
			//启用棚舍管理
			if(isHouseMananger) {
				sql.append(" update T_FM_StockingBatchHouseEntry set FIsAllOut=").append(isAllout)
				.append(" ,FAllOutDate=?")
				.append(" where fhouseid in (").append(houseIDs).append(")")
				.append(" and fparentid='").append(batchID).append("'");

			}else{//不启用棚舍管理
				sql.append(" update T_FM_StockingBatchHouseEntry set FIsAllOut=").append(isAllout)
				.append(" ,FAllOutDate=?")
				.append(" where fhouseid in (").append(houseIDs).append(")")
				.append(" and fparentid='").append(batchID).append("'");

			}
			DbUtil.execute(ctx, sql.toString(),new Object[]{isPlus?bizDate:null});

		}catch(Exception err) {
			err.printStackTrace();
		}
	}

	/**
	 * 生供应链单据
	 * @param ctx
	 * @param info
	 */
	private void createToSCMBill(Context ctx,StockingBreedDailyInfo info) throws BOSException {
		try {

			BaseSysSettingInfo sysInfo = StockingComm.getSysSetting(ctx,info.getCompany().getString("id"));
			if(!sysInfo.isIsAutoSCM()) {
				return;
			}
			String destBillType=null;

			//内部管理 生产入库
			if(sysInfo.isIsInner()) {
				destBillType=BotpCommUtils.ManufactureRec_BOSTYPE;
			}else{//外部管理 生成采购入库
				destBillType=BotpCommUtils.PurInwarehouse_BOSTYPE;
			}

			BotpCommUtils btpIS = BotpCommUtils.getInstance(null);
			OrgUnitInfo orgInfo=info.getCompany();
			BOTMappingCollection btpCols = btpIS.getAllCanUsedBotps(ctx, orgInfo, info.getBOSType().toString(),destBillType,new String[]{info.getString("id")},new String[]{}, new ArrayList<String>(), null);
			for(int index=0;index<btpCols.size();index++) {
				btpIS.createToSCMBill(ctx, info,destBillType, btpCols.get(index));
			}
		}catch(Exception err) {
			throw new BOSException(err);
		}
	}


	protected void _unAudit(Context ctx, IObjectValue model)throws BOSException, EASBizException
	{


		try {
			StockingBreedDailyInfo info = (StockingBreedDailyInfo) model;
			//反审核之前校验是否有下游单据
//			checkNextBill(ctx,info);
			BaseSysSettingInfo sysInfo = StockingComm.getSysSetting(ctx, info.getCompany().getString("id"));
			String houseIDs="";
			boolean isNeedRewrite=false;
			//启用棚舍管理
			FarmInfo farmInfo = null;
			for(int index=0;index<info.getAssEntrys().size();index++) {
				//已经完全出栏
				if(info.getAssEntrys().get(index).isIsMarketed()) {
					isNeedRewrite=true;
					farmInfo = com.kingdee.eas.farm.stocking.basedata.FarmFactory.getLocalInstance(ctx).getFarmInfo(new ObjectUuidPK(info.getFarm().getId()));
					if(farmInfo.isIsHouseManager()) {
						if(houseIDs.length()>0){
							houseIDs+=",";
						}
						houseIDs+="'"+info.getAssEntrys().get(index).getHouse().getString("id")+"'";
					}
				}
			}
			//反写批次出栏标识
			if(isNeedRewrite) {
				reWriteBatchIsAllOut(ctx, info.getStockingBatch().getString("id"),info.getBizDate(), houseIDs, sysInfo.isIsHouseManager(), false);
			}

			//反写转育成，转产蛋日期
			reWritedate(ctx,info,false);

			dealTransEntryBatchInfo(ctx,info,false);

			info.setBaseStatus(BillBaseStatusEnum.TEMPORARILYSAVED);
			info.setAuditTime(null);
			info.setAuditor(null);
			super._update(ctx, new ObjectUuidPK(info.getId()), info);
		} catch (Exception ex) {
			throw new EASBizException(new NumericExceptionSubItem("001",ex.getMessage()));
		}
	}

	/**
	 * //反审核之前校验是否有下游单据
	 * @param ctx
	 * @param info
	 * @throws EASBizException 
	 */
	private void checkNextBill(Context ctx, StockingBreedDailyInfo info) throws EASBizException {
		// TODO Auto-generated method stub
		try {
			String s1 = "/*dialect*/ select t3.fid  materialBillid from T_FM_StockingBreedDaily t1" +
			" inner join T_BOT_Relation t2 on t2.FSrcObjectID = t1.fid" +
			" inner join T_IM_MaterialReqBill t3 on t3.fid= t2.FDestObjectID" +
			" where t1.fid = '"+info.getId()+"'";
			IRowSet r1 = DbUtil.executeQuery(ctx, s1);
			String materialBillid = null;
			if(r1.next()){
				materialBillid = r1.getString("materialBillid");
				if(materialBillid != null){
					throw new EASBizException(new NumericExceptionSubItem("001","已经生成了下游单据领料出库单，禁止反审核！"));
				}
			}

			String s2 = "/*dialect*/ select t3.fid  manufactureRecBill from T_FM_StockingBreedDaily t1" +
			" inner join T_BOT_Relation t2 on t2.FSrcObjectID = t1.fid" +
			" inner join T_IM_ManufactureRecBill t3 on t3.fid= t2.FDestObjectID" +
			" where t1.fid = '"+info.getId()+"'";

			IRowSet r2 = DbUtil.executeQuery(ctx, s2);
			String manufactureRecBill = null;
			if(r2.next()){
				manufactureRecBill = r2.getString("manufactureRecBill");
				if(manufactureRecBill != null){
					throw new EASBizException(new NumericExceptionSubItem("001","已经生成了下游单据生产入库单，禁止反审核！"));
				}
			}



			String s3 = "/*dialect*/ select t3.fid  otherInWarehsBill from T_FM_StockingBreedDaily t1" +
			" inner join T_BOT_Relation t2 on t2.FSrcObjectID = t1.fid" +
			" inner join T_IM_OtherInWarehsBill t3 on t3.fid= t2.FDestObjectID" +
			" where t1.fid = '"+info.getId()+"'";

			IRowSet r3 = DbUtil.executeQuery(ctx, s3);
			String otherInWarehsBill = null;
			if(r3.next()){
				otherInWarehsBill = r3.getString("otherInWarehsBill");
				if(otherInWarehsBill != null){
					throw new EASBizException(new NumericExceptionSubItem("001","已经生成了下游单据其他入库单，禁止反审核！"));
				}
			}


			String s4 = "/*dialect*/ select t3.fid  otherIssueBill from T_FM_StockingBreedDaily t1" +
			" inner join T_BOT_Relation t2 on t2.FSrcObjectID = t1.fid" +
			" inner join T_IM_OtherIssueBill t3 on t3.fid= t2.FDestObjectID" +
			" where t1.fid = '"+info.getId()+"'";

			IRowSet r4 = DbUtil.executeQuery(ctx, s4);
			String otherIssueBill = null;
			if(r4.next()){
				otherIssueBill = r4.getString("otherIssueBill");
				if(otherIssueBill != null){
					throw new EASBizException(new NumericExceptionSubItem("001","已经生成了下游单据其他出库单，禁止反审核！"));
				}
			}




		} catch (BOSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}





	}

	@Override
	protected IObjectPK _save(Context ctx, IObjectValue model) throws BOSException, EASBizException {
		// TODO Auto-generated method stub
		StockingBreedDailyInfo info = (StockingBreedDailyInfo) model;
		if(info.getBaseStatus()==null||info.getBaseStatus().getValue()==-1||info.getBaseStatus().equals(BillBaseStatusEnum.ADD)) {
			info.setBaseStatus(BillBaseStatusEnum.TEMPORARILYSAVED);
		}
		setBizPersonInfo(ctx,info);
		checkRepeatOrNot(ctx,info);
		return super._save(ctx, info);
	}


	/**
	 * 重复性校验
	 * @param ctx
	 * @param info
	 * @throws EASBizException 
	 */
	private void checkRepeatOrNot(Context ctx, StockingBreedDailyInfo info) throws EASBizException {
		// TODO Auto-generated method stub
		if(info.getFarm()!=null){
			if(!info.getFarm().isIsHouseManager()){
				String bizDateString = (new SimpleDateFormat("yyyy-MM-dd")).format(info.getBizDate());
				String sql = "/*dialact*/select * from T_FM_StockingBreedDaily where CONVERT(varchar(100), t2.fbizdate, 23)=? and CFStockingBatchID=?";
				int size = 0;
				try {
					if(info.getId() == null){
						size = DbUtil.executeQuery(ctx, sql,new Object[]{bizDateString,info.getStockingBatch().getString("id")}).size();
					}else{
						sql += " and FID<>?";
						size = DbUtil.executeQuery(ctx, sql,new Object[]{bizDateString,info.getStockingBatch().getString("id"),info.getString("id")}).size();
					}
				} catch (BOSException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if(size > 0){
					throw new EASBizException(EASBizException.CHECKDUPLICATED,new Object[]{"该批次在当前日期的养殖日报"});
				}
			}
		}
	}

	/**
	 * 设置技术员
	 * @param ctx
	 * @param info
	 */
	private void setBizPersonInfo(Context ctx, StockingBreedDailyInfo info) {
		// TODO Auto-generated method stub
		if(info.getBizPerson() == null && info.getFarmer() != null){
			try {
				IRowSet rs = DbUtil.executeQuery(ctx,"select t1.FPersonID from T_FM_PersonFarmerRelation t1 inner join T_FM_PersonFarmerRelationEntry t2 on t1.FID=t2.FParentID where FFarmerID='"+info.getFarmer().getString("id")+"'");
				if(rs.next()){
					if(StringUtils.isNotEmpty(rs.getString("FPersonID"))){
						PersonInfo personInfo = PersonFactory.getLocalInstance(ctx).getPersonInfo(new ObjectUuidPK(rs.getString("FPersonID")));
						info.setBizPerson(personInfo);
					}
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (BOSException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (EASBizException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@Override
	protected IObjectPK _submit(Context ctx, IObjectValue model) throws BOSException, EASBizException {
		StockingBreedDailyInfo info = (StockingBreedDailyInfo) model;
		if(info.getBaseStatus()==null||info.getBaseStatus().getValue()==-1||info.getBaseStatus().equals(BillBaseStatusEnum.ADD)||info.getBaseStatus().equals(BillBaseStatusEnum.TEMPORARILYSAVED)) {
			info.setBaseStatus(BillBaseStatusEnum.SUBMITED);
		}
		setBizPersonInfo(ctx,info);
		//提交后自动审核
		this._save(ctx, model);
		this._audit(ctx, model);
		return super._submit(ctx, info);
	}
	@Override
	protected void _delete(Context ctx, IObjectPK pk) throws BOSException, EASBizException {
		// TODO Auto-generated method stub
		StockingBreedDailyInfo info = StockingBreedDailyFactory.getLocalInstance(ctx).getStockingBreedDailyInfo(pk);
		if (info.getBaseStatus().equals(BillBaseStatusEnum.AUDITED)) {
			throw new EASBizException(new NumericExceptionSubItem("001","单据已经审核，禁止删除！"));
		}
		ArrayList<String> list = checkIsNeedRecalQty(ctx, info);
		super._delete(ctx, pk);
		for(int i=0;i<list.size();i++){
			_recalStockingByBatchID(ctx, list.get(i));
		}
	}
	protected List _genNextBill(Context ctx, IObjectValue model)throws BOSException
	{
		return null;
	}
	protected void _reShareCoalAndDiesel(Context ctx, IObjectValue model)throws BOSException
	{
		IRowSet rs = DbUtil.executeQuery(ctx,"select FID from T_FM_StockingBatch where FAllOutDate is null and  FIsAllOut=0");
		try {
			while(rs.next()){
				_recalStockingByBatchID(ctx,rs.getString("FID"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (EASBizException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	/**
	 * 重算某批次的存栏
	 */
	@Override
	protected String _recalStockingByBatchID(Context ctx, String batchID)
	throws BOSException, EASBizException {
		// TODO Auto-generated method stub
		StringBuffer sb=new StringBuffer();
		JSONArray json = new JSONArray();
		try {
			IRowSet rs = DbUtil.executeQuery(ctx,"select t1.Fnumber,t1.CFStockingBatchID,t1.FID dailyID,t2.FID entryID,t2.FSeq,t1.FBizDate,t2.FHouseID,t2.CFBreekingStock,t2.FFemaleBreedkingStock  from T_FM_StockingBreedDaily t1 inner join T_FM_StockingBDAE t2 on t1.FID=t2.FParentID where t1.CFStockingBatchID='"+batchID+"' and t1.CFBaseStatus=4 order by t1.FBizDate");
			IRowSet rsA =null;
			String stockingBatchID;
			String entryHouseID;
			String dailyID;
			String entryID;
			Date FBizDate;
			Integer seq;
			String billNum;
			BigDecimal CFBreekingStock;
			BigDecimal FFemaleBreedkingStock;
			BigDecimal intMaleQty=BigDecimal.ZERO;
			BigDecimal intFeMaleQty=BigDecimal.ZERO;
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
			int i=0;
			while(rs.next()){
				intMaleQty=BigDecimal.ZERO;
				intFeMaleQty=BigDecimal.ZERO;

				stockingBatchID = rs.getString("CFStockingBatchID");//批次ID
				entryHouseID=rs.getString("FHouseID");//棚舍ID
				dailyID=rs.getString("dailyID");//日报ID
				if(!json.contains(dailyID)){
					json.add(dailyID+"\n");
				}
				entryID=rs.getString("entryID");
				FBizDate=rs.getDate("FBizDate");
				CFBreekingStock=rs.getBigDecimal("CFBreekingStock");//当前公鸭存栏
				FFemaleBreedkingStock=rs.getBigDecimal("FFemaleBreedkingStock");//当前母鸭存栏
				seq=rs.getInt("FSeq");
				billNum=rs.getString("Fnumber");

				if(StringUtils.isEmpty(stockingBatchID))
					continue;

				if(StringUtils.isEmpty(entryHouseID)){
					rsA=DbUtil.executeQuery(ctx,"select FBatchQty,FFemaleQty from T_FM_StockingBatch where FID=?",new String[]{stockingBatchID});
					if(rsA.next()){
						intMaleQty=UIRuleUtil.getBigDecimal(rsA.getBigDecimal("FBatchQty"));
						intFeMaleQty=UIRuleUtil.getBigDecimal(rsA.getBigDecimal("FFemaleQty"));
					}
					//累计死淘、调整、出栏
					rsA=DbUtil.executeQuery(ctx, "select sum(t2.CFDeathQty) CFDeathQty,sum(t2.CFCullQty) CFCullQty,sum(t2.FFemaleCullQty) FFemaleCullQty,sum(t2.FFemaleDeathQty) FFemaleDeathQty,sum(t2.FAdjustQty) FAdjustQty,sum(t2.FAdjustFemaleQty) FAdjustFemaleQty,sum(t2.FMarkedQty) FMarkedQty,sum(t2.FFemaleMarketed) FFemaleMarketed from T_FM_StockingBDAE t2 inner join T_FM_StockingBreedDaily t1 on t1.FID=t2.FParentID and t1.CFStockingBatchID=? and t1.FBizDate<{d '"+sdf.format(DateCommon.getNextDay(FBizDate))+"'}",new String[]{stockingBatchID});
					if(rsA.next()){
						intMaleQty=intMaleQty.subtract(UIRuleUtil.getBigDecimal(rsA.getBigDecimal("CFDeathQty"))).subtract(UIRuleUtil.getBigDecimal(rsA.getBigDecimal("CFCullQty"))).add(UIRuleUtil.getBigDecimal(rsA.getBigDecimal("FAdjustQty"))).subtract(UIRuleUtil.getBigDecimal(rsA.getBigDecimal("FMarkedQty")));
						intFeMaleQty=intFeMaleQty.subtract(UIRuleUtil.getBigDecimal(rsA.getBigDecimal("FFemaleDeathQty"))).subtract(UIRuleUtil.getBigDecimal(rsA.getBigDecimal("FFemaleCullQty"))).add(UIRuleUtil.getBigDecimal(rsA.getBigDecimal("FAdjustFemaleQty"))).subtract(UIRuleUtil.getBigDecimal(rsA.getBigDecimal("FFemaleMarketed")));
					}

					//调整入
					rsA=DbUtil.executeQuery(ctx, "select sum(t2.FTransQty) FTransQty,sum(t2.FTransFemaleQty) FTransFemaleQty from T_FM_StockingBDTE t2 inner join T_FM_StockingBreedDaily t1 on t1.FID=t2.FParentID and t1.CFStockingBatchID=?  and t1.FBizDate<{d '"+sdf.format(DateCommon.getNextDay(FBizDate))+"'}",new String[]{stockingBatchID});
					if(rsA.next()){
						intMaleQty=intMaleQty.add(UIRuleUtil.getBigDecimal(rsA.getBigDecimal("FTransQty")));
						intFeMaleQty=intFeMaleQty.add(UIRuleUtil.getBigDecimal(rsA.getBigDecimal("FTransFemaleQty")));
					}
					//调整出
					rsA=DbUtil.executeQuery(ctx, "select sum(t2.FTransQty) FTransQty,sum(t2.FTransFemaleQty) FTransFemaleQty from T_FM_StockingBDTE t2 inner join T_FM_StockingBreedDaily t1 on t1.FID=t2.FParentID and t2.FFromStockingBatch=?  and t1.FBizDate<{d '"+sdf.format(DateCommon.getNextDay(FBizDate))+"'}",new String[]{stockingBatchID});
					if(rsA.next()){
						intMaleQty=intMaleQty.subtract(UIRuleUtil.getBigDecimal(rsA.getBigDecimal("FTransQty")));
						intFeMaleQty=intFeMaleQty.subtract(UIRuleUtil.getBigDecimal(rsA.getBigDecimal("FTransFemaleQty")));
					}

					if(intMaleQty.compareTo(CFBreekingStock)!=0){
						sb.append(billNum+"   第"+seq+"条公鸡存栏不正确,正确存栏为"+intMaleQty+",当前值为"+CFBreekingStock).append("\n");
						DbUtil.execute(ctx, "update T_FM_StockingBDAE set CFBreekingStock="+intMaleQty+" where FParentID='"+dailyID+"' and FID='"+entryID+"'");
						//						throw new EASBizException(new NumericExceptionSubItem("001",billNum+"   第"+seq+"条公鸭存栏不正确,正确存栏为"+intMaleQty+",当前值为"+CFBreekingStock));
					}
					if(intFeMaleQty.compareTo(FFemaleBreedkingStock)!=0){
						sb.append(billNum+"   第"+seq+"条母鸡存栏不正确,正确存栏为"+intFeMaleQty+",当前值为"+FFemaleBreedkingStock).append("\n");
						DbUtil.execute(ctx, "update T_FM_StockingBDAE set FFemaleBreedkingStock="+intFeMaleQty+" where FParentID='"+dailyID+"' and FID='"+entryID+"'");
						//						throw new EASBizException(new NumericExceptionSubItem("001",billNum+"   第"+seq+"条母鸭存栏不正确,正确存栏为"+intFeMaleQty+",当前值为"+FFemaleBreedkingStock));
					}
				}else{
					//期初数据 
					rsA=DbUtil.executeQuery(ctx,"select t2.FQty,t2.FFemaleQty from T_FM_StockingBatch t1 inner join T_FM_StockingBatchHouseEntry t2 on t1.FID=t2.FParentID and t1.FID=? and t2.FHouseID=?",new String[]{stockingBatchID,entryHouseID});
					if(rsA.next()){
						intMaleQty= UIRuleUtil.getBigDecimal(rsA.getBigDecimal("FQty"));
						intFeMaleQty=UIRuleUtil.getBigDecimal(rsA.getBigDecimal("FFemaleQty"));
					}

					//累计死淘、调整、出栏
					rsA=DbUtil.executeQuery(ctx, "select sum(t2.CFDeathQty) CFDeathQty,sum(t2.CFCullQty) CFCullQty,sum(t2.FFemaleCullQty) FFemaleCullQty,sum(t2.FFemaleDeathQty) FFemaleDeathQty,sum(t2.FAdjustQty) FAdjustQty,sum(t2.FAdjustFemaleQty) FAdjustFemaleQty,sum(t2.FMarkedQty) FMarkedQty,sum(t2.FFemaleMarketed) FFemaleMarketed from T_FM_StockingBDAE t2 inner join T_FM_StockingBreedDaily t1 on t1.FID=t2.FParentID and t1.CFStockingBatchID=? and t2.FHouseID=? and t1.FBizDate<{d '"+sdf.format(DateCommon.getNextDay(FBizDate))+"'}",new String[]{stockingBatchID,entryHouseID});
					if(rsA.next()){
						intMaleQty=intMaleQty.subtract(UIRuleUtil.getBigDecimal(rsA.getBigDecimal("CFDeathQty"))).subtract(UIRuleUtil.getBigDecimal(rsA.getBigDecimal("CFCullQty"))).add(UIRuleUtil.getBigDecimal(rsA.getBigDecimal("FAdjustQty"))).subtract(UIRuleUtil.getBigDecimal(rsA.getBigDecimal("FMarkedQty")));
						intFeMaleQty=intFeMaleQty.subtract(UIRuleUtil.getBigDecimal(rsA.getBigDecimal("FFemaleDeathQty"))).subtract(UIRuleUtil.getBigDecimal(rsA.getBigDecimal("FFemaleCullQty"))).add(UIRuleUtil.getBigDecimal(rsA.getBigDecimal("FAdjustFemaleQty"))).subtract(UIRuleUtil.getBigDecimal(rsA.getBigDecimal("FFemaleMarketed")));
					}

					//调整入
					rsA=DbUtil.executeQuery(ctx, "select sum(t2.FTransQty) FTransQty,sum(t2.FTransFemaleQty) FTransFemaleQty from T_FM_StockingBDTE t2 inner join T_FM_StockingBreedDaily t1 on t1.FID=t2.FParentID and t1.CFStockingBatchID=?  and t2.FHouseID=? and t1.FBizDate<{d '"+sdf.format(DateCommon.getNextDay(FBizDate))+"'}",new String[]{stockingBatchID,entryHouseID});
					if(rsA.next()){
						intMaleQty=intMaleQty.add(UIRuleUtil.getBigDecimal(rsA.getBigDecimal("FTransQty")));
						intFeMaleQty=intFeMaleQty.add(UIRuleUtil.getBigDecimal(rsA.getBigDecimal("FTransFemaleQty")));
					}
					//调整出
					rsA=DbUtil.executeQuery(ctx, "select sum(t2.FTransQty) FTransQty,sum(t2.FTransFemaleQty) FTransFemaleQty from T_FM_StockingBDTE t2 inner join T_FM_StockingBreedDaily t1 on t1.FID=t2.FParentID and t2.FFromStockingBatch=?  and t2.FFromHouseID=? and t1.FBizDate<{d '"+sdf.format(DateCommon.getNextDay(FBizDate))+"'}",new String[]{stockingBatchID,entryHouseID});
					if(rsA.next()){
						intMaleQty=intMaleQty.subtract(UIRuleUtil.getBigDecimal(rsA.getBigDecimal("FTransQty")));
						intFeMaleQty=intFeMaleQty.subtract(UIRuleUtil.getBigDecimal(rsA.getBigDecimal("FTransFemaleQty")));
					}

					if(intMaleQty.compareTo(CFBreekingStock)!=0){ 
						sb.append(billNum+"   第"+seq+"条公鸡存栏不正确,正确存栏为"+intMaleQty+",当前值为"+CFBreekingStock).append("\n");
						System.out.println("/*dialect*/update T_FM_StockingBDAE set CFBreekingStock="+intMaleQty+" where FParentID='"+dailyID+"' and FID='"+entryID+"'");
						DbUtil.execute(ctx, "/*dialect*/update T_FM_StockingBDAE set CFBreekingStock="+intMaleQty+" where FParentID='"+dailyID+"' and FID='"+entryID+"'");
						//						throw new EASBizException(new NumericExceptionSubItem("001",billNum+"   第"+seq+"条公鸭存栏不正确,正确存栏为"+intMaleQty+",当前值为"+CFBreekingStock));
					}
					if(intFeMaleQty.compareTo(FFemaleBreedkingStock)!=0){
						sb.append(billNum+"   第"+seq+"条母鸡存栏不正确,正确存栏为"+intFeMaleQty+",当前值为"+FFemaleBreedkingStock).append("\n");
						System.out.println("/*dialect*/update T_FM_StockingBDAE set FFemaleBreedkingStock="+intFeMaleQty+" where FParentID='"+dailyID+"' and FID='"+entryID+"'");
						DbUtil.execute(ctx, "/*dialect*/update T_FM_StockingBDAE set FFemaleBreedkingStock="+intFeMaleQty+" where FParentID='"+dailyID+"' and FID='"+entryID+"'");
						//						throw new EASBizException(new NumericExceptionSubItem("001",billNum+"   第"+seq+"条母鸭存栏不正确,正确存栏为"+intFeMaleQty+",当前值为"+FFemaleBreedkingStock));
					}
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			System.out.println(json.toString());
		}
		System.out.println(sb.toString());
		return null;
	}
}