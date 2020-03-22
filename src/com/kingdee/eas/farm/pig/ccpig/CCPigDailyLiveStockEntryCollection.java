package com.kingdee.eas.farm.pig.ccpig;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class CCPigDailyLiveStockEntryCollection extends AbstractObjectCollection 
{
    public CCPigDailyLiveStockEntryCollection()
    {
        super(CCPigDailyLiveStockEntryInfo.class);
    }
    public boolean add(CCPigDailyLiveStockEntryInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(CCPigDailyLiveStockEntryCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(CCPigDailyLiveStockEntryInfo item)
    {
        return removeObject(item);
    }
    public CCPigDailyLiveStockEntryInfo get(int index)
    {
        return(CCPigDailyLiveStockEntryInfo)getObject(index);
    }
    public CCPigDailyLiveStockEntryInfo get(Object key)
    {
        return(CCPigDailyLiveStockEntryInfo)getObject(key);
    }
    public void set(int index, CCPigDailyLiveStockEntryInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(CCPigDailyLiveStockEntryInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(CCPigDailyLiveStockEntryInfo item)
    {
        return super.indexOf(item);
    }
}