package com.kingdee.eas.farm.carnivorous.basedata;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractSettlePolicyInfo extends com.kingdee.eas.framework.DataBaseInfo implements Serializable 
{
    public AbstractSettlePolicyInfo()
    {
        this("id");
    }
    protected AbstractSettlePolicyInfo(String pkField)
    {
        super(pkField);
        put("RecycleEntry", new com.kingdee.eas.farm.carnivorous.basedata.SettlePolicyRecycleEntryCollection());
        put("AwardsEntry", new com.kingdee.eas.farm.carnivorous.basedata.SettlePolicyAwardsEntryCollection());
        put("SubsidyEntry", new com.kingdee.eas.farm.carnivorous.basedata.SettlePolicySubsidyEntryCollection());
        put("PriceEntry", new com.kingdee.eas.farm.carnivorous.basedata.SettlePolicyPriceEntryCollection());
    }
    /**
     * Object: 结算政策 's 组别 property 
     */
    public com.kingdee.eas.farm.carnivorous.basedata.SettlePolicyTreeInfo getTreeid()
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.SettlePolicyTreeInfo)get("treeid");
    }
    public void setTreeid(com.kingdee.eas.farm.carnivorous.basedata.SettlePolicyTreeInfo item)
    {
        put("treeid", item);
    }
    /**
     * Object:结算政策's 状态property 
     */
    public com.kingdee.eas.farm.stocking.basedata.FarmBaseStatusEnum getBaseStatus()
    {
        return com.kingdee.eas.farm.stocking.basedata.FarmBaseStatusEnum.getEnum(getInt("baseStatus"));
    }
    public void setBaseStatus(com.kingdee.eas.farm.stocking.basedata.FarmBaseStatusEnum item)
    {
		if (item != null) {
        setInt("baseStatus", item.getValue());
		}
    }
    /**
     * Object: 结算政策 's 审核人 property 
     */
    public com.kingdee.eas.base.permission.UserInfo getAuditor()
    {
        return (com.kingdee.eas.base.permission.UserInfo)get("auditor");
    }
    public void setAuditor(com.kingdee.eas.base.permission.UserInfo item)
    {
        put("auditor", item);
    }
    /**
     * Object:结算政策's 审核时间property 
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
     * Object: 结算政策 's 财务组织 property 
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
     * Object: 结算政策 's 价格分录 property 
     */
    public com.kingdee.eas.farm.carnivorous.basedata.SettlePolicyPriceEntryCollection getPriceEntry()
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.SettlePolicyPriceEntryCollection)get("PriceEntry");
    }
    /**
     * Object:结算政策's 是否模板property 
     */
    public boolean isIsTemplate()
    {
        return getBoolean("isTemplate");
    }
    public void setIsTemplate(boolean item)
    {
        setBoolean("isTemplate", item);
    }
    /**
     * Object: 结算政策 's 品种 property 
     */
    public com.kingdee.eas.farm.stocking.basedata.BreedDataInfo getBreedData()
    {
        return (com.kingdee.eas.farm.stocking.basedata.BreedDataInfo)get("breedData");
    }
    public void setBreedData(com.kingdee.eas.farm.stocking.basedata.BreedDataInfo item)
    {
        put("breedData", item);
    }
    /**
     * Object: 结算政策 's 回收政策 property 
     */
    public com.kingdee.eas.farm.carnivorous.basedata.SettlePolicyRecycleEntryCollection getRecycleEntry()
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.SettlePolicyRecycleEntryCollection)get("RecycleEntry");
    }
    /**
     * Object: 结算政策 's 奖罚政策 property 
     */
    public com.kingdee.eas.farm.carnivorous.basedata.SettlePolicyAwardsEntryCollection getAwardsEntry()
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.SettlePolicyAwardsEntryCollection)get("AwardsEntry");
    }
    /**
     * Object:结算政策's 生效日期property 
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
     * Object:结算政策's 失效日期property 
     */
    public java.util.Date getEndDate()
    {
        return getDate("endDate");
    }
    public void setEndDate(java.util.Date item)
    {
        setDate("endDate", item);
    }
    /**
     * Object:结算政策's 母鸭生活费(只)property 
     */
    public java.math.BigDecimal getAvgFemaleFee()
    {
        return getBigDecimal("avgFemaleFee");
    }
    public void setAvgFemaleFee(java.math.BigDecimal item)
    {
        setBigDecimal("avgFemaleFee", item);
    }
    /**
     * Object:结算政策's 贷款月利率property 
     */
    public java.math.BigDecimal getDepositRate()
    {
        return getBigDecimal("depositRate");
    }
    public void setDepositRate(java.math.BigDecimal item)
    {
        setBigDecimal("depositRate", item);
    }
    /**
     * Object:结算政策's 计提方式property 
     */
    public com.kingdee.eas.farm.stocking.basedata.ProvisionTypeEnum getProvisionType()
    {
        return com.kingdee.eas.farm.stocking.basedata.ProvisionTypeEnum.getEnum(getInt("provisionType"));
    }
    public void setProvisionType(com.kingdee.eas.farm.stocking.basedata.ProvisionTypeEnum item)
    {
		if (item != null) {
        setInt("provisionType", item.getValue());
		}
    }
    /**
     * Object:结算政策's 标准出栏天数property 
     */
    public int getOutDaysStd()
    {
        return getInt("outDaysStd");
    }
    public void setOutDaysStd(int item)
    {
        setInt("outDaysStd", item);
    }
    /**
     * Object: 结算政策 's 补贴分录 property 
     */
    public com.kingdee.eas.farm.carnivorous.basedata.SettlePolicySubsidyEntryCollection getSubsidyEntry()
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.SettlePolicySubsidyEntryCollection)get("SubsidyEntry");
    }
    /**
     * Object:结算政策's 路耗比例(%)property 
     */
    public java.math.BigDecimal getRoadLossRate()
    {
        return getBigDecimal("roadLossRate");
    }
    public void setRoadLossRate(java.math.BigDecimal item)
    {
        setBigDecimal("roadLossRate", item);
    }
    /**
     * Object:结算政策's 最低单只药品(元/只)property 
     */
    public java.math.BigDecimal getMinSingleDrug()
    {
        return getBigDecimal("minSingleDrug");
    }
    public void setMinSingleDrug(java.math.BigDecimal item)
    {
        setBigDecimal("minSingleDrug", item);
    }
    /**
     * Object:结算政策's 标准回收率(%)property 
     */
    public java.math.BigDecimal getStandardRecRate()
    {
        return getBigDecimal("standardRecRate");
    }
    public void setStandardRecRate(java.math.BigDecimal item)
    {
        setBigDecimal("standardRecRate", item);
    }
    /**
     * Object:结算政策's 料肉比扣罚标准(元/kg)property 
     */
    public java.math.BigDecimal getFmRatePunishStd()
    {
        return getBigDecimal("fmRatePunishStd");
    }
    public void setFmRatePunishStd(java.math.BigDecimal item)
    {
        setBigDecimal("fmRatePunishStd", item);
    }
    /**
     * Object:结算政策's 运费补贴标准(元/吨)property 
     */
    public java.math.BigDecimal getFreightSubsidiesStd()
    {
        return getBigDecimal("freightSubsidiesStd");
    }
    public void setFreightSubsidiesStd(java.math.BigDecimal item)
    {
        setBigDecimal("freightSubsidiesStd", item);
    }
    /**
     * Object:结算政策's 有未结算批次是否禁止订下批合同property 
     */
    public boolean isIsForbidUnSettle()
    {
        return getBoolean("isForbidUnSettle");
    }
    public void setIsForbidUnSettle(boolean item)
    {
        setBoolean("isForbidUnSettle", item);
    }
    /**
     * Object:结算政策's 喷雾防疫费(元/只)property 
     */
    public java.math.BigDecimal getImmuneCost()
    {
        return getBigDecimal("immuneCost");
    }
    public void setImmuneCost(java.math.BigDecimal item)
    {
        setBigDecimal("immuneCost", item);
    }
    /**
     * Object:结算政策's 用药不足扣罚比例(%)property 
     */
    public java.math.BigDecimal getUnEnoungh()
    {
        return getBigDecimal("UnEnoungh");
    }
    public void setUnEnoungh(java.math.BigDecimal item)
    {
        setBigDecimal("UnEnoungh", item);
    }
    /**
     * Object:结算政策's 最高单只药品(元/只)property 
     */
    public java.math.BigDecimal getMaxSingleDrug()
    {
        return getBigDecimal("maxSingleDrug");
    }
    public void setMaxSingleDrug(java.math.BigDecimal item)
    {
        setBigDecimal("maxSingleDrug", item);
    }
    /**
     * Object:结算政策's 油苗费用(元/只)property 
     */
    public java.math.BigDecimal getImmuneTost()
    {
        return getBigDecimal("immuneTost");
    }
    public void setImmuneTost(java.math.BigDecimal item)
    {
        setBigDecimal("immuneTost", item);
    }
    /**
     * Object:结算政策's 清舍费(元/只)property 
     */
    public java.math.BigDecimal getCleanHouse()
    {
        return getBigDecimal("cleanHouse");
    }
    public void setCleanHouse(java.math.BigDecimal item)
    {
        setBigDecimal("cleanHouse", item);
    }
    /**
     * Object:结算政策's 预留风险押金(元/只)property 
     */
    public java.math.BigDecimal getReserveRiskOne()
    {
        return getBigDecimal("reserveRiskOne");
    }
    public void setReserveRiskOne(java.math.BigDecimal item)
    {
        setBigDecimal("reserveRiskOne", item);
    }
    /**
     * Object:结算政策's 预留检测费(元)property 
     */
    public java.math.BigDecimal getReserveCheck()
    {
        return getBigDecimal("reserveCheck");
    }
    public void setReserveCheck(java.math.BigDecimal item)
    {
        setBigDecimal("reserveCheck", item);
    }
    /**
     * Object:结算政策's 是否执行利润分成政策property 
     */
    public boolean isIsProDiv()
    {
        return getBoolean("isProDiv");
    }
    public void setIsProDiv(boolean item)
    {
        setBoolean("isProDiv", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("E1DFECFF");
    }
}