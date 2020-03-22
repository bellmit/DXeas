package com.kingdee.eas.custom.wages;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class WorkAgeAwardBonuCollection extends AbstractObjectCollection 
{
    public WorkAgeAwardBonuCollection()
    {
        super(WorkAgeAwardBonuInfo.class);
    }
    public boolean add(WorkAgeAwardBonuInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(WorkAgeAwardBonuCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(WorkAgeAwardBonuInfo item)
    {
        return removeObject(item);
    }
    public WorkAgeAwardBonuInfo get(int index)
    {
        return(WorkAgeAwardBonuInfo)getObject(index);
    }
    public WorkAgeAwardBonuInfo get(Object key)
    {
        return(WorkAgeAwardBonuInfo)getObject(key);
    }
    public void set(int index, WorkAgeAwardBonuInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(WorkAgeAwardBonuInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(WorkAgeAwardBonuInfo item)
    {
        return super.indexOf(item);
    }
}