package com.kingdee.eas.farm.feedfactory;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class PurFrightCollection extends AbstractObjectCollection 
{
    public PurFrightCollection()
    {
        super(PurFrightInfo.class);
    }
    public boolean add(PurFrightInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(PurFrightCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(PurFrightInfo item)
    {
        return removeObject(item);
    }
    public PurFrightInfo get(int index)
    {
        return(PurFrightInfo)getObject(index);
    }
    public PurFrightInfo get(Object key)
    {
        return(PurFrightInfo)getObject(key);
    }
    public void set(int index, PurFrightInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(PurFrightInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(PurFrightInfo item)
    {
        return super.indexOf(item);
    }
}