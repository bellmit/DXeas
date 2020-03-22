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
     * ���治�ɼ�
     */
	public void onLoad() throws Exception {
		super.onLoad();
		initComponents();
		
	}
	/**
	 * ��ʼ������ؼ�
	 */
	private void initComponents(){
		this.btnSave.setVisible(false);
		this.actionSave.setVisible(false);
		
		
		CompanyOrgUnitInfo companyInfo = SysContext.getSysContext().getCurrentFIUnit(); 
		EntityViewInfo evi = new EntityViewInfo();
		FilterInfo filterInfo = new FilterInfo();
		// ��Ӳ�����֯����
		filterInfo.getFilterItems().add(new FilterItemInfo("companyOrgUnit.id", companyInfo.getId().toString(), CompareType.EQUALS));
		evi.setFilter(filterInfo);
    	// ����F7��ѯԪ����
		String queryInfo = QueryInfoConstants.CUSTOMER_COMPANY_STANDARD;
//		prmtCustomer.setQueryInfo(queryInfo);
		// ������ҵ����֯
		prmtcustomer.setCurrentMainBizOrgUnit(companyInfo, OrgType.Company);
		// ���ÿͻ�F7�Ĺ�������
		prmtcustomer.setEntityViewInfo(evi);
		prmtcustomer.setCommitFormat("$number$");//�ύ��ʽ
		prmtcustomer.setDisplayFormat("$number$");//��ʾ��ʽ
		prmtcustomer.setEditFormat("$number$");//�༭��ʽ
		prmtcustomer.setEnabledMultiSelection(false);
		// ���ÿͻ�F7չ����ʽΪ�����ұ�
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
		
		
		
		// ������ҵ����֯
		prmtparentCustomer.setCurrentMainBizOrgUnit(companyInfo, OrgType.Company);
		// ���ÿͻ�F7�Ĺ�������
		prmtparentCustomer.setEntityViewInfo(evi);
		prmtparentCustomer.setCommitFormat("$number$");//�ύ��ʽ
		prmtparentCustomer.setDisplayFormat("$number$");//��ʾ��ʽ
		prmtparentCustomer.setEditFormat("$number$");//�༭��ʽ
		prmtparentCustomer.setEnabledMultiSelection(false);
		prmtparentCustomer.setSelector(selectorAdaptor);
		prmtparentCustomer.addSelectorListener(selectorAdaptor);
	}
	
	/**
	 * �ύǰУ�� �ͻ������ظ�
	 */
	public void actionSubmit_actionPerformed(ActionEvent e) throws Exception {
		this.vilidate();
		super.actionSubmit_actionPerformed(e);
		
		
	}
	/**
	 * У�� �����Ƿ�Ϸ�
	 * @throws BOSException
	 */
	private void vilidate() throws BOSException{

		CustomerInfo customer = (CustomerInfo) this.prmtcustomer.getValue();
		CustomerInfo parentCustomer = (CustomerInfo) this.prmtparentCustomer.getValue();
		if(customer != null && parentCustomer != null){
			if(customer.getId().toString().equals(parentCustomer.getId().toString())){
				MsgBox.showWarning("�ͻ����ϼ��ͻ�����һ��");
				SysUtil.abort();
			}
			
			String parentCustomerID = DiscountFacadeFactory.getRemoteInstance().getParentCustomer(customer.getId().toString());
			if(StringUtils.isNotBlank(parentCustomerID)){
				MsgBox.showWarning("�ÿͻ��Ѿ����ڿͻ���ϵ�������ظ�ά��");
				SysUtil.abort();
			}else{
				// �ͻ����ϼ��ͻ����� ��Ϊ�ϼ�
				String pppCustomerID = DiscountFacadeFactory.getRemoteInstance().getParentCustomer(parentCustomer.getId().toString());
				if(StringUtils.isNotBlank(pppCustomerID) && pppCustomerID.equals(customer.getId().toString())){
					MsgBox.showWarning("�������¼���ϵ�෴�Ŀͻ���Ӧ�����ܴ��ڻ�Ϊ���¼��Ŀͻ���ϵ");
					SysUtil.abort();
				}
			}
			
		}else{
			MsgBox.showWarning("�ͻ����ϼ��ͻ�����Ϊ��");
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