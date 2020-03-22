/**
 * output package name
 */
package com.kingdee.eas.farm.stocking.basedata.client;

import org.apache.log4j.Logger;

import com.kingdee.bos.ctrl.swing.KDDatePicker;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.eas.basedata.org.client.f7.CompanyF7;
import com.kingdee.eas.common.client.SysContext;

/**
 * output class name
 */
public class StockingPeriodEditUI extends AbstractStockingPeriodEditUI
{
    private static final Logger logger = CoreUIObject.getLogger(StockingPeriodEditUI.class);
    
    /**
     * output class constructor
     */
    public StockingPeriodEditUI() throws Exception
    {
        super();
    }

    /**
     * output getBizInterface method
     */
    protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
    {
        return com.kingdee.eas.farm.stocking.basedata.StockingPeriodFactory.getRemoteInstance();
    }

    /**
     * output createNewData method
     */
    protected com.kingdee.bos.dao.IObjectValue createNewData()
    {
        com.kingdee.eas.farm.stocking.basedata.StockingPeriodInfo objectValue = new com.kingdee.eas.farm.stocking.basedata.StockingPeriodInfo();
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
		((KDDatePicker)kdtPeriodEntry.getColumn("beginDate").getEditor().getComponent()).setDatePattern("yyyy-MM-dd");
		((KDDatePicker)kdtPeriodEntry.getColumn("endDate").getEditor().getComponent()).setDatePattern("yyyy-MM-dd");
	}

}