package com.kingdee.eas.farm.food;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class SlaughterPlanEntrySchedulingCollection extends AbstractObjectCollection 
{
    public SlaughterPlanEntrySchedulingCollection()
    {
        super(SlaughterPlanEntrySchedulingInfo.class);
    }
    public boolean add(SlaughterPlanEntrySchedulingInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(SlaughterPlanEntrySchedulingCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(SlaughterPlanEntrySchedulingInfo item)
    {
        return removeObject(item);
    }
    public SlaughterPlanEntrySchedulingInfo get(int index)
    {
        return(SlaughterPlanEntrySchedulingInfo)getObject(index);
    }
    public SlaughterPlanEntrySchedulingInfo get(Object key)
    {
        return(SlaughterPlanEntrySchedulingInfo)getObject(key);
    }
    public void set(int index, SlaughterPlanEntrySchedulingInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(SlaughterPlanEntrySchedulingInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(SlaughterPlanEntrySchedulingInfo item)
    {
        return super.indexOf(item);
    }
}