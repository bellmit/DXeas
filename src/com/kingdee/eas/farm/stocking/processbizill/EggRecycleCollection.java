package com.kingdee.eas.farm.stocking.processbizill;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class EggRecycleCollection extends AbstractObjectCollection 
{
    public EggRecycleCollection()
    {
        super(EggRecycleInfo.class);
    }
    public boolean add(EggRecycleInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(EggRecycleCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(EggRecycleInfo item)
    {
        return removeObject(item);
    }
    public EggRecycleInfo get(int index)
    {
        return(EggRecycleInfo)getObject(index);
    }
    public EggRecycleInfo get(Object key)
    {
        return(EggRecycleInfo)getObject(key);
    }
    public void set(int index, EggRecycleInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(EggRecycleInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(EggRecycleInfo item)
    {
        return super.indexOf(item);
    }
}