/**
 * output package name
 */
package com.kingdee.eas.custom.stockprice.client;

import java.awt.event.*;
import org.apache.log4j.Logger;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.eas.framework.*;
import com.kingdee.bos.ctrl.kdf.table.KDTable;

/**
 * output class name
 */
public class RealTimeInventoryEditUI extends AbstractRealTimeInventoryEditUI
{
	private static final Logger logger = CoreUIObject.getLogger(RealTimeInventoryEditUI.class);

	/**
	 * output class constructor
	 */
	public RealTimeInventoryEditUI() throws Exception
	{
		super();
	}
	/**
	 * output loadFields method
	 */
	public void loadFields()
	{
		/*
    	_______________#########_______________________
    	______________############_____________________
    	______________#############____________________
    	_____________##__###########___________________
    	____________###__######_#####__________________
    	____________###_#######___####_________________
    	___________###__##########_####________________
    	__________####__###########_####_______________
    	________#####___###########__#####_____________
    	_______######___###_########___#####___________
    	_______#####___###___########___######_________
    	______######___###__###########___######_______
    	_____######___####_##############__######______
    	____#######__#####################_#######_____
    	____#######__##############################____
    	___#######__######_#################_#######___
    	___#######__######_######_#########___######___
    	___#######____##__######___######_____######___
    	___#######________######____#####_____#####____
    	____######________#####_____#####_____####_____
    	_____#####________####______#####_____###______
    	______#####______;###________###______#________
    	________##_______####________####______________
    	                           ´Ð¹Ù´Í¸£                                    °ÙÎÞ½û¼É                
		 */
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
	 * output btnAddLine_actionPerformed method
	 */
	protected void btnAddLine_actionPerformed(java.awt.event.ActionEvent e) throws Exception
	{
		super.btnAddLine_actionPerformed(e);
	}

	/**
	 * output menuItemEnterToNextRow_itemStateChanged method
	 */
	protected void menuItemEnterToNextRow_itemStateChanged(java.awt.event.ItemEvent e) throws Exception
	{
		super.menuItemEnterToNextRow_itemStateChanged(e);
	}

	/**
	 * output getBizInterface method
	 */
	protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
	{
		return com.kingdee.eas.custom.stockprice.RealTimeInventoryFactory.getRemoteInstance();
	}

	@Override
	public void onLoad() throws Exception {
		// TODO Auto-generated method stub
		super.onLoad();
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
		com.kingdee.eas.custom.stockprice.RealTimeInventoryInfo objectValue = new com.kingdee.eas.custom.stockprice.RealTimeInventoryInfo();
		objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));

		return objectValue;
	}

}