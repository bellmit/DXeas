package com.kingdee.eas.farm.food;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractCManufactureBillInfo extends com.kingdee.eas.scm.im.inv.InvBillBaseInfo implements Serializable 
{
    public AbstractCManufactureBillInfo()
    {
        this("id");
    }
    protected AbstractCManufactureBillInfo(String pkField)
    {
        super(pkField);
        put("entry", new com.kingdee.eas.farm.food.CManufactureBillEntryCollection());
    }
    /**
     * Object: 生产入库单 's 生产入库单体 property 
     */
    public com.kingdee.eas.farm.food.CManufactureBillEntryCollection getEntry()
    {
        return (com.kingdee.eas.farm.food.CManufactureBillEntryCollection)get("entry");
    }
    /**
     * Object:生产入库单's 倒冲标识property 
     */
    public com.kingdee.eas.scm.im.inv.BackFlushSucceedEnum getIsBackFlushSucceed()
    {
        return com.kingdee.eas.scm.im.inv.BackFlushSucceedEnum.getEnum(getInt("isBackFlushSucceed"));
    }
    public void setIsBackFlushSucceed(com.kingdee.eas.scm.im.inv.BackFlushSucceedEnum item)
    {
		if (item != null) {
        setInt("isBackFlushSucceed", item.getValue());
		}
    }
    /**
     * Object: 生产入库单 's 加工组织 property 
     */
    public com.kingdee.eas.basedata.org.StorageOrgUnitInfo getProcessOrgUnit()
    {
        return (com.kingdee.eas.basedata.org.StorageOrgUnitInfo)get("processOrgUnit");
    }
    public void setProcessOrgUnit(com.kingdee.eas.basedata.org.StorageOrgUnitInfo item)
    {
        put("processOrgUnit", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("D66B122F");
    }
}