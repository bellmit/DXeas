package com.kingdee.eas.farm.carnivorous.basedata;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class FreightCalPointCollection extends AbstractObjectCollection 
{
    public FreightCalPointCollection()
    {
        super(FreightCalPointInfo.class);
    }
    public boolean add(FreightCalPointInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(FreightCalPointCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(FreightCalPointInfo item)
    {
        return removeObject(item);
    }
    public FreightCalPointInfo get(int index)
    {
        return(FreightCalPointInfo)getObject(index);
    }
    public FreightCalPointInfo get(Object key)
    {
        return(FreightCalPointInfo)getObject(key);
    }
    public void set(int index, FreightCalPointInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(FreightCalPointInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(FreightCalPointInfo item)
    {
        return super.indexOf(item);
    }
}