package com.kingdee.eas.farm.pig;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class PigFarmTreeCollection extends AbstractObjectCollection 
{
    public PigFarmTreeCollection()
    {
        super(PigFarmTreeInfo.class);
    }
    public boolean add(PigFarmTreeInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(PigFarmTreeCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(PigFarmTreeInfo item)
    {
        return removeObject(item);
    }
    public PigFarmTreeInfo get(int index)
    {
        return(PigFarmTreeInfo)getObject(index);
    }
    public PigFarmTreeInfo get(Object key)
    {
        return(PigFarmTreeInfo)getObject(key);
    }
    public void set(int index, PigFarmTreeInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(PigFarmTreeInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(PigFarmTreeInfo item)
    {
        return super.indexOf(item);
    }
}