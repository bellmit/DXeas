package com.kingdee.eas.farm.carnivorous.basedata;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class VetCollection extends AbstractObjectCollection 
{
    public VetCollection()
    {
        super(VetInfo.class);
    }
    public boolean add(VetInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(VetCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(VetInfo item)
    {
        return removeObject(item);
    }
    public VetInfo get(int index)
    {
        return(VetInfo)getObject(index);
    }
    public VetInfo get(Object key)
    {
        return(VetInfo)getObject(key);
    }
    public void set(int index, VetInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(VetInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(VetInfo item)
    {
        return super.indexOf(item);
    }
}