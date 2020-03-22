package com.kingdee.eas.farm.carnivorous.basedata;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class BrowerItemTreeCollection extends AbstractObjectCollection 
{
    public BrowerItemTreeCollection()
    {
        super(BrowerItemTreeInfo.class);
    }
    public boolean add(BrowerItemTreeInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(BrowerItemTreeCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(BrowerItemTreeInfo item)
    {
        return removeObject(item);
    }
    public BrowerItemTreeInfo get(int index)
    {
        return(BrowerItemTreeInfo)getObject(index);
    }
    public BrowerItemTreeInfo get(Object key)
    {
        return(BrowerItemTreeInfo)getObject(key);
    }
    public void set(int index, BrowerItemTreeInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(BrowerItemTreeInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(BrowerItemTreeInfo item)
    {
        return super.indexOf(item);
    }
}