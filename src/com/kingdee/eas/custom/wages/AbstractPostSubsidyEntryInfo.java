package com.kingdee.eas.custom.wages;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractPostSubsidyEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractPostSubsidyEntryInfo()
    {
        this("id");
    }
    protected AbstractPostSubsidyEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: ��λ������¼ 's null property 
     */
    public com.kingdee.eas.custom.wages.PostSubsidyInfo getParent()
    {
        return (com.kingdee.eas.custom.wages.PostSubsidyInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.custom.wages.PostSubsidyInfo item)
    {
        put("parent", item);
    }
    /**
     * Object: ��λ������¼ 's Ա������ property 
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
     * Object:��λ������¼'s Ա������property 
     */
    public String getPersonName()
    {
        return getString("personName");
    }
    public void setPersonName(String item)
    {
        setString("personName", item);
    }
    /**
     * Object:��λ������¼'s ���Ὺʼ�·ݾ�property 
     */
    public java.util.Date getStartMonth()
    {
        return getDate("startMonth");
    }
    public void setStartMonth(java.util.Date item)
    {
        setDate("startMonth", item);
    }
    /**
     * Object:��λ������¼'s ��������·ݾ�property 
     */
    public java.util.Date getEndMonth()
    {
        return getDate("endMonth");
    }
    public void setEndMonth(java.util.Date item)
    {
        setDate("endMonth", item);
    }
    /**
     * Object:��λ������¼'s �������·�property 
     */
    public int getAllMonth()
    {
        return getInt("allMonth");
    }
    public void setAllMonth(int item)
    {
        setInt("allMonth", item);
    }
    /**
     * Object:��λ������¼'s �Ѽ����·ݾ�property 
     */
    public int getAlreadyMonth()
    {
        return getInt("AlreadyMonth");
    }
    public void setAlreadyMonth(int item)
    {
        setInt("AlreadyMonth", item);
    }
    /**
     * Object:��λ������¼'s �Ѽ�����property 
     */
    public java.math.BigDecimal getAlreadyMoney()
    {
        return getBigDecimal("AlreadyMoney");
    }
    public void setAlreadyMoney(java.math.BigDecimal item)
    {
        setBigDecimal("AlreadyMoney", item);
    }
    /**
     * Object:��λ������¼'s �����ܽ��property 
     */
    public java.math.BigDecimal getAllMoney()
    {
        return getBigDecimal("allMoney");
    }
    public void setAllMoney(java.math.BigDecimal item)
    {
        setBigDecimal("allMoney", item);
    }
    /**
     * Object: ��λ������¼ 's Ա����λ property 
     */
    public com.kingdee.eas.custom.wages.BasicPostInfo getPsersonpost()
    {
        return (com.kingdee.eas.custom.wages.BasicPostInfo)get("psersonpost");
    }
    public void setPsersonpost(com.kingdee.eas.custom.wages.BasicPostInfo item)
    {
        put("psersonpost", item);
    }
    /**
     * Object:��λ������¼'s ���¼�����property 
     */
    public java.math.BigDecimal getPostWages()
    {
        return getBigDecimal("postWages");
    }
    public void setPostWages(java.math.BigDecimal item)
    {
        setBigDecimal("postWages", item);
    }
    /**
     * Object:��λ������¼'s ��ʼ�����·�property 
     */
    public String getStartMonthN()
    {
        return getString("startMonthN");
    }
    public void setStartMonthN(String item)
    {
        setString("startMonthN", item);
    }
    /**
     * Object:��λ������¼'s ���������·�property 
     */
    public String getEndMonthN()
    {
        return getString("endMonthN");
    }
    public void setEndMonthN(String item)
    {
        setString("endMonthN", item);
    }
    /**
     * Object:��λ������¼'s �Ѽ����·�property 
     */
    public String getAlreadyMonthN()
    {
        return getString("AlreadyMonthN");
    }
    public void setAlreadyMonthN(String item)
    {
        setString("AlreadyMonthN", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("02A8784F");
    }
}