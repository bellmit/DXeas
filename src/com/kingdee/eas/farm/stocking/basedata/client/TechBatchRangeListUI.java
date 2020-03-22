/**
 * output package name
 */
package com.kingdee.eas.farm.stocking.basedata.client;

import org.apache.log4j.Logger;

import com.kingdee.bos.ui.face.CoreUIObject;

/**
 * output class name
 */
public class TechBatchRangeListUI extends AbstractTechBatchRangeListUI
{
    private static final Logger logger = CoreUIObject.getLogger(TechBatchRangeListUI.class);
    
    /**
     * output class constructor
     */
    public TechBatchRangeListUI() throws Exception
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
        return com.kingdee.eas.farm.stocking.basedata.TechBatchRangeFactory.getRemoteInstance();
    }

    /**
     * output createNewData method
     */
    protected com.kingdee.bos.dao.IObjectValue createNewData()
    {
        com.kingdee.eas.farm.stocking.basedata.TechBatchRangeInfo objectValue = new com.kingdee.eas.farm.stocking.basedata.TechBatchRangeInfo();
        return objectValue;
    }

}