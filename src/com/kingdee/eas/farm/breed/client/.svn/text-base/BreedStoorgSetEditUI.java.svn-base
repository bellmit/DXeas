/**
 * output package name
 */
package com.kingdee.eas.farm.breed.client;

import java.awt.event.*;
import org.apache.log4j.Logger;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.eas.framework.*;
import com.kingdee.bos.ctrl.kdf.table.KDTable;

/**
 * output class name
 */
public class BreedStoorgSetEditUI extends AbstractBreedStoorgSetEditUI
{
    private static final Logger logger = CoreUIObject.getLogger(BreedStoorgSetEditUI.class);
    
    /**
     * output class constructor
     */
    public BreedStoorgSetEditUI() throws Exception
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
        return com.kingdee.eas.farm.breed.BreedStoorgSetFactory.getRemoteInstance();
    }

    /**
     * output createNewDetailData method
     */
    protected IObjectValue createNewDetailData(KDTable table)
    {
		
        return null;
    }

    /**
     * output createNewData method
     */
    protected com.kingdee.bos.dao.IObjectValue createNewData()
    {
        com.kingdee.eas.farm.breed.BreedStoorgSetInfo objectValue = new com.kingdee.eas.farm.breed.BreedStoorgSetInfo();
        objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));
		
        return objectValue;
    }

    /**
     * 界面初始化完成
     */
    @Override
	public void onLoad() throws Exception {
		// 
		super.onLoad();
		
		if(this.editData != null && this.editData.getId() != null ){
			if("EDIT".equals(this.getOprtState()) || "VIEW".equals(this.getOprtState())){
//				this.btnCancelCancel.setEnabled(true);
			}
		}
		
		this.prmtfarmLeader.setQueryInfo("com.kingdee.eas.cp.base.app.PersonF7Query");		
	}
}