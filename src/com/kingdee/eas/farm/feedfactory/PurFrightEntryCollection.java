package com.kingdee.eas.farm.feedfactory;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class PurFrightEntryCollection extends AbstractObjectCollection 
{
    public PurFrightEntryCollection()
    {
        super(PurFrightEntryInfo.class);
    }
    public boolean add(PurFrightEntryInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(PurFrightEntryCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(PurFrightEntryInfo item)
    {
        return removeObject(item);
    }
    public PurFrightEntryInfo get(int index)
    {
        return(PurFrightEntryInfo)getObject(index);
    }
    public PurFrightEntryInfo get(Object key)
    {
        return(PurFrightEntryInfo)getObject(key);
    }
    public void set(int index, PurFrightEntryInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(PurFrightEntryInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(PurFrightEntryInfo item)
    {
        return super.indexOf(item);
    }
}