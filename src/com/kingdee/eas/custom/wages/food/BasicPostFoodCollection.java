package com.kingdee.eas.custom.wages.food;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class BasicPostFoodCollection extends AbstractObjectCollection 
{
    public BasicPostFoodCollection()
    {
        super(BasicPostFoodInfo.class);
    }
    public boolean add(BasicPostFoodInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(BasicPostFoodCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(BasicPostFoodInfo item)
    {
        return removeObject(item);
    }
    public BasicPostFoodInfo get(int index)
    {
        return(BasicPostFoodInfo)getObject(index);
    }
    public BasicPostFoodInfo get(Object key)
    {
        return(BasicPostFoodInfo)getObject(key);
    }
    public void set(int index, BasicPostFoodInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(BasicPostFoodInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(BasicPostFoodInfo item)
    {
        return super.indexOf(item);
    }
}