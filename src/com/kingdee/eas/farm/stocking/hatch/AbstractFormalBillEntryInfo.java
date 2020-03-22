package com.kingdee.eas.farm.stocking.hatch;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractFormalBillEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractFormalBillEntryInfo()
    {
        this("id");
    }
    protected AbstractFormalBillEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: ��¼ 's ����ͷ property 
     */
    public com.kingdee.eas.farm.stocking.hatch.FormalBillInfo getParent()
    {
        return (com.kingdee.eas.farm.stocking.hatch.FormalBillInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.farm.stocking.hatch.FormalBillInfo item)
    {
        put("parent", item);
    }
    /**
     * Object: ��¼ 's ��ֳ�� property 
     */
    public com.kingdee.eas.farm.stocking.basedata.FarmInfo getFarm()
    {
        return (com.kingdee.eas.farm.stocking.basedata.FarmInfo)get("farm");
    }
    public void setFarm(com.kingdee.eas.farm.stocking.basedata.FarmInfo item)
    {
        put("farm", item);
    }
    /**
     * Object: ��¼ 's ��ֳ���� property 
     */
    public com.kingdee.eas.farm.stocking.basedata.StockingBatchInfo getStockingBatch()
    {
        return (com.kingdee.eas.farm.stocking.basedata.StockingBatchInfo)get("stockingBatch");
    }
    public void setStockingBatch(com.kingdee.eas.farm.stocking.basedata.StockingBatchInfo item)
    {
        put("stockingBatch", item);
    }
    /**
     * Object: ��¼ 's ���� property 
     */
    public com.kingdee.eas.farm.stocking.basedata.FarmHouseEntryInfo getHouse()
    {
        return (com.kingdee.eas.farm.stocking.basedata.FarmHouseEntryInfo)get("house");
    }
    public void setHouse(com.kingdee.eas.farm.stocking.basedata.FarmHouseEntryInfo item)
    {
        put("house", item);
    }
    /**
     * Object:��¼'s ����property 
     */
    public String getNowWeekAge()
    {
        return getString("nowWeekAge");
    }
    public void setNowWeekAge(String item)
    {
        setString("nowWeekAge", item);
    }
    /**
     * Object:��¼'s ��ǰ����property 
     */
    public int getNowDayAge()
    {
        return getInt("nowDayAge");
    }
    public void setNowDayAge(int item)
    {
        setInt("nowDayAge", item);
    }
    /**
     * Object:��¼'s ����ת������property 
     */
    public java.util.Date getApplyDate()
    {
        return getDate("applyDate");
    }
    public void setApplyDate(java.util.Date item)
    {
        setDate("applyDate", item);
    }
    /**
     * Object:��¼'s ����ת������property 
     */
    public String getApplyWeekAge()
    {
        return getString("applyWeekAge");
    }
    public void setApplyWeekAge(String item)
    {
        setString("applyWeekAge", item);
    }
    /**
     * Object:��¼'s ����ת������property 
     */
    public int getApplyDayAge()
    {
        return getInt("applyDayAge");
    }
    public void setApplyDayAge(int item)
    {
        setInt("applyDayAge", item);
    }
    /**
     * Object: ��¼ 's ��ֳ�� property 
     */
    public com.kingdee.eas.farm.stocking.basedata.FarmersInfo getFarmer()
    {
        return (com.kingdee.eas.farm.stocking.basedata.FarmersInfo)get("farmer");
    }
    public void setFarmer(com.kingdee.eas.farm.stocking.basedata.FarmersInfo item)
    {
        put("farmer", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("52873052");
    }
}