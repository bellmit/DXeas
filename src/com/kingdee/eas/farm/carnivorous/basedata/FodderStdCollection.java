package com.kingdee.eas.farm.carnivorous.basedata;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class FodderStdCollection extends AbstractObjectCollection 
{
    public FodderStdCollection()
    {
        super(FodderStdInfo.class);
    }
    public boolean add(FodderStdInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(FodderStdCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(FodderStdInfo item)
    {
        return removeObject(item);
    }
    public FodderStdInfo get(int index)
    {
        return(FodderStdInfo)getObject(index);
    }
    public FodderStdInfo get(Object key)
    {
        return(FodderStdInfo)getObject(key);
    }
    public void set(int index, FodderStdInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(FodderStdInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(FodderStdInfo item)
    {
        return super.indexOf(item);
    }
}