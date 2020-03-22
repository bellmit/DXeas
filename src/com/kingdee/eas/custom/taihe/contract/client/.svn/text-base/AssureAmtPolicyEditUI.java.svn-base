/**
 * output package name
 */
package com.kingdee.eas.custom.taihe.contract.client;

import java.awt.event.*;

import org.apache.log4j.Logger;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.eas.framework.*;
import com.kingdee.eas.scm.common.BillBaseStatusEnum;
import com.kingdee.eas.util.SysUtil;
import com.kingdee.eas.util.client.MsgBox;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;
import com.kingdee.bos.metadata.entity.SelectorItemInfo;
import com.kingdee.eas.basedata.org.client.f7.CompanyF7;
import com.kingdee.eas.common.client.OprtState;
import com.kingdee.eas.common.client.SysContext;
import com.kingdee.eas.common.client.UIContext;

/**
 * output class name
 */
public class AssureAmtPolicyEditUI extends AbstractAssureAmtPolicyEditUI
{
    private static final Logger logger = CoreUIObject.getLogger(AssureAmtPolicyEditUI.class);
    
    /**
     * output class constructor
     */
    public AssureAmtPolicyEditUI() throws Exception
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

    @Override
	public void onLoad() throws Exception {
		// TODO Auto-generated method stub
		super.onLoad();
		CompanyF7 cf7=new CompanyF7();
		this.prmtcompany.setSelector(cf7);
	}
	/**
     * output getBizInterface method
     */
    protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
    {
        return com.kingdee.eas.custom.taihe.contract.AssureAmtPolicyFactory.getRemoteInstance();
    }

    /**
     * output setDataObject method
     */
    public void setDataObject(IObjectValue dataObject) 
    {
        super.setDataObject(dataObject);
        if(STATUS_ADDNEW.equals(getOprtState())) {
            editData.put("treeid",(com.kingdee.eas.custom.taihe.contract.AssureAmtPolicyTreeInfo)getUIContext().get(UIContext.PARENTNODE));
            editData.setBillStatus(BillBaseStatusEnum.SUBMITED);
        }
    }

    /**
     * output createNewData method
     */
    protected com.kingdee.bos.dao.IObjectValue createNewData()
    {
        com.kingdee.eas.custom.taihe.contract.AssureAmtPolicyInfo objectValue = new com.kingdee.eas.custom.taihe.contract.AssureAmtPolicyInfo();
        objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));
        objectValue.setCompany(SysContext.getSysContext().getCurrentFIUnit());
        objectValue.setCU(SysContext.getSysContext().getCurrentCtrlUnit());
        return objectValue;
    }
	@Override
	public void actionAudit_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		if(this.editData == null || this.editData.getId() == null || !this.editData.getBillStatus().equals(BillBaseStatusEnum.SUBMITED)){
			MsgBox.showWarning("不能审核非提交状态的单据");
			SysUtil.abort();
		}
		super.actionAudit_actionPerformed(e);
		
		this.doAfterSave(new ObjectUuidPK(editData.getId()));
		
		setOprtState(STATUS_VIEW);
		lockUIForViewStatus();
		setNextMessageText("审核成功");
		setShowMessagePolicy(0);
		setIsShowTextOnly(false);
		showMessage();
	}
	@Override
	public void actionUnAudit_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		if(!this.editData.getBillStatus().equals(BillBaseStatusEnum.AUDITED)) {
    		MsgBox.showWarning("单据尚未审核，禁止反审核！");
    		SysUtil.abort();
    	}
    	super.actionUnAudit_actionPerformed(e);
		this.doAfterSave(new ObjectUuidPK(editData.getId()));
		setOprtState(STATUS_VIEW);
		lockUIForViewStatus();
		setNextMessageText("反审核成功");
		setShowMessagePolicy(0);
		setIsShowTextOnly(false);
		showMessage();
	}
	@Override
	public void actionSubmit_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		super.actionSubmit_actionPerformed(e);
	}
	@Override
	public void actionCancel_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		super.actionCancel_actionPerformed(e);
	}
	@Override
	public void actionCancelCancel_actionPerformed(ActionEvent e)
			throws Exception {
		// TODO Auto-generated method stub
		super.actionCancelCancel_actionPerformed(e);
	}
    
}