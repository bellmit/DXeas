package com.kingdee.eas.farm.dayratecost;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractDayRateInitBillInfo extends com.kingdee.eas.framework.CoreBillBaseInfo implements Serializable 
{
    public AbstractDayRateInitBillInfo()
    {
        this("id");
    }
    protected AbstractDayRateInitBillInfo(String pkField)
    {
        super(pkField);
        put("entrys", new com.kingdee.eas.farm.dayratecost.DayRateInitBillEntryCollection());
    }
    /**
     * Object: 产蛋期成本明细表 's 分录 property 
     */
    public com.kingdee.eas.farm.dayratecost.DayRateInitBillEntryCollection getEntrys()
    {
        return (com.kingdee.eas.farm.dayratecost.DayRateInitBillEntryCollection)get("entrys");
    }
    /**
     * Object:产蛋期成本明细表's 是否生成凭证property 
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
     * Object:产蛋期成本明细表's 单据状态property 
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
     * Object: 产蛋期成本明细表 's 财务组织 property 
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
     * Object:产蛋期成本明细表's 审核时间property 
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
     * Object:产蛋期成本明细表's 初始化单据property 
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
     * Object: 产蛋期成本明细表 's 期间 property 
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
     * Object:产蛋期成本明细表's 期末只数property 
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
     * Object:产蛋期成本明细表's 变动只数property 
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
     * Object:产蛋期成本明细表's 期数只数property 
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
     * Object:产蛋期成本明细表's 养殖阶段property 
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
     * Object: 产蛋期成本明细表 's 养殖户 property 
     */
    public com.kingdee.eas.farm.stocking.basedata.FarmersInfo getStockingFarmer()
    {
        return (com.kingdee.eas.farm.stocking.basedata.FarmersInfo)get("stockingFarmer");
    }
    public void setStockingFarmer(com.kingdee.eas.farm.stocking.basedata.FarmersInfo item)
    {
        put("stockingFarmer", item);
    }
    /**
     * Object: 产蛋期成本明细表 's 棚舍 property 
     */
    public com.kingdee.eas.farm.stocking.basedata.FarmHouseEntryInfo getStockingHouse()
    {
        return (com.kingdee.eas.farm.stocking.basedata.FarmHouseEntryInfo)get("stockingHouse");
    }
    public void setStockingHouse(com.kingdee.eas.farm.stocking.basedata.FarmHouseEntryInfo item)
    {
        put("stockingHouse", item);
    }
    /**
     * Object: 产蛋期成本明细表 's 养殖批次 property 
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
     * Object: 产蛋期成本明细表 's 养殖场 property 
     */
    public com.kingdee.eas.farm.stocking.basedata.FarmInfo getStockingFarm()
    {
        return (com.kingdee.eas.farm.stocking.basedata.FarmInfo)get("stockingFarm");
    }
    public void setStockingFarm(com.kingdee.eas.farm.stocking.basedata.FarmInfo item)
    {
        put("stockingFarm", item);
    }
    /**
     * Object:产蛋期成本明细表's 阶段结转余额property 
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
     * Object:产蛋期成本明细表's 总应收金额property 
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
     * Object:产蛋期成本明细表's 期初只数(母)property 
     */
    public int getBeginFemaleQty()
    {
        return getInt("beginFemaleQty");
    }
    public void setBeginFemaleQty(int item)
    {
        setInt("beginFemaleQty", item);
    }
    /**
     * Object:产蛋期成本明细表's 变动只数(母)property 
     */
    public int getOccrFemaleQty()
    {
        return getInt("occrFemaleQty");
    }
    public void setOccrFemaleQty(int item)
    {
        setInt("occrFemaleQty", item);
    }
    /**
     * Object:产蛋期成本明细表's 期末只数(母)property 
     */
    public int getEndFemaleQty()
    {
        return getInt("endFemaleQty");
    }
    public void setEndFemaleQty(int item)
    {
        setInt("endFemaleQty", item);
    }
    /**
     * Object:产蛋期成本明细表's 当期产蛋数property 
     */
    public int getWorkQty()
    {
        return getInt("workQty");
    }
    public void setWorkQty(int item)
    {
        setInt("workQty", item);
    }
    /**
     * Object:产蛋期成本明细表's 当期只均产蛋数property 
     */
    public int getAvgWorkQty()
    {
        return getInt("avgWorkQty");
    }
    public void setAvgWorkQty(int item)
    {
        setInt("avgWorkQty", item);
    }
    /**
     * Object:产蛋期成本明细表's 累计产蛋数property 
     */
    public int getSumWorkQty()
    {
        return getInt("sumWorkQty");
    }
    public void setSumWorkQty(int item)
    {
        setInt("sumWorkQty", item);
    }
    /**
     * Object:产蛋期成本明细表's 累计只均产蛋数property 
     */
    public int getAvgSumWorkQty()
    {
        return getInt("avgSumWorkQty");
    }
    public void setAvgSumWorkQty(int item)
    {
        setInt("avgSumWorkQty", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("8E080BEE");
    }
}