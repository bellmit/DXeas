package com.kingdee.eas.farm.stocking.basedata;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractCoProductPriceInfo extends com.kingdee.eas.framework.DataBaseInfo implements Serializable 
{
    public AbstractCoProductPriceInfo()
    {
        this("id");
    }
    protected AbstractCoProductPriceInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: ����Ʒ�۸�ά�� 's ��� property 
     */
    public com.kingdee.eas.farm.stocking.basedata.CoProductPriceTreeInfo getTreeid()
    {
        return (com.kingdee.eas.farm.stocking.basedata.CoProductPriceTreeInfo)get("treeid");
    }
    public void setTreeid(com.kingdee.eas.farm.stocking.basedata.CoProductPriceTreeInfo item)
    {
        put("treeid", item);
    }
    /**
     * Object:����Ʒ�۸�ά��'s ˵��property 
     */
    public String getRemark()
    {
        return getString("remark");
    }
    public void setRemark(String item)
    {
        setString("remark", item);
    }
    /**
     * Object:����Ʒ�۸�ά��'s ����״̬property 
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
     * Object:����Ʒ�۸�ά��'s ����property 
     */
    public java.util.Date getEffectDate()
    {
        return getDate("effectDate");
    }
    public void setEffectDate(java.util.Date item)
    {
        setDate("effectDate", item);
    }
    /**
     * Object: ����Ʒ�۸�ά�� 's ������֯ property 
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
     * Object:����Ʒ�۸�ά��'s ʧЧ����property 
     */
    public java.util.Date getUnEffectDate()
    {
        return getDate("unEffectDate");
    }
    public void setUnEffectDate(java.util.Date item)
    {
        setDate("unEffectDate", item);
    }
    /**
     * Object:����Ʒ�۸�ά��'s �Ƶ���property 
     */
    public java.math.BigDecimal getBrokenSinglePrice()
    {
        return getBigDecimal("brokenSinglePrice");
    }
    public void setBrokenSinglePrice(java.math.BigDecimal item)
    {
        setBigDecimal("brokenSinglePrice", item);
    }
    /**
     * Object:����Ʒ�۸�ά��'s �˵�property 
     */
    public java.math.BigDecimal getGreensPrice()
    {
        return getBigDecimal("greensPrice");
    }
    public void setGreensPrice(java.math.BigDecimal item)
    {
        setBigDecimal("greensPrice", item);
    }
    /**
     * Object:����Ʒ�۸�ά��'s �൰property 
     */
    public java.math.BigDecimal getDirtyPirce()
    {
        return getBigDecimal("dirtyPirce");
    }
    public void setDirtyPirce(java.math.BigDecimal item)
    {
        setBigDecimal("dirtyPirce", item);
    }
    /**
     * Object:����Ʒ�۸�ά��'s ���ε�property 
     */
    public java.math.BigDecimal getMutantPrice()
    {
        return getBigDecimal("mutantPrice");
    }
    public void setMutantPrice(java.math.BigDecimal item)
    {
        setBigDecimal("mutantPrice", item);
    }
    /**
     * Object:����Ʒ�۸�ά��'s ˫�Ƶ�property 
     */
    public java.math.BigDecimal getDoublePrice()
    {
        return getBigDecimal("doublePrice");
    }
    public void setDoublePrice(java.math.BigDecimal item)
    {
        setBigDecimal("doublePrice", item);
    }
    /**
     * Object:����Ʒ�۸�ά��'s ����property 
     */
    public java.math.BigDecimal getFlowPrice()
    {
        return getBigDecimal("flowPrice");
    }
    public void setFlowPrice(java.math.BigDecimal item)
    {
        setBigDecimal("flowPrice", item);
    }
    /**
     * Object:����Ʒ�۸�ά��'s ��˫��property 
     */
    public java.math.BigDecimal getBrokenDoublePrice()
    {
        return getBigDecimal("brokenDoublePrice");
    }
    public void setBrokenDoublePrice(java.math.BigDecimal item)
    {
        setBigDecimal("brokenDoublePrice", item);
    }
    /**
     * Object: ����Ʒ�۸�ά�� 's ������λ property 
     */
    public com.kingdee.eas.basedata.assistant.MeasureUnitInfo getUnit()
    {
        return (com.kingdee.eas.basedata.assistant.MeasureUnitInfo)get("unit");
    }
    public void setUnit(com.kingdee.eas.basedata.assistant.MeasureUnitInfo item)
    {
        put("unit", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("566729B7");
    }
}