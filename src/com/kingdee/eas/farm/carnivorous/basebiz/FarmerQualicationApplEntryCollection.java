package com.kingdee.eas.farm.carnivorous.basebiz;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class FarmerQualicationApplEntryCollection extends AbstractObjectCollection 
{
    public FarmerQualicationApplEntryCollection()
    {
        super(FarmerQualicationApplEntryInfo.class);
    }
    public boolean add(FarmerQualicationApplEntryInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(FarmerQualicationApplEntryCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(FarmerQualicationApplEntryInfo item)
    {
        return removeObject(item);
    }
    public FarmerQualicationApplEntryInfo get(int index)
    {
        return(FarmerQualicationApplEntryInfo)getObject(index);
    }
    public FarmerQualicationApplEntryInfo get(Object key)
    {
        return(FarmerQualicationApplEntryInfo)getObject(key);
    }
    public void set(int index, FarmerQualicationApplEntryInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(FarmerQualicationApplEntryInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(FarmerQualicationApplEntryInfo item)
    {
        return super.indexOf(item);
    }
}