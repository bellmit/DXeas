/**
 * output package name
 */
package com.kingdee.eas.custom.salepayment.client;

import java.awt.event.*;
import org.apache.log4j.Logger;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.eas.framework.*;

/**
 * output class name
 */
public class TechnicianListUI extends AbstractTechnicianListUI
{
    private static final Logger logger = CoreUIObject.getLogger(TechnicianListUI.class);
    
    /**
     * output class constructor
     */
    public TechnicianListUI() throws Exception
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
        return com.kingdee.eas.custom.salepayment.TechnicianFactory.getRemoteInstance();
    }

    /**
     * output createNewData method
     */
    protected com.kingdee.bos.dao.IObjectValue createNewData()
    {
        com.kingdee.eas.custom.salepayment.TechnicianInfo objectValue = new com.kingdee.eas.custom.salepayment.TechnicianInfo();
		
        return objectValue;
    }

}