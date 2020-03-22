package com.kingdee.eas.farm.rpt.app;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.Context;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.bos.db.TempTablePool;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.bos.metadata.entity.FilterInfo;
import com.kingdee.bos.metadata.entity.FilterItemInfo;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;
import com.kingdee.bos.metadata.query.util.CompareType;
import com.kingdee.eas.basedata.assistant.CurrencyFactory;
import com.kingdee.eas.basedata.assistant.CurrencyInfo;
import com.kingdee.eas.basedata.master.account.AccountViewCollection;
import com.kingdee.eas.basedata.master.account.AccountViewFactory;
import com.kingdee.eas.basedata.master.account.AccountViewInfo;
import com.kingdee.eas.basedata.org.CompanyOrgUnitCollection;
import com.kingdee.eas.basedata.org.CompanyOrgUnitFactory;
import com.kingdee.eas.basedata.org.CompanyOrgUnitInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.common.TableManagerFacadeFactory;
import com.kingdee.eas.fi.gl.GLReportJournalFacadeFactory;
import com.kingdee.eas.fi.gl.IGLReport;
import com.kingdee.eas.fi.gl.ReportConditionBase;
import com.kingdee.eas.fi.gl.ReportConditionJournal;
import com.kingdee.eas.fi.gl.ReportResultInfo;
import com.kingdee.eas.framework.report.CommRptBaseFactory;
import com.kingdee.eas.framework.report.util.PeriodEntity;
import com.kingdee.eas.framework.report.util.RptConditionManager;
import com.kingdee.eas.framework.report.util.RptConditionManager.ComponentStatus;
import com.kingdee.eas.util.app.DbUtil;
import com.kingdee.jdbc.rowset.IRowSet;

public class CapitalDailyRptFacadeControllerBean extends AbstractCapitalDailyRptFacadeControllerBean
{
	private static Logger logger =
        Logger.getLogger("com.kingdee.eas.farm.rpt.app.CapitalDailyRptFacadeControllerBean");


	 // 查询的公司
    private CompanyOrgUnitInfo currCommpany;
    // 查询开始日期
    private Date beginDate;
    // 查询结束日期
    private Date endDate;
    
    public void setCurrCommpany(CompanyOrgUnitInfo currCommpany) {
		this.currCommpany = currCommpany;
	}
	public CompanyOrgUnitInfo getCurrCommpany() {
		return currCommpany;
	}
	
	public void setBeginDate(Date beginDate) {
		this.beginDate = beginDate;
	}
	public Date getBeginDate() {
		return beginDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	
    /**
     * 获取查询结果
     */
	@Override
	protected HashMap _getCapitalDailyInfos(Context ctx, Date beginDate,
			Date endDate, String companyId) throws BOSException {
		this.beginDate = beginDate;
		this.endDate = endDate;
		
		//
		HashMap result = new HashMap();
		try{
			
			
			
			this.currCommpany = CompanyOrgUnitFactory.getLocalInstance(ctx).getCompanyOrgUnitInfo(new ObjectUuidPK(companyId));
			// 财务日报表远程 接口
			IGLReport iglReport  = this.getRptLocalInstance(ctx);
			// 获取查询结果
			ReportResultInfo reportResult = iglReport.findData(getGlCondition(ctx), 0, 100, null, this.getCurrCommpany(), false);
			ArrayList data = reportResult.getData();
			
			if(data != null && data.size() > 0){
				// 创建临时表
				String temptable = TableManagerFacadeFactory.getLocalInstance(ctx).getTableName("CapitalDailyRpt");
				createTempTable(ctx,temptable);
				result.put("temptable", temptable);
				
				//List<>
				// 循环整理数据到临时表
				StringBuffer sb = new StringBuffer();
				for(int i = 0; i < data.size(); i++){
					Object[] dataCase = (Object[]) data.get(i);
					
					CapitalDailyColumnBean columnCase = new CapitalDailyColumnBean();
					
					columnCase.setAccountName((String) dataCase[1]);
					columnCase.setAccountNumber((String) dataCase[0]);
					columnCase.setYestodayDer((String) dataCase[2]);
					columnCase.setYestodayBalance((BigDecimal) dataCase[3]);
					columnCase.setTodayDebit((BigDecimal) dataCase[4]);
					columnCase.setTodayCredit((BigDecimal) dataCase[5]);
					columnCase.setTodayDer((String) dataCase[6]);
					columnCase.setTodayBalance((BigDecimal) dataCase[7]);
					columnCase.setDebitCount((Integer) (dataCase[8]== null?0:dataCase[8]));
					columnCase.setCreditCount((Integer) (dataCase[9]== null?0:dataCase[9]));
					
					// 添加到insert语句中
					sb.append(getInsertSql(temptable, columnCase));
					
					if(i != (data.size() - 1)){
						sb.append(";");
					}
					
				}
				// 执行插入语句 生成临时表数据
				DbUtil.execute(ctx, sb.toString());
				
				IRowSet rs = DbUtil.executeQuery(ctx, "select * from "+ temptable +" order by FAccountNumber ");
				result.put("rowset", rs);
				
//				DbUtil.executeBatch(ctx, sql, paramsList)
			}
		}catch(Exception e){
			e.printStackTrace();
			throw new BOSException(e);
		}
		return result;
//		return super._getCapitalDailyInfos(ctx, beginDate, endDate, companyId);
	}
	/**
	 * 获得插入语句
	 * @param tempTableName
	 * @param columnCase
	 * @return
	 */
	private String getInsertSql(String tempTableName,CapitalDailyColumnBean columnCase){
		 StringBuffer sql = new StringBuffer();
		 sql.append("insert into ");
		 sql.append(tempTableName);
		 sql.append(" values('");
		 sql.append(columnCase.getCompanyNumber());
		 sql.append("','");
		 sql.append(columnCase.getCompanyName());
		 sql.append("','");
		 sql.append(columnCase.getAccountNumber());
		 sql.append("','");
		 sql.append(columnCase.getAccountName());
		 sql.append("','");
		 sql.append(columnCase.getYestodayDer());
		 sql.append("',");
		 sql.append(columnCase.getYestodayBalance().toPlainString());
		 sql.append(",'");
		 sql.append(columnCase.getTodayDer());
		 sql.append("',");
		 sql.append(columnCase.getTodayDebit().toPlainString());
		 sql.append(",");
		 sql.append(columnCase.getTodayCredit().toPlainString());
		 sql.append(",");
		 sql.append(columnCase.getTodayBalance().toPlainString());
		 sql.append(",");
		 sql.append(columnCase.getDebitCount());
		 sql.append(",");
		 sql.append(columnCase.getCreditCount());
		 sql.append(",0)");
		  
		 return sql.toString();
	}
	/**
	 * 创建临时表
	 * @param ctx
	 * @return
	 * @throws Exception 
	 */
	private void createTempTable(Context ctx,String temptableName) throws Exception{
		 TableManagerFacadeFactory.getLocalInstance(ctx).createTempTable(getTempTableCreateSql(temptableName));
	}
	
	/**
	 * 临时表建表语句
	 * @return
	 */
	private String getTempTableCreateSql(String temptableName)
	{
	  StringBuffer sql = new StringBuffer();
	  sql.append("create table ");
	  sql.append(temptableName);
	  sql.append("( FCompanyNumber varchar(44), \r\n");
	  sql.append(" FCompanyName varchar(80), \r\n");
	  sql.append(" FAccountNumber varchar(44), \r\n");
	  sql.append(" FAccountName varchar(44), \r\n");
	  sql.append(" FYestodayDer VARCHAR(44), \r\n");
	  sql.append(" FYestodayBalance DECIMAL(28,10), \r\n");
	  sql.append(" FTodayDer VARCHAR(44), \r\n");
	  sql.append(" FTodayDebit DECIMAL(28,10), \r\n");
	  sql.append(" FTodayCredit DECIMAL(28,10), \r\n");
	  sql.append(" FTodayBalance DECIMAL(28,10), \r\n");
	  sql.append(" FDebitCount INT, \r\n");
	  sql.append(" FCreditCount INT, \r\n");
	  sql.append(" FNumber INT ");
	  sql.append(" )");
	  return sql.toString();
	}
	
	/**
	 * 获取 本地接口
	 * @return
	 * @throws BOSException
	 */
	protected IGLReport getRptLocalInstance(Context ctx) throws BOSException
	{
	     return GLReportJournalFacadeFactory.getLocalInstance(ctx);
	}
	
	
	/**
	 * 获取查询条件
	 * @return
	 * @throws BOSException 
	 * @throws EASBizException 
	 */
	public EntityViewInfo getGlCondition(Context ctx) throws EASBizException, BOSException
	{
	  EntityViewInfo evi = new EntityViewInfo();
	    
	  
	  evi.setFilter(new FilterInfo());
	  evi.put("companyId", this.getCurrCommpany().getId().toString());
	  evi.put("company", this.getCurrCommpany());
	  evi.put("selector", new SelectorItemCollection());
	  evi.put("filter", new FilterInfo());
//	  evi.set
	  // 获得查询条件
	  ReportConditionBase cond = this.getCustomCondition(ctx);

	  evi.put("GLFixCondition", cond);
	  
	
//	  return this.condition;
	  return evi;
	}
	
	
	/**
	 * 
	 * @return
	 * @throws BOSException 
	 * @throws EASBizException 
	 */
	public ReportConditionJournal getCustomCondition(Context ctx) throws EASBizException, BOSException
	{
	  ReportConditionJournal condition = new ReportConditionJournal();

	  Map hm = new HashMap();
	  // 设置界面控件状态
	  hm.put("RptCondition", this.setComponentsStatusManager(ctx));
	  hm.put("company", this.getCurrCommpany());
//	  PeriodEntity  periodEntity =  PeriodEntity.requestPeriodEntity(this.getCurrCommpany());
	  PeriodEntity  periodEntity = new PeriodEntity(CommRptBaseFactory.getLocalInstance(ctx).getPeriodRange(this.getCurrCommpany()));
	  hm.put("periodEntity",periodEntity);
	  condition.setExpandInfo(hm);

	  Date beginDate = this.getBeginDate();
	  if(beginDate == null){
		  beginDate = new Date();
	  }
	  Date endDate = this.getEndDate();
	  if(endDate == null){
		  endDate = new Date();
	  }
	  condition.setDateBegin(beginDate);
	  condition.setDateEnd(endDate);


	  condition.setAccountLevelStart(1);


	  condition.setAccountLevelEnd(3);


	  condition.setAccountCodeStart("1001");


	  condition.setAccountCodeEnd("1012");
	 
	   

	 
      condition.setCurrencyID("dfd38d11-00fd-1000-e000-1ebdc0a8100dDEB58FDC");
      condition.setCurrencyName("人民币");
	  CompanyOrgUnitInfo companyInfo = this.getCurrCommpany();
	  if(companyInfo == null){
		  // 默认食品厂
		  companyInfo = new CompanyOrgUnitInfo();
		  companyInfo.setId(new ObjectUuidPK("at4AAAAAAHDM567U").getKeyValue());
	  }
	  condition.getExpandInfo().put("company", companyInfo);


	  condition.setOptionPosting(true);


	  condition.setOptionNOTDisplayIfNoAmount(false);


	  condition.setOptionNOTDisplayIfBalanceZero(false);


	  condition.setOptionShowTotal(false);

	  condition.setNewQuery(true);
	  condition.setOptionShowAsstItem(false);
	  condition.setExpandCompanyLevel(1);

	  return condition;
	}
	/**
	 * 获得 RptConditionManager
	 * @param hm
	 * @return
	 * @throws BOSException 
	 * @throws EASBizException 
	 */
	private RptConditionManager setComponentsStatusManager(Context ctx) throws EASBizException, BOSException{
		
		HashMap componentStatusMap = new HashMap();
		
		ComponentStatus spnAccountLevelEnd = new ComponentStatus();
		spnAccountLevelEnd.setName("spnAccountLevelEnd");
		spnAccountLevelEnd.setEnabled(true);
		spnAccountLevelEnd.setValue(1);
		componentStatusMap.put("spnAccountLevelEnd", spnAccountLevelEnd);
		
		ComponentStatus chkIncludeNoAmount = new ComponentStatus();
		chkIncludeNoAmount.setName("chkIncludeNoAmount");
		chkIncludeNoAmount.setEnabled(true);
		chkIncludeNoAmount.setValue(false);
		componentStatusMap.put("chkIncludeNoAmount", chkIncludeNoAmount);
		
		ComponentStatus dateDateBegin = new ComponentStatus();
		dateDateBegin.setName("dateDateEnd");
		dateDateBegin.setEnabled(true);
		dateDateBegin.setValue(this.getBeginDate());
		componentStatusMap.put("dateDateBegin", dateDateBegin);
		
		ComponentStatus dateDateEnd = new ComponentStatus();
		dateDateEnd.setName("dateDateEnd");
		dateDateEnd.setEnabled(true);
		dateDateEnd.setValue(this.getEndDate());
		componentStatusMap.put("dateDateEnd", dateDateEnd);
		
		
		ComponentStatus chkIncludeNotPosting = new ComponentStatus();
		chkIncludeNotPosting.setName("chkIncludeNotPosting");
		chkIncludeNotPosting.setEnabled(true);
		chkIncludeNotPosting.setValue(true);
		componentStatusMap.put("chkIncludeNotPosting", chkIncludeNotPosting);
		
		// 开始科目 1001 库存现金

//		fi.getf
		// 开始科目 1001 库存现金
		EntityViewInfo evi = new EntityViewInfo();
		FilterInfo fi = new FilterInfo();
		fi.getFilterItems().add(new FilterItemInfo("accountTableID","at4AAAAAVfQXaY5t",CompareType.EQUALS));
		fi.getFilterItems().add(new FilterItemInfo("accountTypeID","at4AAAAAVf2dqOy7",CompareType.EQUALS));
		fi.getFilterItems().add(new FilterItemInfo("companyID",this.currCommpany.getId().toString(),CompareType.EQUALS));
		fi.getFilterItems().add(new FilterItemInfo("number","1001",CompareType.EQUALS));
		evi.setFilter(fi);
		AccountViewCollection avCol = AccountViewFactory.getLocalInstance(ctx).getAccountViewCollection(evi);
		AccountViewInfo beginAvInfo = null;
		if(avCol != null && avCol.size() > 0){
			beginAvInfo = avCol.get(0);
		}
//		if(beginAvInfo == null){
//			// 食品厂  1001 库存现金
//			if(this.currCommpany != null && "4".equals(this.currCommpany.getNumber())){
//				beginAvInfo = AccountViewFactory.getLocalInstance(ctx).getAccountViewInfo(new ObjectUuidPK("kAkiJRgtSmeG+uKf2Tedzp2pmCY="));
//			}
//			// 养殖厂  1001 库存现金
//			if(this.currCommpany != null && "3".equals(this.currCommpany.getNumber())){
//				beginAvInfo = AccountViewFactory.getLocalInstance(ctx).getAccountViewInfo(new ObjectUuidPK("w0fDTTKKQ7WBF2SbFhwCoJ2pmCY="));
//			}
//			// 本部  1001 库存现金
//			if(this.currCommpany != null && "2".equals(this.currCommpany.getNumber())){
//				beginAvInfo = AccountViewFactory.getLocalInstance(ctx).getAccountViewInfo(new ObjectUuidPK("5IS5blFYQwGek0MnkdYPop2pmCY="));
//			}
//		}
		
		ComponentStatus prbAccountBegin = new ComponentStatus();
		prbAccountBegin.setName("prbAccountBegin");
		prbAccountBegin.setEnabled(true);
		prbAccountBegin.setValue(beginAvInfo);
		
		
		componentStatusMap.put("prbAccountBegin", prbAccountBegin);
		// 结束科目  1012
		
		// 开始科目 1001 库存现金
		 evi = new EntityViewInfo();
		 fi = new FilterInfo();
		fi.getFilterItems().add(new FilterItemInfo("accountTableID","at4AAAAAVfQXaY5t",CompareType.EQUALS));
		fi.getFilterItems().add(new FilterItemInfo("accountTypeID","at4AAAAAVf2dqOy7",CompareType.EQUALS));
		fi.getFilterItems().add(new FilterItemInfo("companyID",this.currCommpany.getId().toString(),CompareType.EQUALS));
		fi.getFilterItems().add(new FilterItemInfo("number","1012",CompareType.EQUALS));
		evi.setFilter(fi);
		 avCol = AccountViewFactory.getLocalInstance(ctx).getAccountViewCollection(evi);
		AccountViewInfo endAccount = null;
		if(avCol != null && avCol.size() > 0){
			endAccount = avCol.get(0);
		}
		
		ComponentStatus prbAccountEnd = new ComponentStatus();
		prbAccountEnd.setName("prbAccountEnd");
		prbAccountEnd.setEnabled(true);
		prbAccountEnd.setValue(endAccount);
		componentStatusMap.put("prbAccountEnd", prbAccountEnd);
		
		
		// 币别
		CurrencyInfo currency = CurrencyFactory.getLocalInstance(ctx).getCurrencyInfo(new ObjectUuidPK("dfd38d11-00fd-1000-e000-1ebdc0a8100dDEB58FDC"));
		ComponentStatus cmbCurrency = new ComponentStatus();
		cmbCurrency.setName("cmbCurrency");
		cmbCurrency.setEnabled(true);
		cmbCurrency.setValue(currency);
		componentStatusMap.put("cmbCurrency", cmbCurrency);
		
		ComponentStatus chkShowAsstItem = new ComponentStatus();
		chkShowAsstItem.setName("chkShowAsstItem");
		chkShowAsstItem.setEnabled(true);
		chkShowAsstItem.setValue(false);
		componentStatusMap.put("chkShowAsstItem", chkShowAsstItem);
		
		ComponentStatus tfCompany = new ComponentStatus();
		tfCompany.setName("tfCompany");
		tfCompany.setEnabled(true);
		tfCompany.setValue(this.getCurrCommpany());
		componentStatusMap.put("tfCompany", tfCompany);
		
		ComponentStatus chkIncludeTotal = new ComponentStatus();
		chkIncludeTotal.setName("chkIncludeTotal");
		chkIncludeTotal.setEnabled(true);
		chkIncludeTotal.setValue(false);
		componentStatusMap.put("chkIncludeTotal", chkIncludeTotal);
		
		ComponentStatus spnAccountLevelBegin = new ComponentStatus();
		spnAccountLevelBegin.setName("spnAccountLevelBegin");
		spnAccountLevelBegin.setEnabled(true);
		spnAccountLevelBegin.setValue(1);
		componentStatusMap.put("spnAccountLevelBegin", spnAccountLevelBegin);
		
//		ComponentStatus bpAccount = new ComponentStatus();
//		bpAccount.setName("bpAccount");
//		bpAccount.setEnabled(true);
//		bpAccount.setValue(this.getCurrCommpany());
//		componentStatusMap.put("bpAccount", bpAccount);
		
		ComponentStatus chkBalanceZero = new ComponentStatus();
		chkBalanceZero.setName("chkBalanceZero");
		chkBalanceZero.setEnabled(true);
		chkBalanceZero.setValue(false);
		componentStatusMap.put("chkBalanceZero", chkBalanceZero);
		
		
		
		
		RptConditionManager rc = new RptConditionManager(componentStatusMap);

	
		  
		return rc;
	}
	
	
	/**
	 * 获取所有公司的 资金日报
	 */
	@Override
	protected HashMap _getAllCompanysCapitalDailyInfos(Context ctx,
			Date beginDate, Date endDate,int isGather,String capitalType) throws BOSException {
		HashMap result = new HashMap();
		
		this.setBeginDate(beginDate);
		this.setEndDate(endDate);
		
		try{
			// 创建临时表
			String temptable = TableManagerFacadeFactory.getLocalInstance(ctx).getTableName("CapitalDailyRpt");
			createTempTable(ctx,temptable);
			result.put("temptable", temptable);
			CompanyOrgUnitCollection couCol = CompanyOrgUnitFactory.getLocalInstance(ctx).getCompanyOrgUnitCollection();
			// 
			// 循环整理数据到临时表
			StringBuffer sb = new StringBuffer();
			for(int j = 0;j < couCol.size(); j++){
				
				
	
				
				this.currCommpany = CompanyOrgUnitFactory.getLocalInstance(ctx).getCompanyOrgUnitInfo(new ObjectUuidPK(couCol.get(j).getId()));
				
				if("北大荒宝泉岭农牧发展有限公司".equals(currCommpany.getName()) || "测试公司".equals(currCommpany.getName())){
					continue;
				}
				// 财务日报表远程 接口
				IGLReport iglReport  = this.getRptLocalInstance(ctx);
				// 获取查询结果
				ReportResultInfo reportResult = iglReport.findData(getGlCondition(ctx), 0, 100, null, this.getCurrCommpany(), false);
				ArrayList data = reportResult.getData();
				
				if(data != null && data.size() > 0){
					//List<>
					
					for(int i = 0; i < data.size(); i++){
						Object[] dataCase = (Object[]) data.get(i);
						
						CapitalDailyColumnBean columnCase = new CapitalDailyColumnBean();
						columnCase.setCompanyName(this.currCommpany.getName());
						columnCase.setCompanyNumber(this.currCommpany.getNumber());
						columnCase.setAccountName((String) dataCase[1]);
						columnCase.setAccountNumber((String) dataCase[0]);
						columnCase.setYestodayDer((String) dataCase[2]);
						columnCase.setYestodayBalance((BigDecimal) dataCase[3]);
						columnCase.setTodayDebit((BigDecimal) dataCase[4]);
						columnCase.setTodayCredit((BigDecimal) dataCase[5]);
						columnCase.setTodayDer((String) dataCase[6]);
						columnCase.setTodayBalance((BigDecimal) dataCase[7]);
						columnCase.setDebitCount((Integer) (dataCase[8]== null?0:dataCase[8]));
						columnCase.setCreditCount((Integer) (dataCase[9]== null?0:dataCase[9]));
						
						// 添加到insert语句中
						sb.append(getInsertSql(temptable, columnCase));
						
//						if(i != (data.size() - 1)){
							sb.append(";");
//						}
						
					}
					
					
					
				
					
	//				DbUtil.executeBatch(ctx, sql, paramsList)
				}
			}
			// 执行插入操作
			// 执行插入语句 生成临时表数据
			DbUtil.execute(ctx, sb.substring(0, sb.length()-1).toString());
			IRowSet rs = null;
			if(1 == isGather){
//				 sql.append("( FCompanyNumber varchar(44), \r\n");
//				  sql.append(" FCompanyName varchar(80), \r\n");
//				  sql.append(" FAccountNumber varchar(44), \r\n");
//				  sql.append(" FAccountName varchar(44), \r\n");
//				  sql.append(" FYestodayDer VARCHAR(44), \r\n");
//				  sql.append(" FYestodayBalance DECIMAL(28,10), \r\n");
//				  sql.append(" FTodayDer VARCHAR(44), \r\n");
//				  sql.append(" FTodayDebit DECIMAL(28,10), \r\n");
//				  sql.append(" FTodayCredit DECIMAL(28,10), \r\n");
//				  sql.append(" FTodayBalance DECIMAL(28,10), \r\n");
//				  sql.append(" FDebitCount INT, \r\n");
//				  sql.append(" FCreditCount INT, \r\n");
//				  sql.append(" FNumber INT ");
//				  sql.append(" )");
				  
				 StringBuffer searchsb = new StringBuffer();
				 searchsb.append("select '1' FCompanyNumber,'北大荒宝泉岭农牧发展有限公司' FCompanyName ,FAccountNumber,");
				 searchsb.append("max(FAccountName) FAccountName,");
				 searchsb.append("max(FYestodayDer) FYestodayDer,");
				 searchsb.append("sum(FYestodayBalance) FYestodayBalance,");
				 searchsb.append("max(FTodayDer) FTodayDer,");
				 searchsb.append("sum(FTodayDebit) FTodayDebit,");
				 searchsb.append("sum(FTodayCredit) FTodayCredit,");
				 searchsb.append("sum(FTodayBalance) FTodayBalance,");
				 searchsb.append("sum(FDebitCount) FDebitCount,");
				 searchsb.append("sum(FCreditCount) FCreditCount,");
				 searchsb.append("sum(FNumber) FNumber from ");
				 searchsb.append(temptable);
				 searchsb.append(" where FAccountNumber in('1001','1002','1012') ");
				 if("1".equals(capitalType)){
					 searchsb.append(" and (FTodayBalance is not null and FTodayBalance > 0) ");
				 }else if("2".equals(capitalType)){
					 searchsb.append(" and ((FTodayDebit is not null and FTodayDebit > 0) or (FTodayCredit is not null and FTodayCredit > 0)) ");
				 }
				 searchsb.append(" group by FAccountNumber order by FAccountNumber ,FCompanyNumber");
				 rs = DbUtil.executeQuery(ctx, searchsb.toString());
			}else{
				StringBuffer searchsb = new StringBuffer();
				searchsb.append("select * from ");
				searchsb.append(temptable);
				 if("1".equals(capitalType)){
					 searchsb.append(" where FTodayBalance is not null and FTodayBalance > 0 ");
				 }else if("2".equals(capitalType)){
					 searchsb.append(" where (FTodayDebit is not null and FTodayDebit > 0) or (FTodayCredit is not null and FTodayCredit > 0) ");
				 }
				searchsb.append(" order by FAccountNumber,FCompanyNumber ");
				rs = DbUtil.executeQuery(ctx, searchsb.toString());
				
				
			}
			result.put("rowset", rs);
			return result;
		}catch(Exception e){
			e.printStackTrace();
			throw new BOSException(e);
		}
			
	
		
	
		
	}
	/**
	 * 清理临时表
	 */
    @Override
	protected void _releaseTempTable(Context ctx, String temptableName)
			throws BOSException {
		if(StringUtils.isNotEmpty(temptableName)){
			TempTablePool.getInstance(ctx).releaseTable(temptableName);
		}
	}

	
}