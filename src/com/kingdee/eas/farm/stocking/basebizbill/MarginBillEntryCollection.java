package com.kingdee.eas.farm.stocking.basebizbill;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class MarginBillEntryCollection extends AbstractObjectCollection 
{
    public MarginBillEntryCollection()
    {
        super(MarginBillEntryInfo.class);
    }
    public boolean add(MarginBillEntryInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(MarginBillEntryCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(MarginBillEntryInfo item)
    {
        return removeObject(item);
    }
    public MarginBillEntryInfo get(int index)
    {
        return(MarginBillEntryInfo)getObject(index);
    }
    public MarginBillEntryInfo get(Object key)
    {
        return(MarginBillEntryInfo)getObject(key);
    }
    public void set(int index, MarginBillEntryInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(MarginBillEntryInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(MarginBillEntryInfo item)
    {
        return super.indexOf(item);
    }
}