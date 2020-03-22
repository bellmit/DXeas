package com.kingdee.eas.farm.food;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class SlaughterPlanEntryCollection extends AbstractObjectCollection 
{
    public SlaughterPlanEntryCollection()
    {
        super(SlaughterPlanEntryInfo.class);
    }
    public boolean add(SlaughterPlanEntryInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(SlaughterPlanEntryCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(SlaughterPlanEntryInfo item)
    {
        return removeObject(item);
    }
    public SlaughterPlanEntryInfo get(int index)
    {
        return(SlaughterPlanEntryInfo)getObject(index);
    }
    public SlaughterPlanEntryInfo get(Object key)
    {
        return(SlaughterPlanEntryInfo)getObject(key);
    }
    public void set(int index, SlaughterPlanEntryInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(SlaughterPlanEntryInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(SlaughterPlanEntryInfo item)
    {
        return super.indexOf(item);
    }
}