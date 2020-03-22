/**
 * output package name
 */
package com.kingdee.eas.custom.taihe.weight.client;

import java.awt.event.*;
import org.apache.log4j.Logger;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.eas.basedata.org.client.f7.CompanyF7;
import com.kingdee.eas.common.client.SysContext;
import com.kingdee.eas.framework.*;

/**
 * output class name
 */
public class WgtDisRateEditUI extends AbstractWgtDisRateEditUI
{
    private static final Logger logger = CoreUIObject.getLogger(WgtDisRateEditUI.class);
    
    /**
     * output class constructor
     */
    public WgtDisRateEditUI() throws Exception
    {
        super();
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
     * output getBizInterface method
     */
    protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
    {
        return com.kingdee.eas.custom.taihe.weight.WgtDisRateFactory.getRemoteInstance();
    }

    /**
     * output createNewData method
     */
    protected com.kingdee.bos.dao.IObjectValue createNewData()
    {
        com.kingdee.eas.custom.taihe.weight.WgtDisRateInfo objectValue = new com.kingdee.eas.custom.taihe.weight.WgtDisRateInfo();
        objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));
        objectValue.setCompany(SysContext.getSysContext().getCurrentFIUnit());
        objectValue.setCU(SysContext.getSysContext().getCurrentCtrlUnit());
        return objectValue;
    }
	@Override
	public void onLoad() throws Exception {
		// TODO Auto-generated method stub
		super.onLoad();
		kdtEntrys.getColumn("seq").getStyleAttributes().setHided(true);
		CompanyF7 cf7=new CompanyF7();
		this.prmtcompany.setSelector(cf7);
	}

}