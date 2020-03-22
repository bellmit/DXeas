package com.kingdee.eas.custom.wages.farm;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class FarmRatingEntryCollection extends AbstractObjectCollection 
{
    public FarmRatingEntryCollection()
    {
        super(FarmRatingEntryInfo.class);
    }
    public boolean add(FarmRatingEntryInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(FarmRatingEntryCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(FarmRatingEntryInfo item)
    {
        return removeObject(item);
    }
    public FarmRatingEntryInfo get(int index)
    {
        return(FarmRatingEntryInfo)getObject(index);
    }
    public FarmRatingEntryInfo get(Object key)
    {
        return(FarmRatingEntryInfo)getObject(key);
    }
    public void set(int index, FarmRatingEntryInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(FarmRatingEntryInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(FarmRatingEntryInfo item)
    {
        return super.indexOf(item);
    }
}