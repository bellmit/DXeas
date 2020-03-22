package com.kingdee.eas.farm.carnivorous.recyclebiz;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class CKSettleBillOtherEntryCollection extends AbstractObjectCollection 
{
    public CKSettleBillOtherEntryCollection()
    {
        super(CKSettleBillOtherEntryInfo.class);
    }
    public boolean add(CKSettleBillOtherEntryInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(CKSettleBillOtherEntryCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(CKSettleBillOtherEntryInfo item)
    {
        return removeObject(item);
    }
    public CKSettleBillOtherEntryInfo get(int index)
    {
        return(CKSettleBillOtherEntryInfo)getObject(index);
    }
    public CKSettleBillOtherEntryInfo get(Object key)
    {
        return(CKSettleBillOtherEntryInfo)getObject(key);
    }
    public void set(int index, CKSettleBillOtherEntryInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(CKSettleBillOtherEntryInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(CKSettleBillOtherEntryInfo item)
    {
        return super.indexOf(item);
    }
}