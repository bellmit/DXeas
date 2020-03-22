package com.kingdee.eas.custom.taihe.weight;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class CarcassCollection extends AbstractObjectCollection 
{
    public CarcassCollection()
    {
        super(CarcassInfo.class);
    }
    public boolean add(CarcassInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(CarcassCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(CarcassInfo item)
    {
        return removeObject(item);
    }
    public CarcassInfo get(int index)
    {
        return(CarcassInfo)getObject(index);
    }
    public CarcassInfo get(Object key)
    {
        return(CarcassInfo)getObject(key);
    }
    public void set(int index, CarcassInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(CarcassInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(CarcassInfo item)
    {
        return super.indexOf(item);
    }
}