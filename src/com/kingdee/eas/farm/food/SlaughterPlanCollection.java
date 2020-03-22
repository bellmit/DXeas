package com.kingdee.eas.farm.food;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class SlaughterPlanCollection extends AbstractObjectCollection 
{
    public SlaughterPlanCollection()
    {
        super(SlaughterPlanInfo.class);
    }
    public boolean add(SlaughterPlanInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(SlaughterPlanCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(SlaughterPlanInfo item)
    {
        return removeObject(item);
    }
    public SlaughterPlanInfo get(int index)
    {
        return(SlaughterPlanInfo)getObject(index);
    }
    public SlaughterPlanInfo get(Object key)
    {
        return(SlaughterPlanInfo)getObject(key);
    }
    public void set(int index, SlaughterPlanInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(SlaughterPlanInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(SlaughterPlanInfo item)
    {
        return super.indexOf(item);
    }
}