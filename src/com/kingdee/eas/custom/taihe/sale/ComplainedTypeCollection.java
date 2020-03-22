package com.kingdee.eas.custom.taihe.sale;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class ComplainedTypeCollection extends AbstractObjectCollection 
{
    public ComplainedTypeCollection()
    {
        super(ComplainedTypeInfo.class);
    }
    public boolean add(ComplainedTypeInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(ComplainedTypeCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(ComplainedTypeInfo item)
    {
        return removeObject(item);
    }
    public ComplainedTypeInfo get(int index)
    {
        return(ComplainedTypeInfo)getObject(index);
    }
    public ComplainedTypeInfo get(Object key)
    {
        return(ComplainedTypeInfo)getObject(key);
    }
    public void set(int index, ComplainedTypeInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(ComplainedTypeInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(ComplainedTypeInfo item)
    {
        return super.indexOf(item);
    }
}