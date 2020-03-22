/**
 * output package name
 */
package com.kingdee.eas.custom.taihe.weight.client;

import java.awt.Dimension;
import java.awt.Toolkit;
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
public class TransportCoeEditUI extends AbstractTransportCoeEditUI
{
    private static final Logger logger = CoreUIObject.getLogger(TransportCoeEditUI.class);
    
    /**
     * output class constructor
     */
    public TransportCoeEditUI() throws Exception
    {
        super();
        double width = Toolkit.getDefaultToolkit().getScreenSize().getWidth();
        double height = Toolkit.getDefaultToolkit().getScreenSize().getHeight();
		this.setPreferredSize(new Dimension((int)(width*0.8),(int)(height*0.8)));
    }
    /**
     * output loadFields method
     */
    public void loadFields()
    {
        super.loadFields();
    }

    @Override
	public void onLoad() throws Exception {
		// TODO Auto-generated method stub
		super.onLoad();
		kdtEntry.getColumn("seq").getStyleAttributes().setHided(true);
		CompanyF7 cf7=new CompanyF7();
		this.prmtcompany.setSelector(cf7);
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
        return com.kingdee.eas.custom.taihe.weight.TransportCoeFactory.getRemoteInstance();
    }

    /**
     * output createNewData method
     */
    protected com.kingdee.bos.dao.IObjectValue createNewData()
    {
        com.kingdee.eas.custom.taihe.weight.TransportCoeInfo objectValue = new com.kingdee.eas.custom.taihe.weight.TransportCoeInfo();
        objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));
        objectValue.setCompany(SysContext.getSysContext().getCurrentFIUnit());
        objectValue.setCU(SysContext.getSysContext().getCurrentCtrlUnit());
        return objectValue;
    }
}