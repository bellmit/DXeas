package com.kingdee.eas.farm.carnivorous.feedbiz;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class DrugApplyBillCollection extends AbstractObjectCollection 
{
    public DrugApplyBillCollection()
    {
        super(DrugApplyBillInfo.class);
    }
    public boolean add(DrugApplyBillInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(DrugApplyBillCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(DrugApplyBillInfo item)
    {
        return removeObject(item);
    }
    public DrugApplyBillInfo get(int index)
    {
        return(DrugApplyBillInfo)getObject(index);
    }
    public DrugApplyBillInfo get(Object key)
    {
        return(DrugApplyBillInfo)getObject(key);
    }
    public void set(int index, DrugApplyBillInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(DrugApplyBillInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(DrugApplyBillInfo item)
    {
        return super.indexOf(item);
    }
}