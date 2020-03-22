/**
 * output package name
 */
package com.kingdee.eas.custom.applicationofsocialsecurity.client;

import java.awt.event.*;

import org.apache.log4j.Logger;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.eas.custom.applicationofsocialsecurity.DataBaseConnection;
import com.kingdee.eas.custom.applicationofsocialsecurity.DataBaseConnectionFactory;
import com.kingdee.eas.custom.applicationofsocialsecurity.DataBaseConnectionInfo;
import com.kingdee.eas.framework.*;

/**
 * output class name
 */
public class DataBaseConnectionListUI extends AbstractDataBaseConnectionListUI
{
	private static final Logger logger = CoreUIObject.getLogger(DataBaseConnectionListUI.class);

	/**
	 * output class constructor
	 */
	public DataBaseConnectionListUI() throws Exception
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
	 * output menuItemImportData_actionPerformed method
	 */
	protected void menuItemImportData_actionPerformed(java.awt.event.ActionEvent e) throws Exception
	{
		super.menuItemImportData_actionPerformed(e);
	}

	/**
	 * output getBizInterface method
	 */
	protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
	{
		return com.kingdee.eas.custom.applicationofsocialsecurity.DataBaseConnectionFactory.getRemoteInstance();
	}

	/**
	 * output createNewData method
	 */
	protected com.kingdee.bos.dao.IObjectValue createNewData()
	{
		com.kingdee.eas.custom.applicationofsocialsecurity.DataBaseConnectionInfo objectValue = new com.kingdee.eas.custom.applicationofsocialsecurity.DataBaseConnectionInfo();

		return objectValue;
	}

	@Override
	public void onLoad() throws Exception {
		// TODO Auto-generated method stub
		super.onLoad();
		btnCancel.setVisible(true);
		btnCancelCancel.setVisible(true);
		tblMain.getColumn("name").setWidth(200);
		tblMain.getColumn("createTime").setWidth(180);
		tblMain.getColumn("lastUpdateTime").setWidth(180);
	}

	/**
	 * Ω˚”√
	 */
	@Override
	public void actionCancel_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		super.actionCancel_actionPerformed(e);
		refreshList();
	}
	/**
	 * ∆Ù”√
	 */
	@Override
	public void actionCancelCancel_actionPerformed(ActionEvent e)
	throws Exception {
		// TODO Auto-generated method stub
		super.actionCancelCancel_actionPerformed(e);
		if(this.getSelectedKeyValue()==null||this.getSelectedKeyValue().equals(""))
			return;
		DataBaseConnectionInfo info = DataBaseConnectionFactory.getRemoteInstance().getDataBaseConnectionInfo(new ObjectUuidPK(this.getSelectedKeyValue()));
		DataBaseConnectionFactory.getRemoteInstance().cancelCancel(new ObjectUuidPK(this.getSelectedKeyValue()), info);
		refreshList();
	}

}