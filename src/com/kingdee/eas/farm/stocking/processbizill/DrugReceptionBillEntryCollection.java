package com.kingdee.eas.farm.stocking.processbizill;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class DrugReceptionBillEntryCollection extends AbstractObjectCollection 
{
    public DrugReceptionBillEntryCollection()
    {
        super(DrugReceptionBillEntryInfo.class);
    }
    public boolean add(DrugReceptionBillEntryInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(DrugReceptionBillEntryCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(DrugReceptionBillEntryInfo item)
    {
        return removeObject(item);
    }
    public DrugReceptionBillEntryInfo get(int index)
    {
        return(DrugReceptionBillEntryInfo)getObject(index);
    }
    public DrugReceptionBillEntryInfo get(Object key)
    {
        return(DrugReceptionBillEntryInfo)getObject(key);
    }
    public void set(int index, DrugReceptionBillEntryInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(DrugReceptionBillEntryInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(DrugReceptionBillEntryInfo item)
    {
        return super.indexOf(item);
    }
}