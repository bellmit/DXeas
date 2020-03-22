package com.kingdee.eas.farm.dayratecost.app;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;

import org.apache.log4j.Logger;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.Context;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.bos.util.BOSUuid;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.farm.dayratecost.AllocationTypeEnum;
import com.kingdee.eas.farm.dayratecost.CostAllocationEntryDetailInfo;
import com.kingdee.eas.farm.dayratecost.CostAllocationFactory;
import com.kingdee.eas.farm.dayratecost.CostAllocationInfo;
import com.kingdee.eas.farm.dayratecost.comm.DayrateUtils;
import com.kingdee.eas.farm.stocking.basedata.FarmStageEnum;
import com.kingdee.eas.farm.stocking.common.BatchLastBean;
import com.kingdee.eas.farm.stocking.common.StockingComm;
import com.kingdee.eas.scm.common.BillBaseStatusEnum;
import com.kingdee.eas.util.app.ContextUtil;
import com.kingdee.eas.util.app.DbUtil;
import com.kingdee.jdbc.rowset.IRowSet;
import com.kingdee.util.NumericExceptionSubItem;

public class CostAllocationControllerBean extends AbstractCostAllocationControllerBean
{
	private static Logger logger =
		Logger.getLogger("com.kingdee.eas.farm.dayratecost.app.CostAllocationControllerBean");
	protected void _audit(Context ctx, IObjectValue model)throws BOSException
	{
		try {
			CostAllocationInfo info = ( CostAllocationInfo) model;
			info.setBillStatus(BillBaseStatusEnum.AUDITED);
			info.setAuditTime(new java.util.Date());
			info.setAuditor(ContextUtil.getCurrentUserInfo(ctx));

			super._update(ctx, new ObjectUuidPK(info.getId()), info);
		} catch (Exception ex) {
			throw new BOSException(ex);
		}
	}
	protected void _unAudit(Context ctx, IObjectValue model)throws BOSException
	{
		try {
			CostAllocationInfo info = ( CostAllocationInfo) model;
			info.setBillStatus(BillBaseStatusEnum.TEMPORARILYSAVED);
			info.setAuditTime(null);
			info.setAuditor(null);

			super._update(ctx, new ObjectUuidPK(info.getId()), info);
		} catch (Exception ex) {
			throw new BOSException(ex);
		}
	}
	@Override
	protected IObjectPK _save(Context ctx, IObjectValue model) throws BOSException, EASBizException {
		// TODO Auto-generated method stub
		CostAllocationInfo info = (CostAllocationInfo) model;
		if(info.getBillStatus()==null||info.getBillStatus().getValue()==-1||info.getBillStatus().equals(BillBaseStatusEnum.ADD)) {
			info.setBillStatus(BillBaseStatusEnum.TEMPORARILYSAVED);
		}
		return super._save(ctx, info);
	}

	@Override
	protected IObjectPK _submit(Context ctx, IObjectValue model) throws BOSException, EASBizException {
		CostAllocationInfo info = (CostAllocationInfo) model;
		if(info.getBillStatus()==null||info.getBillStatus().getValue()==-1||info.getBillStatus().equals(BillBaseStatusEnum.ADD)||info.getBillStatus().equals(BillBaseStatusEnum.TEMPORARILYSAVED)) {
			info.setBillStatus(BillBaseStatusEnum.SUBMITED);
		}
		return super._submit(ctx, info);
	}
	@Override
	protected void _delete(Context ctx, IObjectPK pk) throws BOSException, EASBizException {
		// TODO Auto-generated method stub
		CostAllocationInfo info = CostAllocationFactory.getLocalInstance(ctx).getCostAllocationInfo(pk);
		if (info.getBillStatus().equals(BillBaseStatusEnum.AUDITED)) {
			throw new EASBizException(new NumericExceptionSubItem("001","单据已经审核，禁止删除！"));
		}
		super._delete(ctx, pk);
	}

	/**
	 * 执行分配计算 在养天只计算：日存栏量合计/分摊范围内每日存栏量累计总
	 * @throws EASBizException 
	 */

	protected void _exeAllocation(Context ctx, IObjectValue model)	throws BOSException, EASBizException {
		try {
			CostAllocationInfo info=(CostAllocationInfo) model;
			for(int index=0;index<info.getEntrys().size();index++) {
				info.getEntrys().get(index).getDetail().clear();
			}

			IRowSet rsMax;
			Date[] dateRange = StockingComm.getDateRangeByPeriod(ctx, info.getCompany().getString("id"), info.getPeriod().getString("id"));
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

			//获取该养殖场所有的批次
			StringBuffer sql=new StringBuffer();
			sql.append(" select distinct tbatch.fid fbatchid,tbatch.fnumber fbatchNum,tbe.fseq FBESeq,tbe.fhouseID,tbatch.ffarmID,tbatch.ffarmerID,")
			.append(" tbatch.FBreedDate,tbatch.FMatureDate")//转育成日期，定群日期
			.append(" from t_fm_stockingBatch tbatch")
			.append(" inner join t_fm_farmers tfr on tfr.fid=tbatch.ffarmerid")
			.append(" inner join t_fm_farm tf on tf.fid=tbatch.ffarmid")
			.append(" left join T_FM_StockingBatchHouseEntry tbe on tbe.fparentid=tbatch.fid")
			.append(" where tbatch.fcompanyID='").append(info.getCompany().getString("id")).append("'");
			//养殖场分配
			if(info.getAllocationType().equals(AllocationTypeEnum.byFarm)) {
				sql.append(" and tbatch.ffarmid='").append(info.getFarm().getString("id")).append("'");
			}else if(info.getAllocationType().equals(AllocationTypeEnum.byFarmer)) {
				sql.append(" and tbatch.ffarmerid='").append(info.getFarmer().getString("id")).append("'");
			}else if(info.getAllocationType().equals(AllocationTypeEnum.byFarmGroup)) {
				sql.append(" and tf.ftreeid='").append(info.getFarmGroup().getString("id")).append("'");
			}else if(info.getAllocationType().equals(AllocationTypeEnum.byFarmerGroup)) {
				sql.append(" and tfr.ftreeid='").append(info.getFarmerGroup().getString("id")).append("'");
			}
			sql.append(" and tbatch.fid in(")
			.append(" select distinct cfstockingbatchid from T_FM_StockingBreedDaily tbill")
			.append(" inner join t_fm_farmers tfr on tfr.fid=tbill.ffarmerid")
			.append(" inner join t_fm_farm tf on tf.fid=tbill.cffarmid");
			//养殖场分配
			if(info.getAllocationType().equals(AllocationTypeEnum.byFarm)) {
				sql.append(" and tbill.cffarmid='").append(info.getFarm().getString("id")).append("'");
			}else if(info.getAllocationType().equals(AllocationTypeEnum.byFarmer)) {
				sql.append(" and tbill.ffarmerid='").append(info.getFarmer().getString("id")).append("'");
			}else if(info.getAllocationType().equals(AllocationTypeEnum.byFarmGroup)) {
				sql.append(" and tf.ftreeid='").append(info.getFarmGroup().getString("id")).append("'");
			}else if(info.getAllocationType().equals(AllocationTypeEnum.byFarmerGroup)) {
				sql.append(" and tfr.ftreeid='").append(info.getFarmerGroup().getString("id")).append("'");
			}
			sql.append(" where tbill.FCompanyID='").append(info.getCompany().getString("id")).append("'")
			.append(" and tbill.fbizDate>={d '").append(sdf.format(dateRange[0])).append("'} and tbill.fbizDate<={ d'").append(dateRange[1]).append("'}")
			.append(" and tbill.cfbaseStatus=4")
			.append(" )")
			.append(" order by tbatch.fnumber,tbe.fseq");
			IRowSet rs=DbUtil.executeQuery(ctx, sql.toString());
			BatchLastBean bean;
			int allQty=0;
			int qty,beforeMatrueQty,afterMatrueQty;
			BigDecimal prop;
			BigDecimal b100=new BigDecimal(100);
			Calendar cal=Calendar.getInstance();
			//明细list
			LinkedList<CostAllocationEntryDetailInfo> detailList=new LinkedList<CostAllocationEntryDetailInfo>();
			Date matureDate;//定群日期
			String companyID=info.getCompany().getString("id");
			while(rs.next()) {
				matureDate=rs.getDate("FMatureDate");

				//	    		bean = StockingComm.getEntryHouseBatchBean(ctx, null, info.getCompany().getString("id"), dateRange[1], rs.getString("fbatchid"), rs.getString("fhouseID"));
				//	    		qty=bean.getLaskStock().add(bean.getFemaleLaskStock()).intValue();
				//	    		qty=DayrateUtils.getStockingLastStock(ctx, companyID, dateRange[1],rs.getString("fbatchid"), rs.getString("fhouseID"),DayrateUtils.LastStockCountType_All);
				//	    		allQty+=qty;
				//	    		if(qty<=0) {
				//	    			continue;
				//	    		}


				CostAllocationEntryDetailInfo detailInfo=new CostAllocationEntryDetailInfo();
				//	    		detailInfo.setId(BOSUuid.create(detailInfo.getBOSType()));
				detailInfo.setString("stockingBatch", rs.getString("fbatchid"));
				detailInfo.setString("farmer", rs.getString("ffarmerID"));
				detailInfo.setString("farm", rs.getString("ffarmID"));
				detailInfo.setString("house", rs.getString("fhouseID"));
				if(rs.getDate("FBreedDate")!=null) {
					detailInfo.setBreedStage(FarmStageEnum.breed);//育成期
				}else{
					detailInfo.setBreedStage(FarmStageEnum.brood);//育雏期
				}
				detailInfo.setMatureDate(matureDate);
				//	    		detailInfo.setLastStock(qty);
				detailInfo.setMatureQty(0);
				cal.setTime(dateRange[1]);
				rsMax=DbUtil.executeQuery(ctx, "select max(FBizDate)  FBizDate from  T_FM_StockingBreedDaily t1  where  CFStockingBatchID='"+detailInfo.getString("stockingBatch")+"'");
				if(rsMax.next())
					if(rsMax.getDate("FBizDate").before(cal.getTime()))
						cal.setTime(rsMax.getDate("FBizDate"));
				int actual = DayrateUtils.getOnBreedDayStock(ctx, companyID, dateRange[0], cal.getTime(), rs.getString("fbatchid"), rs.getString("fhouseID"),DayrateUtils.LastStockCountType_All);
				detailInfo.setLastStock(actual);
				allQty+=actual;

				detailInfo.setMatureprop(BigDecimal.ZERO);
				detailList.add(detailInfo);
				if(matureDate!=null) {
					//如果 定群日期在期间日期范围内，则新增两条
					if((dateRange[0].before(matureDate)&&dateRange[1].after(matureDate))||dateRange[0].equals(matureDate)||dateRange[1].equals(matureDate)) {
						//根据定群日期进行比例分配--定群前的存栏
						cal.setTime(matureDate);
						cal.add(Calendar.DAY_OF_MONTH, -1);

						beforeMatrueQty=DayrateUtils.getOnBreedDayStock(ctx, companyID, dateRange[0], cal.getTime(), rs.getString("fbatchid"), rs.getString("fhouseID"),DayrateUtils.LastStockCountType_All);
//						afterMatrueQty=DayrateUtils.getOnBreedDayStock(ctx, companyID, matureDate, dateRange[1], rs.getString("fbatchid"), rs.getString("fhouseID"),DayrateUtils.LastStockCountType_All);
						afterMatrueQty=actual-beforeMatrueQty;
						//	    	    		allQty+=afterMatrueQty;
						//	    				bean = StockingComm.getEntryHouseBatchBean(ctx, null, info.getCompany().getString("id"),cal.getTime(), rs.getString("fBatchid"), rs.getString("fhouseID"));
						//	    				beforeMatrueQty=bean.getLaskStock().add(bean.getFemaleLaskStock()).intValue();
						//	    				detailInfo.setMatureQty(qty-beforeMatrueQty);
						//	    				prop=new BigDecimal(100*(qty-beforeMatrueQty)/qty).setScale(2,BigDecimal.ROUND_HALF_UP);

						prop=new BigDecimal(100*afterMatrueQty).divide(new BigDecimal(beforeMatrueQty+afterMatrueQty),2,BigDecimal.ROUND_HALF_UP);
						detailInfo.setMatureprop(prop);//比例
						detailInfo.setMatureQty(afterMatrueQty);

						//		    			CostAllocationEntryDetailInfo detailInfo2=(CostAllocationEntryDetailInfo) detailInfo.clone();
						//		    			detailInfo2.setBreedStage(FarmStageEnum.eggs);//产蛋期
						//		    			detailList.add(detailInfo2);
					}else {
						//如果存在定群日期，则设置阶段为产蛋期
						if(dateRange[1].after(matureDate)) {
							detailInfo.setBreedStage(FarmStageEnum.eggs);//产蛋期
						}
					}
				}
			}

			//排序
			CostAllocationEntryDetailInfo tempInfo=null;
			for(int i=0;i<detailList.size();i++) {
				tempInfo=detailList.get(i);
				for(int j=i;j<detailList.size();j++) {
					if(detailList.get(j).getLastStock()<tempInfo.getLastStock()) {
						tempInfo=detailList.get(j);
						detailList.set(j, detailList.get(i));
						detailList.set(i, tempInfo);
					}
				}
			}
			//	    	detailList=detailList2;

			//执行分配
			BigDecimal allAmount,amount,sumAmount,matureAmount,allocationAmount;
			CostAllocationEntryDetailInfo detailInfo,detailInfo2;
			//	    	String title;
			//金额保存map
			for(int index=0;index<info.getEntrys().size();index++) {
				allAmount=info.getEntrys().get(index).getAmount();
				sumAmount=BigDecimal.ZERO;
				for(int j=0;j<detailList.size();j++){
					detailInfo=detailList.get(j);
					detailInfo2=null;
					detailInfo.setAllLastStock(allQty);
					//在养天只 比例
					prop=new BigDecimal(100*detailInfo.getLastStock()).divide(new BigDecimal(allQty),10,BigDecimal.ROUND_HALF_UP);

					if(j==(detailList.size()-1)) {
						amount=allAmount.subtract(sumAmount);
					}else{
						amount=prop.multiply(allAmount).divide(b100,2,BigDecimal.ROUND_HALF_UP);
						sumAmount=sumAmount.add(amount);
					}
					detailInfo.setProportion(prop);
					detailInfo.setProportion2(prop);
					detailInfo.setAmount(amount);

					//定群数量大于0
					if(detailInfo.getMatureQty()>0) {
						//		    			title=detailInfo.getStockingBatch().getString("id")+"||"+detailInfo.getHouse()!=null?detailInfo.getHouse().getString("id"):"";
						//	    				title=detailInfo.getString("stockingBatch")+"||"+(StringUtils.isNotEmpty(detailInfo.getString("house"))?detailInfo.getString("house"):"");

						allocationAmount=BigDecimal.ZERO;
						matureAmount=amount.multiply(detailInfo.getMatureprop()).divide(b100,10,BigDecimal.ROUND_HALF_UP);
						//		    			matureAmount=amount.multiply(b100.subtract(detailInfo.getMatureprop())).divide(b100,2,BigDecimal.ROUND_HALF_UP);

						//育雏或育成 育成和产蛋、育雏和产蛋不会同时存在，直接检查即可
						/*if(detailInfo.getBreedStage().equals(FarmStageEnum.brood)||detailInfo.getBreedStage().equals(FarmStageEnum.breed)) {
//			    			if(!amountMap.containsKey(title)) {
//			    				amountMap.put(title, matureAmount);
//			    			}
			    			allocationAmount=amount.subtract(matureAmount);
		    			}else if(detailInfo.getBreedStage().equals(FarmStageEnum.eggs))  {
		    				//如果是产蛋期则减差
//		    				if(amountMap.containsKey(title)) {
//		    					matureAmount=amountMap.get(title);
//		    				}
		    				allocationAmount=matureAmount;
		    			}*/
						detailInfo.setMatureAmount(matureAmount);
						detailInfo.setAlloctionAmount(amount.subtract(matureAmount));

						detailInfo2=(CostAllocationEntryDetailInfo) detailInfo.clone();
						detailInfo2.setBreedStage(FarmStageEnum.eggs);//产蛋期
						//		    			detailInfo2.setId(BOSUuid.create(detailInfo2.getBOSType()));
						detailInfo2.setMatureAmount(matureAmount);
						detailInfo2.setAlloctionAmount(matureAmount);
					}else {
						detailInfo.setAlloctionAmount(amount);
					}

					//	    			//添加分配明细
					//	    			tempInfo=(CostAllocationEntryDetailInfo) detailInfo.clone();
					//	    			tempInfo.setId(BOSUuid.create(tempInfo.getBOSType()));

					info.getEntrys().get(index).getDetail().add((CostAllocationEntryDetailInfo) detailInfo.clone());
					if(detailInfo2!=null)  {
						info.getEntrys().get(index).getDetail().add(detailInfo2);
					}
				}
			}
			detailList=null;
			//保存
			super._save(ctx, info);
		} catch (Exception e) {
			throw new EASBizException(new NumericExceptionSubItem("001",e.getMessage()));
		}
	}
}