package com.kingdee.eas.farm.carnivorous.basedata;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class YieldDataBaseEntryCollection extends AbstractObjectCollection 
{
    public YieldDataBaseEntryCollection()
    {
        super(YieldDataBaseEntryInfo.class);
    }
    public boolean add(YieldDataBaseEntryInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(YieldDataBaseEntryCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(YieldDataBaseEntryInfo item)
    {
        return removeObject(item);
    }
    public YieldDataBaseEntryInfo get(int index)
    {
        return(YieldDataBaseEntryInfo)getObject(index);
    }
    public YieldDataBaseEntryInfo get(Object key)
    {
        return(YieldDataBaseEntryInfo)getObject(key);
    }
    public void set(int index, YieldDataBaseEntryInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(YieldDataBaseEntryInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(YieldDataBaseEntryInfo item)
    {
        return super.indexOf(item);
    }
}