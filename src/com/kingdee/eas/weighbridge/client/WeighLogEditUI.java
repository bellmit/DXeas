/**
 * output package name
 */
package com.kingdee.eas.weighbridge.client;

import java.awt.event.*;
import org.apache.log4j.Logger;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.eas.framework.*;

/**
 * output class name
 */
public class WeighLogEditUI extends AbstractWeighLogEditUI
{
    private static final Logger logger = CoreUIObject.getLogger(WeighLogEditUI.class);
    
    /**
     * output class constructor
     */
    public WeighLogEditUI() throws Exception
    {
        super();
    }
    /**
     * output getBizInterface method
     */
    protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
    {
        return com.kingdee.eas.weighbridge.WeighLogFactory.getRemoteInstance();
    }

    /**
     * output createNewData method
     */
    protected com.kingdee.bos.dao.IObjectValue createNewData()
    {
        com.kingdee.eas.weighbridge.WeighLogInfo objectValue = new com.kingdee.eas.weighbridge.WeighLogInfo();
        objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));
		
        return objectValue;
    }

    

	@Override
	public void onLoad() throws Exception {
		
		super.onLoad();
		
		for (int i = 0; i < this.toolBar.getComponents().length; i++) {
			this.toolBar.getComponent(i).setVisible(false);
		}
		this.actionAddNew.setVisible(false);
		this.actionEdit.setVisible(false);
		this.actionCopy.setVisible(false);
		this.actionRemove.setVisible(false);
	}

}