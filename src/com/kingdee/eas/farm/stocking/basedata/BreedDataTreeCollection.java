package com.kingdee.eas.farm.stocking.basedata;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class BreedDataTreeCollection extends AbstractObjectCollection 
{
    public BreedDataTreeCollection()
    {
        super(BreedDataTreeInfo.class);
    }
    public boolean add(BreedDataTreeInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(BreedDataTreeCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(BreedDataTreeInfo item)
    {
        return removeObject(item);
    }
    public BreedDataTreeInfo get(int index)
    {
        return(BreedDataTreeInfo)getObject(index);
    }
    public BreedDataTreeInfo get(Object key)
    {
        return(BreedDataTreeInfo)getObject(key);
    }
    public void set(int index, BreedDataTreeInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(BreedDataTreeInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(BreedDataTreeInfo item)
    {
        return super.indexOf(item);
    }
}