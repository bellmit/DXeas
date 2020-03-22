/**
 * output package name
 */
package com.kingdee.eas.custom.salediscount.client;

import java.awt.event.ActionEvent;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.IObjectValue;
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
import com.kingdee.eas.common.client.UIContext;
import com.kingdee.eas.custom.salediscount.DiscountFacadeFactory;
import com.kingdee.eas.scm.common.client.GeneralKDPromptSelectorAdaptor;
import com.kingdee.eas.scm.common.constants.QueryInfoConstants;
import com.kingdee.eas.util.SysUtil;
import com.kingdee.eas.util.client.MsgBox;

/**
 * output class name
 */
public class DiscountCustomerRelEditUI extends AbstractDiscountCustomerRelEditUI
{
    private static final Logger logger = CoreUIObject.getLogger(DiscountCustomerRelEditUI.class);
    
    /**
     * output class constructor
     */
    public DiscountCustomerRelEditUI() throws Exception
    {
        super();
    }
    /**
     * output loadFields method
     */
    public void loadFields()
    {
        super.loadFields();
    }

    /**
     * output storeFields method
     */
    public void storeFields()
    {
        super.storeFields();
    }

   

    /**
     * 保存不可见
     */
	public void onLoad() throws Exception {
		super.onLoad();
		initComponents();
		
	}
	/**
	 * 初始化界面控件
	 */
	private void initComponents(){
		this.btnSave.setVisible(false);
		this.actionSave.setVisible(false);
		
		
		CompanyOrgUnitInfo companyInfo = SysContext.getSysContext().getCurrentFIUnit(); 
		EntityViewInfo evi = new EntityViewInfo();
		FilterInfo filterInfo = new FilterInfo();
		// 添加财务组织条件
		filterInfo.getFilterItems().add(new FilterItemInfo("companyOrgUnit.id", companyInfo.getId().toString(), CompareType.EQUALS));
		evi.setFilter(filterInfo);
    	// 设置F7查询元数据
		String queryInfo = QueryInfoConstants.CUSTOMER_COMPANY_STANDARD;
//		prmtCustomer.setQueryInfo(queryInfo);
		// 设置主业务组织
		prmtcustomer.setCurrentMainBizOrgUnit(companyInfo, OrgType.Company);
		// 设置客户F7的过滤条件
		prmtcustomer.setEntityViewInfo(evi);
		prmtcustomer.setCommitFormat("$number$");//提交格式
		prmtcustomer.setDisplayFormat("$number$");//显示格式
		prmtcustomer.setEditFormat("$number$");//编辑格式
		prmtcustomer.setEnabledMultiSelection(false);
		// 设置客户F7展现形式为左树右表
		GeneralKDPromptSelectorAdaptor selectorAdaptor = new GeneralKDPromptSelectorAdaptor(prmtcustomer,
				F7CustomerTreeDetailListUI.class.getName(), 
				this,
				CSSPGroupInfo.getBosType(),
				queryInfo, 
				"browseGroup.id", 
				"companyOrgUnit.id");
		selectorAdaptor.setIsMultiSelect(false);
		prmtcustomer.setSelector(selectorAdaptor);
		prmtcustomer.addSelectorListener(selectorAdaptor);
		
		
		
		// 设置主业务组织
		prmtparentCustomer.setCurrentMainBizOrgUnit(companyInfo, OrgType.Company);
		// 设置客户F7的过滤条件
		prmtparentCustomer.setEntityViewInfo(evi);
		prmtparentCustomer.setCommitFormat("$number$");//提交格式
		prmtparentCustomer.setDisplayFormat("$number$");//显示格式
		prmtparentCustomer.setEditFormat("$number$");//编辑格式
		prmtparentCustomer.setEnabledMultiSelection(false);
		prmtparentCustomer.setSelector(selectorAdaptor);
		prmtparentCustomer.addSelectorListener(selectorAdaptor);
	}
	
	/**
	 * 提交前校验 客户不能重复
	 */
	public void actionSubmit_actionPerformed(ActionEvent e) throws Exception {
		this.vilidate();
		super.actionSubmit_actionPerformed(e);
		
		
	}
	/**
	 * 校验 数据是否合法
	 * @throws BOSException
	 */
	private void vilidate() throws BOSException{

		CustomerInfo customer = (CustomerInfo) this.prmtcustomer.getValue();
		CustomerInfo parentCustomer = (CustomerInfo) this.prmtparentCustomer.getValue();
		if(customer != null && parentCustomer != null){
			if(customer.getId().toString().equals(parentCustomer.getId().toString())){
				MsgBox.showWarning("客户与上级客户不能一样");
				SysUtil.abort();
			}
			
			String parentCustomerID = DiscountFacadeFactory.getRemoteInstance().getParentCustomer(customer.getId().toString());
			if(StringUtils.isNotBlank(parentCustomerID)){
				MsgBox.showWarning("该客户已经存在客户关系，不能重复维护");
				SysUtil.abort();
			}else{
				// 客户与上级客户不能 互为上级
				String pppCustomerID = DiscountFacadeFactory.getRemoteInstance().getParentCustomer(parentCustomer.getId().toString());
				if(StringUtils.isNotBlank(pppCustomerID) && pppCustomerID.equals(customer.getId().toString())){
					MsgBox.showWarning("存在上下级关系相反的客户对应，不能存在互为上下级的客户关系");
					SysUtil.abort();
				}
			}
			
		}else{
			MsgBox.showWarning("客户与上级客户不能为空");
			SysUtil.abort();
		}
		
	}
	/**
     * output getBizInterface method
     */
    protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
    {
        return com.kingdee.eas.custom.salediscount.DiscountCustomerRelFactory.getRemoteInstance();
    }

    /**
     * output setDataObject method
     */
    public void setDataObject(IObjectValue dataObject) 
    {
        super.setDataObject(dataObject);
        if(STATUS_ADDNEW.equals(getOprtState())) {
            editData.put("treeid",(com.kingdee.eas.custom.salediscount.DiscountCustomerRelTreeInfo)getUIContext().get(UIContext.PARENTNODE));
        }
    }

    /**
     * output createNewData method
     */
    protected com.kingdee.bos.dao.IObjectValue createNewData()
    {
        com.kingdee.eas.custom.salediscount.DiscountCustomerRelInfo objectValue = new com.kingdee.eas.custom.salediscount.DiscountCustomerRelInfo();
        objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));
		
        return objectValue;
    }

}