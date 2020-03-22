/**
 * output package name
 */
package com.kingdee.eas.custom.salediscount.rpt.client;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.log4j.Logger;

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
public class SaleDiscountAnalyzeRptFilterUI extends AbstractSaleDiscountAnalyzeRptFilterUI
{
    private static final Logger logger = CoreUIObject.getLogger(SaleDiscountAnalyzeRptFilterUI.class);
    
    /**
     * output class constructor
     */
    public SaleDiscountAnalyzeRptFilterUI() throws Exception
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
    

   

    @Override
	public RptParams getCustomCondition() {
		// TODO Auto-generated method stub
		RptParams pp = new RptParams();	
		String cuId=null;
		String customerId=null;
		if(this.prmtCompany.getValue()!=null){
			cuId=((CompanyOrgUnitInfo)this.prmtCompany.getValue()).getId().toString();
		}else{
			MsgBox.showWarning("请选择公司！");
			SysUtil.abort();
		}
		if(this.prmtCustomer.getValue()!=null) {
			customerId=((CustomerInfo)this.prmtCustomer.getValue()).getId().toString();
		}
//		pp.setObject("companyID",this.prmtCompany.getValue());
		pp.setString("customerID", customerId);
		pp.setString("companyID",cuId);
		Date beginDate = dpBeginDate.getSqlDate() ;
		Date endDate = dpEndDate.getSqlDate();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		if(beginDate != null){
			pp.setString("beginDate", sdf.format(beginDate));
		}else{
			MsgBox.showWarning("请选择开始日期！");
			SysUtil.abort();
		}
		
		if(endDate != null){
			pp.setString("endDate", sdf.format(endDate));
		}else{
			MsgBox.showWarning("请选择开始日期！");
			SysUtil.abort();
		}
		
		
		boolean isGroupByMaterial = this.cbByMaterial.isSelected();
		pp.setBoolean("isGroupByMaterial", isGroupByMaterial);
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
	    prmtCustomer.setCurrentMainBizOrgUnit(companyInfo, OrgType.Company);
		// 设置客户F7的过滤条件
	    prmtCustomer.setEntityViewInfo(evi);
	    prmtCustomer.setCommitFormat("$number$");//提交格式
	    prmtCustomer.setDisplayFormat("$number$");//显示格式
	    prmtCustomer.setEditFormat("$number$");//编辑格式
	    prmtCustomer.setEnabledMultiSelection(false);
		// 设置客户F7展现形式为左树右表
		GeneralKDPromptSelectorAdaptor selectorAdaptor = new GeneralKDPromptSelectorAdaptor(prmtCustomer,
				F7CustomerTreeDetailListUI.class.getName(), 
				this,
				CSSPGroupInfo.getBosType(),
				queryInfo, 
				"browseGroup.id", 
				"companyOrgUnit.id");
		selectorAdaptor.setIsMultiSelect(false);
		prmtCustomer.setSelector(selectorAdaptor);
		prmtCustomer.addSelectorListener(selectorAdaptor);
		
		
		Date nowDate = new Date();
		
		Calendar cal = Calendar.getInstance();
		cal.setTime(nowDate);
		cal.set(Calendar.DATE, 1);
		
		dpBeginDate.setValue(cal.getTime());
		dpBeginDate.setRequired(true);
		cal.add(Calendar.MONTH, 1);
		cal.add(Calendar.DATE, -1);
		dpEndDate.setValue(cal.getTime());
		dpEndDate.setRequired(true);
	}

}