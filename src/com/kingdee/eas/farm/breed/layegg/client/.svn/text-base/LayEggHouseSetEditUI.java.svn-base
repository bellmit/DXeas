/**
 * output package name
 */
package com.kingdee.eas.farm.breed.layegg.client;

import java.awt.event.*;

import org.apache.log4j.Logger;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.eas.basedata.org.StorageOrgUnitFactory;
import com.kingdee.eas.basedata.org.StorageOrgUnitInfo;
import com.kingdee.eas.farm.breed.HenhouseInfo;
import com.kingdee.eas.framework.*;
import com.kingdee.eas.util.client.MsgBox;
import com.kingdee.eas.wlhlcomm.FarmException;
import com.kingdee.bos.ctrl.kdf.table.KDTable;
import com.kingdee.bos.ctrl.swing.event.DataChangeEvent;

/**
 * output class name
 */
public class LayEggHouseSetEditUI extends AbstractLayEggHouseSetEditUI
{
    private static final Logger logger = CoreUIObject.getLogger(LayEggHouseSetEditUI.class);
    
    /**
     * output class constructor
     */
    public LayEggHouseSetEditUI() throws Exception
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
        return com.kingdee.eas.farm.breed.layegg.LayEggHouseSetFactory.getRemoteInstance();
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
        com.kingdee.eas.farm.breed.layegg.LayEggHouseSetInfo objectValue = new com.kingdee.eas.farm.breed.layegg.LayEggHouseSetInfo();
        objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));
		
        return objectValue;
    }
    /**
     * 鸡舍选中时 带出对应的 库存组织
     */
	@Override
	protected void prmthenhouse_dataChanged(DataChangeEvent e) throws Exception {
		HenhouseInfo wsInfo = (HenhouseInfo) this.prmthenhouse.getValue();
		if(wsInfo != null){
//			StorageOrgUnitInfo stoInfo = wsInfo.getChickenFarm();
//			if(stoInfo != null){
//				stoInfo = StorageOrgUnitFactory.getRemoteInstance().getStorageOrgUnitInfo(new ObjectUuidPK(stoInfo.getId()));
//			}
//			this.prmtstorageOrg.setValue(stoInfo);
		}
	}

	
}