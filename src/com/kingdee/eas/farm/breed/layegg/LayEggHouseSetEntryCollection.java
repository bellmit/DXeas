package com.kingdee.eas.farm.breed.layegg;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class LayEggHouseSetEntryCollection extends AbstractObjectCollection 
{
    public LayEggHouseSetEntryCollection()
    {
        super(LayEggHouseSetEntryInfo.class);
    }
    public boolean add(LayEggHouseSetEntryInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(LayEggHouseSetEntryCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(LayEggHouseSetEntryInfo item)
    {
        return removeObject(item);
    }
    public LayEggHouseSetEntryInfo get(int index)
    {
        return(LayEggHouseSetEntryInfo)getObject(index);
    }
    public LayEggHouseSetEntryInfo get(Object key)
    {
        return(LayEggHouseSetEntryInfo)getObject(key);
    }
    public void set(int index, LayEggHouseSetEntryInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(LayEggHouseSetEntryInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(LayEggHouseSetEntryInfo item)
    {
        return super.indexOf(item);
    }
}