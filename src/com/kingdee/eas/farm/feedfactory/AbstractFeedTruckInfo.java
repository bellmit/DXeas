package com.kingdee.eas.farm.feedfactory;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractFeedTruckInfo extends com.kingdee.eas.framework.DataBaseInfo implements Serializable 
{
    public AbstractFeedTruckInfo()
    {
        this("id");
    }
    protected AbstractFeedTruckInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: ���ϳ� 's ��� property 
     */
    public com.kingdee.eas.farm.feedfactory.FeedTruckTreeInfo getTreeid()
    {
        return (com.kingdee.eas.farm.feedfactory.FeedTruckTreeInfo)get("treeid");
    }
    public void setTreeid(com.kingdee.eas.farm.feedfactory.FeedTruckTreeInfo item)
    {
        put("treeid", item);
    }
    /**
     * Object:���ϳ�'s ���ƺ�property 
     */
    public String getLicensePlate()
    {
        return getString("licensePlate");
    }
    public void setLicensePlate(String item)
    {
        setString("licensePlate", item);
    }
    /**
     * Object:���ϳ�'s Ƥ��(kg)property 
     */
    public java.math.BigDecimal getTare()
    {
        return getBigDecimal("tare");
    }
    public void setTare(java.math.BigDecimal item)
    {
        setBigDecimal("tare", item);
    }
    /**
     * Object: ���ϳ� 's ˾�� property 
     */
    public com.kingdee.eas.basedata.person.PersonInfo getDriver()
    {
        return (com.kingdee.eas.basedata.person.PersonInfo)get("driver");
    }
    public void setDriver(com.kingdee.eas.basedata.person.PersonInfo item)
    {
        put("driver", item);
    }
    /**
     * Object:���ϳ�'s ˾���绰property 
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
     * Object:���ϳ�'s ״̬property 
     */
    public com.kingdee.eas.farm.feedfactory.TruckState getStatu()
    {
        return com.kingdee.eas.farm.feedfactory.TruckState.getEnum(getString("statu"));
    }
    public void setStatu(com.kingdee.eas.farm.feedfactory.TruckState item)
    {
		if (item != null) {
        setString("statu", item.getValue());
		}
    }
    /**
     * Object:���ϳ�'s װ��ʱ�䣨���ӣ�property 
     */
    public int getLoadTimes()
    {
        return getInt("loadTimes");
    }
    public void setLoadTimes(int item)
    {
        setInt("loadTimes", item);
    }
    /**
     * Object:���ϳ�'s ж��ʱ�䣨���ӣ�property 
     */
    public int getUnloadTimes()
    {
        return getInt("unloadTimes");
    }
    public void setUnloadTimes(int item)
    {
        setInt("unloadTimes", item);
    }
    /**
     * Object:���ϳ�'s ��������property 
     */
    public com.kingdee.eas.farm.feedfactory.TruckType getTruckType()
    {
        return com.kingdee.eas.farm.feedfactory.TruckType.getEnum(getString("truckType"));
    }
    public void setTruckType(com.kingdee.eas.farm.feedfactory.TruckType item)
    {
		if (item != null) {
        setString("truckType", item.getValue());
		}
    }
    /**
     * Object:���ϳ�'s �Ϲ���property 
     */
    public int getPotCount()
    {
        return getInt("potCount");
    }
    public void setPotCount(int item)
    {
        setInt("potCount", item);
    }
    /**
     * Object:���ϳ�'s �������أ�kg��property 
     */
    public java.math.BigDecimal getPotWeight()
    {
        return getBigDecimal("potWeight");
    }
    public void setPotWeight(java.math.BigDecimal item)
    {
        setBigDecimal("potWeight", item);
    }
    /**
     * Object:���ϳ�'s ��������property 
     */
    public java.util.Date getBuyDate()
    {
        return getDate("buyDate");
    }
    public void setBuyDate(java.util.Date item)
    {
        setDate("buyDate", item);
    }
    /**
     * Object:���ϳ�'s ��Ƶ����property 
     */
    public java.math.BigDecimal getUplimit()
    {
        return getBigDecimal("uplimit");
    }
    public void setUplimit(java.math.BigDecimal item)
    {
        setBigDecimal("uplimit", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("6C0C89BF");
    }
}