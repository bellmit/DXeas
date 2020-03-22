package com.kingdee.eas.farm.foodtrac;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class FarmCodeTreeCollection extends AbstractObjectCollection 
{
    public FarmCodeTreeCollection()
    {
        super(FarmCodeTreeInfo.class);
    }
    public boolean add(FarmCodeTreeInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(FarmCodeTreeCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(FarmCodeTreeInfo item)
    {
        return removeObject(item);
    }
    public FarmCodeTreeInfo get(int index)
    {
        return(FarmCodeTreeInfo)getObject(index);
    }
    public FarmCodeTreeInfo get(Object key)
    {
        return(FarmCodeTreeInfo)getObject(key);
    }
    public void set(int index, FarmCodeTreeInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(FarmCodeTreeInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(FarmCodeTreeInfo item)
    {
        return super.indexOf(item);
    }
}