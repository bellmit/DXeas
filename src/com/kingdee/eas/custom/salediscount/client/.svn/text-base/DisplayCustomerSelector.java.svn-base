/**
 * output package name
 */
package com.kingdee.eas.custom.salediscount.client;

import java.awt.event.ActionEvent;

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
import com.kingdee.eas.scm.common.client.GeneralKDPromptSelectorAdaptor;
import com.kingdee.eas.scm.common.constants.QueryInfoConstants;

/**
 * output class name
 */
public class DisplayCustomerSelector extends AbstractDisplayCustomerSelector
{
    private static final Logger logger = CoreUIObject.getLogger(DisplayCustomerSelector.class);
    
    /**
     * output class constructor
     */
    public DisplayCustomerSelector() throws Exception
    {
        super();
    }

	@Override
	public void onLoad() throws Exception {
		// TODO Auto-generated method stub
		super.onLoad();
		
		
		 CompanyOrgUnitInfo companyInfo = SysContext.getSysContext().getCurrentFIUnit(); 
			EntityViewInfo evi = new EntityViewInfo();
			FilterInfo filterInfo = new FilterInfo();
			// 添加财务组织条件
			filterInfo.getFilterItems().add(new FilterItemInfo("companyOrgUnit.id", companyInfo.getId().toString(), CompareType.EQUALS));
			evi.setFilter(filterInfo);
		    // 设置F7查询元数据
			String queryInfo = QueryInfoConstants.CUSTOMER_COMPANY_STANDARD;
			// 设置主业务组织
		    prmtDisplayCustomer.setCurrentMainBizOrgUnit(companyInfo, OrgType.Company);
			// 设置客户F7的过滤条件
		    prmtDisplayCustomer.setEntityViewInfo(evi);
		    prmtDisplayCustomer.setCommitFormat("$number$");//提交格式
		    prmtDisplayCustomer.setDisplayFormat("$number$");//显示格式
		    prmtDisplayCustomer.setEditFormat("$number$");//编辑格式
		    prmtDisplayCustomer.setEnabledMultiSelection(false);
			// 设置客户F7展现形式为左树右表
			GeneralKDPromptSelectorAdaptor selectorAdaptor = new GeneralKDPromptSelectorAdaptor(prmtDisplayCustomer,
					F7CustomerTreeDetailListUI.class.getName(), 
					this,
					CSSPGroupInfo.getBosType(),
					queryInfo, 
					"browseGroup.id", 
					"companyOrgUnit.id");
			selectorAdaptor.setIsMultiSelect(false);
			prmtDisplayCustomer.setSelector(selectorAdaptor);
			prmtDisplayCustomer.addSelectorListener(selectorAdaptor);
	}

	/**
	 * 取消
	 */
	protected void btnCancel_actionPerformed(ActionEvent e) throws Exception {
		
		this.getUIContext().put("customer", null);
        this.getUIWindow().close();
	}

	/**
	 * 确认
	 */
	protected void btnConfirm_actionPerformed(ActionEvent e) throws Exception {
		CustomerInfo customerInfo = (CustomerInfo) prmtDisplayCustomer.getValue();
		
		 this.getUIContext().put("customer", customerInfo);
	        this.getUIWindow().close();
	}

    	

}