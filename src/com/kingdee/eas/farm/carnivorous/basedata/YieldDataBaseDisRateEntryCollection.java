package com.kingdee.eas.farm.carnivorous.basedata;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class YieldDataBaseDisRateEntryCollection extends AbstractObjectCollection 
{
    public YieldDataBaseDisRateEntryCollection()
    {
        super(YieldDataBaseDisRateEntryInfo.class);
    }
    public boolean add(YieldDataBaseDisRateEntryInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(YieldDataBaseDisRateEntryCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(YieldDataBaseDisRateEntryInfo item)
    {
        return removeObject(item);
    }
    public YieldDataBaseDisRateEntryInfo get(int index)
    {
        return(YieldDataBaseDisRateEntryInfo)getObject(index);
    }
    public YieldDataBaseDisRateEntryInfo get(Object key)
    {
        return(YieldDataBaseDisRateEntryInfo)getObject(key);
    }
    public void set(int index, YieldDataBaseDisRateEntryInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(YieldDataBaseDisRateEntryInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(YieldDataBaseDisRateEntryInfo item)
    {
        return super.indexOf(item);
    }
}