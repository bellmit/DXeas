package com.kingdee.eas.farm.stocking.processbizill;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class FodderReceiveBillEntryCollection extends AbstractObjectCollection 
{
    public FodderReceiveBillEntryCollection()
    {
        super(FodderReceiveBillEntryInfo.class);
    }
    public boolean add(FodderReceiveBillEntryInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(FodderReceiveBillEntryCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(FodderReceiveBillEntryInfo item)
    {
        return removeObject(item);
    }
    public FodderReceiveBillEntryInfo get(int index)
    {
        return(FodderReceiveBillEntryInfo)getObject(index);
    }
    public FodderReceiveBillEntryInfo get(Object key)
    {
        return(FodderReceiveBillEntryInfo)getObject(key);
    }
    public void set(int index, FodderReceiveBillEntryInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(FodderReceiveBillEntryInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(FodderReceiveBillEntryInfo item)
    {
        return super.indexOf(item);
    }
}