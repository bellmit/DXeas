package com.kingdee.eas.custom.wages;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class PostAllocationCollection extends AbstractObjectCollection 
{
    public PostAllocationCollection()
    {
        super(PostAllocationInfo.class);
    }
    public boolean add(PostAllocationInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(PostAllocationCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(PostAllocationInfo item)
    {
        return removeObject(item);
    }
    public PostAllocationInfo get(int index)
    {
        return(PostAllocationInfo)getObject(index);
    }
    public PostAllocationInfo get(Object key)
    {
        return(PostAllocationInfo)getObject(key);
    }
    public void set(int index, PostAllocationInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(PostAllocationInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(PostAllocationInfo item)
    {
        return super.indexOf(item);
    }
}