package com.kingdee.eas.farm.carnivorous.basedata;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractBatchHouseEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractBatchHouseEntryInfo()
    {
        this("id");
    }
    protected AbstractBatchHouseEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: ������Ϣ 's null property 
     */
    public com.kingdee.eas.farm.carnivorous.basedata.BatchInfo getParent()
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.BatchInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.farm.carnivorous.basedata.BatchInfo item)
    {
        put("parent", item);
    }
    /**
     * Object: ������Ϣ 's ���� property 
     */
    public com.kingdee.eas.farm.carnivorous.basedata.FarmHouseEntryInfo getHouse()
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.FarmHouseEntryInfo)get("house");
    }
    public void setHouse(com.kingdee.eas.farm.carnivorous.basedata.FarmHouseEntryInfo item)
    {
        put("house", item);
    }
    /**
     * Object:������Ϣ's �������property 
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
     * Object:������Ϣ's ��������property 
     */
    public java.util.Date getRlDate()
    {
        return getDate("rlDate");
    }
    public void setRlDate(java.util.Date item)
    {
        setDate("rlDate", item);
    }
    /**
     * Object:������Ϣ's ��������property 
     */
    public java.math.BigDecimal getMaleQty()
    {
        return getBigDecimal("maleQty");
    }
    public void setMaleQty(java.math.BigDecimal item)
    {
        setBigDecimal("maleQty", item);
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
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("15216E2A");
    }
}