package com.kingdee.eas.farm.food;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class FoodBaseDataCollection extends AbstractObjectCollection 
{
    public FoodBaseDataCollection()
    {
        super(FoodBaseDataInfo.class);
    }
    public boolean add(FoodBaseDataInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(FoodBaseDataCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(FoodBaseDataInfo item)
    {
        return removeObject(item);
    }
    public FoodBaseDataInfo get(int index)
    {
        return(FoodBaseDataInfo)getObject(index);
    }
    public FoodBaseDataInfo get(Object key)
    {
        return(FoodBaseDataInfo)getObject(key);
    }
    public void set(int index, FoodBaseDataInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(FoodBaseDataInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(FoodBaseDataInfo item)
    {
        return super.indexOf(item);
    }
}