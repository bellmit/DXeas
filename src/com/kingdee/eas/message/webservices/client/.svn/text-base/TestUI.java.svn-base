/**
 * output package name
 */
package com.kingdee.eas.message.webservices.client;

import net.sf.json.JSONObject;

import org.apache.log4j.Logger;

import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.eas.message.webservices.DataUniFormFacadeFactory;

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
     * output btnOK_actionPerformed method
     */
    protected void btnOK_actionPerformed(java.awt.event.ActionEvent e) throws Exception
    {
//    	JSONObject json=new JSONObject();
//    	json.put("role", "manager");//manager
//    	json.put("userNum", "ÇÇØ§Ô¶");
//    	json.put("queryType", "byday");//byday\byManageUnit
//    	json.put("beginDate", "2015-11-01");
//    	json.put("endDate", "2016-01-30");
//    	json.put("orgNums", null);//jsonarray[String]
//    	String result=DataUniFormFacadeFactory.getRemoteInstance().getDataFromJsonCondition(json.toString());
//    	System.out.println(result);
    	
    	JSONObject json=new JSONObject();
//    	json.put("role", "manager");//manager
    	json.put("userName", "ÇÇØ§Ô¶");
//    	json.put("queryType", "byday");//byday\byManageUnit
    	json.put("beginDate", "2015-11-01");
    	json.put("endDate", "2016-01-30");
//    	json.put("orgNums", null);//jsonarray[String]
    	String result=DataUniFormFacadeFactory.getRemoteInstance().getOrderStatusFromJsonCondition(json.toString());
    	System.out.println(result);
    	
    }

}