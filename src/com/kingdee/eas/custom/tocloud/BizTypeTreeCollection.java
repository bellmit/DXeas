package com.kingdee.eas.custom.tocloud;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class BizTypeTreeCollection extends AbstractObjectCollection 
{
    public BizTypeTreeCollection()
    {
        super(BizTypeTreeInfo.class);
    }
    public boolean add(BizTypeTreeInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(BizTypeTreeCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(BizTypeTreeInfo item)
    {
        return removeObject(item);
    }
    public BizTypeTreeInfo get(int index)
    {
        return(BizTypeTreeInfo)getObject(index);
    }
    public BizTypeTreeInfo get(Object key)
    {
        return(BizTypeTreeInfo)getObject(key);
    }
    public void set(int index, BizTypeTreeInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(BizTypeTreeInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(BizTypeTreeInfo item)
    {
        return super.indexOf(item);
    }
}