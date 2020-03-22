package com.kingdee.eas.farm.carnivorous.basebiz;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class FarmerQualicationApplCollection extends AbstractObjectCollection 
{
    public FarmerQualicationApplCollection()
    {
        super(FarmerQualicationApplInfo.class);
    }
    public boolean add(FarmerQualicationApplInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(FarmerQualicationApplCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(FarmerQualicationApplInfo item)
    {
        return removeObject(item);
    }
    public FarmerQualicationApplInfo get(int index)
    {
        return(FarmerQualicationApplInfo)getObject(index);
    }
    public FarmerQualicationApplInfo get(Object key)
    {
        return(FarmerQualicationApplInfo)getObject(key);
    }
    public void set(int index, FarmerQualicationApplInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(FarmerQualicationApplInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(FarmerQualicationApplInfo item)
    {
        return super.indexOf(item);
    }
}