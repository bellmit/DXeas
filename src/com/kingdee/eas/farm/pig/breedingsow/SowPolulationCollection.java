package com.kingdee.eas.farm.pig.breedingsow;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class SowPolulationCollection extends AbstractObjectCollection 
{
    public SowPolulationCollection()
    {
        super(SowPolulationInfo.class);
    }
    public boolean add(SowPolulationInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(SowPolulationCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(SowPolulationInfo item)
    {
        return removeObject(item);
    }
    public SowPolulationInfo get(int index)
    {
        return(SowPolulationInfo)getObject(index);
    }
    public SowPolulationInfo get(Object key)
    {
        return(SowPolulationInfo)getObject(key);
    }
    public void set(int index, SowPolulationInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(SowPolulationInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(SowPolulationInfo item)
    {
        return super.indexOf(item);
    }
}