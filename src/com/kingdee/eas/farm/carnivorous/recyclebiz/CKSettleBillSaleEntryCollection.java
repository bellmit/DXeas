package com.kingdee.eas.farm.carnivorous.recyclebiz;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class CKSettleBillSaleEntryCollection extends AbstractObjectCollection 
{
    public CKSettleBillSaleEntryCollection()
    {
        super(CKSettleBillSaleEntryInfo.class);
    }
    public boolean add(CKSettleBillSaleEntryInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(CKSettleBillSaleEntryCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(CKSettleBillSaleEntryInfo item)
    {
        return removeObject(item);
    }
    public CKSettleBillSaleEntryInfo get(int index)
    {
        return(CKSettleBillSaleEntryInfo)getObject(index);
    }
    public CKSettleBillSaleEntryInfo get(Object key)
    {
        return(CKSettleBillSaleEntryInfo)getObject(key);
    }
    public void set(int index, CKSettleBillSaleEntryInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(CKSettleBillSaleEntryInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(CKSettleBillSaleEntryInfo item)
    {
        return super.indexOf(item);
    }
}