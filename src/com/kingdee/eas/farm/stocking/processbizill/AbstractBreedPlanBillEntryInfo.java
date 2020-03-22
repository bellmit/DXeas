package com.kingdee.eas.farm.stocking.processbizill;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractBreedPlanBillEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractBreedPlanBillEntryInfo()
    {
        this("id");
    }
    protected AbstractBreedPlanBillEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: ��¼ 's ����ͷ property 
     */
    public com.kingdee.eas.farm.stocking.processbizill.BreedPlanBillInfo getParent()
    {
        return (com.kingdee.eas.farm.stocking.processbizill.BreedPlanBillInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.farm.stocking.processbizill.BreedPlanBillInfo item)
    {
        put("parent", item);
    }
    /**
     * Object: ��¼ 's Ʒ�� property 
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
     * Object:��¼'s ��������property 
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
     * Object:��¼'s ��������property 
     */
    public java.math.BigDecimal getBreedQty()
    {
        return getBigDecimal("breedQty");
    }
    public void setBreedQty(java.math.BigDecimal item)
    {
        setBigDecimal("breedQty", item);
    }
    /**
     * Object:��¼'s �Ƿ���Ҫ����property 
     */
    public boolean isIsImmune()
    {
        return getBoolean("isImmune");
    }
    public void setIsImmune(boolean item)
    {
        setBoolean("isImmune", item);
    }
    /**
     * Object:��¼'s ĸ������property 
     */
    public java.math.BigDecimal getFemaleBreedQty()
    {
        return getBigDecimal("femaleBreedQty");
    }
    public void setFemaleBreedQty(java.math.BigDecimal item)
    {
        setBigDecimal("femaleBreedQty", item);
    }
    /**
     * Object: ��¼ 's ��ֳ�� property 
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
     * Object: ��¼ 's ��ֳ�� property 
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
     * Object: ��¼ 's ���κ�ͬ property 
     */
    public com.kingdee.eas.farm.stocking.processbizill.BatchContractInfo getBatchContract()
    {
        return (com.kingdee.eas.farm.stocking.processbizill.BatchContractInfo)get("batchContract");
    }
    public void setBatchContract(com.kingdee.eas.farm.stocking.processbizill.BatchContractInfo item)
    {
        put("batchContract", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("A8145293");
    }
}