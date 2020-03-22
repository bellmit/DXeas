package com.kingdee.eas.farm.stocking.processbizill;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class TranInEntryCollection extends AbstractObjectCollection 
{
    public TranInEntryCollection()
    {
        super(TranInEntryInfo.class);
    }
    public boolean add(TranInEntryInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(TranInEntryCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(TranInEntryInfo item)
    {
        return removeObject(item);
    }
    public TranInEntryInfo get(int index)
    {
        return(TranInEntryInfo)getObject(index);
    }
    public TranInEntryInfo get(Object key)
    {
        return(TranInEntryInfo)getObject(key);
    }
    public void set(int index, TranInEntryInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(TranInEntryInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(TranInEntryInfo item)
    {
        return super.indexOf(item);
    }
}