package com.kingdee.eas.farm.carnivorous.basedata;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class FarmerFarmEntryCollection extends AbstractObjectCollection 
{
    public FarmerFarmEntryCollection()
    {
        super(FarmerFarmEntryInfo.class);
    }
    public boolean add(FarmerFarmEntryInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(FarmerFarmEntryCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(FarmerFarmEntryInfo item)
    {
        return removeObject(item);
    }
    public FarmerFarmEntryInfo get(int index)
    {
        return(FarmerFarmEntryInfo)getObject(index);
    }
    public FarmerFarmEntryInfo get(Object key)
    {
        return(FarmerFarmEntryInfo)getObject(key);
    }
    public void set(int index, FarmerFarmEntryInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(FarmerFarmEntryInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(FarmerFarmEntryInfo item)
    {
        return super.indexOf(item);
    }
}