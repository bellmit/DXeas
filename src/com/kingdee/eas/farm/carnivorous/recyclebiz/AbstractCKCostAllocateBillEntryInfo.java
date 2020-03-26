package com.kingdee.eas.farm.carnivorous.recyclebiz;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractCKCostAllocateBillEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractCKCostAllocateBillEntryInfo()
    {
        this("id");
    }
    protected AbstractCKCostAllocateBillEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: ��¼ 's ����ͷ property 
     */
    public com.kingdee.eas.farm.carnivorous.recyclebiz.CKCostAllocateBillInfo getParent()
    {
        return (com.kingdee.eas.farm.carnivorous.recyclebiz.CKCostAllocateBillInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.farm.carnivorous.recyclebiz.CKCostAllocateBillInfo item)
    {
        put("parent", item);
    }
    /**
     * Object: ��¼ 's ��ֳ�� property 
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
     * Object: ��¼ 's ��ֳ�� property 
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
     * Object: ��¼ 's ���κ�ͬ property 
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
     * Object:��¼'s ���ڷ�̯����property 
     */
    public java.math.BigDecimal getAmount()
    {
        return getBigDecimal("amount");
    }
    public void setAmount(java.math.BigDecimal item)
    {
        setBigDecimal("amount", item);
    }
    /**
     * Object:��¼'s ��������property 
     */
    public java.math.BigDecimal getWeight()
    {
        return getBigDecimal("weight");
    }
    public void setWeight(java.math.BigDecimal item)
    {
        setBigDecimal("weight", item);
    }
    /**
     * Object: ��¼ 's Ʒ������ property 
     */
    public com.kingdee.eas.farm.stocking.basedata.BreedDataInfo getBreeddata()
    {
        return (com.kingdee.eas.farm.stocking.basedata.BreedDataInfo)get("breeddata");
    }
    public void setBreeddata(com.kingdee.eas.farm.stocking.basedata.BreedDataInfo item)
    {
        put("breeddata", item);
    }
    /**
     * Object:��¼'s ��������property 
     */
    public java.math.BigDecimal getRecWgt()
    {
        return getBigDecimal("recWgt");
    }
    public void setRecWgt(java.math.BigDecimal item)
    {
        setBigDecimal("recWgt", item);
    }
    /**
     * Object:��¼'s ����ֻ��property 
     */
    public java.math.BigDecimal getInQty()
    {
        return getBigDecimal("inQty");
    }
    public void setInQty(java.math.BigDecimal item)
    {
        setBigDecimal("inQty", item);
    }
    /**
     * Object: ��¼ 's �ɱ����� property 
     */
    public com.kingdee.eas.basedata.org.CostCenterOrgUnitInfo getCostCenter()
    {
        return (com.kingdee.eas.basedata.org.CostCenterOrgUnitInfo)get("costCenter");
    }
    public void setCostCenter(com.kingdee.eas.basedata.org.CostCenterOrgUnitInfo item)
    {
        put("costCenter", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("DCB4D8FC");
    }
}