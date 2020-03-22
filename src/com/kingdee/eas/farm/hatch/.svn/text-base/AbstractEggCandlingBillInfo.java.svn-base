package com.kingdee.eas.farm.hatch;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractEggCandlingBillInfo extends com.kingdee.eas.framework.CoreBillBaseInfo implements Serializable 
{
    public AbstractEggCandlingBillInfo()
    {
        this("id");
    }
    protected AbstractEggCandlingBillInfo(String pkField)
    {
        super(pkField);
        put("entrys", new com.kingdee.eas.farm.hatch.EggCandlingBillEntryCollection());
    }
    /**
     * Object: 照蛋记录单（多箱） 's 分录 property 
     */
    public com.kingdee.eas.farm.hatch.EggCandlingBillEntryCollection getEntrys()
    {
        return (com.kingdee.eas.farm.hatch.EggCandlingBillEntryCollection)get("entrys");
    }
    /**
     * Object:照蛋记录单（多箱）'s 是否生成凭证property 
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
     * Object:照蛋记录单（多箱）'s 审核日期property 
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
     * Object:照蛋记录单（多箱）'s 状态property 
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
     * Object: 照蛋记录单（多箱） 's 孵化场 property 
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
     * Object:照蛋记录单（多箱）'s 无精蛋property 
     */
    public int getAllNoFertileEggQty()
    {
        return getInt("allNoFertileEggQty");
    }
    public void setAllNoFertileEggQty(int item)
    {
        setInt("allNoFertileEggQty", item);
    }
    /**
     * Object:照蛋记录单（多箱）'s 死胚property 
     */
    public int getAllAddleEggQty()
    {
        return getInt("allAddleEggQty");
    }
    public void setAllAddleEggQty(int item)
    {
        setInt("allAddleEggQty", item);
    }
    /**
     * Object:照蛋记录单（多箱）'s 臭损property 
     */
    public int getAllRottenEggQty()
    {
        return getInt("allRottenEggQty");
    }
    public void setAllRottenEggQty(int item)
    {
        setInt("allRottenEggQty", item);
    }
    /**
     * Object:照蛋记录单（多箱）'s 上孵总数property 
     */
    public int getAllHatchEggQty()
    {
        return getInt("allHatchEggQty");
    }
    public void setAllHatchEggQty(int item)
    {
        setInt("allHatchEggQty", item);
    }
    /**
     * Object: 照蛋记录单（多箱） 's 操作员 property 
     */
    public com.kingdee.eas.basedata.person.PersonInfo getOperator()
    {
        return (com.kingdee.eas.basedata.person.PersonInfo)get("operator");
    }
    public void setOperator(com.kingdee.eas.basedata.person.PersonInfo item)
    {
        put("operator", item);
    }
    /**
     * Object:照蛋记录单（多箱）'s 活胚property 
     */
    public int getAllHealthEggQty()
    {
        return getInt("allHealthEggQty");
    }
    public void setAllHealthEggQty(int item)
    {
        setInt("allHealthEggQty", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("BF769488");
    }
}