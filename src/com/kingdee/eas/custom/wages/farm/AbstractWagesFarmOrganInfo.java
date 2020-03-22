package com.kingdee.eas.custom.wages.farm;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractWagesFarmOrganInfo extends com.kingdee.eas.framework.DataBaseInfo implements Serializable 
{
    public AbstractWagesFarmOrganInfo()
    {
        this("id");
    }
    protected AbstractWagesFarmOrganInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: ��ֳ��֯�ܹ� 's ��� property 
     */
    public com.kingdee.eas.custom.wages.farm.WagesFarmOrganTreeInfo getTreeid()
    {
        return (com.kingdee.eas.custom.wages.farm.WagesFarmOrganTreeInfo)get("treeid");
    }
    public void setTreeid(com.kingdee.eas.custom.wages.farm.WagesFarmOrganTreeInfo item)
    {
        put("treeid", item);
    }
    /**
     * Object:��ֳ��֯�ܹ�'s Ӧ��������property 
     */
    public int getAttendanceDay()
    {
        return getInt("AttendanceDay");
    }
    public void setAttendanceDay(int item)
    {
        setInt("AttendanceDay", item);
    }
    /**
     * Object:��ֳ��֯�ܹ�'s ҹ�ಹ����׼property 
     */
    public java.math.BigDecimal getNightAllowance()
    {
        return getBigDecimal("NightAllowance");
    }
    public void setNightAllowance(java.math.BigDecimal item)
    {
        setBigDecimal("NightAllowance", item);
    }
    /**
     * Object:��ֳ��֯�ܹ�'s �Ӱಹ����Сʱ����׼property 
     */
    public java.math.BigDecimal getOverTimeH()
    {
        return getBigDecimal("OverTimeH");
    }
    public void setOverTimeH(java.math.BigDecimal item)
    {
        setBigDecimal("OverTimeH", item);
    }
    /**
     * Object:��ֳ��֯�ܹ�'s �Ӱಹ�����죩property 
     */
    public java.math.BigDecimal getOverTimeD()
    {
        return getBigDecimal("OverTimeD");
    }
    public void setOverTimeD(java.math.BigDecimal item)
    {
        setBigDecimal("OverTimeD", item);
    }
    /**
     * Object:��ֳ��֯�ܹ�'s ����״̬property 
     */
    public com.kingdee.eas.custom.wages.BasicStatus getBasestatus()
    {
        return com.kingdee.eas.custom.wages.BasicStatus.getEnum(getString("basestatus"));
    }
    public void setBasestatus(com.kingdee.eas.custom.wages.BasicStatus item)
    {
		if (item != null) {
        setString("basestatus", item.getValue());
		}
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("4B36CA1A");
    }
}