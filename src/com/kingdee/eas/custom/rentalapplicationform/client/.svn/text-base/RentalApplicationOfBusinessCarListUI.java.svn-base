/**
 * output package name
 */
package com.kingdee.eas.custom.rentalapplicationform.client;

import java.awt.event.ActionEvent;

import org.apache.log4j.Logger;

import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.eas.util.client.EASResource;

/**
 * output class name
 */
public class RentalApplicationOfBusinessCarListUI extends AbstractRentalApplicationOfBusinessCarListUI
{
    private static final Logger logger = CoreUIObject.getLogger(RentalApplicationOfBusinessCarListUI.class);
    
    /**
     * output class constructor
     */
    public RentalApplicationOfBusinessCarListUI() throws Exception
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
     * output tblMain_tableClicked method
     */
    protected void tblMain_tableClicked(com.kingdee.bos.ctrl.kdf.table.event.KDTMouseEvent e) throws Exception
    {
        super.tblMain_tableClicked(e);
    }

    /**
     * output tblMain_tableSelectChanged method
     */
    protected void tblMain_tableSelectChanged(com.kingdee.bos.ctrl.kdf.table.event.KDTSelectEvent e) throws Exception
    {
        super.tblMain_tableSelectChanged(e);
    }

    /**
     * output getBizInterface method
     */
    protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
    {
        return com.kingdee.eas.custom.rentalapplicationform.RentalApplicationOfBusinessCarFactory.getRemoteInstance();
    }

    /**
     * output createNewData method
     */
    protected com.kingdee.bos.dao.IObjectValue createNewData()
    {
        com.kingdee.eas.custom.rentalapplicationform.RentalApplicationOfBusinessCarInfo objectValue = new com.kingdee.eas.custom.rentalapplicationform.RentalApplicationOfBusinessCarInfo();
		
        return objectValue;
    }

    /**
     * …Û∫À
     */
	@Override
	public void actionAudit_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		super.actionAudit_actionPerformed(e);
		refreshList();
	}

	/**
	 * ∑¥…Û∫À
	 */
	@Override
	public void actionUnAudit_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		super.actionUnAudit_actionPerformed(e);
		refreshList();
	}

	@Override
	public void onLoad() throws Exception {
		// TODO Auto-generated method stub
		super.onLoad();
		this.btnAudit.setIcon(EASResource.getIcon("imgTbtn_audit"));
		this.btnUnAudit.setIcon(EASResource.getIcon("imgTbtn_unaudit"));
		btnTraceUp.setVisible(false);
		btnTraceDown.setVisible(false);
	}

}