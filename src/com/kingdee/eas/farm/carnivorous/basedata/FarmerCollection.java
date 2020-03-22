package com.kingdee.eas.farm.carnivorous.basedata;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class FarmerCollection extends AbstractObjectCollection 
{
    public FarmerCollection()
    {
        super(FarmerInfo.class);
    }
    public boolean add(FarmerInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(FarmerCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(FarmerInfo item)
    {
        return removeObject(item);
    }
    public FarmerInfo get(int index)
    {
        return(FarmerInfo)getObject(index);
    }
    public FarmerInfo get(Object key)
    {
        return(FarmerInfo)getObject(key);
    }
    public void set(int index, FarmerInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(FarmerInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(FarmerInfo item)
    {
        return super.indexOf(item);
    }
}