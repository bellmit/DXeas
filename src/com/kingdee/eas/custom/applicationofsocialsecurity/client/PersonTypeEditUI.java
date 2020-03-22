/**
 * output package name
 */
package com.kingdee.eas.custom.applicationofsocialsecurity.client;

import java.awt.event.*;
import org.apache.log4j.Logger;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.eas.framework.*;

/**
 * output class name
 */
public class PersonTypeEditUI extends AbstractPersonTypeEditUI
{
    private static final Logger logger = CoreUIObject.getLogger(PersonTypeEditUI.class);
    
    /**
     * output class constructor
     */
    public PersonTypeEditUI() throws Exception
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
     * output actionSave_actionPerformed
     */
    public void actionSave_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionSave_actionPerformed(e);
    }

    /**
     * output actionSubmit_actionPerformed
     */
    public void actionSubmit_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionSubmit_actionPerformed(e);
    }

    /**
     * output actionCancel_actionPerformed
     */
    public void actionCancel_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionCancel_actionPerformed(e);
    }

    /**
     * output actionCancelCancel_actionPerformed
     */
    public void actionCancelCancel_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionCancelCancel_actionPerformed(e);
    }

    /**
     * output getBizInterface method
     */
    protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
    {
        return com.kingdee.eas.custom.applicationofsocialsecurity.PersonTypeFactory.getRemoteInstance();
    }

    /**
     * output createNewData method
     */
    protected com.kingdee.bos.dao.IObjectValue createNewData()
    {
        com.kingdee.eas.custom.applicationofsocialsecurity.PersonTypeInfo objectValue = new com.kingdee.eas.custom.applicationofsocialsecurity.PersonTypeInfo();
        objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));
		
        return objectValue;
    }
	@Override
	public void onLoad() throws Exception {
		// TODO Auto-generated method stub

		setUI();
		super.onLoad();
	}
	
	/**
	 * 界面调整
	 */
	private void setUI() {
		// TODO Auto-generated method stub
		btnCopy.setVisible(false);
		btnCancel.setEnabled(true);
		btnCancelCancel.setEnabled(true);
		btnFirst.setVisible(false);
		btnLast.setVisible(false);
		MenuService.setVisible(false);
		menuHelp.setVisible(false);
	}

}