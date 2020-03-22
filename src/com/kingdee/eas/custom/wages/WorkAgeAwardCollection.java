package com.kingdee.eas.custom.wages;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class WorkAgeAwardCollection extends AbstractObjectCollection 
{
    public WorkAgeAwardCollection()
    {
        super(WorkAgeAwardInfo.class);
    }
    public boolean add(WorkAgeAwardInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(WorkAgeAwardCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(WorkAgeAwardInfo item)
    {
        return removeObject(item);
    }
    public WorkAgeAwardInfo get(int index)
    {
        return(WorkAgeAwardInfo)getObject(index);
    }
    public WorkAgeAwardInfo get(Object key)
    {
        return(WorkAgeAwardInfo)getObject(key);
    }
    public void set(int index, WorkAgeAwardInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(WorkAgeAwardInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(WorkAgeAwardInfo item)
    {
        return super.indexOf(item);
    }
}