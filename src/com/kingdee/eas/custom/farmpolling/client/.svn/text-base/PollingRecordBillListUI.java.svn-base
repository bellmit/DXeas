/**
 * output package name
 */
package com.kingdee.eas.custom.farmpolling.client;

import java.awt.event.*;
import org.apache.log4j.Logger;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.eas.framework.*;

/**
 * output class name
 */
public class PollingRecordBillListUI extends AbstractPollingRecordBillListUI
{
    private static final Logger logger = CoreUIObject.getLogger(PollingRecordBillListUI.class);
    
    /**
     * output class constructor
     */
    public PollingRecordBillListUI() throws Exception
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
        return com.kingdee.eas.custom.farmpolling.PollingRecordBillFactory.getRemoteInstance();
    }

    /**
     * output createNewData method
     */
    protected com.kingdee.bos.dao.IObjectValue createNewData()
    {
        com.kingdee.eas.custom.farmpolling.PollingRecordBillInfo objectValue = new com.kingdee.eas.custom.farmpolling.PollingRecordBillInfo();
		
        return objectValue;
    }

	@Override
	public void onLoad() throws Exception {
		// TODO Auto-generated method stub
		super.onLoad();
		tblMain.getColumn("signInTime").getStyleAttributes().setNumberFormat("yyyy-MM-dd HH:mm:ss");
		tblMain.getColumn("signOutTime").getStyleAttributes().setNumberFormat("yyyy-MM-dd HH:mm:ss");
	}

	@Override
	public void onShow() throws Exception {
		// TODO Auto-generated method stub
		super.onShow();
	}
	
	
    

}