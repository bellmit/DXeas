package com.kingdee.eas.farm.carnivorous.recyclebiz;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class ChickenRecBillButcherEntryCollection extends AbstractObjectCollection 
{
    public ChickenRecBillButcherEntryCollection()
    {
        super(ChickenRecBillButcherEntryInfo.class);
    }
    public boolean add(ChickenRecBillButcherEntryInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(ChickenRecBillButcherEntryCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(ChickenRecBillButcherEntryInfo item)
    {
        return removeObject(item);
    }
    public ChickenRecBillButcherEntryInfo get(int index)
    {
        return(ChickenRecBillButcherEntryInfo)getObject(index);
    }
    public ChickenRecBillButcherEntryInfo get(Object key)
    {
        return(ChickenRecBillButcherEntryInfo)getObject(key);
    }
    public void set(int index, ChickenRecBillButcherEntryInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(ChickenRecBillButcherEntryInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(ChickenRecBillButcherEntryInfo item)
    {
        return super.indexOf(item);
    }
}