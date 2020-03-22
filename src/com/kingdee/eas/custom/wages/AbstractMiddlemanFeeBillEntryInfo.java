package com.kingdee.eas.custom.wages;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractMiddlemanFeeBillEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractMiddlemanFeeBillEntryInfo()
    {
        this("id");
    }
    protected AbstractMiddlemanFeeBillEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: ���ܷѷ�¼ 's null property 
     */
    public com.kingdee.eas.custom.wages.MiddlemanFeeBillInfo getParent()
    {
        return (com.kingdee.eas.custom.wages.MiddlemanFeeBillInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.custom.wages.MiddlemanFeeBillInfo item)
    {
        put("parent", item);
    }
    /**
     * Object: ���ܷѷ�¼ 's Ա������ property 
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
     * Object:���ܷѷ�¼'s Ա������property 
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
     * Object: ���ܷѷ�¼ 's ��Ա������ property 
     */
    public com.kingdee.eas.basedata.person.PersonInfo getNPerson()
    {
        return (com.kingdee.eas.basedata.person.PersonInfo)get("NPerson");
    }
    public void setNPerson(com.kingdee.eas.basedata.person.PersonInfo item)
    {
        put("NPerson", item);
    }
    /**
     * Object:���ܷѷ�¼'s ��Ա������property 
     */
    public String getNPersonName()
    {
        return getString("NPersonName");
    }
    public void setNPersonName(String item)
    {
        setString("NPersonName", item);
    }
    /**
     * Object:���ܷѷ�¼'s ���ܷ�property 
     */
    public java.math.BigDecimal getMiddlemanFee()
    {
        return getBigDecimal("middlemanFee");
    }
    public void setMiddlemanFee(java.math.BigDecimal item)
    {
        setBigDecimal("middlemanFee", item);
    }
    /**
     * Object:���ܷѷ�¼'s ��Ա����ְʱ��property 
     */
    public java.util.Date getNEntryTime()
    {
        return getDate("NEntryTime");
    }
    public void setNEntryTime(java.util.Date item)
    {
        setDate("NEntryTime", item);
    }
    /**
     * Object:���ܷѷ�¼'s �������·�property 
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
     * Object:���ܷѷ�¼'s �����ܽ��property 
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
     * Object:���ܷѷ�¼'s �Ѽ����·ݾ�property 
     */
    public int getAlreadyMonth()
    {
        return getInt("alreadyMonth");
    }
    public void setAlreadyMonth(int item)
    {
        setInt("alreadyMonth", item);
    }
    /**
     * Object:���ܷѷ�¼'s �Ѽ�����property 
     */
    public java.math.BigDecimal getAlreadyMoney()
    {
        return getBigDecimal("alreadyMoney");
    }
    public void setAlreadyMoney(java.math.BigDecimal item)
    {
        setBigDecimal("alreadyMoney", item);
    }
    /**
     * Object:���ܷѷ�¼'s ���Ὺʼ�·ݾ�property 
     */
    public java.util.Date getStratMonth()
    {
        return getDate("stratMonth");
    }
    public void setStratMonth(java.util.Date item)
    {
        setDate("stratMonth", item);
    }
    /**
     * Object:���ܷѷ�¼'s ��������·ݾ�property 
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
     * Object:���ܷѷ�¼'s ��ֹͣ����property 
     */
    public boolean isStopPoint()
    {
        return getBoolean("stopPoint");
    }
    public void setStopPoint(boolean item)
    {
        setBoolean("stopPoint", item);
    }
    /**
     * Object:���ܷѷ�¼'s ���¼�����property 
     */
    public java.math.BigDecimal getMidWages()
    {
        return getBigDecimal("midWages");
    }
    public void setMidWages(java.math.BigDecimal item)
    {
        setBigDecimal("midWages", item);
    }
    /**
     * Object:���ܷѷ�¼'s ��ʼ�����·�property 
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
     * Object:���ܷѷ�¼'s ���������·�property 
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
     * Object:���ܷѷ�¼'s �Ѽ����·�property 
     */
    public String getAlreadyMonthN()
    {
        return getString("alreadyMonthN");
    }
    public void setAlreadyMonthN(String item)
    {
        setString("alreadyMonthN", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("F2597102");
    }
}