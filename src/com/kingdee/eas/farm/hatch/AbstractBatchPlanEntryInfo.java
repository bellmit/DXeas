package com.kingdee.eas.farm.hatch;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractBatchPlanEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractBatchPlanEntryInfo()
    {
        this("id");
    }
    protected AbstractBatchPlanEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: ��¼ 's ����ͷ property 
     */
    public com.kingdee.eas.farm.hatch.BatchPlanInfo getParent()
    {
        return (com.kingdee.eas.farm.hatch.BatchPlanInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.farm.hatch.BatchPlanInfo item)
    {
        put("parent", item);
    }
    /**
     * Object:��¼'s �������property 
     */
    public java.util.Date getPlanDate()
    {
        return getDate("planDate");
    }
    public void setPlanDate(java.util.Date item)
    {
        setDate("planDate", item);
    }
    /**
     * Object:��¼'s �Ϸ�����property 
     */
    public int getCarCount()
    {
        return getInt("carCount");
    }
    public void setCarCount(int item)
    {
        setInt("carCount", item);
    }
    /**
     * Object:��¼'s �Ϸ�����property 
     */
    public int getEggQty()
    {
        return getInt("eggQty");
    }
    public void setEggQty(int item)
    {
        setInt("eggQty", item);
    }
    /**
     * Object:��¼'s ��������property 
     */
    public java.util.Date getHatchBabyDate()
    {
        return getDate("hatchBabyDate");
    }
    public void setHatchBabyDate(java.util.Date item)
    {
        setDate("hatchBabyDate", item);
    }
    /**
     * Object: ��¼ 's ����ȥ����Ʒ���� property 
     */
    public com.kingdee.eas.basedata.org.StorageOrgUnitInfo getCcFarm()
    {
        return (com.kingdee.eas.basedata.org.StorageOrgUnitInfo)get("ccFarm");
    }
    public void setCcFarm(com.kingdee.eas.basedata.org.StorageOrgUnitInfo item)
    {
        put("ccFarm", item);
    }
    /**
     * Object:��¼'s Ԥ�Ʒ�����(%)property 
     */
    public java.math.BigDecimal getPreHatchRate()
    {
        return getBigDecimal("preHatchRate");
    }
    public void setPreHatchRate(java.math.BigDecimal item)
    {
        setBigDecimal("preHatchRate", item);
    }
    /**
     * Object:��¼'s Ԥ�Ƴ�����property 
     */
    public int getPreHatchQty()
    {
        return getInt("preHatchQty");
    }
    public void setPreHatchQty(int item)
    {
        setInt("preHatchQty", item);
    }
    /**
     * Object:��¼'s ��Ʒ����������property 
     */
    public java.math.BigDecimal getRequirementAmt()
    {
        return getBigDecimal("requirementAmt");
    }
    public void setRequirementAmt(java.math.BigDecimal item)
    {
        setBigDecimal("requirementAmt", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("C4F5063D");
    }
}