/**
 * output package name
 */
package com.kingdee.eas.custom.salediscount.rpt.client;

import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.log4j.Logger;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.eas.basedata.assistant.PeriodInfo;
import com.kingdee.eas.basedata.assistant.SystemStatusCtrolUtils;
import com.kingdee.eas.basedata.org.CompanyOrgUnitInfo;
import com.kingdee.eas.common.client.SysContext;
import com.kingdee.eas.framework.*;
import com.kingdee.eas.framework.report.util.RptParams;
import com.kingdee.eas.util.SysUtil;
import com.kingdee.eas.util.app.ContextUtil;
import com.kingdee.eas.util.client.MsgBox;

/**
 * output class name
 */
public class InventoryBillAndIssueRptFilterUI extends AbstractInventoryBillAndIssueRptFilterUI
{
    private static final Logger logger = CoreUIObject.getLogger(InventoryBillAndIssueRptFilterUI.class);
    
    /**
     * output class constructor
     */
    public InventoryBillAndIssueRptFilterUI() throws Exception
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
		
		if(this.prmtCompany.getValue()!=null){
			cuId=((CompanyOrgUnitInfo)this.prmtCompany.getValue()).getId().toString();
		}else{
			MsgBox.showWarning("��ѡ��˾��");
			SysUtil.abort();
		}
		
//		pp.setObject("companyID",this.prmtCompany.getValue());
		
		pp.setString("companyID",cuId);
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		PeriodInfo period = (PeriodInfo) prmtPeriod.getValue();
		if(period != null){
			
			Date beginDate = period.getBeginDate() ;
			Date endDate = period.getEndDate();
			
			pp.setString("beginDate", sdf.format(beginDate));
			pp.setString("endDate", sdf.format(endDate));
			
		}else{
			MsgBox.showWarning("��ѡ���ѯ�ڼ䣡");
			SysUtil.abort();
		}
		
		
		
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
		
//		
//		EntityViewInfo evi = new EntityViewInfo();
//		FilterInfo filterInfo = new FilterInfo();
//		// ��Ӳ�����֯����
//		filterInfo.getFilterItems().add(new FilterItemInfo("companyOrgUnit.id", companyInfo.getId().toString(), CompareType.EQUALS));
//		evi.setFilter(filterInfo);
//	    // ����F7��ѯԪ����
//		String queryInfo = QueryInfoConstants.CUSTOMER_COMPANY_STANDARD;
//		// ������ҵ����֯
//	    prmtCustomer.setCurrentMainBizOrgUnit(companyInfo, OrgType.Company);
//		// ���ÿͻ�F7�Ĺ�������
//	    prmtCustomer.setEntityViewInfo(evi);
//	    prmtCustomer.setCommitFormat("$number$");//�ύ��ʽ
//	    prmtCustomer.setDisplayFormat("$number$");//��ʾ��ʽ
//	    prmtCustomer.setEditFormat("$number$");//�༭��ʽ
//	    prmtCustomer.setEnabledMultiSelection(false);
//		// ���ÿͻ�F7չ����ʽΪ�����ұ�
//		GeneralKDPromptSelectorAdaptor selectorAdaptor = new GeneralKDPromptSelectorAdaptor(prmtCustomer,
//				F7CustomerTreeDetailListUI.class.getName(), 
//				this,
//				CSSPGroupInfo.getBosType(),
//				queryInfo, 
//				"browseGroup.id", 
//				"companyOrgUnit.id");
//		selectorAdaptor.setIsMultiSelect(false);
//		prmtCustomer.setSelector(selectorAdaptor);
//		prmtCustomer.addSelectorListener(selectorAdaptor);
//		
//		
		Date nowDate = new Date();
		
		Calendar cal = Calendar.getInstance();
		cal.setTime(nowDate);
		
		
		
		PeriodInfo currPeriod = SystemStatusCtrolUtils.getCurrentPeriod(null, SystemEnum.INVENTORYMANAGEMENT, companyInfo);
		// ����Ĭ�ϵ�ǰ�ڼ�
		this.prmtPeriod.setValue(currPeriod);
		
	}

}