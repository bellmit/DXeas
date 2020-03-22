/**
 * output package name
 */
package com.kingdee.eas.farm.hatch.client;

import java.awt.event.*;

import org.apache.log4j.Logger;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.eas.custom.commld.ClientUtils;
import com.kingdee.eas.framework.*;
import com.kingdee.eas.util.client.MsgBox;

/**
 * output class name
 */
public class ImmuneBillListUI extends AbstractImmuneBillListUI
{
    private static final Logger logger = CoreUIObject.getLogger(ImmuneBillListUI.class);
    
    /**
     * output class constructor
     */
    public ImmuneBillListUI() throws Exception
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
     * output getBizInterface method
     */
    protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
    {
        return com.kingdee.eas.farm.hatch.ImmuneBillFactory.getRemoteInstance();
    }

    /**
     * output createNewData method
     */
    protected com.kingdee.bos.dao.IObjectValue createNewData()
    {
        com.kingdee.eas.farm.hatch.ImmuneBillInfo objectValue = new com.kingdee.eas.farm.hatch.ImmuneBillInfo();
		
        return objectValue;
    }

	@Override
	public void onLoad() throws Exception {
		// TODO Auto-generated method stub
		super.onLoad();
		
		btnAudit.setIcon(ClientUtils.AuditIcon);
		btnUnAudit.setIcon(ClientUtils.UnAuditIcon);
	}

	@Override
	public void actionAudit_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		super.actionAudit_actionPerformed(e);
		refreshList();
		MsgBox.showInfo("审核成功");
	}

	@Override
	public void actionUnAudit_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		super.actionUnAudit_actionPerformed(e);
		refreshList();
		MsgBox.showInfo("审核成功");
	}

}