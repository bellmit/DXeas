/**
 * output package name
 */
package com.kingdee.eas.custom.eas2temp.client;

import java.awt.event.ActionEvent;

import org.apache.log4j.Logger;

import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.eas.util.client.MsgBox;

/**
 * output class name
 */
public class ProductStatusSetUI extends AbstractProductStatusSetUI
{
    private static final Logger logger = CoreUIObject.getLogger(ProductStatusSetUI.class);
    
    /**
     * output class constructor
     */
    public ProductStatusSetUI() throws Exception
    {
        super();
        this.setUITitle("生产状态设置");
    }

    /**
     * output storeFields method
     */
    public void storeFields()
    {
        super.storeFields();
    }

    /**
     * output btnCancel_actionPerformed method
     */
    protected void btnCancel_actionPerformed(java.awt.event.ActionEvent e) throws Exception
    {
       this.destroyWindow();
    }

    /**
     * output btnOK_actionPerformed method
     */
    protected void btnOK_actionPerformed(java.awt.event.ActionEvent e) throws Exception
    {
    	if(this.cmbStatus.getSelectedIndex()==-1) {
    		MsgBox.showWarning("请选择生产状态");
    		return;
    	}
        this.getUIContext().put("result",this.cmbStatus.getSelectedItem());
        this.destroyWindow();
    }

}