package com.kingdee.eas.farm.stocking.basedata;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class SubsidyCollection extends AbstractObjectCollection 
{
    public SubsidyCollection()
    {
        super(SubsidyInfo.class);
    }
    public boolean add(SubsidyInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(SubsidyCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(SubsidyInfo item)
    {
        return removeObject(item);
    }
    public SubsidyInfo get(int index)
    {
        return(SubsidyInfo)getObject(index);
    }
    public SubsidyInfo get(Object key)
    {
        return(SubsidyInfo)getObject(key);
    }
    public void set(int index, SubsidyInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(SubsidyInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(SubsidyInfo item)
    {
        return super.indexOf(item);
    }
}