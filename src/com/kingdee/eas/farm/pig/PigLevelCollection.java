package com.kingdee.eas.farm.pig;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class PigLevelCollection extends AbstractObjectCollection 
{
    public PigLevelCollection()
    {
        super(PigLevelInfo.class);
    }
    public boolean add(PigLevelInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(PigLevelCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(PigLevelInfo item)
    {
        return removeObject(item);
    }
    public PigLevelInfo get(int index)
    {
        return(PigLevelInfo)getObject(index);
    }
    public PigLevelInfo get(Object key)
    {
        return(PigLevelInfo)getObject(key);
    }
    public void set(int index, PigLevelInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(PigLevelInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(PigLevelInfo item)
    {
        return super.indexOf(item);
    }
}