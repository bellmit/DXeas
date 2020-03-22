package com.kingdee.eas.farm.carnivorous.recyclebiz;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class ChickenRecBillEntryCollection extends AbstractObjectCollection 
{
    public ChickenRecBillEntryCollection()
    {
        super(ChickenRecBillEntryInfo.class);
    }
    public boolean add(ChickenRecBillEntryInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(ChickenRecBillEntryCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(ChickenRecBillEntryInfo item)
    {
        return removeObject(item);
    }
    public ChickenRecBillEntryInfo get(int index)
    {
        return(ChickenRecBillEntryInfo)getObject(index);
    }
    public ChickenRecBillEntryInfo get(Object key)
    {
        return(ChickenRecBillEntryInfo)getObject(key);
    }
    public void set(int index, ChickenRecBillEntryInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(ChickenRecBillEntryInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(ChickenRecBillEntryInfo item)
    {
        return super.indexOf(item);
    }
}