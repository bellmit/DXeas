/**
 * output package name
 */
package com.kingdee.eas.farm.carnivorous.basedata.client;

import java.awt.event.*;
import org.apache.log4j.Logger;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.eas.basedata.org.client.f7.CompanyF7;
import com.kingdee.eas.basedata.org.client.f7.CostCenterF7;
import com.kingdee.eas.basedata.org.client.f7.StorageF7;
import com.kingdee.eas.common.client.SysContext;
import com.kingdee.eas.farm.stocking.basedata.AccountTypeEnum;
import com.kingdee.eas.framework.*;

/**
 * output class name
 */
public class SystemSettingEditUI extends AbstractSystemSettingEditUI
{
    private static final Logger logger = CoreUIObject.getLogger(SystemSettingEditUI.class);
    
    /**
     * output class constructor
     */
    public SystemSettingEditUI() throws Exception
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
        return com.kingdee.eas.farm.carnivorous.basedata.SystemSettingFactory.getRemoteInstance();
    }

    /**
     * output createNewData method
     */
    protected com.kingdee.bos.dao.IObjectValue createNewData()
    {
        com.kingdee.eas.farm.carnivorous.basedata.SystemSettingInfo objectValue = new com.kingdee.eas.farm.carnivorous.basedata.SystemSettingInfo();
        objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));
        objectValue.setCompany(SysContext.getSysContext().getCurrentFIUnit());
        objectValue.setAccountType(AccountTypeEnum.farmer);
        return objectValue;
    }
	@Override
	public void onLoad() throws Exception {
		// TODO Auto-generated method stub
		super.onLoad();
		CompanyF7 cf7=new CompanyF7();
		cf7.setIsCUFilter(true);
		this.prmtcompany.setSelector(cf7);
		
		StorageF7 sf7=new StorageF7();
		sf7.setIsCUFilter(false);
		((KDBizPromptBox)this.kdtStorageEntry.getColumn("storageOrgUnit").getEditor().getComponent()).setSelector(sf7);
		
		
		StorageF7 sf72=new StorageF7();
		sf72.setIsCUFilter(true);
		this.prmtdefaultStorageOrgUnit.setSelector(sf72);
		
		CostCenterF7 cof7=new CostCenterF7();
		cof7.setIsCUFilter(true);
		cof7.setShowVirtual(true);
		this.prmtparentCostCenter.setSelector(cof7);
		
		
		this.prmtcostGroup.setQueryInfo("com.kingdee.eas.farm.stocking.basedata.app.StockingF7CostObjectQuery");
		
		/*EntityViewInfo ev=new EntityViewInfo();
		FilterInfo filter=new FilterInfo();
		ev.setFilter(filter);
		prmtcostGroup.setEntityViewInfo(ev);*/
		
		
	}

}