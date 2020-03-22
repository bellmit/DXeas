package com.kingdee.eas.farm.carnivorous.recyclebiz;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class CKSettleBillSeedEntryCollection extends AbstractObjectCollection 
{
    public CKSettleBillSeedEntryCollection()
    {
        super(CKSettleBillSeedEntryInfo.class);
    }
    public boolean add(CKSettleBillSeedEntryInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(CKSettleBillSeedEntryCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(CKSettleBillSeedEntryInfo item)
    {
        return removeObject(item);
    }
    public CKSettleBillSeedEntryInfo get(int index)
    {
        return(CKSettleBillSeedEntryInfo)getObject(index);
    }
    public CKSettleBillSeedEntryInfo get(Object key)
    {
        return(CKSettleBillSeedEntryInfo)getObject(key);
    }
    public void set(int index, CKSettleBillSeedEntryInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(CKSettleBillSeedEntryInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(CKSettleBillSeedEntryInfo item)
    {
        return super.indexOf(item);
    }
}