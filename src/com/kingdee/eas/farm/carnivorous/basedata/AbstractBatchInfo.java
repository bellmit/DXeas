package com.kingdee.eas.farm.carnivorous.basedata;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractBatchInfo extends com.kingdee.eas.framework.DataBaseInfo implements Serializable 
{
    public AbstractBatchInfo()
    {
        this("id");
    }
    protected AbstractBatchInfo(String pkField)
    {
        super(pkField);
        put("HouseEntry", new com.kingdee.eas.farm.carnivorous.basedata.BatchHouseEntryCollection());
    }
    /**
     * Object: ������Ϣ 's ��� property 
     */
    public com.kingdee.eas.farm.carnivorous.basedata.BatchTreeInfo getTreeid()
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.BatchTreeInfo)get("treeid");
    }
    public void setTreeid(com.kingdee.eas.farm.carnivorous.basedata.BatchTreeInfo item)
    {
        put("treeid", item);
    }
    /**
     * Object: ������Ϣ 's Ʒ����Ϣ property 
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
     * Object:������Ϣ's ����״̬property 
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
     * Object:������Ϣ's ��������property 
     */
    public java.math.BigDecimal getBatchQty()
    {
        return getBigDecimal("batchQty");
    }
    public void setBatchQty(java.math.BigDecimal item)
    {
        setBigDecimal("batchQty", item);
    }
    /**
     * Object:������Ϣ's ��������property 
     */
    public java.util.Date getInDate()
    {
        return getDate("inDate");
    }
    public void setInDate(java.util.Date item)
    {
        setDate("inDate", item);
    }
    /**
     * Object: ������Ϣ 's ������֯ property 
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
     * Object: ������Ϣ 's ����� property 
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
     * Object:������Ϣ's ���ʱ��property 
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
     * Object:������Ϣ's ĸ������property 
     */
    public java.math.BigDecimal getFemaleQty()
    {
        return getBigDecimal("femaleQty");
    }
    public void setFemaleQty(java.math.BigDecimal item)
    {
        setBigDecimal("femaleQty", item);
    }
    /**
     * Object: ������Ϣ 's �ɱ����� property 
     */
    public com.kingdee.eas.basedata.assistant.CostObjectInfo getCostItem()
    {
        return (com.kingdee.eas.basedata.assistant.CostObjectInfo)get("costItem");
    }
    public void setCostItem(com.kingdee.eas.basedata.assistant.CostObjectInfo item)
    {
        put("costItem", item);
    }
    /**
     * Object:������Ϣ's ��ʼ���property 
     */
    public java.math.BigDecimal getInitBalanceAmount()
    {
        return getBigDecimal("initBalanceAmount");
    }
    public void setInitBalanceAmount(java.math.BigDecimal item)
    {
        setBigDecimal("initBalanceAmount", item);
    }
    /**
     * Object:������Ϣ's ���property 
     */
    public java.math.BigDecimal getBalanceAmount()
    {
        return getBigDecimal("balanceAmount");
    }
    public void setBalanceAmount(java.math.BigDecimal item)
    {
        setBigDecimal("balanceAmount", item);
    }
    /**
     * Object:������Ϣ's ��ʼ�ֽ�֤��property 
     */
    public java.math.BigDecimal getInitMargin()
    {
        return getBigDecimal("initMargin");
    }
    public void setInitMargin(java.math.BigDecimal item)
    {
        setBigDecimal("initMargin", item);
    }
    /**
     * Object:������Ϣ's ��ʼͳ����property 
     */
    public java.math.BigDecimal getInitAllEggQty()
    {
        return getBigDecimal("initAllEggQty");
    }
    public void setInitAllEggQty(java.math.BigDecimal item)
    {
        setBigDecimal("initAllEggQty", item);
    }
    /**
     * Object:������Ϣ's ��ʼ�ϸ���property 
     */
    public java.math.BigDecimal getInitQcEggQty()
    {
        return getBigDecimal("initQcEggQty");
    }
    public void setInitQcEggQty(java.math.BigDecimal item)
    {
        setBigDecimal("initQcEggQty", item);
    }
    /**
     * Object:������Ϣ's ��ʼ�ܾ�����property 
     */
    public java.math.BigDecimal getInitFertilizeEggQty()
    {
        return getBigDecimal("initFertilizeEggQty");
    }
    public void setInitFertilizeEggQty(java.math.BigDecimal item)
    {
        setBigDecimal("initFertilizeEggQty", item);
    }
    /**
     * Object:������Ϣ's ��ʼ�����֤��property 
     */
    public java.math.BigDecimal getInitLoanMargin()
    {
        return getBigDecimal("initLoanMargin");
    }
    public void setInitLoanMargin(java.math.BigDecimal item)
    {
        setBigDecimal("initLoanMargin", item);
    }
    /**
     * Object:������Ϣ's �Ƿ���ȫ����property 
     */
    public boolean isIsAllOut()
    {
        return getBoolean("isAllOut");
    }
    public void setIsAllOut(boolean item)
    {
        setBoolean("isAllOut", item);
    }
    /**
     * Object:������Ϣ's ��Ⱥ����property 
     */
    public java.util.Date getMatureDate()
    {
        return getDate("matureDate");
    }
    public void setMatureDate(java.util.Date item)
    {
        setDate("matureDate", item);
    }
    /**
     * Object: ������Ϣ 's �ֵ��ɱ����� property 
     */
    public com.kingdee.eas.basedata.assistant.CostObjectInfo getEggCostItem()
    {
        return (com.kingdee.eas.basedata.assistant.CostObjectInfo)get("eggCostItem");
    }
    public void setEggCostItem(com.kingdee.eas.basedata.assistant.CostObjectInfo item)
    {
        put("eggCostItem", item);
    }
    /**
     * Object:������Ϣ's ת������property 
     */
    public java.util.Date getFormalDate()
    {
        return getDate("formalDate");
    }
    public void setFormalDate(java.util.Date item)
    {
        setDate("formalDate", item);
    }
    /**
     * Object:������Ϣ's ת��������property 
     */
    public java.util.Date getBreedDate()
    {
        return getDate("breedDate");
    }
    public void setBreedDate(java.util.Date item)
    {
        setDate("breedDate", item);
    }
    /**
     * Object:������Ϣ's ��ȫ��������property 
     */
    public java.util.Date getAllOutDate()
    {
        return getDate("allOutDate");
    }
    public void setAllOutDate(java.util.Date item)
    {
        setDate("allOutDate", item);
    }
    /**
     * Object:������Ϣ's ��ֳ����property 
     */
    public java.math.BigDecimal getTotalQty()
    {
        return getBigDecimal("totalQty");
    }
    public void setTotalQty(java.math.BigDecimal item)
    {
        setBigDecimal("totalQty", item);
    }
    /**
     * Object: ������Ϣ 's ��ֳ�� property 
     */
    public com.kingdee.eas.farm.carnivorous.basedata.FarmInfo getFarm()
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.FarmInfo)get("farm");
    }
    public void setFarm(com.kingdee.eas.farm.carnivorous.basedata.FarmInfo item)
    {
        put("farm", item);
    }
    /**
     * Object: ������Ϣ 's ��ֳ�� property 
     */
    public com.kingdee.eas.farm.carnivorous.basedata.FarmerInfo getFarmer()
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.FarmerInfo)get("farmer");
    }
    public void setFarmer(com.kingdee.eas.farm.carnivorous.basedata.FarmerInfo item)
    {
        put("farmer", item);
    }
    /**
     * Object: ������Ϣ 's ���κ�ͬ property 
     */
    public com.kingdee.eas.farm.carnivorous.feedbiz.BatchContractBillInfo getBatchContract()
    {
        return (com.kingdee.eas.farm.carnivorous.feedbiz.BatchContractBillInfo)get("batchContract");
    }
    public void setBatchContract(com.kingdee.eas.farm.carnivorous.feedbiz.BatchContractBillInfo item)
    {
        put("batchContract", item);
    }
    /**
     * Object: ������Ϣ 's �г��������� property 
     */
    public com.kingdee.eas.farm.carnivorous.basedata.MarketPolicyInfo getMarketPolicy()
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.MarketPolicyInfo)get("marketPolicy");
    }
    public void setMarketPolicy(com.kingdee.eas.farm.carnivorous.basedata.MarketPolicyInfo item)
    {
        put("marketPolicy", item);
    }
    /**
     * Object: ������Ϣ 's ��Ʒ���ɱ����� property 
     */
    public com.kingdee.eas.basedata.assistant.CostObjectInfo getCarvCostObject()
    {
        return (com.kingdee.eas.basedata.assistant.CostObjectInfo)get("carvCostObject");
    }
    public void setCarvCostObject(com.kingdee.eas.basedata.assistant.CostObjectInfo item)
    {
        put("carvCostObject", item);
    }
    /**
     * Object: ������Ϣ 's ������Ϣ property 
     */
    public com.kingdee.eas.farm.carnivorous.basedata.BatchHouseEntryCollection getHouseEntry()
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.BatchHouseEntryCollection)get("HouseEntry");
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("83B77AD8");
    }
}