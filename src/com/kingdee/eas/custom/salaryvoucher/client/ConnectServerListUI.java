/**
 * output package name
 */
package com.kingdee.eas.custom.salaryvoucher.client;

import java.awt.event.*;

import org.apache.log4j.Logger;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.eas.custom.salaryvoucher.ConnectServerFactory;
import com.kingdee.eas.custom.salaryvoucher.ConnectServerInfo;
import com.kingdee.eas.custom.salaryvoucher.voucherStatus;
import com.kingdee.eas.framework.*;

/**
 * output class name
 */
public class ConnectServerListUI extends AbstractConnectServerListUI
{
    private static final Logger logger = CoreUIObject.getLogger(ConnectServerListUI.class);
    
    /**
     * output class constructor
     */
    public ConnectServerListUI() throws Exception
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
        return com.kingdee.eas.custom.salaryvoucher.ConnectServerFactory.getRemoteInstance();
    }

    /**
     * ½ûÓÃ
     */
    @Override
	public void actionCancel_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
    	String id = this.getSelectedKeyValue();
    	if(id!=null&&!id.equals("")){
    		ConnectServerInfo info = ConnectServerFactory.getRemoteInstance().getConnectServerInfo(new ObjectUuidPK(id));
    		if(info.getStatus().equals(voucherStatus.cancelcancel))
    			super.actionCancel_actionPerformed(e);
    	}
		
	}

    /**
     * ÆôÓÃ
     */
	@Override
	public void actionCancelCancel_actionPerformed(ActionEvent e)
			throws Exception {
		// TODO Auto-generated method stub
		String id = this.getSelectedKeyValue();
    	if(id!=null&&!id.equals("")){
    		ConnectServerInfo info = ConnectServerFactory.getRemoteInstance().getConnectServerInfo(new ObjectUuidPK(id));
    		if(info.getStatus().equals(voucherStatus.save))
    			super.actionCancelCancel_actionPerformed(e);
    	}
		
	}

	/**
	 * É¾³ý
	 */
	@Override
	public void actionRemove_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		String id = this.getSelectedKeyValue();
    	if(id!=null&&!id.equals("")){
    		ConnectServerInfo info = ConnectServerFactory.getRemoteInstance().getConnectServerInfo(new ObjectUuidPK(id));
    		if(info.getStatus().equals(voucherStatus.save))
    			super.actionRemove_actionPerformed(e);
    	}
		
	}

	/**
     * output createNewData method
     */
    protected com.kingdee.bos.dao.IObjectValue createNewData()
    {
        com.kingdee.eas.custom.salaryvoucher.ConnectServerInfo objectValue = new com.kingdee.eas.custom.salaryvoucher.ConnectServerInfo();
		
        return objectValue;
    }

}