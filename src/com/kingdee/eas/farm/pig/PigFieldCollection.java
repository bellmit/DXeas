package com.kingdee.eas.farm.pig;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class PigFieldCollection extends AbstractObjectCollection 
{
    public PigFieldCollection()
    {
        super(PigFieldInfo.class);
    }
    public boolean add(PigFieldInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(PigFieldCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(PigFieldInfo item)
    {
        return removeObject(item);
    }
    public PigFieldInfo get(int index)
    {
        return(PigFieldInfo)getObject(index);
    }
    public PigFieldInfo get(Object key)
    {
        return(PigFieldInfo)getObject(key);
    }
    public void set(int index, PigFieldInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(PigFieldInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(PigFieldInfo item)
    {
        return super.indexOf(item);
    }
}