package com.kingdee.eas.farm.carnivorous.recyclebiz;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class CKSettleBillPreHouseEntryCollection extends AbstractObjectCollection 
{
    public CKSettleBillPreHouseEntryCollection()
    {
        super(CKSettleBillPreHouseEntryInfo.class);
    }
    public boolean add(CKSettleBillPreHouseEntryInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(CKSettleBillPreHouseEntryCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(CKSettleBillPreHouseEntryInfo item)
    {
        return removeObject(item);
    }
    public CKSettleBillPreHouseEntryInfo get(int index)
    {
        return(CKSettleBillPreHouseEntryInfo)getObject(index);
    }
    public CKSettleBillPreHouseEntryInfo get(Object key)
    {
        return(CKSettleBillPreHouseEntryInfo)getObject(key);
    }
    public void set(int index, CKSettleBillPreHouseEntryInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(CKSettleBillPreHouseEntryInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(CKSettleBillPreHouseEntryInfo item)
    {
        return super.indexOf(item);
    }
}