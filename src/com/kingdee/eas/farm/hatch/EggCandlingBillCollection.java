package com.kingdee.eas.farm.hatch;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class EggCandlingBillCollection extends AbstractObjectCollection 
{
    public EggCandlingBillCollection()
    {
        super(EggCandlingBillInfo.class);
    }
    public boolean add(EggCandlingBillInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(EggCandlingBillCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(EggCandlingBillInfo item)
    {
        return removeObject(item);
    }
    public EggCandlingBillInfo get(int index)
    {
        return(EggCandlingBillInfo)getObject(index);
    }
    public EggCandlingBillInfo get(Object key)
    {
        return(EggCandlingBillInfo)getObject(key);
    }
    public void set(int index, EggCandlingBillInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(EggCandlingBillInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(EggCandlingBillInfo item)
    {
        return super.indexOf(item);
    }
}