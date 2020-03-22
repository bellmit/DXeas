/**
 * output package name
 */
package com.kingdee.eas.weighbridge.client;

import java.awt.event.ActionEvent;

import org.apache.log4j.Logger;

import com.kingdee.bos.ui.face.CoreUIObject;

/**
 * output class name
 */
public class WMsgBoxUI extends AbstractWMsgBoxUI
{
    private static final Logger logger = CoreUIObject.getLogger(WMsgBoxUI.class);
    
    /**
     * output class constructor
     */
    public WMsgBoxUI() throws Exception
    {
        super();
        this.setUITitle("³¬³öÎó²î·¶Î§ÌáÐÑ");
    }

    @Override
	public void onLoad() throws Exception {
		// TODO Auto-generated method stub
		super.onLoad();
		if(this.getUIContext().containsKey("this.getUIContext()")&&this.getUIContext().get("bagDiff")!=null) {
			this.lblShow.setText(this.lblShow+"("+this.getUIContext().get("bagDiff").toString()+"");
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
     * output btnActual_actionPerformed method
     */
    @Override
    protected void btnActual_actionPerformed(java.awt.event.ActionEvent e) throws Exception
    {
        this.getUIContext().put("result", "actual");
        this.destroyWindow();
    }

    /**
     * output btnCancel_actionPerformed method
     */
    @Override
    protected void btnCancel_actionPerformed(java.awt.event.ActionEvent e) throws Exception
    {
    	 this.getUIContext().put("result", "cancel");
         this.destroyWindow();
    }

	@Override
	protected void btnSaveTemp_actionPerformed(ActionEvent e) throws Exception {
		this.getUIContext().put("result", "temp");
        this.destroyWindow();
	}
    
}