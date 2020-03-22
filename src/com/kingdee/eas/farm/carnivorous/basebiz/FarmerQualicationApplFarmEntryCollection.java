package com.kingdee.eas.farm.carnivorous.basebiz;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class FarmerQualicationApplFarmEntryCollection extends AbstractObjectCollection 
{
    public FarmerQualicationApplFarmEntryCollection()
    {
        super(FarmerQualicationApplFarmEntryInfo.class);
    }
    public boolean add(FarmerQualicationApplFarmEntryInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(FarmerQualicationApplFarmEntryCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(FarmerQualicationApplFarmEntryInfo item)
    {
        return removeObject(item);
    }
    public FarmerQualicationApplFarmEntryInfo get(int index)
    {
        return(FarmerQualicationApplFarmEntryInfo)getObject(index);
    }
    public FarmerQualicationApplFarmEntryInfo get(Object key)
    {
        return(FarmerQualicationApplFarmEntryInfo)getObject(key);
    }
    public void set(int index, FarmerQualicationApplFarmEntryInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(FarmerQualicationApplFarmEntryInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(FarmerQualicationApplFarmEntryInfo item)
    {
        return super.indexOf(item);
    }
}