/**
 * output package name
 */
package com.kingdee.eas.farm.feemanager.basedata.client;

import java.awt.event.*;
import java.util.HashMap;

import org.apache.log4j.Logger;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.bos.ctrl.kdf.table.event.KDTEditAdapter;
import com.kingdee.bos.ctrl.kdf.table.event.KDTEditEvent;
import com.kingdee.bos.ctrl.swing.event.SelectorEvent;
import com.kingdee.bos.ctrl.swing.event.SelectorListener;
import com.kingdee.bos.dao.AbstractObjectValue;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.eas.farm.food.comm.FarmCommUtils;
import com.kingdee.eas.farm.stocking.basedata.FarmBaseStatusEnum;
import com.kingdee.eas.framework.*;
import com.kingdee.eas.framework.batchHandler.UtilRequest;
import com.kingdee.eas.scm.common.BillBaseStatusEnum;
import com.kingdee.eas.util.SysUtil;
import com.kingdee.eas.util.client.MsgBox;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;
import com.kingdee.bos.metadata.entity.SelectorItemInfo;
import com.kingdee.eas.common.client.OprtState;
import com.kingdee.eas.common.client.SysContext;
import com.kingdee.eas.common.client.UIContext;

/**
 * output class name
 */
public class DriverEditUI extends AbstractDriverEditUI
{
    private static final Logger logger = CoreUIObject.getLogger(DriverEditUI.class);
    
    /**
     * output class constructor
     */
    public DriverEditUI() throws Exception
    {
        super();
      //图标初始化
        this.btnAudit.setIcon(com.kingdee.eas.util.client.EASResource.getIcon("imgTbtn_audit"));
        this.btnUnAudit.setIcon(com.kingdee.eas.util.client.EASResource.getIcon("imgTbtn_unaudit"));
    }
    


    public void loadFields()
	{
		super.loadFields();
		btnCancel.setVisible(true);
		btnCancelCancel.setVisible(true);
		setUIStatus();
	}


    private void setUIStatus() {
		// TODO Auto-generated method stub
		if(this.editData.getBaseStatus()!=null) {
			if(this.editData.getBaseStatus().equals(FarmBaseStatusEnum.approve)) {
				this.actionCancel.setEnabled(true);
				this.actionCancelCancel.setEnabled(false);
				this.actionEdit.setEnabled(false);
				this.actionAudit.setEnabled(false);
				this.actionUnAudit.setEnabled(true);		
			}else if(this.editData.getBaseStatus().equals(FarmBaseStatusEnum.unApprove)) {
				this.actionCancel.setEnabled(false);
				this.actionCancelCancel.setEnabled(false);
				this.actionEdit.setEnabled(true);
				this.actionAudit.setEnabled(true);
				this.actionUnAudit.setEnabled(false);		
			}else  if(this.editData.getBaseStatus().equals(FarmBaseStatusEnum.frozen)) {
				this.actionCancel.setEnabled(false);
				this.actionCancelCancel.setEnabled(true);
				this.actionEdit.setEnabled(false);
				this.actionAudit.setEnabled(false);
				this.actionUnAudit.setEnabled(false);		
			}else {
				this.actionCancel.setEnabled(false);
				this.actionCancelCancel.setEnabled(false);
				this.actionEdit.setEnabled(true);
			}
		}if(editData.getId()==null){
			this.actionCancel.setEnabled(false);
			this.actionCancelCancel.setEnabled(false);
			this.actionAudit.setEnabled(false);
			this.actionUnAudit.setEnabled(false);			
			this.actionEdit.setEnabled(false);
		}
	}

	@Override
	public void actionRemove_actionPerformed(ActionEvent arg0) throws Exception {
		// TODO Auto-generated method stub
		if(this.editData.getBaseStatus()!=null&&!this.editData.getBaseStatus().equals(FarmBaseStatusEnum.unApprove)) {
    		MsgBox.showWarning("单据已经核准或禁用，禁止删除！");
    		return;
		}
		super.actionRemove_actionPerformed(arg0);
	}
	@Override
	public void actionAudit_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		super.actionAudit_actionPerformed(e);
		this.doAfterSave(new ObjectUuidPK(editData.getId()));
		setOprtState(STATUS_VIEW);
		lockUIForViewStatus();
		setNextMessageText("核准完成");
		setShowMessagePolicy(0);
		setIsShowTextOnly(false);
		showMessage();
		setUIStatus();
	}
	@Override
	public void actionUnAudit_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		super.actionUnAudit_actionPerformed(e);
		this.doAfterSave(new ObjectUuidPK(editData.getId()));
		setOprtState(STATUS_VIEW);
		lockUIForViewStatus();
		setNextMessageText("反核准完成");
		setShowMessagePolicy(0);
		setIsShowTextOnly(false);
		showMessage();
		setUIStatus();
	}

	@Override
	public void actionCopy_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		//	super.actionCopy_actionPerformed(e);
		if (!(UtilRequest.isPrepare("ActionCopy", this)))
		{
			checkModified();
		}

		if ((this.editData != null) && (!(OprtState.VIEW.equals(getOprtState()))))
		{
			IObjectValue objectValue = (IObjectValue)getUIContext().get("CURRENT.VO");
			if (objectValue != null)
			{
				try
				{
					String id = this.idList.getID(this.idList.getCurrentIndex());
					setOprtState("RELEASEALL");
					pubFireVOChangeListener(id);
				}
				catch (Throwable E) {
				}
			}
		}
		ObjectValueUtil.copy(this.editData);

		unLockUI();

		setFieldsNull(this.editData);
		setOprtState("ADDNEW");


		this.editData.setBaseStatus(null);

		setDataObject(this.editData);
		//	loadData();
		loadFields();

		showCopyAddNew();
		this.actionCopy.setEnabled(false);
		this.chkMenuItemSubmitAndAddNew.setVisible(true);
		this.baseStatus.setSelectedIndex(0);
		setDefaultFocused();
	}


    /**
     * output getBizInterface method
     */
    protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
    {
        return com.kingdee.eas.farm.feemanager.basedata.DriverFactory.getRemoteInstance();
    }

    /**
     * output setDataObject method
     */
    public void setDataObject(IObjectValue dataObject) 
    {
        super.setDataObject(dataObject);
        if(STATUS_ADDNEW.equals(getOprtState())) {
            editData.put("treeid",(com.kingdee.eas.farm.feemanager.basedata.DriverTreeInfo)getUIContext().get(UIContext.PARENTNODE));
        }
    }

    /**
     * output createNewData method
     */
    protected com.kingdee.bos.dao.IObjectValue createNewData()
    {
        com.kingdee.eas.farm.feemanager.basedata.DriverInfo objectValue = new com.kingdee.eas.farm.feemanager.basedata.DriverInfo();
        objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));
        objectValue.setCompanyOrgUnit(SysContext.getSysContext().getCurrentFIUnit());
        return objectValue;
    }

}