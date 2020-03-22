/**
 * output package name
 */
package com.kingdee.eas.custom.dx.weight.client;

import java.awt.event.*;
import java.util.Date;

import org.apache.log4j.Logger;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.eas.common.client.SysContext;
import com.kingdee.eas.framework.*;

/**
 * output class name
 */
public class SettlDetectionListUI extends AbstractSettlDetectionListUI
{
    private static final Logger logger = CoreUIObject.getLogger(SettlDetectionListUI.class);
    
    /**
     * output class constructor
     */
    public SettlDetectionListUI() throws Exception
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
        return com.kingdee.eas.custom.dx.weight.SettlDetectionFactory.getRemoteInstance();
    }

    /**
     * output createNewData method
     */
    protected com.kingdee.bos.dao.IObjectValue createNewData()
    {
        com.kingdee.eas.custom.dx.weight.SettlDetectionInfo objectValue = new com.kingdee.eas.custom.dx.weight.SettlDetectionInfo();
    
        return objectValue;
    }

}