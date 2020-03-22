package com.kingdee.eas.farm.stocking.hatch;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class EggReceiveBillCollection extends AbstractObjectCollection 
{
    public EggReceiveBillCollection()
    {
        super(EggReceiveBillInfo.class);
    }
    public boolean add(EggReceiveBillInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(EggReceiveBillCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(EggReceiveBillInfo item)
    {
        return removeObject(item);
    }
    public EggReceiveBillInfo get(int index)
    {
        return(EggReceiveBillInfo)getObject(index);
    }
    public EggReceiveBillInfo get(Object key)
    {
        return(EggReceiveBillInfo)getObject(key);
    }
    public void set(int index, EggReceiveBillInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(EggReceiveBillInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(EggReceiveBillInfo item)
    {
        return super.indexOf(item);
    }
}