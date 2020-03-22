package com.kingdee.eas.custom.salediscount;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class DiscountSetEntryCollection extends AbstractObjectCollection 
{
    public DiscountSetEntryCollection()
    {
        super(DiscountSetEntryInfo.class);
    }
    public boolean add(DiscountSetEntryInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(DiscountSetEntryCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(DiscountSetEntryInfo item)
    {
        return removeObject(item);
    }
    public DiscountSetEntryInfo get(int index)
    {
        return(DiscountSetEntryInfo)getObject(index);
    }
    public DiscountSetEntryInfo get(Object key)
    {
        return(DiscountSetEntryInfo)getObject(key);
    }
    public void set(int index, DiscountSetEntryInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(DiscountSetEntryInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(DiscountSetEntryInfo item)
    {
        return super.indexOf(item);
    }
}