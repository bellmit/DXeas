package com.kingdee.eas.farm.dayratecost;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractDayRateCostDetailInfo extends com.kingdee.eas.framework.CoreBillBaseInfo implements Serializable 
{
    public AbstractDayRateCostDetailInfo()
    {
        this("id");
    }
    protected AbstractDayRateCostDetailInfo(String pkField)
    {
        super(pkField);
        put("entrys", new com.kingdee.eas.farm.dayratecost.DayRateCostDetailEntryCollection());
    }
    /**
     * Object: 育成期日成本明细表 's 分录 property 
     */
    public com.kingdee.eas.farm.dayratecost.DayRateCostDetailEntryCollection getEntrys()
    {
        return (com.kingdee.eas.farm.dayratecost.DayRateCostDetailEntryCollection)get("entrys");
    }
    /**
     * Object:育成期日成本明细表's 是否生成凭证property 
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
     * Object: 育成期日成本明细表 's 财务组织 property 
     */
    public com.kingdee.eas.basedata.org.CompanyOrgUnitInfo getCompany()
    {
        return (com.kingdee.eas.basedata.org.CompanyOrgUnitInfo)get("company");
    }
    public void setCompany(com.kingdee.eas.basedata.org.CompanyOrgUnitInfo item)
    {
        put("company", item);
    }
    /**
     * Object:育成期日成本明细表's 审核时间property 
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
     * Object: 育成期日成本明细表 's 成本中心 property 
     */
    public com.kingdee.eas.basedata.org.CostCenterOrgUnitInfo getCostCentor()
    {
        return (com.kingdee.eas.basedata.org.CostCenterOrgUnitInfo)get("costCentor");
    }
    public void setCostCentor(com.kingdee.eas.basedata.org.CostCenterOrgUnitInfo item)
    {
        put("costCentor", item);
    }
    /**
     * Object: 育成期日成本明细表 's 期间 property 
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
     * Object:育成期日成本明细表's 日龄property 
     */
    public int getWeekDay()
    {
        return getInt("weekDay");
    }
    public void setWeekDay(int item)
    {
        setInt("weekDay", item);
    }
    /**
     * Object:育成期日成本明细表's 周龄property 
     */
    public int getWeek()
    {
        return getInt("week");
    }
    public void setWeek(int item)
    {
        setInt("week", item);
    }
    /**
     * Object:育成期日成本明细表's  状态property 
     */
    public int getStatus()
    {
        return getInt("status");
    }
    public void setStatus(int item)
    {
        setInt("status", item);
    }
    /**
     * Object:育成期日成本明细表's 期末只数property 
     */
    public int getEndBreedQty()
    {
        return getInt("endBreedQty");
    }
    public void setEndBreedQty(int item)
    {
        setInt("endBreedQty", item);
    }
    /**
     * Object:育成期日成本明细表's 变动只数property 
     */
    public int getOccurBreedQty()
    {
        return getInt("occurBreedQty");
    }
    public void setOccurBreedQty(int item)
    {
        setInt("occurBreedQty", item);
    }
    /**
     * Object:育成期日成本明细表's 期初只数property 
     */
    public int getBeginBreedQty()
    {
        return getInt("beginBreedQty");
    }
    public void setBeginBreedQty(int item)
    {
        setInt("beginBreedQty", item);
    }
    /**
     * Object: 育成期日成本明细表 's 养殖场 property 
     */
    public com.kingdee.eas.farm.stocking.basedata.FarmInfo getFarm()
    {
        return (com.kingdee.eas.farm.stocking.basedata.FarmInfo)get("farm");
    }
    public void setFarm(com.kingdee.eas.farm.stocking.basedata.FarmInfo item)
    {
        put("farm", item);
    }
    /**
     * Object: 育成期日成本明细表 's 养殖户 property 
     */
    public com.kingdee.eas.farm.stocking.basedata.FarmersInfo getFarmer()
    {
        return (com.kingdee.eas.farm.stocking.basedata.FarmersInfo)get("farmer");
    }
    public void setFarmer(com.kingdee.eas.farm.stocking.basedata.FarmersInfo item)
    {
        put("farmer", item);
    }
    /**
     * Object: 育成期日成本明细表 's 棚舍 property 
     */
    public com.kingdee.eas.farm.stocking.basedata.FarmInfo getHouse()
    {
        return (com.kingdee.eas.farm.stocking.basedata.FarmInfo)get("house");
    }
    public void setHouse(com.kingdee.eas.farm.stocking.basedata.FarmInfo item)
    {
        put("house", item);
    }
    /**
     * Object:育成期日成本明细表's 初始化单据property 
     */
    public boolean isIsInit()
    {
        return getBoolean("isInit");
    }
    public void setIsInit(boolean item)
    {
        setBoolean("isInit", item);
    }
    /**
     * Object:育成期日成本明细表's 阶段结转余额property 
     */
    public boolean isIsStageBalance()
    {
        return getBoolean("isStageBalance");
    }
    public void setIsStageBalance(boolean item)
    {
        setBoolean("isStageBalance", item);
    }
    /**
     * Object: 育成期日成本明细表 's 养殖批次 property 
     */
    public com.kingdee.eas.farm.stocking.basedata.StockingBatchInfo getStockingBatch()
    {
        return (com.kingdee.eas.farm.stocking.basedata.StockingBatchInfo)get("stockingBatch");
    }
    public void setStockingBatch(com.kingdee.eas.farm.stocking.basedata.StockingBatchInfo item)
    {
        put("stockingBatch", item);
    }
    /**
     * Object:育成期日成本明细表's 养殖阶段property 
     */
    public com.kingdee.eas.farm.stocking.basedata.FarmStageEnum getBreedStage()
    {
        return com.kingdee.eas.farm.stocking.basedata.FarmStageEnum.getEnum(getInt("breedStage"));
    }
    public void setBreedStage(com.kingdee.eas.farm.stocking.basedata.FarmStageEnum item)
    {
		if (item != null) {
        setInt("breedStage", item.getValue());
		}
    }
    /**
     * Object:育成期日成本明细表's 总应收金额property 
     */
    public java.math.BigDecimal getAllArAmount()
    {
        return getBigDecimal("allArAmount");
    }
    public void setAllArAmount(java.math.BigDecimal item)
    {
        setBigDecimal("allArAmount", item);
    }
    /**
     * Object:育成期日成本明细表's 单据状态property 
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
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("18C12B75");
    }
}