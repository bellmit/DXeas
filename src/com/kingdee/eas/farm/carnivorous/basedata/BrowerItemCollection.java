package com.kingdee.eas.farm.carnivorous.basedata;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class BrowerItemCollection extends AbstractObjectCollection 
{
    public BrowerItemCollection()
    {
        super(BrowerItemInfo.class);
    }
    public boolean add(BrowerItemInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(BrowerItemCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(BrowerItemInfo item)
    {
        return removeObject(item);
    }
    public BrowerItemInfo get(int index)
    {
        return(BrowerItemInfo)getObject(index);
    }
    public BrowerItemInfo get(Object key)
    {
        return(BrowerItemInfo)getObject(key);
    }
    public void set(int index, BrowerItemInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(BrowerItemInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(BrowerItemInfo item)
    {
        return super.indexOf(item);
    }
}