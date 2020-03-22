package com.kingdee.eas.farm.hatch;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class HatchBaseDataCollection extends AbstractObjectCollection 
{
    public HatchBaseDataCollection()
    {
        super(HatchBaseDataInfo.class);
    }
    public boolean add(HatchBaseDataInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(HatchBaseDataCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(HatchBaseDataInfo item)
    {
        return removeObject(item);
    }
    public HatchBaseDataInfo get(int index)
    {
        return(HatchBaseDataInfo)getObject(index);
    }
    public HatchBaseDataInfo get(Object key)
    {
        return(HatchBaseDataInfo)getObject(key);
    }
    public void set(int index, HatchBaseDataInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(HatchBaseDataInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(HatchBaseDataInfo item)
    {
        return super.indexOf(item);
    }
}