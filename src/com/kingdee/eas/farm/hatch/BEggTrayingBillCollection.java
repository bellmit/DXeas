package com.kingdee.eas.farm.hatch;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class BEggTrayingBillCollection extends AbstractObjectCollection 
{
    public BEggTrayingBillCollection()
    {
        super(BEggTrayingBillInfo.class);
    }
    public boolean add(BEggTrayingBillInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(BEggTrayingBillCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(BEggTrayingBillInfo item)
    {
        return removeObject(item);
    }
    public BEggTrayingBillInfo get(int index)
    {
        return(BEggTrayingBillInfo)getObject(index);
    }
    public BEggTrayingBillInfo get(Object key)
    {
        return(BEggTrayingBillInfo)getObject(key);
    }
    public void set(int index, BEggTrayingBillInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(BEggTrayingBillInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(BEggTrayingBillInfo item)
    {
        return super.indexOf(item);
    }
}