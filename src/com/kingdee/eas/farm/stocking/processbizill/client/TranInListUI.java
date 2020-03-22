/**
 * output package name
 */
package com.kingdee.eas.farm.stocking.processbizill.client;

import java.awt.event.*;

import org.apache.log4j.Logger;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.eas.farm.stocking.processbizill.wzBillBaseStatus;
import com.kingdee.eas.framework.*;
import com.kingdee.eas.util.SysUtil;
import com.kingdee.eas.util.client.EASResource;
import com.kingdee.eas.util.client.MsgBox;

/**
 * output class name
 */
public class TranInListUI extends AbstractTranInListUI
{
    private static final Logger logger = CoreUIObject.getLogger(TranInListUI.class);
    
    /**
     * output class constructor
     */
    public TranInListUI() throws Exception
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
	public void onLoad() throws Exception {
		// TODO Auto-generated method stub
		super.onLoad();
		this.actionAddNew.setVisible(false);
		this.btnAudit.setIcon(EASResource.getIcon("imgTbtn_audit"));
		this.btnUnAudit.setIcon(EASResource.getIcon("imgTbtn_unaudit"));
    }
    
    
    @Override
	public void actionAudit_actionPerformed(ActionEvent e) throws Exception {

    	if(this.getBizInterface().getValue(new ObjectUuidPK(getSelectedKeyValue())).get("baseStatus").equals(wzBillBaseStatus.AUDIT_VALUE)){
			MsgBox.showWarning("单据已经审核，禁止再次审核！");
			SysUtil.abort();
    	}
    	
    	if(!(this.getBizInterface().getValue(new ObjectUuidPK(getSelectedKeyValue())).get("baseStatus").equals(wzBillBaseStatus.SUBMIT_VALUE))){
			MsgBox.showWarning("单据尚未提交，禁止审核！");
			SysUtil.abort();
    	}
		super.actionAudit_actionPerformed(e);
		super.actionRefresh_actionPerformed(e);
	}

	@Override
	public void actionEdit_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		
		if(this.getBizInterface().getValue(new ObjectUuidPK(getSelectedKeyValue())).get("baseStatus").equals(wzBillBaseStatus.AUDIT_VALUE)){
			MsgBox.showWarning("单据已经审核，禁止修改！");
			SysUtil.abort();
    	}
		super.actionEdit_actionPerformed(e);
	}

	@Override
	public void actionRemove_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		
		if(this.getBizInterface().getValue(new ObjectUuidPK(getSelectedKeyValue())).get("baseStatus").equals(wzBillBaseStatus.AUDIT_VALUE)){
			MsgBox.showWarning("单据已经审核，禁止删除！");
			SysUtil.abort();
    	}
		super.actionRemove_actionPerformed(e);
	}

	@Override
	public void actionUnAudit_actionPerformed(ActionEvent e) throws Exception {

		if(!(this.getBizInterface().getValue(new ObjectUuidPK(getSelectedKeyValue())).get("baseStatus").equals(wzBillBaseStatus.AUDIT_VALUE))){	
			MsgBox.showWarning("单据尚未审核，禁止反审核！");
			SysUtil.abort();
		}
		super.actionUnAudit_actionPerformed(e);
		super.actionRefresh_actionPerformed(e);
	}

	/**
     * output tblMain_tableClicked method
     */
    protected void tblMain_tableClicked(com.kingdee.bos.ctrl.kdf.table.event.KDTMouseEvent e) throws Exception
    {
        super.tblMain_tableClicked(e);
    }

    /**
     * output tblMain_tableSelectChanged method
     */
    protected void tblMain_tableSelectChanged(com.kingdee.bos.ctrl.kdf.table.event.KDTSelectEvent e) throws Exception
    {
        super.tblMain_tableSelectChanged(e);
    }

    /**
     * output menuItemImportData_actionPerformed method
     */
    protected void menuItemImportData_actionPerformed(java.awt.event.ActionEvent e) throws Exception
    {
        super.menuItemImportData_actionPerformed(e);
    }

    /**
     * output menuItemPCVoucher_actionPerformed method
     */
    protected void menuItemPCVoucher_actionPerformed(java.awt.event.ActionEvent e) throws Exception
    {
        super.menuItemPCVoucher_actionPerformed(e);
    }

    /**
     * output getBizInterface method
     */
    protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
    {
        return com.kingdee.eas.farm.stocking.processbizill.TranInFactory.getRemoteInstance();
    }

    /**
     * output createNewData method
     */
    protected com.kingdee.bos.dao.IObjectValue createNewData()
    {
        com.kingdee.eas.farm.stocking.processbizill.TranInInfo objectValue = new com.kingdee.eas.farm.stocking.processbizill.TranInInfo();
		
        return objectValue;
    }

}