/**
 * output package name
 */
package com.kingdee.eas.farm.breed.business.client;

import java.awt.event.*;
import org.apache.log4j.Logger;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.eas.framework.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;
import com.kingdee.bos.metadata.entity.SelectorItemInfo;
import com.kingdee.eas.common.client.OprtState;
import com.kingdee.eas.common.client.UIContext;

/**
 * output class name
 */
public class CCSendFodderStandardListUI extends AbstractCCSendFodderStandardListUI
{
    private static final Logger logger = CoreUIObject.getLogger(CCSendFodderStandardListUI.class);
    
    /**
     * output class constructor
     */
    public CCSendFodderStandardListUI() throws Exception
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
        return com.kingdee.eas.farm.breed.business.CCSendFodderStandardFactory.getRemoteInstance();
    }

    /**
     * output getTreeInterface method
     */
    protected ITreeBase getTreeInterface() throws Exception
    {
        return com.kingdee.eas.farm.breed.business.CCSendFodderStandardTreeFactory.getRemoteInstance();
    }

    /**
     * output getGroupEditUIName method
     */
    protected String getGroupEditUIName()
    {
        return com.kingdee.eas.farm.breed.business.client.CCSendFodderStandardTreeEditUI.class.getName();
    }

    /**
     * output getQueryFieldName method
     */
    protected String getQueryFieldName()
    {
        return "treeid.id";
    }

    /**
     * output getKeyFieldName method
     */
    protected String getKeyFieldName()
    {
        return "id";
    }

    /**
     * output getRootName method
     */
    protected String getRootName()
    {
        return "商品鸡料塔送料规范";
    }

    /**
     * output createNewData method
     */
    protected com.kingdee.bos.dao.IObjectValue createNewData()
    {
        com.kingdee.eas.farm.breed.business.CCSendFodderStandardInfo objectValue = new com.kingdee.eas.farm.breed.business.CCSendFodderStandardInfo();
		
        return objectValue;
    }

    
    /**
     * 不进行组织隔离
     */
	@Override
	protected boolean isIgnoreCUFilter() {
		
		return true;
	}
}