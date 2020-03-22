/**
 * output package name
 */
package com.kingdee.eas.weighbridge.client;

import java.awt.event.*;
import java.util.Date;
import java.util.Map;

import org.apache.log4j.Logger;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.bos.ctrl.swing.KDWorkButton;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.eas.framework.*;
import com.kingdee.eas.weighbridge.bean.OrderWeightInfo;

/**
 * output class name
 */
public class PurorderUpdateLogEditUI extends AbstractPurorderUpdateLogEditUI
{
    private static final Logger logger = CoreUIObject.getLogger(PurorderUpdateLogEditUI.class);
    
    
    private String purorderBillNum;
    private String purorderBillID;
    /**
     * output class constructor
     */
    public PurorderUpdateLogEditUI() throws Exception
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
     * 加载界面时隐藏 除了 提交功能外所有其他功能按钮
     */
    @Override
	public void onLoad() throws Exception {
		
		super.onLoad();
		// 隐藏无用组件
		hideComponents();
		
		if("AddNew".equals(this.oprtState)){
			
			purorderBillID = (String) this.getUIContext().get("purOrderID");
			// 获取订单信息
			
		}else{
			this.actionSave.setVisible(false);
			this.actionSubmit.setVisible(false);
		}
	}
    /**
     * 影藏 无用组件
     */
    private void  hideComponents(){
    	this.mainPanel.setVisible(false);
		// 隐藏工具栏所有其他按钮
		this.actionAddNew.setVisible(false);
		this.actionEdit.setVisible(false);
		
		for (int i = 0; i < this.toolBar.getComponents().length; i++) {
			
			if (this.toolBar.getComponent(i).getName().equalsIgnoreCase("btnSubmit")) {
				continue;
			}
			if (this.toolBar.getComponent(i).getName().equalsIgnoreCase("btnSave")) {
				continue;
			}
			
			this.toolBar.getComponent(i).setVisible(false);
		}
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
        return com.kingdee.eas.weighbridge.PurorderUpdateLogFactory.getRemoteInstance();
    }

    /**
     * output createNewData method
     */
    protected com.kingdee.bos.dao.IObjectValue createNewData()
    {
        com.kingdee.eas.weighbridge.PurorderUpdateLogInfo objectValue = new com.kingdee.eas.weighbridge.PurorderUpdateLogInfo();
        objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));
		
        return objectValue;
    }

}