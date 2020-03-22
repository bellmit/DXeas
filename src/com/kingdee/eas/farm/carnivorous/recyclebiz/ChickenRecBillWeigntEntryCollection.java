package com.kingdee.eas.farm.carnivorous.recyclebiz;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class ChickenRecBillWeigntEntryCollection extends AbstractObjectCollection 
{
    public ChickenRecBillWeigntEntryCollection()
    {
        super(ChickenRecBillWeigntEntryInfo.class);
    }
    public boolean add(ChickenRecBillWeigntEntryInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(ChickenRecBillWeigntEntryCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(ChickenRecBillWeigntEntryInfo item)
    {
        return removeObject(item);
    }
    public ChickenRecBillWeigntEntryInfo get(int index)
    {
        return(ChickenRecBillWeigntEntryInfo)getObject(index);
    }
    public ChickenRecBillWeigntEntryInfo get(Object key)
    {
        return(ChickenRecBillWeigntEntryInfo)getObject(key);
    }
    public void set(int index, ChickenRecBillWeigntEntryInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(ChickenRecBillWeigntEntryInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(ChickenRecBillWeigntEntryInfo item)
    {
        return super.indexOf(item);
    }
}