package com.kingdee.eas.farm.carnivorous.recyclebiz;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class CKSettleBillQCEntryCollection extends AbstractObjectCollection 
{
    public CKSettleBillQCEntryCollection()
    {
        super(CKSettleBillQCEntryInfo.class);
    }
    public boolean add(CKSettleBillQCEntryInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(CKSettleBillQCEntryCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(CKSettleBillQCEntryInfo item)
    {
        return removeObject(item);
    }
    public CKSettleBillQCEntryInfo get(int index)
    {
        return(CKSettleBillQCEntryInfo)getObject(index);
    }
    public CKSettleBillQCEntryInfo get(Object key)
    {
        return(CKSettleBillQCEntryInfo)getObject(key);
    }
    public void set(int index, CKSettleBillQCEntryInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(CKSettleBillQCEntryInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(CKSettleBillQCEntryInfo item)
    {
        return super.indexOf(item);
    }
}