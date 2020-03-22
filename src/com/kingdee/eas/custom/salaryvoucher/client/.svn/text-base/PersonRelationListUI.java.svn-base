/**
 * output package name
 */
package com.kingdee.eas.custom.salaryvoucher.client;

import java.awt.event.*;

import org.apache.log4j.Logger;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.eas.custom.salaryvoucher.PersonRelationFactory;
import com.kingdee.eas.custom.salaryvoucher.PersonRelationInfo;
import com.kingdee.eas.custom.salaryvoucher.voucherStatus;
import com.kingdee.eas.framework.*;
import com.kingdee.eas.util.SysUtil;
import com.kingdee.eas.util.client.EASResource;
import com.kingdee.eas.util.client.MsgBox;

/**
 * output class name
 */
public class PersonRelationListUI extends AbstractPersonRelationListUI
{
    private static final Logger logger = CoreUIObject.getLogger(PersonRelationListUI.class);
    
    /**
     * output class constructor
     */
    public PersonRelationListUI() throws Exception
    {
        super();
    }
    public boolean isIgnoreCUFilter(){
        return true;
         }
    /**
     * output storeFields method
     */
    public void storeFields()
    {
        super.storeFields();
    }

    /**
     * output tblMain_tableClicked method
     */
    protected void tblMain_tableClicked(com.kingdee.bos.ctrl.kdf.table.event.KDTMouseEvent e) throws Exception
    {
        super.tblMain_tableClicked(e);
    }

    /**
     * output menuItemImportData_actionPerformed method
     */
    protected void menuItemImportData_actionPerformed(java.awt.event.ActionEvent e) throws Exception
    {
        super.menuItemImportData_actionPerformed(e);
    }

    /**
     * output getBizInterface method
     */
    protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
    {
        return com.kingdee.eas.custom.salaryvoucher.PersonRelationFactory.getRemoteInstance();
    }

    @Override
	public void onLoad() throws Exception {
		// TODO Auto-generated method stub
		super.onLoad();
		
		
		//°´Å¥Òþ²Ø
		btnCancel.setVisible(false);
		btnCancelCancel.setVisible(false);
		//°´Å¥Í¼±êÐÞ¸Ä
		btnaudit.setIcon(EASResource.getIcon("imgTbtn_audit"));
		btnunAudit.setIcon(EASResource.getIcon("imgTbtn_unaudit"));
		btnaudit.setHideActionText(true);
		btnunAudit.setHideActionText(true);		
		btnaudit.setToolTipText("ÉóºË");
		btnunAudit.setToolTipText("·´ÉóºË");
	}
    
    /**
     * ÉóºË
     */
	@Override
	public void actionAudit_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		super.actionAudit_actionPerformed(e);
		refreshList();
	}
	
	/**
	 * É¾³ý
	 */
	@Override
	public void actionRemove_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		String id = this.getSelectedKeyValue();
		PersonRelationInfo info;
		if(id!=null&&!id.equals("")){
			info=PersonRelationFactory.getRemoteInstance().getPersonRelationInfo(new ObjectUuidPK(id));
			if(info.getBillStatus().equals(voucherStatus.save))
				super.actionRemove_actionPerformed(e);
			else{
				MsgBox.showInfo("Ö»ÔÊÐíÉ¾³ý±£´æ×´Ì¬µÄµ¥¾Ý");
				SysUtil.abort();
			}
		}
		else{
			MsgBox.showInfo("ÇëÑ¡Ôñ¼ÇÂ¼ÐÐ");
			SysUtil.abort();
		}
			
		
	}
	/**
	 * ·´ÉóºË
	 */
	@Override
	public void actionUnAudit_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		super.actionUnAudit_actionPerformed(e);
		refreshList();
	}
	/**
     * output createNewData method
     */
    protected com.kingdee.bos.dao.IObjectValue createNewData()
    {
        com.kingdee.eas.custom.salaryvoucher.PersonRelationInfo objectValue = new com.kingdee.eas.custom.salaryvoucher.PersonRelationInfo();
		
        return objectValue;
    }

}