/**
 * output package name
 */
package com.kingdee.eas.farm.stocking.assistfunction.client;

import java.awt.event.ActionEvent;

import org.apache.log4j.Logger;

import com.kingdee.bos.ui.face.CoreUIObject;

/**
 * output class name
 */
public class SettleBillPrintCountListUI extends AbstractSettleBillPrintCountListUI
{
    private static final Logger logger = CoreUIObject.getLogger(SettleBillPrintCountListUI.class);
    
    /**
     * output class constructor
     */
    public SettleBillPrintCountListUI() throws Exception
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
	}

    

    @Override
	public void onShow() throws Exception {
		// TODO Auto-generated method stub
		super.onShow();
		actionCancel.setVisible(true);
		actionCancel.setEnabled(true);
	}
    
    

	@Override
	public void actionCancel_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		super.actionCancel_actionPerformed(e);
		this.actionRefresh_actionPerformed(null);
	}

	/**
     * output getBizInterface method
     */
    protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
    {
        return com.kingdee.eas.farm.stocking.assistfunction.SettleBillPrintCountFactory.getRemoteInstance();
    }

    /**
     * output createNewData method
     */
    protected com.kingdee.bos.dao.IObjectValue createNewData()
    {
        com.kingdee.eas.farm.stocking.assistfunction.SettleBillPrintCountInfo objectValue = new com.kingdee.eas.farm.stocking.assistfunction.SettleBillPrintCountInfo();
		
        return objectValue;
    }

}