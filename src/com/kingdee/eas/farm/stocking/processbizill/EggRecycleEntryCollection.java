package com.kingdee.eas.farm.stocking.processbizill;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class EggRecycleEntryCollection extends AbstractObjectCollection 
{
    public EggRecycleEntryCollection()
    {
        super(EggRecycleEntryInfo.class);
    }
    public boolean add(EggRecycleEntryInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(EggRecycleEntryCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(EggRecycleEntryInfo item)
    {
        return removeObject(item);
    }
    public EggRecycleEntryInfo get(int index)
    {
        return(EggRecycleEntryInfo)getObject(index);
    }
    public EggRecycleEntryInfo get(Object key)
    {
        return(EggRecycleEntryInfo)getObject(key);
    }
    public void set(int index, EggRecycleEntryInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(EggRecycleEntryInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(EggRecycleEntryInfo item)
    {
        return super.indexOf(item);
    }
}