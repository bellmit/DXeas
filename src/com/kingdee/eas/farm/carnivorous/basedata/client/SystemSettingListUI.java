/**
 * output package name
 */
package com.kingdee.eas.farm.carnivorous.basedata.client;

import java.awt.event.*;
import org.apache.log4j.Logger;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.eas.framework.*;

/**
 * output class name
 */
public class SystemSettingListUI extends AbstractSystemSettingListUI
{
    private static final Logger logger = CoreUIObject.getLogger(SystemSettingListUI.class);
    
    /**
     * output class constructor
     */
    public SystemSettingListUI() throws Exception
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
        return com.kingdee.eas.farm.carnivorous.basedata.SystemSettingFactory.getRemoteInstance();
    }

    /**
     * output createNewData method
     */
    protected com.kingdee.bos.dao.IObjectValue createNewData()
    {
        com.kingdee.eas.farm.carnivorous.basedata.SystemSettingInfo objectValue = new com.kingdee.eas.farm.carnivorous.basedata.SystemSettingInfo();
		
        return objectValue;
    }

}