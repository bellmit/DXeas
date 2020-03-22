package com.kingdee.eas.farm.carnivorous.basedata;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class FarmerTreeCollection extends AbstractObjectCollection 
{
    public FarmerTreeCollection()
    {
        super(FarmerTreeInfo.class);
    }
    public boolean add(FarmerTreeInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(FarmerTreeCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(FarmerTreeInfo item)
    {
        return removeObject(item);
    }
    public FarmerTreeInfo get(int index)
    {
        return(FarmerTreeInfo)getObject(index);
    }
    public FarmerTreeInfo get(Object key)
    {
        return(FarmerTreeInfo)getObject(key);
    }
    public void set(int index, FarmerTreeInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(FarmerTreeInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(FarmerTreeInfo item)
    {
        return super.indexOf(item);
    }
}