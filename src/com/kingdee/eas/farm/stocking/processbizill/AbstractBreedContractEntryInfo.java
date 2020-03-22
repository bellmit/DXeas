package com.kingdee.eas.farm.stocking.processbizill;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractBreedContractEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractBreedContractEntryInfo()
    {
        this("id");
    }
    protected AbstractBreedContractEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: ��¼ 's ����ͷ property 
     */
    public com.kingdee.eas.farm.stocking.processbizill.BreedContractInfo getParent()
    {
        return (com.kingdee.eas.farm.stocking.processbizill.BreedContractInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.farm.stocking.processbizill.BreedContractInfo item)
    {
        put("parent", item);
    }
    /**
     * Object: ��¼ 's ��ֳ�� property 
     */
    public com.kingdee.eas.farm.stocking.basedata.FarmInfo getFarmer()
    {
        return (com.kingdee.eas.farm.stocking.basedata.FarmInfo)get("farmer");
    }
    public void setFarmer(com.kingdee.eas.farm.stocking.basedata.FarmInfo item)
    {
        put("farmer", item);
    }
    /**
     * Object: ��¼ 's ��ֳƷ�� property 
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
     * Object:��¼'s ��ֳ����property 
     */
    public java.math.BigDecimal getQty()
    {
        return getBigDecimal("qty");
    }
    public void setQty(java.math.BigDecimal item)
    {
        setBigDecimal("qty", item);
    }
    /**
     * Object:��¼'s ��ʼ��ֳ����property 
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
     * Object:��¼'s ������ֳ����property 
     */
    public java.util.Date getEndData()
    {
        return getDate("endData");
    }
    public void setEndData(java.util.Date item)
    {
        setDate("endData", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("AB31C191");
    }
}