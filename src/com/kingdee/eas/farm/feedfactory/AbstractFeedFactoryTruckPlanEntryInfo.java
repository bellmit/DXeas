package com.kingdee.eas.farm.feedfactory;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractFeedFactoryTruckPlanEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractFeedFactoryTruckPlanEntryInfo()
    {
        this("id");
    }
    protected AbstractFeedFactoryTruckPlanEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: �ɳ���ϸ��¼ 's ����ͷ property 
     */
    public com.kingdee.eas.farm.feedfactory.FeedFactoryTruckPlanInfo getParent()
    {
        return (com.kingdee.eas.farm.feedfactory.FeedFactoryTruckPlanInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.farm.feedfactory.FeedFactoryTruckPlanInfo item)
    {
        put("parent", item);
    }
    /**
     * Object: �ɳ���ϸ��¼ 's ��ֳ�� property 
     */
    public com.kingdee.eas.basedata.org.StorageOrgUnitInfo getFarm()
    {
        return (com.kingdee.eas.basedata.org.StorageOrgUnitInfo)get("farm");
    }
    public void setFarm(com.kingdee.eas.basedata.org.StorageOrgUnitInfo item)
    {
        put("farm", item);
    }
    /**
     * Object: �ɳ���ϸ��¼ 's ���� property 
     */
    public com.kingdee.eas.basedata.scm.im.inv.WarehouseInfo getTower()
    {
        return (com.kingdee.eas.basedata.scm.im.inv.WarehouseInfo)get("tower");
    }
    public void setTower(com.kingdee.eas.basedata.scm.im.inv.WarehouseInfo item)
    {
        put("tower", item);
    }
    /**
     * Object: �ɳ���ϸ��¼ 's ���� property 
     */
    public com.kingdee.eas.farm.feedfactory.FeedTruckInfo getTruck()
    {
        return (com.kingdee.eas.farm.feedfactory.FeedTruckInfo)get("truck");
    }
    public void setTruck(com.kingdee.eas.farm.feedfactory.FeedTruckInfo item)
    {
        put("truck", item);
    }
    /**
     * Object:�ɳ���ϸ��¼'s ˾��property 
     */
    public String getDrive()
    {
        return getString("drive");
    }
    public void setDrive(String item)
    {
        setString("drive", item);
    }
    /**
     * Object:�ɳ���ϸ��¼'s ˾���绰property 
     */
    public String getTel()
    {
        return getString("tel");
    }
    public void setTel(String item)
    {
        setString("tel", item);
    }
    /**
     * Object:�ɳ���ϸ��¼'s �ƻ�װ��ʱ��property 
     */
    public java.util.Date getBeginLoadTime()
    {
        return getDate("beginLoadTime");
    }
    public void setBeginLoadTime(java.util.Date item)
    {
        setDate("beginLoadTime", item);
    }
    /**
     * Object:�ɳ���ϸ��¼'s �ƻ�����ʱ��property 
     */
    public java.util.Date getLeaveFFTime()
    {
        return getDate("leaveFFTime");
    }
    public void setLeaveFFTime(java.util.Date item)
    {
        setDate("leaveFFTime", item);
    }
    /**
     * Object:�ɳ���ϸ��¼'s �ƻ��ʹ�ʱ��property 
     */
    public java.util.Date getTruckArriveTime()
    {
        return getDate("truckArriveTime");
    }
    public void setTruckArriveTime(java.util.Date item)
    {
        setDate("truckArriveTime", item);
    }
    /**
     * Object:�ɳ���ϸ��¼'s ж�����ʱ��property 
     */
    public java.util.Date getLeaveFarmTime()
    {
        return getDate("leaveFarmTime");
    }
    public void setLeaveFarmTime(java.util.Date item)
    {
        setDate("leaveFarmTime", item);
    }
    /**
     * Object:�ɳ���ϸ��¼'s �ƻ�����ʱ��property 
     */
    public java.util.Date getBackToFFTime()
    {
        return getDate("backToFFTime");
    }
    public void setBackToFFTime(java.util.Date item)
    {
        setDate("backToFFTime", item);
    }
    /**
     * Object:�ɳ���ϸ��¼'s ����property 
     */
    public int getPlanSeq()
    {
        return getInt("planSeq");
    }
    public void setPlanSeq(int item)
    {
        setInt("planSeq", item);
    }
    /**
     * Object:�ɳ���ϸ��¼'s ����property 
     */
    public int getTruckSeq()
    {
        return getInt("truckSeq");
    }
    public void setTruckSeq(int item)
    {
        setInt("truckSeq", item);
    }
    /**
     * Object:�ɳ���ϸ��¼'s �緹property 
     */
    public boolean isHaveLunch()
    {
        return getBoolean("haveLunch");
    }
    public void setHaveLunch(boolean item)
    {
        setBoolean("haveLunch", item);
    }
    /**
     * Object:�ɳ���ϸ��¼'s �緹�ص�property 
     */
    public String getLunchPlace()
    {
        return getString("lunchPlace");
    }
    public void setLunchPlace(String item)
    {
        setString("lunchPlace", item);
    }
    /**
     * Object:�ɳ���ϸ��¼'s װ�Ͽ�property 
     */
    public String getFodderPort()
    {
        return getString("fodderPort");
    }
    public void setFodderPort(String item)
    {
        setString("fodderPort", item);
    }
    /**
     * Object:�ɳ���ϸ��¼'s Ҫ�ϱ�עproperty 
     */
    public String getFarmDesc()
    {
        return getString("farmDesc");
    }
    public void setFarmDesc(String item)
    {
        setString("farmDesc", item);
    }
    /**
     * Object:�ɳ���ϸ��¼'s ����property 
     */
    public String getMaterialName()
    {
        return getString("materialName");
    }
    public void setMaterialName(String item)
    {
        setString("materialName", item);
    }
    /**
     * Object:�ɳ���ϸ��¼'s ����IDproperty 
     */
    public String getMaterialID()
    {
        return getString("materialID");
    }
    public void setMaterialID(String item)
    {
        setString("materialID", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("18476E34");
    }
}