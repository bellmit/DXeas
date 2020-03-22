package com.kingdee.eas.farm.food;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractDeliveryCarInfo extends com.kingdee.eas.framework.DataBaseInfo implements Serializable 
{
    public AbstractDeliveryCarInfo()
    {
        this("id");
    }
    protected AbstractDeliveryCarInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: �ͻ����� 's ��� property 
     */
    public com.kingdee.eas.farm.food.DeliveryCarTreeInfo getTreeid()
    {
        return (com.kingdee.eas.farm.food.DeliveryCarTreeInfo)get("treeid");
    }
    public void setTreeid(com.kingdee.eas.farm.food.DeliveryCarTreeInfo item)
    {
        put("treeid", item);
    }
    /**
     * Object:�ͻ�����'s ˾������property 
     */
    public String getDriverName()
    {
        return getString("driverName");
    }
    public void setDriverName(String item)
    {
        setString("driverName", item);
    }
    /**
     * Object:�ͻ�����'s ˾���绰property 
     */
    public String getDriverTel()
    {
        return getString("driverTel");
    }
    public void setDriverTel(String item)
    {
        setString("driverTel", item);
    }
    /**
     * Object:�ͻ�����'s �������property 
     */
    public String getCarType()
    {
        return getString("carType");
    }
    public void setCarType(String item)
    {
        setString("carType", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("0762EC56");
    }
}