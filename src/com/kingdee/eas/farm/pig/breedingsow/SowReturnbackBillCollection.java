package com.kingdee.eas.farm.pig.breedingsow;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class SowReturnbackBillCollection extends AbstractObjectCollection 
{
    public SowReturnbackBillCollection()
    {
        super(SowReturnbackBillInfo.class);
    }
    public boolean add(SowReturnbackBillInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(SowReturnbackBillCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(SowReturnbackBillInfo item)
    {
        return removeObject(item);
    }
    public SowReturnbackBillInfo get(int index)
    {
        return(SowReturnbackBillInfo)getObject(index);
    }
    public SowReturnbackBillInfo get(Object key)
    {
        return(SowReturnbackBillInfo)getObject(key);
    }
    public void set(int index, SowReturnbackBillInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(SowReturnbackBillInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(SowReturnbackBillInfo item)
    {
        return super.indexOf(item);
    }
}