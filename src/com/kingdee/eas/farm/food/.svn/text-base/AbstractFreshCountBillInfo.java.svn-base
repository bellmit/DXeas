package com.kingdee.eas.farm.food;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractFreshCountBillInfo extends com.kingdee.eas.framework.CoreBillBaseInfo implements Serializable 
{
    public AbstractFreshCountBillInfo()
    {
        this("id");
    }
    protected AbstractFreshCountBillInfo(String pkField)
    {
        super(pkField);
        put("entrys", new com.kingdee.eas.farm.food.FreshCountBillEntryCollection());
    }
    /**
     * Object: 鲜品计数单 's 分录 property 
     */
    public com.kingdee.eas.farm.food.FreshCountBillEntryCollection getEntrys()
    {
        return (com.kingdee.eas.farm.food.FreshCountBillEntryCollection)get("entrys");
    }
    /**
     * Object:鲜品计数单's 是否生成凭证property 
     */
    public boolean isFivouchered()
    {
        return getBoolean("Fivouchered");
    }
    public void setFivouchered(boolean item)
    {
        setBoolean("Fivouchered", item);
    }
    /**
     * Object: 鲜品计数单 's 库存组织 property 
     */
    public com.kingdee.eas.basedata.org.StorageOrgUnitInfo getStorageOrg()
    {
        return (com.kingdee.eas.basedata.org.StorageOrgUnitInfo)get("storageOrg");
    }
    public void setStorageOrg(com.kingdee.eas.basedata.org.StorageOrgUnitInfo item)
    {
        put("storageOrg", item);
    }
    /**
     * Object:鲜品计数单's 单据状态property 
     */
    public com.kingdee.eas.scm.common.BillBaseStatusEnum getBillStatus()
    {
        return com.kingdee.eas.scm.common.BillBaseStatusEnum.getEnum(getInt("billStatus"));
    }
    public void setBillStatus(com.kingdee.eas.scm.common.BillBaseStatusEnum item)
    {
		if (item != null) {
        setInt("billStatus", item.getValue());
		}
    }
    /**
     * Object:鲜品计数单's 审核时间property 
     */
    public java.util.Date getAuditTime()
    {
        return getDate("auditTime");
    }
    public void setAuditTime(java.util.Date item)
    {
        setDate("auditTime", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("3E438F52");
    }
}