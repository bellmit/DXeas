package com.kingdee.eas.custom.tocloud;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class BaseDataTypeCollection extends AbstractObjectCollection 
{
    public BaseDataTypeCollection()
    {
        super(BaseDataTypeInfo.class);
    }
    public boolean add(BaseDataTypeInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(BaseDataTypeCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(BaseDataTypeInfo item)
    {
        return removeObject(item);
    }
    public BaseDataTypeInfo get(int index)
    {
        return(BaseDataTypeInfo)getObject(index);
    }
    public BaseDataTypeInfo get(Object key)
    {
        return(BaseDataTypeInfo)getObject(key);
    }
    public void set(int index, BaseDataTypeInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(BaseDataTypeInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(BaseDataTypeInfo item)
    {
        return super.indexOf(item);
    }
}