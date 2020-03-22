package com.kingdee.eas.farm.breed.layegg;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractLayEggPlanInfo extends com.kingdee.eas.framework.CoreBillBaseInfo implements Serializable 
{
    public AbstractLayEggPlanInfo()
    {
        this("id");
    }
    protected AbstractLayEggPlanInfo(String pkField)
    {
        super(pkField);
        put("entrys", new com.kingdee.eas.farm.breed.layegg.LayEggPlanEntryCollection());
    }
    /**
     * Object: 产蛋计划 's 分录 property 
     */
    public com.kingdee.eas.farm.breed.layegg.LayEggPlanEntryCollection getEntrys()
    {
        return (com.kingdee.eas.farm.breed.layegg.LayEggPlanEntryCollection)get("entrys");
    }
    /**
     * Object:产蛋计划's 是否生成凭证property 
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
     * Object: 产蛋计划 's 产蛋场 property 
     */
    public com.kingdee.eas.basedata.org.StorageOrgUnitInfo getFarm()
    {
        return (com.kingdee.eas.basedata.org.StorageOrgUnitInfo)get("farm");
    }
    public void setFarm(com.kingdee.eas.basedata.org.StorageOrgUnitInfo item)
    {
        put("farm", item);
    }
    /**
     * Object:产蛋计划's 状态property 
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
     * Object: 产蛋计划 's 期间（月份） property 
     */
    public com.kingdee.eas.basedata.assistant.PeriodInfo getPeriod()
    {
        return (com.kingdee.eas.basedata.assistant.PeriodInfo)get("period");
    }
    public void setPeriod(com.kingdee.eas.basedata.assistant.PeriodInfo item)
    {
        put("period", item);
    }
    /**
     * Object:产蛋计划's 审核时间property 
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
     * Object:产蛋计划's 月初周龄property 
     */
    public int getInitWeek()
    {
        return getInt("initWeek");
    }
    public void setInitWeek(int item)
    {
        setInt("initWeek", item);
    }
    /**
     * Object:产蛋计划's 月初日龄property 
     */
    public int getInitDays()
    {
        return getInt("initDays");
    }
    public void setInitDays(int item)
    {
        setInt("initDays", item);
    }
    /**
     * Object:产蛋计划's 月初存栏（种母鸡）property 
     */
    public int getInitHenQty()
    {
        return getInt("initHenQty");
    }
    public void setInitHenQty(int item)
    {
        setInt("initHenQty", item);
    }
    /**
     * Object:产蛋计划's 开算日期property 
     */
    public java.util.Date getBeginDate()
    {
        return getDate("beginDate");
    }
    public void setBeginDate(java.util.Date item)
    {
        setDate("beginDate", item);
    }
    /**
     * Object:产蛋计划's 双黄蛋总数property 
     */
    public java.math.BigDecimal getTxtallDoubleYolkEggQty()
    {
        return getBigDecimal("txtallDoubleYolkEggQty");
    }
    public void setTxtallDoubleYolkEggQty(java.math.BigDecimal item)
    {
        setBigDecimal("txtallDoubleYolkEggQty", item);
    }
    /**
     * Object:产蛋计划's 破蛋总数property 
     */
    public java.math.BigDecimal getAllBrokenEggQty()
    {
        return getBigDecimal("allBrokenEggQty");
    }
    public void setAllBrokenEggQty(java.math.BigDecimal item)
    {
        setBigDecimal("allBrokenEggQty", item);
    }
    /**
     * Object:产蛋计划's 畸形蛋总数property 
     */
    public java.math.BigDecimal getAllFreakEggQty()
    {
        return getBigDecimal("allFreakEggQty");
    }
    public void setAllFreakEggQty(java.math.BigDecimal item)
    {
        setBigDecimal("allFreakEggQty", item);
    }
    /**
     * Object:产蛋计划's 合格蛋总数property 
     */
    public java.math.BigDecimal getAllUpEggQty()
    {
        return getBigDecimal("allUpEggQty");
    }
    public void setAllUpEggQty(java.math.BigDecimal item)
    {
        setBigDecimal("allUpEggQty", item);
    }
    /**
     * Object:产蛋计划's 产蛋总数property 
     */
    public java.math.BigDecimal getAllEggQty()
    {
        return getBigDecimal("allEggQty");
    }
    public void setAllEggQty(java.math.BigDecimal item)
    {
        setBigDecimal("allEggQty", item);
    }
    /**
     * Object:产蛋计划's 合格蛋库存property 
     */
    public java.math.BigDecimal getQuantityEggs()
    {
        return getBigDecimal("quantityEggs");
    }
    public void setQuantityEggs(java.math.BigDecimal item)
    {
        setBigDecimal("quantityEggs", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("53C73AD7");
    }
}