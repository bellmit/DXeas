package com.kingdee.eas.farm.carnivorous.feedbiz;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class DrugReceiveBillEntryCollection extends AbstractObjectCollection 
{
    public DrugReceiveBillEntryCollection()
    {
        super(DrugReceiveBillEntryInfo.class);
    }
    public boolean add(DrugReceiveBillEntryInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(DrugReceiveBillEntryCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(DrugReceiveBillEntryInfo item)
    {
        return removeObject(item);
    }
    public DrugReceiveBillEntryInfo get(int index)
    {
        return(DrugReceiveBillEntryInfo)getObject(index);
    }
    public DrugReceiveBillEntryInfo get(Object key)
    {
        return(DrugReceiveBillEntryInfo)getObject(key);
    }
    public void set(int index, DrugReceiveBillEntryInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(DrugReceiveBillEntryInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(DrugReceiveBillEntryInfo item)
    {
        return super.indexOf(item);
    }
}