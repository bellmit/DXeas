package com.kingdee.eas.farm.stocking.processbizill.app;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.sql.RowSet;

import net.sf.json.JSONObject;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.Context;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.bos.dao.query.SQLExecutorFactory;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;
import com.kingdee.bos.metadata.entity.SelectorItemInfo;
import com.kingdee.bos.ui.face.UIRuleUtil;
import com.kingdee.bos.util.BOSUuid;
import com.kingdee.eas.basedata.assistant.IMeasureUnit;
import com.kingdee.eas.basedata.assistant.MeasureUnitFactory;
import com.kingdee.eas.basedata.assistant.MeasureUnitInfo;
import com.kingdee.eas.basedata.assistant.PeriodFactory;
import com.kingdee.eas.basedata.assistant.PeriodInfo;
import com.kingdee.eas.basedata.master.material.IMaterial;
import com.kingdee.eas.basedata.master.material.MaterialFactory;
import com.kingdee.eas.basedata.master.material.MaterialInfo;
import com.kingdee.eas.basedata.org.CompanyOrgUnitFactory;
import com.kingdee.eas.basedata.org.CompanyOrgUnitInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.farm.hatch.EggSourceType;
import com.kingdee.eas.farm.stocking.basedata.AbstractStockingBatchInfo;
import com.kingdee.eas.farm.stocking.basedata.AwardsCalType;
import com.kingdee.eas.farm.stocking.basedata.CoProductPriceFactory;
import com.kingdee.eas.farm.stocking.basedata.CoProductPrice;
import com.kingdee.eas.farm.stocking.basedata.CoProductPriceInfo;
import com.kingdee.eas.farm.stocking.basedata.FarmBaseStatusEnum;
import com.kingdee.eas.farm.stocking.basedata.FarmFactory;
import com.kingdee.eas.farm.stocking.basedata.FarmInfo;
import com.kingdee.eas.farm.stocking.basedata.FarmStageEnum;
import com.kingdee.eas.farm.stocking.basedata.FarmersTreeFactory;
import com.kingdee.eas.farm.stocking.basedata.FarmersTreeInfo;
import com.kingdee.eas.farm.stocking.basedata.IFarm;
import com.kingdee.eas.farm.stocking.basedata.ISettlementItem;
import com.kingdee.eas.farm.stocking.basedata.SettleItemType;
import com.kingdee.eas.farm.stocking.basedata.SettleStandardFactory;
import com.kingdee.eas.farm.stocking.basedata.SettleStandardInfo;
import com.kingdee.eas.farm.stocking.basedata.SettlementItemFactory;
import com.kingdee.eas.farm.stocking.basedata.SettlementItemInfo;
import com.kingdee.eas.farm.stocking.basedata.StockingBatchFactory;
import com.kingdee.eas.farm.stocking.basedata.StockingBatchInfo;
import com.kingdee.eas.farm.stocking.basedata.StockingFarmTypeEnum;
import com.kingdee.eas.farm.stocking.common.BasePriceBean;
import com.kingdee.eas.farm.stocking.common.StockingComm;
import com.kingdee.eas.farm.stocking.hatch.StatisticsType;
import com.kingdee.eas.farm.stocking.processbizill.IStatementsBill;
import com.kingdee.eas.farm.stocking.processbizill.SettleBreedStageEnum;
import com.kingdee.eas.farm.stocking.processbizill.StatementsBillBatchDetailInfo;
import com.kingdee.eas.farm.stocking.processbizill.StatementsBillCollection;
import com.kingdee.eas.farm.stocking.processbizill.StatementsBillEggEntryInfo;
import com.kingdee.eas.farm.stocking.processbizill.StatementsBillEntryInfo;
import com.kingdee.eas.farm.stocking.processbizill.StatementsBillFactory;
import com.kingdee.eas.farm.stocking.processbizill.StatementsBillInfo;
import com.kingdee.eas.farm.stocking.processbizill.StatementsBillOtherEntryInfo;
import com.kingdee.eas.farm.stocking.processbizill.StatementsBillRewardsEntryInfo;
import com.kingdee.eas.farm.stocking.processbizill.StockingSettlementTypeEnum;
import com.kingdee.eas.fi.cas.BillStatusEnum;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.scm.common.BillBaseStatusEnum;
import com.kingdee.eas.util.app.ContextUtil;
import com.kingdee.eas.util.app.DbUtil;
import com.kingdee.eas.wlhlcomm.AppCommon;
import com.kingdee.jdbc.rowset.IRowSet;
import com.kingdee.util.IPropertyContainer;
import com.kingdee.util.NumericExceptionSubItem;

public class StatementsBillControllerBean extends AbstractStatementsBillControllerBean
{
	private static Logger logger =
		Logger.getLogger("com.kingdee.eas.farm.stocking.processbizill.app.StatementsBillControllerBean");
	private IMaterial ims =null;
	private IMeasureUnit imus =null;
	private ArrayList<BasePriceBean> priceList=new ArrayList<BasePriceBean>();
	private SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
	private SimpleDateFormat sdf2=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	private SimpleDateFormat sdf3=new SimpleDateFormat("yyyy-MM");
	private IRowSet rs;
	private IRowSet rsA;//奖惩
	private Calendar cal=Calendar.getInstance();
	//查询过滤条件
	private StringBuffer filterSqlStr=new StringBuffer();
	private StringBuffer filterOracleStr=new StringBuffer();
	private StringBuffer batchFilterStr=new StringBuffer();
	private StringBuffer dateFilterStr=new StringBuffer();
	//固定资产育成应收冲回明细表
	private static final String faOffSetDetailTable="T_FM_ArAODBE";
	private CoProductPriceInfo copInfo=null;//副产品价格Info



	protected void _audit(Context ctx, IObjectValue model)throws BOSException
	{
		try {
			StatementsBillInfo info = ( StatementsBillInfo) model;

			//生成单据
			//    		createToBill(ctx, info);

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
			StatementsBillInfo info = ( StatementsBillInfo) model;
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
		StatementsBillInfo info = ( StatementsBillInfo) model;
		if(info.getBillStatus()==null||info.getBillStatus().getValue()==-1||info.getBillStatus().equals(BillBaseStatusEnum.ADD)) {
			info.setBillStatus(BillBaseStatusEnum.TEMPORARILYSAVED);
		}
		String farmerid = null;
		farmerid=info.getString("farmer");

		if(UIRuleUtil.isNotNull(farmerid)){
			IRowSet rsQuery = DbUtil.executeQuery(ctx, "select FTreeID from T_FM_Farmers where fid='"+farmerid+"'");
			try {
				if(rsQuery.next()){
					if(rsQuery.getString("FTreeID")!=null)
						info.setFarmersTree(FarmersTreeFactory.getLocalInstance(ctx).getFarmersTreeInfo(new ObjectUuidPK(rsQuery.getString("FTreeID"))));
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return super._save(ctx, info);
	}

	@Override
	protected IObjectPK _submit(Context ctx, IObjectValue model) throws BOSException, EASBizException {
		StatementsBillInfo info = ( StatementsBillInfo) model;
		if(info.getBillStatus()==null||info.getBillStatus().getValue()==-1||info.getBillStatus().equals(BillBaseStatusEnum.ADD)||info.getBillStatus().equals(BillBaseStatusEnum.TEMPORARILYSAVED)) {
			info.setBillStatus(BillBaseStatusEnum.SUBMITED);
		}
		String farmerid = null;
		farmerid=info.getString("farmer");
		if(farmerid!=null){
			IRowSet rsQuery = DbUtil.executeQuery(ctx, "select FTreeID from T_FM_Farmers where fid='"+farmerid+"'");
			try {
				if(rsQuery.next()){
					if(rsQuery.getString("FTreeID")!=null) {
						FarmersTreeInfo farmersTreeInfo = FarmersTreeFactory.getLocalInstance(ctx).getFarmersTreeInfo(new ObjectUuidPK(rsQuery.getString("FTreeID")));
						info.setFarmersTree(farmersTreeInfo);
					}
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return super._submit(ctx, info);
	}
	@Override
	protected void _delete(Context ctx, IObjectPK pk) throws BOSException, EASBizException {
		// TODO Auto-generated method stub
		StatementsBillInfo info =  StatementsBillFactory.getLocalInstance(ctx).getStatementsBillInfo(pk);
		if (info.getBillStatus().equals(BillBaseStatusEnum.AUDITED)) {
			throw new EASBizException(new NumericExceptionSubItem("001","单据已经审核，禁止删除！"));
		}

		//删除育成期成本冲回应收数据
		StringBuffer sql=new StringBuffer();
		sql.append(" delete from ").append(faOffSetDetailTable).append(" where FSettleBillID='").append(info.getString("id")).append("'");
		DbUtil.execute(ctx, sql.toString());

		super._delete(ctx, pk);
	}

	/**
	 * 结算计算
	 */
	protected Object _btnExeCal(Context ctx, IObjectValue model) throws BOSException, EASBizException {
		// TODO Auto-generated method stub
		StatementsBillInfo info = (StatementsBillInfo) model;
		String companyID=null;
		String batchID=null;
		String contractID=null;
		String periodID=null;
		if(info.getBillStatus().equals(BillBaseStatusEnum.AUDITED)){
			throw new EASBizException(new NumericExceptionSubItem("001","已审核的结算单禁止重新结算"));
		}

		//非批量结算
		if(!model.containsKey("batchExe")||!model.getBoolean("batchExe")) {
			SelectorItemCollection slor=new SelectorItemCollection();
			slor.add(new SelectorItemInfo("*"));
			slor.add(new SelectorItemInfo("farmer.*"));
			slor.add(new SelectorItemInfo("stockingBatch.*"));
			if(info.getId()!=null) {
				info=StatementsBillFactory.getLocalInstance(ctx).getStatementsBillInfo(new ObjectUuidPK(model.getString("id")),slor);
			}	

			if(info.getStockingBatch()!=null) {
				batchID=info.getStockingBatch().getString("id");
			}
			if(info.getBatchContract()!=null) {
				contractID=info.getBatchContract().getString("id");
			}
			//			info.setString("companyID",companyID);
			info.setString("farmerID",info.getFarmer().getString("id"));
			info.setString("farmID",info.getFarm().getString("id"));
			info.setString("stockingBatchID",batchID);
			info.setString("contractID",contractID);
			info.setString("periodID",info.getPeriod().getString("id"));

			companyID=info.getCompany().getString("id");
			periodID=info.getPeriod().getString("id");



			info.setLoanInterestDiff(getLoanInterestDiff(ctx,info));


			//删除冲回数据
			StringBuffer sql=new StringBuffer();
			sql.append(" delete from ").append(faOffSetDetailTable).append(" where FSettleBillID='").append(info.getString("id")).append("'");
			DbUtil.execute(ctx, sql.toString());

			setCoProductPriceInfo(ctx, companyID, sdf.format(info.getBizDate()));

			/**
			 * 设置批量
			 */
			info.getBatchDetail().clear();

			sql.setLength(0);
			sql.append(" select * ")
			.append(" from t_fm_stockingBatch ")
			.append(" where ffarmerID='").append(info.getString("farmerID")).append("'")
			.append(" and ffarmid='").append(info.getString("farmID")).append("'");
			if(StringUtils.isNotBlank(info.getString("stockingBatchID"))) {
				sql.append(" and fid='").append(info.getString("stockingBatchID")).append("'");
			}
			sql.append(" ");
			rs=DbUtil.executeQuery(ctx,sql.toString());
			try {
				Date[] dateRange = StockingComm.getDateRangeByPeriod(ctx, companyID, periodID);
				Date matureDate;
				StatementsBillBatchDetailInfo batchDetailInfo;
				while(rs.next()) {
					matureDate=rs.getDate("FMatureDate");

					batchDetailInfo=new StatementsBillBatchDetailInfo();
					batchDetailInfo.setString("farmer", rs.getString("ffarmerID"));
					batchDetailInfo.setString("farm",rs.getString("ffarmID"));
					batchDetailInfo.setString("stockingBatch", rs.getString("fid"));
					batchDetailInfo.setBreedDate(rs.getDate("FBreedDate"));
					batchDetailInfo.setMatureDate(matureDate);
					//					info.getBatchDetail().add(batchDetailInfo);

					//产蛋期
					if(matureDate!=null&&(matureDate.equals(dateRange[1])||matureDate.before(dateRange[1]))) {
						//定群日期大于期间开始日期
						if(matureDate.after(dateRange[0])) {
							if(info.getBreedStage().equals(FarmStageEnum.eggs)) {
								batchDetailInfo.setBeginDate(matureDate);
								batchDetailInfo.setEndDate(dateRange[1]);
							}else {
								cal.setTime(matureDate);
								cal.add(Calendar.DAY_OF_MONTH, -1);
								//育成、育雏期
								batchDetailInfo.setBeginDate(dateRange[0]);
								batchDetailInfo.setEndDate(cal.getTime());
							}
						}else{
							//产蛋期
							if(info.getBreedStage().equals(FarmStageEnum.eggs)) {
								batchDetailInfo.setBeginDate(dateRange[0]);
								batchDetailInfo.setEndDate(dateRange[1]);
							}else{
								batchDetailInfo.setBeginDate(null);
								batchDetailInfo.setEndDate(null);
							}
						}
					}else{
						//产蛋期
						if(!info.getBreedStage().equals(FarmStageEnum.eggs)) {
							batchDetailInfo.setBeginDate(dateRange[0]);
							batchDetailInfo.setEndDate(dateRange[1]);
						}else{
							batchDetailInfo.setBeginDate(null);
							batchDetailInfo.setEndDate(null);
						}
					}

					if(batchDetailInfo.getBeginDate()!=null) {
						info.getBatchDetail().add(batchDetailInfo);
					}

				}
			} catch (SQLException e) {
				throw new BOSException(e);
			}
		}

		if(StringUtils.isBlank(info.getNumber())) {
			info.setNumber(AppCommon.getAutoCode(ctx,info,companyID));
		}

		companyID=info.getCompany().getString("id");
		periodID=info.getPeriod().getString("id");

		if(ims==null) {
			ims = MaterialFactory.getLocalInstance(ctx);
		}
		if(imus==null) {
			imus = MeasureUnitFactory.getLocalInstance(ctx);
		}

		//	    String companyID=info.getCompany().getString("id");

		String beginDateStr=null,endDateStr = null;

		//查询过滤条件
		batchID=null;;
		filterSqlStr.setLength(0);
		filterOracleStr.setLength(0);
		batchFilterStr.setLength(0);
		dateFilterStr.setLength(0);

		for(int index=0;index<info.getBatchDetail().size();index++) {
			if(info.getBatchDetail().get(index).getBeginDate()==null||info.getBatchDetail().get(index).getBeginDate()==null) {
				continue;
			}

			beginDateStr=sdf.format(info.getBatchDetail().get(index).getBeginDate());
			endDateStr=sdf.format(info.getBatchDetail().get(index).getEndDate());

			if(filterSqlStr.length()>0) {
				filterSqlStr.append(" or ");
				filterOracleStr.append(" or ");
				//批次结算
				if(info.getSettleType().equals(StockingSettlementTypeEnum.byBatch))
					batchFilterStr.append(" or ");
			}
			if(info.getBatchDetail().get(index).get("stockingBatch") instanceof String) {
				batchID=info.getBatchDetail().get(index).getString("stockingBatch");
			}else {
				batchID=info.getBatchDetail().get(index).getStockingBatch().getString("id");
			}


			filterSqlStr.append(" ( tmain.FBizDate>={d '").append(beginDateStr).append("'}")
			.append(" and tmain.FBizDate<({d '").append(endDateStr).append("'}+1)");

			//批次结算
			if(info.getSettleType().equals(StockingSettlementTypeEnum.byBatch))
				filterSqlStr.append(" and tbatch.fid='").append(batchID).append("'");

			filterSqlStr.append(" )");

			filterOracleStr.append(" ( tmain.FBizDate>=to_date('").append(beginDateStr).append("','yyyy-MM-dd')")
			.append(" and tmain.FBizDate<(to_date('").append(endDateStr).append("','yyyy-MM-dd')+1)");

			//批次结算
			if(info.getSettleType().equals(StockingSettlementTypeEnum.byBatch))
				filterOracleStr.append(" and tbatch.fid='").append(batchID).append("'");
			filterOracleStr.append(" )");

			//批次结算
			if(info.getSettleType().equals(StockingSettlementTypeEnum.byBatch))
				batchFilterStr.append(" tbatch.fid='").append(batchID).append("'");

			dateFilterStr.append(" ( tmain.FBizDate>={d '").append(beginDateStr).append("'}")
			.append(" and tmain.FBizDate<({d '").append(endDateStr).append("'}+1)")
			.append(" )");
		}


		info.getEntrys().clear();
		info.getOtherEntry().clear();
		info.getEggEntry().clear();
		info.getRewardsEntry().clear();

		info.setReceiveQcEggQty(BigDecimal.ZERO);
		info.setCoProductAmount(BigDecimal.ZERO);
		info.setFertilizationRate2(BigDecimal.ZERO);
		info.setBreedDataAmount(BigDecimal.ZERO);
		info.setBreedDataCost(BigDecimal.ZERO);
		info.setAllQty(BigDecimal.ZERO);
		info.setFodderAmount(BigDecimal.ZERO);
		info.setFodderCost(BigDecimal.ZERO);
		info.setDrugAmount(BigDecimal.ZERO);
		info.setDrugCost(BigDecimal.ZERO);
		info.setOtherMaterialAmount(BigDecimal.ZERO);
		info.setOtherMaterialCost(BigDecimal.ZERO);
		info.setSubsidyAmount(BigDecimal.ZERO);
		info.setFeeCostAmount(BigDecimal.ZERO);
		info.setFaFurCardCost(BigDecimal.ZERO);
		info.setArAmountOffset(BigDecimal.ZERO);
		info.setAllEggAmount(BigDecimal.ZERO);
		info.setBirdsAmount(BigDecimal.ZERO);
		info.setAwardsAmount(BigDecimal.ZERO);
		info.setAllEggQty(BigDecimal.ZERO);

		if(filterSqlStr.length()>0) {
			filterSqlStr.insert(0, "and (");
			filterSqlStr.append(" ) ");
			filterOracleStr.insert(0, "and (");
			filterOracleStr.append(" ) ");
			if(info.getSettleType().equals(StockingSettlementTypeEnum.byBatch)){
				batchFilterStr.insert(0, "and (");
				batchFilterStr.append(" ) ");
			}

			//日报信息
			//			setBreedDailyInfo(ctx, info, beginDateStr, endDateStr);

			//受精率
			setEggLayRate(ctx, info, filterSqlStr);

			//保证金
			setMargin(ctx, info, batchFilterStr);
			//苗
			setBreedSeedEntry(ctx, info, filterOracleStr);
			//转苗

			//饲料 --转料目前通过负数领料单完成
			setFodderMateiralData(ctx, info,filterSqlStr);
			//转料单
			//			setTransFodderMaterialEntry(ctx, info, beginDateStr, endDateStr);

			//药
			setDrugMateiralData(ctx, info, filterSqlStr);
			//辅料领用分录
			setOtherMateiralData(ctx, info, filterSqlStr);

			//蛋
			setEggMateiralData(ctx, info,filterSqlStr);
			//禽
			setBirdsMateiralData(ctx, info, filterSqlStr);
			//转禽单
			//			setTransBridsEntry(ctx, info, beginDateStr, endDateStr);

			//收付款业务
			//			setOtherPaymentEntry(ctx, info, beginDate, endDate);
			//特殊业务
			//			setAppealEntry(ctx, info, beginDate, endDate);

			//奖罚
			setRewardsDataEntry(ctx, info, sdf.format(info.getBeginDate()), sdf.format(info.getEndDate()),batchFilterStr);
			//设置补贴
			setSubsidyMateiralData(ctx, info, sdf.format(info.getBeginDate()), sdf.format(info.getEndDate()),batchFilterStr);

			//种蛋接收单数据--副产品冲回，合格蛋数量
			setEggReceiveData(ctx, info, filterSqlStr,beginDateStr,endDateStr,batchID);
			//设置费用分摊数据
			setFeeAllocationData(ctx, info,companyID, periodID, batchFilterStr);
			//设置生物资产折旧信息
			setFACurData(ctx, info, companyID,periodID,batchFilterStr);
			//设置业务数据 设置育成期冲回数据
			setOffSetData(ctx, info,companyID, periodID);
		}

		//养户利润
		BigDecimal farmerProfit=BigDecimal.ZERO;
		//蛋品金额
		farmerProfit=farmerProfit.add(info.getAllEggAmount());
		//活禽金额
		farmerProfit=farmerProfit.add(info.getBirdsAmount());
		//种苗金额
		farmerProfit=farmerProfit.subtract(info.getBreedDataAmount());
		//饲料金额
		farmerProfit=farmerProfit.subtract(info.getFodderAmount());
		//药品金额
		farmerProfit=farmerProfit.subtract(info.getDrugAmount());
		//辅料金额
		farmerProfit=farmerProfit.subtract(info.getOtherMaterialAmount());
		//付款业务
		//		farmerProfit=farmerProfit.add(info.getOtherAmount());
		//奖罚金额
		farmerProfit=farmerProfit.add(info.getAwardsAmount());
		//补贴金额
		farmerProfit=farmerProfit.add(info.getSubsidyAmount());
		//手工项目金额
		farmerProfit=farmerProfit.add(info.getHandAmount()!=null?info.getHandAmount():BigDecimal.ZERO);

		info.setFarmerProfit(farmerProfit);
		info.setOriginalFarmerProfit(farmerProfit);

		//成本计算
		//本期总成本=本期应付合计+本期成本投入(苗、料、药、辅料)+本期分摊费用+生物资产折旧分摊-本期应收-育成期应收冲减-副产品收入-贷款利息差
		BigDecimal allActualCost=BigDecimal.ZERO;
		BigDecimal loanDiff=info.getLoanInterestDiff();//贷款利息差
		if(loanDiff==null) {
			loanDiff=BigDecimal.ZERO;
		}

		allActualCost=info.getAllEggAmount().add(info.getAwardsAmount()).add(info.getBreedDataCost()).add(info.getFodderCost()).add(info.getDrugCost()).add(info.getOtherMaterialCost())
		.add(info.getFeeCostAmount()).subtract(info.getBreedDataAmount()).subtract(info.getFodderAmount()).subtract(info.getDrugAmount()).subtract(info.getOtherMaterialAmount())
		//		.add(info.getBirdsAmount())
		.subtract(info.getArAmountOffset()).subtract(loanDiff)
		.subtract(info.getCoProductAmount());
		//		.add(info.getFaFurCardCost())

		info.setAllActualCost(allActualCost);

		//单位成本
		if(info.getReceiveQcEggQty().signum()>0) {
			info.setUnitActualAmount(allActualCost.divide(info.getReceiveQcEggQty(),2,BigDecimal.ROUND_HALF_UP));
		}

		//		if(!info.getBreedStage().equals(FarmStageEnum.eggs)) {
		//			info.setLoanInterestDiff(BigDecimal.ZERO);
		//		}

		return super.save(ctx, info);
	}





	/**
	 * 贷款利息差
	 * @param ctx
	 * @param info
	 * @return
	 */
	private BigDecimal getLoanInterestDiff(Context ctx, StatementsBillInfo info) {
		// TODO Auto-generated method stub

		StringBuffer diffInterest=new StringBuffer();
		diffInterest.append("select t3.FDiffInterest from T_FM_FarmerInterest t1 \n" )
		.append(" \ninner join T_BD_Period t2 on t2.FID=t1.FPeriodID")
		.append(" \n      and  t2.FID='").append(info.getPeriod().getString("id")).append("'")
		.append(" \ninner join T_FM_FarmerInterestEntry t3 on t1.FID=t3.FParentID")
		.append(" \ninner join T_FM_Farmers t4 on t4.FID=t3.FFarmerID")
		.append(" \n           and t4.FID='").append(info.get("farmer") instanceof String?info.getString("farmer"):info.getFarmer().getString("id")).append("'")
		;
		try {
			rs=DbUtil.executeQuery(ctx, diffInterest.toString());
			if(rs.next())
				return rs.getBigDecimal("FDiffInterest");
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (BOSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 创建应收冲回明细--需要对本期进行结算，综合之前的结算，生成冲回明细
	 * @param ctx
	 */
	private void createArOffSetBill(Context ctx,StatementsBillInfo info,String beginDateStr,String endDateStr) {
		StringBuffer sql=new StringBuffer();
		sql.append(" select ")
		.append("");
	}

	/**
	 * 计算受精率--取照单记录单受精率
	 * @param ctx
	 * @param info
	 * @param beginDate
	 * @param endDate
	 * @throws BOSException
	 */
	private void setEggLayRate(Context ctx,StatementsBillInfo info,StringBuffer filtrSqlStr) throws BOSException{

		//非产蛋期不计算
		if(!info.getBreedStage().equals(FarmStageEnum.eggs)) {
			return;
		}
		try {
			PeriodInfo periodInfo = PeriodFactory.getLocalInstance(ctx).getPeriodInfo(new ObjectUuidPK(info.getPeriod().getString("id")));
			StringBuffer sql=new StringBuffer();
			sql.append(" select round(sum(tentry.CFHealthEggQty)/(sum(tentry.CFEggQty)/100),6) FEggRage")
			.append(" from CT_FM_BECBEE tentry ")
			.append(" inner join CT_FM_BEggCandlingBill tmain on tmain.fid=tentry.fparentid")



			//
			.append(" and tentry.FIsFormal=1")

			//	
			.append(" inner join t_fm_stockingBatch tbatch on tbatch.fid=tentry.CFOutBatchID")
			.append(" inner join T_FM_QcEggTypeEntry              t5  on t5.FQcEggsType=tentry.FQcEggType")
			.append(" inner join T_FM_QcEggType                   t6  on t6.FID=t5.FParentID")
			//			.append(" and (tbatch.FAllOutDate is null or tbatch.FAllOutDate>={ts '").append(sdf.format(periodInfo.getBeginDate())).append(" 00:00:00'})")
			.append(" and (tbatch.FFormalDate is not null and tbatch.FFormalDate<={ts '").append(sdf3.format(periodInfo.getBeginDate())).append("-15 23:59:59'})")

			.append(" where 1=1 ")
			.append(" and tmain.cfbasestatus=4")
			.append(" and tentry.CFFarmerID='").append(info.getString("farmerID")).append("'")
			.append(" and tentry.CFOutFarmID='").append(info.getString("farmID")).append("'")
			.append(" and t6.FName_l2 not in('中蛋2级','其他混合')")
			.append(filtrSqlStr)
			.append(" ");
			rs=DbUtil.executeQuery(ctx, sql.toString());
			if(rs.next()) {
				info.setFertilizationRate2(rs.getBigDecimal("FEggRage"));
			}else{
				info.setFertilizationRate2(BigDecimal.ZERO);
			}
		}catch(Exception err) {
			throw new BOSException(err);
		}
	}

	/**
	 * 收付款业务，系统收付款单
	 * @param ctx
	 * @param info
	 * @param beginDate
	 * @param endDate
	 * @throws BOSException
	 */
	private void setOtherPaymentEntry(Context ctx,StatementsBillInfo info,String beginDate,String endDate) throws BOSException{
		try {
			BigDecimal sumAmount=BigDecimal.ZERO;
			ArrayList<String> billIDList=new ArrayList<String>();
			//收款单
			StringBuffer sql=new StringBuffer();
			sql.append(" select tbill.fid,isnull(tbill.FActRecAmt,0) FAmount,FDescription")
			.append(" from T_CAS_ReceivingBill tbill ")
			.append(" inner join t_fm_stockingBatch tbatch on tbatch.fid=tbill.CFStockingBatchID")
			.append(" where tbill.FCompanyID='").append(info.getCompany().getString("id")).append("'")
			.append(" and (tbill.FBillStatus=").append(BillStatusEnum.PAYED_VALUE)
			.append(" or tbill.FBillStatus=").append(BillStatusEnum.RECED_VALUE)
			.append(" or tbill.FBillStatus=").append(BillStatusEnum.AUDITED_VALUE)
			.append(" or tbill.FBillStatus=").append(BillStatusEnum.APPROVED_VALUE)
			.append(" )")
			.append(" and tbill.FbizDate>={ts '").append(beginDate).append(" 00:00:00'}")
			.append(" and tbill.FbizDate<({ts '").append(endDate).append(" 00:00:00'}+1)")
			.append(" and tbill.CFStockingBatchID='").append(info.getStockingBatch().getString("id")).append("'")
			.append(" ");
			IRowSet rs=DbUtil.executeQuery(ctx, sql.toString());
			while(rs.next()) {
				StatementsBillOtherEntryInfo entryInfo=new StatementsBillOtherEntryInfo();
				entryInfo.setItemName("养殖收款");
				entryInfo.setAmount(rs.getBigDecimal("Famount"));
				entryInfo.setRemark(rs.getString("FDescription"));
				info.getOtherEntry().add(entryInfo);
				sumAmount=sumAmount.add(rs.getBigDecimal("Famount"));
				billIDList.add(rs.getString("fid"));
			}
			//合同上的收款信息
			sql.setLength(0);
			sql.append(" select tbill.fid,isnull(tbill.FActRecAmt,0) FAmount,tbill.FDescription")
			.append(" from T_CAS_ReceivingBill tbill ")
			.append(" inner join t_fm_batchContract tcontract on tcontract.FreceiveBillID=tbill.fid")
			.append(" inner join t_fm_stockingBatch tbatch on tbatch.fid=tbill.CFStockingBatchID")
			.append(" where tbill.FCompanyID='").append(info.getCompany().getString("id")).append("'")
			.append(" and (tbill.FBillStatus=").append(BillStatusEnum.PAYED_VALUE)
			.append(" or tbill.FBillStatus=").append(BillStatusEnum.RECED_VALUE)
			.append(" or tbill.FBillStatus=").append(BillStatusEnum.AUDITED_VALUE)
			.append(" or tbill.FBillStatus=").append(BillStatusEnum.APPROVED_VALUE)
			.append(" )")
			.append(" and tbill.FbizDate>={ts '").append(beginDate).append(" 00:00:00'}")
			.append(" and tbill.FbizDate<({ts '").append(endDate).append(" 00:00:00'}+1)")
			.append(" and tcontract.fid='").append(info.getBatchContract().getString("id")).append("'")
			.append(" ");
			rs=DbUtil.executeQuery(ctx, sql.toString());
			while(rs.next()) {
				if(billIDList.contains(rs.getString("fid"))) {
					continue;
				}
				StatementsBillOtherEntryInfo entryInfo=new StatementsBillOtherEntryInfo();
				entryInfo.setItemName("养殖收款");
				entryInfo.setAmount(rs.getBigDecimal("Famount"));
				entryInfo.setRemark(rs.getString("FDescription"));
				info.getOtherEntry().add(entryInfo);
				sumAmount=sumAmount.add(rs.getBigDecimal("Famount"));
				billIDList.add(rs.getString("fid"));
			}

			//付款单金额
			sql.setLength(0);
			sql.append(" select tbill.fid,isnull(tbill.FActualPayAmount,0) FAmount,FDescription")
			.append(" from T_CAS_PaymentBill tbill ")
			.append(" inner join t_fm_stockingBatch tbatch on tbatch.fid=tbill.CFStockingBatchID")
			.append(" where tbill.FCompanyID='").append(info.getCompany().getString("id")).append("'")
			.append(" and (tbill.FBillStatus=").append(BillStatusEnum.PAYED_VALUE)
			.append(" or tbill.FBillStatus=").append(BillStatusEnum.RECED_VALUE)
			.append(" or tbill.FBillStatus=").append(BillStatusEnum.AUDITED_VALUE)
			.append(" or tbill.FBillStatus=").append(BillStatusEnum.APPROVED_VALUE)
			.append(" )")
			.append(" and tbill.FbizDate>={ts '").append(beginDate).append(" 00:00:00'}")
			.append(" and tbill.FbizDate<({ts '").append(endDate).append(" 00:00:00'}+1)")
			.append(" and tbill.CFStockingBatchID='").append(info.getStockingBatch().getString("id")).append("'")
			.append(" ");
			rs=DbUtil.executeQuery(ctx, sql.toString());
			while(rs.next()) {
				if(billIDList.contains(rs.getString("fid"))) {
					continue;
				}
				StatementsBillOtherEntryInfo entryInfo=new StatementsBillOtherEntryInfo();
				entryInfo.setItemName("养殖付款");
				entryInfo.setAmount(rs.getBigDecimal("Famount"));
				entryInfo.setRemark(rs.getString("FDescription"));
				info.getOtherEntry().add(entryInfo);
				sumAmount=sumAmount.add(rs.getBigDecimal("Famount"));
				billIDList.add(rs.getString("fid"));
			}
			rs.close();
		}catch(Exception err) {
			err.printStackTrace();
		}
	}

	/**
	 * 收付款业务
	 * @param ctx
	 * @param info
	 * @param beginDate
	 * @param endDate
	 * @throws BOSException
	 */
	private void setOtherPaymentEntryOLd(Context ctx,StatementsBillInfo info,String beginDate,String endDate) throws BOSException{
		try {
			BigDecimal sumAmount=BigDecimal.ZERO;
			StringBuffer sql=new StringBuffer();
			sql.append(" select isnull(tentry.FAmount,0) FAmount,FReason")
			.append(" from T_FM_OtherPayment tbill ")
			.append(" inner join T_FM_OtherPaymentEntry tentry on tentry.fparentid=tbill.fid")
			.append(" inner join t_fm_stockingBatch tbatch on tbatch.fid=tbill.FStockingBatchID")
			.append(" where tbill.FCompanyID='").append(info.getCompany().getString("id")).append("'")
			.append(" and tbill.FBillStatus=4")
			.append(" and tbill.FbizDate>={ts '").append(beginDate).append(" 00:00:00'}")
			.append(" and tbill.FbizDate<({ts '").append(endDate).append(" 00:00:00'}+1)")
			.append(" and tbill.FStockingBatchID='").append(info.getStockingBatch().getString("id")).append("'")
			.append(" ")
			.append(" ");
			IRowSet rs=DbUtil.executeQuery(ctx, sql.toString());
			while(rs.next()) {
				StatementsBillOtherEntryInfo entryInfo=new StatementsBillOtherEntryInfo();
				entryInfo.setItemName("养殖付款");
				entryInfo.setAmount(rs.getBigDecimal("Famount"));
				entryInfo.setRemark(rs.getString("FReason"));
				info.getOtherEntry().add(entryInfo);
				sumAmount=sumAmount.add(rs.getBigDecimal("Famount"));
			}
		}catch(Exception err) {
			err.printStackTrace();
		}
	}

	/**
	 * 特殊业务
	 * @param ctx
	 * @param info
	 * @param beginDate
	 * @param endDate
	 * @throws BOSException
	 */
	private void setAppealEntry(Context ctx,StatementsBillInfo info,String beginDate,String endDate) throws BOSException{
		try {
			StringBuffer sql=new StringBuffer();
			sql.append(" select isnull(sum(tentry.FAmount),0) FAmount")
			.append(" from T_FM_AppealBill tbill ")
			.append(" inner join T_FM_AppealBillEntry tentry on tentry.fparentid=tbill.fid")
			.append(" inner join t_fm_stockingBatch tbatch on tbatch.fid=tbill.FStockingBatchID")
			.append(" where tbill.FCompanyID='").append(info.getCompany().getString("id")).append("'")
			.append(" and tbill.FBillStatus=4")
			.append(" and tbill.FbizDate>={ts '").append(beginDate).append(" 00:00:00'}")
			.append(" and tbill.FbizDate<({ts '").append(endDate).append(" 00:00:00'}+1)")
			.append(" and tbill.FStockingBatchID='").append(info.getStockingBatch().getString("id")).append("'")
			.append(" ")
			.append(" ");
			IRowSet rs=DbUtil.executeQuery(ctx, sql.toString());
			if(rs.next()) {
				StatementsBillOtherEntryInfo entryInfo=new StatementsBillOtherEntryInfo();
				entryInfo.setAmount(rs.getBigDecimal("Famount"));
				info.getOtherEntry().add(entryInfo);
			}
		}catch(Exception err) {
			err.printStackTrace();
		}
	}

	/**
	 * 设置保证金金额
	 * @param ctx
	 * @param info
	 * @param beginDate
	 * @param endDate
	 * @throws BOSException
	 */
	private void setMargin(Context ctx,StatementsBillInfo info,StringBuffer filtrBatchStr) throws BOSException{
		try {
			BigDecimal sumAmount=BigDecimal.ZERO;
			StringBuffer sql=new StringBuffer();
			sql.append(" select isnull(tmain.FMarginBillAmount,0) FAmount from T_FM_BatchContract tmain")
			.append(" where tmain.fid in (")
			.append(" select distinct FBatchContractID from t_fm_stockingbatch tbatch")
			.append(" where fcompanyid='").append(info.getCompany().getString("id")).append("'")
			.append(" and ffarmerid='").append(info.getString("farmerID")).append("'")
			.append(" and ffarmid='").append(info.getString("farmID")).append("'")
			.append(filtrBatchStr)
			.append(" )");
			IRowSet rs=DbUtil.executeQuery(ctx, sql.toString());
			while(rs.next()) {
				if(rs.getBigDecimal("Famount")!=null) {
					sumAmount=sumAmount.add(rs.getBigDecimal("Famount"));
				}
			}
			//保证金金额
			info.setMarginAmount(sumAmount);
			info.setMarginInterest(BigDecimal.ZERO);
		}catch(Exception err) {
			throw new BOSException(err);
		}
	}

	/** 设置日报信息
	 * @param info
	 */
	private void setBreedDailyInfo(Context ctx,StatementsBillInfo info,String beginDate,String endDate) throws BOSException{
		try {
			StringBuffer sql=new StringBuffer();
			//期间内总饲料耗用
			sql.append(" select sum(isnull(tentry.CFDailyQtyAll,0)+isnull(FFemaleDailyQty,0)) FQty ")
			.append(" from T_FM_StockingBreedDaily tbill")
			.append(" inner join T_FM_StockingBreedDailyEntry tentry on tentry.FparentID=tbill.fid")
			.append(" where tbill.FCompanyID='").append(info.getCompany().getString("id")).append("'");
			//批次判断
			if(StringUtils.isNotEmpty(info.getString("stockingBatchID"))) {
				sql.append(" and tbill.CFStockingBatchID='").append(info.getString("stockingBatchID")).append("'");
			}
			sql.append(" and tbill.ffarmerID='").append(info.getString("farmerID")).append("'")
			.append(" and tbill.cffarmid='").append(info.getString("farmID")).append("'")
			.append(" and tbill.CFBaseStatus=4")
			.append(" and tbill.FbizDate>={d '").append(beginDate).append("'}")
			.append(" and tbill.FbizDate<({d '").append(endDate).append("'}+1)");
			rs=DbUtil.executeQuery(ctx, sql.toString());
			//总饲喂饲料数
			BigDecimal allEatQty=BigDecimal.ZERO;
			if(rs.next()) {
				allEatQty=rs.getBigDecimal("FQty");
			}
			info.setAllEatQty(allEatQty);

			//全部死淘
			sql.setLength(0);
			sql.append(" select isnull(max(fbatchQty),0) fbatchQty,isnull(max(ffemaleQty),0) ffemaleQty,isnull(sum(FDeadQty),0) FDeadQty,isnull(sum(FCullQty),0) FCullQty,isnull(sum(FFemaleCullQty),0) FFemaleCullQty,isnull(sum(FFemaleDeadQty),0) FFemaleDeadQty,")
			.append(" isnull(sum(FAdjustQty),0) FAdjustQty,isnull(sum(FFemaleAdjustQty),0) FFemaleAdjustQty,isnull(sum(FMarkedQty),0) FMarkedQty,isnull(sum(FFemaleMarkedQty),0) FFemaleMarkedQty,")
			.append(" isnull(sum(FTransQty),0) FTransQty,isnull(sum(FTransFemaleQty),0) FTransFemaleQty")
			.append(" from (");
			sql.append(" select isnull(tb.fbatchQty,0) fbatchQty,isnull(tb.ffemaleQty,0) ffemaleQty,0 FDeadQty,0 FCullQty,0 FFemaleCullQty,0 FFemaleDeadQty,")
			.append(" 0 FAdjustQty,0 FFemaleAdjustQty,0 FMarkedQty,0 FFemaleMarkedQty,")
			.append(" 0 FTransQty,0 FTransFemaleQty")
			.append(" from t_fm_stockingBatch tb ")
			.append(" where tb.FCompanyID='").append(info.getCompany().getString("id")).append("'");
			//批次判断
			if(StringUtils.isNotEmpty(info.getString("stockingBatchID"))) {
				sql.append(" and tb.fid='").append(info.getString("stockingBatchID")).append("'");
			}
			sql.append(" and tb.ffarmerID='").append(info.getString("farmerID")).append("'")
			.append(" and tb.ffarmid='").append(info.getString("farmID")).append("'")
			.append(" union all")
			.append(" select 0 fbatchQty,0 ffemaleQty,")
			.append(" isnull(CFDeathQty,0) FDeadQty,isnull(CFCullQty,0) FCullQty,isnull(FFemaleCullQty,0) FFemaleCullQty,isnull(FFemaleDeathQty,0) FFemaleDeadQty,")
			.append(" isnull(FAdjustQty,0) FAdjustQty,isnull(FAdjustFemaleQty,0) FFemaleAdjustQty,isnull(FMarkedQty,0) FMarkedQty,isnull(FFemaleMarketed,0) FFemaleMarkedQty,")
			.append(" 0 FTransQty,0 FTransFemaleQty")
			.append(" from T_FM_StockingBreedDaily tbill")
			.append(" inner join T_FM_StockingBDAE tentry on tentry.FparentID=tbill.fid")
			.append(" where tbill.FCompanyID='").append(info.getCompany().getString("id")).append("'");
			//			.append(" and tbill.CFStockingBatchID='").append(info.getStockingBatch().getString("id")).append("'")
			//批次判断
			if(StringUtils.isNotEmpty(info.getString("stockingBatchID"))) {
				sql.append(" and tbill.CFStockingBatchID='").append(info.getString("stockingBatchID")).append("'");
			}
			sql.append(" and tbill.ffarmerID='").append(info.getString("farmerID")).append("'")
			.append(" and tbill.cffarmid='").append(info.getString("farmID")).append("'")
			.append(" and tbill.CFBaseStatus=4")
			//			.append(" and tbill.FbizDate>={d '").append(beginDate).append("'}")
			.append(" and tbill.FbizDate<({d '").append(endDate).append("'}+1)");
			//转栏
			sql.append(" union all")
			.append(" select 0 fbatchQty,0 ffemaleQty,")
			.append(" 0 FDeadQty,0 FCullQty,0 FFemaleCullQty,0 FFemaleDeadQty,")
			.append(" 0 FAdjustQty,0 FFemaleAdjustQty,0 FMarkedQty,0 FFemaleMarkedQty,")
			.append(" isnull(FTransQty,0) FTransQty,isnull(FTransFemaleQty,0) FTransFemaleQty")
			.append(" from T_FM_StockingBreedDaily tbill")
			.append(" inner join T_FM_StockingBDTE tentry on tentry.FparentID=tbill.fid")
			.append(" where tbill.FCompanyID='").append(info.getCompany().getString("id")).append("'");
			//批次判断
			if(StringUtils.isNotEmpty(info.getString("stockingBatchID"))) {
				sql.append(" and tbill.CFStockingBatchID='").append(info.getString("stockingBatchID")).append("'");
			}
			sql.append(" and tbill.ffarmerID='").append(info.getString("farmerID")).append("'")
			.append(" and tbill.cffarmid='").append(info.getString("farmID")).append("'")
			.append(" and tbill.CFBaseStatus=4")
			//			.append(" and tbill.FbizDate>={d '").append(beginDate).append("'}")
			.append(" and tbill.FbizDate<({d '").append(endDate).append("'}+1)")
			//转出
			.append(" union all")
			.append(" select 0 fbatchQty,0 ffemaleQty,")
			.append(" 0 FDeadQty,0 FCullQty,0 FFemaleCullQty,0 FFemaleDeadQty,")
			.append(" 0 FAdjustQty,0 FFemaleAdjustQty,0 FMarkedQty,0 FFemaleMarkedQty,")
			.append(" (-1)*isnull(FTransQty,0) FTransQty,(-1)*isnull(FTransFemaleQty,0) FTransFemaleQty")
			.append(" from T_FM_StockingBreedDaily tbill")
			.append(" inner join T_FM_StockingBDTE tentry on tentry.FparentID=tbill.fid")
			.append(" where 1=1 ");
			//批次判断
			if(StringUtils.isNotEmpty(info.getString("stockingBatchID"))) {
				sql.append(" and tentry.FFromStockingBatch='").append(info.getString("stockingBatchID")).append("'");
			}
			sql.append(" and tentry.ffromfarmersID='").append(info.getString("farmerID")).append("'")
			.append(" and tentry.ffromfarmid='").append(info.getString("farmID")).append("'")
			.append(" and tbill.CFBaseStatus=4")
			//			.append(" and tbill.FbizDate>={d '").append(beginDate).append("'}")
			.append(" and tbill.FbizDate<({d '").append(endDate).append("'}+1)");
			sql.append(") ")
			.append(" ")
			;

			rs=DbUtil.executeQuery(ctx, sql.toString());
			BigDecimal deadQty=BigDecimal.ZERO,femaleDeadQty=BigDecimal.ZERO,cullQty=BigDecimal.ZERO,femaleCullQty=BigDecimal.ZERO;
			BigDecimal adjustQty=BigDecimal.ZERO,femaleAdjustQty=BigDecimal.ZERO,markedQty=BigDecimal.ZERO,femaleMarkedQty=BigDecimal.ZERO;
			BigDecimal transQty=BigDecimal.ZERO,transFemaleQty=BigDecimal.ZERO;
			BigDecimal initQty=BigDecimal.ZERO,initFemaleQty=BigDecimal.ZERO;
			if(rs.next()) {
				initQty=rs.getBigDecimal("fbatchQty");
				initFemaleQty=rs.getBigDecimal("FFemaleQty");


				deadQty=rs.getBigDecimal("FDeadQty");
				femaleDeadQty=rs.getBigDecimal("FFemaleDeadQty");
				cullQty=rs.getBigDecimal("FCullQty");
				femaleCullQty=rs.getBigDecimal("FFemaleCullQty");

				adjustQty=rs.getBigDecimal("FAdjustQty");
				femaleAdjustQty=rs.getBigDecimal("FFemaleAdjustQty");
				markedQty=rs.getBigDecimal("FMarkedQty");
				femaleMarkedQty=rs.getBigDecimal("FFemaleMarkedQty");

				transQty=rs.getBigDecimal("FTransQty");
				transFemaleQty=rs.getBigDecimal("FTransFemaleQty");
			}
			//全部死淘
			info.setDeadQty(deadQty);
			info.setFemaleDeadQty(femaleDeadQty);
			info.setCullQty(cullQty);
			info.setFemaleCullQty(femaleCullQty);
			info.setAdjustQty(adjustQty);
			info.setFemaleAdjustQty(femaleAdjustQty);
			info.setMarkedQty(markedQty);
			info.setFemaleMarkedQty(femaleMarkedQty);

			//最后存栏数
			BigDecimal lastStock=BigDecimal.ZERO,lastFemaleStock=BigDecimal.ZERO;

			//如果最后存栏为0，则取批次数量-死淘数量+转栏
			if(lastStock.signum()<=0) {
				lastStock=initQty.subtract(deadQty).subtract(cullQty).add(transQty).add(adjustQty).subtract(markedQty);
			}
			if(lastFemaleStock.signum()<=0) {
				lastFemaleStock=initFemaleQty.subtract(femaleDeadQty).subtract(femaleCullQty).add(transFemaleQty).add(femaleAdjustQty).subtract(femaleMarkedQty);
			}

			//最后存栏数
			info.setLastStock(lastStock);
			info.setLastFemaleStock(lastFemaleStock);

			//			allLastStock=lastStock.add(lastFemaleStock);
			//总存栏
			info.setAllLastStock(lastStock.add(lastFemaleStock));

			//成活率 =存栏*100/期初  算法有问题，假如期初数为0，则成活率大于100%
			//			info.setSurvivalRate(lastStock.add(lastFemaleStock).multiply(new BigDecimal(100)).divide((info.getStockingBatch().getBatchQty().add(info.getStockingBatch().getBatchQty())),4,BigDecimal.ROUND_HALF_UP));


			//只均耗料量=总饲喂料量/总存栏
			if(lastStock.add(lastFemaleStock).signum()>0) {
				info.setAvgFodderQty(allEatQty.divide(lastStock.add(lastFemaleStock),4,BigDecimal.ROUND_HALF_UP));
			}

			//最后一个单子的平均只重
			BigDecimal avgWeight=BigDecimal.ZERO;
			sql.setLength(0);
			sql.append(" select isnull(avg(CFAverageWeight),0) FQty")
			.append(" from T_FM_StockingBreedDaily tbill")
			.append(" inner join T_FM_StockingBreedDailyEntry tentry on tentry.FparentID=tbill.fid")
			.append(" where tbill.FCompanyID='").append(info.getCompany().getString("id")).append("'");
			//			.append(" and tbill.CFStockingBatchID='").append(info.getStockingBatch().getString("id")).append("'")
			if(StringUtils.isNotEmpty(info.getString("stockingBatchID"))) {
				sql.append(" and tbill.CFStockingBatchID='").append(info.getString("stockingBatchID")).append("'");
			}
			sql.append(" and tbill.ffarmerid='").append(info.getString("farmerID")).append("'")
			.append(" and tbill.cffarmid='").append(info.getString("farmID")).append("'")
			.append(" and tbill.CFBaseStatus=4")
			.append(" and tbill.FbizDate>={d '").append(beginDate).append("'}")
			.append(" and tbill.FbizDate<({d '").append(endDate).append("'}+1)")
			.append(" and CFAverageWeight>0")
			//最后一张日报的业务日期
			.append(" and tbill.FBizDate=(")
			.append(" select max(FBizDate) from T_FM_StockingBreedDaily")
			.append(" where FCompanyID='").append(info.getCompany().getString("id")).append("'");
			//			.append(" and CFStockingBatchID='").append(info.getStockingBatch().getString("id")).append("'")
			if(StringUtils.isNotEmpty(info.getString("stockingBatchID"))) {
				sql.append(" and tbill.CFStockingBatchID='").append(info.getString("stockingBatchID")).append("'");
			}
			sql.append(" and tbill.cffarmid='").append(info.getString("farmID")).append("'")
			.append(" and CFBaseStatus=4")
			.append(" and FbizDate>={d '").append(beginDate).append("'}")
			.append(" and FbizDate<({d '").append(endDate).append("'}+1)")
			.append(" )")
			.append(" order by tbill.FBizDate desc");
			rs=DbUtil.executeQuery(ctx, sql.toString());
			if(rs.next()) {
				avgWeight=rs.getBigDecimal("FQty");
			}
			//平均只重
			info.setAvgWeight(avgWeight);


			//批次从开始到现在的总耗料量
			//全部总饲料耗用
			sql.setLength(0);
			sql.append(" select sum(tentry.CFDailyQtyAll) FQty ")
			.append(" from T_FM_StockingBreedDaily tbill")
			.append(" inner join T_FM_StockingBreedDailyEntry tentry on tentry.FparentID=tbill.fid")
			.append(" where tbill.FCompanyID='").append(info.getCompany().getString("id")).append("'");
			//			.append(" and tbill.CFStockingBatchID='").append(info.getStockingBatch().getString("id")).append("'")
			if(StringUtils.isNotEmpty(info.getString("stockingBatchID"))) {
				sql.append(" and tbill.CFStockingBatchID='").append(info.getString("stockingBatchID")).append("'");
			}
			sql.append(" and tbill.cffarmid='").append(info.getString("farmID")).append("'")
			.append(" and tbill.CFBaseStatus=4")
			//			.append(" and tbill.FbizDate>={ts '").append(beginDate).append(" 00:00:00'}")
			.append(" and tbill.FbizDate<({ts '").append(endDate).append(" 00:00:00'}+1)");
			rs=DbUtil.executeQuery(ctx, sql.toString());
			//总饲喂饲料数
			BigDecimal allEatQtyFromBegin=BigDecimal.ZERO;
			if(rs.next()) {
				allEatQtyFromBegin=rs.getBigDecimal("FQty");
			}

			//料肉比=总饲喂量/(平均只重*1000) g转kg
			if(avgWeight.signum()>0) {
				info.setFCR(allEatQtyFromBegin.divide(avgWeight.multiply(new BigDecimal(1000)),4,BigDecimal.ROUND_HALF_UP));
			}

		}catch(Exception err) {
			err.printStackTrace();
		}
	}

	/** 
	 * 设置苗 分录
	 * @param info
	 */
	private void setBreedSeedEntry(Context ctx,StatementsBillInfo info,StringBuffer filterSqlStr) throws BOSException{
		try {
			StringBuffer sql=new StringBuffer();
			sql.append(" /*dialect*/select tm.fid FMaterialID,tm.Fnumber FmaterialNum,tentry.FunitID,sum(nvl(tentry.FReceiveQty,0)) FQty,")
			.append(" decode(sum(nvl(tentry.FReceiveQty,0)),0,0,sum(nvl(tentry.CFAmount,0))/sum(nvl(tentry.FReceiveQty,0))) FPrice,sum(nvl(tentry.CFAmount,0)) FAmount,")
			.append(" sum(nvl(tmre.FActualCost,0)) FActualCost, decode(sum(nvl(tentry.FReceiveQty,0)),0,0,sum(nvl(tmre.FActualCost,0))/sum(nvl(tentry.FReceiveQty,0))) FUnitActualCost")
			.append(" from T_FM_BreedSeedBill tmain")
			.append(" inner join t_fm_stockingBatch tbatch on tbatch.fid=tmain.FStockingBatchID")
			.append(" inner join T_FM_BreedSeedBillEntry tentry on tentry.FparentID=tmain.fid")
			.append(" inner join t_bd_material tm on tm.fid=tentry.FMaterialID")
			//领料出库单
			.append(" left join T_IM_MaterialReqBillEntry tmre on tmre.fsourcebillid=tmain.fid and tmre.fsourcebillentryid=tentry.fid")
			.append(" where tmain.FCompanyID='").append(info.getCompany().getString("id")).append("'")
			.append(" and tmain.ffarmerid='").append(info.getString("farmerID")).append("'")
			.append(" and tmain.ffarmid='").append(info.getString("farmID")).append("'")
			.append(" and tmain.FBillStatus=4")
			.append(filterSqlStr)
			.append(" group by tm.fid,tm.Fnumber,tentry.FunitID")
			.append(" order by tm.fnumber");
			rs=DbUtil.executeQuery(ctx, sql.toString());
			BigDecimal sumAmount=BigDecimal.ZERO,sumQty=BigDecimal.ZERO,sumActualCost=BigDecimal.ZERO;
			if(rs.size()>0) {
				MaterialInfo mInfo;
				while(rs.next()) {
					StatementsBillEntryInfo entryInfo=new StatementsBillEntryInfo();
					entryInfo.setItemName("苗");
					mInfo=ims.getMaterialInfo(new ObjectUuidPK(rs.getString("FMaterialID")));
					entryInfo.setMaterial(mInfo);
					entryInfo.setMaterialName(mInfo.getName());
					entryInfo.setModel(mInfo.getModel());
					entryInfo.setUnit(imus.getMeasureUnitInfo(new ObjectUuidPK(rs.getString("FunitID"))));
					entryInfo.setPrice(rs.getBigDecimal("FPrice"));
					entryInfo.setQty(rs.getBigDecimal("FQty"));
					//应收金额
					entryInfo.setAmount(rs.getBigDecimal("FAmount"));
					//总成本
					entryInfo.setActualCost(rs.getBigDecimal("FActualCost"));
					//单位成本
					entryInfo.setUnitActualCost(rs.getBigDecimal("FUnitActualCost"));

					//总苗数
					sumQty=sumQty.add(rs.getBigDecimal("FQty"));
					sumAmount=sumAmount.add(rs.getBigDecimal("FAmount"));

					sumActualCost=sumActualCost.add(rs.getBigDecimal("FActualCost"));

					info.getEntrys().add(entryInfo);
				}
			}
			//种苗数
			info.setAllQty(sumQty);
			//总苗金额
			info.setBreedDataAmount(sumAmount);
			//苗成本
			info.setBreedDataCost(sumActualCost);

		}catch(Exception err) {
			err.printStackTrace();
		}
	}


	/** 设置转苗 分录
	 * @param info
	 */
	private void setTransBridsEntry(Context ctx,StatementsBillInfo info,String beginDate,String endDate) throws BOSException{
		try {
			StringBuffer sql=new StringBuffer();
			sql.append(" select tsi.fid FSettleItemID,tm.fid FMaterialID,tm.Fnumber FmaterialNum,tentry.CFUnitID,sum((-1)*isnull(tentry.FConfirmQty,0)) FQty,")
			.append(" avg(isnull(tentry.FReceivePrice,0)) FPrice,sum((-1)*isnull(tentry.CFAmount,0)) FAmount")
			.append(" from T_FM_TransBirdsBill tbill")
			.append(" inner join T_FM_TransBirdsBillEntry tentry on tentry.FparentID=tbill.fid")
			.append(" inner join T_FM_StockingBatch tbatch on tbatch.fid=tbill.FStockingBatchID")
			.append(" inner join t_FM_breedData tbd on tbd.fid=tbatch.FBreedDataID")
			.append(" inner join t_bd_material tm on tm.fid=tentry.FMaterialID")
			.append(" left join T_FM_SettlementIME tsie on tsie.fmaterialid=tm.fid")
			.append(" left join T_FM_SettlementItem tsi on ( tsi.fid=tsie.fparentid")
			//当前公司且启用的物料结算项目
			.append(" and tsi.FCompanyID='").append(info.getCompany().getString("id")).append("'")
			.append(" and tsi.FBaseStatus=").append(FarmBaseStatusEnum.ENABLE_VALUE)
			.append(" )")
			.append(" where tbill.FCompanyID='").append(info.getCompany().getString("id")).append("'");
			//			.append(" and tbill.FStockingBatchID='").append(info.getStockingBatch().getString("id")).append("'")
			if(StringUtils.isNotEmpty(info.getString("stockingBatchID"))) {
				sql.append(" and tbill.FStockingBatchID='").append(info.getString("stockingBatchID")).append("'");
			}
			sql.append(" and tbill.ffarmid='").append(info.getString("farmID")).append("'")
			.append(" and tbill.FBillStatus=4")
			.append(" and tbill.FbizDate>={ts '").append(beginDate).append(" 00:00:00'}")
			.append(" and tbill.FbizDate<({ts '").append(endDate).append(" 00:00:00'}+1)")
			.append(" group by tsi.fid,tm.fid,tm.Fnumber,tentry.cFunitID")
			.append(" order by tm.fnumber");
			rs=DbUtil.executeQuery(ctx, sql.toString());
			ISettlementItem isis = SettlementItemFactory.getLocalInstance(ctx);
			IMaterial ims = MaterialFactory.getLocalInstance(ctx);
			IMeasureUnit imus = MeasureUnitFactory.getLocalInstance(ctx);
			BigDecimal sumAmount=BigDecimal.ZERO,sumQty=BigDecimal.ZERO;
			SettlementItemInfo settleItemInfo;
			MaterialInfo mInfo;
			while(rs.next()) {
				StatementsBillEggEntryInfo entryInfo=new StatementsBillEggEntryInfo();
				if(StringUtils.isNotEmpty(rs.getString("FSettleItemID"))) {
					//结算项目
					settleItemInfo = isis.getSettlementItemInfo(new ObjectUuidPK(rs.getString("FSettleItemID")));
					entryInfo.setSettlementItem(settleItemInfo);
					entryInfo.setItemName(settleItemInfo.getName());
				}else {
					entryInfo.setItemName("转活禽");
				}
				entryInfo.setItemName("转活禽");
				mInfo=ims.getMaterialInfo(new ObjectUuidPK(rs.getString("FMaterialID")));
				entryInfo.setMaterial(mInfo);
				entryInfo.setMaterialName(mInfo.getName());
				entryInfo.setModel(mInfo.getModel());
				entryInfo.setUnit(imus.getMeasureUnitInfo(new ObjectUuidPK(rs.getString("CFunitID"))));
				entryInfo.setPrice(rs.getBigDecimal("FPrice"));
				entryInfo.setQty(rs.getBigDecimal("FQty"));
				entryInfo.setAmount(rs.getBigDecimal("FAmount"));
				//				if(rs.getBigDecimal("FPrice").compareTo(BigDecimal.ZERO)==0&&rs.getBigDecimal("FQty").compareTo(rs.getBigDecimal("FAmount"))==0)
				//					continue;
				entryInfo.setRemark("转出活禽");
				//总苗数

				sumQty=sumQty.add(rs.getBigDecimal("FQty"));
				sumAmount=sumAmount.add(rs.getBigDecimal("FAmount"));

				info.getEggEntry().add(entryInfo);
			}
			sql.setLength(0);
			sql.append(" select tsi.fid FSettleItemID,tm.fid FMaterialID,tm.Fnumber FmaterialNum,tentry.CFUnitID,sum(isnull(tentry.FConfirmQty,0)) FQty,")
			.append(" avg(isnull(tentry.FOrderReceivePrice,0)) FPrice,sum(isnull(tentry.CFOrderAmount,0)) FAmount")
			.append(" from T_FM_TransBirdsBill tbill")
			.append(" inner join T_FM_TransBirdsBillEntry tentry on tentry.FparentID=tbill.fid")
			.append(" inner join T_FM_StockingBatch tbatch on tbatch.fid=tbill.FStockingBatchID")
			.append(" inner join t_FM_breedData tbd on tbd.fid=tbatch.FBreedDataID")
			.append(" inner join t_bd_material tm on tm.fid=tentry.FMaterialID")
			.append(" left join T_FM_SettlementIME tsie on tsie.fmaterialid=tm.fid")
			.append(" left join T_FM_SettlementItem tsi on ( tsi.fid=tsie.fparentid")
			//当前公司且启用的物料结算项目
			.append(" and tsi.FCompanyID='").append(info.getCompany().getString("id")).append("'")
			.append(" and tsi.FBaseStatus=").append(FarmBaseStatusEnum.ENABLE_VALUE)
			.append(" )")
			.append(" where tbill.FCompanyID='").append(info.getCompany().getString("id")).append("'");
			//			.append(" and tentry.FOrderStockingBatc='").append(info.getStockingBatch().getString("id")).append("'")
			if(StringUtils.isNotEmpty(info.getString("stockingBatchID"))) {
				sql.append(" and tentry.FOrderStockingBatc='").append(info.getString("stockingBatchID")).append("'");
			}
			sql.append(" and tbill.ffarmid='").append(info.getString("farmID")).append("'")
			.append(" and tbill.FBillStatus=4")
			.append(" and tbill.FbizDate>={ts '").append(beginDate).append(" 00:00:00'}")
			.append(" and tbill.FbizDate<({ts '").append(endDate).append(" 00:00:00'}+1)")
			.append(" group by tsi.fid,tm.fid,tm.Fnumber,tentry.cFunitID")
			.append(" order by tm.fnumber");
			rs=DbUtil.executeQuery(ctx, sql.toString());
			while(rs.next()) {
				StatementsBillEggEntryInfo entryInfo=new StatementsBillEggEntryInfo();
				if(StringUtils.isNotEmpty(rs.getString("FSettleItemID"))) {
					//结算项目
					settleItemInfo = isis.getSettlementItemInfo(new ObjectUuidPK(rs.getString("FSettleItemID")));
					entryInfo.setSettlementItem(settleItemInfo);
					entryInfo.setItemName(settleItemInfo.getName());
				}else {
					entryInfo.setItemName("转活禽");
				}
				entryInfo.setItemName("转活禽");
				mInfo=ims.getMaterialInfo(new ObjectUuidPK(rs.getString("FMaterialID")));
				entryInfo.setMaterial(mInfo);
				entryInfo.setMaterialName(mInfo.getName());
				entryInfo.setModel(mInfo.getModel());
				entryInfo.setUnit(imus.getMeasureUnitInfo(new ObjectUuidPK(rs.getString("CFunitID"))));
				entryInfo.setPrice(rs.getBigDecimal("FPrice"));
				entryInfo.setQty(rs.getBigDecimal("FQty"));
				entryInfo.setAmount(rs.getBigDecimal("FAmount"));
				entryInfo.setRemark("转入活禽");
				//总苗数
				sumQty=sumQty.add(rs.getBigDecimal("FQty"));
				sumAmount=sumAmount.add(rs.getBigDecimal("FAmount"));

				info.getEggEntry().add(entryInfo);
			}
			//转入苗
		}catch(Exception err) {
			err.printStackTrace();
		}
	}


	/** 设置饲料 分录
	 * 
	 * 设置养殖场类别空的为放养养殖场 3 update t_fm_farm set FFarmType=3 where FFarmType is null
	 * @param info
	 */
	private void setFodderMateiralData(Context ctx,StatementsBillInfo info,StringBuffer filterSqlStr) throws BOSException{
		try {

			StringBuffer sql=new StringBuffer();
			//领料出库单
			//只有合同没有批次-----初次领用（根据合同判断）
			sql.append(" /*dialect*/select * from (").append("\n");
			sql.append(" select tm.fid FMaterialID,tm.Fnumber FmaterialNum,tentry.FunitID,sum(nvl(tentry.FConfirmQty,0)) FQty,").append("\n")
			.append(" decode(sum(nvl(tentry.FConfirmQty,0)),0,0,round(sum(nvl(tentry.CFAmount,0))/sum(nvl(tentry.FConfirmQty,0)),6)) FPrice,sum(nvl(tentry.CFAmount,0)) FAmount,").append("\n")
			.append(" decode(sum(tmre.fbaseQty),0,0,nvl(round(sum(nvl(tmre.FActualCost,0))*sum(nvl(tentry.FReceiveQty,0))/sum(tmre.fbaseQty),2),0)) FActualCost, decode(sum(tmre.fbaseQty),0,0,round(sum(nvl(tmre.FActualCost,0))/sum(tmre.fbaseQty),6)) FUnitActualCost").append("\n")
			.append(" from T_FM_FodderReceiveBill tmain").append("\n")
			.append(" inner join T_FM_FodderReceiveBillEntry tentry on tentry.FparentID=tmain.fid").append("\n")
			.append(" inner join t_fm_farm tf on tf.fid=tentry.ffarmid and tf.FFarmType in(").append(StockingFarmTypeEnum.STOCKING_VALUE).append(",").append(StockingFarmTypeEnum.INVESTOR_VALUE).append(")\n")
			.append(" inner join t_fm_BatchContract tcontract on tcontract.fid=tentry.FbatchcontractID").append("\n")
			.append(" inner join t_fm_stockingBatch tbatch on tbatch.FID=tentry.FStockingBatchID").append("\n")
			.append(" inner join t_bd_material tm on tm.fid=tentry.FMaterialID").append("\n")
			//领料出库单
			.append(" left join T_IM_MaterialReqBillEntry tmre on tmre.fsourcebillid=tmain.fid and tmre.fsourcebillentryid=tentry.fid").append("\n")
			.append(" where tmain.FCompanyID='").append(info.getCompany().getString("id")).append("'").append("\n")
			.append(" and tentry.ffarmid='").append(info.getString("farmID")).append("'").append("\n")
			.append(" and tmain.FBillStatus=4").append("\n")
			.append(filterSqlStr).append("\n")
			.append(" group by tm.fid,tm.Fnumber,tentry.FunitID").append("\n");
			//
			//			.append(" union all").append("\n")
			//			.append(" select tm.fid FMaterialID,tm.Fnumber FmaterialNum,tentry.FunitID,sum(nvl(tentry.FConfirmQty,0)) FQty,").append("\n")
			//			.append(" round(sum(nvl(tentry.CFAmount,0))/sum(nvl(tentry.FConfirmQty,0)),6) FPrice,sum(nvl(tentry.CFAmount,0)) FAmount,").append("\n")
			//			.append(" nvl(round(sum(nvl(tmre.FActualCost,0))*sum(nvl(tentry.FReceiveQty,0))/sum(tmre.fbaseQty),2),0) FActualCost, round(sum(nvl(tmre.FActualCost,0))/sum(tmre.fbaseQty),6) FUnitActualCost").append("\n")
			//			.append(" from T_FM_FodderReceiveBill tmain").append("\n")
			//			.append(" inner join T_FM_FodderReceiveBillEntry tentry on tentry.FparentID=tmain.fid").append("\n")
			//			.append(" inner join t_fm_farm tf on tf.fid=tentry.ffarmid and tf.FFarmType!=").append(StockingFarmTypeEnum.STOCKING_VALUE).append("\n")
			//			.append(" inner join t_fm_BatchContract tcontract on tcontract.fid=tentry.FbatchcontractID").append("\n")
			//			.append(" inner join t_fm_stockingBatch tbatch on tbatch.FBatchContractID=tcontract.fid").append("\n")
			//			.append(" inner join t_bd_material tm on tm.fid=tentry.FMaterialID").append("\n")
			//			//领料出库单
			//			.append(" left join T_IM_StockTransferBillEntry ttmain on ttmain.FSourceBillEntryID=tentry.fid").append("\n")
			//			//调拨入库单
			//			.append(" left join T_IM_MoveInWarehsBillEntry tmre on  tmre.fsourcebillentryid=tentry.fid").append("\n")
			//
			//			.append(" where tmain.FCompanyID='").append(info.getCompany().getString("id")).append("'").append("\n")
			//			.append(" and tentry.ffarmid='").append(info.getString("farmID")).append("'").append("\n")
			//			//			.append(" and tbatch.ffarmerid='").append(info.getString("farmerID")).append("'")
			//			//			.append(" and tbatch.ffarmid='").append(info.getString("farmID")).append("'")
			//			.append(" and tmain.FBillStatus=4").append("\n")
			//			.append(filterSqlStr).append("\n")
			//			.append(" group by tm.fid,tm.Fnumber,tentry.FunitID").append("\n");//tsi.fid,

			sql.append(" ) ttemp order by FmaterialNum").append("\n");

			rs=DbUtil.executeQuery(ctx, sql.toString());
			BigDecimal sumAmount=BigDecimal.ZERO,sumActualCost=BigDecimal.ZERO;
			if(rs.size()>0) {
				MaterialInfo mInfo;
				//合同价格List
				priceList.clear();
				BigDecimal amount;
				StatementsBillEntryInfo entryInfo;
				while(rs.next()) {
					entryInfo=new StatementsBillEntryInfo();
					entryInfo.setItemName("料");
					mInfo=ims.getMaterialInfo(new ObjectUuidPK(rs.getString("FMaterialID")));
					entryInfo.setMaterial(mInfo);
					entryInfo.setMaterialName(mInfo.getName());
					entryInfo.setModel(mInfo.getModel());
					entryInfo.setUnit(imus.getMeasureUnitInfo(new ObjectUuidPK(rs.getString("FunitID"))));

					//获取基础价格
					if(priceList.size()>0){
						entryInfo.setPrice(priceList.get(0).getBasePrice());
						amount=priceList.get(0).getBasePrice().multiply(rs.getBigDecimal("FQty")).setScale(2,BigDecimal.ROUND_HALF_UP);
					}else{
						entryInfo.setPrice(rs.getBigDecimal("FPrice"));
						amount=rs.getBigDecimal("FAmount");
					}

					entryInfo.setQty(rs.getBigDecimal("FQty"));
					entryInfo.setAmount(amount);

					entryInfo.setActualCost(rs.getBigDecimal("FActualCost"));
					entryInfo.setUnitActualCost(rs.getBigDecimal("FUnitActualCost"));

					sumAmount=sumAmount.add(rs.getBigDecimal("FAmount"));
					sumActualCost=sumActualCost.add(rs.getBigDecimal("FActualCost"));

					info.getEntrys().add(entryInfo);
				}
			}

			//饲料金额
			info.setFodderAmount(sumAmount);
			//饲料成本
			info.setFodderCost(sumActualCost);
		}catch(Exception err) {
			err.printStackTrace();
		}
	}



	/** 设置转料 分录
	 * @param info
	 */
	private void setTransFodderMaterialEntry(Context ctx,StatementsBillInfo info,String beginDate,String endDate) throws BOSException{
		try {
			StringBuffer sql=new StringBuffer();
			//转出  tsi.fid FSettleItemID,
			sql.append(" select tm.fid FMaterialID,tm.Fnumber FmaterialNum,tentry.cFunitID,(-1)*sum(isnull(tentry.FConfirmQty,0)) FQty,")
			.append(" sum(isnull(tentry.CFAmount,0))/sum(isnull(tentry.FConfirmQty,0)) FPrice,(-1)*sum(isnull(tentry.CFAmount,0)) FAmount,")
			.append(" (-1)*sum(isnull(tmre.FActualCost,0)) FActualCost, sum(isnull(tmre.FActualCost,0))/sum(isnull(tentry.FConfirmQty,0)) FUnitActualCost,")
			.append(" 1 ftranstype")
			.append(" from T_FM_TransFodderBill tbill")
			.append(" inner join t_fm_farm on tf on tf.fid=tbill.ffarmid and tf.FFarmType=").append(StockingFarmTypeEnum.STOCKING_VALUE)
			.append(" inner join T_FM_TransFodderBillEntry tentry on tentry.FparentID=tbill.fid")
			.append(" inner join T_FM_StockingBatch tbatch on tbatch.fid=tbill.FStockingBatchID")
			.append(" inner join t_FM_breedData tbd on tbd.fid=tbatch.FBreedDataID")
			.append(" inner join t_bd_material tm on tm.fid=tentry.FMaterialID")
			//			.append(" left join T_FM_SettlementIME tsie on tsie.fmaterialid=tm.fid")
			//			.append(" left join T_FM_SettlementItem tsi on ( tsi.fid=tsie.fparentid")
			//当前公司且启用的物料结算项目
			//			.append(" and tsi.FCompanyID='").append(info.getCompany().getString("id")).append("'")
			//			.append(" and tsi.FBaseStatus=").append(FarmBaseStatusEnum.ENABLE_VALUE)
			//			.append(" )")
			//领料出库单
			.append(" left join T_IM_MaterialReqBillEntry tmre on (tmre.fsourcebillid=tbill.fid and tmre.fsourcebillentryid=tentry.fid and 1=1)")
			.append(" where tbill.FCompanyID='").append(info.getCompany().getString("id")).append("'");
			//			.append(" and tbill.FStockingBatchID='").append(info.getStockingBatch().getString("id")).append("'")
			if(StringUtils.isNotEmpty(info.getString("stockingBatchID"))) {
				sql.append(" and  tbill.FStockingBatchID='").append(info.getString("stockingBatchID")).append("'");
			}
			sql.append(" and tbill.ffarmerid='").append(info.getString("farmerID")).append("'")
			.append(" and tbill.ffarmid='").append(info.getString("farmID")).append("'")
			.append(" and tbill.FBillStatus=4")
			.append(" and tbill.FbizDate>={d '").append(beginDate).append("'}")
			.append(" and tbill.FbizDate<({d '").append(endDate).append("'}+1)")
			.append(" group by tm.fid,tm.Fnumber,tentry.cFunitID")//tsi.fid,
			//转入
			.append(" union all")//tsi.fid FSettleItemID,
			.append(" select tm.fid FMaterialID,tm.Fnumber FmaterialNum,tentry.cFunitID,sum(isnull(tentry.FConfirmQty,0)) FQty,")
			.append(" sum(isnull(tentry.CFAmount,0))/sum(isnull(tentry.FConfirmQty,0)) FPrice,sum(isnull(tentry.CFOrderAmount,0)) FAmount,")
			.append(" sum(isnull(tmre.FActualCost,0)) FActualCost, sum(isnull(tmre.FActualCost,0))/sum(isnull(tentry.FConfirmQty,0)) FUnitActualCost,")
			.append(" 2 ftranstype")
			.append(" from T_FM_TransFodderBill tbill")
			.append(" inner join T_FM_TransFodderBillEntry tentry on tentry.FparentID=tbill.fid")
			.append(" inner join t_fm_farm on tf on tf.fid=tentry.ffarmid and tf.FFarmType=").append(StockingFarmTypeEnum.STOCKING_VALUE)
			.append(" inner join T_FM_StockingBatch tbatch on tbatch.fid=tbill.FStockingBatchID")
			.append(" inner join t_FM_breedData tbd on tbd.fid=tbatch.FBreedDataID")
			.append(" inner join t_bd_material tm on tm.fid=tentry.FMaterialID")
			//领料出库单
			.append(" left join T_IM_MaterialReqBillEntry tmre on (tmre.fsourcebillid=tbill.fid and tmre.fsourcebillentryid=tentry.fid and 2=2)")
			//			.append(" left join T_FM_SettlementIME tsie on tsie.fmaterialid=tm.fid")
			//			.append(" left join T_FM_SettlementItem tsi on ( tsi.fid=tsie.fparentid")
			//当前公司且启用的物料结算项目
			//			.append(" and tsi.FCompanyID='").append(info.getCompany().getString("id")).append("'")
			//			.append(" and tsi.FBaseStatus=").append(FarmBaseStatusEnum.ENABLE_VALUE)
			//			.append(" )")
			.append(" where tbill.FCompanyID='").append(info.getCompany().getString("id")).append("'");
			//			.append(" and tentry.FOrderStockingBatc='").append(info.getStockingBatch().getString("id")).append("'")
			if(StringUtils.isNotEmpty(info.getString("stockingBatchID"))) {
				sql.append(" and tentry.FOrderStockingBatc='").append(info.getString("stockingBatchID")).append("'");
			}
			sql.append(" and tentry.FOrderFarmerID='").append(info.getString("farmerID")).append("'")
			.append(" and tentry.FOrderFarmID='").append(info.getString("farmID")).append("'")
			.append(" and tbill.FBillStatus=4")
			.append(" and tbill.FbizDate>={d '").append(beginDate).append("'}")
			.append(" and tbill.FbizDate<({d '").append(endDate).append("'}+1)")
			.append(" group by tm.fid,tm.Fnumber,tentry.cFunitID");//tsi.fid,
			rs=DbUtil.executeQuery(ctx, sql.toString());
			BigDecimal sumAmount=BigDecimal.ZERO,sumQty=BigDecimal.ZERO,sumActualCost=BigDecimal.ZERO;
			if(rs.size()>0) {
				//			ISettlementItem isis = SettlementItemFactory.getLocalInstance(ctx);
				//				IMaterial ims = MaterialFactory.getLocalInstance(ctx);
				//				IMeasureUnit imus = MeasureUnitFactory.getLocalInstance(ctx);
				//			SettlementItemInfo settleItemInfo;
				priceList.clear();
				MaterialInfo mInfo;
				//合同价格List
				//				ArrayList<BasePriceBean> priceList=new ArrayList<BasePriceBean>() ;
				BigDecimal amount;
				while(rs.next()) {
					StatementsBillEntryInfo entryInfo=new StatementsBillEntryInfo();
					//				if(StringUtils.isNotEmpty(rs.getString("FSettleItemID"))) {
					//					//结算项目
					//					settleItemInfo = isis.getSettlementItemInfo(new ObjectUuidPK(rs.getString("FSettleItemID")));
					//					entryInfo.setSettlementItem(settleItemInfo);
					//					entryInfo.setItemName(settleItemInfo.getName());
					//				}else {
					entryInfo.setItemName("料");
					//				}
					mInfo=ims.getMaterialInfo(new ObjectUuidPK(rs.getString("FMaterialID")));
					entryInfo.setMaterial(mInfo);
					entryInfo.setMaterialName(mInfo.getName());
					entryInfo.setModel(mInfo.getModel());
					entryInfo.setUnit(imus.getMeasureUnitInfo(new ObjectUuidPK(rs.getString("CFunitID"))));
					//				entryInfo.setPrice(rs.getBigDecimal("FPrice"));
					//获取基础价格
					//				priceList= StockingComm.getBasePrice(null,StockingComm.PRRICE_OUT_TYPE,info.getBatchContract().getString("id"),rs.getString("FMaterialID"),rs.getString("FunitID"));
					if(priceList.size()>0){
						entryInfo.setPrice(priceList.get(0).getBasePrice());
						amount=priceList.get(0).getBasePrice().multiply(rs.getBigDecimal("FQty")).setScale(2,BigDecimal.ROUND_HALF_UP);
					}else{
						entryInfo.setPrice(rs.getBigDecimal("FPrice"));
						amount=rs.getBigDecimal("FAmount");
					}

					entryInfo.setQty(rs.getBigDecimal("FQty"));
					entryInfo.setAmount(amount);
					entryInfo.setRemark(rs.getInt("ftranstype")==1?"转出料":"转入料");

					entryInfo.setActualCost(rs.getBigDecimal("FActualCost"));

					entryInfo.setUnitActualCost(rs.getBigDecimal("FUnitActualCost"));

					//总
					sumQty=sumQty.add(rs.getBigDecimal("FQty"));
					sumAmount=sumAmount.add(rs.getBigDecimal("FAmount"));

					sumActualCost=sumActualCost.add(rs.getBigDecimal("factualcost"));

					info.getEntrys().add(entryInfo);
				}
			}
			info.setFodderAmount(info.getFodderAmount().add(sumAmount));

			info.setFodderCost(info.getFodderCost().add(sumActualCost));

		}catch(Exception err) {
			err.printStackTrace();
		}
	}

	/** 设置药品分录
	 * @param ctx
	 * @param info
	 */
	private void setDrugMateiralData(Context ctx,StatementsBillInfo info,StringBuffer filterSqlStr) throws BOSException{
		try {

			StringBuffer sql=new StringBuffer();
			//tsi.fid FSettleItemID,
			sql.append(" /*dialect*/select * from (").append("\n");
			sql.append(" select tm.fid FMaterialID,tm.Fnumber FmaterialNum,tentry.FUnitID,sum(nvl(tentry.FConfirmQty,0)) FQty,").append("\n")
			.append(" decode(sum(nvl(tentry.FConfirmQty,0)),0,0,sum(nvl(tentry.CFAmount,0))/sum(nvl(tentry.FConfirmQty,0))) FPrice,sum(nvl(tentry.CFAmount,0)) FAmount,").append("\n")
			.append(" decode(sum(tmre.fbaseQty),0,0,nvl(round(sum(nvl(tmre.FActualCost,0))*sum(nvl(tentry.FConfirmQty,0))/sum(tmre.fbaseQty),2),0)) FActualCost, decode(sum(tmre.fbaseQty),0,0,round(sum(nvl(tmre.FActualCost,0))/sum(tmre.fbaseQty),6)) FUnitActualCost").append("\n")
			.append(" from T_FM_DrugReceptionBill tmain").append("\n")
			.append(" inner join t_fm_farm tf on tf.fid=tmain.ffarmid and tf.FFarmType=").append(StockingFarmTypeEnum.STOCKING_VALUE).append("\n")
			.append(" inner join t_fm_batchcontract tcontract on tcontract.fid=tmain.FBatchContractID").append("\n");
			if(info.getSettleType().equals(StockingSettlementTypeEnum.byBatch)) {
				sql.append(" inner join t_fm_stockingBatch tbatch on tbatch.FID=tmain.FStockingBatchID").append("\n");
			}else {
				sql.append(" left join t_fm_stockingBatch tbatch on tbatch.FID=tmain.FStockingBatchID").append("\n");
			}
			//			.append(" inner join t_fm_stockingBatch tbatch on tbatch.FBatchContractID=tcontract.fid").append("\n")
			sql.append(" inner join T_FM_DrugReceptionBillEntry tentry on tentry.FparentID=tmain.fid").append("\n")
			.append(" inner join t_bd_material tm on tm.fid=tentry.FMaterialID").append("\n")
			.append(" left join T_IM_MaterialReqBillEntry tmre on (tmre.fsourcebillid=tmain.fid and tmre.fsourcebillentryid=tentry.fid)").append("\n")
			.append(" where tmain.FCompanyID='").append(info.getCompany().getString("id")).append("'").append("\n")
			.append(" and tf.fid='").append(info.getString("farmID")).append("'").append("\n")
			//			.append(" and ffarmerid='").append(info.getString("farmerID")).append("'")
			//			.append(" and ffarmid='").append(info.getString("farmID")).append("'")
			.append(" and tmain.FBillStatus=4").append("\n")
			.append(filterSqlStr).append("\n")
			.append(" group by tm.fid,tm.Fnumber,tentry.FunitID").append("\n")//

			.append(" union all").append("\n")
			.append(" select tm.fid FMaterialID,tm.Fnumber FmaterialNum,tentry.FUnitID,sum(nvl(tentry.FConfirmQty,0)) FQty,").append("\n")
			.append(" decode(sum(nvl(tentry.FConfirmQty,0)),0,0,decode(sum(nvl(tentry.FConfirmQty,0)),0,0,sum(nvl(tentry.CFAmount,0))/sum(nvl(tentry.FConfirmQty,0)))) FPrice,sum(nvl(tentry.CFAmount,0)) FAmount,").append("\n")
			.append(" decode(sum(tmre.fbaseQty),0,0,nvl(round(sum(nvl(tmre.FActualCost,0))*sum(nvl(tentry.FConfirmQty,0))/sum(tmre.fbaseQty),2),0)) FActualCost, decode(sum(tmre.fbaseQty),0,0,round(sum(nvl(tmre.FActualCost,0))/sum(tmre.fbaseQty),6)) FUnitActualCost").append("\n")
			.append(" from T_FM_DrugReceptionBill tmain").append("\n")
			.append(" inner join t_fm_farm tf on tf.fid=tmain.ffarmid and tf.FFarmType!=").append(StockingFarmTypeEnum.STOCKING_VALUE).append("\n")
			.append(" inner join t_fm_batchcontract tcontract on tcontract.fid=tmain.FBatchContractID").append("\n");
			if(info.getSettleType().equals(StockingSettlementTypeEnum.byBatch)) {
				sql.append(" inner join t_fm_stockingBatch tbatch on tbatch.FID=tmain.FStockingBatchID").append("\n");
			}else {
				sql.append(" left join t_fm_stockingBatch tbatch on tbatch.FID=tmain.FStockingBatchID").append("\n");
			}

				//			.append(" inner join t_fm_stockingBatch tbatch on tbatch.FBatchContractID=tcontract.fid").append("\n")
				sql.append(" inner join T_FM_DrugReceptionBillEntry tentry on tentry.FparentID=tmain.fid").append("\n")
				.append(" inner join t_bd_material tm on tm.fid=tentry.FMaterialID").append("\n")
				//领料出库单
				.append(" left join T_IM_StockTransferBillEntry ttmain on ttmain.FSourceBillEntryID=tentry.fid").append("\n")
				//调拨入库单
				.append(" left join T_IM_MoveInWarehsBillEntry tmre on  tmre.fsourcebillentryid=ttmain.fid").append("\n")

				.append(" where tmain.FCompanyID='").append(info.getCompany().getString("id")).append("'").append("\n")
				.append(" and tf.fid='").append(info.getString("farmID")).append("'").append("\n")
				//			sql.append(" and ffarmerid='").append(info.getString("farmerID")).append("'")
				//			.append(" and ffarmid='").append(info.getString("farmID")).append("'")
				.append(filterSqlStr).append("\n")
				.append(" and tmain.FBillStatus=4").append("\n")
				.append(filterSqlStr).append("\n")
				.append(" group by tm.fid,tm.Fnumber,tentry.FunitID").append("\n")//tsi.fid,
				.append(" ) ttemp").append("\n")
				.append(" order by FMaterialNum").append("\n");
			rs=DbUtil.executeQuery(ctx, sql.toString());
			BigDecimal sumAmount=BigDecimal.ZERO,sumCost=BigDecimal.ZERO;
			if(rs.size()>0) {
				//			ISettlementItem isis = SettlementItemFactory.getLocalInstance(ctx);
				//			SettlementItemInfo settleItemInfo;
				MaterialInfo mInfo;
				while(rs.next()) {
					StatementsBillEntryInfo entryInfo=new StatementsBillEntryInfo();
					//				if(StringUtils.isNotEmpty(rs.getString("FSettleItemID"))) {
					//					//结算项目
					//					settleItemInfo = isis.getSettlementItemInfo(new ObjectUuidPK(rs.getString("FSettleItemID")));
					//					entryInfo.setSettlementItem(settleItemInfo);
					//					entryInfo.setItemName(settleItemInfo.getName());
					//				}else {
					entryInfo.setItemName("药");
					//				}
					mInfo=ims.getMaterialInfo(new ObjectUuidPK(rs.getString("FMaterialID")));
					entryInfo.setMaterial(mInfo);
					entryInfo.setMaterialName(mInfo.getName());
					entryInfo.setModel(mInfo.getModel());
					entryInfo.setUnit(imus.getMeasureUnitInfo(new ObjectUuidPK(rs.getString("FunitID"))));
					entryInfo.setPrice(rs.getBigDecimal("FPrice"));
					entryInfo.setQty(rs.getBigDecimal("FQty"));
					entryInfo.setAmount(rs.getBigDecimal("FAmount"));

					entryInfo.setActualCost(rs.getBigDecimal("FActualCost"));
					entryInfo.setUnitActualCost(rs.getBigDecimal("FUnitActualCost"));

					sumAmount=sumAmount.add(rs.getBigDecimal("FAmount"));
					sumCost=sumCost.add(rs.getBigDecimal("factualCost"));

					info.getEntrys().add(entryInfo);
				}
			}


			//药品金额
			info.setDrugAmount(sumAmount);
			info.setDrugCost(sumCost);
			//
		}catch(Exception err) {
			err.printStackTrace();
		}
	}

	/** 设置辅料领用分录
	 * @param ctx
	 * @param info
	 */
	private void setOtherMateiralData(Context ctx,StatementsBillInfo info,StringBuffer filterSqlStr) throws BOSException{
		try {


			StringBuffer sql=new StringBuffer();
			sql.append(" /*dialect*/select * from (");
			sql.append(" select tm.fid FMaterialID,tm.Fnumber FmaterialNum,tentry.FUnitID,sum(nvl(tentry.FConfirmQty,0)) FQty,")
			.append(" decode(sum(nvl(tentry.FConfirmQty,0)),0,0,sum(nvl(tentry.CFAmount,0))/sum(nvl(tentry.FConfirmQty,0))) FPrice,sum(nvl(tentry.CFAmount,0)) FAmount,")
			.append(" decode(sum(tmre.fbaseQty),0,0,nvl(round(sum(nvl(tmre.FActualCost,0))*sum(nvl(tentry.FConfirmQty,0))/sum(tmre.fbaseQty),2),0)) FActualCost, decode(sum(tmre.fbaseQty),0,0,round(sum(nvl(tmre.FActualCost,0))/sum(tmre.fbaseQty),6)) FUnitActualCost")
			.append(" from T_FM_OtherReceptionBill tmain")
			.append(" inner join t_fm_farm tf on tf.fid=tmain.ffarmid and tf.FFarmType=").append(StockingFarmTypeEnum.STOCKING_VALUE)
			.append(" inner join t_fm_batchcontract tcontract on tcontract.fid=tmain.FBatchContractID")
			.append(" inner join t_fm_stockingBatch tbatch on tbatch.FBatchContractID=tcontract.fid")
			.append(" inner join T_FM_OtherReceptionBillEntry tentry on tentry.FparentID=tmain.fid")
			.append(" inner join t_bd_material tm on tm.fid=tentry.FMaterialID")
			.append(" left join T_IM_MaterialReqBillEntry tmre on (tmre.fsourcebillid=tmain.fid and tmre.fsourcebillentryid=tentry.fid )")
			.append(" where tmain.FCompanyID='").append(info.getCompany().getString("id")).append("'")
			.append(" and tmain.FBillStatus=4")
			.append(filterSqlStr)
			.append(" group by tm.fid,tm.Fnumber,tentry.FunitID")

			.append(" union all")
			.append(" select tm.fid FMaterialID,tm.Fnumber FmaterialNum,tentry.FUnitID,sum(nvl(tentry.FConfirmQty,0)) FQty,")
			.append(" decode(sum(nvl(tentry.FConfirmQty,0)),0,0,sum(nvl(tentry.CFAmount,0))/sum(nvl(tentry.FConfirmQty,0))) FPrice,sum(nvl(tentry.CFAmount,0)) FAmount,")
			.append(" decode(sum(tmre.fbaseQty),0,0,nvl(round(sum(nvl(tmre.FActualCost,0))*sum(nvl(tentry.FConfirmQty,0))/sum(tmre.fbaseQty),2),0)) FActualCost, decode(sum(tmre.fbaseQty),0,0,round(sum(nvl(tmre.FActualCost,0))/sum(tmre.fbaseQty),6)) FUnitActualCost")
			.append(" from T_FM_OtherReceptionBill tmain")
			.append(" inner join t_fm_farm tf on tf.fid=tmain.ffarmid and tf.FFarmType!=").append(StockingFarmTypeEnum.STOCKING_VALUE)
			.append(" inner join t_fm_batchcontract tcontract on tcontract.fid=tmain.FBatchContractID")
			.append(" inner join t_fm_stockingBatch tbatch on tbatch.FBatchContractID=tcontract.fid")
			.append(" inner join T_FM_OtherReceptionBillEntry tentry on tentry.FparentID=tmain.fid")
			.append(" inner join t_bd_material tm on tm.fid=tentry.FMaterialID")
			//领料出库单
			.append(" left join T_IM_StockTransferBillEntry ttmain on ttmain.FSourceBillEntryID=tentry.fid")
			//调拨入库单
			.append(" left join T_IM_MoveInWarehsBillEntry tmre on  tmre.fsourcebillentryid=tentry.fid")

			.append(" where tmain.FCompanyID='").append(info.getCompany().getString("id")).append("'")
			.append(" and tmain.FBillStatus=4")
			.append(filterSqlStr)
			.append(" group by tm.fid,tm.Fnumber,tentry.FunitID")

			.append(" ) ttemp")
			.append(" order by FMaterialNum");
			rs=DbUtil.executeQuery(ctx, sql.toString());
			BigDecimal sumAmount=BigDecimal.ZERO,sumCost=BigDecimal.ZERO;
			if(rs.size()>0) {
				MaterialInfo mInfo;
				while(rs.next()) {
					StatementsBillEntryInfo entryInfo=new StatementsBillEntryInfo();
					entryInfo.setItemName("辅料");
					mInfo=ims.getMaterialInfo(new ObjectUuidPK(rs.getString("FMaterialID")));
					entryInfo.setMaterial(mInfo);
					entryInfo.setMaterialName(mInfo.getName());
					entryInfo.setModel(mInfo.getModel());
					entryInfo.setUnit(imus.getMeasureUnitInfo(new ObjectUuidPK(rs.getString("FunitID"))));
					entryInfo.setPrice(rs.getBigDecimal("FPrice"));
					entryInfo.setQty(rs.getBigDecimal("FQty"));
					entryInfo.setAmount(rs.getBigDecimal("FAmount"));

					entryInfo.setActualCost(rs.getBigDecimal("FActualCost"));
					entryInfo.setUnitActualCost(rs.getBigDecimal("FUnitActualCost"));

					sumAmount=sumAmount.add(rs.getBigDecimal("FAmount"));
					sumCost=sumCost.add(rs.getBigDecimal("FActualCost"));

					info.getEntrys().add(entryInfo);
				}
			}
			//辅料金额
			info.setOtherMaterialAmount(sumAmount);
			info.setOtherMaterialCost(sumCost);

		}catch(Exception err) {
			err.printStackTrace();
		}
	}

	/** 设置蛋品回收分录--种蛋结算单
	 * @param ctx
	 * @param info
	 */
	private void setEggMateiralData(Context ctx,StatementsBillInfo info,StringBuffer filterSqlStr) throws EASBizException {
		try {
			StringBuffer sql=new StringBuffer();
			sql.append(" select tsi.fid FSettleItemID,tentry.FunitID,sum(isnull(tentry.FQty,0)) FQty,sum(isnull(tentry.famount,0)) famount")
			.append(" ,to_char(tmain.FBizDate,'yyyy-MM-dd') FBizDate,sum(isnull(tentry.FNum,0)) FNum")//总枚数
			.append(" from T_FM_EggSettleBill tmain")
			.append(" inner join T_FM_EggSettleBillEntry tentry on tentry.FparentID=tmain.fid")
			.append(" inner join t_fm_stockingBatch tbatch on tbatch.fid=tentry.FStockingBatchID")
			.append(" inner join T_FM_SettlementItem tsi on tsi.fid=tentry.fsettleitemid")
			.append(" where tmain.FCompanyID='").append(info.getCompany().getString("id")).append("'")
			.append(" and tmain.FEggSource=").append(EggSourceType.SUBCONTRACT_VALUE)//放养
			.append(" and tentry.ffarmerid='").append(info.getString("farmerID")).append("'")
			.append(" and tentry.ffarmid='").append(info.getString("farmID")).append("'")
			.append(" and tmain.FBillStatus=4")
			.append(filterSqlStr)
			.append(" group by tsi.fid,tentry.FunitID,tmain.FBizDate")
			.append(" ");
			rs=DbUtil.executeQuery(ctx, sql.toString());
			BigDecimal sumErtilityRate=BigDecimal.ZERO;//受精率
			BigDecimal sumQcQty=BigDecimal.ZERO,sumQcAmount=BigDecimal.ZERO,sumAllAmount=BigDecimal.ZERO;
			int sumAllNum=0;
			if(rs.size()>0) {
				MeasureUnitInfo uInfo;
				BigDecimal price,amount,qty;

				ISettlementItem isis = SettlementItemFactory.getLocalInstance(ctx);
				SettlementItemInfo settleItemInfo;
				IMeasureUnit imus = MeasureUnitFactory.getLocalInstance(ctx);
				while(rs.next()) {
					qty=rs.getBigDecimal("fqty");
					amount=rs.getBigDecimal("famount");
					sumAllNum+=rs.getInt("fNum");
					sumAllAmount=amount.add(sumAllAmount);

					//蛋品回收分录
					StatementsBillEggEntryInfo entryInfo=new StatementsBillEggEntryInfo();

					//结算项目
					settleItemInfo = isis.getSettlementItemInfo(new ObjectUuidPK(rs.getString("FSettleItemID")));
					entryInfo.setSettlementItem(settleItemInfo);
					entryInfo.setItemName(settleItemInfo.getName());
					//合格蛋
					if(settleItemInfo.getSettleItemType().equals(SettleItemType.qcEgg)) {
						sumQcQty=sumQcQty.add(qty);
						sumQcAmount=sumQcAmount.add(amount);
					}

					uInfo=imus.getMeasureUnitInfo(new ObjectUuidPK(rs.getString("funitid")));
					entryInfo.setUnit(uInfo);
					entryInfo.setNumber(rs.getBigDecimal("fNum"));
					entryInfo.setQty(qty);
					entryInfo.setAmount(amount);
					if(qty.signum()>0) {
						price=amount.divide(qty,4,BigDecimal.ROUND_HALF_UP);
					}else{
						price=BigDecimal.ZERO;
					}
					entryInfo.setPrice(price);

					info.getEggEntry().add(entryInfo);
				}
			}

			//回收合格蛋品数量
			info.setEggQty(sumQcQty);
			//合格蛋品金额
			info.setEggAmount(sumQcAmount);
			//合格蛋平均单价
			info.setAvgEggPrice(sumQcQty.signum()>0?sumQcAmount.divide(sumQcQty,4,BigDecimal.ROUND_HALF_UP):BigDecimal.ZERO);

			//蛋品回收总金额
			info.setAllEggAmount(sumAllAmount);
			//蛋品回收总个数
			info.setAllEggQty(new BigDecimal(sumAllNum));

			//受精率 合格单的受精率
			if(sumQcQty.signum()>0) {
				//				info.setFertilizationRate(sumErtilityRate.divide(sumQcQty,2,BigDecimal.ROUND_HALF_UP));
			}

			/*//蛋品回收平均单价
			if(sumQty.signum()>0) {
				info.setEggPrice(sumAmount.divide(sumQty,4, BigDecimal.ROUND_HALF_UP));
			}else{
				info.setEggPrice(BigDecimal.ZERO);
			}*/

			//产蛋率=总蛋数/天数/母鸡存栏
			long diff = info.getEndDate().getTime()-info.getBeginDate().getTime();
			diff=diff/1000/60/60/24+1;
			if(info.getLastFemaleStock()!=null&&info.getLastFemaleStock().signum()>0) {
				info.setLayingRate(info.getAllEggQty().multiply(new BigDecimal(100)).divide(info.getLastFemaleStock().multiply(new BigDecimal(diff)),2,BigDecimal.ROUND_HALF_UP));
			}else{
				info.setLayingRate(BigDecimal.ZERO);
			}

		}catch(Exception err) {
			throw new EASBizException(new NumericExceptionSubItem("001",err.getMessage()));
		}
	}

	/** 设置禽类回收分录--从日报取
	 * @param ctx
	 * @param info
	 */
	private void setBirdsMateiralData(Context ctx,StatementsBillInfo info,StringBuffer filterSqlStr) throws EASBizException {
		try {
			//全部死淘
			StringBuffer sql=new StringBuffer();
			sql.append(" select isnull(sum(tentry.FCullTotalAmt),0) FAmount")
			.append(" from T_FM_StockingBreedDaily tmain")
			.append(" inner join T_FM_StockingBDAE tentry on tentry.fparentid=tmain.fid")
			.append(" inner join  t_fm_stockingBatch tbatch on tbatch.fid=tmain.CFStockingBatchID ")
			.append(" where tmain.FCompanyID='").append(info.getCompany().getString("id")).append("'")
			.append(" and tmain.CFBaseStatus=4")
			.append(" and tbatch.ffarmerID='").append(info.getString("farmerID")).append("'")
			.append(" and tbatch.ffarmid='").append(info.getString("farmID")).append("'")
			.append(filterSqlStr)
			;
			rs=DbUtil.executeQuery(ctx, sql.toString());
			while(rs.next()) {
				info.setBirdsAmount(rs.getBigDecimal("FAmount"));
			}

		}catch(Exception err) {
			throw new EASBizException(new NumericExceptionSubItem("001",err.getMessage()));
		}
	}
	/** 设置禽类回收分录
	 * @param ctx
	 * @param info
	 */
	private void setBirdsMateiralDataOld(Context ctx,StatementsBillInfo info,String beginDate,String endDate) throws BOSException{
		try {
			StringBuffer sql=new StringBuffer();
			sql.append(" select tsi.fid FSettleItemID,tm.fid FMaterialID,tm.Fnumber FmaterialNum,tentry.FunitID,sum(isnull(tentry.FQty,0)) FQty,")
			.append(" avg(isnull(tentry.FReceivePrice,0)) FPrice,sum(FWeight) FWeight,sum(isnull(tentry.CFAmount,0)) FAmount")
			.append(" from T_FM_BirdsRecycleBill tbill")
			.append(" inner join T_FM_BirdsRecycleBillEntry tentry on tentry.FparentID=tbill.fid")
			.append(" inner join t_bd_material tm on tm.fid=tentry.FMaterialID")
			.append(" left join T_FM_SettlementIME tsie on tsie.fmaterialid=tm.fid")
			.append(" left join T_FM_SettlementItem tsi on ( tsi.fid=tsie.fparentid")
			//当前公司且启用的物料结算项目
			.append(" and tsi.FCompanyID='").append(info.getCompany().getString("id")).append("'")
			.append(" and tsi.FBaseStatus=").append(FarmBaseStatusEnum.ENABLE_VALUE)
			.append(" )")
			.append(" where tbill.FCompanyID='").append(info.getCompany().getString("id")).append("'");
			//			.append(" and tbill.FStockingBatchID='").append(info.getStockingBatch().getString("id")).append("'")
			if(StringUtils.isNotEmpty(info.getString("stockingBatchID"))) {
				sql.append(" and  tbill.FStockingBatchID='").append(info.getString("stockingBatchID")).append("'");
			}
			sql.append(" and tbill.ffarmid='").append(info.getString("farmID")).append("'")
			.append(" and tbill.FBillStatus=4")
			.append(" and tbill.FbizDate>={ts '").append(beginDate).append(" 00:00:00'}")
			.append(" and tbill.FbizDate<({ts '").append(endDate).append(" 00:00:00'}+1)")
			.append(" ")
			.append(" group by tsi.fid,tm.fid,tm.Fnumber,tentry.FunitID")
			.append(" order by tm.fnumber");
			rs=DbUtil.executeQuery(ctx, sql.toString());
			ISettlementItem isis = SettlementItemFactory.getLocalInstance(ctx);
			IMaterial ims = MaterialFactory.getLocalInstance(ctx);
			IMeasureUnit imus = MeasureUnitFactory.getLocalInstance(ctx);
			BigDecimal sumAmount=BigDecimal.ZERO,sumQty=BigDecimal.ZERO,sumWeight=BigDecimal.ZERO;

			SettlementItemInfo settleItemInfo;
			MaterialInfo mInfo;
			while(rs.next()) {
				StatementsBillEggEntryInfo entryInfo=new StatementsBillEggEntryInfo();
				if(StringUtils.isNotEmpty(rs.getString("FSettleItemID"))) {
					//结算项目
					settleItemInfo = isis.getSettlementItemInfo(new ObjectUuidPK(rs.getString("FSettleItemID")));
					entryInfo.setSettlementItem(settleItemInfo);
					entryInfo.setItemName(settleItemInfo.getName());
				}else {
					entryInfo.setItemName("活禽");
				}
				mInfo=ims.getMaterialInfo(new ObjectUuidPK(rs.getString("FMaterialID")));
				entryInfo.setMaterial(mInfo);
				entryInfo.setMaterialName(mInfo.getName());
				entryInfo.setModel(mInfo.getModel());
				entryInfo.setUnit(imus.getMeasureUnitInfo(new ObjectUuidPK(rs.getString("FunitID"))));
				entryInfo.setPrice(rs.getBigDecimal("FPrice"));
				entryInfo.setQty(rs.getBigDecimal("FQty"));
				entryInfo.setWeight(rs.getBigDecimal("FWeight"));
				entryInfo.setAmount(rs.getBigDecimal("FAmount"));

				sumAmount=sumAmount.add(rs.getBigDecimal("FAmount"));
				sumQty=sumQty.add(rs.getBigDecimal("FQty"));
				sumWeight=sumWeight.add(rs.getBigDecimal("FWeight"));

				info.getEggEntry().add(entryInfo);
			}
			//活禽金额
			info.setBirdsAmount(sumAmount);
			//活禽数量
			info.setBirdsQty(sumQty);
			//活禽重量
			info.setBirdsWeight(sumWeight);
			//活禽单价 重量结算
			if(sumQty.signum()>0) {
				info.setBirdsPrice(sumAmount.divide(sumWeight, 2,BigDecimal.ROUND_HALF_UP));
			}else{
				info.setBirdsPrice(BigDecimal.ZERO);
			}
		}catch(Exception err) {

		}
	}
	/** 设置奖罚分录
	 * @param ctx
	 * @param info
	 */
	private void setRewardsDataEntry(Context ctx,StatementsBillInfo info,String beginDate,String endDate,StringBuffer filterBatchStr) throws BOSException{
		try {

			if(info.getFertilizationRate2()==null||info.getFertilizationRate2().compareTo(BigDecimal.ZERO)==0){
				info.setAwardsAmount(BigDecimal.ZERO);
				return;
			}
			//取批次合同
			//			StockingBatchInfo stockingBatchInfo = StockingBatchFactory.getLocalInstance(ctx).getStockingBatchInfo(new ObjectUuidPK(info.getString("stockingBatchID")));

			//获取所有奖惩类型
			StringBuffer sql=new StringBuffer();
			sql.append(" select trp.fid,trp.fname_l2 FName,trp.FBizType,trp.FCalType,trp.FBaseQty,trp.FFormulaTxt")
			.append(" from T_FM_BatchContract tct")
			.append(" inner join T_FM_StatementsPolicy tsp on tsp.fid=tct.FSettlementPolicyI")
			.append(" inner join T_FM_StatementsPAE tspa on tspa.fparentid=tsp.fid")
			.append(" inner join T_FM_RewardsPolicy trp on trp.fid=tspa.FPolicyID")
			.append(" inner join t_fm_stockingBatch tbatch on tbatch.fbatchcontractid=tct.fid")


			.append(" where tct.fid='").append(info.getString("contractID")).append("'")
			.append(" and trp.FBeginDate<={ts '").append(beginDate).append(" 00:00:00'}")
			.append(" and ( trp.FEndDate>=({ts '").append(endDate).append(" 00:00:00'})")
			.append(" or trp.FEndDate is null")
			.append(" )")
			.append(filterBatchStr);
			rsA = DbUtil.executeQuery(ctx, sql.toString());
			BigDecimal baseQty,amount,sumAmount=BigDecimal.ZERO;
			String jsTxt;
			CoreBaseCollection cols=new CoreBaseCollection();
			cols.add(info);
			SettleStandardInfo sInfo = getSettleStandartInfo(ctx, info.getCompany().getString("id"), beginDate, endDate);
			if(sInfo!=null) {
				cols.add(sInfo);
			}
			while(rsA.next()) {
				baseQty=rsA.getBigDecimal("FBaseQty");
				amount=BigDecimal.ZERO;
				if(rsA.getInt("FCalType")==AwardsCalType.CUSTOM_VALUE) {
					//计算脚本
					jsTxt=rsA.getString("FFormulaTxt");
					jsTxt=StockingComm.getCalDealedFormulaTxt(jsTxt);
					amount=StockingComm.getCalResultByJsTxt(ctx, cols, jsTxt);
					sumAmount=sumAmount.add(amount);
				}
				StatementsBillRewardsEntryInfo entryInfo=new StatementsBillRewardsEntryInfo();
				entryInfo.setItemID(rsA.getString("fid"));
				entryInfo.setItemName(rsA.getString("fname"));
				entryInfo.setAmount(amount);
				info.getRewardsEntry().add(entryInfo);
			}
			info.setAwardsAmount(sumAmount);
		}catch(Exception err) {
			err.printStackTrace();
		}
	}
	/**
	 * 获取结算标准
	 * @param ctx
	 * @param companyID
	 * @param beginDate
	 * @param endDate
	 * @return
	 */
	private SettleStandardInfo getSettleStandartInfo(Context ctx,String companyID,String beginDate,String endDate) {
		try{
			StringBuffer sql=new StringBuffer();
			sql.append(" select fid")
			.append(" from T_FM_SettleStandard tct")
			.append(" where FCompanyID='").append(companyID).append("'")
			.append(" and FBeginDate<={ts '").append(beginDate).append(" 00:00:00'}")
			.append(" and (FEndDate>({ts '").append(endDate).append(" 00:00:00'}+1)")
			.append(" or FEndDate is null")
			.append(" )")
			.append(" and FBaseStatus=").append(FarmBaseStatusEnum.ENABLE_VALUE);
			IRowSet rs = DbUtil.executeQuery(ctx, sql.toString());
			if(rs.next()) {
				return SettleStandardFactory.getLocalInstance(ctx).getSettleStandardInfo(new ObjectUuidPK(rs.getString("fid")));
			}
		}catch(Exception err) {
			err.printStackTrace();
		}
		return null;
	}


	/** 设置补贴分录
	 * @param ctx
	 * @param info
	 */
	private void setSubsidyMateiralData(Context ctx,StatementsBillInfo info,String beginDate,String endDate,StringBuffer batchFilterStr) throws BOSException{
		try {


		}catch(Exception err) {

		}
	}

	/**
	 * 检查结算计算方式
	 */
	private void checkSettleType(Context ctx,String companyID,String periodID,StockingSettlementTypeEnum settleType) {

	}

	/**
	 * 统一结算
	 */
	@Override
	protected Object _exeAllCal(Context ctx, Object params)	throws BOSException,EASBizException {
		try {
			JSONObject jo=JSONObject.fromObject(params);
			String companyID=jo.getString("companyID");
			String periodID=jo.getString("periodID");
			StockingSettlementTypeEnum settleType=StockingSettlementTypeEnum.getEnum(jo.getInt("settleType"));//结算方式
			SettleBreedStageEnum settleBreedStage=SettleBreedStageEnum.getEnum(jo.getInt("settleBreedStage"));//结算阶段

			Date[] dateRange = StockingComm.getDateRangeByPeriod(ctx, companyID, periodID);
			if(dateRange==null) {
				throw new Exception("当前期间尚未设置结账期间！");
			}
			/*DayRateBaseSettingCollection bsCol = DayRateBaseSettingFactory.getLocalInstance(ctx).getDayRateBaseSettingCollection("where company.id='"+companyID+"'");
			if(bsCol==null||bsCol.size()<=0) {
				throw new EASBizException(new NumericExceptionSubItem("001","请设置好养殖成本系统参数！"));
			}

			SelectorItemCollection slor=new SelectorItemCollection();
			slor.add("*");
			slor.add("curPeriod.*");
			DayRateBaseSettingInfo bsInfo = DayRateBaseSettingFactory.getLocalInstance(ctx).getDayRateBaseSettingInfo(new ObjectUuidPK(bsCol.get(0).getId()),slor);
			if(!bsInfo.isIsInit()) {
				throw new EASBizException(new NumericExceptionSubItem("001","请先初始化养殖成本系统！"));
			}*/

			String typeStr="";
			if(settleBreedStage.equals(SettleBreedStageEnum.egg)) {
				typeStr=" and FBreedStage="+FarmStageEnum.EGGS_VALUE;
			}

			StringBuffer sql=new StringBuffer();
			//删除本期的结算单
			sql.append(" /*dialect*/ begin");
			sql.append(" delete from T_FM_StatementsBRE where fparentid in (")
			.append(" select fid from T_FM_StatementsBill where fcompanyID='").append(companyID).append("' and fperiodid='").append(periodID).append("'")
			.append(typeStr)
			.append(" );")
			//回收分录
			.append(" delete from T_FM_StatementsBillEggEntry where fparentid in (")
			.append(" select fid from T_FM_StatementsBill where fcompanyID='").append(companyID).append("' and fperiodid='").append(periodID).append("'")
			.append(typeStr)
			.append(" );")
			//投入分录
			.append(" delete from T_FM_StatementsBillEntry where fparentid in (")
			.append(" select fid from T_FM_StatementsBill where fcompanyID='").append(companyID).append("' and fperiodid='").append(periodID).append("'")
			.append(typeStr)
			.append(" );")
			//手工分录
			.append(" delete from T_FM_StatementsBillHandEntry where fparentid in (")
			.append(" select fid from T_FM_StatementsBill where fcompanyID='").append(companyID).append("' and fperiodid='").append(periodID).append("'")
			.append(typeStr)
			.append(" );")
			//其他分录
			.append(" delete from T_FM_StatementsBillOtherEntry where fparentid in (")
			.append(" select fid from T_FM_StatementsBill where fcompanyID='").append(companyID).append("' and fperiodid='").append(periodID).append("'")
			.append(" );")
			//育成期冲回数据
			//删除育成期成本冲回应收数据--固定资产
			.append(" delete from ").append(faOffSetDetailTable).append(" where FSettleBillID in (")
			.append(" select fid from T_FM_StatementsBill where fcompanyID='").append(companyID).append("' and fperiodid='").append(periodID).append("'")
			.append(typeStr)
			.append(" );")
			//主表
			.append(" delete from T_FM_StatementsBill where fcompanyID='").append(companyID).append("' and fperiodid='").append(periodID).append("'")
			.append(typeStr)
			.append(" ;");
			sql.append(" end;");
			DbUtil.execute(ctx, sql.toString());

			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");

			String selectCols="";
			//根据类型设置不同的查询条件
			//			if(settleType.equals(StockingSettlementTypeEnum.byBatch)) {
			selectCols="tbatch.fid fbatchID,tbatch.ffarmerid,tbatch.ffarmid,tbatch.FBreedDate,tbatch.FMatureDate";
			//			}else if(settleType.equals(StockingSettlementTypeEnum.byFarm)) {//养殖场结算
			//				selectCols="'' fbatchid,tbatch.ffarmerid,tbatch.ffarmid,tbatch.FBreedDate,tbatch.FMatureDate";
			//			}
			//批次结算 遍历需要结算的批次
			sql.setLength(0);
			sql.append(" select distinct ").append(selectCols).append(" ")
			.append(" from t_fm_stockingbatch tbatch")
			.append(" inner join t_fm_farm tfm on tfm.fid=tbatch.ffarmid")
			.append(" where tbatch.fcompanyID='").append(companyID).append("'")
			//			.append(" and (tfm.FFarmType=").append(StockingFarmTypeEnum.STOCKING_VALUE)//放养
			//			.append(" or tfm.FFarmType=").append(StockingFarmTypeEnum.INVESTOR_VALUE).append(")")//股东自养
			//.append(" and tbatch.fbaseStatus=").append(FarmBaseStatusEnum.ENABLE_VALUE)
			.append(" and exists (")
			//当前期间存在日报
			.append(" select 1 from T_FM_StockingBreedDaily td where td.fcompanyID='").append(companyID).append("'")
			.append(" and td.cfbasestatus=4")
			.append(" and td.fbizDate>={d '").append(sdf.format(dateRange[0])).append("'}")
			.append(" and td.fbizDate<({d '").append(sdf.format(dateRange[1])).append("'}+1)").append("\n")
			.append(" and td.CFStockingBatchID=tbatch.fid").append("\n")

			//种蛋结算单
			.append("union all").append("\n")
			.append("select 1 from T_FM_EggSettleBill   t1").append("\n")
			.append("inner join T_FM_EggSettleBillEntry t2 on t1.FID=t2.FParentID").append("\n")
			.append("      where t1.FCompanyID='").append(companyID).append("'").append("\n")
			.append("      and t2.FFarmID=tfm.FID").append("\n")
			.append("      and t2.FStockingBatchID=tbatch.fid").append("\n")
			.append("      and t1.FBillStatus=4").append("\n")
			.append("      and t1.fbizDate>={d '").append(sdf.format(dateRange[0])).append("'}")
			.append("      and t1.fbizDate<({d '").append(sdf.format(dateRange[1])).append("'}+1)").append("\n")
			//种蛋接收单
			.append("union all").append("\n")
			.append("select 1 from T_FM_EggReceiveBill   t1").append("\n")
			.append("inner join T_FM_EggReceiveBillEntry t2 on t1.FID=t2.FParentID").append("\n")
			.append("      where t1.FCompanyID='").append(companyID).append("'").append("\n")
			.append("      and t2.FFarmID=tfm.FID").append("\n")
			.append("      and t2.FStockingBatchID=tbatch.fid").append("\n")
			.append("      and t1.FBillStatus=4").append("\n")
			.append("      and t1.fbizDate>={d '").append(sdf.format(dateRange[0])).append("'}")
			.append("      and t1.fbizDate<({d '").append(sdf.format(dateRange[1])).append("'}+1)")

			.append(" )")
			.append(" order by tbatch.ffarmid,tbatch.fid");
			//			sql.append(" and tbatch.ffarmerid='75QAAAAd1sQYMRT/'");//测试种鸭7场生成多张的问题
			IRowSet rs=DbUtil.executeQuery(ctx, sql.toString());

			if(rs.size()<=0) {
				return null;
			}

			//设置日期为期间最后一天
			Date bizDate=dateRange[1];

			setCoProductPriceInfo(ctx, companyID, sdf.format(bizDate));

			//已执行batchid
			ArrayList<String> hasExeID=new ArrayList<String>();
			//结算单集合
			CoreBaseCollection settleBillCol=new CoreBaseCollection();
			CoreBaseCollection settleBillCol2=new CoreBaseCollection();

			CompanyOrgUnitInfo companyInfo = CompanyOrgUnitFactory.getLocalInstance(ctx).getCompanyOrgUnitInfo(new ObjectUuidPK(companyID));

			PeriodInfo periodInfo = PeriodFactory.getLocalInstance(ctx).getPeriodInfo(new ObjectUuidPK(periodID));
			String contractID;
			StatementsBillInfo info=null,info2=null;
			String exeID=null;//执行id
			Date matureDate;
			StatementsBillBatchDetailInfo batchDetailInfo,batchDetailInfo2;
			int z=0;
			String farmID;
			FarmInfo farmInfo;

			IFarm iFarm = FarmFactory.getLocalInstance(ctx);
			while(rs.next()) {
				System.out.println(z++);
				//批次结算
				farmInfo=null;
				farmID = rs.getString("FfarmID");
				if(StringUtils.isNotEmpty(farmID)){
					farmInfo = iFarm.getFarmInfo(new ObjectUuidPK(farmID));
				}
				if(settleType.equals(StockingSettlementTypeEnum.byBatch)) {
					exeID=rs.getString("fbatchid");
				}else{
					if(farmInfo!=null&&farmInfo.getFarmType().getValue()==2)
						exeID=rs.getString("fbatchid");
					else
						exeID=rs.getString("FfarmID");
				}

				//执行结算
				if((hasExeID.size()>0&&!hasExeID.contains(exeID))) {
					if(info!=null&&info.getBatchDetail().size()>0&&settleBreedStage.equals(SettleBreedStageEnum.breed)) {
						settleBillCol.add(info);
					}
					if(info2!=null&&info2.getBatchDetail().size()>0&&settleBreedStage.equals(SettleBreedStageEnum.egg)) {
						settleBillCol2.add(info2);
					}
					info2=null;
					info=null;
				}

				batchDetailInfo2=null;
				batchDetailInfo=null;

				//获取批次合同
				contractID=StockingComm.getContractIDByBatchID(ctx, rs.getString("fbatchid"));
				if(StringUtils.isEmpty(contractID)) {
					//					continue;
				}

				//不包含该执行id
				if(!hasExeID.contains(exeID)) {
					//创建结算单
					info=new StatementsBillInfo();
					info.setId(BOSUuid.create(info.getBOSType()));
					info.setBoolean("batchExe", true);//批量执行
					info.setCompany(companyInfo);
					info.setBizDate(bizDate);
					//					info.setNumber(AppCommon.getAutoCode(ctx,info,companyID));
					info.setPeriod(periodInfo);
					info.setBeginDate(dateRange[0]);
					info.setEndDate(dateRange[1]);
					info.setSettleType(settleType);
					info.setBreedStage(FarmStageEnum.breed);

					info.setString("farmer", rs.getString("ffarmerID"));
					info.setString("farm", rs.getString("ffarmID"));
					info.setString("stockingBatch", rs.getString("fbatchid"));

					info.setString("farmerID", rs.getString("ffarmerID"));
					info.setString("farmID", rs.getString("ffarmID"));
					info.setString("stockingBatchID", rs.getString("fbatchid"));

					info.setString("batchContract",contractID);
					info.setString("contractID",contractID);
					info.setLoanInterestDiff(getLoanInterestDiff(ctx, info));

					//					hasExeID.add(exeID);
				}
				matureDate=rs.getDate("FMatureDate");

				//插入明细
				batchDetailInfo=new StatementsBillBatchDetailInfo();
				batchDetailInfo.setString("farmer", rs.getString("ffarmerid"));
				batchDetailInfo.setString("farm",rs.getString("ffarmid") );
				batchDetailInfo.setString("stockingBatch", rs.getString("fbatchid"));
				batchDetailInfo.setBreedDate(rs.getDate("FBreedDate"));
				batchDetailInfo.setMatureDate(rs.getDate("FMatureDate"));

				//产蛋期
				if(matureDate!=null&&(matureDate.equals(dateRange[1])||matureDate.before(dateRange[1]))) {
					//产蛋期
					if(settleBreedStage.equals(SettleBreedStageEnum.egg)) {
						if(info2==null) {
							info2=(StatementsBillInfo) info.clone();
							info2.setId(BOSUuid.create(info2.getBOSType()));
							info2.setBreedStage(FarmStageEnum.eggs);
							//						info2.setNumber(AppCommon.getAutoCode(ctx,info,companyID));
							info2.getBatchDetail().clear();
						}
						//产蛋期
						batchDetailInfo2=(StatementsBillBatchDetailInfo) batchDetailInfo.clone();
						batchDetailInfo2.setBeginDate(matureDate.before(dateRange[0])?dateRange[0]:matureDate);
						batchDetailInfo2.setEndDate(dateRange[1]);
						info2.getBatchDetail().add(batchDetailInfo2);
					}

					//定群日期大于期间开始日期
					if(matureDate.after(dateRange[0])) {
						cal.setTime(matureDate);
						cal.add(Calendar.DAY_OF_MONTH, -1);
						//育成、育雏期
						batchDetailInfo.setBeginDate(dateRange[0]);
						batchDetailInfo.setEndDate(cal.getTime());
						batchDetailInfo.setIsTransFA(true);//转固定资产
						info.getBatchDetail().add(batchDetailInfo);
					}
				}else {
					if(!settleBreedStage.equals(SettleBreedStageEnum.egg)) {
						//育成、育雏期
						batchDetailInfo.setBeginDate(dateRange[0]);
						batchDetailInfo.setEndDate(dateRange[1]);
						info.getBatchDetail().add(batchDetailInfo);
					}
				}
				//执行结算
				if(rs.getRow()==rs.size()) {
					if(info!=null&&info.getBatchDetail().size()>0&&settleBreedStage.equals(SettleBreedStageEnum.breed)) {
						settleBillCol.add(info);
					}
					if(info2!=null&&info2.getBatchDetail().size()>0&&settleBreedStage.equals(SettleBreedStageEnum.egg)) {
						settleBillCol2.add(info2);
					}
					info2=null;
					info=null;
					batchDetailInfo2=null;
					batchDetailInfo=null;
				}
				if(settleBreedStage.equals(SettleBreedStageEnum.breed)&&info!=null&&info.getBatchDetail().size()>0&&!hasExeID.contains(exeID)) {
					hasExeID.add(exeID);
				}
				if(settleBreedStage.equals(SettleBreedStageEnum.egg)&&info2!=null&&info2.getBatchDetail().size()>0&&!hasExeID.contains(exeID)) {
					hasExeID.add(exeID);
				}
			}

			//结算 --育雏育成期
			if(settleBillCol.size()>0) {
				for(int i=0;i<settleBillCol.size();i++) {
					_btnExeCal(ctx, settleBillCol.getObject(i));
				}
				StatementsBillFactory.getLocalInstance(ctx).addnew(settleBillCol);
			}
			//结算 --产蛋期
			if(settleBillCol2.size()>0) {
				for(int i=0;i<settleBillCol2.size();i++) {
					System.out.println("产蛋期"+i);
					_btnExeCal(ctx, settleBillCol2.getObject(i));
				}
				StatementsBillFactory.getLocalInstance(ctx).addnew(settleBillCol2);
			}

		}catch(Exception err) {
			System.out.println(err.getStackTrace()[0].getLineNumber());
			throw new EASBizException(new NumericExceptionSubItem("001",err.getMessage()));
		}
		return null;
	}

	/**
	 * 生成固定资产卡片
	 */
	private void createToFACard(Context ctx,CoreBaseCollection settleBillCol) {
		for(int i=0;i<settleBillCol.size();i++) {

		}
	}

	/**
	 * 设置半成品价格info
	 * @param ctx
	 * @param bizDate
	 */
	private void setCoProductPriceInfo(Context ctx,String companyID,String bizDate) {
		try {
			StringBuffer sql=new StringBuffer();
			sql.append(" select fid")
			.append(" from T_FM_CoProductPrice ")
			.append(" where fcompanyID='").append(companyID).append("'")
			.append(" and FBaseStatus=").append(FarmBaseStatusEnum.ENABLE_VALUE)
			.append(" and FEffectDate<={d '").append(bizDate).append("'}")
			.append(" and CFUnEffectDate>({d '").append(bizDate).append("'}-1)")
			.append(" order by fcreatetime desc")
			;
			rs=DbUtil.executeQuery(ctx, sql.toString());
			if(rs.next()) {
				copInfo=CoProductPriceFactory.getLocalInstance(ctx).getCoProductPriceInfo(new ObjectUuidPK(rs.getString("fid")));
			}
		}catch(Exception err) {
			err.printStackTrace();
		}
	}

	/** 设置副产品数据--其他--冲回--种蛋接收单
	 * @param ctx
	 * @param info
	 * @param batchID 
	 * @param endDateStr 
	 * @param beginDateStr 
	 */
	private void setEggReceiveData(Context ctx,StatementsBillInfo info,StringBuffer filterSqlStr, String beginDateStr, String endDateStr, String batchID) throws EASBizException {
		try {
			StringBuffer sql=new StringBuffer();
			sql.append(" select FStatisticsType,isnull(sum(isnull(FQc1lv1Qty,0)+isnull(FQc1lv2Qty,0)+isnull(FQc2lv1Qty,0)+isnull(FQc2lv2Qty,0)+isnull(FQc3lv1Qty,0)+isnull(FQc4lv1Qty,0)+isnull(FQc5lv2Qty,0)+isnull(FQc6lv2Qty,0)),0) fqcQty,")
			.append(" isnull(sum(FGreensQty),0) FGreensQty,isnull(sum(FDirtyQty),0) FDirtyQty,isnull(sum(FDoubleQty),0) FDoubleQty,isnull(sum(FMutantQty),0) FMutantQty,isnull(sum(FBrokenSingeQty),0) FBrokenSingeQty,isnull(sum(FFlowQty),0) FFlowQty,isnull(sum(FBrokenDoubleQty),0) FBrokenDoubleQty")
			.append(" from T_FM_EggReceiveBill tmain")
			.append(" inner join T_FM_EggReceiveBillEntry tentry on tentry.fparentid=tmain.fid")
			.append(" inner join t_fm_stockingBatch tbatch on tbatch.fid=tentry.FStockingBatchID")
			.append(" where tmain.fcompanyid='").append(info.getCompany().getString("id")).append("'")
			.append(" and tmain.fbillstatus=4")
			.append(" and ( tentry.FStatisticsType=").append(StatisticsType.NUMQTY_VALUE)
			.append(" or tentry.FStatisticsType=").append(StatisticsType.ALLWIGHT_VALUE)
			.append(" )")
			.append(" and (tmain.FBizDate>={d '").append(beginDateStr).append("'} and tmain.FBizDate<{d '").append(endDateStr).append("'}+1 and tbatch.fid='").append(batchID).append("')")
			//			.append(filterSqlStr)
			.append(" group by FStatisticsType");
			rs=DbUtil.executeQuery(ctx, sql.toString());
			while(rs.next()) {
				//合格蛋数量
				//				if(rs.getInt("FBrokenDoubleQty")==StatisticsType.NUMQTY_VALUE) {
				if(rs.getInt("FStatisticsType")==StatisticsType.NUMQTY_VALUE) {
					info.setReceiveQcEggQty(rs.getBigDecimal("fqcQty"));
				}else {
					if(copInfo==null) {
						return;
					}
					BigDecimal amount=copInfo.getGreensPrice().multiply(rs.getBigDecimal("FGreensQty")).add(copInfo.getDirtyPirce().multiply(rs.getBigDecimal("FDirtyQty")))
					.add(copInfo.getDoublePrice().multiply(rs.getBigDecimal("FDoubleQty"))).add(copInfo.getMutantPrice().multiply(rs.getBigDecimal("FMutantQty")))
					.add(copInfo.getBrokenSinglePrice().multiply(rs.getBigDecimal("FBrokenSingeQty"))).add(copInfo.getFlowPrice().multiply(rs.getBigDecimal("FFlowQty")))
					.add(copInfo.getBrokenDoublePrice().multiply(rs.getBigDecimal("FBrokenDoubleQty")));
					amount= amount.setScale(2, BigDecimal.ROUND_HALF_UP);
					info.setCoProductAmount(amount);
				}
			}
		}catch(Exception err) {
			throw new EASBizException(new NumericExceptionSubItem("001",err.toString()));
		}
	}

	/**
	 * 设置费用分摊数据
	 * @param ctx
	 * @param companyID
	 * @param periodID
	 * @param beginDateStr
	 * @param endDateStr
	 * @param tableBean
	 * @throws EASBizException
	 */
	private void setFeeAllocationData(Context ctx,StatementsBillInfo info ,String companyID,String periodID,StringBuffer batchFilterStr) throws EASBizException{
		try {
			StringBuffer sql=new StringBuffer();
			sql.append(" select isnull(sum(FAlloctionAmount),0) FAmount")
			.append(" from T_FM_CostAllocation tmain")
			.append(" inner join T_FM_CostAllocationEntry tentry on tentry.fparentid=tmain.fid")
			.append(" inner join T_FM_CostAllocationDetail tdetail on tdetail.fparentid=tentry.fid")
			.append(" inner join t_fm_stockingbatch tbatch on tbatch.fid=tdetail.fstockingbatchid")
			.append(" where tmain.fcompanyid='").append(companyID).append("'")
			.append(" and tmain.fperiodid='").append(periodID).append("'")
			.append(" and tmain.fbillStatus=").append(BillBaseStatusEnum.AUDITED_VALUE)
			.append(" and tdetail.ffarmerID='").append(info.getString("farmerID")).append("'")
			.append(" and tdetail.ffarmID='").append(info.getString("farmID")).append("'")
			.append(batchFilterStr);
			//产蛋期
			if(info.getBreedStage().equals(FarmStageEnum.eggs)) {
				sql.append(" and tdetail.FBreedStage=").append(FarmStageEnum.EGGS_VALUE);
			}else {
				sql.append(" and tdetail.FBreedStage!=").append(FarmStageEnum.EGGS_VALUE);
			}
			rs = DbUtil.executeQuery(ctx, sql.toString());
			StatementsBillOtherEntryInfo entryInfo;
			BigDecimal sumFeeAmount=BigDecimal.ZERO;
			while(rs.next()) {
				if(rs.getBigDecimal("FAmount").signum()<=0) {
					continue;
				}
				entryInfo=new StatementsBillOtherEntryInfo();
				entryInfo.setItemName("费用分摊");
				entryInfo.setAmount(rs.getBigDecimal("FAmount"));
				//				entryInfo.setRemark("成本");
				info.getOtherEntry().add(entryInfo);

				sumFeeAmount=sumFeeAmount.add(rs.getBigDecimal("FAmount"));
			}
			info.setFeeCostAmount(sumFeeAmount);
		}catch(Exception err) {
			throw new EASBizException(new NumericExceptionSubItem("001",err.getMessage()));
		}
	}

	/**
	 * 设置育成期冲回数据
	 * @param ctx
	 * @param companyID
	 * @param periodID
	 * @param beginDateStr
	 * @param endDateStr
	 * @param tableBean
	 * @throws EASBizException    
	 */
	private void setOffSetData(Context ctx,StatementsBillInfo info ,String companyID,String periodID) throws EASBizException {
		try {
			//			if(true) {
			//				return;
			//			}

			//非产蛋期不冲回
			if(!info.getBreedStage().equals(FarmStageEnum.eggs)) {
				return;
			}
			String sp = "\n";
			StringBuffer sql=new StringBuffer();
			sql.append(" select fid,isnull(FMonthDepreRate,0) FMonthDepreRate,isnull(ttemp.FUsedAmount,0) FUsedAmount,isnull(cfallaramount,0) cfallaramount ").append(sp)
			.append(" from T_FA_FaCurCard tcard").append(sp)
			.append(" left join (").append(sp)
			.append(" select tentry.fstockingbatchid,sum(foffsetAmount) FUsedAmount from T_FM_StatementsBillBatchDetail tentry ").append(sp)
			.append(" inner join T_FM_StatementsBill tmain on tmain.fid=tentry.fparentid").append(sp)
			.append(" and tmain.fcompanyID='").append(companyID).append("'").append(sp)
			.append(" and tmain.fbillStatus=4").append(sp)
			.append(" and tentry.fstockingbatchid=?").append(sp);
			if(info.getId()!=null) {
				sql.append(" and tmain.fid !='").append(info.getString("id")).append("'").append(sp);
			}
			sql.append(" group by tentry.fstockingbatchid").append(sp)
			.append(" ) ttemp on ttemp.fstockingbatchid=tcard.CFBreedBatchID").append(sp)
			.append(" where tcard.FCompanyID='").append(companyID).append("'").append(sp)
			.append(" and (tcard.CFStockingbatchID=? or tcard.CFBREEDBATCHID=?)").append(sp)
			.append(" ").append(sp);

			StringBuffer faCardUpdateSql=new StringBuffer();
			StringBuffer faCardInsertSql=new StringBuffer();

			String batchID;
			BigDecimal monthDepreRate,tempAmount;//余额折旧率
			BigDecimal sumAmount=BigDecimal.ZERO,allSumAmount=BigDecimal.ZERO;//合计折旧金额
			String userID=ContextUtil.getCurrentUserInfo(ctx).getString("id");
			IRowSet rsReCal;
			for(int index=0;index<info.getBatchDetail().size();index++) {
				if(info.getBatchDetail().get(index).get("stockingBatch") instanceof String)
					batchID=info.getBatchDetail().get(index).getString("stockingBatch");
				else{
					batchID=((IPropertyContainer)info.getBatchDetail().get(index).getStockingBatch()).getString("id");
				}
				//				batchID=info.getBatchDetail().get(index).getStockingBatch().getId().toString();
				rs=DbUtil.executeQuery(ctx, sql.toString(),new String[]{batchID,batchID,batchID});
				sumAmount=BigDecimal.ZERO;
				while(rs.next()) {
					//					if(tempAmount.add(rs.getBigDecimal("FUsedAmount")).compareTo(rs.getBigDecimal("cfallaramount"))>0){
					//						tempAmount=rs.getBigDecimal("cfallaramount").subtract(rs.getBigDecimal("FUsedAmount"));
					//					}
					//					sumAmount=sumAmount.add(tempAmount);
					//					allSumAmount=allSumAmount.add(tempAmount);

					monthDepreRate=rs.getBigDecimal("FMonthDepreRate");
					//重算当期工作量
//					System.out.println("/*dialect*/select nvl(t2.FCorrentWorkLoad,0) FCorrentWorkLoad,nvl(t1.FEvalleftPeriod,0)  FTotalWorkLoad from T_FA_FaCurCard t1 inner join T_FA_FaWorkLoad t2 on  t1.FID='"+rs.getString("fid")+"' and t1.FID=t2.FCurCardID and t2.FPeriodID='"+periodID+"'");
					rsReCal = DbUtil.executeQuery(ctx,"/*dialect*/select nvl(t2.FCorrentWorkLoad,0) FCorrentWorkLoad,nvl(t1.FEvalleftPeriod,0)  FTotalWorkLoad from T_FA_FaCurCard t1 inner join T_FA_FaWorkLoad t2 on  t1.FID='"+rs.getString("fid")+"' and t1.FID=t2.FCurCardID and t2.FPeriodID='"+periodID+"'");
					if(rsReCal.next()){
						if(rsReCal.getBigDecimal("FTotalWorkLoad").compareTo(BigDecimal.ZERO)!=0)
							monthDepreRate=rsReCal.getBigDecimal("FCorrentWorkLoad").divide(rsReCal.getBigDecimal("FTotalWorkLoad"),10,BigDecimal.ROUND_HALF_EVEN).multiply(new BigDecimal("100"));
					}

					tempAmount=rs.getBigDecimal("cfallaramount").multiply(monthDepreRate).multiply(new BigDecimal(0.01)).setScale(2,BigDecimal.ROUND_HALF_UP);

					faCardInsertSql.append(" insert into ").append(faOffSetDetailTable).append(" (fid,FFaCardID,fsettlebillid,fsettlebillNum,famount,fbizdate,fuserid) values (")
					.append(" newbosid('F4B2A0AE'),'").append(rs.getString("fid")).append("','").append(info.getString("id")).append("','").append(info.getNumber()).append("',").append(tempAmount).append(",")
					.append(" {ts '").append(sdf2.format(info.getBizDate())).append("'},'").append(userID).append("');");

					//设置本期摊销额
					faCardUpdateSql.append(" update T_FA_FaCurCard t1 set t1.CFCurrentTXAmt=").append(tempAmount).append(" where t1.fid='").append(rs.getString("fid")).append("';");
					/*	
					//2017-10-04 WZW 批量计算育成冲回
					StringBuffer sql7=new StringBuffer();
					sql7.append("update T_FM_StatementsBill set FArAmountOffset='")
						.append(tempAmount).append("' where fid='").append(info.getId().toString()).append("'");
					DbUtil.execute(ctx, sql7.toString());*/

					info.setArAmountOffset(tempAmount);



					//设置累计摊销金额
					faCardUpdateSql.append(" update T_FA_FaCurCard t1 set t1.cfTotalTXAmt=(nvl(t1.CFinitUseApAmount,0)+(select sum(FAmount) from  ").append(faOffSetDetailTable).append("  t2 where t2.ffacardid=t1.fid)) where t1.fid='").append(rs.getString("fid")).append("';");

					//设置为摊销金额
					faCardUpdateSql.append(" update T_FA_FaCurCard t1 set t1.CFRemainTXAmt=(nvl(t1.CFallArAmount,0)-nvl(t1.cfTotalTXAmt,0)) where t1.fid='").append(rs.getString("fid")).append("';");
					//					.append(" update T_FA_FaCurCard set cfunUseArAmount=nvl(cfallaramount,0)-nvl(cfinitUseArAmount,0)-nvl(cfusearAmount,0) where fid='").append(rs.getString("fid")).append("';");
					//					.append(" update T_FA_FaCurCard set cfunUseArAmount=nvl(cfallaramount,0)-nvl(cfinitUseArAmount,0)-nvl(cfusearAmount,0) where fid='").append(rs.getString("fid")).append("';")
					;
				}
				info.getBatchDetail().get(index).setOffsetAmount(sumAmount);
			}
			//更新固定资产卡片未冲金额
			if(faCardUpdateSql.length()>0) {
				DbUtil.execute(ctx, faCardInsertSql.toString());

				faCardUpdateSql.insert(0, "/*dialect*/begin ");
				faCardUpdateSql.append(" end;");
				DbUtil.execute(ctx, faCardUpdateSql.toString());
			}
			if(allSumAmount.signum()>0) {
				StatementsBillOtherEntryInfo entryInfo = new StatementsBillOtherEntryInfo();
				entryInfo.setItemName("育成期应收冲回");
				entryInfo.setAmount(allSumAmount);
				entryInfo.setRemark("");
				info.getOtherEntry().add(entryInfo);
			}

		}catch(Exception err) {
			throw new EASBizException(new NumericExceptionSubItem("001",err.getMessage()));
		}
	}

	/**
	 * 设置固定资产信息
	 * @param ctx
	 * @param companyID
	 * @param beginDateStr
	 * @param endDateStr
	 * @param tableBean
	 * @throws EASBizException 
	 */
	private void setFACurData(Context ctx,StatementsBillInfo info,String companyID,String periodID,StringBuffer batchFilterStr) throws EASBizException{
		try {
			if(!info.getBreedStage().equals(FarmStageEnum.eggs)) {
				return;
			}
			if(true) {
				//				return;
			}
			StringBuffer sql=new StringBuffer();
			sql.append(" select isnull(sum(FDepreTerm),0) FAmount")//FDepreTerm本期折旧
			.append(" from T_FA_FaAccountBalance tbal")//固定资产余额表
			.append(" inner join T_FA_FaCurCard tcard on tcard.fid=tbal.FFaCurCardID")//固定资产卡片   18
			.append(" inner join t_fm_stockingbatch tbatch on tbatch.fid=tcard.cfstockingbatchid")
			.append(" where tbal.FCompanyOrgUnitID='").append(companyID).append("'")
			.append(" and tbal.fperiodid='").append(periodID).append("'")
			//			.append(" and tcard.cffarmerid='").append(info.getString("farmerID")).append("'")
			.append(" and tcard.cffarmerid='").append(info.get("farmer") instanceof String?info.getString("farmer"):info.getFarmer().getId().toString()).append("'")
			//			.append(" and tcard.cffarmid='").append(info.getString("farmID")).append("'")
			.append(" and tcard.cffarmid='").append(info.get("farm") instanceof String?info.getString("farm"):info.getFarm().getId().toString()).append("'")
			.append(batchFilterStr);
			rs = DbUtil.executeQuery(ctx, sql.toString());
			if(("75QAAAAN8MUYMRT/").equals(info.get("farmer") instanceof String?info.getString("farmer"):info.getFarmer().getId().toString())){
				System.out.println(sql.toString());
			}
			BigDecimal sumAmount=BigDecimal.ZERO;
			StatementsBillOtherEntryInfo entryInfo;
			while(rs.next()) {
				entryInfo=new StatementsBillOtherEntryInfo();
				entryInfo.setItemName("生物性资产折旧");
				entryInfo.setAmount(rs.getBigDecimal("FAmount"));
				entryInfo.setRemark("");
				info.getOtherEntry().add(entryInfo);

				sumAmount=sumAmount.add(rs.getBigDecimal("FAmount"));
			}
			StringBuffer sql7=new StringBuffer();
			sql7.append("update T_FM_StatementsBill set FFaFurCardCost='")
			.append(sumAmount).append("' where fid='").append(info.getId().toString()).append("'");
			DbUtil.execute(ctx, sql7.toString());

			info.setFaFurCardCost(sumAmount);
		}catch(Exception err) {
			throw new EASBizException(new NumericExceptionSubItem("001",err.getMessage()));
		}
	}

	@Override
	protected void _multiSubmit(Context ctx, IObjectValue model)
	throws BOSException {
		// TODO Auto-generated method stub

	}

	@Override
	protected void _calYC(Context ctx, IObjectValue model) throws BOSException {

		StringBuffer sql= new StringBuffer();
		sql.append("select fid from T_FM_StatementsBill where    FPeriodID='75QAAAAFPj2COIxM'");
		RowSet rs=SQLExecutorFactory.getLocalInstance(ctx, sql.toString()).executeSQL();

		StringBuffer sql2=new StringBuffer();

		try {
			while(rs.next()){
				String id=rs.getString("fid");

				StatementsBillInfo info=StatementsBillFactory.getLocalInstance(ctx).getStatementsBillInfo(new ObjectUuidPK(id));
				//				setOffSetData(ctx, info, info.getCompany().getId().toString(), info.getPeriod().getString("id"));
				//				setFACurData(ctx, info, info.getCompany().getId().toString(),info.getPeriod().getString("id"),batchFilterStr);

				BigDecimal allActualCost=BigDecimal.ZERO;
				BigDecimal dw=BigDecimal.ZERO;
				BigDecimal zz=BigDecimal.ZERO;
				BigDecimal z1=BigDecimal.ZERO;
				BigDecimal z2=BigDecimal.ZERO;
				BigDecimal z3=BigDecimal.ZERO;
				BigDecimal z4=BigDecimal.ZERO;
				BigDecimal z5=BigDecimal.ZERO;
				BigDecimal z6=BigDecimal.ZERO;
				BigDecimal z7=BigDecimal.ZERO;
				BigDecimal z8=BigDecimal.ZERO;
				BigDecimal z9=BigDecimal.ZERO;
				BigDecimal z10=BigDecimal.ZERO;
				BigDecimal z11=BigDecimal.ZERO;
				BigDecimal z12=BigDecimal.ZERO;
				BigDecimal z13=BigDecimal.ZERO;
				BigDecimal loanDiff=info.getLoanInterestDiff();//贷款利息差
				if(loanDiff==null) {
					loanDiff=BigDecimal.ZERO;
				}
				if(info.getAllEggAmount()!=null){
					zz=info.getAllEggAmount();
				}else{
					zz=BigDecimal.ZERO;
				}
				if(info.getAllEggAmount()!=null){
					z1=info.getAwardsAmount();
				}else{
					z1=BigDecimal.ZERO;
				}
				if(info.getBreedDataCost()!=null){
					z2=info.getBreedDataCost();
				}else{
					z2=BigDecimal.ZERO;
				}
				if(info.getFodderCost()!=null){
					z3=info.getFodderCost();
				}else{
					z3=BigDecimal.ZERO;
				}
				if(info.getDrugCost()!=null){
					z4=info.getDrugCost();
				}else{
					z4=BigDecimal.ZERO;
				}
				if(info.getOtherMaterialCost()!=null){
					z5=info.getOtherMaterialCost();
				}else{
					z5=BigDecimal.ZERO;
				}
				if(info.getFeeCostAmount()!=null){
					z6=info.getFeeCostAmount();
				}else{
					z6=BigDecimal.ZERO;
				}
				if(info.getBreedDataAmount()!=null){
					z7=info.getBreedDataAmount();
				}else{
					z7=BigDecimal.ZERO;
				}
				if(info.getBreedDataAmount()!=null){
					z8=info.getFodderAmount();
				}else{
					z8=BigDecimal.ZERO;
				}
				if(info.getDrugAmount()!=null){
					z9=info.getDrugAmount();
				}else{
					z9=BigDecimal.ZERO;
				}
				if(info.getOtherMaterialAmount()!=null){
					z10=info.getOtherMaterialAmount();
				}else{
					z10=BigDecimal.ZERO;
				}
				if(info.getArAmountOffset()!=null){
					z11=info.getArAmountOffset();
				}else{
					z11=BigDecimal.ZERO;
				}
				if(info.getCoProductAmount()!=null){
					z12=info.getCoProductAmount();
				}else{
					z12=BigDecimal.ZERO;
				}
				if(zz!=null&&z1!=null&&z2!=null&&z3!=null&&z4!=null&&z5!=null&&z6!=null&&z7!=null&&z8!=null&&z9!=null&&z10!=null&&z11!=null&&z12!=null&loanDiff!=null){
					allActualCost=zz.add(z1).add(z2).add(z3).add(z4).add(z5).add(z6).subtract(z7).subtract(z8).subtract(z9).subtract(z10)
					//				.add(info.getBirdsAmount())
					.subtract(z11)
					.subtract(loanDiff)
					.subtract(z12);
					//		.add(info.getFaFurCardCost())
				}

				if(info.getReceiveQcEggQty()!=null&&info.getReceiveQcEggQty().compareTo(BigDecimal.ZERO)>0) {
					dw=allActualCost.divide(info.getReceiveQcEggQty(),2,BigDecimal.ROUND_HALF_UP);
				}

				sql2.append("	update T_FM_StatementsBill set FAllActualCost='")
				.append(allActualCost).append("',FUnitActualAmount='").append(dw).append("' where fid ='").append(id).append("'");

				DbUtil.execute(ctx, sql2.toString());

			}
		} catch (EASBizException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}



	}
	/**
	 * 结转
	 */
	@Override
	protected void _carryover(Context ctx, IObjectValue model)
	throws BOSException {
		//		// TODO Auto-generated method stub
		//		IRowSet rsQuery = DbUtil.executeQuery(ctx, "select FID from T_FM_StatementsBill where FPeriodID='75QAAAAFPj6COIxM' and FCompanyID='75QAAAAAAPTM567U' and FBreedStage=3 ");
		//		//and FID='CPyaZ0gnTWO6x0U3liICmRjWcbA='
		//		IStatementsBill iStatementsBill = StatementsBillFactory.getLocalInstance(ctx);
		//		//		StatementsBillCollection coll = StatementsBillFactory.getLocalInstance(ctx).getStatementsBillCollection("where Period='75QAAAAFPj6COIxM' and company='75QAAAAAAPTM567U' and BreedStage=3");
		//		//		System.out.println(coll.size());
		//		SelectorItemCollection slor=new SelectorItemCollection();
		//		slor.add("*");
		//		slor.add("otherEntry.*");
		//		slor.add("batchDetail.*");
		//		slor.add("batchDetail.stockingBatch.*");
		//		StringBuffer sb=new StringBuffer();
		//		int i=0;
		//
		//		//				try {
		//		try {
		//			while(rsQuery.next()){
		//				System.out.println(++i);
		//				StatementsBillInfo info = iStatementsBill.getStatementsBillInfo(new ObjectUuidPK(rsQuery.getString("FID")),slor);
		//
		//				BigDecimal allActualCost = UIRuleUtil.getBigDecimal(info.getAllEggAmount()).add(UIRuleUtil.getBigDecimal(info.getAwardsAmount())).add(UIRuleUtil.getBigDecimal(info.getBreedDataCost())).add(UIRuleUtil.getBigDecimal(info.getFodderCost())).add(UIRuleUtil.getBigDecimal(info.getDrugCost())).add(UIRuleUtil.getBigDecimal(info.getOtherMaterialCost()))
		//				.add(UIRuleUtil.getBigDecimal(info.getFeeCostAmount())).subtract(UIRuleUtil.getBigDecimal(info.getBreedDataAmount())).subtract(UIRuleUtil.getBigDecimal(info.getFodderAmount())).subtract(UIRuleUtil.getBigDecimal(info.getDrugAmount())).subtract(UIRuleUtil.getBigDecimal(info.getOtherMaterialAmount()))
		//				//		.add(info.getBirdsAmount())
		//				.subtract(UIRuleUtil.getBigDecimal(info.getArAmountOffset())).subtract(UIRuleUtil.getBigDecimal(info.getLoanInterestDiff()))
		//				.subtract(UIRuleUtil.getBigDecimal(info.getCoProductAmount()));
		//				//		.add(info.getFaFurCardCost())
		//
		//				info.setAllActualCost(allActualCost);
		//
		//				//单位成本
		//				if(info.getReceiveQcEggQty()!=null&&info.getReceiveQcEggQty().signum()>0) {
		//					info.setUnitActualAmount(allActualCost.divide(info.getReceiveQcEggQty(),2,BigDecimal.ROUND_HALF_UP));
		//				}
		//				StatementsBillFactory.getLocalInstance(ctx).save(info);
		//				//						for(int j=info.getOtherEntry().size()-1;j>0;j--){
		//				//							if(StringUtils.isNotBlank(info.getOtherEntry().get(j).getItemName())&&(info.getOtherEntry().get(j).getItemName().equals("育成期应收冲回"))||info.getOtherEntry().get(j).getItemName().equals("生物性资产折旧"))
		//				//								info.getOtherEntry().remove(info.getOtherEntry().get(j));
		//				//		
		//				//						}
		//				//						setOffSetData(ctx,info,"75QAAAAAAPTM567U","75QAAAAFPj6COIxM");
		//				//						if(info.getStockingBatch()!=null){
		//				//							sb.setLength(0);
		//				//							sb.append(" and tbatch.fid='").append(info.getStockingBatch().getString("id")).append("'");
		//				//							setFACurData(ctx, info, "75QAAAAAAPTM567U", "75QAAAAFPj6COIxM", sb);
		//				//						}
		//				//						StatementsBillFactory.getLocalInstance(ctx).save(info);
		//				//					}
		//				//				} catch (EASBizException e) {
		//				//					// TODO Auto-generated catch block
		//				//					e.printStackTrace();
		//				//				} catch (SQLException e) {
		//				//					// TODO Auto-generated catch block
		//				//					e.printStackTrace();
		//				//				}
		//			}
		//		} catch (EASBizException e) {
		//			// TODO Auto-generated catch block
		//			e.printStackTrace();
		//		} catch (SQLException e) {
		//			// TODO Auto-generated catch block
		//			e.printStackTrace();
		//		}
	}

}