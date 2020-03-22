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
     * ���չ�˾ָ��������棬���ؽ��
     * ��ȡ��������Ȼ�����
     * ����ʱ
     * ���ȸ��ݹ�˾ָ���� ���е�����Աָ��
     * Ȼ���������Ա ����ָ����㣬���� ���� Ȼ�� ��������浽 ���������
     * ������ɺ��ܽ������
     */
	@Override
	protected SaleProfitResultInfo _calculateCompanyTarget(Context ctx,
			String companyID,
			String companyTargetID) throws BOSException {
		
		try{
			// ��˾ָ��
			CompanyTargetInfo companyTarget = CompanyTargetFactory.getLocalInstance(ctx).getCompanyTargetInfo(new ObjectUuidPK(companyTargetID));
			// ��ȡ��Ҫ������·��б�
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
			// ��ȡ��ʼ ���ںͽ�������
			Date beginDate = DateCommon.getMonthBeginDate(year, beginMonth);
			Date endDate = DateCommon.getMonthEndTime(year, endMonth);
			
			// ��ù�˾���۶�
			BigDecimal companyAllSaleAmount = getSaleAmount(ctx,companyID,null,beginDate,endDate);
			// ��û�������
			SalePaymentSetInfo companySetInfo = getCompanySetInfo(ctx, companyID);
			// ��õ���� ���ϱ�׼�ɱ�����
			HashMap<String, MaterialStandardCostCostDetailEntryInfo> costSets = getCompanyStandardCost(ctx, companyID,companyTarget.getYear());
			// �������Աָ������
			SalerStimulateSetCollection salerSetColl = (SalerStimulateSetCollection) getSalerTargetInfos(ctx, companyTargetID);
			if(salerSetColl != null && salerSetColl.size() > 0){
				// ������㱣����
				for(int i = 0; i < salerSetColl.size(); i++){
					SalerStimulateSetInfo salerSetInfo = salerSetColl.get(i);
					// ��ָ��
					salerSetInfo.setCompanyTargetInfo(companyTarget);
					// �������ã����¼�����,��� ������ ������Ϣ
					
					
					// ���Ȼ��ë����ϸ
					SaleProfitResultInfo profitResultInfo = getSaleGrossInfo(ctx, companyID, companySetInfo, salerSetInfo, costSets,year,beginMonth,endMonth);
					// ��˾�ܲ���˰���۶�
					profitResultInfo.setCompanyAllNoTaxAmount(companyAllSaleAmount);
					// �������Ա �����۶�
					BigDecimal salerNoTaxAmount = this.getSaleAmount(ctx, companyID, salerSetInfo.getSaler().getId().toString(), beginDate, endDate);
					
					
					// ���� ������ϸ�ͻ��� 
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
					
					// ���㳤��Ӧ�տ�
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
	 * ��ù�˾ ָ������ʱ�䷶Χ�ڵ����� �ܶ� (����˰���۶�)
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
	 * ��������Ա������ϸ �ͻ�����Ϣ�� �������
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
			// ������ ����Ա���� ���۷���ͳ���빫˾���۷��÷�̯
			// ���˷���ͳ��CT_SP_SaleFeeInput CT_SP_SaleFeeInputEntry
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
			// �������� ��¼
			while(prs.next()){
				String feeID = prs.getString("feeID");
				String feeNumber = prs.getString("feeNumber");
				String feeName = prs.getString("feeName");
				BigDecimal feeAmount = prs.getBigDecimal("feeAmount");
				
				// ������ϸ
				SaleProfitCalculateResultFeeEntryInfo feeEntryInfo = new SaleProfitCalculateResultFeeEntryInfo();
				FeeTypeInfo feeType = new FeeTypeInfo();
				feeType.setId(BOSUuid.read(feeID));
				feeType.setNumber(feeNumber);
				feeType.setName(feeName);
				
				feeEntryInfo.setFeeType(feeType);
				feeEntryInfo.setFeeAmount(feeAmount);
				feeEntryInfo.setIsShared(false);
				// ���ӵ���¼��ϸ��
				profitResultInfo.getFeeEntryInfos().add(feeEntryInfo);
			}
			
			// ��̯����ͳ��CT_SP_CompanyMonthFee CT_SP_CompanyMonthFeeEntry
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
						// ���˷�̯����  ��Ҫ��������̯
						personFee = feeAmount.multiply(salerNoTaxAmount).divide(allNoTaxAmount, RoundingMode.HALF_UP);
						
						// ������ϸ
						SaleProfitCalculateResultFeeEntryInfo feeEntryInfo = new SaleProfitCalculateResultFeeEntryInfo();
						FeeTypeInfo feeType = new FeeTypeInfo();
						feeType.setId(BOSUuid.read(feeID));
						feeType.setNumber(feeNumber);
						feeType.setName(feeName);
						
						feeEntryInfo.setFeeType(feeType);
						feeEntryInfo.setFeeAmount(personFee);
						feeEntryInfo.setIsShared(true);
						// ���ӵ���¼��ϸ��
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
	 * �������������
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
			
			// ���ð���ͳ�Ƶ����۶�  �ɱ� ��¼
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
			
			// �������۷��÷�¼
			List<SaleProfitCalculateResultFeeEntryInfo> feeEntrys = profitResultInfo.getFeeEntryInfos();
			for(int j = 0; j < feeEntrys.size(); j++){
				SaleProfitCalculateResultFeeEntryInfo feeDetailInfo = feeEntrys.get(j);
				feeDetailInfo.setParent(profitCalculateResult);
				profitCalculateResult.getFeeEntry().add(feeDetailInfo);
				
			}
			// ���������
			IObjectPK pk = SaleProfitCalculateResultFactory.getLocalInstance(ctx).addnew(profitCalculateResult);
			return pk;
		}
		
		return null;
		
	}
	/**
	 * ���ָ�� ����ָ��� ����ë��
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
			// ��ȡ����Ա������ϸ
			salerSetInfo = SalerStimulateSetFactory.getLocalInstance(ctx).getSalerStimulateSetInfo(new ObjectUuidPK(salerSetInfo.getId()));
			
			SaleProfitResultInfo profitResult = new SaleProfitResultInfo(salerSetInfo);
			
			profitResult.setCompanySetInfo(saleSetInfo);
			// ָ������
			profitResult.setCompanyTargetInfo(salerSetInfo.getCompanyTargetInfo());
			profitResult.setSalerSetInfo(salerSetInfo);
			
			
			
			
			// �����ۼ�
			for(int i = beginMonth; i <= endMonth; i++){
				
				GrossProfitInfoInfo monthGrossProfit = getCompanyMonthGrossProfit(ctx, companyID, costSets, salerSetInfo, year, i);
				// ��� �� ����������б���
				profitResult.addGrossProfitInfo(monthGrossProfit);
				// ������������ TODO
				
			}
			
			
			
			
			
			return profitResult;
		}else{
			return null;
		}
	}
	
	/**
	 * ��������� ������Ϣ�������������
	 */
	private void saveProfitResult(){
		
	}
	/**
	 * ��ȡָ�� ����ָ�� ָ������ �� ����ë������
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
		
		// ����Ա
		PersonInfo personInfo = salerSetInfo.getSaler();
		// �³�����
		Date beginDate = SalePaymentUtil.getFirstDayOfMonth(year, month-1);
		// ��ĩ����
		Date endDate = SalePaymentUtil.getLastDayOfMonth(year, month-1);
		
		// ����ë������ͷ��Ϣ
		grossProfitInfo.setBaseStatus(BillBaseStatusEnum.ADD);
		grossProfitInfo.setSaleStimulateInfo(salerSetInfo);
		grossProfitInfo.setCompany(salerSetInfo.getCompany());
		grossProfitInfo.setYear(year);
		grossProfitInfo.setMonth(month);
		grossProfitInfo.setIndexType(salerSetInfo.getIndexType());
		grossProfitInfo.setBizDate(new Date());
		grossProfitInfo.setQuarter(salerSetInfo.getQuarter());
		// TODO ��ë��
		BigDecimal allGrossProfit = new BigDecimal(0);
		BigDecimal allSaleNoTaxAmount = new BigDecimal(0);
		BigDecimal allSaleStandardCost = new BigDecimal(0);
		BigDecimal allSaleTaxAmount = new BigDecimal(0);
		BigDecimal allRecAmount = new BigDecimal(0);
		BigDecimal allRecGrossProfit = new BigDecimal(0);
		BigDecimal allRecStandardCost = new BigDecimal(0);
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		// ͳ������ 
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
		
//		 �Ҳ������ϱ�׼�ɱ�������
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
				
				// ��ȡ��׼�ɱ� 
				MaterialStandardCostCostDetailEntryInfo costDetailEntry = costSets.get(materialID);
				if(costDetailEntry == null){
					throw new NoStandardSetException(materialName,year);
				}else{
					// ����һ�� ë����¼
					GrossProfitInfoEntryInfo entryInfo = new GrossProfitInfoEntryInfo();
					entryInfo.setParent(grossProfitInfo);
					// ����
					MaterialInfo materialInfo = new MaterialInfo();
					materialInfo.setId(BOSUuid.read(materialID));
					materialInfo.setNumber(materialNumber);
					materialInfo.setName(materialName);
					entryInfo.setMaterial(materialInfo);
					// �ͻ�
					CustomerInfo customerInfo = new CustomerInfo();
					customerInfo.setId(BOSUuid.read(customerID));
					customerInfo.setNumber(customerNumber);
					customerInfo.setName(customerName);
					entryInfo.setCustomer(customerInfo);
					// ������λ
					MeasureUnitInfo unitInfo = new MeasureUnitInfo();
					unitInfo.setId(BOSUuid.read(unitID));
					unitInfo.setName(unitName);
					unitInfo.setNumber(unitNumber);
					
					entryInfo.setBaseUnit(unitInfo);
					
					entryInfo.setBaseQty(saleQty);
					entryInfo.setNoTaxAmount(amount);
					entryInfo.setTaxAmount(taxAmount);
					// ���㵥��
					BigDecimal noTaxPrice = new BigDecimal(0);
					BigDecimal taxPrice = new BigDecimal(0);
					if(saleQty != null && saleQty.compareTo(new BigDecimal(0)) != 0){
						noTaxPrice = amount.divide(saleQty, 6, RoundingMode.HALF_UP);
						taxPrice = taxAmount.divide(saleQty, 6, RoundingMode.HALF_UP);
					}
					
					// ��׼�ɱ�
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
					// �ۼƵ���ë����
					allGrossProfit = allGrossProfit.add(profit);
					
					grossProfitInfo.getEntrys().add(entryInfo);
				}
				
				
			}
			
			// ������ë��
			grossProfitInfo.setAllGrossProfit(allGrossProfit);
			grossProfitInfo.setAllNoTaxAmount(allSaleNoTaxAmount);
			grossProfitInfo.setAllStandardCost(allSaleStandardCost);
			
			// ͳ�����ۻؿ�� ����ֵ
			grossProfitInfo = getSalerRecAmount(ctx, grossProfitInfo, companyID, salerSetInfo.getSaler(), beginDate, endDate);
			
			// ͳ�����ۻؿ���ϸ
			// TODO Ŀǰ��ʱȡ����
			
			
		}catch(SQLException sqle){
			throw new BOSException(sqle);
		}
		IObjectPK pk = GrossProfitInfoFactory.getLocalInstance(ctx).save(grossProfitInfo);
		if(pk != null){
			grossProfitInfo.setId(BOSUuid.read(pk.toString()));
		}else{
			throw new BOSException("����ë������");
		}
		return grossProfitInfo;
	}
	
	/**
	 * �������Ա�� �ؿ���
	 * ���տ ͳ�� ����Ա�Ļؿ��ܶ�   
	 * ���ۻؿ���ϸ ��ʱ�޷�ͳ�� TODO
	 * @param ctx
	 * @param saler
	 * @param beginDate
	 * @param endDate
	 * @return
	 * @throws BOSException 
	 */
	private GrossProfitInfoInfo getSalerRecAmount(Context ctx, GrossProfitInfoInfo profitInfo,String companyID, PersonInfo saler, Date beginDate, Date endDate) throws BOSException{
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		// �ۼ��տ�ܽ��
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
	    		// �����»ؿ��ܶ�
	    		profitInfo.setMonthRecAmount(recAmount);
	    	}
	    }catch(SQLException sqle){
	    	throw new BOSException(sqle);
	    }
	    
		return profitInfo;
	}
	/**
	 * ���ָ����˾�Ļ�������
	 */
	@Override
	protected SalePaymentSetInfo _getCompanySetInfo(Context ctx,
			String companyID) throws BOSException {
		
		EntityViewInfo ev = new EntityViewInfo();
		FilterInfo filter = new FilterInfo();
		
//		// ����״̬
//		FilterItemInfo filterItemBlockStatus = new FilterItemInfo("blockedStatus", BlockedStatusEnum.UNBLOCKED, CompareType.EQUALS);
//		filter.getFilterItems().add(filterItemBlockStatus);
		
		// ��˾
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
	 * �������Աָ��
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
	 * ��ȡ��˾��׼�ɱ�
	 * 
	 * ��׼�ɱ� ������ ����ŵ�map��
	 * keyΪ����ID��value Ϊ ��׼������ϸ
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
				// �����¼�ŵ�map��
				MaterialStandardCostCostDetailEntryCollection detailInfos = standardSetInfo.getCostDetailEntry();
				if(detailInfos != null && detailInfos.size() > 0){
					// ����ŵ�map��
					for(int i = 0; i < detailInfos.size(); i++){
						MaterialStandardCostCostDetailEntryInfo entryInfo = detailInfos.get(i);
						entryInfo = MaterialStandardCostCostDetailEntryFactory.getLocalInstance(ctx).getMaterialStandardCostCostDetailEntryInfo(new ObjectUuidPK(entryInfo.getId()));
						
						if(!costSets.containsKey(entryInfo.getMaterial().getId().toString())){
							// ����¼���÷ŵ�map�У�keyΪmaterialID
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