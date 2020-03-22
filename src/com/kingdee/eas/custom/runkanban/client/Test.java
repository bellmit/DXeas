/**
 * output package name
 */
package com.kingdee.eas.custom.runkanban.client;

import java.awt.event.*;

import net.sf.json.JSONObject;

import org.apache.log4j.Logger;

import com.ibm.db2.jcc.t4.ob;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.eas.base.codingrule.util.ParmCodingRule;
import com.kingdee.eas.custom.runkanban.runKanbanFacadeFactory;
import com.kingdee.eas.custom.runkanban.common.CommonExportUtils;
import com.kingdee.eas.framework.*;

/**
 * output class name
 */
public class Test extends AbstractTest
{
    private static final Logger logger = CoreUIObject.getLogger(Test.class);
    
    /**
     * output class constructor
     */
    public Test() throws Exception
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
    	
        JSONObject paramobj=new JSONObject();
        paramobj.put("fbizdate", "2016-04-21");
        paramobj.put("parentGroupNumber","02!0204!020401");
        JSONObject object=new JSONObject();
        object.put("userNum", "user");
        object.put("queryType", QueryType.食品厂月销量统计按物料小类_VALUE);
        object.put("paramStr", paramobj.toString());
        String result= runKanbanFacadeFactory.getRemoteInstance().getDataFromJsonCondition(object.toString());
        System.out.println("result:"+result);
    }

}