package com.kingdee.eas.farm.hatch;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class HatchBillEntryCollection extends AbstractObjectCollection 
{
    public HatchBillEntryCollection()
    {
        super(HatchBillEntryInfo.class);
    }
    public boolean add(HatchBillEntryInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(HatchBillEntryCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(HatchBillEntryInfo item)
    {
        return removeObject(item);
    }
    public HatchBillEntryInfo get(int index)
    {
        return(HatchBillEntryInfo)getObject(index);
    }
    public HatchBillEntryInfo get(Object key)
    {
        return(HatchBillEntryInfo)getObject(key);
    }
    public void set(int index, HatchBillEntryInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(HatchBillEntryInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(HatchBillEntryInfo item)
    {
        return super.indexOf(item);
    }
}