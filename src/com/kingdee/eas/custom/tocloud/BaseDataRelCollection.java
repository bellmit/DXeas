package com.kingdee.eas.custom.tocloud;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class BaseDataRelCollection extends AbstractObjectCollection 
{
    public BaseDataRelCollection()
    {
        super(BaseDataRelInfo.class);
    }
    public boolean add(BaseDataRelInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(BaseDataRelCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(BaseDataRelInfo item)
    {
        return removeObject(item);
    }
    public BaseDataRelInfo get(int index)
    {
        return(BaseDataRelInfo)getObject(index);
    }
    public BaseDataRelInfo get(Object key)
    {
        return(BaseDataRelInfo)getObject(key);
    }
    public void set(int index, BaseDataRelInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(BaseDataRelInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(BaseDataRelInfo item)
    {
        return super.indexOf(item);
    }
}