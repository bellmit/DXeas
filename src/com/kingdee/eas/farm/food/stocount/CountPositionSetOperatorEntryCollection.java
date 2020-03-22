package com.kingdee.eas.farm.food.stocount;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class CountPositionSetOperatorEntryCollection extends AbstractObjectCollection 
{
    public CountPositionSetOperatorEntryCollection()
    {
        super(CountPositionSetOperatorEntryInfo.class);
    }
    public boolean add(CountPositionSetOperatorEntryInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(CountPositionSetOperatorEntryCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(CountPositionSetOperatorEntryInfo item)
    {
        return removeObject(item);
    }
    public CountPositionSetOperatorEntryInfo get(int index)
    {
        return(CountPositionSetOperatorEntryInfo)getObject(index);
    }
    public CountPositionSetOperatorEntryInfo get(Object key)
    {
        return(CountPositionSetOperatorEntryInfo)getObject(key);
    }
    public void set(int index, CountPositionSetOperatorEntryInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(CountPositionSetOperatorEntryInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(CountPositionSetOperatorEntryInfo item)
    {
        return super.indexOf(item);
    }
}