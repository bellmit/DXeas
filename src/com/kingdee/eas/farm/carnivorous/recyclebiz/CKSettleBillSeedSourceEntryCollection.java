package com.kingdee.eas.farm.carnivorous.recyclebiz;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class CKSettleBillSeedSourceEntryCollection extends AbstractObjectCollection 
{
    public CKSettleBillSeedSourceEntryCollection()
    {
        super(CKSettleBillSeedSourceEntryInfo.class);
    }
    public boolean add(CKSettleBillSeedSourceEntryInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(CKSettleBillSeedSourceEntryCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(CKSettleBillSeedSourceEntryInfo item)
    {
        return removeObject(item);
    }
    public CKSettleBillSeedSourceEntryInfo get(int index)
    {
        return(CKSettleBillSeedSourceEntryInfo)getObject(index);
    }
    public CKSettleBillSeedSourceEntryInfo get(Object key)
    {
        return(CKSettleBillSeedSourceEntryInfo)getObject(key);
    }
    public void set(int index, CKSettleBillSeedSourceEntryInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(CKSettleBillSeedSourceEntryInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(CKSettleBillSeedSourceEntryInfo item)
    {
        return super.indexOf(item);
    }
}