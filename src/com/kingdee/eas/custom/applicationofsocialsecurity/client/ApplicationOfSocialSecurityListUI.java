/**
 * output package name
 */
package com.kingdee.eas.custom.applicationofsocialsecurity.client;

import java.awt.event.*;

import org.apache.log4j.Logger;

import com.kingdee.bos.metadata.entity.FilterInfo;
import com.kingdee.bos.metadata.entity.FilterItemInfo;
import com.kingdee.bos.metadata.query.util.CompareType;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.eas.common.client.SysContext;
import com.kingdee.eas.framework.*;
import com.kingdee.eas.util.client.EASResource;

/**
 * output class name
 */
public class ApplicationOfSocialSecurityListUI extends AbstractApplicationOfSocialSecurityListUI
{
    private static final Logger logger = CoreUIObject.getLogger(ApplicationOfSocialSecurityListUI.class);
    

    public ApplicationOfSocialSecurityListUI() throws Exception
    {
        super();
    }
    protected FilterInfo getDefaultFilterForQuery(){
    	FilterInfo filterNew = super.getDefaultFilterForQuery();
//    	FilterInfo filterNew = new FilterInfo();
		filterNew.getFilterItems().add(new FilterItemInfo("Entrys.seq",new Integer(1),CompareType.EQUALS));
		filterNew.getFilterItems().add(new FilterItemInfo("Entrys.seq",null,CompareType.EQUALS));
		
		
//		filterNew.setMaskString("#0 or #1");
		return filterNew;
        
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
        return com.kingdee.eas.custom.applicationofsocialsecurity.ApplicationOfSocialSecurityFactory.getRemoteInstance();
    }

    /**
     * output createNewData method
     */
    protected com.kingdee.bos.dao.IObjectValue createNewData()
    {
        com.kingdee.eas.custom.applicationofsocialsecurity.ApplicationOfSocialSecurityInfo objectValue = new com.kingdee.eas.custom.applicationofsocialsecurity.ApplicationOfSocialSecurityInfo();
        objectValue.setCU(SysContext.getSysContext().getCurrentCtrlUnit());
        
        return objectValue;
    }
	@Override
	public void actionAudit_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		super.actionAudit_actionPerformed(e);
		refreshList();
	}
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
		setUI();
	}
	private void setUI() {
		// TODO Auto-generated method stub
		//ÐÞ¸ÄÍ¼±ê
		this.btnAudit.setIcon(EASResource.getIcon("imgTbtn_audit"));
		this.btnUnAudit.setIcon(EASResource.getIcon("imgTbtn_unaudit"));
		tblMain.getColumn("entrys.idCardNo").setWidth(180);
		tblMain.getColumn("number").setWidth(160);
	}

}