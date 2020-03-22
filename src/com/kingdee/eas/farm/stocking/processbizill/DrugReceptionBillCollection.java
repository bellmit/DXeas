package com.kingdee.eas.farm.stocking.processbizill;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class DrugReceptionBillCollection extends AbstractObjectCollection 
{
    public DrugReceptionBillCollection()
    {
        super(DrugReceptionBillInfo.class);
    }
    public boolean add(DrugReceptionBillInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(DrugReceptionBillCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(DrugReceptionBillInfo item)
    {
        return removeObject(item);
    }
    public DrugReceptionBillInfo get(int index)
    {
        return(DrugReceptionBillInfo)getObject(index);
    }
    public DrugReceptionBillInfo get(Object key)
    {
        return(DrugReceptionBillInfo)getObject(key);
    }
    public void set(int index, DrugReceptionBillInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(DrugReceptionBillInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(DrugReceptionBillInfo item)
    {
        return super.indexOf(item);
    }
}