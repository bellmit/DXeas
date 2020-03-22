package com.kingdee.eas.custom.wages.farm;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractMotorcadePayrollEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractMotorcadePayrollEntryInfo()
    {
        this("id");
    }
    protected AbstractMotorcadePayrollEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: ��¼ 's ����ͷ property 
     */
    public com.kingdee.eas.custom.wages.farm.MotorcadePayrollInfo getParent()
    {
        return (com.kingdee.eas.custom.wages.farm.MotorcadePayrollInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.custom.wages.farm.MotorcadePayrollInfo item)
    {
        put("parent", item);
    }
    /**
     * Object: ��¼ 's Ա�� property 
     */
    public com.kingdee.eas.basedata.person.PersonInfo getPerson()
    {
        return (com.kingdee.eas.basedata.person.PersonInfo)get("person");
    }
    public void setPerson(com.kingdee.eas.basedata.person.PersonInfo item)
    {
        put("person", item);
    }
    /**
     * Object:��¼'s �ͻ�����property 
     */
    public java.math.BigDecimal getShipptonnage()
    {
        return getBigDecimal("shipptonnage");
    }
    public void setShipptonnage(java.math.BigDecimal item)
    {
        setBigDecimal("shipptonnage", item);
    }
    /**
     * Object:��¼'s ��������property 
     */
    public java.math.BigDecimal getCompensation()
    {
        return getBigDecimal("compensation");
    }
    public void setCompensation(java.math.BigDecimal item)
    {
        setBigDecimal("compensation", item);
    }
    /**
     * Object:��¼'s ��ռ����property 
     */
    public String getTonnagerate()
    {
        return getString("tonnagerate");
    }
    public void setTonnagerate(String item)
    {
        setString("tonnagerate", item);
    }
    /**
     * Object:��¼'s н��property 
     */
    public java.math.BigDecimal getPaywages()
    {
        return getBigDecimal("paywages");
    }
    public void setPaywages(java.math.BigDecimal item)
    {
        setBigDecimal("paywages", item);
    }
    /**
     * Object:��¼'s �Ƽ�����property 
     */
    public java.math.BigDecimal getPayamount()
    {
        return getBigDecimal("payamount");
    }
    public void setPayamount(java.math.BigDecimal item)
    {
        setBigDecimal("payamount", item);
    }
    /**
     * Object:��¼'s �ּ������ʹ���property 
     */
    public java.math.BigDecimal getChinknumber()
    {
        return getBigDecimal("chinknumber");
    }
    public void setChinknumber(java.math.BigDecimal item)
    {
        setBigDecimal("chinknumber", item);
    }
    /**
     * Object:��¼'s �����󣨶֣�property 
     */
    public java.math.BigDecimal getSumtonnage()
    {
        return getBigDecimal("sumtonnage");
    }
    public void setSumtonnage(java.math.BigDecimal item)
    {
        setBigDecimal("sumtonnage", item);
    }
    /**
     * Object:��¼'s �ּ��ϲ���property 
     */
    public java.math.BigDecimal getChinkamount()
    {
        return getBigDecimal("chinkamount");
    }
    public void setChinkamount(java.math.BigDecimal item)
    {
        setBigDecimal("chinkamount", item);
    }
    /**
     * Object:��¼'s ���¹ʽ���property 
     */
    public java.math.BigDecimal getWsgjl()
    {
        return getBigDecimal("wsgjl");
    }
    public void setWsgjl(java.math.BigDecimal item)
    {
        setBigDecimal("wsgjl", item);
    }
    /**
     * Object:��¼'s Ѻ��property 
     */
    public java.math.BigDecimal getYj()
    {
        return getBigDecimal("yj");
    }
    public void setYj(java.math.BigDecimal item)
    {
        setBigDecimal("yj", item);
    }
    /**
     * Object:��¼'s ��нproperty 
     */
    public java.math.BigDecimal getMinamount()
    {
        return getBigDecimal("minamount");
    }
    public void setMinamount(java.math.BigDecimal item)
    {
        setBigDecimal("minamount", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("60B23DD7");
    }
}