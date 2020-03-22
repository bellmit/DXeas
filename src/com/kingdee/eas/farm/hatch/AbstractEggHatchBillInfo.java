package com.kingdee.eas.farm.hatch;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractEggHatchBillInfo extends com.kingdee.eas.framework.CoreBillBaseInfo implements Serializable 
{
    public AbstractEggHatchBillInfo()
    {
        this("id");
    }
    protected AbstractEggHatchBillInfo(String pkField)
    {
        super(pkField);
        put("entrys", new com.kingdee.eas.farm.hatch.EggHatchBillEntryCollection());
    }
    /**
     * Object: 种蛋上孵单（多箱） 's 分录 property 
     */
    public com.kingdee.eas.farm.hatch.EggHatchBillEntryCollection getEntrys()
    {
        return (com.kingdee.eas.farm.hatch.EggHatchBillEntryCollection)get("entrys");
    }
    /**
     * Object:种蛋上孵单（多箱）'s 是否生成凭证property 
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
     * Object:种蛋上孵单（多箱）'s 审核日期property 
     */
    public java.util.Date getAuditTime()
    {
        return getDate("auditTime");
    }
    public void setAuditTime(java.util.Date item)
    {
        setDate("auditTime", item);
    }
    /**
     * Object:种蛋上孵单（多箱）'s 状态property 
     */
    public com.kingdee.eas.scm.common.BillBaseStatusEnum getBaseStatus()
    {
        return com.kingdee.eas.scm.common.BillBaseStatusEnum.getEnum(getInt("baseStatus"));
    }
    public void setBaseStatus(com.kingdee.eas.scm.common.BillBaseStatusEnum item)
    {
		if (item != null) {
        setInt("baseStatus", item.getValue());
		}
    }
    /**
     * Object: 种蛋上孵单（多箱） 's 孵化场 property 
     */
    public com.kingdee.eas.farm.hatch.HatchBaseDataInfo getHatchFactory()
    {
        return (com.kingdee.eas.farm.hatch.HatchBaseDataInfo)get("hatchFactory");
    }
    public void setHatchFactory(com.kingdee.eas.farm.hatch.HatchBaseDataInfo item)
    {
        put("hatchFactory", item);
    }
    /**
     * Object:种蛋上孵单（多箱）'s 上孵总数property 
     */
    public int getAllHatchQty()
    {
        return getInt("allHatchQty");
    }
    public void setAllHatchQty(int item)
    {
        setInt("allHatchQty", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("0648D2F0");
    }
}