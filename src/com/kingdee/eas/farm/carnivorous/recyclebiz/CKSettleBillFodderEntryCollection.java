package com.kingdee.eas.farm.carnivorous.recyclebiz;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class CKSettleBillFodderEntryCollection extends AbstractObjectCollection 
{
    public CKSettleBillFodderEntryCollection()
    {
        super(CKSettleBillFodderEntryInfo.class);
    }
    public boolean add(CKSettleBillFodderEntryInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(CKSettleBillFodderEntryCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(CKSettleBillFodderEntryInfo item)
    {
        return removeObject(item);
    }
    public CKSettleBillFodderEntryInfo get(int index)
    {
        return(CKSettleBillFodderEntryInfo)getObject(index);
    }
    public CKSettleBillFodderEntryInfo get(Object key)
    {
        return(CKSettleBillFodderEntryInfo)getObject(key);
    }
    public void set(int index, CKSettleBillFodderEntryInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(CKSettleBillFodderEntryInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(CKSettleBillFodderEntryInfo item)
    {
        return super.indexOf(item);
    }
}