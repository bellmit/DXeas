package com.kingdee.eas.custom.wages.farm;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractBasicPostFarmInfo extends com.kingdee.eas.framework.DataBaseInfo implements Serializable 
{
    public AbstractBasicPostFarmInfo()
    {
        this("id");
    }
    protected AbstractBasicPostFarmInfo(String pkField)
    {
        super(pkField);
        put("Entry", new com.kingdee.eas.custom.wages.farm.BasicPostFarmEntryCollection());
    }
    /**
     * Object:��ֳ������λ's ��λ����property 
     */
    public java.math.BigDecimal getPostSalary()
    {
        return getBigDecimal("PostSalary");
    }
    public void setPostSalary(java.math.BigDecimal item)
    {
        setBigDecimal("PostSalary", item);
    }
    /**
     * Object:��ֳ������λ's ��Ʒϵ��property 
     */
    public java.math.BigDecimal getProductRatio()
    {
        return getBigDecimal("ProductRatio");
    }
    public void setProductRatio(java.math.BigDecimal item)
    {
        setBigDecimal("ProductRatio", item);
    }
    /**
     * Object: ��ֳ������λ 's ��λ��Ա property 
     */
    public com.kingdee.eas.custom.wages.farm.BasicPostFarmEntryCollection getEntry()
    {
        return (com.kingdee.eas.custom.wages.farm.BasicPostFarmEntryCollection)get("Entry");
    }
    /**
     * Object:��ֳ������λ's ������λproperty 
     */
    public com.kingdee.eas.custom.wages.UnitOfMetering getUnitMetering()
    {
        return com.kingdee.eas.custom.wages.UnitOfMetering.getEnum(getString("UnitMetering"));
    }
    public void setUnitMetering(com.kingdee.eas.custom.wages.UnitOfMetering item)
    {
		if (item != null) {
        setString("UnitMetering", item.getValue());
		}
    }
    /**
     * Object:��ֳ������λ's ����״̬property 
     */
    public com.kingdee.eas.custom.wages.BasicStatus getBaseStatus()
    {
        return com.kingdee.eas.custom.wages.BasicStatus.getEnum(getString("BaseStatus"));
    }
    public void setBaseStatus(com.kingdee.eas.custom.wages.BasicStatus item)
    {
		if (item != null) {
        setString("BaseStatus", item.getValue());
		}
    }
    /**
     * Object: ��ֳ������λ 's ְλ property 
     */
    public com.kingdee.eas.basedata.org.PositionInfo getPosition()
    {
        return (com.kingdee.eas.basedata.org.PositionInfo)get("position");
    }
    public void setPosition(com.kingdee.eas.basedata.org.PositionInfo item)
    {
        put("position", item);
    }
    /**
     * Object:��ֳ������λ's ��λ����property 
     */
    public String getPostname()
    {
        return getString("postname");
    }
    public void setPostname(String item)
    {
        setString("postname", item);
    }
    /**
     * Object: ��ֳ������λ 's �������� property 
     */
    public com.kingdee.eas.custom.wages.farm.WagesFarmOrganInfo getFromposition()
    {
        return (com.kingdee.eas.custom.wages.farm.WagesFarmOrganInfo)get("fromposition");
    }
    public void setFromposition(com.kingdee.eas.custom.wages.farm.WagesFarmOrganInfo item)
    {
        put("fromposition", item);
    }
    /**
     * Object:��ֳ������λ's ��������property 
     */
    public java.math.BigDecimal getBasicwages()
    {
        return getBigDecimal("basicwages");
    }
    public void setBasicwages(java.math.BigDecimal item)
    {
        setBigDecimal("basicwages", item);
    }
    /**
     * Object:��ֳ������λ's ���߲���property 
     */
    public java.math.BigDecimal getEpidemicSub()
    {
        return getBigDecimal("EpidemicSub");
    }
    public void setEpidemicSub(java.math.BigDecimal item)
    {
        setBigDecimal("EpidemicSub", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("0781235A");
    }
}