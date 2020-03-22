package com.kingdee.eas.farm.stocking.basedata;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class HatchBabyCostObjectCollection extends AbstractObjectCollection 
{
    public HatchBabyCostObjectCollection()
    {
        super(HatchBabyCostObjectInfo.class);
    }
    public boolean add(HatchBabyCostObjectInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(HatchBabyCostObjectCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(HatchBabyCostObjectInfo item)
    {
        return removeObject(item);
    }
    public HatchBabyCostObjectInfo get(int index)
    {
        return(HatchBabyCostObjectInfo)getObject(index);
    }
    public HatchBabyCostObjectInfo get(Object key)
    {
        return(HatchBabyCostObjectInfo)getObject(key);
    }
    public void set(int index, HatchBabyCostObjectInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(HatchBabyCostObjectInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(HatchBabyCostObjectInfo item)
    {
        return super.indexOf(item);
    }
}