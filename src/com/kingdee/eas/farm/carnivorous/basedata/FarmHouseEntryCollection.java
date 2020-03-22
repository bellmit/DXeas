package com.kingdee.eas.farm.carnivorous.basedata;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class FarmHouseEntryCollection extends AbstractObjectCollection 
{
    public FarmHouseEntryCollection()
    {
        super(FarmHouseEntryInfo.class);
    }
    public boolean add(FarmHouseEntryInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(FarmHouseEntryCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(FarmHouseEntryInfo item)
    {
        return removeObject(item);
    }
    public FarmHouseEntryInfo get(int index)
    {
        return(FarmHouseEntryInfo)getObject(index);
    }
    public FarmHouseEntryInfo get(Object key)
    {
        return(FarmHouseEntryInfo)getObject(key);
    }
    public void set(int index, FarmHouseEntryInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(FarmHouseEntryInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(FarmHouseEntryInfo item)
    {
        return super.indexOf(item);
    }
}