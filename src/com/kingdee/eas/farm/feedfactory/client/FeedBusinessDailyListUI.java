/**
 * output package name
 */
package com.kingdee.eas.farm.feedfactory.client;

import java.awt.event.*;

import org.apache.log4j.Logger;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.eas.framework.*;
import com.kingdee.eas.util.client.MsgBox;
import com.kingdee.eas.wlhlcomm.FarmException;

/**
 * output class name
 */
public class FeedBusinessDailyListUI extends AbstractFeedBusinessDailyListUI
{
    private static final Logger logger = CoreUIObject.getLogger(FeedBusinessDailyListUI.class);
    
    /**
     * output class constructor
     */
    public FeedBusinessDailyListUI() throws Exception
    {
        super();
    }

    /**
     * 界面初始化 
     */
    @Override
	public void onLoad() throws Exception {
		super.onLoad();
		// 设置全屏
//		this.setPreferredSize(Toolkit.getDefaultToolkit().getScreenSize());
		
		this.btnAudit.setIcon(com.kingdee.eas.util.client.EASResource.getIcon("imgTbtn_audit"));
		this.btnUnAudit.setIcon(com.kingdee.eas.util.client.EASResource.getIcon("imgTbtn_unaudit"));
		
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
        return com.kingdee.eas.farm.feedfactory.FeedBusinessDailyFactory.getRemoteInstance();
    }

    /**
     * output createNewData method
     */
    protected com.kingdee.bos.dao.IObjectValue createNewData()
    {
        com.kingdee.eas.farm.feedfactory.FeedBusinessDailyInfo objectValue = new com.kingdee.eas.farm.feedfactory.FeedBusinessDailyInfo();
		
        return objectValue;
    }
    

    /**
     * 审核
     */
	@Override
	public void actionAudit_actionPerformed(ActionEvent e) throws Exception {
		try{
			super.actionAudit_actionPerformed(e);
			MsgBox.showInfo("审核完成");
			
			this.refreshList();
			this.setMessageText("审核完成");
			this.showMessage();
		}catch(FarmException fe){
			MsgBox.showError(fe.getMessage());
		}
	}

	/**
	 * 反审核
	 */
	@Override
	public void actionUnAudit_actionPerformed(ActionEvent e) throws Exception {
		try{
			super.actionUnAudit_actionPerformed(e);
			MsgBox.showInfo("反审核完成");
			
			this.refreshList();
			this.setMessageText("反审核完成");
			this.showMessage();
		}catch(FarmException fe){
			MsgBox.showError(fe.getMessage());
		}
	}

}