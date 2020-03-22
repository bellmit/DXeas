package com.kingdee.eas.farm.carnivorous.recyclebiz;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class CKSettleBillSlaughterEntryCollection extends AbstractObjectCollection 
{
    public CKSettleBillSlaughterEntryCollection()
    {
        super(CKSettleBillSlaughterEntryInfo.class);
    }
    public boolean add(CKSettleBillSlaughterEntryInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(CKSettleBillSlaughterEntryCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(CKSettleBillSlaughterEntryInfo item)
    {
        return removeObject(item);
    }
    public CKSettleBillSlaughterEntryInfo get(int index)
    {
        return(CKSettleBillSlaughterEntryInfo)getObject(index);
    }
    public CKSettleBillSlaughterEntryInfo get(Object key)
    {
        return(CKSettleBillSlaughterEntryInfo)getObject(key);
    }
    public void set(int index, CKSettleBillSlaughterEntryInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(CKSettleBillSlaughterEntryInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(CKSettleBillSlaughterEntryInfo item)
    {
        return super.indexOf(item);
    }
}