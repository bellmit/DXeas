package com.kingdee.eas.custom.salediscount;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class DiscountGridLogEntryCollection extends AbstractObjectCollection 
{
    public DiscountGridLogEntryCollection()
    {
        super(DiscountGridLogEntryInfo.class);
    }
    public boolean add(DiscountGridLogEntryInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(DiscountGridLogEntryCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(DiscountGridLogEntryInfo item)
    {
        return removeObject(item);
    }
    public DiscountGridLogEntryInfo get(int index)
    {
        return(DiscountGridLogEntryInfo)getObject(index);
    }
    public DiscountGridLogEntryInfo get(Object key)
    {
        return(DiscountGridLogEntryInfo)getObject(key);
    }
    public void set(int index, DiscountGridLogEntryInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(DiscountGridLogEntryInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(DiscountGridLogEntryInfo item)
    {
        return super.indexOf(item);
    }
}