package com.kingdee.eas.farm.stocking.basedata;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class FarmTreeCollection extends AbstractObjectCollection 
{
    public FarmTreeCollection()
    {
        super(FarmTreeInfo.class);
    }
    public boolean add(FarmTreeInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(FarmTreeCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(FarmTreeInfo item)
    {
        return removeObject(item);
    }
    public FarmTreeInfo get(int index)
    {
        return(FarmTreeInfo)getObject(index);
    }
    public FarmTreeInfo get(Object key)
    {
        return(FarmTreeInfo)getObject(key);
    }
    public void set(int index, FarmTreeInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(FarmTreeInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(FarmTreeInfo item)
    {
        return super.indexOf(item);
    }
}