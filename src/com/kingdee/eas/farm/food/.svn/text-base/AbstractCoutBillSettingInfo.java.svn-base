package com.kingdee.eas.farm.food;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractCoutBillSettingInfo extends com.kingdee.eas.framework.DataBaseInfo implements Serializable 
{
    public AbstractCoutBillSettingInfo()
    {
        this("id");
    }
    protected AbstractCoutBillSettingInfo(String pkField)
    {
        super(pkField);
        put("MaterialEntry", new com.kingdee.eas.farm.food.CoutBillSettingMaterialEntryCollection());
    }
    /**
     * Object: 计数单基础设置 's 库存组织 property 
     */
    public com.kingdee.eas.basedata.org.StorageOrgUnitInfo getStorageOrgUnit()
    {
        return (com.kingdee.eas.basedata.org.StorageOrgUnitInfo)get("storageOrgUnit");
    }
    public void setStorageOrgUnit(com.kingdee.eas.basedata.org.StorageOrgUnitInfo item)
    {
        put("storageOrgUnit", item);
    }
    /**
     * Object:计数单基础设置's 单据类型property 
     */
    public com.kingdee.eas.farm.food.CountBillType getBillType()
    {
        return com.kingdee.eas.farm.food.CountBillType.getEnum(getString("billType"));
    }
    public void setBillType(com.kingdee.eas.farm.food.CountBillType item)
    {
		if (item != null) {
        setString("billType", item.getValue());
		}
    }
    /**
     * Object: 计数单基础设置 's 基本物料 property 
     */
    public com.kingdee.eas.farm.food.CoutBillSettingMaterialEntryCollection getMaterialEntry()
    {
        return (com.kingdee.eas.farm.food.CoutBillSettingMaterialEntryCollection)get("MaterialEntry");
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("E105C954");
    }
}