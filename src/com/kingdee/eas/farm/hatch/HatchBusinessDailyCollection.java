package com.kingdee.eas.farm.hatch;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class HatchBusinessDailyCollection extends AbstractObjectCollection 
{
    public HatchBusinessDailyCollection()
    {
        super(HatchBusinessDailyInfo.class);
    }
    public boolean add(HatchBusinessDailyInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(HatchBusinessDailyCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(HatchBusinessDailyInfo item)
    {
        return removeObject(item);
    }
    public HatchBusinessDailyInfo get(int index)
    {
        return(HatchBusinessDailyInfo)getObject(index);
    }
    public HatchBusinessDailyInfo get(Object key)
    {
        return(HatchBusinessDailyInfo)getObject(key);
    }
    public void set(int index, HatchBusinessDailyInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(HatchBusinessDailyInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(HatchBusinessDailyInfo item)
    {
        return super.indexOf(item);
    }
}