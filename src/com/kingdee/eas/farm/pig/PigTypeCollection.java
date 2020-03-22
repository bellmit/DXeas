package com.kingdee.eas.farm.pig;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class PigTypeCollection extends AbstractObjectCollection 
{
    public PigTypeCollection()
    {
        super(PigTypeInfo.class);
    }
    public boolean add(PigTypeInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(PigTypeCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(PigTypeInfo item)
    {
        return removeObject(item);
    }
    public PigTypeInfo get(int index)
    {
        return(PigTypeInfo)getObject(index);
    }
    public PigTypeInfo get(Object key)
    {
        return(PigTypeInfo)getObject(key);
    }
    public void set(int index, PigTypeInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(PigTypeInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(PigTypeInfo item)
    {
        return super.indexOf(item);
    }
}