package com.kingdee.eas.custom.znck;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class MaterialLedRelCollection extends AbstractObjectCollection 
{
    public MaterialLedRelCollection()
    {
        super(MaterialLedRelInfo.class);
    }
    public boolean add(MaterialLedRelInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(MaterialLedRelCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(MaterialLedRelInfo item)
    {
        return removeObject(item);
    }
    public MaterialLedRelInfo get(int index)
    {
        return(MaterialLedRelInfo)getObject(index);
    }
    public MaterialLedRelInfo get(Object key)
    {
        return(MaterialLedRelInfo)getObject(key);
    }
    public void set(int index, MaterialLedRelInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(MaterialLedRelInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(MaterialLedRelInfo item)
    {
        return super.indexOf(item);
    }
}