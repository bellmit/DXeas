package com.kingdee.eas.farm.dayratecost;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractArAmountOffsetDetailBillInfo extends com.kingdee.eas.framework.CoreBillBaseInfo implements Serializable 
{
    public AbstractArAmountOffsetDetailBillInfo()
    {
        this("id");
    }
    protected AbstractArAmountOffsetDetailBillInfo(String pkField)
    {
        super(pkField);
        put("entrys", new com.kingdee.eas.farm.dayratecost.ArAmountOffsetDetailBillEntryCollection());
    }
    /**
     * Object: 应收冲减明细 's 分录 property 
     */
    public com.kingdee.eas.farm.dayratecost.ArAmountOffsetDetailBillEntryCollection getEntrys()
    {
        return (com.kingdee.eas.farm.dayratecost.ArAmountOffsetDetailBillEntryCollection)get("entrys");
    }
    /**
     * Object:应收冲减明细's 是否生成凭证property 
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
     * Object:应收冲减明细's 单据状态property 
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
     * Object: 应收冲减明细 's 财务组织 property 
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
     * Object:应收冲减明细's 审核时间property 
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
     * Object: 应收冲减明细 's 养殖户 property 
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
     * Object: 应收冲减明细 's 养殖场 property 
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
     * Object: 应收冲减明细 's 养殖批次 property 
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
     * Object:应收冲减明细's 养殖阶段property 
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
     * Object:应收冲减明细's 总应收金额property 
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
     * Object:应收冲减明细's 未冲销金额property 
     */
    public java.math.BigDecimal getUnOffsetAmount()
    {
        return getBigDecimal("unOffsetAmount");
    }
    public void setUnOffsetAmount(java.math.BigDecimal item)
    {
        setBigDecimal("unOffsetAmount", item);
    }
    /**
     * Object:应收冲减明细's 已冲销金额property 
     */
    public java.math.BigDecimal getOffsetAmount()
    {
        return getBigDecimal("offsetAmount");
    }
    public void setOffsetAmount(java.math.BigDecimal item)
    {
        setBigDecimal("offsetAmount", item);
    }
    /**
     * Object: 应收冲减明细 's 会计期间 property 
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
     * Object:应收冲减明细's 初始化单据property 
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
     * Object: 应收冲减明细 's 棚舍 property 
     */
    public com.kingdee.eas.farm.stocking.basedata.FarmHouseEntryInfo getHouse()
    {
        return (com.kingdee.eas.farm.stocking.basedata.FarmHouseEntryInfo)get("house");
    }
    public void setHouse(com.kingdee.eas.farm.stocking.basedata.FarmHouseEntryInfo item)
    {
        put("house", item);
    }
    /**
     * Object: 应收冲减明细 's 资产卡片 property 
     */
    public com.kingdee.eas.fi.fa.manage.FaCurCardInfo getFaCard()
    {
        return (com.kingdee.eas.fi.fa.manage.FaCurCardInfo)get("faCard");
    }
    public void setFaCard(com.kingdee.eas.fi.fa.manage.FaCurCardInfo item)
    {
        put("faCard", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("6E8FC959");
    }
}