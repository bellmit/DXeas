package com.kingdee.eas.farm.hatch;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractHatchBillCoefficientEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractHatchBillCoefficientEntryInfo()
    {
        this("id");
    }
    protected AbstractHatchBillCoefficientEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 库存组织分录 's null property 
     */
    public com.kingdee.eas.farm.hatch.HatchBillCoefficientInfo getParent()
    {
        return (com.kingdee.eas.farm.hatch.HatchBillCoefficientInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.farm.hatch.HatchBillCoefficientInfo item)
    {
        put("parent", item);
    }
    /**
     * Object: 库存组织分录 's 库存组织 property 
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
     * Object:库存组织分录's 库存组织编码property 
     */
    public String getStoOrgUnitNum()
    {
        return getString("stoOrgUnitNum");
    }
    public void setStoOrgUnitNum(String item)
    {
        setString("stoOrgUnitNum", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("4ABAD876");
    }
}