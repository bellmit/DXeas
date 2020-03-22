package com.kingdee.eas.farm.hatch;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class HatchingBoxTreeCollection extends AbstractObjectCollection 
{
    public HatchingBoxTreeCollection()
    {
        super(HatchingBoxTreeInfo.class);
    }
    public boolean add(HatchingBoxTreeInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(HatchingBoxTreeCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(HatchingBoxTreeInfo item)
    {
        return removeObject(item);
    }
    public HatchingBoxTreeInfo get(int index)
    {
        return(HatchingBoxTreeInfo)getObject(index);
    }
    public HatchingBoxTreeInfo get(Object key)
    {
        return(HatchingBoxTreeInfo)getObject(key);
    }
    public void set(int index, HatchingBoxTreeInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(HatchingBoxTreeInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(HatchingBoxTreeInfo item)
    {
        return super.indexOf(item);
    }
}