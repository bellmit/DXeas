package com.kingdee.eas.farm.breed;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class ResidueSetCollection extends AbstractObjectCollection 
{
    public ResidueSetCollection()
    {
        super(ResidueSetInfo.class);
    }
    public boolean add(ResidueSetInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(ResidueSetCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(ResidueSetInfo item)
    {
        return removeObject(item);
    }
    public ResidueSetInfo get(int index)
    {
        return(ResidueSetInfo)getObject(index);
    }
    public ResidueSetInfo get(Object key)
    {
        return(ResidueSetInfo)getObject(key);
    }
    public void set(int index, ResidueSetInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(ResidueSetInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(ResidueSetInfo item)
    {
        return super.indexOf(item);
    }
}