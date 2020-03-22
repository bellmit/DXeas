/**
 * output package name
 */
package com.kingdee.eas.custom.stockprice.client;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.*;
import org.apache.log4j.Logger;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.eas.custom.wlhllicensemanager.util.WlhlManagerClientUtils;
import com.kingdee.eas.framework.*;
import com.kingdee.bos.ctrl.kdf.table.KDTable;

/**
 * output class name
 */
public class SalesPriceEditUI extends AbstractSalesPriceEditUI
{
	private static final Logger logger = CoreUIObject.getLogger(SalesPriceEditUI.class);

	/**
	 * output class constructor
	 */
	public SalesPriceEditUI() throws Exception
	{
		super();
		double width = Toolkit.getDefaultToolkit().getScreenSize().getWidth();
        double height = Toolkit.getDefaultToolkit().getScreenSize().getHeight();
		this.setPreferredSize(new Dimension((int)(width*0.8),(int)(height*0.8)));
    
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
		return com.kingdee.eas.custom.stockprice.SalesPriceFactory.getRemoteInstance();
	}

	/**
	 * output createNewDetailData method
	 */
	protected IObjectValue createNewDetailData(KDTable table)
	{

		return null;
	}

	@Override
	public void onLoad() throws Exception {
		// TODO Auto-generated method stub
		super.onLoad();
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



		contLastUpdateUser.setVisible(true);
		contauditDate.setEnabled(false);
		actionRemove.setVisible(false);
		WlhlManagerClientUtils.addTableQuerySearchPanel(kdtEntrys);
//		if(editData.getId()==null)
//			com.kingdee.eas.custom.stockprice.saveRealTimeInventoryFacadeFactory.getRemoteInstance().saveMaterialBasePrice();
		
		
	}
	/**
	 * output createNewData method
	 */
	protected com.kingdee.bos.dao.IObjectValue createNewData()
	{
		com.kingdee.eas.custom.stockprice.SalesPriceInfo objectValue = new com.kingdee.eas.custom.stockprice.SalesPriceInfo();
		objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));

		return objectValue;
	}

}