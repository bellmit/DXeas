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
public class AvgWgtSectionListUI extends AbstractAvgWgtSectionListUI
{
    private static final Logger logger = CoreUIObject.getLogger(AvgWgtSectionListUI.class);
    
    /**
     * output class constructor
     */
    public AvgWgtSectionListUI() throws Exception
    {
        super();
    }

    @Override
    protected boolean isIgnoreCUFilter() {
    	// TODO Auto-generated method stub
    	return true;
    }
    
    /**
     * output getBizInterface method
     */
    protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
    {
        return com.kingdee.eas.farm.carnivorous.basedata.AvgWgtSectionFactory.getRemoteInstance();
    }

    /**
     * output createNewData method
     */
    protected com.kingdee.bos.dao.IObjectValue createNewData()
    {
        com.kingdee.eas.farm.carnivorous.basedata.AvgWgtSectionInfo objectValue = new com.kingdee.eas.farm.carnivorous.basedata.AvgWgtSectionInfo();
		
        return objectValue;
    }

}