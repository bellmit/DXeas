package com.kingdee.eas.farm.breed;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class HenhouseEntryCollection extends AbstractObjectCollection 
{
    public HenhouseEntryCollection()
    {
        super(HenhouseEntryInfo.class);
    }
    public boolean add(HenhouseEntryInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(HenhouseEntryCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(HenhouseEntryInfo item)
    {
        return removeObject(item);
    }
    public HenhouseEntryInfo get(int index)
    {
        return(HenhouseEntryInfo)getObject(index);
    }
    public HenhouseEntryInfo get(Object key)
    {
        return(HenhouseEntryInfo)getObject(key);
    }
    public void set(int index, HenhouseEntryInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(HenhouseEntryInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(HenhouseEntryInfo item)
    {
        return super.indexOf(item);
    }
}