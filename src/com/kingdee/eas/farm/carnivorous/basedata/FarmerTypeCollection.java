package com.kingdee.eas.farm.carnivorous.basedata;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class FarmerTypeCollection extends AbstractObjectCollection 
{
    public FarmerTypeCollection()
    {
        super(FarmerTypeInfo.class);
    }
    public boolean add(FarmerTypeInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(FarmerTypeCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(FarmerTypeInfo item)
    {
        return removeObject(item);
    }
    public FarmerTypeInfo get(int index)
    {
        return(FarmerTypeInfo)getObject(index);
    }
    public FarmerTypeInfo get(Object key)
    {
        return(FarmerTypeInfo)getObject(key);
    }
    public void set(int index, FarmerTypeInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(FarmerTypeInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(FarmerTypeInfo item)
    {
        return super.indexOf(item);
    }
}