package com.kingdee.eas.farm.carnivorous.basebiz;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class MarginUnlockBillEntryCollection extends AbstractObjectCollection 
{
    public MarginUnlockBillEntryCollection()
    {
        super(MarginUnlockBillEntryInfo.class);
    }
    public boolean add(MarginUnlockBillEntryInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(MarginUnlockBillEntryCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(MarginUnlockBillEntryInfo item)
    {
        return removeObject(item);
    }
    public MarginUnlockBillEntryInfo get(int index)
    {
        return(MarginUnlockBillEntryInfo)getObject(index);
    }
    public MarginUnlockBillEntryInfo get(Object key)
    {
        return(MarginUnlockBillEntryInfo)getObject(key);
    }
    public void set(int index, MarginUnlockBillEntryInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(MarginUnlockBillEntryInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(MarginUnlockBillEntryInfo item)
    {
        return super.indexOf(item);
    }
}