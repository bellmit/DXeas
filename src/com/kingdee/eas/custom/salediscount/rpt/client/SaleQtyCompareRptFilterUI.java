/**
 * output package name
 */
package com.kingdee.eas.custom.salediscount.rpt.client;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.log4j.Logger;

import com.kingdee.bos.ctrl.swing.event.DataChangeEvent;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.bos.metadata.entity.FilterInfo;
import com.kingdee.bos.metadata.entity.FilterItemInfo;
import com.kingdee.bos.metadata.query.util.CompareType;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.eas.basedata.master.cssp.CSSPGroupInfo;
import com.kingdee.eas.basedata.master.cssp.CustomerInfo;
import com.kingdee.eas.basedata.master.cssp.client.F7CustomerTreeDetailListUI;
import com.kingdee.eas.basedata.org.CompanyOrgUnitInfo;
import com.kingdee.eas.basedata.org.OrgType;
import com.kingdee.eas.common.client.SysContext;
import com.kingdee.eas.framework.report.util.RptParams;
import com.kingdee.eas.scm.common.client.GeneralKDPromptSelectorAdaptor;
import com.kingdee.eas.scm.common.constants.QueryInfoConstants;
import com.kingdee.eas.util.SysUtil;
import com.kingdee.eas.util.client.MsgBox;

/**
 * output class name
 */
public class SaleQtyCompareRptFilterUI extends AbstractSaleQtyCompareRptFilterUI
{
    private static final Logger logger = CoreUIObject.getLogger(SaleQtyCompareRptFilterUI.class);
    
    /**
     * output class constructor
     */
    public SaleQtyCompareRptFilterUI() throws Exception
    {
        super();
    }

    /**
     * output storeFields method
     */
    public void storeFields()
    {
        super.storeFields();
    }
    

   
    /**
     * 数据校验
     */
    @Override
	public boolean verify() {
    	if(this.prmtCompany.getValue()==null){
			MsgBox.showWarning("请选择公司！");
			SysUtil.abort();
		}
    	
//    	if(this.prmtPeriod.getValue() == null){
//    		MsgBox.showWarning("请选择期间！");
//			SysUtil.abort();
//    	}
    	
    	if(this.dpCurrBeginDate.getSqlDate() == null){
    		MsgBox.showWarning("请选择当期开始时间！");
			SysUtil.abort();
    	}
    	if(this.dpCurrEndDate.getSqlDate() == null){
    		MsgBox.showWarning("请选择当期结束时间！");
			SysUtil.abort();
    	}
    	if(this.dpLastBeginDate.getSqlDate() == null){
    		MsgBox.showWarning("请选择上期开始时间！");
			SysUtil.abort();
    	}
    	if(this.dpLastEndDate.getSqlDate() == null){
    		MsgBox.showWarning("请选择上期结束时间！");
			SysUtil.abort();
    	}
    	return true;
	}

	@Override
	public RptParams getCustomCondition() {
		// TODO Auto-generated method stub
		RptParams pp = new RptParams();	
		String companyID = null;
		String saleGroupId = null;
		String periodID = null;
		if(this.prmtCompany.getValue()!=null){
			companyID=((CompanyOrgUnitInfo)this.prmtCompany.getValue()).getId().toString();
		}else{
			MsgBox.showWarning("请选择公司！");
			SysUtil.abort();
		}
		if(this.prmtSaleGroup.getValue()!=null) {
			saleGroupId=((CustomerInfo)this.prmtSaleGroup.getValue()).getId().toString();
		}
		
//		periodID = ((PeriodInfo)this.prmtPeriod.getValue()).getId().toString();
//		
//		PeriodInfo periodInfo = (PeriodInfo)this.prmtPeriod.getValue();
//		Date beginDate = periodInfo.getBeginDate();
//		Date endDate = periodInfo.getEndDate();
//		
//		Calendar cal = Calendar.getInstance();
//		cal.setTime(beginDate);
//		
//		cal.add(Calendar.MONTH, -1);
//		// 上月第一天
//		Date lastBeginDate = cal.getTime();
//		
//		cal.set(Calendar.DAY_OF_MONTH, cal.getActualMaximum(Calendar.DAY_OF_MONTH));
//		// 上月最后一天
//		Date lastEndDate = cal.getTime();
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//		String beginDateStr = sdf.format(beginDate);
//		String endDateStr = sdf.format(endDate);
//		String lastBeginDateStr = sdf.format(lastBeginDate);
//		String lastEndDateStr = sdf.format(lastEndDate);
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String beginDateStr = sdf.format(this.dpCurrBeginDate.getSqlDate());
		String endDateStr = sdf.format(this.dpCurrEndDate.getSqlDate());
		String lastBeginDateStr = sdf.format(this.dpLastBeginDate.getSqlDate());
		String lastEndDateStr = sdf.format(this.dpLastEndDate.getSqlDate());
		
		pp.setString("beginDateStr", beginDateStr);
		pp.setString("endDateStr", endDateStr);
		pp.setString("lastBeginDateStr", lastBeginDateStr);
		pp.setString("lastEndDateStr", lastEndDateStr);
		
		pp.setString("saleGroupId", saleGroupId);
		pp.setString("companyID",companyID);
		pp.setString("periodID", periodID);
		
		pp.setObject("company", this.prmtCompany.getValue());
//		pp.setObject("period", periodInfo);
		
		return pp;
	}

	@Override
	public void onInit(RptParams arg0) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setCustomCondition(RptParams params) {
		// TODO Auto-generated method stub
//		this.prmtCompany.setData(params.getObject("CU"));
	}

	@Override
	public void onLoad() throws Exception {
		// TODO Auto-generated method stub
		super.onLoad();
		this.setF7();
	}
	public void setF7() throws Exception {
//		CompanyF7 org = new CompanyF7(this);
//		org.disablePerm();
//		org.setIsCUFilter(false);
//		this.prmtCompany.setSelector(org);
//		this.prmtCompany.setData(SysContext.getSysContext().getCurrentCompany());
		String cuId=SysContext.getSysContext().getCurrentFIUnit().getId().toString();
		this.prmtCompany.setQueryInfo("com.kingdee.eas.basedata.org.app.CompanyOrgUnitQuery");		
        this.prmtCompany.setVisible(true);		
        this.prmtCompany.setEditable(false);		
        this.prmtCompany.setDisplayFormat("$name$");		
        this.prmtCompany.setEditFormat("$number$");		
        this.prmtCompany.setCommitFormat("$number$");		
        this.prmtCompany.setRequired(true);



		CompanyOrgUnitInfo companyInfo = SysContext.getSysContext().getCurrentFIUnit(); 
		
		this.prmtCompany.setValue(companyInfo);
		
		
		EntityViewInfo evi = new EntityViewInfo();
		FilterInfo filterInfo = new FilterInfo();
		// 添加财务组织条件
		filterInfo.getFilterItems().add(new FilterItemInfo("companyOrgUnit.id", companyInfo.getId().toString(), CompareType.EQUALS));
		evi.setFilter(filterInfo);
	    // 设置F7查询元数据
		String queryInfo = QueryInfoConstants.CUSTOMER_COMPANY_STANDARD;
		// 设置主业务组织
	    prmtSaleGroup.setCurrentMainBizOrgUnit(companyInfo, OrgType.Company);
		// 设置客户F7的过滤条件
	    prmtSaleGroup.setEntityViewInfo(evi);
	    prmtSaleGroup.setCommitFormat("$number$");//提交格式
	    prmtSaleGroup.setDisplayFormat("$number$");//显示格式
	    prmtSaleGroup.setEditFormat("$number$");//编辑格式
	    prmtSaleGroup.setEnabledMultiSelection(false);
		// 设置客户F7展现形式为左树右表
		GeneralKDPromptSelectorAdaptor selectorAdaptor = new GeneralKDPromptSelectorAdaptor(prmtSaleGroup,
				F7CustomerTreeDetailListUI.class.getName(), 
				this,
				CSSPGroupInfo.getBosType(),
				queryInfo, 
				"browseGroup.id", 
				"companyOrgUnit.id");
		selectorAdaptor.setIsMultiSelect(false);
		prmtSaleGroup.setSelector(selectorAdaptor);
		prmtSaleGroup.addSelectorListener(selectorAdaptor);
		

		
		//期间
        this.prmtPeriod.setQueryInfo("com.kingdee.eas.basedata.assistant.app.F7PeriodQuery");
        this.prmtPeriod.setVisible(true);
        this.prmtPeriod.setEditable(true);
        this.prmtPeriod.setDisplayFormat("$number$");
        this.prmtPeriod.setEditFormat("$number$");
        this.prmtPeriod.setCommitFormat("$number$");
        this.prmtPeriod.setRequired(true);
        this.prmtPeriod.setEnabled(true);
        this.prmtPeriod.setForeground(new java.awt.Color(0,0,0));
		
        
        
        
        
        
        
        
//    	
//		periodID = ((PeriodInfo)this.prmtPeriod.getValue()).getId().toString();
//		
//		PeriodInfo periodInfo = (PeriodInfo)this.prmtPeriod.getValue();
//		Date beginDate = periodInfo.getBeginDate();
//		Date endDate = periodInfo.getEndDate();
		
		
		Date nowDate = new Date();
		
		Calendar cal = Calendar.getInstance();
		cal.setTime(nowDate);
		cal.set(Calendar.DATE, 1);
		
		Date currBeginDate = cal.getTime();
		
		this.dpCurrBeginDate.setValue(currBeginDate);
		this.dpCurrEndDate.setValue(nowDate);
		
		
//        Date nowDate = new Date();
//		Calendar cal = Calendar.getInstance();
//		cal.setTime(beginDate);
		
		
//		cal.add(Calendar.MONTH, -1);
//		// 上月第一天
//		Date lastBeginDate = cal.getTime();
//		
//		cal.set(Calendar.DAY_OF_MONTH, cal.getActualMaximum(Calendar.DAY_OF_MONTH));
//		// 上月最后一天
//		Date lastEndDate = cal.getTime();
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//		String beginDateStr = sdf.format(beginDate);
//		String endDateStr = sdf.format(endDate);
//		String lastBeginDateStr = sdf.format(lastBeginDate);
//		String lastEndDateStr = sdf.format(lastEndDate);
		
		
	}

	/**
	 * 当月开始时间
	 */
	@Override
	protected void dpCurrBeginDate_dataChanged(DataChangeEvent e)
			throws Exception {
		Date beginDate = this.dpCurrBeginDate.getSqlDate();
		if(beginDate != null){
			Calendar cal = Calendar.getInstance();
			cal.setTime(beginDate);
			cal.add(Calendar.MONTH, -1);
			
			this.dpLastBeginDate.setValue(cal.getTime());
		}
	}

	/**
	 * 当月结束时间
	 */
	@Override
	protected void dpCurrEndDate_dataChanged(DataChangeEvent e)
			throws Exception {
		Date endDate = this.dpCurrEndDate.getSqlDate();
		if(endDate != null){
			Calendar cal = Calendar.getInstance();
			cal.setTime(endDate);
			cal.add(Calendar.MONTH, -1);
			
			this.dpLastEndDate.setValue(cal.getTime());
		}
	}
	
	
	
	

}