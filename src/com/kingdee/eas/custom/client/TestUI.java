/**
 * output package name
 */
package com.kingdee.eas.custom.client;

import java.awt.event.ActionEvent;

import net.sf.json.JSONObject;

import org.apache.log4j.Logger;

import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.eas.basedata.org.client.BizOrgRangeF7PromptDialog;
import com.kingdee.eas.common.client.SysContext;
import com.kingdee.eas.custom.lhsm.ForecastOrderFacadeFactory;
import com.kingdee.eas.util.client.MsgBox;

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
        this.setUITitle("测试界面");

        BizOrgRangeF7PromptDialog f7=new BizOrgRangeF7PromptDialog(SysContext.getSysContext().getCurrentUserInfo());
        f7.setIsCUFilter(true);
        f7.setMultiSelect(false);
        //f7.setTitle("组织hha");
//        this.kDBizPromptBox1.setSelector(f7);
    }

    /**
     * output storeFields method
     */
    public void storeFields()
    {
        super.storeFields();
    }

	@Override
	protected void btnTest_actionPerformed(ActionEvent e) throws Exception {
//		Object dd = testFacadeFactory.getRemoteInstance().getTest(null);
		JSONObject json=new JSONObject();
//		json.put("id", "E3sAAAAOJRr/r9tP");
//		Object dd = ForecastOrderFacadeFactory.getRemoteInstance().downloadBillData(jsonStr);
		json.put("bosType", "FFAFDB4F");
		json.put("queryStr", "where company.number='11'");
		Object dd = ForecastOrderFacadeFactory.getRemoteInstance().downloadBillList(json.toString());
//		Object dd = ForecastOrderFacadeFactory.getRemoteInstance().uploadBillData(jsonStr);
		MsgBox.showInfo(dd.toString());
	}

}