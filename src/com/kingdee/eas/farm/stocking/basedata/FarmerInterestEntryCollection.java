package com.kingdee.eas.farm.stocking.basedata;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class FarmerInterestEntryCollection extends AbstractObjectCollection 
{
    public FarmerInterestEntryCollection()
    {
        super(FarmerInterestEntryInfo.class);
    }
    public boolean add(FarmerInterestEntryInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(FarmerInterestEntryCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(FarmerInterestEntryInfo item)
    {
        return removeObject(item);
    }
    public FarmerInterestEntryInfo get(int index)
    {
        return(FarmerInterestEntryInfo)getObject(index);
    }
    public FarmerInterestEntryInfo get(Object key)
    {
        return(FarmerInterestEntryInfo)getObject(key);
    }
    public void set(int index, FarmerInterestEntryInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(FarmerInterestEntryInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(FarmerInterestEntryInfo item)
    {
        return super.indexOf(item);
    }
}