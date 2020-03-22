package com.kingdee.eas.farm.hatch;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class HatchBabyBillCollection extends AbstractObjectCollection 
{
    public HatchBabyBillCollection()
    {
        super(HatchBabyBillInfo.class);
    }
    public boolean add(HatchBabyBillInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(HatchBabyBillCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(HatchBabyBillInfo item)
    {
        return removeObject(item);
    }
    public HatchBabyBillInfo get(int index)
    {
        return(HatchBabyBillInfo)getObject(index);
    }
    public HatchBabyBillInfo get(Object key)
    {
        return(HatchBabyBillInfo)getObject(key);
    }
    public void set(int index, HatchBabyBillInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(HatchBabyBillInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(HatchBabyBillInfo item)
    {
        return super.indexOf(item);
    }
}