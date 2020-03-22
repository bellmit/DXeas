/**
 * output package name
 */
package com.kingdee.eas.farm.stocking.hatch.client;

import java.awt.event.ActionEvent;

import org.apache.log4j.Logger;

import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.eas.basedata.org.client.f7.CompanyF7;
import com.kingdee.eas.common.client.SysContext;

/**
 * output class name
 */
public class SecondAllotEditUI extends AbstractSecondAllotEditUI
{
    private static final Logger logger = CoreUIObject.getLogger(SecondAllotEditUI.class);
    
    /**
     * output class constructor
     */
    public SecondAllotEditUI() throws Exception
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
     * output getBizInterface method
     */
    protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
    {
        return com.kingdee.eas.farm.stocking.hatch.SecondAllotFactory.getRemoteInstance();
    }

    /**
     * output createNewData method
     */
    protected com.kingdee.bos.dao.IObjectValue createNewData()
    {
        com.kingdee.eas.farm.stocking.hatch.SecondAllotInfo objectValue = new com.kingdee.eas.farm.stocking.hatch.SecondAllotInfo();
        objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));
        objectValue.setCompany(SysContext.getSysContext().getCurrentFIUnit());
        return objectValue;
    }
	@Override
	public void onLoad() throws Exception {
		// TODO Auto-generated method stub
		super.onLoad();
		CompanyF7 cf7=new CompanyF7();
		cf7.setIsCUFilter(true);
		this.prmtcompany.setSelector(cf7);
	}
    

}