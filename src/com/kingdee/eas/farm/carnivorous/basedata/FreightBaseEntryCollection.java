package com.kingdee.eas.farm.carnivorous.basedata;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class FreightBaseEntryCollection extends AbstractObjectCollection 
{
    public FreightBaseEntryCollection()
    {
        super(FreightBaseEntryInfo.class);
    }
    public boolean add(FreightBaseEntryInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(FreightBaseEntryCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(FreightBaseEntryInfo item)
    {
        return removeObject(item);
    }
    public FreightBaseEntryInfo get(int index)
    {
        return(FreightBaseEntryInfo)getObject(index);
    }
    public FreightBaseEntryInfo get(Object key)
    {
        return(FreightBaseEntryInfo)getObject(key);
    }
    public void set(int index, FreightBaseEntryInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(FreightBaseEntryInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(FreightBaseEntryInfo item)
    {
        return super.indexOf(item);
    }
}