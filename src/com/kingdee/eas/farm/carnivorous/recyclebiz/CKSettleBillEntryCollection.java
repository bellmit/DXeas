package com.kingdee.eas.farm.carnivorous.recyclebiz;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class CKSettleBillEntryCollection extends AbstractObjectCollection 
{
    public CKSettleBillEntryCollection()
    {
        super(CKSettleBillEntryInfo.class);
    }
    public boolean add(CKSettleBillEntryInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(CKSettleBillEntryCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(CKSettleBillEntryInfo item)
    {
        return removeObject(item);
    }
    public CKSettleBillEntryInfo get(int index)
    {
        return(CKSettleBillEntryInfo)getObject(index);
    }
    public CKSettleBillEntryInfo get(Object key)
    {
        return(CKSettleBillEntryInfo)getObject(key);
    }
    public void set(int index, CKSettleBillEntryInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(CKSettleBillEntryInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(CKSettleBillEntryInfo item)
    {
        return super.indexOf(item);
    }
}