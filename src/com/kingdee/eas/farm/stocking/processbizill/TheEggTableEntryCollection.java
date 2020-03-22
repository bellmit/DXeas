package com.kingdee.eas.farm.stocking.processbizill;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class TheEggTableEntryCollection extends AbstractObjectCollection 
{
    public TheEggTableEntryCollection()
    {
        super(TheEggTableEntryInfo.class);
    }
    public boolean add(TheEggTableEntryInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(TheEggTableEntryCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(TheEggTableEntryInfo item)
    {
        return removeObject(item);
    }
    public TheEggTableEntryInfo get(int index)
    {
        return(TheEggTableEntryInfo)getObject(index);
    }
    public TheEggTableEntryInfo get(Object key)
    {
        return(TheEggTableEntryInfo)getObject(key);
    }
    public void set(int index, TheEggTableEntryInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(TheEggTableEntryInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(TheEggTableEntryInfo item)
    {
        return super.indexOf(item);
    }
}