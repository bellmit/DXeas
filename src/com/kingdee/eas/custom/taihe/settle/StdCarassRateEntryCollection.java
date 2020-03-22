package com.kingdee.eas.custom.taihe.settle;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class StdCarassRateEntryCollection extends AbstractObjectCollection 
{
    public StdCarassRateEntryCollection()
    {
        super(StdCarassRateEntryInfo.class);
    }
    public boolean add(StdCarassRateEntryInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(StdCarassRateEntryCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(StdCarassRateEntryInfo item)
    {
        return removeObject(item);
    }
    public StdCarassRateEntryInfo get(int index)
    {
        return(StdCarassRateEntryInfo)getObject(index);
    }
    public StdCarassRateEntryInfo get(Object key)
    {
        return(StdCarassRateEntryInfo)getObject(key);
    }
    public void set(int index, StdCarassRateEntryInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(StdCarassRateEntryInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(StdCarassRateEntryInfo item)
    {
        return super.indexOf(item);
    }
}