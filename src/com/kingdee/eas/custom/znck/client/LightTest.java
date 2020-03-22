/**
 * output package name
 */
package com.kingdee.eas.custom.znck.client;

import java.awt.event.*;
import org.apache.log4j.Logger;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.eas.custom.wsclient.Ctr_LedSoapProxy;
import com.kingdee.eas.framework.*;

/**
 * output class name
 */
public class LightTest extends AbstractLightTest
{
    private static final Logger logger = CoreUIObject.getLogger(LightTest.class);
    
    // µ∆øÿ÷∆Ω”ø⁄
    Ctr_LedSoapProxy proxy;
    /**
     * output class constructor
     */
    public LightTest() throws Exception
    {
        super();
        
        proxy = new Ctr_LedSoapProxy();
    }

    /**
     * output storeFields method
     */
    public void storeFields()
    {
        super.storeFields();
    }
    
    
    /**
     * ¡¡µ∆
     * output btnLightOn_actionPerformed method
     */
    protected void btnLightOn_actionPerformed(java.awt.event.ActionEvent e) throws Exception
    {

    	String comNum = this.tfComNum.getText();
    	String btl = this.tfBTL.getText();
    	
    	int lightNum = this.ftLightNum.getIntegerValue();
    	
    	// ¡¡µ∆
    	String lightResult  = proxy.lighten(comNum, btl, lightNum);
    	this.tfResult.setText(lightResult);
    	
    }
    
    /**
     * output btnLightOff_actionPerformed method
     */
    protected void btnLightOff_actionPerformed(java.awt.event.ActionEvent e) throws Exception
    {
    	String comNum = this.tfComNum.getText();
    	String btl = this.tfBTL.getText();
    	
    	int lightNum = this.ftLightNum.getIntegerValue();
    	
    	// ¡¡µ∆
    	String lightResult  = proxy.extinguish(comNum, btl, lightNum);
    	this.tfResult.setText(lightResult);
    }

    /**
     * output btnAllOff_actionPerformed method
     */
    protected void btnAllOff_actionPerformed(java.awt.event.ActionEvent e) throws Exception
    {
    	String comNum = this.tfComNum.getText();
    	String btl = this.tfBTL.getText();
    	// ¡¡µ∆
    	String lightResult  = proxy.allOut(comNum, btl);
    	this.tfResult.setText(lightResult);
    }

}