package com.kingdee.eas.farm.food;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractFoodSendCarPlanInfo extends com.kingdee.eas.framework.CoreBillBaseInfo implements Serializable 
{
    public AbstractFoodSendCarPlanInfo()
    {
        this("id");
    }
    protected AbstractFoodSendCarPlanInfo(String pkField)
    {
        super(pkField);
        put("OrgEntry", new com.kingdee.eas.farm.food.FoodSendCarPlanOrgEntryCollection());
        put("entrys", new com.kingdee.eas.farm.food.FoodSendCarPlanEntryCollection());
    }
    /**
     * Object: 食品厂派车计划 's 分录 property 
     */
    public com.kingdee.eas.farm.food.FoodSendCarPlanEntryCollection getEntrys()
    {
        return (com.kingdee.eas.farm.food.FoodSendCarPlanEntryCollection)get("entrys");
    }
    /**
     * Object:食品厂派车计划's 是否生成凭证property 
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
     * Object:食品厂派车计划's 派车数量property 
     */
    public java.math.BigDecimal getCarCount()
    {
        return getBigDecimal("carCount");
    }
    public void setCarCount(java.math.BigDecimal item)
    {
        setBigDecimal("carCount", item);
    }
    /**
     * Object: 食品厂派车计划 's 商品鸡场信息 property 
     */
    public com.kingdee.eas.farm.food.FoodSendCarPlanOrgEntryCollection getOrgEntry()
    {
        return (com.kingdee.eas.farm.food.FoodSendCarPlanOrgEntryCollection)get("OrgEntry");
    }
    /**
     * Object:食品厂派车计划's 审核时间property 
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
     * Object: 食品厂派车计划 's 库存组织 property 
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
     * Object:食品厂派车计划's 单据状态property 
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
     * Object:食品厂派车计划's 挂鸡时间property 
     */
    public java.util.Date getHitchTime()
    {
        return getDate("hitchTime");
    }
    public void setHitchTime(java.util.Date item)
    {
        setDate("hitchTime", item);
    }
    /**
     * Object:食品厂派车计划's 总数量property 
     */
    public java.math.BigDecimal getAllQty()
    {
        return getBigDecimal("allQty");
    }
    public void setAllQty(java.math.BigDecimal item)
    {
        setBigDecimal("allQty", item);
    }
    /**
     * Object:食品厂派车计划's 抓鸡转舍时间(min)property 
     */
    public java.math.BigDecimal getTransferTime()
    {
        return getBigDecimal("transferTime");
    }
    public void setTransferTime(java.math.BigDecimal item)
    {
        setBigDecimal("transferTime", item);
    }
    /**
     * Object:食品厂派车计划's 提前发车时间property 
     */
    public java.math.BigDecimal getAheadTime()
    {
        return getBigDecimal("aheadTime");
    }
    public void setAheadTime(java.math.BigDecimal item)
    {
        setBigDecimal("aheadTime", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("8291834D");
    }
}