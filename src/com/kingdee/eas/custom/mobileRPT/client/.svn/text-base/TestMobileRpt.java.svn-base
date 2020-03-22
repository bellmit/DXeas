/**
 * output package name
 */
package com.kingdee.eas.custom.mobileRPT.client;

import java.awt.Event;
import java.awt.event.*;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.log4j.Logger;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.eas.custom.mobileRPT.functions.HRRpt;
import com.kingdee.eas.framework.*;

/**
 * output class name   com.kingdee.eas.custom.mobileRPT.client.TestMobileRpt
 */
public class TestMobileRpt extends AbstractTestMobileRpt
{
    private static final Logger logger = CoreUIObject.getLogger(TestMobileRpt.class);
    
    /**
     * output class constructor
     */
    public TestMobileRpt() throws Exception
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

	@Override
	public void onLoad() throws Exception {
		// TODO Auto-generated method stub
		super.onLoad();
		final JSONObject jo = new JSONObject();
		jo.put("bizDate", "2018-07-15");
		this.test.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				HRRpt hr = new HRRpt();
				try {
					JSONArray downloadData = hr.downloadData(null, jo);
					System.out.println(downloadData.toString());
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
	}

}