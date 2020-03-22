package com.kingdee.eas.farm.carnivorous.recyclebiz;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class ChickenRecBillCollection extends AbstractObjectCollection 
{
    public ChickenRecBillCollection()
    {
        super(ChickenRecBillInfo.class);
    }
    public boolean add(ChickenRecBillInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(ChickenRecBillCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(ChickenRecBillInfo item)
    {
        return removeObject(item);
    }
    public ChickenRecBillInfo get(int index)
    {
        return(ChickenRecBillInfo)getObject(index);
    }
    public ChickenRecBillInfo get(Object key)
    {
        return(ChickenRecBillInfo)getObject(key);
    }
    public void set(int index, ChickenRecBillInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(ChickenRecBillInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(ChickenRecBillInfo item)
    {
        return super.indexOf(item);
    }
}