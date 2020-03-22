/**
 * output package name
 */
package com.kingdee.eas.farm.food.client;

import java.awt.event.*;
import org.apache.log4j.Logger;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.eas.basedata.org.client.f7.StorageF7;
import com.kingdee.eas.common.client.SysContext;
import com.kingdee.eas.framework.*;

/**
 * output class name
 */
public class FoodBaseDataEditUI extends AbstractFoodBaseDataEditUI
{
    private static final Logger logger = CoreUIObject.getLogger(FoodBaseDataEditUI.class);
    
    /**
     * output class constructor
     */
    public FoodBaseDataEditUI() throws Exception
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
     * output createNewData method
     */
    protected com.kingdee.bos.dao.IObjectValue createNewData()
    {
        com.kingdee.eas.farm.food.FoodBaseDataInfo objectValue = new com.kingdee.eas.farm.food.FoodBaseDataInfo();
        objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));
        objectValue.setStorageOrgUnit(SysContext.getSysContext().getCurrentStorageUnit());
        return objectValue;
    }
	@Override
	public void onLoad() throws Exception {
		// TODO Auto-generated method stub
		super.onLoad();
		this.prmtstorageOrgUnit.setRequired(true);
		StorageF7 sf7=new StorageF7();
		sf7.setIsCUFilter(true);
		this.prmtstorageOrgUnit.setSelector(sf7);
		
		this.txtcarHandlingTime.setRequired(true);
	}
    
    

}