/**
 * output package name
 */
package com.kingdee.eas.farm.hatch.client;

import java.awt.event.*;
import org.apache.log4j.Logger;

import com.kingdee.bos.metadata.entity.FilterInfo;
import com.kingdee.bos.metadata.entity.FilterItemInfo;
import com.kingdee.bos.metadata.query.util.CompareType;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.bos.ui.face.UIRuleUtil;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.eas.basedata.org.CtrlUnitInfo;
import com.kingdee.eas.basedata.org.StorageOrgUnitInfo;
import com.kingdee.eas.common.SysContextConstant;
import com.kingdee.eas.common.client.SysContext;
import com.kingdee.eas.framework.*;

/**
 * output class name
 */
public class HatchAdjustBillListUI extends AbstractHatchAdjustBillListUI
{
    private static final Logger logger = CoreUIObject.getLogger(HatchAdjustBillListUI.class);
    
    /**
     * output class constructor
     */
    public HatchAdjustBillListUI() throws Exception
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
     * output getBizInterface method
     */
    protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
    {
        return com.kingdee.eas.farm.hatch.HatchAdjustBillFactory.getRemoteInstance();
    }

    /**
     * output createNewData method
     */
    protected com.kingdee.bos.dao.IObjectValue createNewData()
    {
        com.kingdee.eas.farm.hatch.HatchAdjustBillInfo objectValue = new com.kingdee.eas.farm.hatch.HatchAdjustBillInfo();
		
        return objectValue;
    }

	@Override
	protected FilterInfo getDefaultFilterForQuery() {
		// TODO Auto-generated method stub
		FilterInfo filterInfo = super.getDefaultFilterForQuery();
		CtrlUnitInfo ctrlUnitInfo = SysContext.getSysContext().getCurrentCtrlUnit();
		String maskString = filterInfo.getMaskString();
		int size = filterInfo.getFilterItems().size();
		filterInfo.getFilterItems().add(new FilterItemInfo("cu.id",ctrlUnitInfo.getString("id"),CompareType.EQUALS));
		filterInfo.setMaskString(maskString+" or #"+size);
		StorageOrgUnitInfo storageOrgUnitInfo = SysContext.getSysContext().getCurrentStorageUnit();
		if(UIRuleUtil.isNotNull(storageOrgUnitInfo)){
			filterInfo.getFilterItems().add(new FilterItemInfo("storageOrgUnit.longNumber",storageOrgUnitInfo.getString("longNumber")+"%",CompareType.LIKE));
			filterInfo.setMaskString(maskString+" or #"+(size+1));
		}
		return filterInfo;
	}

}