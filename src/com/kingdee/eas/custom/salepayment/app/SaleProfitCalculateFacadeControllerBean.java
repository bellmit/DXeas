package com.kingdee.eas.custom.salepayment.app;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.Context;
import com.kingdee.bos.dao.IObjectCollection;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.bos.metadata.data.SortType;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.bos.metadata.entity.FilterInfo;
import com.kingdee.bos.metadata.entity.FilterItemInfo;
import com.kingdee.bos.metadata.entity.SorterItemInfo;
import com.kingdee.bos.metadata.query.util.CompareType;
import com.kingdee.bos.util.BOSUuid;
import com.kingdee.eas.basedata.assistant.MeasureUnitInfo;
import com.kingdee.eas.basedata.master.cssp.CustomerInfo;
import com.kingdee.eas.basedata.master.material.MaterialInfo;
import com.kingdee.eas.basedata.org.CompanyOrgUnitInfo;
import com.kingdee.eas.basedata.person.PersonInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.common.client.SysContext;
import com.kingdee.eas.custom.salepayment.CompanyTargetFactory;
import com.kingdee.eas.custom.salepayment.CompanyTargetInfo;
import com.kingdee.eas.custom.salepayment.DisableState;
import com.kingdee.eas.custom.salepayment.FeeTypeInfo;
import com.kingdee.eas.custom.salepayment.GrossProfitInfoEntryInfo;
import com.kingdee.eas.custom.salepayment.GrossProfitInfoFactory;
import com.kingdee.eas.custom.salepayment.GrossProfitInfoInfo;
import com.kingdee.eas.custom.salepayment.IndexType;
import com.kingdee.eas.custom.salepayment.MaterialStandardCostCollection;
import com.kingdee.eas.custom.salepayment.MaterialStandardCostCostDetailEntryCollection;
import com.kingdee.eas.custom.salepayment.MaterialStandardCostCostDetailEntryFactory;
import com.kingdee.eas.custom.salepayment.MaterialStandardCostCostDetailEntryInfo;
import com.kingdee.eas.custom.salepayment.MaterialStandardCostFactory;
import com.kingdee.eas.custom.salepayment.MaterialStandardCostInfo;
import com.kingdee.eas.custom.salepayment.Quarter;
import com.kingdee.eas.custom.salepayment.SalePaymentSetCollection;
import com.kingdee.eas.custom.salepayment.SalePaymentSetFactory;
import com.kingdee.eas.custom.salepayment.SalePaymentSetInfo;
import com.kingdee.eas.custom.salepayment.SaleProfitCalculateResultFactory;
import com.kingdee.eas.custom.salepayment.SaleProfitCalculateResultFeeEntryInfo;
import com.kingdee.eas.custom.salepayment.SaleProfitCalculateResultInfo;
import com.kingdee.eas.custom.salepayment.SaleProfitCalculateResultMonthEntryInfo;
import com.kingdee.eas.custom.salepayment.SalerStimulateSetCollection;
import com.kingdee.eas.custom.salepayment.SalerStimulateSetFactory;
import com.kingdee.eas.custom.salepayment.SalerStimulateSetInfo;
import com.kingdee.eas.custom.salepayment.bean.NoStandardSetException;
import com.kingdee.eas.custom.salepayment.bean.SaleProfitResultInfo;
import com.kingdee.eas.custom.salepayment.util.SalePaymentUtil;
import com.kingdee.eas.scm.common.BillBaseStatusEnum;
import com.kingdee.eas.util.app.DbUtil;
import com.kingdee.eas.wlhlcomm.DateCommon;
import com.kingdee.jdbc.rowset.IRowSet;

public class SaleProfitCalculateFacadeControllerBean extends AbstractSaleProfitCalculateFacadeControllerBean
{
    private static Logger logger =
        Logger.getLogger("com.kingdee.eas.custom.salepayment.app.SaleProfitCalculateFacadeControllerBean");

    
    
    
    /**
     * 按照公司指标计算损益，返回结果
     * 获取基本资料然后计算
     * 计算时
     * 首先根据公司指标获得 所有的销售员指标
     * 然后逐个销售员 按照指标计算，逐月 计算 然后 将结果保存到 结果单据中
     * 计算完成后将总结果返回
     */
	@Override
	protected SaleProfitResultInfo _calculateCompanyTarget(Context ctx,
			String companyID,
			String companyTargetID) throws BOSException {
		
		try{
			// 公司指标
			CompanyTargetInfo companyTarget = CompanyTargetFactory.getLocalInstance(ctx).getCompanyTargetInfo(new ObjectUuidPK(companyTargetID));
			// 获取需要计算的月份列表
			int year = companyTarget.getYear();
			int beginMonth = 0;
			int endMonth = 0;
			
			IndexType indexType = companyTarget.getIndexType();
			Quarter quarter = companyTarget.getQuater();
			if(indexType.getValue().equals(IndexType.YEAR_VALUE)){
				beginMonth = 1;
				endMonth = 12;
			}else if(indexType.getValue().equals(IndexType.QUARTER_VALUE )){
				if(quarter.getValue().equals(Quarter.ONE_VALUE)){
					beginMonth = 1;
					endMonth = 3;
				}else if(quarter.getValue().equals(Quarter.TWO_VALUE)){
					beginMonth = 4;
					endMonth = 6;
				}else if(quarter.getValue().equals(Quarter.THREE_VALUE)){
					beginMonth = 7;
					endMonth = 9;
				}else if(quarter.getValue().equals(Quarter.FOUR_VALUE)){
					beginMonth = 10;
					endMonth = 12;
				}
			}
			// 获取起始 日期和结束日期
			Date beginDate = DateCommon.getMonthBeginDate(year, beginMonth);
			Date endDate = DateCommon.getMonthEndTime(year, endMonth);
			
			// 获得公司销售额
			BigDecimal companyAllSaleAmount = getSaleAmount(ctx,companyID,null,beginDate,endDate);
			// 获得基本设置
			SalePaymentSetInfo companySetInfo = getCompanySetInfo(ctx, companyID);
			// 获得当年的 物料标准成本设置
			HashMap<String, MaterialStandardCostCostDetailEntryInfo> costSets = getCompanyStandardCost(ctx, companyID,companyTarget.getYear());
			// 获得销售员指标设置
			SalerStimulateSetCollection salerSetColl = (SalerStimulateSetCollection) getSalerTargetInfos(ctx, companyTargetID);
			if(salerSetColl != null && salerSetColl.size() > 0){
				// 逐个计算保存结果
				for(int i = 0; i < salerSetColl.size(); i++){
					SalerStimulateSetInfo salerSetInfo = salerSetColl.get(i);
					// 年指标
					salerSetInfo.setCompanyTargetInfo(companyTarget);
					// 根据设置，逐月计算结果,获得 计算后的 损益信息
					
					
					// 首先获得毛利明细
					SaleProfitResultInfo profitResultInfo = getSaleGrossInfo(ctx, companyID, companySetInfo, salerSetInfo, costSets,year,beginMonth,endMonth);
					// 公司总不含税销售额
					profitResultInfo.setCompanyAllNoTaxAmount(companyAllSaleAmount);
					// 获得销售员 年销售额
					BigDecimal salerNoTaxAmount = this.getSaleAmount(ctx, companyID, salerSetInfo.getSaler().getId().toString(), beginDate, endDate);
					
					
					// 设置 费用明细和汇总 
					profitResultInfo = getSalerFeeInfo(ctx, 
							profitResultInfo,
							companyID, 
							companySetInfo, 
							salerSetInfo,
							beginMonth,
							endMonth,
							beginDate,
							endDate,
							companyAllSaleAmount,
							salerNoTaxAmount);
					
					// 计算长期应收款
					// TODO
					
					IObjectPK pk = saveProfitResultInfo(ctx,profitResultInfo);
//					profitResultInfo
//					return profitResultInfo;
				}
			}
			return null;
			
		}catch(Exception e){
			throw new BOSException(e);
		}
	}
	
	/**
	 * 获得公司 指定政策时间范围内的销售 总额 (不含税销售额)
	 * @param ctx
	 * @param companyTarget
	 * @return
	 * @throws BOSException 
	 */
	private BigDecimal getSaleAmount(Context ctx,
			String companyID,
			String salerID,
			Date beginDate,
			Date endDate) throws BOSException {
		StringBuilder sb = new StringBuilder();
		SimpleDateFormat sdf = new SimpleDateFormat();
		SimpleDateFormat sdfss = new SimpleDateFormat();
		sb.append("select sum(t.noTaxAmount) noTaxAmount from (select sum(te.famount) noTaxAmount ");
		sb.append(" from t_sd_saleorder t ");
		sb.append(" inner join t_sd_saleorderentry te on t.fid = te.fparentid ");
		sb.append(" where t.fbasestatus in (4,7) ");
		sb.append(" and t.FSaleOrgUnitID='");
		sb.append(companyID);
		sb.append("' and t.fbizdate >= {ts'");
		sb.append(sdf.format(beginDate));
		sb.append("'} and t.fbizdate <={ ts'");
		sb.append(sdfss.format(endDate));
		sb.append("'} ");
		if(StringUtils.isNotBlank(salerID)){
			sb.append(" and t.FSalePersonID = '");
			sb.append(salerID);
			sb.append("'");
		}
		sb.append(" union all ");
		sb.append("select -sum(te.famount) noTaxAmount ");
		sb.append(" from T_SD_SaleReturns t ");
		sb.append(" inner join T_SD_SaleReturnsEntry te on t.fid = te.fparentid ");
		sb.append(" where t.fbasestatus in (4,7) ");
		sb.append(" and t.FSaleOrgUnitID='");
		sb.append(companyID);
		sb.append("' and t.fbizdate >= {ts'");
		sb.append(sdf.format(beginDate));
		sb.append("'} and t.fbizdate <={ ts'");
		sb.append(sdfss.format(endDate));
		sb.append("'} ");
		if(StringUtils.isNotBlank(salerID)){
			sb.append(" and t.FSalePersonID = '");
			sb.append(salerID);
			sb.append("'");
		}
		sb.append(") t ");
		
		
		try{
			IRowSet rs = DbUtil.executeQuery(ctx, sb.toString());
			if(rs.next()){
				return rs.getBigDecimal("noTaxAmount");
			}
		}catch(SQLException sqle){
			throw new BOSException(sqle);
		}
		
		
		return null;
	}

	/**
	 * 设置销售员费用明细 和汇总信息到 结果表中
	 * @param ctx
	 * @param companyID
	 * @param companySetInfo
	 * @param salerSetInfo
	 * @param beginDate
	 * @param endDate 
	 * @return
	 * @throws BOSException 
	 */
	private SaleProfitResultInfo getSalerFeeInfo(Context ctx,
			SaleProfitResultInfo profitResultInfo,
			String companyID,
			SalePaymentSetInfo companySetInfo,
			SalerStimulateSetInfo salerSetInfo,
			int beginMonth,
			int endMonth,
			Date beginDate,
			Date endDate,
			BigDecimal allNoTaxAmount,
			BigDecimal salerNoTaxAmount) throws BOSException {
		
		try{
			// 两部分 销售员个人 销售费用统计与公司销售费用分摊
			// 个人费用统计CT_SP_SaleFeeInput CT_SP_SaleFeeInputEntry
			StringBuilder sb = new StringBuilder();
			sb.append("	select ");
			sb.append("       ft.fid feeID, ");
	        sb.append("       max(ft.fnumber) feeNumber, ");
	        sb.append("       max(ft.fname_l2) feeName, ");
	        sb.append("       sum(te.cfamount) feeAmount ");
			       
	        sb.append(" from CT_SP_SaleFeeInput t  ");
			sb.append(" inner join CT_SP_SaleFeeInputEntry te on t.fid = te.fparentid ");
			sb.append(" inner join CT_SP_FeeType ft on te.CFFeeTypeID = ft.fid ");
			sb.append(" where t.cfyear =");
			sb.append(salerSetInfo.getYear());
			sb.append(" and t.cfmonth>=");
			sb.append(beginMonth);
			sb.append(" and t.cfmonth<=");
			sb.append(endMonth);
			sb.append(" and t.cfcompanyid= '");
			sb.append(companyID);
			
			sb.append("' and t.cfsalerid= '");
			sb.append(salerSetInfo.getSaler().getId().toString());
			sb.append("' and t.cfbasestatus in (4,7) ");
			
			IRowSet prs = DbUtil.executeQuery(ctx, sb.toString());
			// 逐条生成 分录
			while(prs.next()){
				String feeID = prs.getString("feeID");
				String feeNumber = prs.getString("feeNumber");
				String feeName = prs.getString("feeName");
				BigDecimal feeAmount = prs.getBigDecimal("feeAmount");
				
				// 费用明细
				SaleProfitCalculateResultFeeEntryInfo feeEntryInfo = new SaleProfitCalculateResultFeeEntryInfo();
				FeeTypeInfo feeType = new FeeTypeInfo();
				feeType.setId(BOSUuid.read(feeID));
				feeType.setNumber(feeNumber);
				feeType.setName(feeName);
				
				feeEntryInfo.setFeeType(feeType);
				feeEntryInfo.setFeeAmount(feeAmount);
				feeEntryInfo.setIsShared(false);
				// 增加到分录明细中
				profitResultInfo.getFeeEntryInfos().add(feeEntryInfo);
			}
			
			// 分摊费用统计CT_SP_CompanyMonthFee CT_SP_CompanyMonthFeeEntry
			if(salerNoTaxAmount != null &&
					allNoTaxAmount != null &&
					salerNoTaxAmount.compareTo(BigDecimal.ZERO) != 0 &&
					allNoTaxAmount.compareTo(BigDecimal.ZERO) != 0){
				
				
				sb = new StringBuilder();
				sb.append("	select ");
				sb.append("       ft.fid feeID, ");
		        sb.append("       max(ft.fnumber) feeNumber, ");
		        sb.append("       max(ft.fname_l2) feeName, ");
		        sb.append("       sum(te.cfamount) feeAmount ");
				       
		        sb.append(" from CT_SP_CompanyMonthFee t  ");
				sb.append(" inner join CT_SP_CompanyMonthFeeEntry te on t.fid = te.fparentid ");
				sb.append(" inner join CT_SP_FeeType ft on te.CFFeeTypeID = ft.fid ");
				sb.append(" where t.cfyear =");
				sb.append(salerSetInfo.getYear());
				sb.append(" and t.cfmonth>=");
				sb.append(beginMonth);
				sb.append(" and t.cfmonth<=");
				sb.append(endMonth);
				sb.append(" and t.cfcompanyid= '");
				sb.append(companyID);
				
				sb.append("' and  t.cfbasestatus in (4,7) ");
				
				IRowSet sharers = DbUtil.executeQuery(ctx, sb.toString());
				while(sharers.next()){
					String feeID = sharers.getString("feeID");
					String feeNumber = sharers.getString("feeNumber");
					String feeName = sharers.getString("feeName");
					BigDecimal feeAmount = sharers.getBigDecimal("feeAmount");
					
					if(feeAmount != null && feeAmount.compareTo(BigDecimal.ZERO) != 0){
						BigDecimal personFee = BigDecimal.ZERO;
						// 个人分摊费用  需要按销量分摊
						personFee = feeAmount.multiply(salerNoTaxAmount).divide(allNoTaxAmount, RoundingMode.HALF_UP);
						
						// 费用明细
						SaleProfitCalculateResultFeeEntryInfo feeEntryInfo = new SaleProfitCalculateResultFeeEntryInfo();
						FeeTypeInfo feeType = new FeeTypeInfo();
						feeType.setId(BOSUuid.read(feeID));
						feeType.setNumber(feeNumber);
						feeType.setName(feeName);
						
						feeEntryInfo.setFeeType(feeType);
						feeEntryInfo.setFeeAmount(personFee);
						feeEntryInfo.setIsShared(true);
						// 增加到分录明细中
						profitResultInfo.getFeeEntryInfos().add(feeEntryInfo);
					}
				}
			}
		}catch(SQLException sqle){
			throw new BOSException(sqle);
		}
		
		return profitResultInfo;
	}

	/**
	 * 保存损益计算结果
	 * @param ctx
	 * @param profitResultInfo
	 * @throws BOSException 
	 * @throws EASBizException 
	 */
	private IObjectPK saveProfitResultInfo(Context ctx,SaleProfitResultInfo profitResultInfo) throws EASBizException, BOSException{
		if(profitResultInfo != null){
			SaleProfitCalculateResultInfo profitCalculateResult = new SaleProfitCalculateResultInfo();
			profitCalculateResult.setCompany(profitResultInfo.getCompanyTargetInfo().getCompany());
			profitCalculateResult.setSaleStimulateInfo(profitResultInfo.getSalerSetInfo());
			profitCalculateResult.setCompanyTarget(profitResultInfo.getCompanyTargetInfo());
			profitCalculateResult.setAreaTarget(profitResultInfo.getSalerSetInfo().getAreaTargetInfo());
			
			profitCalculateResult.setIndexType(profitResultInfo.getSalerSetInfo().getIndexType());
			profitCalculateResult.setYear(profitResultInfo.getSalerSetInfo().getYear());
			profitCalculateResult.setQuarter(profitResultInfo.getSalerSetInfo().getQuarter());
			profitCalculateResult.setSaler(profitResultInfo.getSalerSetInfo().getSaler());
			
			if(profitResultInfo.getCompanySetInfo() != null){
				profitCalculateResult.setRecDataSource(profitResultInfo.getCompanySetInfo().getRecDataSource());
				profitCalculateResult.setManagerFeeShareType(profitResultInfo.getCompanySetInfo().getManageFeeShareType());
				profitCalculateResult.setProfitExeType(profitResultInfo.getCompanySetInfo().getProfitExeType());
			}
			profitCalculateResult.setAllRecAmount(profitResultInfo.getAllRecAmount());
			
			profitCalculateResult.setAllStandardCost(profitResultInfo.getAllStandardCost());
			
			// 设置按月统计的销售额  成本 分录
			List<GrossProfitInfoInfo> grossDetails = profitResultInfo.getGrossProfits();
			for(int i = 0; i < grossDetails.size(); i++){
				GrossProfitInfoInfo detailInfo = grossDetails.get(i);
				SaleProfitCalculateResultMonthEntryInfo monthEntry = new SaleProfitCalculateResultMonthEntryInfo();
				monthEntry.setParent(profitCalculateResult);
				monthEntry.setMonthGrossProfit(detailInfo);
				monthEntry.setGrossProfit(detailInfo.getAllGrossProfit());
				monthEntry.setMonth(detailInfo.getMonth());
				profitCalculateResult.getMonthEntry().add(monthEntry);
			}
			
			// 设置销售费用分录
			List<SaleProfitCalculateResultFeeEntryInfo> feeEntrys = profitResultInfo.getFeeEntryInfos();
			for(int j = 0; j < feeEntrys.size(); j++){
				SaleProfitCalculateResultFeeEntryInfo feeDetailInfo = feeEntrys.get(j);
				feeDetailInfo.setParent(profitCalculateResult);
				profitCalculateResult.getFeeEntry().add(feeDetailInfo);
				
			}
			// 保存计算结果
			IObjectPK pk = SaleProfitCalculateResultFactory.getLocalInstance(ctx).addnew(profitCalculateResult);
			return pk;
		}
		
		return null;
		
	}
	/**
	 * 获得指定 销售指标的 销售毛利
	 * @param ctx
	 * @param salerSetInfo
	 * @return
	 * @throws BOSException 
	 * @throws EASBizException 
	 */
	private SaleProfitResultInfo getSaleGrossInfo(Context ctx,
			String companyID,
			SalePaymentSetInfo saleSetInfo,
			SalerStimulateSetInfo salerSetInfo,
			HashMap<String, MaterialStandardCostCostDetailEntryInfo> costSets,
			int year,
			int beginMonth,
			int endMonth) throws BOSException, EASBizException{
		if(salerSetInfo != null){
			// 获取销售员设置明细
			salerSetInfo = SalerStimulateSetFactory.getLocalInstance(ctx).getSalerStimulateSetInfo(new ObjectUuidPK(salerSetInfo.getId()));
			
			SaleProfitResultInfo profitResult = new SaleProfitResultInfo(salerSetInfo);
			
			profitResult.setCompanySetInfo(saleSetInfo);
			// 指标设置
			profitResult.setCompanyTargetInfo(salerSetInfo.getCompanyTargetInfo());
			profitResult.setSalerSetInfo(salerSetInfo);
			
			
			
			
			// 逐月累计
			for(int i = beginMonth; i <= endMonth; i++){
				
				GrossProfitInfoInfo monthGrossProfit = getCompanyMonthGrossProfit(ctx, companyID, costSets, salerSetInfo, year, i);
				// 添加 到 损益计算结果列表中
				profitResult.addGrossProfitInfo(monthGrossProfit);
				// 计算其他费用 TODO
				
			}
			
			
			
			
			
			return profitResult;
		}else{
			return null;
		}
	}
	
	/**
	 * 保存计算后的 损益信息到利润计算结果中
	 */
	private void saveProfitResult(){
		
	}
	/**
	 * 获取指定 销售指标 指定年月 的 销售毛利数据
	 * @param ctx
	 * @param salerSetInfo
	 * @return
	 * @throws BOSException 
	 * @throws EASBizException 
	 */
	private GrossProfitInfoInfo getCompanyMonthGrossProfit(Context ctx, 
			String companyID,
			HashMap<String, MaterialStandardCostCostDetailEntryInfo> costSets,
			SalerStimulateSetInfo salerSetInfo,
			int year,
			int month) throws EASBizException, BOSException{
		GrossProfitInfoInfo grossProfitInfo = new GrossProfitInfoInfo();
		
		// 销售员
		PersonInfo personInfo = salerSetInfo.getSaler();
		// 月初日期
		Date beginDate = SalePaymentUtil.getFirstDayOfMonth(year, month-1);
		// 月末日期
		Date endDate = SalePaymentUtil.getLastDayOfMonth(year, month-1);
		
		// 设置毛利单据头信息
		grossProfitInfo.setBaseStatus(BillBaseStatusEnum.ADD);
		grossProfitInfo.setSaleStimulateInfo(salerSetInfo);
		grossProfitInfo.setCompany(salerSetInfo.getCompany());
		grossProfitInfo.setYear(year);
		grossProfitInfo.setMonth(month);
		grossProfitInfo.setIndexType(salerSetInfo.getIndexType());
		grossProfitInfo.setBizDate(new Date());
		grossProfitInfo.setQuarter(salerSetInfo.getQuarter());
		// TODO 总毛利
		BigDecimal allGrossProfit = new BigDecimal(0);
		BigDecimal allSaleNoTaxAmount = new BigDecimal(0);
		BigDecimal allSaleStandardCost = new BigDecimal(0);
		BigDecimal allSaleTaxAmount = new BigDecimal(0);
		BigDecimal allRecAmount = new BigDecimal(0);
		BigDecimal allRecGrossProfit = new BigDecimal(0);
		BigDecimal allRecStandardCost = new BigDecimal(0);
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		// 统计销量 
		StringBuilder sql = new StringBuilder("/*dialect*/");
		sql.append("select t.customerID, ");
		sql.append(" max(t.customerNumber) customerNumber, ");
		sql.append(" max(t.customerName) customerName, ");
		sql.append(" t.materialID, ");
		sql.append(" max(t.materialNumber) materialNumber, ");
		sql.append(" max(t.materialName) materialName, ");
		sql.append(" max(t.unitID) unitID, ");
		sql.append(" max(t.unitNumber) unitNumber, ");
		sql.append(" max(t.unitName) unitName, ");
		sql.append(" sum(t.saleQty) saleQty, ");
		sql.append(" sum(t.taxAmount) taxAmount, ");
		sql.append(" sum(t.amount) amount ");
		sql.append(" from  ");
		
		sql.append(" (select  ");

		sql.append("  tc.fid customerID, ");
		sql.append("  max(tc.fnumber) customerNumber, ");
		sql.append("  max(tc.fname_l2) customerName, ");
		sql.append("  tm.fid materialID, ");
		sql.append("  max(tm.fnumber) materialNumber, ");
		sql.append("  max(tm.fname_l2) materialName, ");
		sql.append("  max(tu.fid) unitID, ");
		sql.append("  max(tu.fnumber) unitNumber, ");
		sql.append("  max(tu.fname_l2) unitName, ");
		sql.append("  sum(te.fbaseqty) saleQty, ");
		sql.append("  sum(te.ftaxamount) taxAmount, ");
		sql.append("  sum(te.famount) amount ");

		sql.append("   from t_sd_saleorder t ");
		sql.append("  inner join t_sd_saleorderentry te ");
		sql.append("     on t.fid = te.fparentid ");
		sql.append("  inner join t_bd_customer tc ");
		sql.append("     on t.fordercustomerid = tc.fid ");
		sql.append("  inner join t_bd_material tm ");
		sql.append("     on te.fmaterialid = tm.fid ");
	    sql.append("  inner join t_bd_measureunit tu ");
		sql.append("     on tm.fbaseunit = tu.fid ");

	    sql.append("  where t.fbizdate >= to_date('");
	    sql.append(sdf.format(beginDate));
	    sql.append("', 'yyyy-mm-dd') ");
		sql.append("    and t.fbizdate <= to_date('");
		sql.append(sdf.format(endDate));
	    sql.append("', 'yyyy-mm-dd') ");
		sql.append("    and t.fcompanyorgunitid = '");
		sql.append(companyID);
	    sql.append("'    and t.fsalepersonid = '");
	    sql.append(personInfo.getId().toString());
	    sql.append("'");
	    sql.append("    and t.fbasestatus in (4, 7) and te.FIsPresent = 0 ");
		sql.append(" group by tc.fid, tm.fid ");
		
		
		sql.append(" union select  ");

		sql.append("  tc.fid customerID, ");
		sql.append("  max(tc.fnumber) customerNumber, ");
		sql.append("  max(tc.fname_l2) customerName, ");
		sql.append("  tm.fid materialID, ");
		sql.append("  max(tm.fnumber) materialNumber, ");
		sql.append("  max(tm.fname_l2) materialName, ");
		sql.append("  max(tu.fid) unitID, ");
		sql.append("  max(tu.fnumber) unitNumber, ");
		sql.append("  max(tu.fname_l2) unitName, ");
		sql.append("  -sum(te.fbaseqty) saleQty, ");
		sql.append("  -sum(te.ftaxamount) taxAmount, ");
		sql.append("  -sum(te.famount) amount ");

		sql.append("   from T_SD_SaleReturns t ");
		sql.append("  inner join T_SD_SaleReturnsEntry te ");
		sql.append("     on t.fid = te.fparentid ");
		sql.append("  inner join t_bd_customer tc ");
		sql.append("     on t.FReturnsCustomerID = tc.fid ");
		sql.append("  inner join t_bd_material tm ");
		sql.append("     on te.fmaterialid = tm.fid ");
	    sql.append("  inner join t_bd_measureunit tu ");
		sql.append("     on tm.fbaseunit = tu.fid ");

	    sql.append("  where t.fbizdate >= to_date('");
	    sql.append(sdf.format(beginDate));
	    sql.append("', 'yyyy-mm-dd') ");
		sql.append("    and t.fbizdate <= to_date('");
		sql.append(sdf.format(endDate));
	    sql.append("', 'yyyy-mm-dd') ");
		sql.append("    and t.fcompanyorgunitid = '");
		sql.append(companyID);
	    sql.append("'    and t.fsalepersonid = '");
	    sql.append(personInfo.getId().toString());
	    sql.append("'");
	    sql.append("    and t.fbasestatus in (4, 7) and te.FIsPresent = 0 ");
		sql.append(" group by tc.fid, tm.fid) t group by t.customerID,materialID ");
		
//		 找不到物料标准成本的物料
//		StringBuilder noStandardMaterials = new StringBuilder();
		try{
			IRowSet rs = DbUtil.executeQuery(ctx, sql.toString());
			while(rs.next()){
				String customerID = rs.getString("customerID");
				String customerNumber = rs.getString("customerNumber");
				String customerName = rs.getString("customerName");
				String materialID = rs.getString("materialID");
				String materialNumber = rs.getString("materialNumber");
				String materialName = rs.getString("materialName");
				String unitID = rs.getString("unitID");
				String unitNumber = rs.getString("unitNumber");
				String unitName = rs.getString("unitName");
				
				BigDecimal saleQty = rs.getBigDecimal("saleQty");
				BigDecimal taxAmount = rs.getBigDecimal("taxAmount");
				BigDecimal amount = rs.getBigDecimal("amount");
				
				// 获取标准成本 
				MaterialStandardCostCostDetailEntryInfo costDetailEntry = costSets.get(materialID);
				if(costDetailEntry == null){
					throw new NoStandardSetException(materialName,year);
				}else{
					// 设置一个 毛利分录
					GrossProfitInfoEntryInfo entryInfo = new GrossProfitInfoEntryInfo();
					entryInfo.setParent(grossProfitInfo);
					// 物料
					MaterialInfo materialInfo = new MaterialInfo();
					materialInfo.setId(BOSUuid.read(materialID));
					materialInfo.setNumber(materialNumber);
					materialInfo.setName(materialName);
					entryInfo.setMaterial(materialInfo);
					// 客户
					CustomerInfo customerInfo = new CustomerInfo();
					customerInfo.setId(BOSUuid.read(customerID));
					customerInfo.setNumber(customerNumber);
					customerInfo.setName(customerName);
					entryInfo.setCustomer(customerInfo);
					// 计量单位
					MeasureUnitInfo unitInfo = new MeasureUnitInfo();
					unitInfo.setId(BOSUuid.read(unitID));
					unitInfo.setName(unitName);
					unitInfo.setNumber(unitNumber);
					
					entryInfo.setBaseUnit(unitInfo);
					
					entryInfo.setBaseQty(saleQty);
					entryInfo.setNoTaxAmount(amount);
					entryInfo.setTaxAmount(taxAmount);
					// 计算单价
					BigDecimal noTaxPrice = new BigDecimal(0);
					BigDecimal taxPrice = new BigDecimal(0);
					if(saleQty != null && saleQty.compareTo(new BigDecimal(0)) != 0){
						noTaxPrice = amount.divide(saleQty, 6, RoundingMode.HALF_UP);
						taxPrice = taxAmount.divide(saleQty, 6, RoundingMode.HALF_UP);
					}
					
					// 标准成本
					BigDecimal unitCost = costDetailEntry.getUnitCost();
					BigDecimal cost = saleQty.multiply(unitCost);
					
					BigDecimal profit = amount.subtract(cost);
					
					
					entryInfo.setTaxPrice(taxPrice);
					entryInfo.setNoTaxPrice(noTaxPrice);
					
					entryInfo.setUnitCost(unitCost);
					entryInfo.setAllCoat(cost);
					
					entryInfo.setGrossProfit(profit);
					
					allSaleNoTaxAmount = allSaleNoTaxAmount.add(amount);
					allSaleTaxAmount = allSaleTaxAmount.add(taxAmount);
					
					allSaleStandardCost = allSaleStandardCost.add(cost);
					// 累计到总毛利中
					allGrossProfit = allGrossProfit.add(profit);
					
					grossProfitInfo.getEntrys().add(entryInfo);
				}
				
				
			}
			
			// 设置总毛利
			grossProfitInfo.setAllGrossProfit(allGrossProfit);
			grossProfitInfo.setAllNoTaxAmount(allSaleNoTaxAmount);
			grossProfitInfo.setAllStandardCost(allSaleStandardCost);
			
			// 统计销售回款额 汇总值
			grossProfitInfo = getSalerRecAmount(ctx, grossProfitInfo, companyID, salerSetInfo.getSaler(), beginDate, endDate);
			
			// 统计销售回款明细
			// TODO 目前暂时取不到
			
			
		}catch(SQLException sqle){
			throw new BOSException(sqle);
		}
		IObjectPK pk = GrossProfitInfoFactory.getLocalInstance(ctx).save(grossProfitInfo);
		if(pk != null){
			grossProfitInfo.setId(BOSUuid.read(pk.toString()));
		}else{
			throw new BOSException("保存毛利出错");
		}
		return grossProfitInfo;
	}
	
	/**
	 * 获得销售员的 回款金额
	 * 从收款单 统计 销售员的回款总额   
	 * 销售回款明细 暂时无法统计 TODO
	 * @param ctx
	 * @param saler
	 * @param beginDate
	 * @param endDate
	 * @return
	 * @throws BOSException 
	 */
	private GrossProfitInfoInfo getSalerRecAmount(Context ctx, GrossProfitInfoInfo profitInfo,String companyID, PersonInfo saler, Date beginDate, Date endDate) throws BOSException{
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		// 累计收款单总金额
		StringBuilder sql = new StringBuilder("/*dialect*/");
		
		sql.append("select sum(te.factualamt) allRecAmount ");


		sql.append(" from  T_CAS_ReceivingBill t ");
		sql.append(" innerjoin T_CAS_ReceivingBillEntry te on t.fid = te.freceivingbillid ");
		sql.append(" where ");
		sql.append("  where t.fbizdate >= to_date('");
	    sql.append(sdf.format(beginDate));
	    sql.append("', 'yyyy-mm-dd') ");
		sql.append("    and t.fbizdate <= to_date('");
		sql.append(sdf.format(endDate));
	    sql.append("', 'yyyy-mm-dd') ");
		sql.append("    and t.fcompanyorgunitid = '");
		sql.append(companyID);
	    sql.append("'    and t.fsalepersonid = '");
	    sql.append(saler.getId().toString());
	    sql.append("'");
	    sql.append("    and t.fbasestatus in (4, 7) and te.FIsPresent = 0 ");
	    try{
	    	IRowSet rs = DbUtil.executeQuery(ctx, sql.toString());
	    	if(rs.next()){
	    		BigDecimal recAmount = rs.getBigDecimal("allRecAmount");
	    		// 设置月回款总额
	    		profitInfo.setMonthRecAmount(recAmount);
	    	}
	    }catch(SQLException sqle){
	    	throw new BOSException(sqle);
	    }
	    
		return profitInfo;
	}
	/**
	 * 获得指定公司的基本设置
	 */
	@Override
	protected SalePaymentSetInfo _getCompanySetInfo(Context ctx,
			String companyID) throws BOSException {
		
		EntityViewInfo ev = new EntityViewInfo();
		FilterInfo filter = new FilterInfo();
		
//		// 启用状态
//		FilterItemInfo filterItemBlockStatus = new FilterItemInfo("blockedStatus", BlockedStatusEnum.UNBLOCKED, CompareType.EQUALS);
//		filter.getFilterItems().add(filterItemBlockStatus);
		
		// 公司
		FilterItemInfo companyFi = new FilterItemInfo("company.id", companyID, CompareType.EQUALS);
		filter.getFilterItems().add(companyFi);
		
		ev.setFilter(filter);
		SalePaymentSetCollection mbpc = SalePaymentSetFactory.getLocalInstance(ctx).getSalePaymentSetCollection(ev);
		if (mbpc.size() < 1) {
		  return null;
		}
		return mbpc.get(0);
	}



	/**
	 * 获得销售员指标
	 */
	@Override
	protected IObjectCollection _getSalerTargetInfos(Context ctx, String companyTargetID)
			throws BOSException {
		EntityViewInfo view = new EntityViewInfo();
        FilterInfo filterInfo = new FilterInfo();
        CompanyOrgUnitInfo orgInfo = SysContext.getSysContext().getCurrentFIUnit();
        filterInfo.getFilterItems().add(new FilterItemInfo("companyTargetInfo.id",companyTargetID,CompareType.EQUALS));

//		SorterItemInfo sortItem = new SorterItemInfo("companyTargetInfo.number");
//		sortItem.setSortType(SortType.DESCEND);
//		view.getSorter().add(sortItem);
		view.setFilter(filterInfo);
		return SalerStimulateSetFactory.getLocalInstance(ctx).getSalerStimulateSetCollection(view);
	}
	/**
	 * 获取公司标准成本
	 * 
	 * 标准成本 按物料 逐个放到map中
	 * key为物料ID；value 为 标准设置明细
	 */
	@Override
	protected HashMap<String, MaterialStandardCostCostDetailEntryInfo> _getCompanyStandardCost(Context ctx, String companyID, int year)
			throws BOSException {
		HashMap<String, MaterialStandardCostCostDetailEntryInfo> costSets = new HashMap<String, MaterialStandardCostCostDetailEntryInfo>();
		try{
			EntityViewInfo view = new EntityViewInfo();
	        FilterInfo filterInfo = new FilterInfo();
	        CompanyOrgUnitInfo orgInfo = SysContext.getSysContext().getCurrentFIUnit();
	        filterInfo.getFilterItems().add(new FilterItemInfo("company.id",companyID,CompareType.EQUALS));
	        filterInfo.getFilterItems().add(new FilterItemInfo("year",year,CompareType.EQUALS));
	    	
	        filterInfo.getFilterItems().add(new FilterItemInfo("deletedStatus",DisableState.ENABLE_VALUE,CompareType.EQUALS));
	        
			
			view.setFilter(filterInfo);
			MaterialStandardCostCollection standardColl = MaterialStandardCostFactory.getLocalInstance(ctx).getMaterialStandardCostCollection(view);
			if (standardColl.size() < 1) {
			  return costSets;
			}else{
				MaterialStandardCostInfo standardSetInfo = standardColl.get(0);
				// 逐个分录放到map中
				MaterialStandardCostCostDetailEntryCollection detailInfos = standardSetInfo.getCostDetailEntry();
				if(detailInfos != null && detailInfos.size() > 0){
					// 逐个放到map中
					for(int i = 0; i < detailInfos.size(); i++){
						MaterialStandardCostCostDetailEntryInfo entryInfo = detailInfos.get(i);
						entryInfo = MaterialStandardCostCostDetailEntryFactory.getLocalInstance(ctx).getMaterialStandardCostCostDetailEntryInfo(new ObjectUuidPK(entryInfo.getId()));
						
						if(!costSets.containsKey(entryInfo.getMaterial().getId().toString())){
							// 将分录设置放到map中，key为materialID
							costSets.put(entryInfo.getMaterial().getId().toString(), entryInfo);
						}
					}
				}
			}
		
		}catch(Exception e){
			throw new BOSException(e);
		}
		return costSets;
	}
    
    
    
    
}