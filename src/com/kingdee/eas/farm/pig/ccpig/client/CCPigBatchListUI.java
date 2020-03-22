/**
 * output package name
 */
package com.kingdee.eas.farm.pig.ccpig.client;

import java.awt.event.ActionEvent;

import org.apache.log4j.Logger;

import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.eas.util.client.MsgBox;
import com.kingdee.eas.wlhlcomm.FarmException;

/**
 * output class name
 */
public class CCPigBatchListUI extends AbstractCCPigBatchListUI
{
    private static final Logger logger = CoreUIObject.getLogger(CCPigBatchListUI.class);
    
    /**
     * output class constructor
     */
    public CCPigBatchListUI() throws Exception
    {
        super();
        
        // ͼ��
        this.btnAudit.setIcon(com.kingdee.eas.util.client.EASResource.getIcon("imgTbtn_audit"));
		this.btnUnAudit.setIcon(com.kingdee.eas.util.client.EASResource.getIcon("imgTbtn_unaudit"));
    }

    /**
     * output getBizInterface method
     */
    protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
    {
        return com.kingdee.eas.farm.pig.ccpig.CCPigBatchFactory.getRemoteInstance();
    }

    /**
     * output createNewData method
     */
    protected com.kingdee.bos.dao.IObjectValue createNewData()
    {
        com.kingdee.eas.farm.pig.ccpig.CCPigBatchInfo objectValue = new com.kingdee.eas.farm.pig.ccpig.CCPigBatchInfo();
		
        return objectValue;
    }
    
    

    /**
     * ���
     */
	@Override
	public void actionAudit_actionPerformed(ActionEvent e) throws Exception {
		try{
			super.actionAudit_actionPerformed(e);
			MsgBox.showInfo("������");
			
			this.refreshList();
			this.setMessageText("������");
			this.showMessage();
		}catch(FarmException fe){
			MsgBox.showError(fe.getMessage());
		}
	}

	/**
	 * �����
	 */
	@Override
	public void actionUnAudit_actionPerformed(ActionEvent e) throws Exception {
		try{
			super.actionUnAudit_actionPerformed(e);
			MsgBox.showInfo("��������");
			
			this.refreshList();
			this.setMessageText("��������");
			this.showMessage();
		}catch(FarmException fe){
			MsgBox.showError(fe.getMessage());
		}
	}


}