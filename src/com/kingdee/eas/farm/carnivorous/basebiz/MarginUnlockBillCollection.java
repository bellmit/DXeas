package com.kingdee.eas.farm.carnivorous.basebiz;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class MarginUnlockBillCollection extends AbstractObjectCollection 
{
    public MarginUnlockBillCollection()
    {
        super(MarginUnlockBillInfo.class);
    }
    public boolean add(MarginUnlockBillInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(MarginUnlockBillCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(MarginUnlockBillInfo item)
    {
        return removeObject(item);
    }
    public MarginUnlockBillInfo get(int index)
    {
        return(MarginUnlockBillInfo)getObject(index);
    }
    public MarginUnlockBillInfo get(Object key)
    {
        return(MarginUnlockBillInfo)getObject(key);
    }
    public void set(int index, MarginUnlockBillInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(MarginUnlockBillInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(MarginUnlockBillInfo item)
    {
        return super.indexOf(item);
    }
}