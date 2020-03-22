package com.kingdee.eas.farm.breed;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class HouseFieldCollection extends AbstractObjectCollection 
{
    public HouseFieldCollection()
    {
        super(HouseFieldInfo.class);
    }
    public boolean add(HouseFieldInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(HouseFieldCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(HouseFieldInfo item)
    {
        return removeObject(item);
    }
    public HouseFieldInfo get(int index)
    {
        return(HouseFieldInfo)getObject(index);
    }
    public HouseFieldInfo get(Object key)
    {
        return(HouseFieldInfo)getObject(key);
    }
    public void set(int index, HouseFieldInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(HouseFieldInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(HouseFieldInfo item)
    {
        return super.indexOf(item);
    }
}