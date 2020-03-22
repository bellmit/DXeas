package com.kingdee.eas.farm.carnivorous.basedata;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class FarmingCheckItemCollection extends AbstractObjectCollection 
{
    public FarmingCheckItemCollection()
    {
        super(FarmingCheckItemInfo.class);
    }
    public boolean add(FarmingCheckItemInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(FarmingCheckItemCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(FarmingCheckItemInfo item)
    {
        return removeObject(item);
    }
    public FarmingCheckItemInfo get(int index)
    {
        return(FarmingCheckItemInfo)getObject(index);
    }
    public FarmingCheckItemInfo get(Object key)
    {
        return(FarmingCheckItemInfo)getObject(key);
    }
    public void set(int index, FarmingCheckItemInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(FarmingCheckItemInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(FarmingCheckItemInfo item)
    {
        return super.indexOf(item);
    }
}