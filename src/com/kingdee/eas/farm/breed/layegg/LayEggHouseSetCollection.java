package com.kingdee.eas.farm.breed.layegg;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class LayEggHouseSetCollection extends AbstractObjectCollection 
{
    public LayEggHouseSetCollection()
    {
        super(LayEggHouseSetInfo.class);
    }
    public boolean add(LayEggHouseSetInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(LayEggHouseSetCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(LayEggHouseSetInfo item)
    {
        return removeObject(item);
    }
    public LayEggHouseSetInfo get(int index)
    {
        return(LayEggHouseSetInfo)getObject(index);
    }
    public LayEggHouseSetInfo get(Object key)
    {
        return(LayEggHouseSetInfo)getObject(key);
    }
    public void set(int index, LayEggHouseSetInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(LayEggHouseSetInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(LayEggHouseSetInfo item)
    {
        return super.indexOf(item);
    }
}