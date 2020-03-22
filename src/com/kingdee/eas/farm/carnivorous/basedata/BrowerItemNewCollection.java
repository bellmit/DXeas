package com.kingdee.eas.farm.carnivorous.basedata;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class BrowerItemNewCollection extends AbstractObjectCollection 
{
    public BrowerItemNewCollection()
    {
        super(BrowerItemNewInfo.class);
    }
    public boolean add(BrowerItemNewInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(BrowerItemNewCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(BrowerItemNewInfo item)
    {
        return removeObject(item);
    }
    public BrowerItemNewInfo get(int index)
    {
        return(BrowerItemNewInfo)getObject(index);
    }
    public BrowerItemNewInfo get(Object key)
    {
        return(BrowerItemNewInfo)getObject(key);
    }
    public void set(int index, BrowerItemNewInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(BrowerItemNewInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(BrowerItemNewInfo item)
    {
        return super.indexOf(item);
    }
}