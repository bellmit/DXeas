/**
 * output package name
 */
package com.kingdee.eas.custom.applicationofsocialsecurity.client;

import java.awt.event.*;
import org.apache.log4j.Logger;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.eas.custom.applicationofsocialsecurity.DataBaseConnectionFactory;
import com.kingdee.eas.custom.applicationofsocialsecurity.DataBaseConnectionInfo;
import com.kingdee.eas.custom.applicationofsocialsecurity.PersonTypeFactory;
import com.kingdee.eas.custom.applicationofsocialsecurity.PersonTypeInfo;
import com.kingdee.eas.framework.*;

/**
 * output class name
 */
public class PersonTypeListUI extends AbstractPersonTypeListUI
{
    private static final Logger logger = CoreUIObject.getLogger(PersonTypeListUI.class);
    
    /**
     * output class constructor
     */
    public PersonTypeListUI() throws Exception
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
     * output actionCancel_actionPerformed
     */
    public void actionCancel_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionCancel_actionPerformed(e);
        refreshList();
    }

    /**
     * output actionCancelCancel_actionPerformed
     */
    public void actionCancelCancel_actionPerformed(ActionEvent e) throws Exception
    {
    	if(this.getSelectedKeyValue()==null||this.getSelectedKeyValue().equals(""))
			return;
		PersonTypeInfo info = PersonTypeFactory.getRemoteInstance().getPersonTypeInfo(new ObjectUuidPK(this.getSelectedKeyValue()));
		PersonTypeFactory.getRemoteInstance().cancelCancel(new ObjectUuidPK(this.getSelectedKeyValue()), info);
        super.actionCancelCancel_actionPerformed(e);
        refreshList();
    }

    /**
     * output getBizInterface method
     */
    protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
    {
        return com.kingdee.eas.custom.applicationofsocialsecurity.PersonTypeFactory.getRemoteInstance();
    }

    /**
     * output createNewData method
     */
    protected com.kingdee.bos.dao.IObjectValue createNewData()
    {
        com.kingdee.eas.custom.applicationofsocialsecurity.PersonTypeInfo objectValue = new com.kingdee.eas.custom.applicationofsocialsecurity.PersonTypeInfo();
		
        return objectValue;
    }

	@Override
	public void onLoad() throws Exception {
		// TODO Auto-generated method stub
		super.onLoad();
		setUI();
	}

	private void setUI() {
		// TODO Auto-generated method stub
		btnCancel.setVisible(true);
		btnCancelCancel.setVisible(true);
	}

}