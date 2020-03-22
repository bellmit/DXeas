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
     * Object: �������� 's ��� property 
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
     * Object:��������'s ״̬property 
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
     * Object: �������� 's ����� property 
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
     * Object:��������'s ���ʱ��property 
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
     * Object: �������� 's ������֯ property 
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
     * Object: �������� 's �۸��¼ property 
     */
    public com.kingdee.eas.farm.carnivorous.basedata.SettlePolicyPriceEntryCollection getPriceEntry()
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.SettlePolicyPriceEntryCollection)get("PriceEntry");
    }
    /**
     * Object:��������'s �Ƿ�ģ��property 
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
     * Object: �������� 's Ʒ�� property 
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
     * Object: �������� 's �������� property 
     */
    public com.kingdee.eas.farm.carnivorous.basedata.SettlePolicyRecycleEntryCollection getRecycleEntry()
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.SettlePolicyRecycleEntryCollection)get("RecycleEntry");
    }
    /**
     * Object: �������� 's �������� property 
     */
    public com.kingdee.eas.farm.carnivorous.basedata.SettlePolicyAwardsEntryCollection getAwardsEntry()
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.SettlePolicyAwardsEntryCollection)get("AwardsEntry");
    }
    /**
     * Object:��������'s ��Ч����property 
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
     * Object:��������'s ʧЧ����property 
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
     * Object:��������'s ĸѼ�����(ֻ)property 
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
     * Object:��������'s ����������property 
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
     * Object:��������'s ���᷽ʽproperty 
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
     * Object:��������'s ��׼��������property 
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
     * Object: �������� 's ������¼ property 
     */
    public com.kingdee.eas.farm.carnivorous.basedata.SettlePolicySubsidyEntryCollection getSubsidyEntry()
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.SettlePolicySubsidyEntryCollection)get("SubsidyEntry");
    }
    /**
     * Object:��������'s ·�ı���(%)property 
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
     * Object:��������'s ��͵�ֻҩƷ(Ԫ/ֻ)property 
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
     * Object:��������'s ��׼������(%)property 
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
     * Object:��������'s ����ȿ۷���׼(Ԫ/kg)property 
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
     * Object:��������'s �˷Ѳ�����׼(Ԫ/��)property 
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
     * Object:��������'s ��δ���������Ƿ��ֹ��������ͬproperty 
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
     * Object:��������'s ������߷�(Ԫ/ֻ)property 
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
     * Object:��������'s ��ҩ����۷�����(%)property 
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
     * Object:��������'s ��ߵ�ֻҩƷ(Ԫ/ֻ)property 
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
     * Object:��������'s �������(Ԫ/ֻ)property 
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
     * Object:��������'s �����(Ԫ/ֻ)property 
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
     * Object:��������'s Ԥ������Ѻ��(Ԫ/ֻ)property 
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
     * Object:��������'s Ԥ������(Ԫ)property 
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
     * Object:��������'s �Ƿ�ִ������ֳ�����property 
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