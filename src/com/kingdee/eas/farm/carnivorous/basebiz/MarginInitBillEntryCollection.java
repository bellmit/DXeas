package com.kingdee.eas.farm.carnivorous.basebiz;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class MarginInitBillEntryCollection extends AbstractObjectCollection 
{
    public MarginInitBillEntryCollection()
    {
        super(MarginInitBillEntryInfo.class);
    }
    public boolean add(MarginInitBillEntryInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(MarginInitBillEntryCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(MarginInitBillEntryInfo item)
    {
        return removeObject(item);
    }
    public MarginInitBillEntryInfo get(int index)
    {
        return(MarginInitBillEntryInfo)getObject(index);
    }
    public MarginInitBillEntryInfo get(Object key)
    {
        return(MarginInitBillEntryInfo)getObject(key);
    }
    public void set(int index, MarginInitBillEntryInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(MarginInitBillEntryInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(MarginInitBillEntryInfo item)
    {
        return super.indexOf(item);
    }
}