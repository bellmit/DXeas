package com.kingdee.eas.farm.stocking.hatch;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class EggSettleBillEntryCollection extends AbstractObjectCollection 
{
    public EggSettleBillEntryCollection()
    {
        super(EggSettleBillEntryInfo.class);
    }
    public boolean add(EggSettleBillEntryInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(EggSettleBillEntryCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(EggSettleBillEntryInfo item)
    {
        return removeObject(item);
    }
    public EggSettleBillEntryInfo get(int index)
    {
        return(EggSettleBillEntryInfo)getObject(index);
    }
    public EggSettleBillEntryInfo get(Object key)
    {
        return(EggSettleBillEntryInfo)getObject(key);
    }
    public void set(int index, EggSettleBillEntryInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(EggSettleBillEntryInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(EggSettleBillEntryInfo item)
    {
        return super.indexOf(item);
    }
}