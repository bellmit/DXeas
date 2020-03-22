package com.kingdee.eas.farm.stocking.hatch;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class EggSettleBillCollection extends AbstractObjectCollection 
{
    public EggSettleBillCollection()
    {
        super(EggSettleBillInfo.class);
    }
    public boolean add(EggSettleBillInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(EggSettleBillCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(EggSettleBillInfo item)
    {
        return removeObject(item);
    }
    public EggSettleBillInfo get(int index)
    {
        return(EggSettleBillInfo)getObject(index);
    }
    public EggSettleBillInfo get(Object key)
    {
        return(EggSettleBillInfo)getObject(key);
    }
    public void set(int index, EggSettleBillInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(EggSettleBillInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(EggSettleBillInfo item)
    {
        return super.indexOf(item);
    }
}