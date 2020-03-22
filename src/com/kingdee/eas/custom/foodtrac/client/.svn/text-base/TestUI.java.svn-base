/**
 * output package name
 */
package com.kingdee.eas.custom.foodtrac.client;

import java.awt.event.*;

import net.sf.json.JSONObject;

import org.apache.log4j.Logger;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.eas.custom.foodtrac.traceFacadeFactory;
import com.kingdee.eas.custom.foodtrac.app.traceFacadeControllerBean;
import com.kingdee.eas.framework.*;
import com.kingdee.eas.util.app.DbUtil;

/**
 * output class name
 */
public class TestUI extends AbstractTestUI
{
    private static final Logger logger = CoreUIObject.getLogger(TestUI.class);
    
    /**
     * output class constructor
     */
    public TestUI() throws Exception
    {
        super();
    }

    /**
     * output storeFields method
     */
    public void storeFields()
    {
        super.storeFields();
    }

    /**
     * output kDButton1_actionPerformed method
     */
    protected void kDButton1_actionPerformed(java.awt.event.ActionEvent e) throws Exception
    {
    	
//        super.kDButton1_actionPerformed(e);
    	JSONObject jsonObject=new JSONObject();
    	jsonObject.put("batchCode", "_4_04-000091_16062202");//ÌõÂë
    	jsonObject.put("type", "base");
    	String result=traceFacadeFactory.getRemoteInstance().getDataFromJsonCondition(jsonObject.toString());
    	System.out.println("×·ËÝ½á¹ûjsonarray£º"+result);
    	
    }
    
}