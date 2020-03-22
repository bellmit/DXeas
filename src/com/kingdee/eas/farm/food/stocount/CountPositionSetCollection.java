package com.kingdee.eas.farm.food.stocount;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class CountPositionSetCollection extends AbstractObjectCollection 
{
    public CountPositionSetCollection()
    {
        super(CountPositionSetInfo.class);
    }
    public boolean add(CountPositionSetInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(CountPositionSetCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(CountPositionSetInfo item)
    {
        return removeObject(item);
    }
    public CountPositionSetInfo get(int index)
    {
        return(CountPositionSetInfo)getObject(index);
    }
    public CountPositionSetInfo get(Object key)
    {
        return(CountPositionSetInfo)getObject(key);
    }
    public void set(int index, CountPositionSetInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(CountPositionSetInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(CountPositionSetInfo item)
    {
        return super.indexOf(item);
    }
}