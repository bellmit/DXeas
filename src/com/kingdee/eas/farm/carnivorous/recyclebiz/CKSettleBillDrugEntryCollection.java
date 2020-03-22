package com.kingdee.eas.farm.carnivorous.recyclebiz;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class CKSettleBillDrugEntryCollection extends AbstractObjectCollection 
{
    public CKSettleBillDrugEntryCollection()
    {
        super(CKSettleBillDrugEntryInfo.class);
    }
    public boolean add(CKSettleBillDrugEntryInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(CKSettleBillDrugEntryCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(CKSettleBillDrugEntryInfo item)
    {
        return removeObject(item);
    }
    public CKSettleBillDrugEntryInfo get(int index)
    {
        return(CKSettleBillDrugEntryInfo)getObject(index);
    }
    public CKSettleBillDrugEntryInfo get(Object key)
    {
        return(CKSettleBillDrugEntryInfo)getObject(key);
    }
    public void set(int index, CKSettleBillDrugEntryInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(CKSettleBillDrugEntryInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(CKSettleBillDrugEntryInfo item)
    {
        return super.indexOf(item);
    }
}