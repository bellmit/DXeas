/**
 * output package name
 */
package com.kingdee.eas.farm.breed.brood.client;

import java.awt.event.*;
import org.apache.log4j.Logger;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.eas.basedata.org.StorageOrgUnitFactory;
import com.kingdee.eas.basedata.org.StorageOrgUnitInfo;
import com.kingdee.eas.basedata.scm.im.inv.WarehouseInfo;
import com.kingdee.eas.farm.breed.HenhouseInfo;
import com.kingdee.eas.framework.*;
import com.kingdee.bos.ctrl.kdf.table.KDTable;
import com.kingdee.bos.ctrl.swing.event.DataChangeEvent;

/**
 * output class name
 */
public class BroodCoopSetEditUI extends AbstractBroodCoopSetEditUI
{
    private static final Logger logger = CoreUIObject.getLogger(BroodCoopSetEditUI.class);
    
    /**
     * output class constructor
     */
    public BroodCoopSetEditUI() throws Exception
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
        return com.kingdee.eas.farm.breed.brood.BroodCoopSetFactory.getRemoteInstance();
    }

    /**
     * output createNewDetailData method
     */
    protected IObjectValue createNewDetailData(KDTable table)
    {
		
        return null;
    }

    /**
     * output createNewData method
     */
    protected com.kingdee.bos.dao.IObjectValue createNewData()
    {
        com.kingdee.eas.farm.breed.brood.BroodCoopSetInfo objectValue = new com.kingdee.eas.farm.breed.brood.BroodCoopSetInfo();
        objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));
		
        return objectValue;
    }
    
    /**
     * 鸡舍 选中时 自动将 库存组织带出
     */
	@Override
	protected void prmthenhouse_dataChanged(DataChangeEvent e) throws Exception {
		HenhouseInfo wsInfo = (HenhouseInfo) this.prmthenhouse.getValue();
		if(wsInfo != null){
//			StorageOrgUnitInfo stoInfo = wsInfo.getChickenFarm();
//			if(stoInfo != null){
//				stoInfo = StorageOrgUnitFactory.getRemoteInstance().getStorageOrgUnitInfo(new ObjectUuidPK(stoInfo.getId()));
//			}
//			this.prmtstoOrg.setValue(stoInfo);
		}
	}

    
}