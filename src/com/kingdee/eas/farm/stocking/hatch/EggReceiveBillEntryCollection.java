package com.kingdee.eas.farm.stocking.hatch;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class EggReceiveBillEntryCollection extends AbstractObjectCollection 
{
    public EggReceiveBillEntryCollection()
    {
        super(EggReceiveBillEntryInfo.class);
    }
    public boolean add(EggReceiveBillEntryInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(EggReceiveBillEntryCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(EggReceiveBillEntryInfo item)
    {
        return removeObject(item);
    }
    public EggReceiveBillEntryInfo get(int index)
    {
        return(EggReceiveBillEntryInfo)getObject(index);
    }
    public EggReceiveBillEntryInfo get(Object key)
    {
        return(EggReceiveBillEntryInfo)getObject(key);
    }
    public void set(int index, EggReceiveBillEntryInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(EggReceiveBillEntryInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(EggReceiveBillEntryInfo item)
    {
        return super.indexOf(item);
    }
}