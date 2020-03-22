package com.kingdee.eas.farm.carnivorous.feedbiz;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class DrugReceiveBillCollection extends AbstractObjectCollection 
{
    public DrugReceiveBillCollection()
    {
        super(DrugReceiveBillInfo.class);
    }
    public boolean add(DrugReceiveBillInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(DrugReceiveBillCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(DrugReceiveBillInfo item)
    {
        return removeObject(item);
    }
    public DrugReceiveBillInfo get(int index)
    {
        return(DrugReceiveBillInfo)getObject(index);
    }
    public DrugReceiveBillInfo get(Object key)
    {
        return(DrugReceiveBillInfo)getObject(key);
    }
    public void set(int index, DrugReceiveBillInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(DrugReceiveBillInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(DrugReceiveBillInfo item)
    {
        return super.indexOf(item);
    }
}