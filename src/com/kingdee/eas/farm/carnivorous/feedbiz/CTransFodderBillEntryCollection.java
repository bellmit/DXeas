package com.kingdee.eas.farm.carnivorous.feedbiz;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class CTransFodderBillEntryCollection extends AbstractObjectCollection 
{
    public CTransFodderBillEntryCollection()
    {
        super(CTransFodderBillEntryInfo.class);
    }
    public boolean add(CTransFodderBillEntryInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(CTransFodderBillEntryCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(CTransFodderBillEntryInfo item)
    {
        return removeObject(item);
    }
    public CTransFodderBillEntryInfo get(int index)
    {
        return(CTransFodderBillEntryInfo)getObject(index);
    }
    public CTransFodderBillEntryInfo get(Object key)
    {
        return(CTransFodderBillEntryInfo)getObject(key);
    }
    public void set(int index, CTransFodderBillEntryInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(CTransFodderBillEntryInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(CTransFodderBillEntryInfo item)
    {
        return super.indexOf(item);
    }
}