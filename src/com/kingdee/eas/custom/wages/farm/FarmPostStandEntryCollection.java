package com.kingdee.eas.custom.wages.farm;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class FarmPostStandEntryCollection extends AbstractObjectCollection 
{
    public FarmPostStandEntryCollection()
    {
        super(FarmPostStandEntryInfo.class);
    }
    public boolean add(FarmPostStandEntryInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(FarmPostStandEntryCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(FarmPostStandEntryInfo item)
    {
        return removeObject(item);
    }
    public FarmPostStandEntryInfo get(int index)
    {
        return(FarmPostStandEntryInfo)getObject(index);
    }
    public FarmPostStandEntryInfo get(Object key)
    {
        return(FarmPostStandEntryInfo)getObject(key);
    }
    public void set(int index, FarmPostStandEntryInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(FarmPostStandEntryInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(FarmPostStandEntryInfo item)
    {
        return super.indexOf(item);
    }
}