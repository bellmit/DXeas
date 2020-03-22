/**
 * output package name
 */
package com.kingdee.eas.custom.wages.client;

import java.awt.event.*;
import org.apache.log4j.Logger;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.eas.framework.*;
import com.kingdee.eas.util.client.EASResource;

/**
 * output class name
 */
public class ExtractFromListUI extends AbstractExtractFromListUI
{
    private static final Logger logger = CoreUIObject.getLogger(ExtractFromListUI.class);
    
    /**
     * output class constructor
     */
    public ExtractFromListUI() throws Exception
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

    /* (non-Javadoc)
	 * @see com.kingdee.eas.framework.client.CoreBillListUI#onLoad()
	 */
	@Override
	public void onLoad() throws Exception {
		// TODO Auto-generated method stub
		super.onLoad();
	}

	/* (non-Javadoc)
	 * @see com.kingdee.eas.framework.client.CoreBillListUI#onShow()
	 */
	@Override
	public void onShow() throws Exception {
		// TODO Auto-generated method stub
//		this.audit.setIcon(EASResource.getIcon("imgTbtn_audit"));
//		this.unaudit.setIcon(EASResource.getIcon("imgTbtn_unaudit"));
		super.onShow();
	}
    /**
     * output tblMain_tableClicked method
     */
    protected void tblMain_tableClicked(com.kingdee.bos.ctrl.kdf.table.event.KDTMouseEvent e) throws Exception
    {
        super.tblMain_tableClicked(e);
    }
    
    /**
     * output createNewData method
     */
    protected com.kingdee.bos.dao.IObjectValue createNewData()
    {
        com.kingdee.eas.custom.wages.ExtractFromInfo objectValue = new com.kingdee.eas.custom.wages.ExtractFromInfo();
		
        return objectValue;
    }
    public String[] getMergeColumnKeys() {
		return new String[]{"number"};//,"createTime","creator.number","creator.name","lastUpdateTime","lastUpdateUser.number","lastUpdateUser.name"
	}
}