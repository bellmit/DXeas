package com.kingdee.eas.farm.feemanager.basebizbill;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractMileModifyRecordInfo extends com.kingdee.eas.framework.CoreBillBaseInfo implements Serializable 
{
    public AbstractMileModifyRecordInfo()
    {
        this("id");
    }
    protected AbstractMileModifyRecordInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: ����޸ļ�¼ 's �������䵥 property 
     */
    public com.kingdee.eas.farm.feemanager.basebizbill.TransportationrecordInfo getTransportRecord()
    {
        return (com.kingdee.eas.farm.feemanager.basebizbill.TransportationrecordInfo)get("transportRecord");
    }
    public void setTransportRecord(com.kingdee.eas.farm.feemanager.basebizbill.TransportationrecordInfo item)
    {
        put("transportRecord", item);
    }
    /**
     * Object: ����޸ļ�¼ 's �޸��û� property 
     */
    public com.kingdee.eas.base.permission.UserInfo getModifier()
    {
        return (com.kingdee.eas.base.permission.UserInfo)get("modifier");
    }
    public void setModifier(com.kingdee.eas.base.permission.UserInfo item)
    {
        put("modifier", item);
    }
    /**
     * Object:����޸ļ�¼'s �޸�ʱ��property 
     */
    public java.util.Date getModifyTime()
    {
        return getDate("modifyTime");
    }
    public void setModifyTime(java.util.Date item)
    {
        setDate("modifyTime", item);
    }
    /**
     * Object: ����޸ļ�¼ 's �޸��� property 
     */
    public com.kingdee.eas.basedata.person.PersonInfo getModifyPerson()
    {
        return (com.kingdee.eas.basedata.person.PersonInfo)get("modifyPerson");
    }
    public void setModifyPerson(com.kingdee.eas.basedata.person.PersonInfo item)
    {
        put("modifyPerson", item);
    }
    /**
     * Object:����޸ļ�¼'s ������̡�ǰproperty 
     */
    public java.math.BigDecimal getSingleMileageB()
    {
        return getBigDecimal("singleMileageB");
    }
    public void setSingleMileageB(java.math.BigDecimal item)
    {
        setBigDecimal("singleMileageB", item);
    }
    /**
     * Object:����޸ļ�¼'s ȫ����̡�ǰproperty 
     */
    public java.math.BigDecimal getAllMileageB()
    {
        return getBigDecimal("allMileageB");
    }
    public void setAllMileageB(java.math.BigDecimal item)
    {
        setBigDecimal("allMileageB", item);
    }
    /**
     * Object:����޸ļ�¼'s ������̡���property 
     */
    public java.math.BigDecimal getSingleMileageA()
    {
        return getBigDecimal("singleMileageA");
    }
    public void setSingleMileageA(java.math.BigDecimal item)
    {
        setBigDecimal("singleMileageA", item);
    }
    /**
     * Object:����޸ļ�¼'s ȫ����̡���property 
     */
    public java.math.BigDecimal getAllMileageA()
    {
        return getBigDecimal("allMileageA");
    }
    public void setAllMileageA(java.math.BigDecimal item)
    {
        setBigDecimal("allMileageA", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("1CEF7B06");
    }
}