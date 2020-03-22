/**
 * output package name
 */
package com.kingdee.eas.farm.stocking.assistfunction.client;

import java.awt.event.*;
import org.apache.log4j.Logger;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.eas.framework.*;

/**
 * output class name
 */
public class SquareChechPermissionEditUI extends AbstractSquareChechPermissionEditUI
{
    private static final Logger logger = CoreUIObject.getLogger(SquareChechPermissionEditUI.class);
    
    /**
     * output class constructor
     */
    public SquareChechPermissionEditUI() throws Exception
    {
        super();
    }
    /**
     * output loadFields method
     */
    public void loadFields()
    {
        super.loadFields();
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
        return com.kingdee.eas.farm.stocking.assistfunction.SquareChechPermissionFactory.getRemoteInstance();
    }

    @Override
	public void onLoad() throws Exception {
		// TODO Auto-generated method stub
		super.onLoad();
		kdtEntryUser.getColumn("seq").getStyleAttributes().setHided(true);
	}
	/**
     * output createNewData method
     */
    protected com.kingdee.bos.dao.IObjectValue createNewData()
    {
        com.kingdee.eas.farm.stocking.assistfunction.SquareChechPermissionInfo objectValue = new com.kingdee.eas.farm.stocking.assistfunction.SquareChechPermissionInfo();
        objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));
		
        return objectValue;
    }

}