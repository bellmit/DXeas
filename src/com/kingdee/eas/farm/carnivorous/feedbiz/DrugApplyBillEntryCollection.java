package com.kingdee.eas.farm.carnivorous.feedbiz;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class DrugApplyBillEntryCollection extends AbstractObjectCollection 
{
    public DrugApplyBillEntryCollection()
    {
        super(DrugApplyBillEntryInfo.class);
    }
    public boolean add(DrugApplyBillEntryInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(DrugApplyBillEntryCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(DrugApplyBillEntryInfo item)
    {
        return removeObject(item);
    }
    public DrugApplyBillEntryInfo get(int index)
    {
        return(DrugApplyBillEntryInfo)getObject(index);
    }
    public DrugApplyBillEntryInfo get(Object key)
    {
        return(DrugApplyBillEntryInfo)getObject(key);
    }
    public void set(int index, DrugApplyBillEntryInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(DrugApplyBillEntryInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(DrugApplyBillEntryInfo item)
    {
        return super.indexOf(item);
    }
}