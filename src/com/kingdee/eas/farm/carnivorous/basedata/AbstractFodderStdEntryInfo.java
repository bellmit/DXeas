package com.kingdee.eas.farm.carnivorous.basedata;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractFodderStdEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractFodderStdEntryInfo()
    {
        this("id");
    }
    protected AbstractFodderStdEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: ��¼ 's null property 
     */
    public com.kingdee.eas.farm.carnivorous.basedata.FodderStdInfo getParent()
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.FodderStdInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.farm.carnivorous.basedata.FodderStdInfo item)
    {
        put("parent", item);
    }
    /**
     * Object:��¼'s ����property 
     */
    public int getWeekDay()
    {
        return getInt("weekDay");
    }
    public void setWeekDay(int item)
    {
        setInt("weekDay", item);
    }
    /**
     * Object: ��¼ 's ���� property 
     */
    public com.kingdee.eas.basedata.master.material.MaterialInfo getMaterial()
    {
        return (com.kingdee.eas.basedata.master.material.MaterialInfo)get("material");
    }
    public void setMaterial(com.kingdee.eas.basedata.master.material.MaterialInfo item)
    {
        put("material", item);
    }
    /**
     * Object:��¼'s ��ֻ������(g)property 
     */
    public java.math.BigDecimal getSingleUsed()
    {
        return getBigDecimal("singleUsed");
    }
    public void setSingleUsed(java.math.BigDecimal item)
    {
        setBigDecimal("singleUsed", item);
    }
    /**
     * Object:��¼'s ��׼ֻ��property 
     */
    public java.math.BigDecimal getSingleWgtStd()
    {
        return getBigDecimal("singleWgtStd");
    }
    public void setSingleWgtStd(java.math.BigDecimal item)
    {
        setBigDecimal("singleWgtStd", item);
    }
    /**
     * Object:��¼'s ��������(%)property 
     */
    public java.math.BigDecimal getDateDeadRate()
    {
        return getBigDecimal("dateDeadRate");
    }
    public void setDateDeadRate(java.math.BigDecimal item)
    {
        setBigDecimal("dateDeadRate", item);
    }
    /**
     * Object:��¼'s �ۼ�������(%)property 
     */
    public java.math.BigDecimal getTotalDeadRate()
    {
        return getBigDecimal("totalDeadRate");
    }
    public void setTotalDeadRate(java.math.BigDecimal item)
    {
        setBigDecimal("totalDeadRate", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("030B4DC7");
    }
}