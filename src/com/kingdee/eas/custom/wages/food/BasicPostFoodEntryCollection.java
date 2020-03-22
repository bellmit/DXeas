package com.kingdee.eas.custom.wages.food;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class BasicPostFoodEntryCollection extends AbstractObjectCollection 
{
    public BasicPostFoodEntryCollection()
    {
        super(BasicPostFoodEntryInfo.class);
    }
    public boolean add(BasicPostFoodEntryInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(BasicPostFoodEntryCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(BasicPostFoodEntryInfo item)
    {
        return removeObject(item);
    }
    public BasicPostFoodEntryInfo get(int index)
    {
        return(BasicPostFoodEntryInfo)getObject(index);
    }
    public BasicPostFoodEntryInfo get(Object key)
    {
        return(BasicPostFoodEntryInfo)getObject(key);
    }
    public void set(int index, BasicPostFoodEntryInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(BasicPostFoodEntryInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(BasicPostFoodEntryInfo item)
    {
        return super.indexOf(item);
    }
}