package com.kingdee.eas.farm.carnivorous.feedbiz;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class FodderReceptionCollection extends AbstractObjectCollection 
{
    public FodderReceptionCollection()
    {
        super(FodderReceptionInfo.class);
    }
    public boolean add(FodderReceptionInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(FodderReceptionCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(FodderReceptionInfo item)
    {
        return removeObject(item);
    }
    public FodderReceptionInfo get(int index)
    {
        return(FodderReceptionInfo)getObject(index);
    }
    public FodderReceptionInfo get(Object key)
    {
        return(FodderReceptionInfo)getObject(key);
    }
    public void set(int index, FodderReceptionInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(FodderReceptionInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(FodderReceptionInfo item)
    {
        return super.indexOf(item);
    }
}