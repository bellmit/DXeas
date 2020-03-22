package com.kingdee.eas.farm.stocking.basedata;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class BreedDataCollection extends AbstractObjectCollection 
{
    public BreedDataCollection()
    {
        super(BreedDataInfo.class);
    }
    public boolean add(BreedDataInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(BreedDataCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(BreedDataInfo item)
    {
        return removeObject(item);
    }
    public BreedDataInfo get(int index)
    {
        return(BreedDataInfo)getObject(index);
    }
    public BreedDataInfo get(Object key)
    {
        return(BreedDataInfo)getObject(key);
    }
    public void set(int index, BreedDataInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(BreedDataInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(BreedDataInfo item)
    {
        return super.indexOf(item);
    }
}