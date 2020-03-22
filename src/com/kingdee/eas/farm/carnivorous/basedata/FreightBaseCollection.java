package com.kingdee.eas.farm.carnivorous.basedata;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class FreightBaseCollection extends AbstractObjectCollection 
{
    public FreightBaseCollection()
    {
        super(FreightBaseInfo.class);
    }
    public boolean add(FreightBaseInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(FreightBaseCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(FreightBaseInfo item)
    {
        return removeObject(item);
    }
    public FreightBaseInfo get(int index)
    {
        return(FreightBaseInfo)getObject(index);
    }
    public FreightBaseInfo get(Object key)
    {
        return(FreightBaseInfo)getObject(key);
    }
    public void set(int index, FreightBaseInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(FreightBaseInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(FreightBaseInfo item)
    {
        return super.indexOf(item);
    }
}